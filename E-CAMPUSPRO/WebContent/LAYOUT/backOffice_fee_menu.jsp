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
					<a data-toggle="collapse" data-parent="#accordion2" href="#menucollapseOne" style="color:#fff;"><h3 class="panel-title active" >Fee Management<i class="glyphicon glyphicon-triangle-bottom" style="float:right;"></i></h3></a>		
				</div>
				<div id="menucollapseOne" class="accordion-body collapse in">
					<div class="panel-body" >
						<ul class="nav nav-pills nav-stacked">
						
						<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="FEEDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">
						
										<li><a href="adminMenu.html?method=feeDetailsList">Fee Master</a></li>
										
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
											
						<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="TRMDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">
										
										<li><a href="adminMenu.html?method=termList">Term Master</a></li>
										
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
							
						<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="TTYDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">	
																			
										<li><a href="adminMenu.html?method=transportTypeHome">Transport Type</a></li>
										
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
					
						<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="CONDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">
										
										<li><a href="adminMenu.html?method=FeeConcessionList">Concession Details</a></li>
										
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
							
						<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="CLSFEEDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">
										
										<li><a href="adminMenu.html?method=getClassFeeSetup">Class Fee Setup</a></li>
										
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
							
						<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="STGFEEDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">
										
										<li><a href="adminMenu.html?method=getStageFeeSetup">Stage Fee Setup</a></li>
									
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
										
						<logic:present name="UserDetails" scope="session">
								 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
									<logic:equal value="FEECOLLDIS" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">
										
										<li><a href="adminMenu.html?method=feeCollection">Fee Collection</a></li>
										
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
								
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
