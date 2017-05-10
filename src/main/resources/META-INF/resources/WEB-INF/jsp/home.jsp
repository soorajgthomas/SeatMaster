<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page isELIgnored="false" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>SeatMaster</title>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/moment.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	
	<link rel="stylesheet" type="text/css" href="css/jquery.seat-charts.css" />
	<link rel="stylesheet" type="text/css" href="css/mapstyle.css">
	<link href="http://fonts.googleapis.com/css?family=Lato:400,700" rel="stylesheet" type="text/css">
	
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="js/jquery.seat-charts.js"></script>
	<script type="text/javascript" src="javascript/Activity.js"></script>
	<script src="js/jquery.backstretch.js" type="text/javascript"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script>
		function loadEconomy() {
			$("#pop").load("/Economy");
		};
		
		function loadFirst() {
			$("#pop").load("First.html");
		};
		
		function loadBusiness() {
			$("#pop").load("Business.html");
		}
	</script>
</head>

<body>
	<div id="custom-bootstrap-menu" class="navbar navbar-default " role="navigation">
		<div class="navbar-header"><a class="navbar-brand" href="#">SeatMaster</a>
	    	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder">
	    		<span class="sr-only">Toggle navigation</span>
	    		<span class="icon-bar"></span>
	    		<span class="icon-bar"></span>
	    		<span class="icon-bar"></span>
	      	</button>
	 	</div>
	    <div class="collapse navbar-collapse navbar-menubuilder">
	    	<ul class="nav navbar-nav navbar-right">
	        	<li><a href="#">Home</a></li>
	            <li><a href="#">Products</a></li>
	           	<li><a href="#">About Us</a></li>
	            <li><a href="#">Contact Us</a></li>
	     	</ul>
	 	</div>
	</div>
	<div class="wrapper">
		<div class="row">
			<div class="col-lg-4 col-sm-4 col-xs-12">
				<div class="booking-details">
					<h2>Booking Details</h2>
					<h3>
						Selected Seats (<span id="counter">2</span>):
					</h3>
					<ul id="selected-seats">
						<li id="cart-item-3_4">Economy Class Seat # 11: <b>$40</b> <a
							href="#" class="cancel-cart-item">[cancel]</a></li>
						<li id="cart-item-3_5">Economy Class Seat # 12: <b>$40</b> <a
							href="#" class="cancel-cart-item">[cancel]</a></li>
					</ul>
					Total: <b>$<span id="total">80</span></b>

					<button class="checkout-button">Checkout �</button>					
					
					<div class="panel panel-info" id="Legend">
      					<div class="panel-heading">Seat Legend</div>
      					<div class="panel-body">
	      					<div class="span4 proj-div" data-toggle="modal" data-target="#pop">
	      						<img src="icons/economy_class.png" width="50" onClick="loadEconomy();"><span>Economy</span>
	      					</div>
	      					<div class="span4 proj-div" data-toggle="modal" data-target="#pop">
	      						<img src="icons/first_class.png" width="60" onClick="loadFirst();"><span>First_class</span>
	      					</div>
	      					<div class="span4 proj-div" data-toggle="modal" data-target="#tour">
	      						<img src="icons/clk2.png" width="100" onClick="loadTour();"><span>Take virtual tour of cabin</span>
	      					</div>
      					</div>
    				</div>
				</div>
			</div>	

			<div><span>${fly1}</span></div>		
			<div class="col-lg-8 col-sm-8 col-xs-12 pre-scrollable map-parentdiv">
				<div class="container mapbackground ">
					<div id="seat-map" class="seatCharts-container" tabindex="0" aria-activedescendant="4_2">
						<div class="front-indicator">Front</div>
					</div>
				</div>
			</div>

		</div>
		
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
				        	var fenway = {lat: ${lat}, lng: ${lon} };				
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
    				<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCeSqrVfFZxsFQAgsGs0re_q0ojqvbXuU8&callback=initialize">
    				</script>
  				</body>
			</html>
 		</div>
	</div>
</body>
</html>