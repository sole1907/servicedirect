$(document).ready(function() {
    $("#tabs li a").click(function() {

        $("#ajax-content").empty().append("<div id='loading'><img src='../images/loading.gif' alt='Loading' /></div>");
        $("#tabs li a").removeClass('current');
        $(this).addClass('current');

        $.ajax({url: this.href, success: function(html) {
                $("#ajax-content").empty().append(html);
            }
        });
        return false;
    });

    $("#ajax-content").empty().append("<div id='loading'><img src='../images/loading.gif' alt='Loading' /></div>");
    $.ajax({url: '/servicedirect/faces/agent/uploadserviceproviders.xhtml', success: function(html) {
            $("#ajax-content").empty().append(html);
        }
    });
});