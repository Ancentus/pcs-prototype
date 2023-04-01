$(function () {

    //New PCS form
    var form = $('#wizard_with_validation').show();
    form.steps({
        headerTag: 'h3',
        bodyTag: 'fieldset',
        transitionEffect: 'slideLeft',
        onInit: function (event, currentIndex) {
            $.AdminBSB.input.activate();

            //Set tab width
            var $tab = $(event.currentTarget).find('ul[role="tablist"] li');
            var tabCount = $tab.length;
            $tab.css('width', (100 / tabCount) + '%');

            //set button waves effect
            setButtonWavesEffect(event);
        },
        onStepChanging: function (event, currentIndex, newIndex) {
            if (currentIndex > newIndex) { return true; }

            if (currentIndex < newIndex) {
                form.find('.body:eq(' + newIndex + ') label.error').remove();
                form.find('.body:eq(' + newIndex + ') .error').removeClass('error');
            }

            form.validate().settings.ignore = ':disabled,:hidden';
            return form.valid();
        },
        onStepChanged: function (event, currentIndex, priorIndex) {
            setButtonWavesEffect(event);
        },
        onFinishing: function (event, currentIndex) {
            form.validate().settings.ignore = ':disabled';
            return form.valid();
        },
        onFinished: function (event, currentIndex) {
            swal("Good job!", "Submitted!", "success");
        }
    });

    form.validate({
        highlight: function (input) {
            $(input).parents('.form-line').addClass('error');
        },
        unhighlight: function (input) {
            $(input).parents('.form-line').removeClass('error');
        },
        errorPlacement: function (error, element) {
            $(element).parents('.form-group').append(error);
        },
        // rules: {
        //     'confirm': {
        //         equalTo: '#password'
        //     }
        // }
    });

    //Datetimepicker plugin
    $('.datetimepicker').bootstrapMaterialDatePicker({
        format: 'DD/MM/YYYY HH:mm',
        clearButton: true,
        weekStart: 1
    });

    $('.datepicker').bootstrapMaterialDatePicker({
        format: 'DD-MM-YYYY',
        clearButton: true,
        weekStart: 1,
        time: false
    });

    $('.timepicker').bootstrapMaterialDatePicker({
        format: 'HH:mm',
        clearButton: true,
        date: false
    });
});

function setButtonWavesEffect(event) {
    $(event.currentTarget).find('[role="menu"] li a').removeClass('waves-effect');
    $(event.currentTarget).find('[role="menu"] li:not(.disabled) a').addClass('waves-effect');
}

function removePanel(n){
    $('#panel' + n).remove();
}

(function ($) {

    var i = 1;
    // Get medication info from modal and save in hidden fields
    function addMed(e) {
        var medication = $('#medication').val();
        if (!medication) {
            $('#medication').parents('.form-line').addClass('error');
            //$('#medication').parents('.form-group').append("<span class='validationMessage' style='color:red;'> This field is required.</span>");
            $('#medication').focus();
            return false;
        }

        const dosage = $('#dosage').val();
        const route = $('#route').val();
        const med_response = $('#med_response').val();
        const med_complication = $('#med_complication').val();
        const med_datetime = $('#med_datetime').val();


        const colors = ["pink", "purple", "blue", "cyan", "teal", "green", "orange", "amber"];

        const random = Math.floor(Math.random() * colors.length);

        const color = colors[random];


        $('#accordion').append('<div id="panel' + i + '" class="panel panel-col-' + color + '">' +
            '<div class="panel-heading" role="tab" id="heading' + i + '">' +
            '<h4 class="panel-title">' +
            '<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse' + i + '" aria-expanded="true" aria-controls="collapse' + i + '">' +
            '<i class="material-icons">local_pharmacy</i>' +
            '#' + i + " " + medication + " " + dosage +
            '</a>' +
            '</h4>' +
            '</div>' +
            '<div id="collapse' + i + '" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading' + i + '">' +
            '<div class="panel-body">Response: ' +
            med_response + '<br/>Complication: ' + med_complication + '<br/>Given At: ' + med_datetime + '<br/><br/>' +
            '<button type="button" onclick="removePanel(' + i + ')" class="btn btn-default waves-effect">' +
            '<i class="material-icons">delete</i>' +
            '</button>' +

            '<input type="hidden" id="med_item" name="med_name" value="' + medication + '"/>' +
            '<input type="hidden" name="dosage" value="' + dosage + '"/>' +
            '<input type="hidden" name="route" value="' + route + '"/>' +
            '<input type="hidden" name="med_response" value="' + med_response + '"/>' +
            '<input type="hidden" name="med_complication" value="' + med_complication + '"/>' +
            '<input type="hidden" name="med_datetime" value="' + med_datetime + '"/>' +

            '</div>' +
            '</div>' +
            '</div>');
        i++;
        //$('#form_add').trigger("reset");

    }

    $('#addMed').click(addMed);
})(jQuery);