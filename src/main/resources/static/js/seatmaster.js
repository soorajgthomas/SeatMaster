function onFlightSelection(){
	if($("#selectflight").val() == "Scandinavian Airlines (SAS)"){
		$("#selectmodel").html("<option value='AirBus A330-300'>AirBus A330-300</option><option value='AirBus A340-300'>AirBus A340-300</option>");
	}else{
		$("#selectmodel").html("<option value='AirBus A330-300'>AirBus A330-300</option><option value='AirBus A330-200'>AirBus A330-200</option>");
	}
	
}

function onModelSelection(){
}