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
	src="JS/backOffice/Admin/StaffAttendance.js"></script>

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
		style="font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">

		<div class="col-md-7" id="div2">

			<p style="margin: 16px 0px;">
				<img src="images/addstu.png" />&nbsp;<span>Staff</span>
			</p>
		</div>

		<div class="input-group col-md-5">
		
		
			
			<label  class="hedderstyle form-control" style="margin: 20px 0px; width: 20% !important; border: none;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;">Department</label> 
		
							
			<select id="department" style="width: 30%; margin: 20px 0px; margin-left: 3%;" class="form-control">
			
			<option value="all">All</option>
			<logic:iterate id="department" name="departmentList">
			
			<option value="<bean:write name="department" property="depId"/>"><bean:write name="department" property="depName"/></option>
			
			</logic:iterate>
			
			</select>
			
			<label style="margin: 20px 0px; width: 13%; border: none;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;"
				class="form-control">Date</label>
				
			<input type="text" name="year" style="width: 30%; margin: 20px 0px; margin-left: 4%;" 
							id="date" maxlength="25" class="form-control"  readonly="readonly" value="<logic:present name='TodayDate'><bean:write name='TodayDate'/></logic:present>" />
			
			<span class="input-group-btn">
					<button class="btn btn-default" type="button" id="search">
						<i class="fa fa-search"></i>
					</button>
				</span>
<input type="hidden" id="hdeptId" value="<logic:present name="departmentname"><bean:write name="departmentname"/></logic:present>"/>

		</div>


		<center>
			<logic:present name="message" scope="request">
				<div class="successmessagediv">
					<div class="message-item">
						<!-- Warning -->
						<a href="#" class="msg-success bg-msg-succes"><span><bean:write
									name="message" scope="request" /></span></a>
					</div>
				</div>
			</logic:present>
			<logic:present name="error" scope="request">
				<div class="successmessagediv">
					<div class="message-item">
						<!-- Warning -->
						<a href="#" class="msg-warning bg-msg-warning"><span><bean:write
									name="error" scope="request" /></span></a>
					</div>
				</div>
			</logic:present>
			
			<div class="successmessagediv" style="display: none;">
								<div class="message-item">
									<!-- Warning -->
									<a href="#" class="msg-success bg-msg-succes"><span class="successmessage"></span></a>
								</div>
						</div>
			
			<div class="errormessagediv" style="display: none;">
						<div class="message-item">
							<!-- Warning -->
							<a href="#" class="msg-warning bg-msg-warning"><span
								class="validateTips"></span></a>
						</div>
		</div>
			
		</center>


		<div class="panel panel-primary">
			<div class="panel-heading">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#collapseOne" style="color: #fff;"><h3
						class="panel-title" style="color: #767676;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;Staff
						Attendance

					</h3></a>
				<div class="navbar-right" >

					<span class="save2"> <img src="images/save.png"></span>
					 <a href="adminMenu.html?method=getStaffAttendance">
					 	 <span class="glyphicon glyphicon-list2" ></span>
					  </a>

				</div>
			</div>
			<script>
				$(document).ready(function() {
					$('[data-toggle="tooltip"]').tooltip();
				});
			</script>
			<div id="collapseOne" class="accordion-body collapse in">
				<div class="panel-body"
					style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">

					
					<display:table class="table" id="allstudent" style="font-family: Open Sans Light;color: #897676;"
						name="requestScope.attendanceList" pagesize="10"
						requestURI="/staffattendancepath.html?method=staffattendaceUpload">
						
						 
						<display:column property="teacherId" class="hiddenclass" headerClass="hiddenclass"></display:column>
						
						<display:column property="count" sortable="true"
							title="Sno  <img src='images/sort1.png' style='float: right'/>"
							media="html">
									
						</display:column>
						
						<display:column property="regid" sortable="true" 
							title="Teacher Id  <img src='images/sort1.png' style='float: right'/>"
							media="html">
						</display:column>

						<display:column property="teacherName" sortable="true"
							title="Teacher Name <img src='images/sort1.png' style='float: right'/>"
							media="html"></display:column>
							
						<display:column property="designation" sortable="true"
							title="Designation <img src='images/sort1.png' style='float: right'/>"
							media="html"></display:column>
							
						<display:column property="department" sortable="true"
							title="Department <img src='images/sort1.png' style='float: right'/>"
							media="html"></display:column>

						<display:column  sortable="true"
							title="Actual Completion Date  <img src='images/sort1.png' style='float: right'/>"
							media="html">
							<select name="status" class="form-control statusclass" id="${allstudent.teacherId}status">
									<option value="${allstudent.status}">${allstudent.status}</option>
									
									
							</select>
							
							</display:column>

						

						
					</display:table>
					

					
					<br />
					
				</div>
				<br>
			</div>
		</div>

	</div>


</body>
</html>