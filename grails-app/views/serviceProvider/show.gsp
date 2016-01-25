
<%@ page import="com.soconcepts.servicedirect.ServiceProvider" %>
<%@ page import="com.soconcepts.servicedirect.ServiceProviderReview" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'viewdetails.css')}" type="text/css">
        <g:javascript src="ratings.js" />
        <g:javascript src="serviceprovider.js" />

    </head>
    <body>
        <div class="newDesignWrapC cloudCityBegin">
            <main class="main">
                <section id="heroBanner">
                    <div class="heroContainer">
                        <div class="heroInner">
                            <div><h1> </h1>
                                <g:form url="[resource:serviceProviderInstance, action:'serviceProviderRating']" method="POST" id="rateSpForm">
                                    <div class="whiteBoxL">
                                        <div class="service_provider">
                                            <div class="serviceHolder">
                                                <g:if test="${serviceProviderInstance.picture}">
                                                    <g:img uri="/images/uploads/${serviceProviderInstance.picture}" width="150" height="150" />
                                                </g:if>
                                                <g:else>
                                                    <g:img uri="/images/provider-logo.jpg" width="150" height="150" />
                                                </g:else>
                                                <div id="companysummary">
                                                    <table width="100%" border="0">
                                                        <tr>
                                                            <td><h3>${serviceProviderInstance.user.firstname} ${serviceProviderInstance.user.lastname}</h3> 
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td><h4><p id="pratings"><span class="stars">
                                                                            <g:if test="${reviews}">
                                                                                ${totalrating/reviews.size()}
                                                                            </g:if>
                                                                            <g:else>
                                                                                0
                                                                            </g:else>
                                                                        </span></p></h4><input type="hidden" value="0" id="hiddenrating" /></td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <p>${serviceProviderInstance.about}</p>
                                            <hr />
                                            <table width="100%" border="0">
                                                <tr>
                                                    <!--&lt;td align=&quot;left&quot;&gt;&lt;a href=&quot;#&quot;&gt;&lt;h:graphicImage title=&quot;Send a Message&quot; name=&quot;./images/message.png&quot; /&gt;&lt;/a&gt;&lt;br /&gt;Send &lt;br /&gt;Message&lt;/td&gt;-->                			
                                                </tr>
                                            </table>
                                            <hr />
                                            <h1>View Comments</h1>
                                            <g:each var="review" in="${reviews}">
                                                <div class="service_provider">
                                                    <g:if test="${review.ratedBy}"><h5>${review.ratedBy.firstname}</h5></g:if>
                                                    <g:else><h5>${review.raterName}</h5></g:else>
                                                    ${review.comment}
                                                </div>
                                            </g:each>
                                            <hr />
                                            <g:if test="${flash.message}">
                                                <div class="successmsg">
                                                    <div role="status">${flash.message}</div>
                                                </div>
                                            </g:if>
                                            <g:if test="${flash.error}">
                                                <div class="errormsg">
                                                    <div role="status">${flash.error}</div>
                                                </div>
                                            </g:if>
                                            <g:hasErrors bean="${serviceProviderReviewInstance}">
                                                <div class="errormsg">
                                                    <ul class="errors" role="alert">
                                                        <g:eachError bean="${serviceProviderReviewInstance}" var="error">
                                                            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                                                            </g:eachError>
                                                    </ul>
                                                </div>
                                            </g:hasErrors>
                                            <div class="loading" style="display:none">Hang on while we process your request ...</div><div id="rateSpForm:result"></div>
                                            <h6>Please feel free to make your comments below</h6>
                                            <div class="addComment">
                                                <sec:ifNotLoggedIn>
                                                    <input type="text" name="myname" placeholder="Enter Name" required="required" />
                                                </sec:ifNotLoggedIn>
                                                <sec:ifLoggedIn>
                                                    <input type="text" name="myname" readonly placeholder="Enter Name" value="<sec:loggedInUserInfo field='fullName' />" required="required" />
                                                </sec:ifLoggedIn>
                                                <textarea name="mycomment" placeholder="Make your comment" rows="5" required="required"></textarea>

                                                <h6>How would you rate this service provider on a scale of 1 -5? <br /> Tell us by selecting a rating below: </h6>
                                                <fieldset class="rating">
                                                    <legend></legend>
                                                    <input type="radio" id="star5" name="rating" value="5" p:required="required" onclick="document.getElementById('rateSpForm:finalrating').value = 5" /><label for="star5" title="Rocks!">5 stars</label>
                                                    <input type="radio" id="star4" name="rating" value="4" p:required="required" onclick="document.getElementById('rateSpForm:finalrating').value = 4" /><label for="star4" title="Pretty good">4 stars</label>
                                                    <input type="radio" id="star3" name="rating" value="3" p:required="required" onclick="document.getElementById('rateSpForm:finalrating').value = 3" /><label for="star3" title="Meh">3 stars</label>
                                                    <input type="radio" id="star2" name="rating" value="2" p:required="required" onclick="document.getElementById('rateSpForm:finalrating').value = 2" /><label for="star2" title="Kinda bad">2 stars</label>
                                                    <input type="radio" id="star1" name="rating" value="1" p:required="required" onclick="document.getElementById('rateSpForm:finalrating').value = 1" /><label for="star1" title="Sucks big time">1 star</label>
                                                </fieldset>
                                                <div style="display: none"><input id="rateSpForm:finalrating" type="text" name="rateSpForm:finalrating" class="finalrating" /><input type="text" name="rateSpForm:j_idt84" value="144" /></div>

                                                <div class="clear"></div><g:submitButton name="comment" class="save btn search" value="Make Comment" />
                                                <!--&lt;a href=&quot;#&quot; title=&quot;Make comment&quot; class=&quot;search btn&quot;&gt;Make comment&lt;/a&gt;-->
                                            </div>
                                            <div class="clear"></div>

                                        </div>
                                    </div><input type="hidden" name="javax.faces.ViewState" id="j_id1:javax.faces.ViewState:0" value="5232605415997992993:-8896568615279601034" autocomplete="off" />
                                </g:form>
                            </div>


                                    <!-- when we are in tablet view -->


                        </div>
                    </div>
                    <div class="viewdetails"></div>
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

    </body>
</html>
