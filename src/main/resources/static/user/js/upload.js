$(document).ready(function () {

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('.user-avatar').attr('src', e.target.result);

            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $('#input-avatar').change(function () {
        readURL(this);
    });

    $('#formDetailUser').submit(function (e) {
        e.preventDefault();
        let formData = new FormData();
        NProgress.start();
        formData.append('file', $('#input-avatar')[0].files[0]);
        axios.post('/api/upload/upload-image', formData)
            .then(function (res) {
                NProgress.done();
                if (res.data.success) {
                    $('#avatar').val(res.data.link);
                }
                $('#formDetailUser')[0].submit();
            }, function (err) {
                NProgress.done();
                $('#formDetailUser')[0].submit();
            });
    });

});