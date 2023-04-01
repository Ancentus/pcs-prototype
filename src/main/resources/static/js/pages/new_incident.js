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
            var str = $('#wizard_with_validation').serialize();
            console.log(str)
            swal({
                title: "New Paramedicine Care Summary",
                text: "Click OK to send",
                type: "info",
                showCancelButton: true,
                closeOnConfirm: false,
                showLoaderOnConfirm: true,
            }, function () {
                $.ajax({
                    url: 'http://localhost:8080/pcs/create',
                    data: str,
                    //dataType: 'json',
                    type: 'post',
                    //contentType: 'application/json',
                    //data: JSON.stringify( { "login_name": $('#username').val(), "password": $('#password').val() } ),
                    //processData: false,
                    success: function( data, textStatus, jQxhr ){
                        // Simulate an HTTP redirect:
                        //window.location.replace("http://localhost:8080/admin");
                        console.log(data);
                        swal({
                            title: "Success",
                            text: data,
                            type: "success"
                        });
                    },
                    error: function( jqXhr, textStatus, errorThrown ){
                        var errorMessage = jqXhr.status + ': ' + jqXhr.responseText;
                        //alert(errorMessage);
                        console.log(errorMessage);
                        swal({
                            title: "Error " + jqXhr.status,
                            text: "Contact System Admin for assistance.",
                            type: "error"
                        });
    
                    }
                });
            });
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
            medication + " " + dosage +
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

    // Get medication info from modal and save in hidden fields
    function addProcedure(e) {
        var procedure = $('#procedure').val();
        if (!procedure) {
            $('#procedure').parents('.form-line').addClass('error');
            //$('#medication').parents('.form-group').append("<span class='validationMessage' style='color:red;'> This field is required.</span>");
            $('#procedure').focus();
            return false;
        }

        const attempts = $('#attempts').val();
        const successful = $('#successful').val();
        const procedure_response = $('#procedure_response').val();
        const procedure_complication = $('#procedure_complication').val();
        const procedure_datetime = $('#procedure_datetime').val();


        const colors = ["pink", "purple", "blue", "cyan", "teal", "green", "orange", "amber"];

        const random = Math.floor(Math.random() * colors.length);

        const color = colors[random];


        $('#procedure_accordion').append('<div id="panel' + i + '" class="panel panel-col-' + color + '">' +
            '<div class="panel-heading" role="tab" id="heading' + i + '">' +
            '<h4 class="panel-title">' +
            '<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse' + i + '" aria-expanded="true" aria-controls="collapse' + i + '">' +
            '<i class="material-icons">local_pharmacy</i>' +
            '#' + attempts + " " + procedure + "(s)" +
            '</a>' +
            '</h4>' +
            '</div>' +
            '<div id="collapse' + i + '" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading' + i + '">' +
            '<div class="panel-body">Response: ' +
            procedure_response + '<br/>Complication: ' + procedure_complication + '<br/>Performed At: ' + procedure_datetime + '<br/><br/>' +
            '<button type="button" onclick="removePanel(' + i + ')" class="btn btn-default waves-effect">' +
            '<i class="material-icons">delete</i>' +
            '</button>' +

            '<input type="hidden" id="procedure_item" name="procedure_name" value="' + procedure + '"/>' +
            '<input type="hidden" name="attempts" value="' + attempts + '"/>' +
            '<input type="hidden" name="successful" value="' + successful + '"/>' +
            '<input type="hidden" name="procedure_response" value="' + procedure_response + '"/>' +
            '<input type="hidden" name="procedure_complication" value="' + procedure_complication + '"/>' +
            '<input type="hidden" name="procedure_datetime" value="' + procedure_datetime + '"/>' +

            '</div>' +
            '</div>' +
            '</div>');
        i++;
        //$('#form_add').trigger("reset");

    }

    $('#addMed').click(addMed);
    $('#addProcedure').click(addProcedure);
})(jQuery);