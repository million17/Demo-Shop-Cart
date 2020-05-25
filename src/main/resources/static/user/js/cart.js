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
});