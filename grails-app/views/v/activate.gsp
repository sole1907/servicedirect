<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main"/>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'menuhack.css')}" type="text/css">
        <g:javascript src="responsiveslides.min.js" />
        <script type="text/javascript">
            document.body.className = "html front not-logged-in no-sidebars page-node page-node- page-node-78406 node-type-page newDesign newDesignC";//document.body.className += "html front not-logged-in no-sidebars page-node page-node- page-node-78406 node-type-page newDesign newDesignC";
            //document.body.className += " newDesignC";

            document.getElementsByClassName("ackbar-footer")[0].style.display = "none";
            document.getElementsByClassName("ackbar-header")[0].style.display = "none";
            document.getElementsByClassName("cloudCity")[0].style.display = "block";
            document.getElementsByClassName("cloudCity")[1].style.display = "block";
        </script>
    </head>
    <body>
        <div id="main" class="clearfix with-navigation">
            <div id="content" class="column"><div class="section">
                    <div style="clear:both;"></div>
                    <a id="main-content"></a>
                    <div class="region region-content">
                        <div id="block-system-main" class="block block-system first last odd">


                            <div class="content">
                                <div class="inner-panels margin-center">
                                    <div class="panel-panel panel-full-head">
                                        <div class="panel-pane pane-breadcrumb-block clearfix">


                                        </div>
                                        <div class="panel-separator"></div>

                                        <div class="panel-pane pane-node-content">

                                            <div class="pane-content">
                                                <div id="node-67216" class="node node-page view-mode-full clearfix">
                                                    <form id="j_idt45" name="j_idt45" method="post" action="/servicedirect/faces/howitworks.xhtml" enctype="application/x-www-form-urlencoded">
                                                        <input type="hidden" name="j_idt45" value="j_idt45" />

                                                        <div class="welcome-bar">
                                                            <div class="user-name">
                                                            </div>
                                                            <div class="sign-out">
                                                            </div>
                                                        </div><input type="hidden" name="javax.faces.ViewState" id="j_id1:javax.faces.ViewState:0" value="2400902239787536689:-5623149875975192175" autocomplete="off" />
                                                    </form>
                                                    <div class="content">

                                                        <div class="field field-name-body field-type-text-with-summary field-label-hidden clearfix">
                                                            <div class="field-items">
                                                                <div class="field-item even">
                                                                    <div id="aboutUsContainer">
                                                                        <!-- You can put your contents Here!  -->
                                                                        <g:if test="${flash.message}">
                                                                            <div class="infomsg">
                                                                                <div class="message" role="status">${flash.message}</div>
                                                                            </div>
                                                                        </g:if>
                                                                        <div class="newDesignWrapC cloudCityBegin">
                                                                            <main class="main"></main>
                                                                        </div>
                                                                        <script type="text/javascript">
                                                                            // You can also use "$(window).load(function() {"
                                                                            $(function () {

                                                                            // Slideshow 1
                                                                            $("#slider1").responsiveSlides({
                                                                            //maxwidth: 800,
                                                                            speed: 800
                                                                            });

                                                                            });
                                                                            document.body.className = "html front not-logged-in no-sidebars page-node page-node- page-node-78406 node-type-page newDesign newDesignC";//document.body.className += "html front not-logged-in no-sidebars page-node page-node- page-node-78406 node-type-page newDesign newDesignC";
                                                                            //document.body.className += " newDesignC";

                                                                            document.getElementsByClassName("ackbar-footer")[0].style.display = "none";
                                                                            document.getElementsByClassName("ackbar-header")[0].style.display = "none";
                                                                            document.getElementsByClassName("cloudCity")[0].style.display = "block";
                                                                            document.getElementsByClassName("cloudCity")[1].style.display = "block";
                                                                        </script>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>


                                                    </div><!-- /.node -->
                                                </div>


                                            </div>
                                        </div>
                                        <div class="clear"> </div>


                                    </div>
                                    <div class="clear"> </div>
                                </div>

                            </div><!-- /.block -->
                        </div><!-- /.region -->
                    </div></div><!-- /.section, /#content -->




            </div>
    </body>
</html>
