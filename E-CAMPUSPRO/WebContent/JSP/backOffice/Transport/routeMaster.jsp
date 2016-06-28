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

<script type="text/javascript" src="JS/newUI/jquery-1.9.1.min.js"></script>
<script src="JS/newUI/jquery.js"></script>
<script src="JS/newUI/bootstrap.min.js"></script>
<script type="text/javascript"
	src="JS/backOffice/Transport/routeMaster.js"></script>


<title>eCampus Pro</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<!-- <script type="text/javascript" src="JS/backOffice/Admin/RoleMaster.js"></script>
 --><link href="CSS/newUI/custome.css" rel="stylesheet" type="text/css">

<style>
#editDesignationId:hover {
	cursor: pointer;
}

#trash:hover {
	cursor: pointer;
}

#plus:hover {
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

</head>

<body>

	<div class="col-md-10" id="div1">
		<div class="col-md-8" id="div2">

			<p style="margin: 16px 0px;">
				<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<span
					id="pageHeading">Route Master</span>
			</p>
		</div>

		<div class="input-group col-md-4" style="margin: 20px 0px;">

			<input type="text" class="form-control" Placeholder="Search......"
				id="search"> <span class="input-group-btn">
				<button class="btn btn-default" type="button" id="searchid">
					<i class="fa fa-search"></i>
				</button>
			</span>
		</div>
			<logic:present name="message" scope="request">
				<div class="successmessagediv">
					<div class="message-item">
						<!-- Warning -->
						<a href="#" class="msg-success bg-msg-succes"><span><bean:write
									name="message" scope="request" /></span></a>
					</div>
				</div>
			</logic:present>

			<logic:present name="error" scope="request">
				<div class="successmessagediv">
					<div class="message-item">
						<!-- Warning -->
						<a href="#" class="msg-warning bg-msg-warning"><span><bean:write
									name="error" scope="request" /></span></a>
					</div>
				</div>
			</logic:present>

			<div class="successmessagediv" style="display: none;">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-success bg-msg-succes"><span
						class="successmessage"></span></a>
				</div>
			</div>


			<div class="errormessagediv1"
				style="display: none; text-align: center;">
				<div class="message-item1">
					<!-- Warning -->
					<a href="#" class="msg-warning1 bg-msg-warning1"
						style="width: 50%; font-size: 11pt; color: red;"><span
						class="validateTips1"></span></a>
				</div>
			</div>

		<div class="panel panel-primary">
			<div class="panel-heading">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#collapseOne" style="color: #fff;"><h3
						class="panel-title" style="color: #767676;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;
						Route Master
					</h3></a>
				<div class="navbar-right" >
				
					<span
						id="plus" class="glyphicon glyphicon-plus"
						data-toggle="tooltip" data-placement="bottom" title="Add">
					</span> 
					
					<span
						id="editDesignationId" class="glyphicon glyphicon-pencil"
						data-toggle="tooltip" data-placement="bottom" title="Edit">
					 </span> 
					 
					 <span
						id="trash" class="glyphicon glyphicon-trash"
						
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
					<display:table class="table" id="allstudent"
						name="requestScope.getTpMasterDetails" pagesize="10"
						requestURI="/adminMenu.html?method=routeMasterSettings"
						defaultsort="3"
						decorator="com.centris.campus.decorator.TransportDecorator">

						<display:column property="check"
							title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />" />
						<display:column property="routeNo" sortable="true"
							title="Route No" />
						<display:column property="routeName" sortable="true"
							title="Route Name" />
						<display:column property="stratTime" sortable="true"
							title="Start Time" />
						<display:column property="endTime" sortable="true"
							title="End Time" />
						<display:column property="totalStops" sortable="true"
							title="Total Stops" />
						<display:column property="totalDistance" sortable="true"
							title="Total Distance" />
						<display:column property="halttime" sortable="true"
							title="Halt Time" />
						<display:column property="destination" sortable="true"
							title="Destination" />
						<display:column property="stop" sortable="true"
							title="Update Stop Details" />

					</display:table>

					<ul class="pagination" style="float: right; margin: 0;">
						<li><a href="#">&laquo;</a></li>
						<li class="active"><a href="#">1</a></li>
						<li class=""><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">&raquo;</a></li>
					</ul>
				</div>
				<br />
			</div>
		</div>
	</div>


</body>
</html>