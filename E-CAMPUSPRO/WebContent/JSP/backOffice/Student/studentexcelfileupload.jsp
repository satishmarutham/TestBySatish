<!DOCTYPE html>
<html lang="en">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>
<head>

<link href="/CSS/newUI/custome.css" rel="stylesheet">

<script type="text/javascript" src="JS/common.js"></script>
<script type="text/javascript"
	src="JS/backOffice/Student/Studentexcelfileupload.js"></script>

<style>
.form-control {
	width: 70%;
}
</style>

</head>

<body>
	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span id="pageHeading">Student
				Excel File Upload</span>
		</p>



		<div class="successmessagediv" align="center" style="display: none;">
			<div class="message-item">
				<!-- Warning -->
				<a href="#" class="msg-success bg-msg-succes"><span
					class="validateTips"></span></a>
			</div>
		</div>


		<div class="errormessagediv" align="center" style="display: none;">
			<div class="message-item">
				<!-- Warning -->
				<a href="#" class="msg-warning bg-msg-warning"><span
					class="validateTips"></span></a>
			</div>
		</div>


		<logic:present name="errorMessage" scope="request">
			<div class="errormessagediv" align="center">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-warning bg-msg-warning"><span><bean:write
								name="errorMessage" scope="request" /></span></a>
				</div>
			</div>
		</logic:present>
		<logic:present name="successmessagediv" scope="request">
			<div class="successmessagediv" align="center">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-success bg-msg-succes"><span><bean:write
								name="successmessagediv" scope="request" /></span></a>
				</div>
			</div>
		</logic:present>


		<form action="uploadStudentXSL.html?method=insertStudentXSL"
			id="excelfileupload" name="UploadStudentXSLForm" method="post"
			enctype="multipart/form-data">
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Student Excel File Upload
							</a>
						</h4>
						<div class="navbar-right" style="margin: -24px -10px;   ">
							<span id="saveid" class="save2" style="  padding: 7px 3px 3px 11px;" > <img
								src="images/save.png" class="save" data-toggle="tooltip"
								data-placement="bottom" title="Upload Student Details">
							</Span>
						</div>
					</div>
					<script>
						$(document).ready(function() {
							$('[data-toggle="tooltip"]').tooltip();
						});
					</script>


					<div class="feebody panel-group" id="accordion" role="tablist"
						aria-multiselectable="true">
						<div id="collapseOne" class="panel-collapse collapse in"
							role="tabpanel" aria-labelledby="headingOne" align="center">
							<div class="panel-body">
								<div class="col-md-6" id="txtstyle" style="padding: 0;">
									<div class="form-group">
										<label for="inputEmail" class="control-label col-xs-4"
											id="inputnames">Choose File</label>
										<div class="col-xs-8">
											<input type="file" name="formFile" id="studentfile"
												class="form-control" style="height: 35px !important;"></input>
										</div>
										<br />
									</div>
								</div>

								<div class="col-md-3" id="txtstyle" style="padding: 0;">
									<a href="uploadStudentXSL.html?method=downloadfileformat">Click
										here for Download File Format</a>
								</div>



								<logic:present name="FailEmployeeList" scope="request">
									<div class="col-md-12"
										style="padding: 0px; height: 250px; overflow: scroll;">
										<p class="theading">
											<span class="displayno"></span>
										</p>

										<%-- 			  					<display:table class="table" id="allstudent"
 --%>

										<%-- 		       <display:table id="tableid" name="requestScope.FailEmployeeList" class="table table-bordered"
 --%>
										<display:table id="allstudent"
											name="requestScope.FailEmployeeList" class="table"
											requestURI="/uploadStudentXSL.html?method=insertStudentXSL">

											<display:column property="studentFirstName"
												title="First Name" headerClass="heading1" />
											<display:column property="studentLastName" title="Last Name"
												headerClass="heading1" />
											<display:column property="studentAdmissionNo"
												title="AdmissionNo" headerClass="heading1" />
											<display:column property="studentRegNo"
												title="Registration No" headerClass="heading1" />
											<display:column property="dateofJoin" title="Date of Join"
												headerClass="heading1" />
											<display:column property="academicYear" title="Academic Year"
												headerClass="heading1" />
											<display:column property="category" title="Stream"
												headerClass="heading1" />
											<display:column property="classname" title="Class Name"
												headerClass="heading1" />
											<display:column property="sectionname" title="Section Name"
												headerClass="heading1" />
											<display:column property="studentquotaname"
												title="Quota Name" headerClass="heading1" />
											<display:column property="grade" title="Grade"
												headerClass="heading1" />
											<display:column property="rte" title="RTE"
												headerClass="heading1" />
											<display:column property="hostel" title="Hostel"
												headerClass="heading1" />
											<display:column property="concession_applicable"
												title="Concession Applicable" headerClass="heading1" />
											<display:column property="concession_type"
												title="Concession Type" headerClass="heading1" />
											<display:column property="transport" title="Transport"
												headerClass="heading1" />
											<display:column property="transcategory"
												title="Tranport Category" headerClass="heading1" />
											<display:column property="translocation"
												title="Transport Location" headerClass="heading1" />
											<display:column property="dateofBirth" title="Date of Birth"
												headerClass="heading1" />
											<display:column property="gender" title="Gender"
												headerClass="heading1" />
											<display:column property="identificationMarks"
												title="Identification Marks" headerClass="heading1" />
											<display:column property="bloodGroup" title="Blood Group"
												headerClass="heading1" />
											<display:column property="religion" title="Religion"
												headerClass="heading1" />
											<display:column property="caste" title="Caste"
												headerClass="heading1" />
											<display:column property="nationality" title="Nationality"
												headerClass="heading1" />
											<display:column property="physicallyChallenged"
												title="Physically Challenged" headerClass="heading1" />
											<display:column property="physicalchalreason"
												title="Physically challenged Reason" headerClass="heading1" />
											<display:column property="studentstatus" title="Status"
												headerClass="heading1" />
											<display:column property="primaryPerson"
												title="Primary Person" headerClass="heading1" />
											<display:column property="fatherName" title="Father Name"
												headerClass="heading1" />
											<display:column property="fatherQualification"
												title="Father Qualification" headerClass="heading1" />
											<display:column property="fatherMobileNo"
												title="Father Mobile No" headerClass="heading1" />
											<display:column property="motherName" title="Mother Name"
												headerClass="heading1" />
											<display:column property="motherQualification"
												title="Mother Qualification" headerClass="heading1" />
											<display:column property="motherMobileNo"
												title="Mother Mobile No" headerClass="heading1" />
											<display:column property="guardianName" title="Guardian Name"
												headerClass="heading1" />
											<display:column property="guardianMobileNo"
												title="Guardian Mobile Number" headerClass="heading1" />
											<display:column property="address" title="Address"
												headerClass="heading1" />
											<display:column property="reason" title="Reason"
												headerClass="heading1" />


										</display:table>

									</div>
									<div class="paginationbox">
										<p class="paginationp"></p>
									</div>


								</logic:present>


							</div>

						</div>

					</div>

				</div>

			</div>

		</form>
</body>

</html>
