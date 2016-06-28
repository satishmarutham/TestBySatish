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

<script src="JS/newUI/jquery.js"></script>
<script src="JS/newUI/bootstrap.min.js"></script>
<script src="JS/backOffice/Admin/UserRolePermission.js"></script>
<script type="text/javascript" src="JS/common.js"></script>

<title>eCampus Pro</title>

<style>
#editDesignationId:hover {
	cursor: pointer;
}

#trash:hover {
	cursor: pointer;
}

</style>
</head>

<body>

<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span id="pageHeading">Assign Permissions</span>
		</p>
		
		
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
					

		<form method="post">
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Role Permissions
							</a>

							<div class="navbar-right" style="float: right; margin: -10px;">
								<img src="images/rightline.png" style="margin-top: -5px;">
							
							<span id="savePermission"><img src="images/save.png"
									style="font-size: 20px; line-height: 34px; color: #989898; margin-top: -5px;" data-toggle="tooltip" data-placement="bottom" title="Save Permissions"></span>	
								
					
							</div>
						</h4>
					</div>
					
					<script>
	$(document).ready(function(){
	    $('[data-toggle="tooltip"]').tooltip();   
	});
	</script>
					
					<div id="collapseOne" class="panel-collapse collapse in"
				role="tabpanel" aria-labelledby="headingOne">
				<div class="panel-body" id="filters">

					<div class="col-md-12" style="padding:0; ">
					<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							  <div class="panel-body"  id="tabletxt" style="padding:15px 0;">
							
								<div class="col-md-6" id="txtstyle">
									<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4" id="inputnames">Select Role<font color="red"></font></label>
									<div class="col-xs-7" id="selecti">
									<select name="roleName" id="roleId" class="form-control">
									<option value=""></option>
									<logic:present name="RolePermission" scope="session">
									<logic:iterate id="role" name="RolePermission" property="roleList" scope="session">
									<option value='<bean:write name="role" property="roleCode"/>,<bean:write name="role" property="roleName"/>'><bean:write name="role" property="roleName"/></option>
									</logic:iterate>
									</logic:present>
									</select>	
										</div> 
									</div><br/>
								</div>
							
								<div class="col-md-6" id="txtstyle">
									
									<div class="form-group">
										<label for="inputEmail" class="control-label col-xs-4" id="inputnames"><input type="checkbox" id='selectAll' name="" >&nbsp;&nbsp;&nbsp;&nbsp;Select All<font color="red"></font></label>
										
									</div><br/>
								</div>
								
			</div></div></div>
					</div>
					</div>
	
	<div class="col-md-12" style="padding:0;height:300px; !important;overflow-y:scroll !important; ">				
	<table  class="table" id="allstudent" style="font-family: Open Sans Light;color: #897676;" >
	<tr>
	 <th  width="20px !important;">Module</th>
	 <th >Sub Module</th>
	 <th style="text-align: center;width:130px !important;">PageAccess</th>  
	 <th   style="text-align: center;width:130px !important;">Add</th>
	 <th  style="text-align: center;width:130px !important;">Update</th> 
	 <th style="text-align: center;width:130px !important;">Delete</th>
	  <th  style="text-align: center;width:130px !important;">Download</th>
	  
	
	</tr>
	
	<logic:present name="RolePermission" scope="session">
	<logic:iterate id="creation" name="RolePermission" property="permissionList">
	<logic:notEmpty name="creation" property="submodule">
	<tr>
	
	
	 <td width="20px !important;"><bean:write name="creation" property="module"/></td>
	 <td >&nbsp;<input type="checkbox" id='${creation.submodule}All' />&nbsp;&nbsp;<bean:write name="creation" property="submodule"/></td>
	
	<td style="text-align: center;"><logic:match name="creation" value="${creation.submodule}"  property="permissionName">
	  <logic:iterate id="operation3" name="RolePermission" property="permissionList">
		<logic:match name="operation3" value="${creation.submodule} Display"  property="permissionName" >
		<input type="checkbox" class="permission permission${creation.submodule}" id='<bean:write name="operation3" property="permissionId"/>' name='<bean:write name="operation3" property="permissionShortName"/>'/>
	</logic:match>
	</logic:iterate>
	</logic:match>
	</td>
	
	<td style="text-align: center;">
	<logic:match name="creation" value="${creation.submodule}"  property="permissionName">
	<logic:iterate id="operation" name="RolePermission" property="permissionList">
		<logic:match name="operation" value="${creation.submodule} Creation"  property="permissionName" >
		<input type="checkbox" class="permission permission${operation.submodule}" id='<bean:write name="operation" property="permissionId"/>' name='<bean:write name="operation" property="permissionShortName"/>'/>
	</logic:match>
	</logic:iterate>
	</logic:match>
	</td>
	
	<td style="text-align: center;"><logic:match name="creation" value="${creation.submodule}"  property="permissionName">
	  <logic:iterate id="operation1" name="RolePermission" property="permissionList">
		<logic:match name="operation1" value="${creation.submodule} Update"  property="permissionName" >
		<input type="checkbox" class="permission permission${creation.submodule}" id='<bean:write name="operation1" property="permissionId"/>' name='<bean:write name="operation1" property="permissionShortName"/>'/>
	</logic:match>
	</logic:iterate>
	</logic:match>
	</td>
	
	<td style="text-align: center;"><logic:match name="creation" value="${creation.submodule}"  property="permissionName">
	  <logic:iterate id="operation2" name="RolePermission" property="permissionList">
		<logic:match name="operation2" value="${creation.submodule} Delete"  property="permissionName" >
		<input type="checkbox" class="permission permission${creation.submodule}" id='<bean:write name="operation2" property="permissionId"/>' name='<bean:write name="operation2" property="permissionShortName"/>'/>
	</logic:match>
	</logic:iterate>
	</logic:match>
	</td>
	
	
	<td style="text-align: center;"><logic:match name="creation" value="${creation.submodule}"  property="permissionName">
	  <logic:iterate id="operation4" name="RolePermission" property="permissionList">
		<logic:match name="operation4" value="${creation.submodule} Download"  property="permissionName" >
		<input type="checkbox" class="permission permission${creation.submodule}" id='<bean:write name="operation4" property="permissionId"/>' name='<bean:write name="operation4" property="permissionShortName"/>'/>
	</logic:match>
	</logic:iterate>
	</logic:match></td>
	
	</tr>
	</logic:notEmpty>
	</logic:iterate>
	</logic:present>
	

	
	</table>
	</div>				
					
					
					</div>
					</div>
					</form>
					</div>
					


</body>
</html>