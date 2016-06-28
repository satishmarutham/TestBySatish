<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>eCampus Pro</title>


<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet">
<link href="CSS/newUI/modern-business.css" rel="stylesheet">
<link href="CSS/newUI/custome.css" rel="stylesheet">
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css"> 

 <script type="text/javascript" src="JS/backOffice/Transport/DriverEditingPage.js"></script> 

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
</style>
<body>

	<div class="col-md-10" id="div1">
		<div class="col-md-8" id="div2">

			<p style="margin: 16px 0px;">
				<span class="glyphicon glyphicon-user" ></span>&nbsp;&nbsp;<span id="pageHeading">Drivers List</span>
			</p>
		</div>
		
		
		<form id="myForm" action="driverDetailsPath.html?method=searchDriverDetails" method="post">
		<div class="input-group col-md-4" style="margin: 20px 0px;">
			<input type="text" name="searchname" id="searchname" class="form-control" Placeholder="Search......"
			value='<logic:present name="searchname"><bean:write name="searchname"/></logic:present>'>
			<span class="input-group-btn">
				<button class="btn btn-default" type="button" id="search" onclick="myFunction()"value="Submitform">
					<i class="fa fa-search"></i>
				</button>
			</span>
		</div>
		</form>
		
			<div class="errormessagediv" align="left" style="display: none;">
					<div class="message-item">
					<!-- Warning -->
				    <a href="#" class="msg-warning bg-msg-warning"><span
					class="validateTips"></span></a>
					</div>
					</div>	
			<div class="successmessagediv" align="left" style="display: none;">
			<div class="message-item">
			<!-- Warning -->
			<a href="#" class="msg-success bg-msg-succes"><span	class="validateTips"></span></a>
			</div>
			</div>	
					
					
					
					
		
		<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingOne">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#collapseOne" style="color: #fff;"><h3
						class="panel-title" style="color: #767676;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;Driver
						Details
					</h3></a>
					
				
				<div class="navbar-right" >
				
					<a
						href="driverDetailsPath.html?method=addDriver"><span
						class="glyphicon glyphicon-plus"
						 data-toggle="tooltip" data-placement="bottom" title="Add"></span></a>
						
						
						
						<span class="glyphicon glyphicon-pencil" id="editdriver"
						 data-toggle="tooltip" data-placement="bottom" title="Edit"></span>
						
						
						<span class="glyphicon glyphicon-trash" id="delete"
						 data-toggle="tooltip" data-placement="bottom" title="Delete"></span>
						
						
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
					
				
					<logic:present name="driverList" scope="request">	
				<display:table class="table" pagesize="10" 
				    name="requestScope.driverList" 
					requestURI="adminMenu.html?method=driverList"
				     decorator="com.centris.campus.decorator.DriverMasterDecorator"
					 id="allstudent" >
					
					<display:column property="check" sortable="true" title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />"></display:column>
					<display:column property="driverName" sortable="true" title="Driver Name <img src='images/sort1.png' style='float: right'/>"></display:column>
					<display:column property="dateofJoin" sortable="true" title="Date Of Joining <img src='images/sort1.png' style='float: right'/>"></display:column>
					<display:column property="mobile" sortable="true" title="Mob NO <img src='images/sort1.png' style='float: right'/>"></display:column>
					<display:column property="drivingliecenseNo" sortable="true" title="Driving License No <img src='images/sort1.png' style='float: right'/>"></display:column>
					<display:column property="dl_issued_date" sortable="true" title="DL Issued Date<img src='images/sort1.png' style='float: right'/>"></display:column>
					<display:column property="dl_validity" sortable="true" title="DL Experied Date<img src='images/sort1.png' style='float: right'/>"></display:column>
					
					</display:table>
					
					</logic:present>
				
				</div>
				<br />
			</div>
			</div>
		</div>
	</div>
	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		})
	</script>
</body>
</html>