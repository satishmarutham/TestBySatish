 <!-- Written By Swathi -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
<script type="text/javascript"	src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="JS/common.js"></script>
<script type="text/javascript" src="JS/backOffice/Admin/AcadamicYearPlanMaster.js"></script>
<link rel="stylesheet"	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<!-- <link href="/CSS/Admin/bootstrap-datetimepicker.min.css" rel="stylesheet"	type="text/css" />
<link href="CSS/Admin/bootstrap-combined.min.css" rel="stylesheet"	type="text/css" /> -->
<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet" />
<link href="CSS/newUI/modern-business.css" rel="stylesheet"/>
<link href="CSS/newUI/custome.css" rel="stylesheet"/>
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css"/>
	
	
	
	<script type="text/javascript">
	
	$(document).scroll(function() {
		var y = $(this).scrollTop();
		if (y > 100) {
			$('.topimg').fadeIn();
		} else {
			$('.topimg').fadeOut();
		}
	});
</script>

<style>

.save:hover {
	cursor: pointer;
}
</style>



</head>

<body>
	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span id="pageHeading">Add AcademicYear Plan</span>
			
		</p>
			
						<div class="errormessagediv" style="display: none;margin-left: 30%;width: 100% !important;">
							<div class="message-item">
								<!-- Warning -->
								<a href="#" class="msg-warning bg-msg-warning" style="text-align: center;"><span
									class="validateTips" style="text-align: center;"></span></a>
							</div>
						</div>
				
			
				<center>
					<logic:present name="successMessage" scope="request">
						<div class="successmessagediv">
							<div class="message-item">
								<!-- Warning -->
								<a href="#" class="msg-success bg-msg-succes"><span><bean:write	name="successMessage" scope="request" /></span></a>
							</div>
						</div>
					</logic:present>
					
						<logic:present name="errorMessage" scope="request">
							<div class="successmessagediv">
								<div class="message-item">
									<!-- Warning -->
									<a href="#" class="msg-warning bg-msg-warning"><span>
											<bean:write name="errorMessage" scope="request" />
									</span></a>
								</div>

							</div>
						</logic:present>
		          </center>
						
	
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-primary">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;AcademicYear Plan
							</a>
						</h4>

							<div class="navbar-right" >
								
								 <span class="save2">
									
									 <img src="images/save.png" id="save" data-toggle="tooltip" data-placement="bottom" title="Save"/>
								
								</span>
								
								<a	href="adminMenu.html?method=acdamicYearPlanList">
								
								<span class="glyphicon glyphicon-list2" data-toggle="tooltip" data-placement="bottom" title="List">
							
								</span>
								
								</a>
							</div>
				
						<script>
				$(document).ready(function() {
					$('[data-toggle="tooltip"]').tooltip();
				});
			</script>
					</div>

					
			<form id="AcadamicYearPlanForm" action="acadamicYearPlan.html?method=insertAcadamicYearPlan" method="post" enctype="multipart/form-data">	
		       <div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							<div class="col-md-6"
								style="font-size: 11pt; font-family: Open Sans Light;color: #5d5d5d;">
								
								<input type="hidden" name="heventId"  id="heventId" value="<logic:present name="AcadamicYearPlanDetails"  scope="request"><bean:write name="AcadamicYearPlanDetails" property="eventid"/></logic:present>"/>
								<input type="hidden" name="hFile"  id="hFile" value="<logic:present name="AcadamicYearPlanDetails"  scope="request"><bean:write name="AcadamicYearPlanDetails" property="file"/></logic:present>"/>
								
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Title</label>
									<div class="col-xs-7">
									
											<input type="text" name="title" class="form-control" id="title"  maxlength="100"
											  placeholder="" value="<logic:present name="AcadamicYearPlanDetails"  scope="request"><bean:write name="AcadamicYearPlanDetails" property="title"/></logic:present>"/>
									</div>
								</div>
								<br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Week Day</label>
									<div class="col-xs-7">
											<input type="text" name="dayOfWeekId" id="dayOfWeekId" class="form-control" readonly="readonly" value="<logic:present name="AcadamicYearPlanDetails"  scope="request"><bean:write name="AcadamicYearPlanDetails" property="weekday"/></logic:present>"/>
									</div>
								</div>
								
							    <br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">End Time</label>
									<div class="col-xs-7">
				                          <div id="datetimepicker4" class="input-append"	style="width: 100%;">
												<input type="text" data-format="hh:mm:ss" 
													readonly="readonly" name="endtime" id="endtime"  class="form-control"  value="<logic:present name="AcadamicYearPlanDetails"  scope="request"><bean:write name="AcadamicYearPlanDetails" property="endtime"/></logic:present>"/> <span class="add-on"> 
													<!-- <img src="images/time2.png" width="25"	height="8" /> -->
													<img
											src="./images/time1.jpg" width="30" height="30"
											class="add-on" style="margin-left: 88%; margin-top: -12%;" />
												</span>
											</div>	
									</div>
								</div>
								
								 <br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Description</label>
									<div class="col-xs-7">
									  <textarea style="font-size: 12px;resize:none;" rows="4" class="form-control" maxlength="250"
											name="description" id="description"  ><logic:present name="AcadamicYearPlanDetails"  scope="request"><bean:write name="AcadamicYearPlanDetails" property="description"/></logic:present></textarea>
									</div>
								</div>
								
						
								
							</div>
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								
								<div class="form-group">
								   <label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;"> Date</label>
									<div class="col-xs-7">
											<input type="text"readonly="readonly" name="date" id="date" class="form-control" placeholder="" value="<logic:present name="AcadamicYearPlanDetails"  scope="request"><bean:write name="AcadamicYearPlanDetails" property="date"/></logic:present>"/>
									</div>
								</div>
								
								<br />
								
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Start Time</label>
									<div class="col-xs-7">
											<div id="datetimepicker3"	class="input-append" style="width:100%;">
												<input type="text" data-format="hh:mm:ss" readonly="readonly" name="starttime" id="starttime" class="form-control" value="<logic:present name="AcadamicYearPlanDetails"  scope="request"><bean:write name="AcadamicYearPlanDetails" property="starttime"/></logic:present>"/><span class="add-on"><!-- <img src="images/time2.png"
													width="30" height="8"  align="top"/> -->
													<img
											src="./images/time1.jpg" width="30" height="30"
											class="add-on" style="margin-left: 88%; margin-top: -12%;" />
												</span>
							               </div>
									</div>
								</div>
								
								<br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Invitation File</label>
									<div class="col-xs-7">
											<input type="file"  name="file" id="file" class="form-control" placeholder="Click Here" />
										<!-- 	
											<input type="button" id="document1btn" name="profile" class="downloadDoc" value="Download" />
										<span style="font-size:20px;color:red;cursor:pointer;" id="deleteProfile">  x</span>		
											
										 -->
										
										<input type="button"  name="download" id="<logic:present name="AcadamicYearPlanDetails"  scope="request"><bean:write name="AcadamicYearPlanDetails" property="file"/></logic:present>" class="download" placeholder="Click Here" value="download"/>
										<span style="font-size:20px;color:red;cursor:pointer;" id="deleteProfile">  x</span>		
									</div>
								</div>
								
								<%-- <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;"></label>
									<div class="col-xs-7">
											<input type="button"  name="download" id="<logic:present name="AcadamicYearPlanDetails"  scope="request"><bean:write name="AcadamicYearPlanDetails" property="file"/></logic:present>" class="download" placeholder="Click Here" value="download"/>
									</div>
								</div>  --%>
								
							</div>
							
						
						</div>
					</div>
				</form>
					<!-- <button type="reset" class="btn btn-info" id="clear">Clear</button> -->
					<br />
				</div>
		</div>
		
	</div>
</body>
</html>