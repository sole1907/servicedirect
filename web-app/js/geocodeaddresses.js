$(window).load(function () {
    var addressdetails = $("#addresses").val();
    //alert(addressdetails);
    var addressextract = addressdetails.split("###");
    setCenter(addressextract[0]);
    //alert(addressextract[1]);
    var splitadddetails = addressextract[1].split("~");

    var addresses = [];
    var htmls = [];
    var labels = [];

    for (i = 0; i < splitadddetails.length; i++) {
        //alert(splitadddetails[i]);
        var splitadd = splitadddetails[i].split("^");
        addresses.push(splitadd[0]);
        htmls.push(splitadd[1]);
        labels.push(splitadd[2]);
    }

    setAddresses(addresses);
    setHtmls(htmls);
    setLabels(labels);

    theNext();
});
//<![CDATA[


// delay between geocode requests - at the time of writing, 100 miliseconds seems to work well
var delay = 100;


if (GBrowserIsCompatible()) {


    // ====== Create a Client Geocoder ======
    var geo = new GClientGeocoder();

    // ====== Array for decoding the failure codes ======
    var reasons = [];
    reasons[G_GEO_SUCCESS] = "Success";
    reasons[G_GEO_MISSING_ADDRESS] = "Missing Address: The address was either missing or had no value.";
    reasons[G_GEO_UNKNOWN_ADDRESS] = "Unknown Address:  No corresponding geographic location could be found for the specified address.";
    reasons[G_GEO_UNAVAILABLE_ADDRESS] = "Unavailable Address:  The geocode for the given address cannot be returned due to legal or contractual reasons.";
    reasons[G_GEO_BAD_KEY] = "Bad Key: The API key is either invalid or does not match the domain for which it was given";
    reasons[G_GEO_TOO_MANY_QUERIES] = "Too Many Queries: The daily geocoding quota for this site has been exceeded.";
    reasons[G_GEO_SERVER_ERROR] = "Server error: The geocoding request could not be successfully processed.";
    reasons[403] = "Error 403: Probably an incorrect error caused by a bug in the handling of invalid JSON.";

    // ====== Geocoding ======
    function getAddress(search, html, label, next) {
        //alert("the addy " + search);
        geo.getLocations(search, function (result)
        {
            // If that was successful
            if (result.Status.code == G_GEO_SUCCESS) {
                // Lets assume that the first marker is the one we want
                var p = result.Placemark[0].Point.coordinates;
                var lat = p[1];
                var lng = p[0];
                // Display the results in XML format
                var xml = '<marker address="' + search + '" html="' + html + '" label="' + label + '" lat="' + lat + '" lng="' + lng + '" />';
                //alert(xml);
                document.getElementById("message").textContent += xml;
            }
            // ====== Decode the error status ======
            else {
                // === if we were sending the requests to fast, try this one again and increase the delay
                if (result.Status.code == G_GEO_TOO_MANY_QUERIES) {
                    nextAddress--;
                    delay++;
                } else {
                    var reason = "Code " + result.Status.code;
                    if (reasons[result.Status.code]) {
                        reason = reasons[result.Status.code]
                    }
                    var xml = '<marker address="' + search + '" error="' + reason + '"/>';
                    document.getElementById("message").innerHTML += xml;
                }
            }
            next();
        }
        );
    }

// ====== Geocoding ======
    function setCenter(search) {
        //alert("the addy " + search);
        geo.getLocations(search, function (result)
        {
            // If that was successful
            if (result.Status.code == G_GEO_SUCCESS) {
                // Lets assume that the first marker is the one we want
                var p = result.Placemark[0].Point.coordinates;
                lgaLat = p[1];
                lgaLng = p[0];
            }
            // ====== Decode the error status ======
            else {
                lgaLat = 6.45306;
                lgaLng = 3.39583;
            }
        }
        );
    }

    // ======= An array of locations that we want to Geocode ========
    /*var addresses = [
     "1060 West Addison Street, Chicago, IL",
     "99, rue de Rivoli, Paris 75001",
     "Oder, DE",
     "Piazza della Scala, Milano 20121",
     "London, UK",
     "1600 Pennsylvania Avenue, Washington, DC",
     "A totally bogus address"
     ];*/

    var addresses = [];
    var htmls = [];
    var labels = [];
    var lgaLat;
    var lgaLong;

    function setAddresses(address) {
        addresses = address;
    }

    function setHtmls(html) {
        htmls = html;
    }

    function setLabels(label) {
        labels = label;
    }

    /*function setCenter(lat, long) {
     lgaLat = lat;
     alert(lat);
     lgaLong = long;
     alert(long);
     }*/

    // ======= Global variable to remind us what to do next
    var nextAddress = 0;

    // ======= Function to call the next Geocode operation when the reply comes back

    function theNext() {
        if (nextAddress < addresses.length) {
            //alert(addresses[nextAddress]);
            setTimeout('getAddress("' + addresses[nextAddress] + '", "' + htmls[nextAddress] + '", "' + labels[nextAddress] + '", theNext)', delay);
            nextAddress++;
        } else {
            // create the map
            var map = new GMap2(document.getElementById("map"));
            map.addControl(new GLargeMapControl());
            map.addControl(new GMapTypeControl());
            //map.setCenter(new GLatLng(6.45306, 3.39583), 11);
            //alert(lgaLat);
            //alert(lgaLng);
            //map.setCenter(new new google.maps.LatLng(6.601838, 3.3514863000000332), 11);
            map.setCenter(new google.maps.LatLng(lgaLat, lgaLng), 11);
            document.getElementById("message").textContent += "</markers>";
            var xml = document.getElementById("message").textContent;
            //xml = xml.replace(/"/g, '\\"');
            //var xml = "<markers><marker address=\"23, Dahomey Street, Bariga,Shomolu,Lagos, Nigeria\" html=\"test 1\" label=\"John Doe Enterprises\" lat=\"6.5453861\" lng=\"3.393133900000066\" /><marker address=\"41 Olaleye Street, Sawmill, Gbagada,Shomolu,Lagos, Nigeria\" html=\"test 2\" label=\"Jihn Doe Ent\" lat=\"6.555882299999999\" lng=\"3.393294800000035\" /></markers>";
            //var xml = "<markers><marker lat=\"43.65654\" lng=\"-79.90138\" html=\"Some stuff to display in the&lt;br&gt;First Info Window\"  label=\"Marker One\" /><marker lat=\"43.91892\" lng=\"-78.89231\" html=\"Some stuff to display in the&lt;br&gt;Second Info Window\" label=\"Marker Two\" /><marker lat=\"43.82589\" lng=\"-79.10040\" html=\"Some stuff to display in the&lt;br&gt;Third Info Window\"  label=\"Marker Three\" /></markers>";
            //var xml = "<markers><marker address=\"23, Dahomey Street, Bariga,Shomolu,Lagos, Nigeria\" lat=\"6.5453861\" lng=\"3.393133900000066\" html=\"Some stuff to display in the&lt;br&gt;First Info Window\"  label=\"Marker One\" /><marker lat=\"6.555882299999999\" lng=\"3.393294800000035\" html=\"Some stuff to display in the&lt;br&gt;Second Info Window\" label=\"Marker Two\" /><marker lat=\"6.555882299999999\" lng=\"3.393294800000035\" html=\"Some stuff to display in the&lt;br&gt;Third Info Window\"  label=\"Marker Three\" /></markers>";
            //alert(xml);
            // Read the data from example.xml
            var xmlDoc = GXml.parse(xml);
            var markers = xmlDoc.documentElement.getElementsByTagName("marker");
            //alert(markers.length);

            for (var i = 0; i < markers.length; i++) {
                // obtain the attribues of each marker
                //alert("counter :: " + i);
                var lat = parseFloat(markers[i].getAttribute("lat"));
                var lng = parseFloat(markers[i].getAttribute("lng"));
                var point = new GLatLng(lat, lng);
                var html = markers[i].getAttribute("html");
                var label = markers[i].getAttribute("label");
                // create the marker
                var marker = createMarker(point, label, html);
                map.addOverlay(marker);
            }
            // put the assembled side_bar_html contents into the side_bar div
            document.getElementById("side_bar").innerHTML = side_bar_html;
            $('span.stars').stars();
        }
    }


    //<![CDATA[ 
    // this variable will collect the html which will eventualkly be placed in the side_bar
    var side_bar_html = "";

    // arrays to hold copies of the markers used by the side_bar
    // because the function closure trick doesnt work there
    var gmarkers = [];

    // A function to create the marker and set up the event window
    function createMarker(point, name, html) {
        var marker = new GMarker(point);
        GEvent.addListener(marker, "click", function () {
            marker.openInfoWindowHtml(html);
        });
        // save the info we need to use later for the side_bar
        gmarkers.push(marker);
        // add a line to the side_bar html
        name = name.replace("#abegin#", '<a href="javascript:myclick(' + (gmarkers.length - 1) + ')">');
        name = name.replace("#aend#", '<\/a>');
        name = name.replace("#abegin1#", '<a href="javascript:myclick(' + (gmarkers.length - 1) + ')" class="btn search">');
        name = name.replace("#aend1#", '<\/a>');
        //alert(name);
        side_bar_html += name;
        return marker;
    }


    // This function picks up the click and opens the corresponding info window
    function myclick(i) {
        GEvent.trigger(gmarkers[i], "click");
    }

    // This Javascript is based on code provided by the
    // Community Church Javascript Team
    // http://www.bisphamchurch.org.uk/   
    // http://econym.org.uk/gmap/

    //]]>
    // ======= Call that function for the first time =======
    //theNext();



}

// display a warning if the browser was not compatible
else {
    alert("Sorry, the Google Maps API is not compatible with this browser");
}

// This Javascript is based on code provided by the
// Community Church Javascript Team
// http://www.bisphamchurch.org.uk/   
// http://econym.org.uk/gmap/

//]]>