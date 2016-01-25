/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery(function ($) {

// initialize tooltipster on input elements
    $('#findProvidersForm input').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right',
        touchDevices: false
    });
    // initialize tooltipster on select elements
    $('#findProvidersForm select').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right',
        touchDevices: false
    });

    // initialize validate plugin on the form
    $("#findProvidersForm").validate({
        errorPlacement: function (error, element) {
            $(element).tooltipster('update', $(error).text());
            $(element).tooltipster('show');
        },
        success: function (label, element) {
            $(element).tooltipster('hide');
        }
    });

    // initialize validate plugin on the form
    $("#uploadspForm").validate({
        errorPlacement: function (error, element) {
            $(element).tooltipster('update', $(error).text());
            $(element).tooltipster('show');
        },
        success: function (label, element) {
            $(element).tooltipster('hide');
        }
    });

    var $radios = $('input[name=rating]').change(function () {
        var value = $radios.filter(':checked').val();
        alert(value);
        $('.finalrating').val(value);
    });

});
function handleAjax(data) {
    var status = data.status;
    //alert(data.source.id);

    switch (status) {
        case "begin":
            // This is the start of the AJAX request.
            $(".loading").css("display", "block");
            //document.getElementsByTagName('body')[0].className = 'loading';
            break;
        case "complete":
            // This is invoked right after ajax response is returned.
            $(".loading").css("display", "none");
            break;
        case "success":
            // This is invoked right after successful processing of ajax response and update of HTML DOM.
            //document.getElementsByTagName('body')[0].className = '';
            if (data.source.id === "findProvidersForm:submit") {
                $('#pratings').html('<span class="stars">' + parseFloat($('#hiddenrating').val()) + '</span>');
                $('span.stars').stars();
                //alert($('#viewServiceProviderForm\\:addresses').val());
                if ($('#viewServiceProviderForm\\:addresses').val() == "") {
                    $('#noresult').css("display", "block");
                } else {
                    window.location = "/servicedirect/faces/maplocations.xhtml";
                }
            }

            /*if (data.source.id === "manageSubcategoryForm:submit") {
             //alert("here");
             alert($("#manageSubcategoryForm\\:categoryname").val());
             $("#manageSubcategoryForm\\:categoryname").value = "";
             }*/
            //window.open("/servicedirect/faces/userview/serviceprovider/128");

            break;
    }
}

// Rebind tooltipster cos States dropdown is regenerated on country change
function rebindSelectTooltipster() {
    $('#findProvidersForm select').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    })
}

function rateSpDialog(opendialog, spid) {
    if (opendialog) {
        $('.dialog').load('/servicedirect/faces/users/rateserviceprovider/' + spid, function () {
            $(this).dialog({
                modal: true,
                width: 400,
                height: 400
            });
        });
    } else {
        window.location.href = "/servicedirect/faces/users/rateserviceprovider.xhtml";
    }
}