const Validate = (function () {

    function validate_salary() {
        $('#salary-form').validate({
            errorClass: "salary-error",
            validClass: "salary-correct",

            rules: {
                salary: {
                    required: true,
                    number: true
                }
            },
            highlight: function (element, errorClass, validClass) {
                if (element.id === 'salary-input') {
                    $(".salary-button").attr("disabled", true);
                    $('#salary-input').addClass(errorClass).removeClass(validClass);
                }
            },
            unhighlight: function (element, errorClass, validClass) {
                if (element.id === 'salary-input') {
                    $(".salary-button").removeAttr("disabled");
                    $('#salary-input').removeClass(errorClass).addClass(validClass);
                }
            },
            errorPlacement: function (error, element) {
                return true;
            },
            submitHandler: function (form) {
                // do other things for a valid form
                form.submit();
            }
        })
    }

    return {
        salary: validate_salary
    }

}());