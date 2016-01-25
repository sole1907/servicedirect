$(document).ready(function () {
    $("#tabs li a").click(function () {

        $("#ajax-content").empty().append("<div id='loading'><img src='../images/loading.gif' alt='Loading' /></div>");
        $("#tabs li a").removeClass('current');
        $(this).addClass('current');

        $.ajax({url: this.href, success: function (html) {
                $("#ajax-content").empty().append(html);
                $('span.stars').stars();
            }
        });
        return false;
    });

    $("#ajax-content").empty().append("<div id='loading'><img src='../images/loading.gif' alt='Loading' /></div>");
    $.ajax({url: '/servicedirect/faces/users/myprofile.xhtml', success: function (html) {
            $("#ajax-content").empty().append(html);
        }
    });

    $.fn.stars = function () {
        return $(this).each(function () {
            var rating = ($(this).html());
            var swidth = Math.max(0, (Math.min(5, parseFloat(rating)))) * 16;
            $(this).html($('<span />').width(swidth));
        });
    }
});