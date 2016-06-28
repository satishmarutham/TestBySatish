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
<script type="text/javascript" src="JS/common.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script src="JS/newUI/jquery.js"></script>
<script src="JS/newUI/bootstrap.min.js"></script>
<script type="text/javascript" src="JS/backOffice/Admin/career.js"></script>
<title>eCampus Pro</title>

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
					id="pageHeading">Internal Job Posting</span>
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
		
		
			
		
	<input type="hidden" name="searchterm" class="searchtermclass"
			id="searchexamid"
			value='<logic:present name="searchnamelist"><bean:write name="searchnamelist" />

													</logic:present>'></input>		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			<div class="successmessagediv" style="display: none;">
				<div class="message-item" align="center">
					<!-- Warning -->
					<a href="#" class="msg-success bg-msg-succes"><span
						class="successmessage"></span></a>
				</div>
			</div>


			<div class="errormessagediv1"align="center"
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
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;Internal
						Job Posting
					</h3></a>
				<div class="navbar-right"">
					 <span
						id="plus" class="glyphicon glyphicon-plus"
						  data-toggle="tooltip" data-placement="bottom" title="Add"></span> <span
						id="editDesignationId" class="glyphicon glyphicon-pencil"
						 data-toggle="tooltip" data-placement="bottom" title="Edit"> </span> <span
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
						name="requestScope.career" pagesize="10"
						requestURI="/adminMenu.html?method=careerupdate" defaultsort="3"
						decorator="com.centris.campus.decorator.CareerUpdateDecorator">
						<display:column property="check" sortable="true" title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />" />
						<display:column property="title" sortable="true" title="Title<img src='images/sort1.png' style='float: right'/>" />
						<display:column property="qualification" sortable="true" title="Qualification<img src='images/sort1.png' style='float: right'/>" />
						<display:column property="noofposition" sortable="true" title="No of Position<img src='images/sort1.png' style='float: right'/>"></display:column>
						<display:column property="experience" sortable="true" title="Experience<img src='images/sort1.png' style='float: right'/>"></display:column>
						<display:column property="status" sortable="true" title="Status<img src='images/sort1.png' style='float: right'/>"></display:column>
					
					
					
						<display:setProperty name="paging.banner.page.separator" value=""></display:setProperty>

						<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
					
					
					
					</display:table>
				
				</div>
				<br />
			</div>
		</div>
	</div>


</body>
</html>