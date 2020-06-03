$(document).ready(function () {
    $('.update-cart').on('click', function () {

        dataCartProduct = {};

        var cartProductId = $(this).data("id");

        dataCartProduct.cartProductId = cartProductId;
        dataCartProduct.amount = $(this).parents('tr.table-row').find('.num-product').val();

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

    $('.btn-cancel').on('click', function () {

        dataOrder = {};


        var orderId = $(this).data("id");

        dataOrder.orderId = orderId;

        NProgress.start();

        let linkPost = '/order/cancel/' + orderId;

        axios.post(linkPost, dataOrder).then(function (res) {
            NProgress.done();
            if (res.data.success) {
                swal(
                    'Cancel Order',
                    res.data.message,
                    'success'
                ).then()
                {
                    location.reload();
                }
            } else {
                swal(
                    'Fails',
                    'Cancel Fails',
                    'error'
                )
            }
        }, function (err) {
            NProgress.done();
            swal(
                'Fails',
                'Cancel Fails',
                'error'
            )
        });

    });
});