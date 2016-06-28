<!DOCTYPE html>
<html lang="en">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>
<head>

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect-blind.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript"
	src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>

<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet" />
<link href="CSS/newUI/modern-business.css" rel="stylesheet" />
<link href="CSS/newUI/custome.css" rel="stylesheet" />
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />



<link href="/CSS/newUI/custome.css" rel="stylesheet">
<script type="text/javascript" src="JS/common.js"></script>
<script type="text/javascript" src="JS/backOffice/Teacher/AssignmentList.js"></script>


<style >

/* .form-control{

width: 70%;
} */

.hiddenclass{
display: none;
}

</style>

</head>

<body>
	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span id="pageHeading">Assignment</span>
		</p>
		
		<center>
		
				<div class="successmessagediv" align="left" style="display: none;">
						<div class="message-item">
							<!-- Warning -->
							<a href="#" class="msg-success bg-msg-succes"><span
								class="validateTips"></span></a>
						</div>
				</div>	

					
				<div class="errormessagediv" align="left" style="display: none;">
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
		
		</center>		

		<form method="post">
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Update Assignment
							</a>
						</h4>
					<div class="navbar-right">
							
							<span id="saveid" class="save2">
							
							<img src="images/save.png" class="save" data-toggle="tooltip" data-placement="bottom" title="Pay Fee">
									
							</Span>	
							
								
						<a href="teachermenuaction.html?method=assignmentView">
							<span class="glyphicon glyphicon-list2"></span>
						</a>
					</div>
					
					</div>
					
					<script>
	$(document).ready(function(){
	    $('[data-toggle="tooltip"]').tooltip();   
	});
	</script>
					

			<div class="feebody panel-group" id="accordion" role="tablist" aria-multiselectable="true">

					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne" align="center">
						<div class="panel-body">
						
						<input type="hidden" id="assignmentId" value="<logic:present name="AssignmentDetailsVo"><bean:write name="AssignmentDetailsVo" property="assignmentId"/></logic:present>"/>

							
							<div class="col-md-6" id="txtstyle">

								<div class="form-group">
									<label class="control-label col-xs-6"
										style="text-align: right; line-height: 35px;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;" >Class &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
									<div class="col-xs-6">
										<label for="inputPassword" class="col-xs-12"
											style="text-align: left; line-height: 35px;font-size: 13px;font-family: Open Sans Light" id="addmissionNo"><logic:present name="AssignmentDetailsVo"><bean:write name="AssignmentDetailsVo" property="classname"/></logic:present>
										</label>
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-xs-6"
										style="text-align: right; font-family: sans-serif; line-height: 35px;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;">Assignment Name
										 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
									<div class="col-xs-6">
										<label for="inputPassword" class="col-xs-12"
											style="text-align: left; line-height: 35px;font-size: 13px;font-family: Open Sans Light"><logic:present name="AssignmentDetailsVo"><bean:write name="AssignmentDetailsVo" property="assigName"/></logic:present>
										</label>
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-xs-6"
										style="text-align: right; font-family: sans-serif; line-height: 35px;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;">Assignment Date
										 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
									<div class="col-xs-6">
										<label for="inputPassword" class="col-xs-12"
											style="text-align: left; line-height: 35px;font-size: 13px;font-family: Open Sans Light"><logic:present name="AssignmentDetailsVo"><bean:write name="AssignmentDetailsVo" property="startdate"/></logic:present>
										</label>
									</div>
								</div>
								
								<br/>
								
								<div class="form-group">
									<label class="control-label col-xs-6"
										style="text-align: right; font-family: sans-serif; line-height: 35px;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;">Max Marks
										 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
									<div class="col-xs-6">
										<label for="inputPassword" class="col-xs-12" id="maxmarks"
											style="text-align: left; line-height: 35px;font-size: 13px;font-family: Open Sans Light"><logic:present name="AssignmentDetailsVo"><bean:write name="AssignmentDetailsVo" property="marks"/></logic:present>
										</label>
									</div>
								</div>
								
								</div>

							<div class="col-md-6" id="txtstyle">

								<div class="form-group">
									<label class="control-label col-xs-6"
										style="text-align: right; font-family: sans-serif; line-height: 35px;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;">Section
										 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
									<div class="col-xs-6">
										<label for="inputPassword" class="col-xs-12"
											style="text-align: left; line-height: 35px;font-size: 13px;font-family: Open Sans Light"><logic:present name="AssignmentDetailsVo"><bean:write name="AssignmentDetailsVo" property="section"/></logic:present>
										</label>
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-xs-6"
										style="text-align: right; font-family: sans-serif; line-height: 35px;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;">Subject Name
										 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
									<div class="col-xs-6">
										<label for="inputPassword" class="col-xs-12"
											style="text-align: left; line-height: 35px;font-size: 13px;font-family: Open Sans Light"><logic:present name="AssignmentDetailsVo"><bean:write name="AssignmentDetailsVo" property="subjectname"/></logic:present>
										</label>
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-xs-6"
										style="text-align: right; font-family: sans-serif; line-height: 35px;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;">Completion Date
										 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
									<div class="col-xs-6">
										<label for="inputPassword" class="col-xs-12"
											style="text-align: left; line-height: 35px;font-size: 13px;font-family: Open Sans Light" id="concessionPercent"><logic:present name="AssignmentDetailsVo"><bean:write name="AssignmentDetailsVo" property="enddate"/></logic:present>
										</label>
									</div>
								</div>
								

							</div>

						
						
						<display:table class="table" id="allstudent" style="font-family: Open Sans Light;color: #897676;"
						name="requestScope.AssignmentDetailsList" 
						requestURI="/teachermenuaction.html?method=assignmentView">
						
						 
						<display:column property="studentId" class="hiddenclass" headerClass="hiddenclass"></display:column>
						
						<display:column property="sno" sortable="true"
							title="Sno  <img src='images/sort1.png' style='float: right'/>"
							media="html">
									
						</display:column>
						
						<display:column property="admissionNo" sortable="true" 
							title="Admission Number  <img src='images/sort1.png' style='float: right'/>"
							media="html">
						</display:column>

						<display:column property="studentName" sortable="true"
							title="Student Name <img src='images/sort1.png' style='float: right'/>"
							media="html"></display:column>

						<display:column  sortable="true"
							title="Actual Completion Date  <img src='images/sort1.png' style='float: right'/>"
							media="html">
							<input type='text' name='actualcompleteDate'
									value='${allstudent.actualcompletedDate}'
									id="${allstudent.assignmentId}--${allstudent.studentId}date" readonly="readonly"
									style="width: 95% !important;height: 30px" class="form-control actualcompleteDate" />
							
							
							</display:column>

						<display:column  sortable="true"
							title="Acquired Marks <img src='images/sort1.png' style='float: right'/>"
							media="html">
							
							<input type='text' name='acquiredmarks'
									value='${allstudent.acquiredMarks}'
									id="${allstudent.assignmentId}--${allstudent.studentId}acquiredmarks" 
									 class="form-control acquiredmarks" />
							
						</display:column>


						<display:column sortable="true"
							title="Remarks <img src='images/sort1.png' style='float: right'/>"
							media="html">
							
							<textarea rows="1" cols="40" style="resize:none" class="form-control remarks" id="${allstudent.assignmentId}--${allstudent.studentId}remarks">${allstudent.remarks}</textarea>
							
						</display:column>

						
					</display:table>
					
							</div>
					</div>

			
				
			</div>
			
			</div>
					</div>

		</form>
				</div>
			
				
			
	
</body>

</html>
