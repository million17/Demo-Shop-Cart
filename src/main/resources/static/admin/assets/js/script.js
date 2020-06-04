$(document).ready(function () {

    var dataProduct = {};




    $('.add-product-new').on('click', function () {
        var dataProduct = {};
        $('#input-product-name').val();
        $('#input-product-category').val();
        $('#input-product-shortDesc').val();
        $('#input-product-price').val();
        $('#input-product-brand').val();
    });

    $('.edit-product').on('click', function () {

        let id = $(this).data("id");
        NProgress.start();
        linkPost = "/api/product/detail/" + id;

        axios.get(linkPost).then(function (res) {
            NProgress.done();
            if (res.data.success) {
                dataProduct.id = id;
                $('#input-product-name').val(res.data.data.productName);
                $('#input-product-category').val(res.data.data.categoryId);
                $('#input-product-shortDesc').val(res.data.data.shortDesc);
                $('#input-product-price').val(res.data.data.price);
                $('#input-product-brand').val(res.data.data.brand);
                if (res.data.data.mainImage != null) {
                    $('#product-mainImage').attr('src', res.data.data.mainImage);
                }
            } else {
                console.log("error");
            }
        });
    });

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                // $('#preview-product-img').attr('src', e.target.result);
                // $('#product-image-add').attr('src', e.target.result);

            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#change-product-mainImage").change(function () {
        readURL(this);
        var formData = new FormData();
        NProgress.start();
        formData.append('file', $("#change-product-mainImage")[0].files[0]);
        axios.post("/api/upload/upload-image", formData).then(function (res) {
            NProgress.done();
            if (res.data.success) {
                $('#product-mainImage').attr('src', res.data.link);
            }
        }, function (err) {
            NProgress.done();
        });
    });


    $('.btn-save-product').on('click', function () {

        NProgress.start();

        dataProduct.productName = $('#input-product-name').val();
        dataProduct.categoryId = $('#input-product-category').val();
        dataProduct.price = $('#input-product-price').val();
        dataProduct.brand = $('#input-product-brand').val();
        dataProduct.shortDesc = $('#input-product-shortDesc').val();

        dataProduct.mainImage = $('#product-mainImage').attr('src');

        var linkPost = "/api/product/create";

        if (dataProduct.id) {
            var linkPost = "/api/product/update/" + dataProduct.id;
        }

        axios.post(linkPost, dataProduct).then(function (res) {
            NProgress.done();
            if (res.data.success) {
                swal(
                    'Save Success !',
                    'Save',
                    'success'
                ).then(function () {
                    location.reload();
                })
            } else {
                swal(
                    'Fails to save !',
                    'Fail',
                    'error'
                )
            }
        }, function (err) {
            NProgress.done();
            swal(
                'Fails',
                'Fail',
                'error'
            )
        });

    });

    $('.delete-product').on('click', function () {

        let id = $(this).data("id");

        dataProduct.id = id;

        NProgress.start();

        letPost = "/api/product/delete/" + dataProduct.id;

        axios.post(letPost, dataProduct).then(function (res) {
            if (res.data.success) {
                swal(
                    'Delete Success',
                    'Delete Success ',
                    'success'
                ).then(function () {
                    location.reload();
                });
            } else {
                swal(
                    'Delete Fails',
                    'Delete Fails ',
                    'error'
                )
            }
        }, function (err) {
            swal(
                'Delete Fails',
                'Delete Fails ',
                'error'
            )
        });

    });
});