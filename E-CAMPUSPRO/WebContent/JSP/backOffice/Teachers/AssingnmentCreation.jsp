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
	src="JS/backOffice/Teacher/AssignmentUpload.js"></script>

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
			<img src="images/addstu.png" />&nbsp;<span id="pageHeading">Assignment</span>
		</p>

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
			
			<div class="errormessagediv" style="display: none;">
						<div class="message-item">
							<!-- Warning -->
							<a href="#" class="msg-warning bg-msg-warning"><span
								class="validateTips"></span></a>
						</div>
					</div>
			
			
		</center>

		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" style="color: #767676"> <i
							class="glyphicon glyphicon-menu-hamburger"></i>
							&nbsp;&nbsp;New Assignment
						</a>
					</h4>
						<div class="navbar-right">

							
								<span class="save2" style="cursor: pointer;">
									<img src="images/save.png" id="save" >
								</span>
							
							 
							 
							 <a href="teachermenuaction.html?method=assignmentView">
							 		<span class="glyphicon glyphicon-list2"></span>
							 </a>
						</div>
			
				</div>
				
				<form id="assignmentform" action="assignmentupload.html?method=insertAssignment" method="post">
				<div id="collapseOne" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingOne">
					<div class="panel-body">

						<div class="col-md-6" id="txtstyle">
						
						
						<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Assignment Name
								</label>
								<div class="col-xs-7">
									<input type="text" name="assname" id="assname"
										class="form-control"></input>
								</div>
							</div>
							<br />
							
						<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Completion
									date
								</label>
								<div class="col-xs-7">
									<input type="text" name="compdate" id="compdate"
										readonly="readonly" class="form-control"
										placeholder="Click Here"></input>
								</div>
							</div>
							<br />
							
							
							<div class="form-group">
								<label for="inputEmail" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Stream
								</label>
								<div class="col-xs-7">
									<select name="streamid" id="streamid" class="form-control">
											 <option value=""></option>
											 <logic:present name="StreamList">
											 
											 <logic:iterate  id="StreamRec" name="StreamList" >
											 
											 <option value="<bean:write name="StreamRec" property="streamId"/>"><bean:write name="StreamRec" property="streamname"/></option>
											 
											 </logic:iterate>
											 
											 </logic:present>
									</select>
								</div>
							</div>
							<br />
							
						<div class="form-group">
								<label for="inputEmail" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Section
								</label>
								<div class="col-xs-7">
									<select name="section" id="section" class="form-control">
										
									</select>
								</div>
							</div>
							<br />
							
							<div class="form-group">
								<label for="inputEmail" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Student
								</label>
								<div class="col-xs-7">
									<select name="student" id="student" class="form-control" multiple="multiple">
									</select>
								</div>
							</div>

							
						</div>
						<div class="col-md-6" id="txtstyle">
						
						
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Assignment
									Date
								</label>
								<div class="col-xs-7">
									<input type="text" name="assdate" id="assdate"
										readonly="readonly" class="form-control"
										placeholder="Click Here"></input>
								</div>
							</div>
							<br />
							
								<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Max
									Point/Marks
								</label>
								<div class="col-xs-7">
									<input type="text" name="maxid" id="maxid"
										class="form-control"></input>
								</div>
							</div>
							<br />
							
							<div class="form-group">
								<label for="inputEmail" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Class
								</label>
								<div class="col-xs-7">
									<select name="classid" id="classid" class="form-control">
										<option value="">----Select----</option>
										<option value="1st">1st</option>
										<option value="2nd">2nd</option>
										<option value="3rd">3rd</option>
									</select>
								</div>
							</div>
							<br />
							
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Subject</label>
								<div class="col-xs-7">
									<select name="subject" id="subject" class="form-control">
										<option value=""></option>
										<option value="general">General</option>
											 <logic:present name="SubjectsList">
											 
											 <logic:iterate  id="Subjects" name="SubjectsList" >
											 
											 <option value="<bean:write name="Subjects" property="subjectid"/>"><bean:write name="Subjects" property="subjectname"/></option>
											 
											 </logic:iterate>
											 
											 </logic:present>
										
									</select>
								</div>
							</div>
							<br />
						
						
							
							
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Description
								</label>
								<div class="col-xs-7">
									<textarea style="font-size: 12px;" rows="4"  name="description"
										class="form-control" id="description">
										</textarea>

								</div>
							</div>

						</div>
						<input type="hidden" id="duplicateid"
							value='<logic:present name="status" scope="request"><bean:write name="status" scope="request" /></logic:present>'>
					</div>
				</div>
				
				</form>

			</div>
		</div>
	</div>
</body>

</html>
