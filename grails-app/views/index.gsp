<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'search.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'tooltipster.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery-ui.min.css')}" type="text/css">
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
                                                    <form id="j_idt45" name="j_idt45" method="post" action="/servicedirect/faces/serviceproviders.xhtml" enctype="application/x-www-form-urlencoded">
                                                        <input type="hidden" name="j_idt45" value="j_idt45" />

                                                        <div class="welcome-bar">
                                                            <div class="user-name">
                                                            </div>
                                                            <div class="sign-out">
                                                            </div>
                                                        </div><input type="hidden" name="javax.faces.ViewState" id="j_id1:javax.faces.ViewState:0" value="-8744114477156083367:-6011443310649426669" autocomplete="off" />
                                                    </form>
                                                    <div class="content">

                                                        <div class="field field-name-body field-type-text-with-summary field-label-hidden clearfix">
                                                            <div class="field-items">
                                                                <div class="field-item even">
                                                                    <div id="aboutUsContainer">
                                                                        <!-- You can put your contents Here!  -->
                                                                        <g:if test="${flash.message}">
                                                                            <div class="successmsg">
                                                                                <div role="status">${flash.message}</div>
                                                                            </div>
                                                                        </g:if>
                                                                        <div id="dialog" class="dialog"></div>
                                                                        <div class="newDesignWrapC cloudCityBegin">
                                                                            <main class="main"><section id="heroBanner">
                                                                                    <div class="heroContainer">
                                                                                        <div class="heroInner">
                                                                                            <div><h1> </h1>
                                                                                                <div class="whiteBox"><div class="loading" style="display:none">Hang on while we process your request ...</div>
                                                                                                    <g:if test="${flash.noresult}">
                                                                                                        <div class="warningmsg" id="noresult">${flash.noresult}</div>
                                                                                                    </g:if>
                                                                                                    <h1>Find Your Provider.</h1>
                                                                                                    <form id="viewServiceProviderForm" name="viewServiceProviderForm" method="post" action="/servicedirect/faces/serviceproviders.xhtml" enctype="application/x-www-form-urlencoded">
                                                                                                        <input type="hidden" name="viewServiceProviderForm" value="viewServiceProviderForm" />
                                                                                                        <input id="viewServiceProviderForm:addresses" type="hidden" name="viewServiceProviderForm:addresses" /><input type="hidden" name="javax.faces.ViewState" id="j_id1:javax.faces.ViewState:0" value="-8744114477156083367:-6011443310649426669" autocomplete="off" />
                                                                                                    </form>
                                                                                                    <g:form url="[action:'findServiceProviders',controller:'v']" method="post" id="findProvidersForm">
                                                                                                        <input type="hidden" name="findProvidersForm" value="findProvidersForm" />

                                                                                                        <label>Select Location:</label>
                                                                                                        <g:select id="state" name="state.id" noSelection="${['':'Select State ...']}" from="${com.soconcepts.servicedirect.State.list()}" optionKey="id" required="" optionValue="state" />
                                                                                                        <br /><br />
                                                                                                        <label>Select LGA:</label>
                                                                                                        <g:select id="lga" noSelection="${['':'Select LGA ...']}" name="lga" from="${[]}" optionKey="id" optionValue="lga" required="" value="${secUserInstance?.lga?.id}" />
                                                                                                        <br /><br />
                                                                                                        <label>Select Category:</label>
                                                                                                        <g:select id="category" name="category.id" noSelection="${['':'Select Category ...']}" from="${com.soconcepts.servicedirect.ServiceCategory.list()}" optionKey="id" required="" optionValue="category" />
                                                                                                        <br /><br />
                                                                                                        <!--  choose a service -->
                                                                                                        <label>Select a Service:</label>
                                                                                                        <g:select id="subcategory" noSelection="${['':'Select Service ...']}" name="serviceSubcategory" from="${[]}" optionKey="id" value="${serviceProviderInstance?.serviceSubcategories*.id}"/>
                                                                                                        <input id="submit" type="submit" name="submit" value="Find a Service" class="search btn" />
                                                                                                    </g:form>
                                                                                                    <br />
                                                                                                </div>
                                                                                            </div>

                                                                                        </div>
                                                                                    </div>
                                                                                    <form id="j_idt78" name="j_idt78" method="post" action="/servicedirect/faces/serviceproviders.xhtml" enctype="application/x-www-form-urlencoded">
                                                                                        <input type="hidden" name="j_idt78" value="j_idt78" />
                                                                                        <g:img uri="/images/maps.jpg" /><input type="hidden" name="javax.faces.ViewState" id="j_id1:javax.faces.ViewState:0" value="-8744114477156083367:-6011443310649426669" autocomplete="off" />
                                                                                    </form>

                                                                                </section>
                                                                            </main>
                                                                        </div>
                                                                        <script type="text/javascript">
                                                                            document.body.className = document.body.className += "html front not-logged-in no-sidebars page-node page-node- page-node-78406 node-type-page newDesign newDesignC";
                                                                            //document.body.className += " newDesignC";

                                                                            document.getElementsByClassName("ackbar-footer")[0].style.display = "none";
                                                                            document.getElementsByClassName("ackbar-header")[0].style.display = "none";
                                                                            document.getElementsByClassName("cloudCity")[0].style.display = "block";
                                                                            document.getElementsByClassName("cloudCity")[1].style.display = "block";
                                                                        </script>
                                                                        <script>
                                                                            $(document).ready(function() {
                                                                            $("#state").change(function() {
                                                                            if (this.value != "") {
                                                                            $.ajax({
                                                                            url: "/servicedirectg/state/stateSelected",
                                                                            data: "id=" + this.value,
                                                                            cache: false,
                                                                            success: function(html) {
                                                                            $("#lga").html(html);
                                                                            }
                                                                            });
                                                                            }
                                                                            });

                                                                            $("#category").change(function() {
                                                                            if (this.value != "") {
                                                                            $.ajax({
                                                                            url: "/servicedirectg/serviceCategory/categorySelected",
                                                                            data: "id=" + this.value,
                                                                            cache: false,
                                                                            success: function(html) {
                                                                            $("#subcategory").html(html);
                                                                            }
                                                                            });
                                                                            }
                                                                            });
                                                                            });
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




            </div></div><!-- /#main, /#main-wrapper -->


    </body>
</html>
