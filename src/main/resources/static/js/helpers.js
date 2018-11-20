    function initMap() {

        var xmlhttp1 = new XMLHttpRequest();
        var IP_lat = "";
        var IP_lng = "";

        xmlhttp1.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                var LatLongObj = JSON.parse(this.responseText);
                IP_lat = LatLongObj.location.lat;
                IP_lng = LatLongObj.location.lng;
                console.log(IP_lat);
                console.log(IP_lng);
                var urlLatLngToPostalCode = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + IP_lat + "," + IP_lng + "&key=AIzaSyA_aOK49a2Rm00tCPaeNE6d23F0y2O7BL4&result_type=postal_code";

            }
        };

        var urlIPToLatLng = "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyA_aOK49a2Rm00tCPaeNE6d23F0y2O7BL4";

        xmlhttp1.open("POST", urlIPToLatLng, true);
        xmlhttp1.send();


        var xmlhttp2 = new XMLHttpRequest();
        var strPostalCode = "";

        xmlhttp2.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                var PostalCodeObj = JSON.parse(this.responseText);
                strPostalCode = PostalCodeObj.locations[0].address_components[0].long_name;
                console.log(strPostalCode);
            }
        };
        
        xmlhttp2.open("GET", "urlLatLngToPostalCode", true);
        xmlhttp2.send();



    //"lat": 47.579064,
    //"lng": -122.1702689  
    var myLatLng1 = {lat: 47.579064, lng: -122.1702689};
    var myLatLng2 = {lat: 47.4987544, lng: -122.2033417};
    var myLatLng3 = {lat: 47.54391400000001, lng: -122.018032};


    // Create a map object and specify the DOM element
    // for display.
    var map = new google.maps.Map(document.getElementById('map'), {
        center: myLatLng1,
        zoom: 11
    });

    var infowindow1 = new google.maps.InfoWindow({
        content: contentString
    });

    // Create a marker and set its position.
    var marker1 = new google.maps.Marker({
        map: map,
        position: myLatLng1,
        title: 'Theater1'
    });

    marker1.addListener('click', function() {
        infowindow1.open(map, marker1);
    });

    // Create a marker and set its position.
    var marker2 = new google.maps.Marker({
        map: map,
        position: myLatLng2,
        title: 'Theater2'
    });

    // Create a marker and set its position.
    var marker3 = new google.maps.Marker({
        map: map,
        position: myLatLng3,
        title: 'Theater3'
    });
}
