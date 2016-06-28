<!DOCTYPE html>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<link rel="stylesheet"	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery-ui.custom.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.tooltip.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/timepicker.js"></script>
<script type="text/javascript" src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script> 
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet" />
<link href="CSS/newUI/modern-business.css" rel="stylesheet" />
<link href="CSS/newUI/custome.css" rel="stylesheet" />
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
	
 <script type="text/javascript"
	src="JS/backOffice/Reports/TeacherLeaveReport.js"></script>
	
	
	
<style>
.save:hover {
	cursor: pointer;
}


 .table,th.heading1 {
	/* font-family: Roboto Bold; */
	font-size: 14px;
	color: #211f1f;
} 

.heading1{
	background:#d5d4d4;
}
</style>

<style>
#list:hover {
	cursor: pointer;
}
</style>


</head>

<body>
<form id="staffLeavereport" action="teacherLeaveDetailsReport.html?method=getLeaveDetailsReport" method="post" >
	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span>Staff Leave Report
			</span>
		</p>
      <div class="errormessagediv" align="center" style="display: none;">
			<div class="message-item">
				<!-- Warning -->
				<a href="#" class="msg-warning bg-msg-warning"><span
					class="validateTips"></span></a>
			</div>
		</div>


		<div class="successmessagediv" align="center" style="display: none;">
			<div class="message-item">
				<!-- Warning -->
				<a href="#" class="msg-success bg-msg-succes"><span
					class="validateTips"></span></a>
			</div>
		</div>

		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" style="color: #767676"> <i
							class="glyphicon glyphicon-menu-hamburger"></i> &nbsp;&nbsp;Staff Leave Report
							 
						</a>
						
						</h4>

						<div class="navbar-right">
						
							<img src="images/rightline.png" style="margin-top: -2px;margin-right: 11px;">
							<img src="images/download.png" class="download" id="iconsimg" style="margin-top:4px"
								data-toggle="modal" data-target="#myModal" data-toggle="tooltip"
								data-placement="bottom" title="Download">

						</div>
						
						<script>
							$(document).ready(function() {
								$('[data-toggle="tooltip"]').tooltip();
							});
						</script>
				
				</div>
				
				
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
								<span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<span id="excelDownload"><img src="images/xl.png"
										class="xl"></span>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--  <span
										id="pdfDownload"><img src="images/pdf.png" class="pdf"></span> -->
								</div>

							</div>
						</div>
					</div>
				
				
				<div id="collapseOne" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingOne">
					
					<div class="panel-body" id="tabletxt">

						<div class="col-md-6" id="txtstyle">
							
							
							
							<div class="form-group">
									<!-- <label for="inputPassword" class="control-label col-xs-4"
										id="inputnames">Academic Year</label> -->
										
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Academic Year
								</label>		
										
									<div class="col-xs-7">
										<select id="accyear" name="accyear" class="form-control"
											>
											<option value=""></option>

											<logic:present name="AccYearList">
											

												<logic:iterate id="AccYear" name="AccYearList">

													<option
														value="<bean:write name="AccYear" property="accyearId"/>">
														<bean:write name="AccYear" property="accyearname" />
													</option>

												</logic:iterate>

											</logic:present>
										</select>
									</div>
								</div>
						
							<br />
							
							
							<div class="form-group">
						
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Teacher Type
									
								</label>
								
								<div class="col-xs-7">
									<select name="teachingtype" id="teachertype" class="form-control" onchange="getTeacherName()" >
										<option value=""></option>
										<option value="all">All</option>
										<option value="teaching">Teaching</option>
										<option value="nonteaching">Non Teaching</option>
										
							
									</select>
								</div>
								
									
							</div>
			
						</div>
						<div class="col-md-6" id="txtstyle">

              			<div class="form-group">
								
										
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Department
								</label>		
										
									<div class="col-xs-7">
										<select id="deptid" name="department" class="form-control" onchange="getTeacherName()"
											>
											<option value=""></option>
											<logic:present name="DepartmentList">
												<option value="all">All</option>
												<logic:iterate id="DeptId" name="DepartmentList">

													<option
														value="<bean:write name="DeptId" property="depId"/>">
														<bean:write name="DeptId" property="depName" />
													</option>

												</logic:iterate>

											</logic:present>

										
										</select>
									</div>
								</div>	
                       
                             <br />

                       	 <div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Teacher Name
								</label>		
										
										
										
									<div class="col-xs-7">
										<select id="teachername" name="teachername" class="form-control"
											>
											<option value=""></option>

										
										</select>
									</div>
								</div>	
							<br />	<br />
						
						</div>
						
					
			<button type="submit" class="btn btn-info col-md-offset-5"
								id="search" >Search</button>
							<!-- data-toggle="modal" data-target="#myModal" -->
							<br />			
						
						
						<div class="col-md-12 selecteditems">
								<br /> 
								
								<input type="hidden" id="haccyear" name="haccyear" value="" />
									
								<input type="hidden" id="hteachertype" name="hteachertype" value="" />
									
								<input type="hidden" id="hdepartment" name="hdepartment" value="" />
									
								<input type="hidden" id="hteachername" name="hteachername" value="" />
								
								<logic:present name="Departmentname">

								<span><b>Academic Year :</b></span>&nbsp;&nbsp;&nbsp;<span><logic:present
										name="AccyearNaame">
										<bean:write name="AccyearNaame" />
										
									</logic:present></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span><b>Department :</b></span>&nbsp;&nbsp;&nbsp;<span><logic:present
										name="Departmentname">
										<bean:write name="Departmentname" />
										
									</logic:present></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span><b>Teaching Type :</b></span>&nbsp;&nbsp;&nbsp;<span><logic:present
										name="Teachingtype">
										<bean:write name="Teachingtype"/>
										
									</logic:present></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span><b>Teacher Name :</b></span>&nbsp;&nbsp;&nbsp;<span><logic:present
										name="TeacherName">
										<bean:write name="TeacherName"/>
										
									</logic:present></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />
									
								</logic:present>
							</div>
							<br />	
			
						
						
						
						
						 <div class="col-md-12" id="allstudent" style="overflow:scroll;padding:7px;height: 300px;text-align: center;">
				<p class="theading"><span class="displayno"></span></p>	
		
		<logic:present name="detailsList" scope="request">
		
		<input type="hidden" id="hideenId" value="studentlist" />
			
				<table style="width:100px"  class="table" id="allstudent">		

<tr class="heading1" >
<th  class="heading1">Employee Id</th>

<th  class="heading1">Employee Name</th>
<th class="heading1">Total Leaves </th>
<th colspan="3">JAN</th><th colspan="3">FEB</th><th colspan="3">MAR</th>
<th colspan="3">April</th><th colspan="3">May</th><th colspan="3">June</th>
<th colspan="3">July</th><th colspan="3">Aug</th><th colspan="3">Sept</th>
<th colspan="3">Oct</th><th colspan="3">Nov</th><th colspan="3">Dec</th>

<th >Balance as on </th></tr>
<tr>
<th class="heading1"></th>
<th class="heading1"></th>
<th class="heading1"></th>
<th style="width:100px" class="heading1">PL</th><th class="heading1">CL</th><th class="heading1">SL</th>
<th class="heading1">PL</th><th class="heading1">CL</th><th class="heading1">SL</th>
<th class="heading1">PL</th><th class="heading1">CL</th><th class="heading1">SL</th>
<th class="heading1">PL</th><th class="heading1">CL</th><th class="heading1">SL</th>
<th class="heading1">PL</th><th class="heading1">CL</th><th class="heading1">SL</th>
<th class="heading1">PL</th><th class="heading1">CL</th><th class="heading1">SL</th>
<th class="heading1">PL</th><th class="heading1">CL</th><th class="heading1">SL</th>
<th class="heading1">PL</th><th class="heading1">CL</th><th class="heading1">SL</th>
<th class="heading1">PL</th><th class="heading1">CL</th><th class="heading1">SL</th>
<th class="heading1">PL</th><th class="heading1">CL</th><th class="heading1">SL</th>
<th class="heading1">PL</th><th class="heading1">CL</th><th class="heading1">SL</th>
<th class="heading1">PL</th><th class="heading1">CL</th><th class="heading1">SL</th>

<th class="heading1"></th>
<!-- <td class="heading1">PL</td><td class="heading1">CL</td><td class="heading1">SL</td> -->
</tr>


 
  <logic:iterate id="LeaveReport" name="detailsList"
					scope="request">
					<tr> 

						<td align="center"><bean:write name="LeaveReport"
								property="teacherId" /></td>
								
					 <td align="center"><bean:write name="LeaveReport"
								property="teachername"/></td>
						
					  <td align="center"><bean:write name="LeaveReport"
								property="total"/></td>	
											
							<logic:iterate id="LeaveReport1"
							name="LeaveReport" property="jan">
							<td id="<bean:write name="LeaveReport1" />"><bean:write	name="LeaveReport1" property="pljan"/></td>
							<td><bean:write	name="LeaveReport1" property="cljan"/></td>
							<td><bean:write	name="LeaveReport1" property="sljan"/></td>
						</logic:iterate> 
						
						
				 <logic:iterate id="LeaveReport2"
							name="LeaveReport" property="feb">
							<td id="<bean:write name="LeaveReport2" />"><bean:write	name="LeaveReport2" property="plfeb"/></td>
							<td><bean:write	name="LeaveReport2" property="clfeb"/></td>
							<td><bean:write	name="LeaveReport2" property="slfeb"/></td>
						</logic:iterate> 
						
						  <logic:iterate id="LeaveReport3"
							name="LeaveReport" property="mar">
							<td id="<bean:write name="LeaveReport3" />"><bean:write	name="LeaveReport3" property="plmar"/></td>
							<td><bean:write	name="LeaveReport3" property="clmar"/></td>
							<td><bean:write	name="LeaveReport3" property="slmar"/></td>
						</logic:iterate> 
						
						 <logic:iterate id="LeaveReport4"
							name="LeaveReport" property="aprl">
							<td id="<bean:write name="LeaveReport4" />"><bean:write	name="LeaveReport4" property="plaprl"/></td>
							<td><bean:write	name="LeaveReport4" property="claprl"/></td>
							<td><bean:write	name="LeaveReport4" property="slaprl"/></td>
						</logic:iterate> 
						
						 <logic:iterate id="LeaveReport5"
							name="LeaveReport" property="may">
							<td id="<bean:write name="LeaveReport5" />"><bean:write	name="LeaveReport5" property="plmay"/></td>
							<td><bean:write	name="LeaveReport5" property="clmay"/></td>
							<td><bean:write	name="LeaveReport5" property="slmay"/></td>
						</logic:iterate> 
						
						
						 <logic:iterate id="LeaveReport6"
							name="LeaveReport" property="june">
							<td id="<bean:write name="LeaveReport6" />"><bean:write	name="LeaveReport6" property="pljune"/></td>
							<td><bean:write	name="LeaveReport6" property="cljune"/></td>
							<td><bean:write	name="LeaveReport6" property="sljune"/></td>
						</logic:iterate> 
						
						 <logic:iterate id="LeaveReport7"
							name="LeaveReport" property="july">
							<td id="<bean:write name="LeaveReport7" />"><bean:write	name="LeaveReport7" property="pljuly"/></td>
							<td><bean:write	name="LeaveReport7" property="cljuly"/></td>
							<td><bean:write	name="LeaveReport7" property="sljuly"/></td>
						</logic:iterate> 
						
					 	 <logic:iterate id="LeaveReport8"
							name="LeaveReport" property="aug">
							<td id="<bean:write name="LeaveReport8" />"><bean:write	name="LeaveReport8" property="plaug"/></td>
							<td><bean:write	name="LeaveReport8" property="claug"/></td>
							<td><bean:write	name="LeaveReport8" property="slaug"/></td>
						</logic:iterate> 
						
						 <logic:iterate id="LeaveReport9"
							name="LeaveReport" property="sep">
							<td id="<bean:write name="LeaveReport9" />"><bean:write	name="LeaveReport9" property="plsep"/></td>
							<td><bean:write	name="LeaveReport9" property="clsep"/></td>
							<td><bean:write	name="LeaveReport9" property="slsep"/></td>
						</logic:iterate> 
						
						 <logic:iterate id="LeaveReport10"
							name="LeaveReport" property="oct">
							<td id="<bean:write name="LeaveReport10" />"><bean:write	name="LeaveReport10" property="ploct"/></td>
							<td><bean:write	name="LeaveReport10" property="cloct"/></td>
							<td><bean:write	name="LeaveReport10" property="sloct"/></td>
						</logic:iterate> 
						
								
								 
 
				 <logic:iterate id="LeaveReport11"
							name="LeaveReport" property="nov">
							<td id="<bean:write name="LeaveReport11" />"><bean:write	name="LeaveReport11" property="plnov"/></td>
							<td><bean:write	name="LeaveReport11" property="clnov"/></td>
							<td><bean:write	name="LeaveReport11" property="slnov"/></td>
						</logic:iterate> 
						
						
						 <logic:iterate id="LeaveReport12"
							name="LeaveReport" property="dec">
							<td id="<bean:write name="LeaveReport12" />"><bean:write	name="LeaveReport12" property="pldec"/></td>
							<td><bean:write	name="LeaveReport12" property="cldec"/></td>
							<td><bean:write	name="LeaveReport12" property="sldec"/></td>
						</logic:iterate>  
				
				
				    
						  <td align="center"><bean:write name="LeaveReport"
								property="balance"/></td>		
								
					</tr> 
				</logic:iterate>   
				
		
				
				</table>
			
				</logic:present>
			  </div>
						
						</div> 
					</div>
					
			
				</div>

			</div>
	</form>
</body>

</html>
