const Entry = (function () {

    function sign_in() {
        let salary = $("#salary-input").val();
        // let working_hours = $(".working-hours").val();

        if (Validate.is_salary(salary)) {
            Navigation.to_menu();

            Cookie.set_salary(salary);
            // Cookie.set_working_hours(working_hours);

        } else {
            // TODO: create an error message
            alert('Please, provide a valid salary');
        }

        return false;
    }
    
    return {
        initialize: function () {
            let salary = Cookie.get_salary();
            if (typeof salary !== 'undefined') {
                Navigation.to_menu();
            }

            $(document).on('keydown', 'form', function (event) {
                if (event.key === 'Enter') {
                    sign_in();
                }
            });
        },

        login: sign_in
    }
}());

$(document).ready(function () {
    Entry.initialize();
});