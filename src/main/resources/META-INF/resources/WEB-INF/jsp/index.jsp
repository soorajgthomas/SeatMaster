<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!--[if lt IE 7]> <html class="no-js ie6 oldie" lang="en"> <![endif]-->
    <!--[if IE 7]>    <html class="no-js ie7 oldie" lang="en"> <![endif]-->
    <!--[if IE 8]>    <html class="no-js ie8 oldie" lang="en"> <![endif]-->
    <!--[if IE 9]> <html class="no-js ie9 oldie" lang="en"> <![endif]-->
    <meta charset="utf-8">
    <!--Set the viewport width to device width for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="SeatMaster">
    <title>SeatMaster</title>
    <!-- ============ Google fonts ============ -->
    <link href='http://fonts.googleapis.com/css?family=EB+Garamond' rel='stylesheet'
        type='text/css' />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300,800'
        rel='stylesheet' type='text/css' />
    <!-- ============ Add custom CSS here ============ -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
   	<link href="css/style.css" rel="stylesheet" type="text/css" />    
   
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" />

</head>
<body>
    <div id="custom-bootstrap-menu" class="navbar navbar-default " role="navigation">
	    <div class="container">
	        <div class="navbar-header"><a class="navbar-brand" href="#">SeatMaster</a>
	            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
	            </button>
	        </div>
	        <div class="collapse navbar-collapse navbar-menubuilder">
	            <ul class="nav navbar-nav navbar-right">
	                <li><a href="#">Home</a>
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

	<div class="container">
    	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 text-center">
       		<div id="banner">
           		<h1>SeatMaster - <strong>Choose your seat!</strong></h1>           
           </div>                        
    	</div>
        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        	<div class="registrationform">
            	<form role="form" class="form-horizontal" method="post" action="SeatMaster">
                	<fieldset>
                    	<legend>Flight Select <i class="fa fa-plane pull-right"></i></legend>
	                    <div class="form-group">
	                        <label for="select" class="col-lg-2 control-label">
	                            Airline</label>
	                        <div class="col-lg-10">
	                            <select class="form-control" name="flight" id="selectflight" onchange="onFlightSelection();">
	                                <option value="Scandinavian Airlines (SAS)">Scandinavian Airlines (SAS)</option>
	                                <option value="Aer Lingus (EI)">Aer Lingus (EI)</option>
	                            </select>
	                           
	                        </div>
	                    </div>
	                    <div class="form-group">
	                        <label for="select" class="col-lg-2 control-label">
	                            Model</label>
	                        <div class="col-lg-10">
	                            <select class="form-control" id="selectmodel" name="model" onchange="onModelSelection();">
	                                <option value="AirBus A330-300">AirBus A330-300</option>
	                                <option value="AirBus A340-300">AirBus A340-300</option>
	                            </select>
	                           
	                        </div>
	                    </div>
	                    <div class="form-group">
	                        <div class="col-lg-10 col-lg-offset-2">
	                            <button type="reset" class="btn btn-warning">
	                                Clear</button>
	                            <button type="submit" class="btn btn-primary">
	                                GoSeat</button>
	                        </div>
	                    </div>
                	</fieldset>
            	</form>
         	</div>



      	</div>
   	</div>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/jquery.backstretch.js" type="text/javascript"></script>
    <script src="js/seatmaster.js" type="text/javascript"></script>
        
</body>
</html>
