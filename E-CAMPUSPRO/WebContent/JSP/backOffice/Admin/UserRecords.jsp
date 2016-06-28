
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
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JS/backOffice/Admin/userRecords.js"></script>
<script type="text/javascript" src="JS/common.js"></script>
<title>eCampus Pro</title>
<style>
.glyphicon:hover{

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


<style>
.glyphicon:hover {
	cursor: pointer;
}
/* .modal-body {
	text-align: center;
} */
</style>

<style>
.download:hover{

cursor: pointer;
}
#excelDownload:hover {
	cursor: pointer;
}
#pdfDownload:hover {
	cursor: pointer;
}
</style>
</head>

<body>

	<div class="col-md-10" id="div1">
		<div class="col-md-7" id="div2">

			<p style="margin: 16px 0px;">
				<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<span
					id="pageHeading">User Details</span>
			</p>
			
		</div>
		<div class="input-group col-md-5" id="txtstyle" >
		  <label style="margin: 20px 0px;width:12%;border: none;" class="form-control">Type</label>
		<select	name="typename" id="typename" class="form-control"
								onchange="selectClass()" style="width:30%;margin: 20px 0px;margin-left:0%;">
									<option value="">------Select--------</option>
									<option value="TEA">Teacher</option>
									<option value="PAR">Parent</option>

							</select>
			 <label style="margin: 20px 0px;width:12%;border: none; " class="form-control">Name</label>				
    			<input type="text" class="form-control" Placeholder="Search......"  id="searchTextId"    style="margin: 20px 0px;width:30%;">
		
				<button class="btn btn-default" type="button"   id="searchButtonId"        style="margin: 20px 0px;"  >
					<i class="fa fa-search"></i>
				</button>
			
		</div>
		
		<div class="errormessagediv"	style="display: none; margin-left: 30%;width: 100%;" >
							<div class="message-item" >
							       <!-- Warning -->
								<a href="#" class="msg-warning bg-msg-warning" style="text-align: center;"><span
									class="validateTips" style="text-align: center;"></span></a>
							</div>
						</div> 
							
						<div class="successmessagediv" style="display: none;margin-left: 30%;width: 100%;">
								<div class="message-item">
									<a href="#" class="msg-success bg-msg-succes" style="text-align: center;"><span class="successmessage" style="text-align: center;"></span></a>
								</div>
						</div>
				
		
		
		<div class="panel panel-primary">
			<div class="panel-heading">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#collapseOne" style="color: #fff;"><h3
						class="panel-title" style="color: #767676;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;User Details
					</h3></a>
				<div class="navbar-right" >
                  
                     
						<span class="glyphicon glyphicon-pencil3" id="Edit"  
						     data-toggle="tooltip" data-placement="bottom" title="Edit">
						</span>
					
					
						 <span	class="glyphicon glyphicon-trash" id="delete"
							 data-toggle="tooltip" data-placement="bottom" title="Delete">
						</span>
						
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
					<display:table class="table" id="allstudent" pagesize="10"
						name="requestScope.userRecords" 
						requestURI="/adminMenu.html?method=getUserRecords"
						decorator="com.centris.campus.decorator.UserManagementDecorator">

						<tr>
						    <td><display:column title="Select" property="select" ></display:column></td>
							<td><display:column property="firstName" title="Name" /></td>
							<td><display:column property="designation" title="Designation" /></td>
							<td><display:column property="userName" title="User Name" /></td>
							<td><display:column property="mobile" title="Mobile No" /></td>
						
						<td> <display:setProperty name="paging.banner.page.separator" value=""></display:setProperty></td>

						<td><display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty></td>
						
						
						</tr>
					</display:table>
					
					
				</div>
				<br />
			</div>
		</div>
	</div>
	
	<input type="hidden" id="hsearchTextId" value="<logic:present name="SearchText" scope="request"><bean:write name="SearchText" scope="request"></bean:write></logic:present>"></input>
	<input type="hidden" id="htype" value="<logic:present name="Type" scope="request"><bean:write name="Type" scope="request"></bean:write></logic:present>">
	
	
	
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
















