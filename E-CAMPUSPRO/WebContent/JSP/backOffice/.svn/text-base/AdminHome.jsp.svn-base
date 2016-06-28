<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link href="CSS/newUI/DashBoardCss/custome.css" rel="stylesheet">
<link href="CSS/newUI/custome.css" rel="stylesheet">
<style>

.panel-default {
    border-radius: 5px;
}

.panel-body {
    padding: 15px;
}

</style>
</head>



<body>

	<div class="row" style="margin:0;">
		<!-- <div class="col-md-9" style="padding:0;margin: 0;">
			<div class="col-md-9">
				<span class="breadcrumbs">DASHBOARD >></span>
			</div>
		</div> --><br/>
	
		<div class="col-md-10" style="padding: 0 10px;;">
			<div class="col-md-12 centertxt">
				<div class="col-md-12">
				<h1>ADMIN DASHBOARD</h1>
				</div>
			<!-- 	<div class="col-md-4"><br/>
						<div class="input-group">
					  <input type="text" class="form-control" placeholder="Search for..." style="border-right: 1px solid #fff;">
					  <span class="input-group-btn">
						<button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search">&nbsp;</span></button>
					  </span>
					</div>/input-group
					<br/>
				</div> -->
				
							<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="LEAVEAPPROVE" name="daymap" property="key">
									
										<logic:equal value="true" name="daymap" property="value">
				
										<div class="col-md-4">
											<div class="panel panel-default"> 
													<h4>&nbsp;&nbsp;&nbsp;&nbsp;LEAVE APPROVAL</h4>
												<div class="panel-body">
													<img src="images/performance.png" style="float:right;width:30%;    margin-top: -20px;"><br/><br/><br/><br/><br/>
													<p>&nbsp;&nbsp;&nbsp;&nbsp; 50% OUT OF 100%</p>
												</div>
												
											</div>
										</div>
				
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
			
						<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="STFFATTDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">
			
										<div class="col-md-4">
											<div class="panel panel-default"> 
													<h4>&nbsp;&nbsp;&nbsp;&nbsp;STAFF ATTENDANCE</h4>
												<div class="panel-body">
													<img src="images/leave.png" style="float:right;width:35%;"><br/><br/><br/><br/><br/>
													<p>&nbsp;&nbsp;&nbsp;&nbsp; 50% OUT OF 100%</p>
													<!-- <p><a href="">APPLY LEAVE</a></P> -->
												</div>
												
											</div>
										</div>
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
							
							
							<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="STUATTDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">				
										
											<div class="col-md-4">
												<div class="panel panel-default"> 
														<h4>&nbsp;&nbsp;&nbsp;&nbsp;STUDENT ATTENDANCE</h4>
													<div class="panel-body">
														<img src="images/attandence.png" style="float:right;width:35%;"><br/><br/><br/><br/><br/>
														<p>&nbsp;&nbsp;&nbsp;&nbsp; 30% OUT OF 100%</p>
													</div>
													
												</div>
											</div>
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
				
							<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="FEECOLLDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">				
							
									<div class="col-md-4">
										<div class="panel panel-default"> 
												<h4>&nbsp;&nbsp;&nbsp;&nbsp;FEE COLLECTION SUMMARY</h4>
											<div class="panel-body">
												<img src="images/recipt.png" style="float:right;width:30%;"><br/><br/><br/><br/><br/>
												<p>&nbsp;&nbsp;&nbsp;&nbsp; EASY TO TAKE THE RECIPT</p>
											</div>
											
										</div>
									</div>
									
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
							
							
						<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="AYPDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">					
									
									<div class="col-md-4">
										<div class="panel panel-default"> 
												<h4>&nbsp;&nbsp;&nbsp;&nbsp; CALENDER</h4>
											<div class="panel-body">
												<img src="images/dairy.png" style="float:right;width:35%;"><br/><br/><br/><br/><br/>
												<p>&nbsp;&nbsp;&nbsp;&nbsp; <b>ON 14TH</b> CHILDRENS DAY</p>
											</div>
											
										</div>
									</div>
									
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
							
							<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="CMSDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">				
							
								<div class="col-md-4">
									<div class="panel panel-default"> 
											<h4>&nbsp;&nbsp;&nbsp;&nbsp; CIRCULAR & MEETING</h4>
										<div class="panel-body">
											<img src="images/meeting.png" style="float:right;width:38%;"><br/><br/><br/><br/><br/>
											<p>&nbsp;&nbsp;&nbsp;&nbsp; <b>ON 14TH</b> CHILDRENS DAY</p>
										</div>
										
									</div>
								</div>
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
			</div>
		</div>
	</div>
</body>
</html>