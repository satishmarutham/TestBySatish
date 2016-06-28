<!DOCTYPE html>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Role Master</title>

<script type="text/javascript" src="JS/newUI/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="JS/backOffice/Admin/RoleMaster.js"></script>
<script type="text/javascript" src="JS/newUI/bootstrap.min.js"></script>
<script type="text/javascript" src="JS/common.js"></script>


<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet">
<link href="CSS/newUI/modern-business.css" rel="stylesheet">
<link href="CSS/newUI/custome.css" rel="stylesheet">
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
	

<style>

.save:hover {
	cursor: pointer;
}
</style>


</head>

<body>
	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		
		<p style="margin: 10px 0px;">
			<img src="images/addstu.png" />&nbsp;<span>Role Details</span>
			
		</p>
		
	
						<div class="errormessagediv" align="center" style="display: none;">
							<div class="message-item">
								<!-- Warning -->
								<a href="#" class="msg-warning bg-msg-warning"><span
									class="validateTips"></span></a>
							</div>
						</div>
				
			
					
						<div class="successmessagediv" align="center"  style="display: none;">
								<div class="message-item">
									<!-- Warning -->
									<a href="#" class="msg-success bg-msg-succes"><span class="successmessage"></span></a>
								</div>
						</div>
	
				

		<form method="post" id="myform">
			<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
				<div class="panel panel-primary">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>&nbsp;&nbsp;Role Details
							</a>
							</h4>

							<div class="navbar-right">
									
								 <span class="save2"> <img src="images/save.png" id="save" data-toggle="tooltip" data-placement="bottom" title="Save" ></span> 
								 
								 <a href="adminMenu.html?method=roleList">
								 <span class="glyphicon glyphicon-list2" data-toggle="tooltip" data-placement="bottom" title="List"></span>
								 </a>
								 
							</div>
						
					</div>

	<script>
	$(document).ready(function(){
	    $('[data-toggle="tooltip"]').tooltip();   
	});
	</script>
					
					
					
					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							<div class="col-md-6" style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;" >
								<br />
								<div class="form-group">
								
								<input type="hidden" id="rolecode" value="<logic:present name="RoleDetails"><bean:write name="RoleDetails" property="roleCode"/></logic:present>"/>
								
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Role Name
										</label>
									<div class="col-xs-7">
										<input type="text" name="rolename" id="rolename"  class="form-control"
											maxlength="25" value="<logic:present name="RoleDetails"><bean:write name="RoleDetails" property="roleName"/></logic:present>" />
									</div>
								</div>
								<br />
								
								
								

								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Role Description
										</label>
									<div class="col-xs-7">
										<textarea style="resize:none" rows="3" cols="25" class="form-control"
											name="roleDescription" id="description" ><logic:present name="RoleDetails"><bean:write name="RoleDetails" property="roleDescription"/></logic:present></textarea>
									</div>
								</div>
								<br />

							</div>
						</div>
					</div>
				
					<!-- <button type="reset" class="btn btn-info" id="clear">Clear</button> -->
					<br />
				</div>
		</form>
		</div>
	</div>
</body>

</html>


