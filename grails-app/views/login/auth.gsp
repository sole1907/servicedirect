<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'login.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'tooltipster.css')}" type="text/css">
        <g:javascript src="jquery.validate.min.js" />
        <g:javascript src="tooltipster.js" />
        <g:javascript src="login.js" />
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
                                                    <div class="content">

                                                        <div class="field field-name-body field-type-text-with-summary field-label-hidden clearfix">
                                                            <div class="field-items">
                                                                <div class="field-item even">
                                                                    <div id="aboutUsContainer">
                                                                        <!-- You can put your contents Here!  -->
                                                                        <g:if test="${flash.message}">
                                                                            <div class="infomsg">
                                                                                <div role="status" style="font-size: 18px;">${flash.message}</div>
                                                                            </div>
                                                                        </g:if>

                                                                        <div id="logincontent">


                                                                            <h1 class="loginHeader"><g:img uri="/images/GetTheBestService.png" alt="Get the best service" /></h1>

                                                                            <p class="loginTextBody">Find detailed reviews on roofers, plumbers, house cleaners, dentists and more!<br />More than 2 million households check Service Direct's List before they hire.</p>

                                                                            <ul class="loginCheckList">
                                                                                <li><b>Reviews come from real people</b> like you, not anonymous users</li>
                                                                                <li><b>Exclusive discounts</b> from top-rated businesses - save up to 70%</li>
                                                                                <li>Ratings and reviews in <b>more than 720</b> home repair and health care services</li>
                                                                                <li><b>Live call center</b> and help if a project goes badly</li>
                                                                            </ul>
                                                                        </div>
                                                                        <div id="SigninPanel" class="blue signin_progress">
                                                                            <h1 class="loginText">Member Sign In</h1>
                                                                            <div class="section">
                                                                                <form id="loginForm" name="loginForm" method="post" action="${resource(file: 'j_spring_security_check')}">
                                                                                    <div>
                                                                                        <div style="margin-top: 2px;">
                                                                                            <label class="bold" for="UserNameTextbox">Email Address</label><input name="j_username" style="width:12em;" maxlength="100" type="email" required="required" />
                                                                                        </div><br />
                                                                                        <div style="margin-top: 2px;">
                                                                                            <label class="bold" for="UserPasswordTextbox">Password</label><input type="password" name="j_password" value="" style="width:12em;" minlength="8" maxlength="100" required="required" />
                                                                                        </div>

                                                                                    </div>

                                                                                    <div style="margin-top: 10px;"><g:submitButton name="login" value="Sign In" class="btn-oval btn-yellow" /><br />
                                                                                        <!--&lt;input type=&quot;submit&quot; value=&quot;Sign In&quot; title=&quot;Sign In&quot; class=&quot;btn-oval btn-yellow&quot; /&gt;&lt;br /&gt;-->
                                                                                        <div class="clear"></div>
                                                                                    </div><input type="hidden" name="javax.faces.ViewState" id="j_id1:javax.faces.ViewState:0" value="3520406145413322811:-110770989708463998" autocomplete="off" />
                                                                                </form>
                                                                            </div>



                                                                            <hr id="login_instructions_separator" class="vertical_space" />

                                                                            <div class="section">
                                                                                <div style="font-size:110%; line-height:normal;">   
                                                                                    <span style="font-weight: bold;">Not a member?</span><br />     
                                                                                    <a href="${createLink(controller: 'secUser', action: 'create')}">Create an Account</a>   </div>  

                                                                                <div style="font-size:100%; padding: 10px 0 0 0; line-height:normal;">   
                                                                                    <span style="font-weight: bold;">Forgot your:</span><br />   
                                                                                    <a href="${createLink(controller: 'secUser', action: 'forgotPassword')}">Password?</a>   
                                                                                </div>  
                                                                                <div style="font-size:100%; padding: 10px 0 0 0; line-height:normal;">  </div>  

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
                                        <div class="clear"> </div>


                                    </div>
                                    <div class="clear"> </div>
                                </div>

                            </div><!-- /.block -->
                        </div><!-- /.region -->
                    </div></div><!-- /.section, /#content -->
            </div>
        </div>
    </body>
</html>
