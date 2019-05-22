var Entry = (function () {
    
    var a = 5;

    function update_salary() {
        // Get salary from input
        let salary = $(".salary-input").val();

        if (/^[1-9]\d*$/.test(salary)) {
            to_main();

            $.cookie('salary', salary - 0, {expires: 365});

        } else {
            alert('Please, provide a valid salary');
        }

        return false;
    }

    function validate_salary_input() {
        $('.salary-form').validate({
            errorClass: "salary-error",
            validClass: "salary-correct",

            rules: {
                salary: {
                    required: true,
                    number: true
                }
            },
            highlight: function (element, errorClass, validClass) {
                $(".salary-button").attr("disabled", true);
                $(element).addClass(errorClass).removeClass(validClass);
            },
            unhighlight: function (element, errorClass, validClass) {
                $(".salary-button").removeAttr("disabled");
                $(element).removeClass(errorClass).addClass(validClass);
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

    function to_main() {
        window.location = 'main.html';
    }
    
    return {
        initialize: function () {

            let salary = $.cookie('salary');
            if (typeof salary !== 'undefined') {
                to_main();
            }

            $(document).on('keydown', 'form', function (event) {
                if (event.key === 'Enter') {
                    update_salary();
                }
            });

            validate_salary_input();
        },

        update: update_salary
    }
}());

$(document).ready(function () {
    Entry.initialize()
});