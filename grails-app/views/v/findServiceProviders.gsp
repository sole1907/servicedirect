<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main"/>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'search.css')}" type="text/css">
        <script src="http://maps.google.com/maps?file=api&amp;v=3&amp;sensor=false&amp;key=AIzaSyC3MXmo6TODNHKlxpu1Mov_TCXjMXv9Gdw" type="text/javascript"></script>
        <g:javascript src="geocodeaddresses.js" />
        <g:javascript src="ratings.js" />
        <script type="text/javascript">
            document.body.className = document.body.className += " newDesignC";

            document.getElementsByClassName("ackbar-footer")[0].style.display = "none";
            document.getElementsByClassName("ackbar-header")[0].style.display = "none";
            document.getElementsByClassName("cloudCity")[0].style.display = "block";
            document.getElementsByClassName("cloudCity")[1].style.display = "block";
        </script>
    </head>
    <body>
        <div id="message" style="display: none">&lt;markers&gt;</div>
    <h:form id="mapForm"><div style="display:none"><input type="hidden" value="${flash.addresses}" id="addresses" /></div></h:form>
    <main class="main">
        <div class="desk-view">
            <div class="cover">
                <div class="cell1">
                    <table width="100%">
                        <tr>
                            <td>
                                <div id="map" style="width: 100%; height: 280px">
                                    <div class="loading">Hang on while we process your request ...</div>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="cell2">
                    <table width="100%">
                        <tr>
                            <td valign="top" style="text-decoration: underline; color: #4444ff;">
                                <div id="side_bar" style="height: 280px; overflow-y: scroll;"></div>
                            </td>
                        </tr>
                    </table> 
                </div>
            </div>
        </div>
    </main>
    <a href="${createLink(uri: '/')}">Back to the search page</a>
</body>
</html>
