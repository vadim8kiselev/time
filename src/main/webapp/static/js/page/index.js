const Entry = (function () {

    function entry() {
        // Empty block
    }
    
    return {
        initialize: function () {
            $(document).on('keydown', 'form', function (event) {
                if (event.key === 'Enter') {
                    entry();
                }
            });
        }
    }
}());

$(document).ready(function () {
    Entry.initialize();
});