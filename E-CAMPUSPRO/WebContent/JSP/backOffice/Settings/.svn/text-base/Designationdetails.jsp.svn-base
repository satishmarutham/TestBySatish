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
<script type="text/javascript" src="JS/common.js"></script>
<script type="text/javascript" src="JS/backOffice/Settings/AddDesignation.js"></script>
<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet">
<link href="CSS/newUI/modern-business.css" rel="stylesheet">
<link href="CSS/newUI/custome.css" rel="stylesheet">
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"rel="stylesheet" type="text/css">

	
<title>eCampus Pro</title>
<style>
#editDesignationId:hover {
	cursor: pointer;
}

#deleteDesignationId:hover {
	cursor: pointer;
} 
#xlss:hover {
	cursor: pointer;
}
.download:hover{

cursor: pointer;
}

#pdfDownload:hover {
	cursor: pointer;
}
</style>

</head>

<body>
  
	                    <div class="col-md-10" id="div1">
		                    <div class="col-md-8" id="div2">
			<p style="margin: 16px 0px;">
				<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<span
					id="pageHeading">Designation details</span>
			</p>
		</div>
		
		
		<div class="input-group col-md-4" style="margin: 20px 0px;">

			<input type="text" class="form-control" id="searchvalue" Placeholder="Search......"  >
			<span class="input-group-btn">
				<button class="btn btn-default" type="button" id="search">
					<i class="fa fa-search"></i>
				</button>
			</span>
		</div>
		
		
		
		
		
		<logic:present name="successmessagediv" scope="request">
			<div class="successmessagediv" align="center">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-success bg-msg-succes"><span><bean:write
								name="successmessagediv" scope="request" /></span></a>
				</div>
			</div>
		</logic:present>
		
			
					
						<div class="successmessagediv" align="center" style="display: none;">
								<div class="message-item">
									
									<a href="#" class="msg-success bg-msg-succes"><span class="successmessagediv"></span></a>
								</div>
						</div>
						
						
						<div class="errormessagediv" align="center" style="display: none;">
							<div class="message-item">
								
								<a href="#" class="msg-warning bg-msg-warning"><span
									class="validateTips"></span></a>
							</div>
						</div>
						
						
					 <div class="errormessagediv1" align="center" style="display: none;">
				      <div class="message-item1"></div></div>
				      
				      
		 
		
		
		
		
		
		
		
		
		
		<div class="panel panel-primary">
			<div class="panel-heading">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#collapseOne" style="color: #fff;"><h3
						class="panel-title" style="color: #767676;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;Designation
						Details
					</h3></a>
			<div class="navbar-right" >
					
					
					
					
					 <a	href="adminMenu.html?method=adddesignation">
					 <span class="glyphicon glyphicon-plus" data-toggle="tooltip" data-placement="bottom" title="Add" ></span>
					
					 </a> 
					 
					 
				    
				     <span id="editDesignationId" class="glyphicon glyphicon-pencil"   data-toggle="tooltip" data-placement="bottom" title="Edit" ></span>
				    
				    
				     
				     <span  id="deleteDesignationId"class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="bottom" title="Delete" ></span>
				   
					 	 
					
					<!--  <span class="glyphicon glyphicon-print" style="font-size: 20px; line-height: 34px; color: #989898;"></span>
					 <img src="images/rightline.png" style="margin-top: -5px;">
					 </a>  -->
					 
					 <!-- <span id="xlss" >
						 <img src="images/download.png" class="download"  data-toggle="tooltip" data-placement="bottom" title="Download" >
					 </span> -->
					 
					 
				<img src="images/download.png" class="download" id="iconsimg" style=""
								data-toggle="modal" data-target="#myModal" data-toggle="tooltip"
								data-placement="bottom" title="Download">		 
					 
					 
					 
 
				</div> 
			
								<script>
				$(document).ready(function() {
					$('[data-toggle="tooltip"]').tooltip();
				});
			</script>
			
	</div>
			
			
			
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
									<span id="xlss"><img src="images/xl.png"
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
												
					
					<logic:present name="DesignationDetails" scope="request">
					
					
					<display:table id="allstudent" class="table"  name="requestScope.DesignationDetails"  export="false" 
					 requestURI="/adminMenu.html?method=designationList"
					 
					pagesize="10" decorator="com.centris.campus.decorator.AddDesignationDecorator">
				
				    <display:column property="designationCheckBox" sortable="true" title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />" />
				    <display:column property="desgname" sortable="true"   title=" Designation Name<img src='images/sort1.png' style='float: right'/>" />
				    <display:column property="desgdes"  sortable="true"  title="Description<img src='images/sort1.png' style='float: right'/>" />
					
					
					
						<display:setProperty name="paging.banner.page.separator" value=""></display:setProperty>

						<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
					
					
					</display:table>
					
					
					</logic:present>
						
				
		
				</div>
				<br />
			</div>
		</div>
	</div>
	
	<!-- <script src="JS/newUI/jquery.js"></script>
	<script src="JS/newUI/bootstrap.min.js"></script>
	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		})
	</script> -->
</body>
</html>