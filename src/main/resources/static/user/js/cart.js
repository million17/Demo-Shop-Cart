$(document).ready(function () {
    $('.change-product-amount').click(function () {
        dataCartProduct = {};
        let cPInfo = $(this).data("id");
        console.log(cPInfo);
        dataCartProduct.cartProductId = cPInfo;
        dataCartProduct.amount = $(this).val();

        console.log(dataCartProduct);

        NProgress.start();

        let linkPost = "/api/cart-product/update";

        axios.post(linkPost, dataCartProduct).then(function (res) {
            NProgress.done();
            if (res.data.success) {
                location.reload();
            } else {
                swal(
                    'Fail',
                    res.data.message,
                    'error'
                ).then(function () {
                    location.reload();
                });
            }
        }, function (err) {
            NProgress.done();
            swal(
                'Error',
                'Fail',
                'error'
            );
        });
    });
});