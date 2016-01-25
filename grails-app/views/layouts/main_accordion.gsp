<%@ page import="com.soconcepts.servicedirect.utils.SessionCounterListener" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Service Direct - Listing that service directly next to you.</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
        <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-theme.min.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'home.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'menuhack.css')}" type="text/css">
        <style type="text/css">
            #al_topnav a {
            box-sizing: content-box !important;
            }

            #al_topnav a li {
            box-sizing: content-box !important;
            }

            #al_topnav a:hover{
            -webkit-box-shadow:inset 0 2px 1px 1px rgba(0,0,0,0.25) !important;
            -moz-box-shadow:inset 0 2px 1px 1px rgba(0,0,0,0.25)  !important;
            box-shadow:inset 0 2px 1px 1px rgba(0,0,0,0.25)  !important;
            background-color:#000;position:relative  !important;
            top:1px  !important;
            height:1.1em  !important;
            text-decoration:none !important;
            box-sizing: content-box !important;
            }

            .footer.cloudCity .container {
            margin: 0 auto;
            max-width: 1000px;
            box-sizing: content-box !important;
            }

            .footer.cloudCity {
            color: #fff;
            font-size: 0.9em;
            text-rendering: optimizelegibility;
            box-sizing: content-box !important;
            }

            .region .region-footer {
            clear: both;
            height: auto;
            margin: 0;
            width: 100%;
            box-sizing: content-box !important;
            }
        </style>
        <g:javascript src="jquery-1.11.1.min.js" />	
        <g:layoutHead/>
    <r:layoutResources />
</head>
<body class="html not-front not-logged-in no-sidebars page-node page-node- page-node-67216 node-type-page section-aboutushtm">
    <div id="outer_wrapper"><div id="inner_wrapper">

                <!-- START OLD Header -->
            <div class="header-wrapper ackbar-header">
                <header  id="al_header" role="banner">
                    <div>        	
                        <div id="al_show_menu">
                            <a href="#top" class="btn btn-silver">
                                <g:img uri="/images/nav-icon.png" alt="nav-icon" width="30" height="24" /></a>
                        </div><!--
                        --><div id="al_logo"><!--
                            --><a href="${createLink(uri: '/')}"><g:img class="default" uri="/images/servicedirect-logo.png" alt="Logo" /></a>
                        </div>

                        <div id="al_tel_header"><a href="#" class="number-text"><g:img uri="/images/ico_phone_26x26.png" alt="ico_phone_26x26" width="26" height="26" />08067121610</a>
                            <a href="tel:08067121610" class="btn  btn-silver"><g:img uri="/images/ico_phone_26x26.png" alt="ico_phone_26x26" width="26" height="26" />

                                <span class="number-text">08067121610</span></a></div>

                            <!--   	-->
                        <h:form>
                            <div id="al_utilities">
                                <h:panelGroup><h4 style="display: inline"> Currently Online: ${SessionCounterListener.getTotalActiveSession()}</h4></h:panelGroup>
                                <sec:ifLoggedIn>
                                    <h4 style="display: inline"> | Welcome <sec:loggedInUserInfo field="fullName" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h4> 
                                    <g:link controller="logout" class="btn-silver btn-rounded-3px btnSignin">Sign Out</g:link>
                                    </sec:ifLoggedIn>
                                </div>
                            </h:form>
                        </div>
                    </header>

                    <!--  -->

                <nav id="al_topnav" role="navigation">
                    <div id="nav-corner-left"></div>
                    <div class="nav-class-block">
                        <ul class="al-navlist">
                            <li id="close_nav"><a class="close-btn" id="nav-close-btn" href="#top">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Close Menu</a></li>
                            <li id="hiw"><a href="${createLink(controller: 'v', action: 'howitworks')}">How It Works</a></li>
                            <li id="nav_join_now"><a href="${createLink(controller: 'serviceProvider', action: 'create')}">Register as a Service Provider</a></li>
                            <li id="nav_join_now"><a href="${createLink(controller: 'secUser', action: 'create')}">Register as a User</a></li>
                            <li id="nav_sign_in"><a href="${createLink(uri: '/')}">Find a Service Provider</a></li>
                            <li id="nav_sign_in"><a href="${createLink(controller: 'v', action: 'deals')}">Deals</a></li>
                            <li id="nav_join_now"><!--<a href="/servicedirect/faces/register.xhtml">Register as a Service Provider</a></li>-->
                            <sec:ifNotLoggedIn>
                                <h:panelGroup rendered="#{empty sessionScope['firstname']}"><a href="${createLink(controller: 'login', action: 'auth')}">Sign In</a></h:panelGroup>
                            </sec:ifNotLoggedIn>
                            <sec:ifLoggedIn>
                                <sec:ifAllGranted roles="ROLE_ADMIN">
                                    <a href="${createLink(controller: 'secUser', action: 'edit', id: sec.loggedInUserInfo(field:"id"))}">Administration</a>
                                </sec:ifAllGranted>
                                <sec:ifAllGranted roles="ROLE_USER">
                                    <a href="${createLink(controller: 'secUser', action: 'editProfile')}">My Account</a>
                                </sec:ifAllGranted>
                                <sec:ifAllGranted roles="ROLE_SERVICE_PROVIDER">
                                    <a href="${createLink(controller: 'serviceProvider', action: 'editProfile')}">My Account</a>
                                </sec:ifAllGranted>
                            </sec:ifLoggedIn>
                            </li>
                            <!--<li id="nav_sign_in"><a href="/servicedirect/faces/login.xhtml">Sign In</a></li>-->
                            <!--<li id="faq"><a href="#">FAQ</a></li>
                            <li id="press"><a href="#">In the Press</a></li>
                            <li id="articles"><a href="#">Articles</a></li>
                            <li id="tbd"><a href="#">The Big Deal</a></li>
                            <li id="contact"><a href="/servicedirect/faces/contactus.xhtml">Contact Us</a></li>-->
                            <li id="nav_tel"><a href="#"><span>08067121610</span></a></li>
                            <li id="nav_business_owner" class="mobi-nav"><a href="#">Service Providers</a></li>
                        </ul>
                    </div>
                    <div id="nav-corner-right"></div>
                </nav>
            </div>
            <!-- END OLD Header -->

                <!-- START cloudCity Header -->
            <div class="header-wrapper cloudCity" style="display:none;">
                <header  id="al_header" role="banner">
                    <div>
                        <div id="al_show_menu">
                            <a href="#top" class="btn btn-silver"><g:img uri="/images/nav-icon.png" alt="nav-icon" width="30" height="24" /></a>
                        </div><!--
                        --><div id="al_logo"><!--
                            --><a href="#"><<g:img class="default" uri="/images/servicedirect-logo.png" alt="servicedirect" /></a>
                        </div><!--
                        --><div id="al_tel_header">
                            <a href="#" class="btn btn-silver"><<g:img uri="/images/ico_phone_26x26.png" alt="ico_phone_26x26" width="26" height="26" /><span class="number-text">08067121610</span></a>
                        </div>
                    </div>
                </header>
                <!--
                -->
                <nav id="al_topnav" role="navigation">
                    <div class="nav-class-block">
                        <ul class="al-navlist">
                            <li id="close_nav"><a class="close-btn" id="nav-close-btn" href="#top">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Close Menu</a></li>
                            <!--<li id="qt" class="notOnHome"><a href="/servicedirect/faces/quicktour.xhtml">Quick Tour</a></li>-->
                            <li id="hiw" class="mobi-nav"><a href="${createLink(controller: 'v', action: 'howitworks')}">How It Works</a></li>
                            <!--<li id="nav_join_now" class="mobi-nav"><a href="/servicedirect/faces/register.xhtml">Register as a Service Provider</a></li>
                            <li id="nav_sign_in" class="mobi-nav"><a href="/servicedirect/faces/login.xhtml">Sign In</a></li>-->
                            <li id="nav_sign_in"><a href="/servicedirect/faces/serviceproviders.xhtml" class="btn-silver btn-rounded-3px btnOwners">Find a Service Provider</a></li>
                            <li id="nav_join_now"><!--<a href="/servicedirect/faces/register.xhtml">Register as a Service Provider</a></li>-->
                            <h:panelGroup rendered="#{empty sessionScope['firstname']}"><a href="/servicedirect/faces/login.xhtml" class="btn-silver btn-rounded-3px btnSignin">Sign In</a></h:panelGroup>
                            </li>
                            <li id="contact"><a href="${createLink(controller: 'v', action: 'contactUs')}">Contact Us</a></li>
                            <!--<li id="faq"><a href="#">FAQ</a></li>
                            <li id="press" class="notOnHome"><a href="#">In the Press</a></li>
                            <li id="articles" class="notOnHome"><a href="#">Articles</a></li>
                            <li id="tbd" class="notOnHome"><a href="#">The Big Deal</a></li>-->

                            <li id="nav_business_owner"><a href="#">Service Providers</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
            <!-- END cloudCity Header -->

            <div id="main-wrapper">
                <div id="main" class="clearfix with-navigation" style="width:100%">
                    <div id="content" class="column"><div class="section">
                            <div style="clear:both;"></div>
                            <a id="main-content"></a>
                            <div class="region region-content">
                                <div id="block-system-main" class="block block-system first last odd">


                                    <div class="content">
                                        <div class="inner-panels margin-center">
                                            <div class="panel-panel panel-full-head" >
                                                <div class="panel-pane pane-breadcrumb-block clearfix" >


                                                </div>
                                                <div class="panel-separator"></div>

                                                <div class="panel-pane pane-node-content" >

                                                    <div class="pane-content">
                                                        <div id="node-67216" class="node node-page view-mode-full clearfix">
                                                            <h:form>
                                                                <div class="welcome-bar">
                                                                    <sec:ifLoggedIn>
                                                                        <div class="user-name"><h4 style="display: inline">Welcome <sec:loggedInUserInfo field="fullName" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                                                                        </div>
                                                                        <div class="sign-out"><g:link controller="logout" class="btn-silver btn-rounded-3px btnSignin">Sign Out</g:link>
                                                                            </div>
                                                                    </div>
                                                                    </sec:ifLoggedIn>
                                                                </h:form>
                                                                <div class="content">

                                                                <div class="field field-name-body field-type-text-with-summary field-label-hidden clearfix">
                                                                    <div class="field-items">
                                                                        <div class="field-item even">
                                                                            <div id="aboutUsContainer">
                                                                                <!-- You can put your contents Here!  -->
                                                                                <div class="container" style="margin-top:20px;">
                                                                                    <div class="row">
                                                                                        <div class="col-sm-3 col-md-3">
                                                                                            <div class="panel-group" id="accordion">
                                                                                                <div class="panel panel-default">
                                                                                                    <div class="panel-heading">
                                                                                                        <h4 class="panel-title">
                                                                                                            <sec:ifAllGranted roles="ROLE_ADMIN">
                                                                                                                <a data-toggle="collapse" data-parent="#accordion" href="${createLink(controller: 'secUser', action: 'edit', id: sec.loggedInUserInfo(field:"id"))}"><span class="glyphicon glyphicon-user">
                                                                                                                    </span>My Profile</a>
                                                                                                            </sec:ifAllGranted>
                                                                                                            <sec:ifAllGranted roles="ROLE_USER">
                                                                                                                <a data-toggle="collapse" data-parent="#accordion" href="${createLink(controller: 'secUser', action: 'editProfile')}"><span class="glyphicon glyphicon-user">
                                                                                                                    </span>My Profile</a>
                                                                                                            </sec:ifAllGranted>
                                                                                                            <sec:ifAllGranted roles="ROLE_SERVICE_PROVIDER">
                                                                                                                <a data-toggle="collapse" data-parent="#accordion" href="${createLink(controller: 'serviceProvider', action: 'editProfile')}"><span class="glyphicon glyphicon-user">
                                                                                                                    </span>My Profile</a>
                                                                                                            </sec:ifAllGranted>
                                                                                                        </h4>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="panel panel-default">
                                                                                                    <div class="panel-heading">
                                                                                                        <h4 class="panel-title">
                                                                                                            <a data-toggle="collapse" data-parent="#accordion" href="${createLink(controller: 'secUser', action: 'changeProfilePassword')}"><span class="glyphicon glyphicon-lock">
                                                                                                                </span>Change Password</a>
                                                                                                        </h4>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <sec:ifAllGranted roles="ROLE_USER">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading">
                                                                                                            <h4 class="panel-title">
                                                                                                                <a href="${createLink(controller: 'profileViews', action: 'recentviews')}"><span class="glyphicon glyphicon-eye-open">
                                                                                                                    </span>Recently Viewed</a>
                                                                                                            </h4>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </sec:ifAllGranted>
                                                                                                <sec:ifAllGranted roles="ROLE_SERVICE_PROVIDER">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading">
                                                                                                            <h4 class="panel-title">
                                                                                                                <a href="${createLink(controller: 'profileViews', action: 'profileviews')}"><span class="glyphicon glyphicon-eye-open">
                                                                                                                    </span>Profile Views</a>
                                                                                                            </h4>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </sec:ifAllGranted>  
                                                                                                <sec:ifAllGranted roles="ROLE_ADMIN">
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading">
                                                                                                            <h4 class="panel-title">
                                                                                                                <a data-toggle="collapse" data-parent="#accordion" href="${createLink(controller: 'serviceProvider', action: 'upload')}"><span class="glyphicon glyphicon-upload">
                                                                                                                    </span>Upload Service Providers</a>
                                                                                                            </h4>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading">
                                                                                                            <h4 class="panel-title">
                                                                                                                <a data-toggle="collapse" data-parent="#accordion" href="${createLink(controller: 'serviceProvider')}"><span class="glyphicon glyphicon-user">
                                                                                                                    </span>Service Providers</a>
                                                                                                            </h4>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading">
                                                                                                            <h4 class="panel-title">
                                                                                                                <a data-toggle="collapse" data-parent="#accordion" href="${createLink(controller: 'secUser')}"><span class="glyphicon glyphicon-user">
                                                                                                                    </span>Users</a>
                                                                                                            </h4>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading">
                                                                                                            <h4 class="panel-title">
                                                                                                                <a data-toggle="collapse" data-parent="#accordion" href="${createLink(controller: 'serviceSubcategory')}"><span class="glyphicon glyphicon-menu-down">
                                                                                                                    </span>Sub Categories</a>
                                                                                                            </h4>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading">
                                                                                                            <h4 class="panel-title">
                                                                                                                <a data-toggle="collapse" data-parent="#accordion" href="${createLink(controller: 'state')}"><span class="glyphicon glyphicon-map-marker">
                                                                                                                    </span>States</a>
                                                                                                            </h4>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading">
                                                                                                            <h4 class="panel-title">
                                                                                                                <a data-toggle="collapse" data-parent="#accordion" href="${createLink(controller: 'lga')}"><span class="glyphicon glyphicon-map-marker">
                                                                                                                    </span>LGAs</a>
                                                                                                            </h4>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="panel panel-default">
                                                                                                        <div class="panel-heading">
                                                                                                            <h4 class="panel-title">
                                                                                                                <a data-toggle="collapse" data-parent="#accordion" href="${createLink(controller: 'visitorsCount')}"><span class="glyphicon glyphicon-map-marker">
                                                                                                                    </span>Site Visits</a>
                                                                                                            </h4>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </sec:ifAllGranted>  
                                                                                            </div>
                                                                                        </div>
                                                                                        <div>
                                                                                            <div class="col-sm-9 col-md-9">
                                                                                                <div class="well">
                                                                                                    <g:layoutBody/>
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>


                                                                </div><!-- /.node -->
                                                            </div>


                                                        </div>
                                                    </div>
                                                    <div class="clear">&nbsp;</div>


                                                </div>
                                                <div class="clear">&nbsp;</div>
                                            </div>

                                        </div><!-- /.block -->
                                    </div><!-- /.region -->
                                </div></div><!-- /.section, /#content -->




                        </div></div><!-- /#main, /#main-wrapper -->


                    <div class="region region-footer" style="width:100%">
                        <div class="section">
                            <div id="block-system-powered-by" class="block block-system first last odd">


                                <div class="content">
                                </div>

                            </div><!-- /.block -->
                        </div>
                        <div id="footer" class="ackbar-footer">         
                            <ul>
                                <li><a href="${createLink(uri: '/')}">Home</a></li>
                                <!--<li><a href="/servicedirect/faces/quicktour.xhtml">Quick Tour</a></li>-->
                                <li><a href="${createLink(controller: 'v', action: 'howitworks')}">How It Works</a></li>
                                <!--<li><a href="#">FAQ</a></li>-->
                                <li><a href="${createLink(controller: 'v', action: 'contactUs')}">Contact Us</a></li>
                                <!--<li><a href="#">Investor Relations</a></li>-->
                            </ul>
                            <!--<ul>
                                <li><a href="/servicedirect/faces/aboutus.xhtml">About Us</a></li>
                                <li><a class="external" href="#">Careers</a></li>
                                <li><a class="external" href="#">The Big Deal</a></li>
                                <li><a class="external" href="#">Classic Cars</a></li>
                                <li><a class="external" href="#">Affiliate Program</a></li>
                                <li><a href="#">SnapFix</a></li>
                            </ul>
                            <ul>
                                <li><a href="#" class="external">Gift Memberships</a></li>
                                <li><a href="#">News</a></li>
                                <li><a class="external" href="#">Service Direct's Blog</a></li>
                                <li><a class="external" href="#">Videos</a></li>
                                <li><a class="external" href="#">Home Improvement Tips</a></li>
                                <li><a class="external" href="#">Articles</a></li>
                            </ul>
                            <ul>
                                <li><a class="external" href="#">Business Center</a></li>
                                <li><a href="#">Local Guides</a></li>
                                <li><a href="#">Consumer Reviews by Category</a></li>
                                <li><a href="#">Find Contractors &amp; Doctors</a></li>
                                <li><a class="external" href="#">Answers</a></li>
                                <li><a href="#">Home Shows</a></li>
                            </ul>-->
                            <ul class="social">
                                <li><strong>Follow us</strong></li>
                                <li class="social-icons"><a href="#"><div class="social_icon"></div></a>&nbsp;</li>
                                <li class="social-icons"><a href="#"><div class="social_icon" style="background-position: -86px;"></div></a> &nbsp;</li>
                                <li class="social-icons"><a href="#"><div class="social_icon" style="background-position: -43px;"></div></a> &nbsp;</li>
                            </ul>
                            <div id="copyright">
                                © Copyright 1995-2014 by Service Direct Inc. All Rights Reserved. <br />
                                <span style="font-size:1.3em;font-weight:bold;"> <a href="#">Terms of Use</a> | <a href="#">Privacy Policy</a></span>
                            </div>
                            <!-- CATEGORY: (Tips :  - /Tips/4 tips to avoid home warranty woes  :27003 []) -->       
                        </div>

                        <!-- START cloudCity Footer -->
                        <div class="footer cloudCity" style="display:none;">
                            <div class="container">

                                <div>
                                    <div class="footer-bottom clearfix">
                                        <div class="social-links">
                                            <ul>
                                                <li><a href="#" class="twitter" title="Follow us on Twitter"></a></li>
                                                <li><a href="https://www.facebook.com/servicedirectng/" target="_blank" class="facebook" title="Follow us on Facebook"></a></li>
                                                <li><a href="#" class="googleplus" title="Follow us on Google+"></a></li>
                                                <li><a href="#" class="youtube" title="Watch us on Youtube"></a></li>
                                            </ul>
                                        </div>
                                        <section class="sitemap-links clearfix">
                                            <div class="sitemap-links-block">
                                                <h6>Features</h6>
                                                <ul>
                                                    <li><a href="${createLink(uri: '/')}">Home</a></li>
                                                    <!--<li><a href="/servicedirect/faces/quicktour.xhtml">Quick Tour</a></li>-->
                                                    <li><a href="${createLink(controller: 'v', action: 'howitworks')}">How It Works</a></li>
                                                    <!--<li><a href="#">The Big Deal</a></li>
                                                    <li><a href="#">Business Center</a></li>
                                                    <li><a href="#">Gift Memberships</a></li>
                                                    <li><a href="#">SnapFix</a></li>-->
                                                </ul>
                                            </div>
                                            <!--<div class="sitemap-links-block">
                                                <h6>The Company</h6>
                                                <ul>
                                                    <li><a href="/servicedirect/faces/aboutus.xhtml">About Us</a></li>
                                                    <li><a href="#">In The Press</a></li>
                                                    <li><a href="#">Careers</a></li>
                                                    <li><a href="#">Privacy Policy</a></li>
                                                    <li><a href="#">Affiliate Program</a></li>
                                                </ul>
                                            </div>
                                            <div class="sitemap-links-block">
                                                <h6>Explore</h6>
                                                <ul>
                                                    <li><a href="#">Blog</a></li>
                                                    <li><a href="#">Videos</a></li>
                                                    <li><a href="#">Home Improvement Tips</a></li>
                                                    <li><a href="#">Articles</a></li>
                                                    <li><a href="#">Answers</a></li>
                                                    <li><a href="#">Local Guides</a></li>
                                                    <li><a href="#">Home Shows</a></li>
                                                </ul>
                                            </div>-->
                                            <div class="sitemap-links-block">
                                                <h6>Help</h6>
                                                <ul>
                                                    <!--<li><a href="#">FAQ</a></li>-->
                                                    <li><a href="${createLink(controller: 'v', action: 'contactUs')}">Contact Us</a></li>
                                                </ul>
                                            </div>
                                        </section>
                                        <div class="copyright">&copy; Copyright 2014, ServiceDirect. All Rights Reserved.&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">Membership Agreement</a><br />
                                            <span style="font-size:1.3em;font-weight:bold;"> <a href="#">Terms of Use</a> | <a href="#">Privacy Policy</a></span></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- END cloudCity Footer -->


                    </div><!-- /.section, /.region -->

                </div></div>
        </div>
        <!--<script type="text/javascript" src="js/XE4.js"></script>
    
        <script type="text/javascript" src="js/fh4.js"></script>-->
        <script type="text/javascript">
            document.getElementsByClassName("ackbar-footer")[0].style.display = "none";
            document.getElementsByClassName("cloudCity")[1].style.display = "block";
        </script>
        <script type="text/javascript">
            jQuery(document).ready(function () {
            jQuery('#al_show_menu,.close-btn').click(function (event) {
            event.preventDefault();
            jQuery('#al_topnav ul').toggleClass('show');
            jQuery('#inner_wrapper').toggleClass('move');
            });
            });
        </script>
        <script>
            (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
            (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o),
            m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
            })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

            ga('create', 'UA-63152272-1', 'auto');
            ga('send', 'pageview');

        </script>
</body>
</html>
