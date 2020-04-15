const Entry = (function () {

    function entry() {
        // Empty block
    }
    
    return {
        initialize: function () {
            entry();
        }
    }
}());

$(document).ready(function () {
    Entry.initialize();
});