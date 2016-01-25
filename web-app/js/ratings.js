$(function() {
//    $('input[type=submit]').click(function() {
//        $('p').html('<span class="stars">' + parseFloat($('input[name=amount]').val()) + '</span>');
    $('span.stars').stars();
//    });
//    $('input[type=submit]').click();
});

$.fn.stars = function() {
    return $(this).each(function() {
        var rating = ($(this).html());
        var swidth = Math.max(0, (Math.min(5, parseFloat(rating)))) * 16;
        $(this).html($('<span />').width(swidth));
    });
}