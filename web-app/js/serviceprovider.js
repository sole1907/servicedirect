/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery(function($) {

// initialize tooltipster on input elements
    $('#rateSpForm input').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right',
        touchDevices: false
    });
    // initialize tooltipster on select elements
    $('#rateSpForm select').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right',
        touchDevices: false
    });

    // initialize validate plugin on the form
    $("#rateSpForm").validate({
        errorPlacement: function(error, element) {
            $(element).tooltipster('update', $(error).text());
            $(element).tooltipster('show');
        },
        success: function(label, element) {
            $(element).tooltipster('hide');
        }
    });

    var $radios = $('input[name=rating]').on('change', function() {
        var value = $radios.filter(':checked').val();
        //alert(value);
        //$('.finalrating').val(value);
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
            if (data.source.id === "rateSpForm:submit") {
                //alert("sub");
                $('#pratings').html('<span class="stars">' + parseFloat($('#hiddenrating').val()) + '</span>');
                $('span.stars').stars();
            }
            break;
    }
}

// Rebind tooltipster cos States dropdown is regenerated on country change
function rebindSelectTooltipster() {
    $('#spRateForm select').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    })
}

$.fn.stars = function() {
    return $(this).each(function() {
        var rating = ($(this).html());
        var swidth = Math.max(0, (Math.min(5, parseFloat(rating)))) * 16;
        //alert(swidth);
        $(this).html($('<span />').width(swidth));
    });
}