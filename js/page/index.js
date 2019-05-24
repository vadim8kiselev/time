const Entry = (function () {

    function initialize() {
        let salary = $("#salary-input").val();
        let working_hours = $(".working-hours").val();

        if (/^[1-9]\d*$/.test(salary)) {
            to_main();

            Cookie.set_salary(salary);
            Cookie.set_working_hours(working_hours);

        } else {
            alert('Please, provide a valid salary');
        }

        return false;
    }

    function to_main() {
        window.location = 'menu.html';
    }
    
    return {
        initialize: function () {
            let salary = Cookie.salary();
            if (typeof salary !== 'undefined') {
                to_main();
            }

            $(document).on('keydown', 'form', function (event) {
                if (event.key === 'Enter') {
                    initialize();
                }
            });

            Validate.salary();
        },

        login: initialize
    }
}());

$(document).ready(function () {
    Entry.initialize();
});