<!DOCTYPE html>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript"
	src="JS/backOffice/Admin/AcademicYearDetails.js"></script>

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
			<img src="images/addstu.png" />&nbsp;<span id="pageHeading">Academic Year Details</span>
		</p>

		
			<div class="successmessagediv" align ="center" style="display: none;">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-success bg-msg-succes"><span
						class="successmessage"></span></a>
				</div>
			</div>

			<div class="errormessagediv1" align ="center" style="display: none;">
				<div class="message-item1">
					<!-- Warning -->
					<a href="#" class="msg-warning1 bg-msg-warning1"
						style="width: 30%;"><span class="validateTips1"></span></a>
				</div>
			</div>
		

		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<div class="panel panel-primary">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" style="color: #767676"> <i
							class="glyphicon glyphicon-menu-hamburger"></i>
							&nbsp;&nbsp;Academic Year Details
						</a>
						</h4>

						<div class="navbar-right" >
						
							
							 <span id="save" class="save2">
								 <img src="images/save.png" 
									 data-toggle="tooltip" data-placement="bottom" title="Save">
									</span> 
								
							
							
							
							
						<!-- 	<span class="save"><img src="images/save.png" id="save"
								style="font-size: 20px; line-height: 34px; color: #989898; margin-top: -5px;" data-toggle="tooltip" data-placement="bottom" title="Save"></span> 
								 -->
								<!-- <a
								href=""><img src="images/download.png"
								style="font-size: 20px; line-height: 34px; color: #989898; margin-top: -5px;"> 
								
								<img src="images/rightline.png" style="margin-top: -13px;"></a>-->
								
								 <span
								class="glyphicon glyphicon-list2" id="list"
								 data-toggle="tooltip" data-placement="bottom" title="List"></span>
						</div>
					</h4>
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
						
							<div class="form-group">
								<label for="inputEmail" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Academic
									Year
								</label>
								<div class="col-xs-7">
									<input type="text" name="accyearname" id="accyearname"
										maxlength="25" class="form-control"
										placeholder=""
										value='<logic:present name="editacademicyear" property="acadamic_name"><bean:write name="editacademicyear" property="acadamic_name"></bean:write></logic:present>'></input>
								</div>
							</div>

							<br />
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Description
								</label>
								<div class="col-xs-7">
									<textarea style="font-size: 12px;" name="description"
										class="form-control" id="description"
										placeholder="Enter Description">
										</textarea>
								</div>
							</div>

						</div>
						
						<div class="col-md-6" id="txtstyle">

							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Start
									Date
								</label>
								<div class="col-xs-7">
									<input type="text" name="startdate" id="startdate"
										readonly="readonly" placeholder=""
										class="form-control"
										value='<logic:present name="editacademicyear" property="startDate"><bean:write name="editacademicyear" property="startDate" /></logic:present>'
										onchange="setEndDate()"></input>
								</div>
							</div>
							<br />
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">End Date</label>
								<div class="col-xs-7">
									<input type="text" name="enddate" id="enddate"
										readonly="readonly" placeholder=""
										class="form-control"
										value='<logic:present name="editacademicyear" property="endDate"><bean:write name="editacademicyear" property="endDate" /></logic:present>'></input>

								</div>
							</div>
							<br />
						</div>
						<input type="hidden" name="accid" id="accid"
							value='<logic:present name="editacademicyear" property="acadamic_id"><bean:write name="editacademicyear" property="acadamic_id" />
													</logic:present>' />

						<input type="hidden" id="descriptionId" name="descriptionId"
							value="<logic:present name="editacademicyear" property="description">
											<bean:write name="editacademicyear" property="description" />
										</logic:present>">
					</div>
				</div>

			</div>
		</div>
	</div>
</body>

</html>
