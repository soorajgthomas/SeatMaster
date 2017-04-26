<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Street View side-by-side</title>
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map, #pano {
        float: left;
        height: 100%;
        width: 45%;
      }
    </style>
  </head>
  <body>
    <div id="pano"></div>
    <script>

      function initialize() {
        var fenway = {lat: 53.4228485, lng: -6.2393878};

        var panorama = new google.maps.StreetViewPanorama(
            document.getElementById('pano'), {
              position: fenway,
              pov: {
                heading: 34,
                pitch: 10
              }
            });
        map.setStreetView(panorama);
      }
    </script>
    <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCeSqrVfFZxsFQAgsGs0re_q0ojqvbXuU8&callback=initialize">
    </script>
  </body>
</html>