<!DOCTYPE html>
<html lang="en">
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
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<script type="text/javascript" src="JS/Admin/Latheef.js"></script>

<link href="CSS/newUI/custome.css" rel="stylesheet">

<script type="text/javascript" src="JS/backOffice/Staff/StaffAmendment.js"></script> 

<script type="text/javascript">
	$('.carousel').carousel({
		interval : 5000
	//changes the speed
	})
	$(document).scroll(function() {
		var y = $(this).scrollTop();
		if (y > 100) {
			$('.topimg').fadeIn();
		} else {
			$('.topimg').fadeOut();
		}
	});
</script>
<script>
	$('.carousel').carousel({
		interval : 5000
	//changes the speed
	})
</script>

<style >



#allstudent tr {
	font-size: 14px;
	border-bottom: 1px solid #ddd;
	border-left: 1px solid #ddd;
}

#allstudent th {
	background: #f9f9f9 !important;
    border-bottom: 1px solid #ddd;
    border-top: 1px solid #ddd;
    border-right: 1px solid #ddd;
    font-size: 11pt;
    color: #767676 !important;
    text-align: center;
    font-family: Roboto Medium;
   
	
}

#addstaffsubject tr {
	font-size: 14px;
	border-bottom: 1px solid #ddd;
	border-left: 1px solid #ddd;
}

#addstaffsubject tr:nth-child(n) {
	background-color: #F2FAFC;
}
#addstaffsubject tr:nth-child(2n) {
	background-color: #FFFFFF;
}

#addstaffsubject tr:hover {
	background: #9CDDE3;
	color: #fff;
	cursor: pointer;
}

#addstaffsubject th {
	background: #f9f9f9 !important;
    border-bottom: 1px solid #ddd;
    border-top: 1px solid #ddd;
    border-right: 1px solid #ddd;
    font-size: 11pt;
    color: #767676 !important;
    text-align: center;
    font-family: Roboto Medium;
	
}
#addstaffsubject th a{
	color: #767676 !important;
}
#addstaffsubject tr :HOVER{
	color: #000 !important;
}
#addstaffsubject  tr td {
	border-right: 1px solid #ddd;
	border-left: 0;
	border-top: 0;
	border-bottom: 0;
	color: #000000;
}


.inputbox {
	display: block;
	width: 100%;
	height: 34px;
	padding: 6px 12px;
	font-size: 13px;
	line-height: 1.42857;
	color: #767676;
	background-color: #fff;
	background-image: none;
	border: 1px solid #cbd5dd;
	border-radius: 0;
	border: 0;
	
}

.select-control{

	border: 0;
	display: block;
	width: 100%;
	height: 34px;
	padding: 6px 12px;
	font-size: 13px;
	line-height: 1.42857;
	color: #767676;
	background-color: #fff;
	background-image: none;
	border-radius: 0;

}
 

</style>
</head>

<body>
	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span>Update Staff</span>
		</p>
		
		    
					<logic:present name="successmessagediv" scope="request">
						<div class="successmessagediv">
							<div class="message-item">
								<!-- Warning -->
								<a href="#" class="msg-success bg-msg-succes"><span><bean:write
											name="successmessagediv" scope="request" /></span></a>
							</div>
						</div>
					</logic:present>


					<div class="errormessagediv" style="display: none;">
						<div class="message-item">
							<!-- Warning -->
							<a href="#" class="msg-warning bg-msg-warning"><span
								class="validateTips"></span></a>
						</div>
					</div>
						

	   <form id="teacherupdateform" action="teacherregistration.html?method=teacherUpdation"
					enctype="multipart/form-data" method="post">
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Staff Details
							</a>
						</h4>

							<div class="navbar-right" >
								
								<span id="save" class="save2"><img src="images/save.png" style=" cursor:pointer"></span>
							
								 <a href="adminMenu.html?method=staffList">
								 	<span class="glyphicon glyphicon-list2"></span>
								 </a>
								 
							</div>
						
					</div>
					
					
						
					
					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							<div class="col-md-6" style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">First Name<font
									color="red">*</font></label>
									<div class="col-xs-7">
									
											<input type="text" name="tfastname" id="fname"   class="form-control" placeholder="First Name"
								maxlength="25" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="tfastname"/></logic:present>"/>
									</div>
								</div>
								<br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Last Name </label>
									<div class="col-xs-7">
											<input type="text" name="tlastname" id="lname" maxlength="12" class="form-control" placeholder="Last Name " value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="tlastname"/></logic:present>"/>
									</div>
								</div>
								
							    <br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Date of
									Joining<font color="red">*</font></label>
									<div class="col-xs-7">
											<input type="text"
								readonly="readonly" name="joiningdate" id="joindateid" class="form-control" 
								placeholder="Click Here" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="joiningdate"/></logic:present>" />
									</div>
								</div>
								
								 <br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Primary Subject<font
									color="red">*</font></label>
									<div class="col-xs-7">
											<select
								name="subjectprimary" id="primaryid" class="form-control">
									<option value=" ">------Select----------</option>
							</select>
									</div>
								</div>
								
								 <br />
                               <div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Secondary Subject</label>
									<div class="col-xs-7">
										<select name="subjectsecondary" id="secondaryid" class="form-control">
									<option value=" ">------Select----------</option>
							</select>
									</div>
								</div>
								
								<br/>
								
								  <div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Role</label>
									<div class="col-xs-7">
										<select name="roleId" id="roleId" class="form-control">
									<option value=" "></option>
									<logic:present name="RolePermission" >
									<logic:iterate id="role" name="RolePermission" property="roleList">
									<option value='<bean:write name="role" property="roleCode"/>'><bean:write name="role" property="roleName"/></option>
									</logic:iterate>
									</logic:present>
							</select>
									</div>
								</div>
								
							</div>
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								
									<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">
										Teacher Id <font
									color="red">*</font></label>
									<div class="col-xs-7">
										<input type="text" class="form-control" readonly="readonly" name="regno" id="regno" placeholder="Teacher Id" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="regsitrationNo"/></logic:present>"/>
									</div>
								</div>
								
								<br />
								
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Department<font
									color="red">*</font></label>
									<div class="col-xs-7">
											<select name="department" id="department"  class="form-control" >
									<option value=" ">------Select----------</option>
							</select>
									</div>
								</div>
								
								<br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Designation<font
									color="red">*</font></label>
									<div class="col-xs-7">
											<select name="designation" id="designation" class="form-control" >
									<option value=" ">------Select----------</option>
							</select>
									</div>
								</div>
								 <br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Teaching Type<font
									color="red">*</font></label>
									<div class="col-xs-7">
											<select name="teachingtype" id="teachingtype" class="form-control">
									<option value=" ">------Select----------</option>
									<option value="Teaching">Teaching</option>
									<option value="Non-Teaching">Non-Teaching</option>
									
							</select>
									</div>
								</div>
								
								 <br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">User Name </label>
									<div class="col-xs-7">
											<input type="text" name="username" id="uname" maxlength="25" placeholder="User Name"  class="form-control" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="username"/></logic:present>"/>
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
								&nbsp;&nbsp;Personal Details
							</a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body">
							<div class="col-md-6" style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
									 <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Gender<font
									color="red">*</font></label>
									<div class="col-xs-7">
											<select name="gender" id="gender" class="form-control">
									<option value=" ">------Select----------</option>
									<option value="male">Male</option>
									<option value="female">Female</option>
									
							</select>
									</div>
								</div>
								<br/>
								
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Qualification<font
									color="red">*</font> </label>
									<div class="col-xs-7">
											<input type="text"
								name="tqualification" id="qualification" maxlength="12" class="form-control" placeholder="Qualification"  value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="tqualification"/></logic:present>"/>
									</div>
								</div>
								<br/>
								
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Email ID </label>
									<div class="col-xs-7">
											<input type="text"
								name="teacheremail" id="teacherEmail" maxlength="45" class="form-control" placeholder="Email ID"  value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="teacheremail"/></logic:present>" />
									</div>
								</div>
								<br/>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Id
										Proof</label>
									<div class="col-xs-7">
										<input type="file" class="docFile form-control" name="idproof" id="idproof" >
										<input type="button" id="document2btn" name="idproof" class="downloadDoc" value="Download" />
										<span id="downloadIdTitle"> downloadIdProof</span>
										<span style="font-size:20px;color:red;cursor:pointer;" id="deleteIDProof">x</span>
									</div>
								</div>
								<br/>
								
								
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">
										Image</label>
									<div class="col-xs-7">
										<input type="file" class="form-control" id="teaImageId" name="teacherImage">
									</div>
								</div>
								
								
								</div>
								
									<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">
										Date of
									Birth<font color="red">*</font></label>
									<div class="col-xs-7">
										<input type="text" readonly="readonly" name="dateofbirth" id="dateofbirthid" placeholder="Click Here" class="form-control"  value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="dateofbirth"/></logic:present>"/>
									</div>
								</div>
								<br/>
								
									
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Mobile No<font
									color="red">*</font></label>
									<div class="col-xs-7">
											<input type="text" name="teachermobno" id="mnumber" maxlength="11" placeholder="Mobile No" class="form-control" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="teachermobno"/></logic:present>"/>
									</div>
								</div>
								
								<br/>
								 <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Blood Group</label>
									<div class="col-xs-7">
											<select name="blood" id="bloodId" class="form-control">
									<option value=" ">------Select----------</option>
									<option value="A+ve">A+ve</option>
									<option value="A-ve">A-ve</option>
									<option value="A1+ve">A1+ve</option>
									<option value="A1-ve">A1-ve</option>
									<option value="A2+ve">A2+ve</option>
									<option value="A2-ve">A2-ve</option>
									<option value="A1B+ve">A1B+ve</option>
									<option value="A1B-ve">A1B-ve</option>
									<option value="AB+ve">AB+ve</option>
									<option value="AB-ve">AB-ve</option>
									<option value="AB1+ve">AB1+ve</option>
									<option value="AB1-ve">AB1-ve</option>
									<option value="A+B+ve">A+B+ve</option>
									<option value="B+ve">B+ve</option>
									<option value="B-ve">B-ve</option>
									<option value="O+ve">O+ve</option>
									<option value="O-ve">O-ve</option>
							</select>
									</div>
								</div>
								<br/>
								
								
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Profile
									</label>
									<div class="col-xs-7">
										<input type="file" class="form-control" name="teacherprofile" id="teaprofile">
										<input type="button" id="document1btn" name="profile" class="downloadDoc" value="Download" />
										<span id="downloadProfileTitle"> downloadProfile</span>
										<span style="font-size:20px;color:red;cursor:pointer;" id="deleteProfile">  x</span>
									</div>
								</div>
								<br/>
								
								<div class="form-group">
									
									<div class="col-xs-7">
									<img id="imagePreview" src="#" alt="image" width="80px"
											height="70px" style="margin-left: 62%;" />
									</div>
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
								&nbsp;&nbsp;Contact Details
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
										style="text-align: right; line-height: 35px;">Father's Name<font color="red">*</font></label>
									<div class="col-xs-7">
										<input type="text" class="form-control" id="fathername" name="fathername"
											placeholder="Father's Name" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="fathername"/></logic:present>">
									</div>
								</div>
								<br />
								
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Present Address<font color="red">*</font></label>
									<div class="col-xs-7">
											<textarea rows="3px" cols="3px" name="presentadd" id="presentadd" class="form-control"    placeholder="Description" ><logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="presentadd"/></logic:present>
											</textarea>
									</div>
								</div>
								
							</div>
								<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								
                                        	<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Mother's Name<font color="red">*</font></label>
									<div class="col-xs-7">
										<input type="text" class="form-control" id="mothername" name="mothername"
											placeholder="Mother's Name" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="mothername"/></logic:present>">
									</div>
								</div>
								<br/>
									
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Permanent Address<font color="red">*</font></label>
									<div class="col-xs-7">
											<textarea rows="3px" cols="3px" name="permanentadd" id="permanentadd" class="form-control"    placeholder="Description" ><logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="permanentadd"/></logic:present>
											</textarea>
									</div>
								</div>
								
							
					
								
							<input type="hidden" name="status"	id="status" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="status" /></logic:present>"  />
							<input type="hidden" name="hiddenprimary"	id="hiddenprimary" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="primary" /></logic:present>"  />
							<input type="hidden" name="hiddensecoundary"	id="hiddensecoundary" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="secondary" /></logic:present>"  />
							<input type="hidden" name="hiddendept"	id="hiddendept" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="dept" /></logic:present>"  />
							<input type="hidden" name="hiddendes"	id="hiddendes" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="designation" /></logic:present>"  />
							<input type="hidden" name="hiddenteatype"	id="hiddenteatype" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="teachingtype" /></logic:present>"  />
							<input type="hidden" name="hiddengender"	id="hiddengender" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="gender" /></logic:present>"  />
							<input type="hidden" name="hiddenblood"	id="hiddenblood" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="blood" /></logic:present>"  />
							<input type="hidden" name="defaultimage"	id="hiddenimage" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="imgpath" /></logic:present>"  />
							<input type="hidden" name="defaultidproof"	id="hiddenidproof" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="idproof" /></logic:present>"  />
							<input type="hidden" name="defaultprofile"	id="hiddenprofile" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="profilepath" /></logic:present>"  />
							<input type="hidden" name="teacherid"	id="teacherid" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="teacherId" /></logic:present>"  />
							<input type="hidden" name="hroleud"	id="hroleid" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="role" /></logic:present>"  />
							
							
							
								</div>
								
								
						</div>
						
					
					</div>
				</div>
				
				
				
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingFour">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseFour"
								style="color: #767676" aria-expanded="false"
								aria-controls="collapseFour"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Class Details
							</a>
						</h4>
							
							<div class="navbar-right">
								
								<span id="save" onclick="add()" class="glyphicon glyphicon-plus"></span>
								
								<span id="delete" onclick="deleteClassMapping()" class="glyphicon glyphicon-trash"></span>
								
							</div>
						
					</div>
					
					
					<div id="collapseFour" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingFour">
						<html:hidden property="count" styleId="count" value="0"/>
						<div class="panel-body">
							<div class="col-md-11" id="dynamicdiv"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<div class="col-xs-12">
								<table id="allstudent" class="teacherclass table" >
								<tr>
								<th align="center">
								<label>Check</label>
								
								</th>
								<th align="center">
								<label>Class</label>
								</th>
								<th align="center"><label>Section</label></th>
								</tr>
								
								</table>
								</div>
								
								</div>
								
						</div>
						
					
					</div>
				</div>
				
				
				
					<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingFive">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseFive"
								style="color: #767676" aria-expanded="false"
								aria-controls="collapseFive"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Subject Mapping
							</a>
						</h4>
							
							<div class="navbar-right">
								
								<span id="addsubject" onclick="addSubject()" class="glyphicon glyphicon-plus"></span>
								
								<span id="deletesubject" onclick="deleteSubject()" class="glyphicon glyphicon-trash"></span>
								
							</div>
						
					</div>
					
					
					<div id="collapseFive" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingFive">
						<html:hidden property="subjectcount" styleId="subjectcount" value="0"/>
						<div class="panel-body">
							<div class="col-md-11" id="dynamicdiv"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<div class="col-xs-12">
								<table id="addstaffsubject" class="teachersubject table" >
								<tr>
								<th align="center">
								<label>Check</label>
								
								</th>
								<th align="center">
								<label>Class</label>
								</th>
								<th align="center"><label>Subject</label></th>
								</tr>
								</table>
								</div>
								
								</div>
								
						</div>
						
					
					</div>
				</div>
				
				
				</div>
				
					
			      </div>
			      
       <!-- 
		 --></form>		
				
		 </form>
	</div>
	
</body>

</html>
