<!DOCTYPE html>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html lang="en">

<head>

<title>eCampus Pro</title>

<link href="CSS/newUI/custome.css" rel="stylesheet">
<script type="text/javascript" src="JS/backOffice/Staff/StaffEmployement.js"></script>
<script type="text/javascript" src="JS/common.js"></script>


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
		<div class="col-md-8" id="div2">

			<p style="margin: 16px 0px;">
				<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<span
					id="pageHeading">Staff Employment Details</span>
			</p>
		</div>
		<div class="input-group col-md-4" style="margin: 20px 0px;">

			<input type="text" class="form-control" id="searchname" Placeholder="Search......">
			<span class="input-group-btn">
				<button class="btn btn-default" type="button" id="searchbtn" >
					<i class="fa fa-search"></i>
				</button>
			</span>
		</div>
		
		<logic:present name="successmessagediv" scope="request">
						<div class="successmessagediv" align="center">
							<div class="message-item">
								<!-- Warning -->
								<a href="#" class="msg-success bg-msg-succes"><span><bean:write
											name="successmessagediv" scope="request" /></span></a>
							</div>
						</div>
		</logic:present>
		
		
						<logic:present name="errorMessage" scope="request">

							<div class="successmessagediv" align="center">
								<div class="message-item">
									<!-- Warning -->
									<a href="#" class="msg-warning bg-msg-warning"><span>
											<bean:write name="errorMessage" scope="request" />
									</span></a>
								</div>

							</div>

						</logic:present>
		
			<div class="errormessagediv"  align="center" style="display: none;">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-warning bg-msg-warning"><span
						class="validateTips"></span></a>
				</div>
			</div>
		
		<div class="panel panel-primary">
			<div class="panel-heading">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#collapseOne" style="color: #fff;"><h3
						class="panel-title" style="color: #767676;vertical-align: middle;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;Staff
						Employment
					</h3></a>
					
				<div class="navbar-right" >
				
					
<!-- 					<img src="images/rightline.png" class="rightimg">
 -->					
					 	<span id="editTeacher" class="glyphicon glyphicon-pencil3"  data-toggle="tooltip" data-placement="bottom" title="Edit"></span>
					  
                       <img src="images/download.png" class="download" id="iconsimg" style="    margin-left: 1px;"
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
							requestURI="/adminMenu.html?method=staffEmployementList" export="false" pagesize="10"
							decorator="com.centris.campus.decorator.AllTeacherDetailsDecorator">
							<display:column property="check" sortable="true"
								title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />" />


							<display:column property="registartionNo" sortable="true"
								title="Teacher Id <img src='images/sort1.png' style='float: right'/>" />
							<display:column property="teacherName" sortable="true"
								title="Teacher Name <img src='images/sort1.png' style='float: right'/>" />
							
							<display:column property="department" sortable="true"
								title="Department <img src='images/sort1.png' style='float: right'/>" />
							<display:column property="bankaccountNo" sortable="true"
								title="Account No <img src='images/sort1.png' style='float: right'/>" />
							<display:column property="pfnumber" sortable="true"
								title="Employee Pf No <img src='images/sort1.png' style='float: right'/>" />
							<display:column property="ctc" sortable="true"
								title="CTC <img src='images/sort1.png' style='float: right'/>" />
					


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
		})
	</script>
</body>
</html>