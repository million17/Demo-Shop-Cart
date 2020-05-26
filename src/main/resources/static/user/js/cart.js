$(document).ready(function () {
    $('.update-cart').on('click', function () {
        console.log("click");
        dataCartProduct = {};

        var cartProductId = $(this).data("id");

        dataCartProduct.cartProductId = cartProductId;
        dataCartProduct.amount = $('.num-product').val();

        NProgress.start();

        let linkPost = "/api/cart-product/update";

        axios.post(linkPost, dataCartProduct).then(function (res) {
            NProgress.done();
            if (res.data.success) {
                swal(
                    'Success ',
                    'Update Success ',
                    'success'
                ).then()
                {
                    location.reload();
                }
            } else {
                swal(
                    'Fails',
                    'Update Fail',
                    'error'
                )
            }

        }, function (err) {
            NProgress.done();
            swal(
                'Fails',
                'Fails',
                'error'
            )
        });
    });

    $('.delete-cart-product').on('click', function () {
        var pdInfo = $(this).data("id");

        let linkGet = "/api/cart-product/delete/" + pdInfo;

        console.log(linkGet);

        NProgress.start();

        axios.get(linkGet).then(function (res) {
            NProgress.done();

            if (res.data.success) {
                swal(
                    'Success',
                    res.data.message,
                    'success'
                ).then(function () {
                    location.reload();
                });
            } else {
                swal(
                    'Fail',
                    'Delete Fails',
                    'error'
                )
            }

        }, function (err) {
            NProgress.done();
            swal(
                'Fail',
                'Delete Fails !',
                'error'
            )
        });
    });
});