const Cookie = (function () {

    const salary_key = 'salary',
          working_hours_key = 'working_hours';

    function cookie(key) {
        return $.cookie(key);
    }

    function set_cookie(key, value) {
        $.cookie(key, value, {expires: 365});
    }

    return {
        set_salary: function(salary) {
            set_cookie(salary_key, salary);
        },

        salary: function () {
            return cookie(salary_key);
        },

        set_working_hours: function(working_hours) {
            set_cookie(working_hours_key, working_hours);
        },

        working_hours: function () {
            return cookie(working_hours_key);
        }
    }
}());