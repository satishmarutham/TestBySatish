<!DOCTYPE html>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>
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
	src="JS/backOffice/Teacher/AttendaceUpload.js"></script>

<title>eCampus Pro</title>

<style>
#editDesignationId:hover {
	cursor: pointer;
}

#trash:hover {
	cursor: pointer;
}
.hiddenclass{

	display: none;
}
</style>

</head>

<body>
	<div class="col-md-10"
		style="font-size: 16pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span id="pageHeading">Student Attendance
				</span>
		</p>
		<center>
			<logic:present name="successMessage" scope="request">

				<div class="successmessagediv">
					<div class="message-item">
						<!-- Warning -->
						<a href="#" class="msg-success bg-msg-succes"><span> <bean:write
									name="successMessage" scope="request" />
						</span></a>
					</div>
				</div>

			</logic:present>

			<logic:present name="errorMessage" scope="request">

				<div class="successmessagediv">
					<div class="message-item">
						<!-- Warning -->
						<a href="#" class="msg-warning bg-msg-warning"><span> <bean:write
									name="errorMessage" scope="request" />
						</span></a>
					</div>

				</div>

			</logic:present>

			
				<div class="successmessagediv" style="display: none;">
								<div class="message-item">
									<!-- Warning -->
									<a href="#" class="msg-success bg-msg-succes"><span class="successmessage"></span></a>
								</div>
						</div>

		</center>
		<center>
		
			<div class="errormessagediv" style="display: none;">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-warning bg-msg-warning"><span
						class="validateTips"></span></a>
				</div>
			</div>

		</center>
		<form action="studentRegistration.html?method=saveStudentRegistration"
			enctype="multipart/form-data" id="formstudent" method="post" >
			
			
			<!-- chiru -->

			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne"
								style="color: #767676; vertical-align: middle;"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Student Details
							</a>
						</h4>

						<div class="navbar-right">
						
						<span id="saveAttendance" class="save2"><img src="images/save.png"></span>

							 <a href="teachermenuaction.html?method=attendaceStatus"> 
							 	<span class="glyphicon glyphicon-list2" data-toggle="tooltip" data-placement="bottom" title="List"></span>
							</a>
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

							<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4" style="text-align: right; line-height: 35px;"
										id="inputnames">Class</label>
									<div class="col-xs-7">
										<select id="classId" name="classname" class="form-control"
											required>
											<option value=""></option>

										</select>
									</div>
							</div>
							
								<br />
								
							<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Attendance Date</label>
									<div class="col-xs-7">
										<input type="text" name="date" readonly="readonly"
											onkeypress="HideError()" id="date"
											maxlength="25" class="form-control"
											value=''/>
									</div>
								</div>
								
							</div>
							
							<div class="col-md-6" id="txtstyle">

								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										id="inputnames" style="text-align: right; line-height: 35px;">Section</label>
									<div class="col-xs-7">
										<select id="section" name="section" class="form-control"
											required>
											<option value=""></option>

										</select>
									</div>
								</div>
								<br />
								
								
							</div>
							
							<button type="button" class="btn btn-info col-md-offset-5" id="search">Filter Students</button>
			<br></br>
							
				<logic:present name="attendanceList">	
				
					<input type="hidden" id="hclass" value='<logic:present name='classId'><bean:write name="classId"/></logic:present>'/>
					<input type="hidden" id="hsection" value='<logic:present name='section'><bean:write name="section"/></logic:present>'/>
					<input type="hidden" id="hdate" value='<logic:present name='date'><bean:write name="date"/></logic:present>'/>	
							
				<display:table class="table" id="allstudent" style="font-family: Open Sans Light;color: #897676;"
						name="requestScope.attendanceList" 
						requestURI="/staffattendancepath.html?method=staffattendaceUpload">
						
						 
						<display:column property="studentid" class="hiddenclass" headerClass="hiddenclass"></display:column>
						
						<display:column property="count" sortable="true"
							title="Sno  <img src='images/sort1.png' style='float: right'/>"
							media="html">
									
						</display:column>
						
						<display:column property="addmissionNo" sortable="true" 
							title="Admission Number  <img src='images/sort1.png' style='float: right'/>"
							media="html">
						</display:column>

						<display:column property="studentname" sortable="true"
							title="Student Name <img src='images/sort1.png' style='float: right'/>"
							media="html"></display:column>
							
						<display:column  sortable="true"
							title="Attendance Status  <img src='images/sort1.png' style='float: right'/>"
							media="html">
							<select style="width:80%;"name="status" class="form-control statusclass" id="${allstudent.studentid}status">
									<option value="${allstudent.status}">${allstudent.status}</option>
									
							</select>
							
							<img  src="images/TimeTableImg.png" id="${allstudent.studentid},${allstudent.studentname}" class="GetTimeTable" style="width: 20px;height: 20px;float: right;margin-right: 25px;margin-top: -30px;">
							
							</display:column>

						

						
					</display:table>
					
				</logic:present>	
							
							
						</div>
					</div>
					
				</div>
			</div>
			
		</form>
	</div>
</html>









