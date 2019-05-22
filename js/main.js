$(document).ready(function () {

    // Open menu
    $('.toggler').click(function () {
        $('.menu').toggleClass('menu-open');
        $(this).toggleClass('toggler-active');
    });

    // If 'Change salary' was requested, open the dialog
    $('#change-salary').click(function () {
        $.removeCookie('salary');
        to_entry();
    });
});

function to_entry() {
    window.location = 'index.html';
}

