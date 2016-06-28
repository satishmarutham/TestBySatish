<!DOCTYPE html>
<html lang="en">
<%@  taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
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
<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet">
<link href="CSS/newUI/modern-business.css" rel="stylesheet">
<link href="CSS/newUI/custome.css" rel="stylesheet">
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<script type="text/javascript" src="JS/backOffice/Admin/Latheef.js"></script>
<script type="text/javascript"
	src="JS/backOffice/Transport/AddVehicleDetails.js"></script>


</head>

<body>
	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span>New Vehicle</span>
		</p>

		<center>
			<logic:present name="successmessagediv" scope="request">
				<div class="successmessagediv">
					<div class="message-item">
						<!-- Warning -->
						<a href="#" class="msg-success bg-msg-succes"><span><bean:write
									name="successmessagediv" scope="request" /></span></a>
					</div>
				</div>
			</logic:present>


			<div class="errormessagediv" style="display: none;">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-warning bg-msg-warning"><span
						class="validateTips"></span></a>
				</div>
			</div>

		</center>



		<form method="post">
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i> &nbsp;&nbsp;<span
								style="margin-top: -4px; position: absolute;">Vehicle
									Details</span>
							</a>
                          </h4>
							<div class="navbar-right" >
								
								<span id="save" class="save2"><img src="images/save.png"
									style="cursor: pointer"
									data-toggle="tooltip" data-placement="bottom" title="Save"></span>
									 <a
									href="adminMenu.html?method=vehicleList"><span
									class="glyphicon glyphicon-list2"
								
									data-toggle="tooltip" data-placement="bottom" title="List"></span></a>
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
							<div class="col-md-6" id="txtstyle"
								style="font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Registration
										No</label>
									<div class="col-xs-7">

										<input type="text" name="vehicleregno" class="form-control"
											id="vehicleregno" onblur="registernumberValidation()"
											placeholder=""
											value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="vehicleregno"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Type</label>
									<div class="col-xs-7">
										<input type="text" name="vehicletype" id="vehicletype"
											class="form-control" placeholder=""
											value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="vehicletype"/></logic:present>" />
									</div>
								</div>

								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Maker's
										Name</label>
									<div class="col-xs-7">
										<input type="text" name="makersname" id="makersname"
											class="form-control" placeholder=""
											value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="makersname"/></logic:present>" />
									</div>
								</div>

								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Chassis
										No</label>
									<div class="col-xs-7">
										<input type="text" name="chassisno" id="chassisno"
											onblur="chassisnovalidation()" class="form-control"
											placeholder=""
											value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="chassisno"/></logic:present>" />
									</div>
								</div>

								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Fuel
										Used In Engine</label>
									<div class="col-xs-7">
										<select name="fuelengine" id="fuelengine" class="form-control">
											<option value="">-----Select-----</option>
											<option value="pertrol">Petrol</option>
											<option value="diesel">Diesel</option>
											<option value="gas">Gas</option>
										</select>
									</div>
								</div>

							</div>
							<div class="col-md-6" id="txtstyle"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">

								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;"> Name</label>
									<div class="col-xs-7">
										<input type="text" class="form-control" name="vehiclename"
											id="vehiclename" placeholder=""
											value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="vehiclename"/></logic:present>" />
									</div>
								</div>

								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Type Of
										Body</label>
									<div class="col-xs-7">
										<input type="text" name="typeofbody" id="typeofbody"
											class="form-control" placeholder=""
											value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="typeofbody"/></logic:present>" />
									</div>
								</div>

								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Manufacturing
										Date</label>
									<div class="col-xs-7">
										<input type="text" readonly="readonly" name="manufacturerdate"
											id="manufacturerdate" class="form-control" placeholder=""
											value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="manufacturerdate"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Seating
										Capacity</label>
									<div class="col-xs-7">
										<input type="text" name="settingcapacity" id="settingcapacity"
											maxlength="3" class="form-control" placeholder=""
											value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="settingcapacity"/></logic:present>" />
									</div>
								</div>

								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Color Of
										Body</label>
									<div class="col-xs-7">
										<input type="text" name="colorofbody" id="colorofbody"
											class="form-control" placeholder=""
											value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="colorofbody"/></logic:present>" />
									</div>
								</div>

							</div>


						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseTwo"
								style="color: #767676" aria-expanded="false"
								aria-controls="collapseTwo"> <i
								class="glyphicon glyphicon-menu-hamburger"></i> &nbsp;&nbsp;<span
								style="margin-top: -4px; position: absolute;">Insurance
									Details</span>
							</a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body">
							<div class="col-md-6" id="txtstyle"
								style="font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;"> Company
										Name</label>
									<div class="col-xs-7">
										<input type="text" name="companyname" id="companyname"
											class="form-control" placeholder=""
											value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="companyname"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;"> Issued
										Date</label>
									<div class="col-xs-7">
										<input type="text" name="issueddate" id="issueddate"
											placeholder="" readonly="readonly" class="form-control"
											placeholder=""
											value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="issueddate"/></logic:present>" />
									</div>
								</div>
								<br />


							</div>

							<div class="col-md-6" id="txtstyle"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">

								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;"> Expiry
										Date</label>
									<div class="col-xs-7">
										<input type="text" name="expirydate" id="expirydate"
											placeholder="" readonly="readonly" class="form-control"
											placeholder=""
											value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="expirydate"/></logic:present>" />
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Done By</label>
									<div class="col-xs-7">
										<input type="text" name="doneby" id="doneby"
											class="form-control" placeholder=""
											value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="doneby"/></logic:present>" />
									</div>
								</div>

							</div>
						</div>
					</div>

				</div>

				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseThree"
								style="color: #767676" aria-expanded="false"
								aria-controls="collapseTwo"> <i
								class="glyphicon glyphicon-menu-hamburger"></i> &nbsp;&nbsp;<span
								style="margin-top: -4px; position: absolute;">Driver
									Mapping</span>
							</a>
						</h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body">
							<div class="col-md-6" id="txtstyle"
								style="font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;"> Driver
										Name</label>
									<div class="col-xs-7">
										<select name="drivername" id="drivername" class="form-control"
											onchange="getDriverEntireDetails()">
											<option value="">-----Select-----</option>
										</select>
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">
										Experience </label>
									<div class="col-xs-7">
										<input type="text" name="experience" id="experience"
											readonly="readonly" class="form-control"
											value="<logic:present name="driverDetails" ><bean:write name="driverDetails" property="experience"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">DL
										Issued Date</label>
									<div class="col-xs-7">
										<input type="text" name="dlissued" id="dlissued"
											readonly="readonly" class="form-control"
											value="<logic:present name="driverDetails" ><bean:write name="driverDetails" property="dl_issued_date"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Licence
										To Drive </label>
									<div class="col-xs-7">
										<input type="text" name="licencedrive" id="licencedrive"
											readonly="readonly" class="form-control"
											value="<logic:present name="driverDetails" ><bean:write name="driverDetails" property="license"/></logic:present>" />
									</div>
								</div>
								<br />
							</div>

							<div class="col-md-6" id="txtstyle"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Mobile
										Number</label>
									<div class="col-xs-7">
										<input type="text" name="phoneno" id="phoneno"
											readonly="readonly" class="form-control"
											value="<logic:present name="driverDetails" ><bean:write name="driverDetails" property="mobile"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;"> Date Of
										Join</label>
									<div class="col-xs-7">
										<input type="text" name="doj" id="doj" readonly="readonly"
											class="form-control"
											value="<logic:present name="driverDetails" ><bean:write name="driverDetails" property="dateofJoin"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">DL
										Expiry Date</label>
									<div class="col-xs-7">
										<input type="text" name="dlexpiray" id="dlexpiray"
											readonly="readonly" class="form-control"
											value="<logic:present name="driverDetails" ><bean:write name="driverDetails" property="dl_validity"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Drive
										Licence No</label>
									<div class="col-xs-7">
										<input type="text" name="dlno" id="dlno" readonly="readonly"
											class="form-control"
											value="<logic:present name="driverDetails" ><bean:write name="driverDetails" property="drivingliecenseNo"/></logic:present>" />
									</div>
								</div>
								<br />

							</div>
						</div>
					</div>

				</div>

				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseFourth"
								style="color: #767676" aria-expanded="false"
								aria-controls="collapseTwo"> <i
								class="glyphicon glyphicon-menu-hamburger"></i> &nbsp;&nbsp;<span
								style="margin-top: -4px; position: absolute;">Route
									Mapping</span>
							</a>
						</h4>
					</div>
					<div id="collapseFourth" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body">
							<div class="col-md-6" id="txtstyle"
								style="font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;"> Route
										Name</label>
									<div class="col-xs-7">
										<select name="routename" id="routename" class="form-control"
											onchange="getRouteEntireDetails()">
											<option value="">-----Select-----</option>
										</select>
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Halt
										time</label>
									<div class="col-xs-7">
										<input type="text" name="halttime" id="halttime"
											readonly="readonly" class="form-control"
											value="<logic:present name="RouteDetails" ><bean:write name="RouteDetails" property="halttime"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Total
										Distance</label>
									<div class="col-xs-7">
										<input type="text" name="totaldistance" id="totaldistance"
											readonly="readonly" class="form-control"
											value="<logic:present name="RouteDetails" ><bean:write name="RouteDetails" property="totalDistance"/></logic:present>" />
									</div>
								</div>

								<br />
							</div>

							<div class="col-md-6" id="txtstyle"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;"> Route
										No </label>
									<div class="col-xs-7">
										<input type="text" name="routeno" id="routeno"
											readonly="readonly" class="form-control"
											value="<logic:present name="RouteDetails" ><bean:write name="RouteDetails" property="routeNo"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Destination</label>
									<div class="col-xs-7">
										<input type="text" name="destination" id="destination"
											readonly="readonly" class="form-control"
											value="<logic:present name="RouteDetails" ><bean:write name="RouteDetails" property="destination"/></logic:present>" />
									</div>
								</div>

								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Total
										Stops</label>
									<div class="col-xs-7">
										<input type="text" name="totalstops" id="totalstops"
											readonly="readonly" class="form-control"
											value="<logic:present name="RouteDetails" ><bean:write name="RouteDetails" property="totalStops"/></logic:present>" />
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>


				<input type="hidden" name="updatevehicleCode" id="updatevehicleCode"
					value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="vehiclecode"/></logic:present>" />

				<input type="hidden" name="driverCode" id="driverCode"
					value="<logic:present name="driverDetails" ><bean:write name="driverDetails" property="driverCode"/></logic:present>" />

				<input type="hidden" name="status" id="statusId"
					value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="status"/></logic:present>" />

				<input type="hidden" name="hiddenfuel" id="hiddenfuelId"
					value="<logic:present name="vehicleDetails" ><bean:write name="vehicleDetails" property="fuelusedintheengine"/></logic:present>" />

				<input type="hidden" name="routecodeid" id="routecodeid"
					value="<logic:present name="RouteDetails" ><bean:write name="RouteDetails" property="routeCode"/></logic:present>" />





			</div>



		</form>
	</div>

</body>

</html>
