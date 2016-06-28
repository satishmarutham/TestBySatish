<!DOCTYPE html>
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

<title>eCampus Pro</title>
<script type="text/javascript" src="JQUERY/jquery-1.9.1.js"></script>
<script type="text/javascript" src="JS/common.js"></script>
<script type="text/javascript" src="JS/newUI/jquery-1.9.1.min.js"></script>


<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet">
<link href="CSS/newUI/modern-business.css" rel="stylesheet">
<link href="CSS/newUI/custome.css" rel="stylesheet">
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="JS/backOffice/Staff/StaffDetails.js"></script>
<style>
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
		<div class="col-md-8" id="div2">

			<p style="margin: 16px 0px;">
				<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<span
					id="pageHeading">Staff Details</span>
			</p>
		</div>

		<form id="searchForm"
			action="teacherregistration.html?method=searchStaffDetails"
			method="post">
			<div class="input-group col-md-4" style="margin: 20px 0px;">

				<input type="text" name="searchname" id="searchname"
					class="form-control" Placeholder="Search......"> <span
					class="input-group-btn">
					<button class="btn btn-default" type="button" id="search">
						<i class="fa fa-search"></i>
					</button>
				</span>

			</div>
		</form>
		<div class="errormessagediv" style="display: none;">
			<div class="message-item">
				<!-- Warning -->
				<a href="#" class="msg-warning bg-msg-warning"><span
					class="validateTips"></span></a>
			</div>
		</div>

		<logic:present name="successmessagediv" scope="request">
			<div class="successmessagediv">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-success bg-msg-succes"><span><bean:write
								name="successmessagediv" scope="request" /></span></a>
				</div>
			</div>
		</logic:present>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#collapseOne" style="color: #fff;"><h3
						class="panel-title" style="color: #767676;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;Staff
						Details
					</h3></a>
				<div class="navbar-right">
				
					
					
					 <a	href="teacherregistration.html?method=getTeachers">
					 <span class="glyphicon glyphicon-plus"
						data-toggle="tooltip" data-placement="bottom" title="Add">
						</span>
					</a>
					
					 
					 <span class="glyphicon glyphicon-pencil" id="editTeacher"
						style="cursor: pointer"
						data-toggle="tooltip" data-placement="bottom" title="Edit">
					</span>

					
					
					 <span class="glyphicon glyphicon-trash" id="deleteTeacher"
						style="cursor: pointer"
						data-toggle="tooltip" data-placement="bottom" title="Delete">
					</span>
					
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
					<!-- <table class="table" id="allstudent"> -->


					<logic:present name="allTeacherDetailsList" scope="request">
						<display:table class="table" id="allstudent"
							name="requestScope.allTeacherDetailsList"
							requestURI="/adminMenu.html" export="false" pagesize="10"
							decorator="com.centris.campus.decorator.AllTeacherDetailsDecorator">
							<display:column property="check" sortable="true"
								title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />" />

							<display:column property="teacherName" sortable="true"
								title="Teacher Name <img src='images/sort1.png' style='float: right'/>" />
							<display:column property="mobileNo" sortable="true"
								title="Mobile No <img src='images/sort1.png' style='float: right'/>" />
							<display:column property="qualification" sortable="true"
								title="Qualification <img src='images/sort1.png' style='float: right'/>" />
							<display:column property="designation" sortable="true"
								title="Designation <img src='images/sort1.png' style='float: right'/>" />
							<display:column property="email" sortable="true"
								title="Email <img src='images/sort1.png' style='float: right'/>" />



							<display:setProperty name="export.pdf.filename"
								value="AllEmployee.pdf" />
							<display:setProperty name="export.pdf" value="true" />
							<display:setProperty name="export.excel.filename"
								value="AllEmployee.xls" />
							<display:setProperty name="export.excel" value="true" />
							<display:setProperty name="export.csv.filename"
								value="AllEmployee.csv" />
							<display:setProperty name="export.csv" value="true" />
							<display:setProperty name="export.xml.filename"
								value="AllEmployee.xml" />
							<display:setProperty name="export.xml" value="true" />
						<%-- 	<display:column sortable="true"
								title="Salary Details <img src='images/sort1.png' style='float: right'/>">
								<input type="button" name="getsalary" onClick='salaryDeatails()'
									value="Get Salary Details"
									id="${defaulttable.empid},${defaulttable.empname},${defaulttable.emplyee_role}"> </>
						</display:column> --%>


						</display:table>

					</logic:present>
				
				</div>
				<br />
			</div>
		</div>
	</div>

	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		});
	</script>
</body>
