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

<script type="text/javascript"
	src="JS/backOffice/Teacher/AssignmentList.js"></script>

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

	<div class="col-md-10" id="div1">
		<div class="col-md-8" id="div2">

			<p style="margin: 16px 0px;">
				<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<span
					id="pageHeading">ASSIGNMENT DETAILS</span>
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


		<center>
		
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
				
		
		<logic:present name="message">
			<div class="successmessagediv" >
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-success bg-msg-succes">
					<span><bean:write name="message"/></span></a>
				</div>
			</div>
		</logic:present>
		
		
		<logic:present name="errormessagediv" scope="request">
			<div class="errormessagediv" >
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-warning bg-msg-warning"><span
						class="validateTips"><bean:write name="errormessagediv"
								scope="request" /></span></a>
				</div>
			</div>
		</logic:present>
		
		</center>


		<div class="panel panel-primary">
			<div class="panel-heading">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#collapseOne" style="color: #fff;"><h3
						class="panel-title" style="color: #767676;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;
					</h3></a>
				<div class="navbar-right">
					 <a href="teachermenuaction.html?method=addassignment" id="plus">
					 	<span class="glyphicon glyphicon-plus"></span>
					 </a>
					  
					  <span class="glyphicon glyphicon-pencil" style="cursor: pointer;" id="edit"></span>
					
					  
					  	 <span id="trash" class="glyphicon glyphicon-trash" style="cursor: pointer;"></span>
				
					
					<a href=""><img src="images/download.png" class="download"></a>
				</div>
			</div>  

			<div id="collapseOne" class="accordion-body collapse in">
				<div class="panel-body"
					style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">

							<div id="collapseOne" class="accordion-body collapse in">
				<div class="panel-body"
					style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
					
					<display:table class="table" id="allstudent"
					
						name="requestScope.AssignmentList" pagesize="10"
						requestURI="/teachermenuaction.html?method=assignmentView"
						decorator="com.centris.campus.decorator.AssignmentDecorator">


						<display:column property="check" style="text-align:center"
							sortable="true"
							title="<input type='checkbox' name='selectall' style='text-align:center' id='selectall' onClick='selectAll()' />"></display:column>


						<display:column property="classname" sortable="true"
							title="Class  <img src='images/sort1.png' style='float: right'/>"
							media="html"></display:column>


						<display:column property="section" sortable="true"
							title="Section <img src='images/sort1.png' style='float: right'/>"
							media="html"></display:column>

						<display:column property="assigName" sortable="true"
							title="Assignment Name <img src='images/sort1.png' style='float: right'/>"
							media="html"></display:column>

						<display:column property="startdate" sortable="true"
							title="Assignment Date <img src='images/sort1.png' style='float: right'/>"
							media="html"></display:column>



						<display:column property="enddate" sortable="true"
							title="Completion Date <img src='images/sort1.png' style='float: right'/>"
							media="html"></display:column>


						<display:column property="subjectname" sortable="true"
							title="Subject Name <img src='images/sort1.png' style='float: right'/>"
							media="html"></display:column>
							
						<display:column property="marks" sortable="true"
							title="Max Marks <img src='images/sort1.png' style='float: right'/>"
							media="html"></display:column>	
						
					</display:table>

					
				</div>
				<br />
			</div>
				
				</div>
				<br />
			</div>
		</div>
	</div>


</body>
</html>