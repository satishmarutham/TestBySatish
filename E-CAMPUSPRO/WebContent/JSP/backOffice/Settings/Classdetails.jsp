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
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JS/backOffice/Settings/classList.js"></script>
<script type="text/javascript" src="JS/common.js"></script>
<title>eCampus Pro</title>
<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet">

<link href="CSS/newUI/modern-business.css" rel="stylesheet">
<link href="CSS/newUI/custome.css" rel="stylesheet">
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
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


</head>

<body>

	<div class="col-md-10" id="div1">
		<div class="col-md-8" id="div2">

			<p style="margin: 16px 0px;">
				<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<span id="pageHeading">Class
					details</span>
			</p>
		</div>
		 <div class="input-group col-md-4" style="margin: 20px 0px;">

			<!-- <input type="text" class="form-control" id="searchValue" Placeholder="Search......" > -->
			
			<input type="text" name="searchname" id="searchValue"
					class="form-control" Placeholder="Search....."
					value='<logic:present name="searchname"><bean:write name="searchname"/></logic:present>'>
			<span class="input-group-btn">
				<button class="btn btn-default" type="button" id="searchClass">
					<i class="fa fa-search"></i>
				</button>
			</span>
		</div> 
		
		
		
		
		
	<input type="hidden" name="searchterm" class="searchtermclass"
			id="searchexamid"
			value='<logic:present name="searchnamelist"><bean:write name="searchnamelist" />

													</logic:present>'></input>		
		
		
		
		
		
<%-- 		
	<form id="myForm"
			action="adminMenu.html?method=streamList" method="post">

			<div class="input-group col-md-4" style="margin: 20px 0px;">
				<input type="text" name="searchname" id="searchname"
					class="form-control" Placeholder="Search......"
					value='<logic:present name="searchname"><bean:write name="searchname"/></logic:present>'>
				<span class="input-group-btn">
					<button class="btn btn-default" type="button" id="search"
						onclick="myFunction()" value="Submitform">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>	
		
		
		 --%>
		
		
		
		
		
					<logic:present name="successmessagediv"  scope="request">
						<div class="successmessagediv" align="center">
							<div class="message-item">
								<!-- Warning -->
								<a href="#" class="msg-success bg-msg-succes"><span><bean:write
											name="successmessagediv" scope="request" /></span></a>
							</div>
						</div>
					</logic:present>
			<div class="errormessagediv" align="center" style="display: none;">
						<div class="message-item">
							<!-- Warning -->
							<a href="#" class="msg-warning bg-msg-warning"><span
								class="validateTips"></span></a>
						</div>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#collapseOne" style="color: #fff;"><h3
						class="panel-title" style="color: #767676;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;Class
						Details
					</h3></a>
				<div class="navbar-right" >
					
					
						<a href="classPath.html?method=addClass"><span
						class="glyphicon glyphicon-plus"
						  data-toggle="tooltip" data-placement="bottom" title="Save"></span></a>
				
						
					<span id="editClass" class="glyphicon glyphicon-pencil" 
					
									  data-toggle="tooltip" data-placement="bottom" title="Edit"></span>
									
									
									
									
									
									<span class="glyphicon glyphicon-trash" id="classDelete"
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
					
					<logic:present name="classList" scope="request">
					<display:table  class="table" id="allstudent"
						name="classList" pagesize="10"
						   decorator="com.centris.campus.decorator.ClassDecorator"
						requestURI="/adminMenu.html?method=classList">
					
                        <display:column property="check"  sortable="true" title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />" /> 
						<display:column property="streamName" sortable="true" title="Stream <img src='images/sort1.png' style='float: right'/>" />
						<display:column property="className" sortable="true" title="Class <img src='images/sort1.png' style='float: right'/>" />
						
						<display:setProperty name="paging.banner.page.separator" value=""></display:setProperty>

						<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
				
					</display:table>
					</logic:present>

					
		
			
				
				</div>
				<br />
	
			</div>
		</div>
	</div>
	<script src="JS/newUI/jquery.js"></script>
	<script src="JS/newUI/bootstrap.min.js"></script>

</body>
</html>