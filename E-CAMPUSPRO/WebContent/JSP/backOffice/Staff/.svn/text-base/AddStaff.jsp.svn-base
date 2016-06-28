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

<script type="text/javascript" src="JS/backOffice/Staff/AddStaff.js"></script> 
<script type="text/javascript">
	$('.carousel').carousel({
		interval : 5000
	//changes the speed
	});
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
<style>


 
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
			<img src="images/addstu.png" />&nbsp;<span>New Staff</span>
		</p>
		
		          
					<logic:present name="successmessagediv"  scope="request">
						<div class="successmessagediv" align="center">
							<div class="message-item">
								<!-- Warning -->
								<a href="#" class="msg-success bg-msg-succes"><span><bean:write
											name="successmessagediv" scope="request" /></span></a>
							</div>
						</div>
					</logic:present>


					<div class="errormessagediv" align="center" style="display: none;">
						<div class="message-item">
							<!-- Warning -->
							<a href="#" class="msg-warning bg-msg-warning"><span
								class="validateTips"></span></a>
						</div>
					</div>
				
		      

		<form id="teacherform" action="teacherregistration.html?method=teacherregister"
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

							<div class="navbar-right">
							
								<span  id="save" class="save2"> <img src="images/save.png" style="cursor:pointer"></span>
								 
								 <a href="adminMenu.html?method=staffList">
								 	<span class="glyphicon glyphicon-list2"></span>
								 </a>
								 
							</div>
						
					</div>
					
					
						
					
					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							<div class="col-md-6" id="txtstyle"
								>
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">First Name</label>
									<div class="col-xs-7">
									
											<input type="text" name="tfastname" id="fname"   class="form-control" placeholder=""
								maxlength="25" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="tfastname"/></logic:present>"/>
									</div>
								</div>
								<br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Last Name </label>
									<div class="col-xs-7">
											<input type="text" name="tlastname" id="lname" maxlength="12" class="form-control" placeholder="" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="tlastname"/></logic:present>"/>
									</div>
								</div>
								
							    <br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Date of
									Joining</label>
									<div class="col-xs-7">
											<input type="text"
								readonly="readonly" name="joiningdate" id="joindateid" class="form-control" 
								placeholder="" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="joiningdate"/></logic:present>" />
									</div>
								</div>
								
								 <br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Teaching Type</label>
									<div class="col-xs-7">
											<select name="teachingtype" id="teachingtype" class="form-control">
									<option value=" "></option>
									<option value="Teaching">Teaching</option>
									<option value="Non-Teaching">Non-Teaching</option>
									
							</select>
									</div>
								</div>
								
								 <br />
                               <div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Secondary Subject</label>
									<div class="col-xs-7">
										<select name="subjectsecondary" id="secondaryid" class="form-control">
									<option value=" "></option>
							</select>
									</div>
								</div>
								
								<br/>
								
								  <div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">UserType</label>
									<div class="col-xs-7">
										<select name="usertype" id="usertype" class="form-control">
									<option value=" "></option>
									<option value="admin">Admin</option>
									<option value="teacher">Teacher</option>
									<option value="custum">Custum</option>
									
							</select>
							
							
							
									</div>
								</div>
								
							</div>
							<div class="col-md-6"
								id="txtstyle">
								
									<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">
										Teacher Id</label>
									<div class="col-xs-7">
										<input type="text" class="form-control"  name="regno" id="regno" placeholder="" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="regsitrationNo"/></logic:present>"/>
									</div>
								</div>
								
								<br />
								
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Department</label>
									<div class="col-xs-7">
											<select name="department" id="department"  class="form-control" >
									<option value=" "></option>
							</select>
									</div>
								</div>
								
								<br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Designation</label>
									<div class="col-xs-7">
											<select name="designation" id="designation" class="form-control" >
									<option value=" "></option>
							</select>
									</div>
								</div>
								 <br />
								 <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Primary Subject</label>
									<div class="col-xs-7">
											<select
								name="subjectprimary" id="primaryid" class="form-control">
									<option value=" "></option>
							</select>
									</div>
								</div>
                                
								
								 <br />
                                <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">User Name </label>
									<div class="col-xs-7">
											<input type="text" name="username" id="uname" maxlength="25" placeholder=""  class="form-control" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="username"/></logic:present>"/>
									</div>
								</div>
								<br/>
								
								 <div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Role</label>
									<div class="col-xs-7">
										<select name="role" id="roleId" class="form-control">
									<option value=" "></option>
									<logic:present name="RolePermission" >
									<logic:iterate id="role" name="RolePermission" property="roleList">
									<option value='<bean:write name="role" property="roleCode"/>'><bean:write name="role" property="roleName"/></option>
									</logic:iterate>
									</logic:present>
							</select>
							
							<input type="hidden" name="roleId" id="selectedRole" value="" />
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
							<div class="col-md-6"
								id="txtstyle">
									 <div class="form-group">
									 
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Gender</label>
									<div class="col-xs-7">
											<select name="gender" id="gender" class="form-control">
									<option value=" "></option>
									<option value="male">Male</option>
									<option value="female">Female</option>
									
							</select>
									</div>
								</div>
								<br/>
								
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Qualification</label>
									<div class="col-xs-7">
											<input type="text"
								name="tqualification" id="qualification" maxlength="12" class="form-control" placeholder=""  value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="tqualification"/></logic:present>"/>
									</div>
								</div>
								<br/>
								
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Email ID </label>
									<div class="col-xs-7">
											<input type="text"
								name="teacheremail" id="teacherEmail" maxlength="45" class="form-control" placeholder=""  value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="teacheremail"/></logic:present>" />
									</div>
								</div>
								<br/>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Id
										Proof</label>
									<div class="col-xs-7">
										<input type="file" class="form-control" name="idproof" id="idproof" >
									</div>
								</div>
								<br/>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Profile
									</label>
									<div class="col-xs-7">
										<input type="file" class="form-control" name="teacherprofile" id="teaprofile">
									</div>
								</div>
								
								</div>
								
									<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">
										Date of
									Birth</label>
									<div class="col-xs-7">
										<input type="text" readonly="readonly" name="dateofbirth" id="dateofbirthid" placeholder="" class="form-control"  value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="dateofbirth"/></logic:present>"/>
									</div>
								</div>
								<br/>
								
									
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Mobile No</label>
									<div class="col-xs-7">
											<input type="text" name="teachermobno" id="mnumber" maxlength="11" placeholder="" class="form-control" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="teachermobno"/></logic:present>"/>
									</div>
								</div>
								
								<br/>
								 <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Blood Group</label>
									<div class="col-xs-7">
											<select name="blood" id="bloodId" class="form-control">
									<option value=""></option>
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
										style="text-align: right; line-height: 35px;">
										Image</label>
									<div class="col-xs-7">
										<input type="file" class="form-control" id="teaImageId" name="teacherImage">
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
										style="text-align: right; line-height: 35px;">Father's Name</label>
									<div class="col-xs-7">
										<input type="text" class="form-control" id="fathername" name="fathername"
											placeholder="" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="fathername"/></logic:present>">
									</div>
								</div>
								<br />
								
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Present Address</label>
									<div class="col-xs-7">
											<textarea rows="3px" cols="3px" name="presentadd" id="presentadd" class="form-control"    placeholder="" ><logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="presentadd"/></logic:present>
											</textarea>
									</div>
								</div>
								
							</div>
								<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								
                                        	<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Mother's Name</label>
									<div class="col-xs-7">
										<input type="text" class="form-control" id="mothername" name="mothername"
											placeholder="" value="<logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="mothername"/></logic:present>">
									</div>
								</div>
								<br/>
									
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Permanent Address</label>
									<div class="col-xs-7">
											<textarea rows="3px" cols="3px" name="permanentadd" id="permanentadd" class="form-control"    placeholder="" ><logic:present name="teacherdetails" ><bean:write name="teacherdetails" property="permanentadd"/></logic:present>
											</textarea>
									</div>
								</div>
								
							
							
							
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
							
							<div class="navbar-right" style="margin: -32px -29px" >
								
								<span id="save" onclick="add()" class="glyphicon glyphicon-plus" style="margin-top: 5px"></span>
							
								<span id="delete" onclick="deleteClassMapping()" class="glyphicon glyphicon-trash" style="margin-top: 6px "></span>
								
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
								&nbsp;&nbsp;Subject 
							</a>
						</h4>
							
							<div class="navbar-right" style="margin: -32px -29px" >
								
								<span id="addsubject" onclick="addSubject()" class="glyphicon glyphicon-plus" style="margin-top: 5px"></span>
								
								<span id="deletesubject" onclick="deleteSubject()" class="glyphicon glyphicon-trash" style="margin-top: 6px"></span>
								
							</div>
						
					</div>
					
					
					<div id="collapseFive" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingFour">
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
			      
       
		</form>		
				
		<!-- </form> -->
	</div>
	
</body>

</html>
