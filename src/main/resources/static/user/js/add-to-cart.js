$(document).ready(function () {

    function setCookie(cname, cvalue, exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
        var expires = "expires=" + d.toUTCString();
        document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
    }

    var delete_cookie = function (name) {
        document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    };

    function getCookie(name) {
        var nameEQ = name + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') c = c.substring(1, c.length);
            if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
        }
        return null;
    }

    function checkCookie() {
        var user = getCookie("username");
        if (user != "") {
            alert("Welcome again " + user);
        } else {
            user = prompt("Please enter your name:", "");
            if (user != "" && user != null) {
                setCookie("username", user, 365);
            }
        }
    }

    var state = {
        amount: "",
        productEntityId: ""
    }

    $('#selectColor').change(function () {
        console.log("Color");
        if ($('#selectColor :selected').val() == "0") {
            return;
        }

        getAmount();
    });

    $('#selectSize').change(function () {
        console.log("Size");
        if ($('#selectSize :selected').val() == "0") {
            return;
        }
        getAmount();
    });

    function getAmount() {
        console.log(" get vm: ", vm.productEntityVMList);

        let size = $('#selectSize :selected').val();
        let color = $('#selectColor :selected').val();

        let amount = 0;

        let listEntity = vm.productEntityVMList;
        for (let i = 0; i < listEntity.length; i++) {
            console.log("Item :", listEntity[i]);

            if (listEntity[i].sizeId == size && listEntity[i].colorId == color) {
                //Con lai so luong
                amount = listEntity[i].amount;
                state.productEntityId = listEntity[i].productEntityId;
                break;
            }
        }
        state.amount = amount;
        $('#warehouse').text("Remaining : " + amount + " Products)");
        console.log('Còn lại ' + amount);

    };

    $('.add-to-cart').on('click', function () {
        if ($('#selectSize :selected').val() == "0") {
            swal('Fail',
                'No selected Size',
                'error')
        }
        if ($('#selectColor :selected').val() == "0") {
            swal('Fail',
                'No selected Color',
                'error')
        }

        let dataCart = {};

        let pdInfo = $(this).data("product");

        dataCart.amount = $('.num-product').val();
        if (dataCart.amount > state.amount) {
            swal('Fail',
                'Not enough quantity',
                'error')
            return;
        }
        dataCart.productEntityId = state.productEntityId;
        dataCart.guid = getCookie("guid");

        NProgress.start();
        console.log("Data : ", dataCart);
        let linkPost = "/api/cart-product/add";

        axios.post(linkPost, dataCart).then(function (res) {
            NProgress.done();
            if (res.data.success) {
                swal('Success',
                    'Add to cart success !',
                    'success').then(function () {
                    location.reload();
                });
            } else {
                swal('Fail',
                    'Add to cart fail',
                    'error');
            }
        }, function (err) {
            NProgress.done();
            swal('Fail',
                'Add to cart fail',
                'error');
        });


    });

});