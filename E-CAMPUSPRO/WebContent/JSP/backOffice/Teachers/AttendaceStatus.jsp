<!DOCTYPE html>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
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
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="JS/backOffice/Teacher/AttendaceUpload.js"></script>
<script type="text/javascript" src="JS/common.js"></script>
<title>eCampus Pro</title>

<style>
#editDesignationId:hover {
	cursor: pointer;
}

#trash:hover {
	cursor: pointer;
}

.download:hover{

cursor: pointer;
}
#excelDownload:hover {
	cursor: pointer;
}
#pdfDownload:hover {
	cursor: pointer;
}
</style>
</head>

<body>

	<div class="col-md-10" id="div1">
		<div class="col-md-6" id="div2">

			<p style="margin: 16px 0px;">
				<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<span
					id="pageHeading">Student Attendance</span>
			</p>
		</div>

		
		
		<div class="input-group col-md-6">
			
			<label  class="hedderstyle form-control" style="margin: 20px 0px; width: 20% !important; border: none;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;">Start Date</label> 
		
			<input type="text" name="year" style="width: 30%; margin: 20px 0px; margin-left: 0%;" 
							id="startdate" maxlength="25" class="form-control"  readonly="readonly" value="<logic:present name='StartDate'><bean:write name='StartDate'/></logic:present>" />
			
			<label style="margin: 20px 0px; width: 21%; border: none;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;"
				class="form-control">End Date</label>
				
			<input type="text" name="year" style="width: 30%; margin: 20px 0px; margin-left: -1%;" 
							id="enddate" maxlength="25" class="form-control"  readonly="readonly" value="<logic:present name='EndDate'><bean:write name='EndDate'/></logic:present>" />
							
			<span class="input-group-btn">
					<button class="btn btn-default" type="button" id="searchAttendanceList">
						<i class="fa fa-search"></i>
					</button>
				</span>


		</div>


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


		<div class="panel panel-primary">
			<div class="panel-heading">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#collapseOne" style="color: #fff;"><h3
						class="panel-title" style="color: #767676;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;Student Attendance
					</h3></a>
				<div class="navbar-right">
				
					<a href="StudentAttendanceActionPath.html?method=studentattendaceUploadEntry" style="margin: 0px 12px 0px 0px;"
						id="plus"><span class="glyphicon glyphicon-plus"></span> </a>
						
					<img src="images/download.png" class="download" id="iconsimg"
						data-toggle="modal" data-target="#myModal" data-toggle="tooltip"
						data-placement="bottom" title="Download">

				</div>
				<script>
				$(document).ready(function() {
					$('[data-toggle="tooltip"]').tooltip();
				});
			</script>
			</div>
			<!-- pop up -->

			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Download</h4>
						</div>
						<div class="modal-body">
							<span id="excelDownload"><img src="images/xl.png"
								class="xl"></span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
								id="pdfDownload"><img src="images/pdf.png" class="pdf"></span>
						</div>

					</div>
				</div>
			</div>
			<div id="collapseOne" class="accordion-body collapse in">
				<div class="panel-body"
					style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">

					<display:table name="requestScope.attendancelist"
						requestURI="adminMenu.html?method=getStaffAttendance"
						pagesize="10" export="false" class="table" id="allstudent">


						<display:column property="count" sortable="true"
							title="Sno<img src='images/sort1.png' style='float: right'/>" />
						<display:column property="date" sortable="true"
							title="Attendance Date<img src='images/sort1.png' style='float: right'/>" />
							
							<display:column property="classsection" sortable="true"
							title="Class&Section<img src='images/sort1.png' style='float: right'/>" />
							
						<display:column property="tot_count" sortable="true"
							title="Total Strength<img src='images/sort1.png' style='float: right'/>" />
						<display:column property="present_count" sortable="true"
							title="Total Present<img src='images/sort1.png' style='float: right'/>" />
						<display:column property="absent_count" sortable="true"
							title="Total Absent<img src='images/sort1.png' style='float: right'/>" />
						<display:column property="holiday_count" sortable="true"
							title="Total Holiday<img src='images/sort1.png' style='float: right'/>" />
						<display:column property="leave_count" sortable="true"
							title="Total Leave<img src='images/sort1.png' style='float: right'/>" />

						<display:setProperty name="paging.banner.page.separator" value=""></display:setProperty>

						<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>

					</display:table>

				</div>
				<br />
			</div>
		</div>
	</div>


</body>
</html>