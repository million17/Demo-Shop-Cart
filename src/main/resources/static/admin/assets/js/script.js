$(document).ready(function () {

    var dataProduct = {}

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


    $('.btn-save-product').on('click', function () {

        NProgress.start();

        dataProduct.productName = $('#input-product-name').val();
        dataProduct.categoryId = $('#input-product-category').val();

    });
});