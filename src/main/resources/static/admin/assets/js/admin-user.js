$(document).ready(function () {

    var dataUser = {};


    $('.add-user-new').on('click', function () {
        $('#input-user-userName').val();
        $('#input-user-name').val();
        $('#input-user-email').val();
        $('#input-user-address').val();
        $('#input-user-phoneNumber').val();
    });


    $('.edit_user').on('click', function () {
        NProgress.start();

        //Lấy id của user từ th:attr
        var id = $(this).data('id');

        console.log(id);

        let linkPost = '/api/user/detail/' + id;


        //Gọi vào api của detail
        axios.post(linkPost).then(function (res) {
            NProgress.done();
            // Trường hợp trả về là true
            if (res.data.success) {
                dataUser.id = id;
                //Nếu có data thì đẩy dữ liệu vào trong value của ô input
                $('#input-user-userName').val(res.data.data.userName);
                $('#input-user-name').val(res.data.data.name);
                $('#input-user-email').val(res.data.data.email);
                $('#input-user-address').val(res.data.data.address);
                $('#input-user-phoneNumber').val(res.data.data.phoneNumber);
            } else {
                console.log('error');
            }
        }, function (err) {
            console.log(err)
        });

    })

    $('.btn-save-user').on('click', function () {
        NProgress.start();

        dataUser.userName = $('#input-user-userName').val();
        dataUser.name = $('#input-user-name').val();
        dataUser.email = $('#input-user-email').val();
        dataUser.address = $('#input-user-address').val();
        dataUser.phoneNumber = $('#input-user-phoneNumber').val();

        // var linkPost = '/api/user/create';

        if (dataUser.id) {
            var linkPost = '/api/user/update/' + dataUser.id;
        }

        console.log(linkPost);
        axios.post(linkPost, dataUser).then(function (res) {
            NProgress.done();
            console.log(res);
            if (res.data.success) {
                console.log(res.data.success);
                swal(
                    'success',
                    'Update Success ',
                    'success'
                ).then(function () {
                    window.location.href = '/admin/user';
                });
            }
        }, function (err) {
            NProgress.done();
            console.log(err);
        })
    })
})