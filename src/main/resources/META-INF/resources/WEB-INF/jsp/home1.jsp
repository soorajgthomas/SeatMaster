<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SeatMaster</title>
<!-- <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" /> -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/moment.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<!-- Include Date Range Picker -->
<!-- <script type="text/javascript" src="js/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css" href="css/daterangepicker.css" />
<link rel="stylesheet" type="text/css" href="css/CustomStyle.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="css/addons.min.css" /> -->



<link rel="stylesheet" type="text/css" href="css/jquery.seat-charts.css" />
<link rel="stylesheet" type="text/css" href="css/mapstyle.css">
<link href="http://fonts.googleapis.com/css?family=Lato:400,700"
	rel="stylesheet" type="text/css">

<!-- <script type="text/javascript" src="js/jquery.gritter.min.js"></script> -->
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.seat-charts.js"></script>

<script type="text/javascript" src="javascript/Activity1.js"></script>

 <script src="js/jquery.backstretch.js" type="text/javascript"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <!-- ============ Google fonts ============ -->
    <link href='http://fonts.googleapis.com/css?family=EB+Garamond' rel='stylesheet'
        type='text/css' />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300,800'
        rel='stylesheet' type='text/css' />
        <link href="css/style.css" rel="stylesheet" type="text/css" />

    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" />
    <link href="css/button.css" rel="stylesheet" type="text/css" />
<script>
function loadEconomy() {
	$("#pop").load("Economy");
};

function loadFirst() {
	$("#pop").load("First");
};

function loadBusiness() {
	$("#pop").load("Business");
}
</script>
</head>
<body>
<input type="hidden" id="flightname" value=${fly1}>
<div id="custom-bootstrap-menu" class="navbar navbar-default " role="navigation">
    <div class="container">
        <div class="navbar-header"><a class="navbar-brand" href="#">SeatMaster</a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse navbar-menubuilder">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="http://localhost:8082/">Home</a>
                </li>
                <li><a href="#">Products</a>
                </li>
                <li><a href="#">About Us</a>
                </li>
                <li><a href="#">Contact Us</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div style="color: white; margin-left: 1000px; font-style: oblique;"><span><h4><b>${fly1}</b></h4></span></div>
	<div class="wrapper"  style="background-image: url(./images/bg.jpg)">
		<div class="row">
			<div class="col-lg-4 col-sm-4 col-xs-12">
				<div class="booking-details" style="border: 3px solid white; border-radius: 35px; height: 157px">
					<h3 style="margin-left:66px;"><b>Booking details</b></h3>
					<h3>
						Selected Seats (<span id="counter">2</span>):
					</h3>
					<ul id="selected-seats" style="height: 130px; width: 282px;">
						<li id="cart-item-3_4">Economy Class Seat # 11: <b>$40</b> <a
							href="#" class="cancel-cart-item"><img src="./images/delete.png"></a></li>
						<li id="cart-item-3_5">Economy Class Seat # 12: <b>$40</b> <a
							href="#" class="cancel-cart-item"><img src="./images/delete.png"></a></li>
					</ul>
					<div id="Legend" style="border: 3px solid white; border-radius: 42px; margin-top:31px">
      					<h3 style="margin-left:79px;"><b>Seat Legend</b></h3>
      						<div class="panel-body">
      						<div class="span4 proj-div" data-toggle="modal" data-target="#pop">
      						<img src="icons/economy_class.png" width="50" onClick="loadEconomy();"><span>Economy</span>
      						</div>
      						<div class="span4 proj-div" data-toggle="modal" data-target="#pop">
      						<img src="icons/first_class.png" width="60" onClick="loadFirst();"><span>First_class</span>
      						</div>
      						<div class="span4 proj-div" data-toggle="modal" data-target="#pop">
      						<img src="icons/prime.png" width="60" onClick="loadBusiness();"><span>Business</span>
      						</div>
      						<div class="span4 proj-div" data-toggle="modal" data-target="#tour">
      						<img src="icons/clk2.png" width="80"><span>Take virtual tour of cabin</span>
      						</div>
      						</div>
    				</div>
    				<div style="border: 3px solid white; border-radius: 35px; margin-top:5px width: 275px; text-align: center; height: 93px;"><h1><b>Total: $<span id="total">80</span></b></h1></div>

					<button style="margin-left:50px;" class="button button-4 button-4c icon-arrow-right"><i class="fa fa-arrow-right"></i>checkout</button>
				</div>

			</div>


			<div class="col-lg-8 col-sm-8 col-xs-12 pre-scrollable map-parentdiv">
				<div class="container mapbackground ">
					<div id="seat-map" class="seatCharts-container" tabindex="0"
						aria-activedescendant="4_2">
					</div>
				</div>
			</div>

		</div>
		<!-- <div class="container">
			<div id="mapbackground" class="mapbackground">

			</div>
		</div> -->
<div id="pop" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    			<!-- placeholder for 3d model -->
 			</div>

 			<div id="tour" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    			<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Street View side-by-side</title>
    <link rel="shortcut icon" href="seat.ico" />
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
        var fenway = {lat: ${lat}, lng: ${lon}};

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
    <script src="js/jquery.backstretch.js" type="text/javascript"></script>
        <script type="text/javascript">
            'use strict';

            /* ========================== */
            /* ::::::: Backstrech ::::::: */
            /* ========================== */
            // You may also attach Backstretch to a block-level element
            $.backstretch(
        [
        "images/bg.jpg"
        ],

        {
            duration: 4500,
            fade: 1500
        }
    );
        </script>

    <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCeSqrVfFZxsFQAgsGs0re_q0ojqvbXuU8&callback=initialize">
    </script>
  </body>
</html>
 			</div>
	</div>
</body>
</html>