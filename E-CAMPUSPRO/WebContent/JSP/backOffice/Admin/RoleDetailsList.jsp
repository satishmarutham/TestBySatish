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

<title>eCampus Pro</title>
<script type="text/javascript" src="JS/common.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JS/backOffice/Admin/RoleMaster.js"></script>
<link href="CSS/newUI/custome.css" rel="stylesheet" type="text/css">
</head>


<style>
.glyphicon:hover{

cursor: pointer;
}
#excelDownload :hover {
	cursor: pointer;
}
#pdfDownload:hover {
	cursor: pointer;
}
#iconsimg:hover {
	cursor: pointer;
}


/* .sortable{

 background: #f9f9f9 !important;
    border-bottom: 1px solid #ddd;
    border-top: 1px solid #ddd;
    font-family: Roboto bold !important;
    font-size: 11pt;
    color: #000 !important;
}
sortable:HOVER {
	color: #767676 !important ;
} */
</style>



<body>


	<div class="col-md-10" id="div1">
		<div class="col-md-8" id="div2">

			<p style="margin: 16px 0px;">
				<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<span
					id="pageHeading">Role details</span>
			</p>
			
		</div>
		<div align="right" class="input-group col-md-4" style="margin: 20px 0px;" >
		

			<input type="text" class="form-control" Placeholder="Search......" id="searchterm" value="<logic:present name="searchTerm"><bean:write name="searchTerm"></bean:write></logic:present>">
			<span class="input-group-btn">
				<button class="btn btn-default" type="button" id="search">
					<i class="fa fa-search"></i>
				</button>
			</span>
		</div>
		
			
	<input type="hidden" name="searchterm" class="searchtermclass"
			id="searchexamid"
			value='<logic:present name="searchnamelist"><bean:write name="searchnamelist" />

													</logic:present>'></input>		
		
		
		
		
	<div class="errormessagediv" align="center" style="display: none;">
							<div class="message-item" >
								<!-- Warning -->
								<a href="#" class="msg-warning bg-msg-warning"><span
									class="validateTips"></span></a>
							</div>
						</div>
			
					
						<div class="successmessagediv" align="center" style="display: none;">
								<div class="message-item">
									<!-- Warning -->
									<a href="#" class="msg-success bg-msg-succes"><span class="successmessage"></span></a>
								</div>
						</div>
			
		
		<div class="panel panel-primary">
			<div class="panel-heading">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#collapseOne" style="color: #fff;"><h3
						class="panel-title" style="color: #767676;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;Role
						 Details
					</h3></a>
				<div class="navbar-right">
						 <a href="role.html?parameter=getRoleEntry">
					 		<span class="glyphicon glyphicon-plus" data-toggle="tooltip" data-placement="bottom" title="Add"></span>
					 	</a>	
					
						<span class="glyphicon glyphicon-pencil" id="edit" data-toggle="tooltip" data-placement="bottom" title="Edit"></span>
						
						<span class="glyphicon glyphicon-trash" id="delete" data-toggle="tooltip" data-placement="bottom" title="Delete"></span>
					
					 <img src="images/download.png" class="download" id="iconsimg"
						data-toggle="modal" data-target="#myModal" data-toggle="tooltip"
						data-placement="bottom" title="Download">

				</div>
				<script>
							$(document).ready(function() {
								$('[data-toggle="tooltip"]').tooltip();
							});
						</script>
			</div>
			<!-- pop up -->

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
							<span id="excelDownload"><img src="images/xl.png"
								class="xl"></span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
								id="pdfDownload"><img src="images/pdf.png" class="pdf"></span>
						</div>

					</div>
				</div>
			</div>
			<div id="collapseOne" class="accordion-body collapse in">
				<div class="panel-body"
					style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
					
					
					<display:table name="requestScope.roleMasterList"  
							requestURI="/adminMenu.html?method=roleList" pagesize="10" export="false"
							decorator="com.centris.campus.decorator.RoleMasterDecorator"
							class="table" id="allstudent">

						<display:column property="checkBox" sortable="true"
							title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />" media="html">
							</display:column>

						<display:column property="roleName" sortable="true"
							title="Role Name <img src='images/sort1.png' style='float: right'/>" />

						<display:column property="roleDescription" sortable="true"
							title="Description <img src='images/sort1.png' style='float: right'/>" />


						<display:setProperty name="paging.banner.page.separator" value=""></display:setProperty>

						<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>


					</display:table>
					
					
				
				</div>
				<br />
			</div>
		</div>
	</div>
	<script src="JS/newUI/jquery.js"></script>
	<script src="JS/newUI/bootstrap.min.js"></script>
	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		})
	</script>
</body>
</html>
