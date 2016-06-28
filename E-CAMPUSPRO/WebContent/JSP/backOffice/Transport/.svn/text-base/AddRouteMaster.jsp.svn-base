<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>


<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect-blind.js"></script>
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
<script type="text/javascript" src="JS/backOffice/Transport/routeMaster.js"></script>

<style>
.save:hover {
	cursor: pointer;
}
</style>

<style>
#list:hover {
	cursor: pointer;
}
</style>


</head>

<body>
	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span>New Route Master</span>
		</p>

		<center>
			<div class="successmessagediv" style="display: none;">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-success bg-msg-succes"><span
						class="successmessage"></span></a>
				</div>
			</div>

			<div class="errormessagediv1" style="display: none;">
				<div class="message-item1">
					<!-- Warning -->
					<a href="#" class="msg-warning1 bg-msg-warning1"
						style="width: 30%;"><span class="validateTips1"></span></a>
				</div>
			</div>


		</center>

		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" style="color: #767676"> <i
							class="glyphicon glyphicon-menu-hamburger"></i> &nbsp;&nbsp;Route
							Master Details
						</a>
					</h4>

						<div class="navbar-right">
						
							<span class="save2"><img src="images/save.png" id="save" data-toggle="tooltip" data-placement="bottom" title="Save"></span> 
							
							<span class="glyphicon glyphicon-list2" id="list" data-toggle="tooltip" data-placement="bottom" title="List"></span>
						
						</div>
					
				</div>
				
				
				<script>
					$(document).ready(function() {
						$('[data-toggle="tooltip"]').tooltip();
					});
				</script>
				<div id="collapseOne" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingOne">
					<div class="panel-body">

						<div class="col-md-6" id="txtstyle">
							<br />

							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Route No
								</label>
								<div class="col-xs-7">
									<input type="text" name="routeNo" id="routeNo" maxlength="10"
										value='<logic:present name="masterDetails"><bean:write name="masterDetails" property="routeNo"></bean:write></logic:present>'
										maxlength="25" class="form-control" onblur="checkRouteNo()" />
								</div>
							</div>
							<br />



							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Route
									Short Name </label>
								<div class="col-xs-7">
									<input type="text" name="routeLogicName" id="routeLogicName"
										value='<logic:present name="masterDetails"><bean:write name="masterDetails" property="routeLogicName"></bean:write></logic:present>'
										maxlength="45" class="form-control" />
								</div>
							</div>

							<%-- <br />
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Cost Per
									Person
								</label>
								<div class="col-xs-7">
									<input type="text" name="costPerPerson" id="costPerPerson"
										value='<logic:present name="masterDetails"><bean:write name="masterDetails" property="costPerPerson"></bean:write></logic:present>'
										maxlength="7" class="form-control"
										placeholder="Enter Cost Per Person" />
								</div>
							</div> --%>
							<br />
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Total
									Stops
								</label>
								<div class="col-xs-7">
									<input type="text" name="totalStops" id="totalStops"
										maxlength="5"
										value='<logic:present name="masterDetails"><bean:write name="masterDetails" property="totalStops"></bean:write></logic:present>'
										class="form-control" />
								</div>
							</div>
							<br />
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Start
									Time
								</label>
								<div class="col-xs-7">
									<div id="datetimepicker3" class="input-append">
										<input type="text" data-format="hh:mm:ss" size="8"
											readonly="readonly" name="starttime" id="starttime"
											class="form-control"
											value='<logic:present name="masterDetails"><bean:write name="masterDetails" property="stratTime"></bean:write></logic:present>' /><img
											src="./images/time1.jpg" width="30" height="30"
											class="add-on" style="margin-left: 88%; margin-top: -12%;" />
									</div>
								</div>
							</div>
							<br />
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Halt Time
									In Stops
								</label>
								<div class="col-xs-7">
									<input type="text" name="halttime" id="halttime" maxlength="5"
										value='<logic:present name="masterDetails"><bean:write name="masterDetails" property="halttime"></bean:write></logic:present>'
										class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-6" id="txtstyle">
							<br />
							<div class="form-group">
								<label for="inputEmail" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Route
									Name
								</label>
								<div class="col-xs-7">
									<input type="text" name="routeName" id="routeName"
										maxlength="48" class="form-control"
										value='<logic:present name="masterDetails"><bean:write name="masterDetails" property="routeName"></bean:write></logic:present>' />
								</div>
							</div>

							<br />

							<%-- 	<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Route
									Type
								</label>
								<div class="col-xs-7">
									<input type="text" name="routeType" id="routeType"
										value='<logic:present name="masterDetails"><bean:write name="masterDetails" property="routeType"></bean:write></logic:present>'
										class="form-control" placeholder="Enter Route Type" />
								</div>
							</div> --%>


							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Destination
								</label>
								<div class="col-xs-7">
									<input type="text" name="destination" id="destination"
										value='<logic:present name="masterDetails"><bean:write name="masterDetails" property="destination"></bean:write></logic:present>'
										class="form-control" />
								</div>
							</div>
							<br />
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Total
									Distance
								</label>
								<div class="col-xs-7">
									<input type="text" name="totalDistance" id="totalDistance"
										value='<logic:present name="masterDetails"><bean:write name="masterDetails" property="totalDistance"></bean:write></logic:present>'
										maxlength="7" class="form-control" />
								</div>
							</div>
							<br />
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">End Time</label>
								<div class="col-xs-7">
									<div id="datetimepicker4" class="input-append">
										<input type="text" data-format="hh:mm:ss" size="8"
											readonly="readonly" name="endtime" id="endtime"
											class="form-control"
											value='<logic:present name="masterDetails"><bean:write name="masterDetails" property="endTime"></bean:write></logic:present>' /><img
											src="./images/time1.jpg" width="30" height="30"
											class="add-on" style="margin-left: 88%; margin-top: -12%;" />
									</div>
								</div>
							</div>
						</div>

						<input type="hidden" name="routeid" id="routeid"
							value='<logic:present name="masterDetails"><bean:write name="masterDetails" property="routeCode"/></logic:present>' />
					</div>
				</div>

			</div>
		</div>
	</div>
</body>

</html>
