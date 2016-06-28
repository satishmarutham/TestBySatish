<!DOCTYPE html>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<script type="text/javascript" src="JS/newUI/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery-ui.custom.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.tooltip.js"></script>
<script type="text/javascript" src="JS/newUI/bootstrap.min.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet">
<link href="CSS/newUI/modern-business.css" rel="stylesheet">
<link href="CSS/newUI/custome.css" rel="stylesheet">
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript" src="JS/backOffice/Parents/StudentInformation.js"></script>

<style>
.save:hover {
	cursor: pointer;
}
</style>

</head>

<body>
	<div class="col-md-10"
		style="font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<div class="col-md-7" id="div2">


			<p style="margin: 20px 0px;">
				<img src="images/addstu.png" />&nbsp;<span id="pageHeading">Student
					Information</span>
			</p>
		</div>

		<div class="input-group col-md-5" style="margin: 20px 0px;">

			<div class="form-group">
				<label for="inputPassword" class="control-label col-xs-3"
					style="text-align: left; line-height: 35px; color: #797676; font-size: 16px; font-family: Open Sans Light;">Student</label>
				<div class="col-xs-7">
					
						<logic:present name="studentlist" scope="request">
					<select class="form-control" name="studSectionId" id="parentchild">
 											<logic:iterate id="stream" name="studentlist" scope="request">
											<option value='<bean:write name='stream' property='stdAdmisiionNo'/>'>
											<bean:write name='stream' property='studentFnameVar'/></option>
										    </logic:iterate>
							                </select>
											</logic:present>
						
				</div>
			</div>


		</div>
		
	
	<input type="hidden" name="hiddenid" class="hiddenclass" id="stuhiddenid" 
							value='<logic:present name="studentexam"><bean:write name="studentexam" />
													</logic:present>'></input>
													
<input	type="hidden" name="parenthidden" id="parenthidden" value="<logic:present name="parenthiddenid" ><bean:write name="parenthiddenid" property="parentID"/></logic:present>"/>	
<input	type="hidden" name="hiddenstudentid" id="stuinfostudentId" value='<logic:present name="studentexam"><bean:write name="studentexam" />
													</logic:present>'></input>		
		
		
		
		
		
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

			<logic:present name="duplicateMessage" scope="request">

				<div class="successmessagediv">
					<div class="message-item">
						<!-- Warning -->
						<a href="#" class="msg-warning bg-msg-warning"><span> <bean:write
									name="duplicateMessage" scope="request" />
						</span></a>
					</div>

				</div>

			</logic:present>

			<div class="errormessagediv1" style="display: none;">
				<div class="message-item1">
					<!-- Warning -->
					<a href="#" class="msg-warning1 bg-msg-warning1"
						style="width: 30%;"><span class="validateTips1"></span></a>
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
		<form action="" enctype="multipart/form-data" id="formstudent"
			method="post">



	

			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Student Details
							</a>


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
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								
								
								<div class="form-group">
								
							
									<div class="col-xs-3">
										<img src="#" id="imagePreview" alt="image"  class="previewimg"/>
									</div> 
								</div><br/><br/><br/>
								
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">First

										Name &nbsp;&nbsp; :
									</label>


				<span class="newspan"><logic:present name="studentdetails"  scope="request">
				<bean:write name="studentdetails" property="studentFirstName"></bean:write>
				</logic:present></span>

								
								</div>
								<br />

				<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Last
										Name&nbsp;&nbsp;:</label>
										
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="studentLastName"></bean:write>
				</logic:present></span>
								
								</div>
								<br />



								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Admission

										No &nbsp;&nbsp; :
									</label>

									<span class="newspan">
									<logic:present name="studentdetails"  scope="request">
				<bean:write name="studentdetails" property="studentAdmissionNo"></bean:write>
				</logic:present>
									
									</span>
									
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Admission

										Date &nbsp;&nbsp; :
									</label>

									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="dateofJoin"></bean:write>
				</logic:present></span>
									
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Stream &nbsp;&nbsp; :</label>
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="streemname"></bean:write>
				</logic:present></span>
									
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Section &nbsp;&nbsp; :</label>
									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="sectionnaem"></bean:write>
				</logic:present></span>
								
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Grade &nbsp;&nbsp; :</label>
									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="grade"></bean:write>
				</logic:present></span>
									
								</div>
								<br />

								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px; padding: 0;">Concession

										Applicable &nbsp;&nbsp; :
									</label>

									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="isconcession"></bean:write>
				</logic:present></span>
									
								</div>

								<br />
								<div class="form-group" id="cencessionlable">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Concession &nbsp;&nbsp; :
									</label>
									<span class="newspan"><logic:present name="concession" scope="request">
				<bean:write name="studentdetails" property="studentFirstName"></bean:write>
				</logic:present></span>
								
								</div>
								<br />
								
							</div>
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								
								
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Transport&nbsp;&nbsp;:</label>
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="transport"></bean:write>
				</logic:present></span>
										
									
								</div>
								<br />

								<div class="form-group" id="transportcategorylabel">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Transport

										Category&nbsp;&nbsp;: 
									</label>

									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="transporttypeName"></bean:write>
				</logic:present></span>
									
								</div>
								<br />
								<div class="form-group" id="transportlocationlabel">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">

										Transport Location&nbsp;&nbsp;:  
									</label>

									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="transportlocationName"></bean:write>
				</logic:present></span>
								
								</div>						
								<br/>
								
								
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Application

										No&nbsp;&nbsp;:
									</label>

									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="applicationNo"></bean:write>
				</logic:present></span>
									
								
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Academic

										Year&nbsp;&nbsp;: 
									</label>

										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="academicYear"></bean:write>
				</logic:present></span>
								
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;"> class&nbsp;&nbsp;:</label>
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="classname"></bean:write>
				</logic:present></span>
								
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Quota&nbsp;&nbsp;:</label>
										
										
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="studentquotaname"></bean:write>
				</logic:present></span>
										
								
								</div>
								<br />


								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">EMIS
										Number&nbsp;&nbsp;:</label>
										
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="emisNo"></bean:write>
				</logic:present></span>
									
								</div>
								<br />


								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"

										style="text-align: right; line-height: 35px;">RTE&nbsp;&nbsp;:
									</label>

									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="rte"></bean:write>
				</logic:present></span>
								
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Hostel&nbsp;&nbsp;:</label>
										
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="hostel"></bean:write>
				</logic:present></span>
								
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
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Personal Information
							</a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body">
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Date Of

										Birth&nbsp;&nbsp;:  
									</label>

										
									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="dateofBirth"></bean:write>
				</logic:present></span>
									
									
								</div>
								<br />

								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Gender&nbsp;&nbsp;: </label>
										
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="gender"></bean:write>
				</logic:present></span>
							
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Blood

										Group&nbsp;&nbsp;: 
									</label>

										
									
									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="bloodGroup"></bean:write>
				</logic:present></span>
								
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Caste&nbsp;&nbsp;: </label>
										
									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="studentcastename"></bean:write>
				</logic:present></span>	
									
								</div>
								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Nationality&nbsp;&nbsp;: </label>
								
								<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="nationality"></bean:write>
				</logic:present></span>
								
									
								</div>

								<br />
								

							</div>
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Age&nbsp;&nbsp;:</label>
									
									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="age"></bean:write>
				</logic:present></span>
									
								</div>
								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Identification
										Marks&nbsp;&nbsp;:</label>
									
									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="identificationMarks"></bean:write>
				</logic:present></span>
									
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Religion&nbsp;&nbsp;:</label>
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="religion"></bean:write>
				</logic:present></span>
									
								</div>
								<br />
							
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-5"
										style="text-align: right; line-height: 35px;">Physically

										Challenged&nbsp;&nbsp;: 
									</label>

										

									
									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="physicallyChallenged"></bean:write>
				</logic:present></span>
								
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Remark's&nbsp;&nbsp;: </label>
								
								<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="remarks"></bean:write>
				</logic:present></span>
							
								</div>

								
							
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingThree">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseThree"
								style="color: #767676" aria-expanded="false"
								aria-controls="collapseThree"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Parent Information
							</a>
						</h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingThree">
						<div class="panel-body">
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Sibling
										Name&nbsp;&nbsp;:</label>
										
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="sibilingName"></bean:write>
				</logic:present></span>
								
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Sibling
										class&nbsp;&nbsp;:</label>
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="sibilingClass"></bean:write>
				</logic:present></span>
								
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Father's
										Name&nbsp;&nbsp;: 
									</label>

								
									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="fatherName"></bean:write>
				</logic:present></span>
									
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Mobile

										Number&nbsp;&nbsp;: 
									</label>

										

									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="fatherMobileNo"></bean:write>
				</logic:present></span>
								
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Mother's

										Name&nbsp;&nbsp;: 
									</label>

									

									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="motherName"></bean:write>
				</logic:present></span>
									
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Mobile

										Number&nbsp;&nbsp;:  
									</label>

									

									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="motherMobileNo"></bean:write>
				</logic:present></span>
									
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Guardian's
										Name&nbsp;&nbsp;: </label>
										
											<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="guardianName"></bean:write>
				</logic:present></span>
									
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Email Id&nbsp;&nbsp;:</label>
										
											<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="guardianemailId"></bean:write>
				</logic:present></span>
									
								</div>

								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Father's
										Occupation&nbsp;&nbsp;: </label>
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="fatheroccupation"></bean:write>
				</logic:present></span>
								
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Address&nbsp;&nbsp;:
									</label>
									<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="address"></bean:write>
				</logic:present></span>
									
								</div>
								<br />
							</div>
							
						
								
								
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">	
								
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Qualification&nbsp;&nbsp;:</label>
										
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="fatherQualification"></bean:write>
				</logic:present></span></div>
								
								
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Email Id&nbsp;&nbsp;:</label>
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="fatheremailId"></bean:write>
				</logic:present></span>
								
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Qualification&nbsp;&nbsp;:</label>
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="motherQualification"></bean:write>
				</logic:present></span>
									
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Email Id&nbsp;&nbsp;:</label>
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="motheremailId"></bean:write>
				</logic:present></span>
									
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Mobile
										Number&nbsp;&nbsp;:</label>
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="guardianMobileNo"></bean:write>
				</logic:present></span>
									
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"

										style="text-align: right; line-height: 35px;">Guardian's Occupation&nbsp;&nbsp;: </label>
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="quardianoccupation"></bean:write>
				</logic:present> </span>
									
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"

										style="text-align: right; line-height: 35px;">Mother's Occupation&nbsp;&nbsp;:  </label>
										<span class="newspan"><logic:present name="studentdetails" scope="request">
				<bean:write name="studentdetails" property="motheroccupation"></bean:write>
				</logic:present> </span>
									
								</div>
								
								
								</div>
							</div>
						</div>
					</div>
				

				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingfour">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapsefour"
								style="color: #767676" aria-expanded="false"
								aria-controls="collapsefour"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Document Details
							</a>
						</h4>
					</div>
					<div id="collapsefour" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingfour">
						<div class="panel-body">
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Birth
										Certificate</label>
										<span class="newspan">
										<input type="file" id="uploadBirth" name="birthFile"
											class="custom-file-uploadfile" style="height: 20%;" />
											
										<input type="button" id="document2btn" name="idproof" class="downloadDoc" value="Download" />
										<span id="downloadIdTitle"> downloadBirthCertificate</span>
										
											
											</span>
									
								</div>
								<br />
							</div>
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Transfer
										Certificate</label>
									<div class="col-xs-7">
										<input type="file" id="uploadTransfer" name="transferFile"
											readonly="readonly" class="custom-file-uploadfile"
											style="height: 20%;" />
											<input type="button" id="document1btn" name="profile" class="downloadDoc" value="Download" />
										<span id="downloadProfileTitle"> downloadTransferCertificate</span>
										
									</div>
								</div>
							</div>
						</div>
					</div>
					<input type="hidden" name="parentId" id="parentId" /> <input
						type="hidden" name="sibilingClassId" id="sibilingClassID" /><br />
					<input type="hidden" name="selected_Primary_Id"
						id="selected_Primary_Id" /> <input type="hidden"
						id="trnporttypestatus" /> <input type="hidden"
						name="studentIDgenerator" id="studentIDgeneratorId" /> <input
						type="hidden" name="previousParentId" id="previousParentId" /> <br />
					
	                    	
							<input type="hidden" name="defaultimage"	id="hiddenimage" value="<logic:present name="studentdetails" ><bean:write name="studentdetails" property="studentimage" /></logic:present>"  />
							<input type="hidden" name="defaultidproof"	id="hiddenidproof" value="<logic:present name="studentdetails" ><bean:write name="studentdetails" property="transferfile" /></logic:present>"  />
							<input type="hidden" name="defaultprofile"	id="hiddenprofile" value="<logic:present name="studentdetails" ><bean:write name="studentdetails" property="birthcertificate" /></logic:present>"  />				
					
					
				</div>
			</div>
			</div>
		</form>
		
	

		</body>
</html>
