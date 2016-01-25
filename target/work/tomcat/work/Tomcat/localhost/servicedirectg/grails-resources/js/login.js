/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery(function($) {

// initialize tooltipster on input elements
    $('#loginForm input').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right',
        touchDevices: false
    });

    // initialize validate plugin on the form
    $("#loginForm").validate({
        errorPlacement: function(error, element) {
            $(element).tooltipster('update', $(error).text());
            $(element).tooltipster('show');
        },
        success: function(label, element) {
            $(element).tooltipster('hide');
        },
        /*rules: {
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 5
            }
        },
        submitHandler: function(form) { // for demo
            alert('valid form');
            return false;
        }*/
    });

});