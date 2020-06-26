const Entry = (function () {

    const income_container = $('#income-container'),
        addIncomeForm = $('#addIncomeForm');

    function addNewIncomeForm() {
        let incomeForms = $('.income-row[disabled=disabled]');

        // Hide and disable 'plus' button if limit is exceeded
        if (incomeForms.length === 1) {
            addIncomeForm.attr('disabled', true);
            addIncomeForm.hide();
        }

        let firstIncomeForm = incomeForms.first();

        // Show first disabled income form
        firstIncomeForm.removeAttr("disabled");
        firstIncomeForm.show();
    }

    function deleteExistingIncomeForm(incomeFormId) {
        let incomeForm = $(incomeFormId);

        // Clear fields
        incomeForm.find('input').val('');
        incomeForm.find('select').val('₽');

        // Hide and disable
        incomeForm.attr('disabled', true);
        incomeForm.hide();

        // Move down
        incomeForm.appendTo(income_container);

        // Show 'plus' button
        addIncomeForm.removeAttr("disabled");
        addIncomeForm.show();
    }

    function entry() {
        // Empty block
    }

    return {
        initialize: function () {
            entry();
        },
        addIncomeForm: function () {
            addNewIncomeForm();
        },
        deleteIncomeForm: function (incomeFormId) {
            deleteExistingIncomeForm(incomeFormId);
        }
    }
}());

$(document).ready(function () {
    Entry.initialize();
});