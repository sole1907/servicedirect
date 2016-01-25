<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main"/>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'contact.css')}" type="text/css">
    </head>
    <body>
        <div>

            <div id="contact-area">

                <p class="new-contact">Please feel free to reach us using the following media, <br />we are more than happy to be of service to you.</p>
 <g:if test="${flash.message}">
                <div class="infomsg" role="status">${flash.message}</div>
            </g:if>                    
<g:form  url="[controller:'v', action:'sendContactUsMail']">

                    <label>Name: </label><input type="text" name="name" placeholder="John Doe" required="required" />

                    <label>Email: </label><input id="email" name="email" placeholder="john.doe@domain.com" type="email" required="required" />

                    <label>Message: </label><textarea name="message" placeholder="A brief message to us" required="required"></textarea>
                    <g:submitButton name="submit" value="Submit" class="submit-button" />

                    <p> </p>
                </g:form>
                <div style="clear: both;"></div>

            </div><div id="contact-area2">
                <h3>Contact Information</h3>
                <p>
                    You can locate us Here!
                </p>
            </div>

        </div>
    </body>
</html>
