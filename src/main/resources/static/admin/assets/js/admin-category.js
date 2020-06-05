$(document).ready(function () {
    var dataCategory = {};

    $('.edit-category').on('click', function () {

        NProgress.start();

        var categoryId = $(this).data("id");

        linkPost = '/api/category/detail/' + categoryId;

        axios.post(linkPost).then(function (res) {

            NProgress.done();
            if (res.data.success) {
                dataCategory.id = categoryId;
                $('#input-category-name').val(res.data.data.name);
                $('#input-category-shortDesc').val(res.data.data.shortDesc);
            } else {
                console.log('error');
            }

        });


    });

    $('.btn-save-category').on('click', function () {

        NProgress.start();

        dataCategory.name = $('#input-category-name').val();
        dataCategory.shortDesc = $('#input-category-shortDesc').val();

        var linkPost = '/api/category/create';

        if (dataCategory.id) {
            var linkPost = '/api/category/update/' + dataCategory.id;
        }

        axios.post(linkPost, dataCategory).then(function (res) {
            if (res.data.success) {
                swal(
                    'Success',
                    'Success',
                    'success'
                ).then(function () {
                    window.location.href = '/admin/category';
                });
            }
        });

    });

    $('.delete-category').on('click', function () {
        NProgress.start();

        var id = $(this).data("id");

        var linkPost = '/api/category/delete/' + id;

        axios.post(linkPost, id).then(function (res) {
            NProgress.done();
            if (res.data.success) {
                swal(
                    'Delete Success ! ',
                    'Success !',
                    'success'
                ).then(function () {
                    window.location.href = '/admin/category';
                });
            }

        })
    });


});