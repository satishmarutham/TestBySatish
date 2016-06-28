<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
	<link href="CSS/newUI/custome.css" rel="stylesheet">
<title>eCampus Pro</title>
<body>
		<div class="col-md-2 leftmenu"
			style="padding: 0; background-color: #f5f2f2;">
			
			<div class="panel panel-primary" style="border: none;background-color: transparent;	margin: 1px 0px;box-shadow: none;">
			<div class="panel-heading" style="background-color: #07AAB9;">
					<a data-toggle="collapse" data-parent="#accordion2" href="#menucollapseOne" style="color:#fff;"><h3 class="panel-title active" >Staff Management<i class="glyphicon glyphicon-triangle-bottom" style="float:right;"></i></h3></a>		
				</div>
				<div id="menucollapseOne" class="accordion-body collapse in">
					<div class="panel-body" >
						<ul class="nav nav-pills nav-stacked">
				
				
							<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="STAFFDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">

									<li><a href="adminMenu.html?method=staffList">Staff Registration</a></li>
									
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
									
									
								<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="STFFEMPDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">
									
										<li><a href="adminMenu.html?method=staffEmployementList">Staff Employment</a></li>
									
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
									
							<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="STFFATTDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">
									
										<li><a href="adminMenu.html?method=getStaffAttendance">Staff Attendance</a></li>
									
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
									
								
								<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="STAFFPAYDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">
											
											<li><a href="adminMenu.html?method=getPayrollList">Payroll Generation</a></li>

										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
									

									<li><a href="teachermenuaction.html?method=viewTeacherTimeTable">View TimeTable</a></li>
									
										<li><a href="teachermenuaction.html?method=downloadPayslip">Download PaySlip</a></li>
									
									<li>&nbsp;</li>
									<li>&nbsp;</li>
									<li>&nbsp;</li>
									<li>&nbsp;</li>
									<li>&nbsp;</li>
									<li>&nbsp;</li>
									<li>&nbsp;</li>
									<li>&nbsp;</li>
									<li>&nbsp;</li>
									<li>&nbsp;</li>
									<li>&nbsp;</li>
									<li>&nbsp;</li>
									<li>&nbsp;</li>
									<li>&nbsp;</li>
						</ul>
					</div>
				  <br/>
				</div>
			</div>
			
		</div>
</body>
</html>
