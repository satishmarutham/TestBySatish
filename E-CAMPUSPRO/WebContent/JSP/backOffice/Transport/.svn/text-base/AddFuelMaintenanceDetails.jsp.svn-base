<!DOCTYPE html>
<html lang="en">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<link rel="stylesheet"	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery-ui.custom.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.tooltip.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/timepicker.js"></script>
<script type="text/javascript" src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script> 

<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript"
	src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet" />
<link href="CSS/newUI/modern-business.css" rel="stylesheet" />
<link href="CSS/newUI/custome.css" rel="stylesheet" />
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript" src="JS/backOffice/Transport/FuelMaintenanceList.js"></script> 

<!-- <script >
	$('.carousel').carousel({
		interval : 5000
	//changes the speed
	})
	$(document).scroll(function() {
		var y = $(this).scrollTop();
		if (y > 100) {
			$('.topimg').fadeIn();
		} else {
			$('.topimg').fadeOut();
		}
	});
</script>
<script>
	$('.carousel').carousel({
		interval : 5000
	//changes the speed
	})
</script> -->
</head>

<body>
	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span>Fuel Maintenance</span>
		</p>
		
		
					
					
					
				

					<div class="errormessagediv" style="display: none;">
						<div class="message-item">
							<!-- Warning -->
							<a href="#" class="msg-warning bg-msg-warning"><span
								class="validateTips"></span></a>
						</div>
					</div>
					
					<div class="successmessagediv" style="display: none;">
								<div class="message-item">
									<!-- Warning -->
									<a href="#" class="msg-success bg-msg-succes"><span class="successmessage"></span></a>
								</div>
						</div>
				
		      
						<br/>
						
						

		<form method="post">
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Fuel Maintenance Details
							</a>
						</h4>

							<div class="navbar-right" >
							
							<a href="" id="saveid" class="save2"><img src="images/save.png" data-toggle="tooltip" data-placement="bottom" title="Save"></a>	
								
							<a href="adminMenu.html?method=fuelMaintenance">
							
							<span class="glyphicon glyphicon-list2" data-toggle="tooltip" data-placement="bottom" title="List"></span></a>
							
							</div>
						
					</div>
					


			<input	type="hidden" name="drivercode" id="drivercode" value="<logic:present name="fuellist" ><bean:write name="fuellist" property="driverCode"/></logic:present>"/>
		    <input	type="hidden" name="vehiclecode" id="vehiclecode" value="<logic:present name="fuellist" ><bean:write name="fuellist" property="vehicleCode"/></logic:present>"/>
            <input type="hidden" name="fuelcode" id="fuelcode"  value="<logic:present name="fuellist" ><bean:write name="fuellist" property="fuelCode"/></logic:present>"/>

			<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							<div class="col-md-6"
								id="txtstyle">
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Vehicle Name</label>
									<div class="col-xs-7">
									
											<input type="text" name="vehiclename" class="form-control" id="vehicleid"  placeholder="" value="<logic:present name="fuellist" ><bean:write name="fuellist" property="vehiclename"/></logic:present>"/>
									</div>
								</div>
								<br />
                                								
								<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Time</label>
								<div class="col-xs-7">
									<div id="timpicker" class="input-append">
										<input type="text" data-format="hh:mm:ss" size="8"
											readonly="readonly" name="time" id="timeid"
											class="form-control" placeholder=""
											value='<logic:present name="fuellist"><bean:write name="fuellist" property="time"></bean:write></logic:present>' /><img
											src="./images/time1.jpg" width="30" height="30"
											class="add-on" style="margin-left: 88%; margin-top: -12%;" />
									</div>
								</div>
							</div>
								
							    <br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Driver Name</label>
									<div class="col-xs-7">
											<input type="text" name="drivername" id="driverid" class="form-control" placeholder="" value="<logic:present name="fuellist" ><bean:write name="fuellist" property="drivername"/></logic:present>"/>
									</div>
								</div>
								
								 <br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Quantity</label>
									<div class="col-xs-7">
									<input type="text" name="qty" id="quantityid"  class="form-control" 
									 value="<logic:present name="fuellist" ><bean:write name="fuellist" property="quantity"/></logic:present>" />
									</div>
								</div>
								
								 <br />
                               <div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Meter Reading(Km)</label>
										<div class="col-xs-7">
									<input type="text" name="meterreading" id="meterreading"  class="form-control"
									 value="<logic:present name="fuellist" ><bean:write name="fuellist" property="meterReading"/></logic:present>" />
									</div>
								</div>
								
							</div>
							
							<div class="col-md-6"
								id="txtstyle">
								
									<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">
										Date</label>
									<div class="col-xs-7">
										<input type="text" readonly="readonly" class="form-control"  name="date" id="date" placeholder="" value="<logic:present name="fuellist" ><bean:write name="fuellist" property="date"/></logic:present>"/>
									</div>
								</div>
								
								<br />
								
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Vehicle No.</label>
									<div class="col-xs-7">
											<input type="text" readonly="readonly" name="vehicleno" id="vehiclenoid" class="form-control"  value="<logic:present name="fuellist" ><bean:write name="fuellist" property="vehiclenumber"/></logic:present>"/>
									</div>
								</div>
								
								<br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Fuel Type</label>
									<div class="col-xs-7">
											<input type="text"  name="fueltype" id="fueltype" class="form-control" 
										value="<logic:present name="fuellist" ><bean:write name="fuellist" property="fuelType"/></logic:present>"/>
									</div>
								</div>
								 <br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Price</label>
									<div class="col-xs-7">
											<input type="text"
								name="price" id="priceid" class="form-control"  value="<logic:present name="fuellist" ><bean:write name="fuellist" property="price"/></logic:present>"/>
									</div>
								</div>
								
								 <br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Location</label>
									<div class="col-xs-7">
											<input type="text" name="location" id="locationid" class="form-control" value="<logic:present name="fuellist" ><bean:write name="fuellist" property="location"/></logic:present>"/>
									</div>
								</div>
								
							</div>
							
							
						
						</div>
					</div>
					</div>
					</div>
					
</form>
				</div>
			
				
			
	
</body>

</html>
