/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery(function($) {

// initialize tooltipster on input elements
    $('#manageSubcategoryForm input').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right',
        touchDevices: false
    });
    // initialize tooltipster on select elements
    $('#manageSubcategoryForm select').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right',
        touchDevices: false
    });

    // initialize validate plugin on the form
    $("#manageSubcategoryForm").validate({
        errorPlacement: function(error, element) {
            $(element).tooltipster('update', $(error).text());
            $(element).tooltipster('show');
        },
        success: function(label, element) {
            $(element).tooltipster('hide');
        }
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
            break;
    }
}