/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery(function ($) {

// initialize tooltipster on input elements
    $('#registeruserForm input').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right',
        touchDevices: false
    });
    // initialize tooltipster on select elements
    $('#registeruserForm select').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right',
        touchDevices: false
    });

    // initialize validate plugin on the form
    $("#registeruserForm").validate({
        errorPlacement: function (error, element) {
            $(element).tooltipster('update', $(error).text());
            $(element).tooltipster('show');
        },
        success: function (label, element) {
            $(element).tooltipster('hide');
        },
        rules: {
            password_again: {
                equalTo: "#password"
            },
            username: {
                //remote: "/servicedirect/webresources/users/exists/" + $("#registeruserForm\\:email").val()
                emailExists: true
            }
        },
        messages: {
            password_again: {
                equalTo: "Please enter the same password again"
            }
        }/*,
         submitHandler: function(form) { // for demo
         //alert('valid form');
         jsf.ajax.request(this);
         return false;
         }*/
    });

    $('#uploadLogoForm input').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });

    // initialize validate plugin on the form
    $("#uploadLogoForm").validate({
        errorPlacement: function (error, element) {
            $(element).tooltipster('update', $(error).text());
            $(element).tooltipster('show');
        },
        success: function (label, element) {
            $(element).tooltipster('hide');
        }
    });

    $.validator.addMethod("emailExists", function (email, element) {
        var emailExists = true;
        $.ajax(
                {
                    type: "GET",
                    url: "/servicedirectg/secUser/exists/" + email,
                    async: false,
                    success: function (data)
                    {
                        if (data === "true") {
                            emailExists = false;
                        }
                    },
                });
        return emailExists;
    }, 'This email address is already registered.');

    $('#registeruserForm\\:servicetype').change(function () {
        if ($(this).val() === "") {
            $('#companyinfo').css("display", "none");
            $('#otherinfo').css("display", "none");
        } else if ($(this).val() === "user") {
            $('#companyinfo').css("display", "none");
            $('#otherinfo').css("display", "block");
        } else if ($(this).val() === "sp") {
            $('#companyinfo').css("display", "block");
            $('#otherinfo').css("display", "block");
        }
    });

    /*$('#registerForm').submit(function(e) {
     e.preventDefault();
     if ($("#registerForm").valid()) {
     jsf.ajax.request(this, null, {execute: 'inputname', render: 'outputname'});
     return false;
     // Setup the statusUpdate function to hear all events on the page
     //jsf.ajax.addOnEvent(handleAjax);
     }
     });*/

});
function handleAjax(data) {
    //alert("here");
    var status = data.status;
    if (data.type === "error") {
        alert("Error :: " + data.name);
    }

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
            //alert("reloading");
            /*if (data.source.id === "registerForm:submit") {
             location.reload();
             break;
             }*/
    }
}

// Rebind tooltipster cos States dropdown is regenerated on country change
function rebindSelectTooltipster() {
    $('#registerForm select').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    })

    /*$('#uploadLogoForm').tooltipster({
     trigger: 'custom',
     onlyOne: false,
     position: 'right'
     })*/
}