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



<script type="text/javascript" src="JS/backOffice/Admin/TimeTable.js"></script>
<script type="text/javascript" src="JS/common.js"></script>


<title>eCampus Pro</title>

<style>
#editDesignationId:hover {
	cursor: pointer;
}

.glyphicon-pencil:hover {
	cursor: pointer;
}

#trash:hover {
	cursor: pointer;
}

.glyphicon:hover {
	cursor: pointer;
}
.download:hover{

cursor: pointer;
}
#xls:hover {
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
					id="pageHeading">Time Table</span>
			</p>
		</div>
		
		<input type="hidden" id="hviewBy" value="<logic:present name="ViewBy"><bean:write name="ViewBy"/></logic:present>"/>

		<div class="input-group col-md-5">
			
			<label 
				class="hedderstyle form-control" style="width: 32% !important;margin-left: 33% !important">View Time Table By</label> 
			<select name="classname" id="classname" class="form-control" onchange="selectClass()" style="width: 35%; margin: 20px 0px; margin-left: 0%;">
				
				<option value="class">Class</option>
				<option value="teacher">Teacher</option>
			
			</select> 
			
		
		</div>


		<center>
			
			<div class="errormessagediv" align="left" style="display: none;">
					<div class="message-item">
					<!-- Warning -->
				    <a href="#" class="msg-warning bg-msg-warning"><span
					class="validateTips"></span></a>
					</div>
					</div>	
		</center>


		<div class="panel panel-primary">
			<div class="panel-heading">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#collapseOne" style="color: #fff;"><h3
						class="panel-title" style="color: #767676;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;Time Table Details
					</h3></a>
				<div class="navbar-right">
				
					
							<span class="glyphicon glyphicon-pencil3" id="edit" data-toggle="tooltip" data-placement="bottom" title="Edit Fee"></span>
							
							 <!-- <a href=""> <img src="images/download.png" class="downloadlast"></a> -->
							 
							 
							 
							 <img src="images/download.png" class="download" id="iconsimg" style="    margin-left: 2px;"
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
									<span id="xls"><img src="images/xl.png"
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
					
					
					
					<logic:present name="ClassTimeTableList">
					<display:table  name="requestScope.ClassTimeTableList" requestURI="adminMenu.html?method=gettimetable"
						
						pagesize="10" export="false" class="table" id="allstudent">

					<display:column 
							title="<input type='checkbox' name='selectall' id='selectall'  onClick='selectAll()' />" >
							<input type="checkbox" name="selectBox" id="selectBox"  value="${allstudent.timetableId},${allstudent.classid},${allstudent.sectionid}" />
					</display:column>
					
						<display:column property="classname" sortable="true" title="Class Name  <img src='images/sort1.png' style='float: right'/>" />
						<display:column property="sectionname" sortable="true" title="Section Name  <img src='images/sort1.png' style='float: right'/>" />
						<display:column property="timetableStatus" sortable="true" title="Status  <img src='images/sort1.png' style='float: right'/>" />
						<display:column property="createdby" sortable="true" title="Created By <img src='images/sort1.png' style='float: right'/>" />	
						<display:column property="createddate" sortable="true" title="Create Date <img src='images/sort1.png' style='float: right'/>" />	
						<display:column property="lastupdatedby" sortable="true" title="Updated By <img src='images/sort1.png' style='float: right'/>" />	
						<display:column property="lastupdated" sortable="true" title="Update Date <img src='images/sort1.png' style='float: right'/>" />
					
						<display:setProperty name="paging.banner.page.separator" value=""></display:setProperty>

						<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
					
					</display:table>
				</logic:present>
				
				<logic:present name="TeacherTimeTableList">
					<display:table  name="requestScope.TeacherTimeTableList" requestURI="adminMenu.html?method=gettimetable"
						
						pagesize="10" export="false" class="table" id="allstudent">

					<display:column 
							title="<input type='checkbox' name='selectall' id='selectall'  onClick='selectAll()' />" >
							<input type="checkbox" name="selectBox" id="selectBox"  value="${allstudent.teacherId},${allstudent.teachername}" />
					</display:column>
					
						<display:column property="regno" sortable="true" title="Teacher Id  <img src='images/sort1.png' style='float: right'/>" />
						<display:column property="teachername" sortable="true" title="teachername Name  <img src='images/sort1.png' style='float: right'/>" />
						<display:column property="timetableStatus" sortable="true" title="Status  <img src='images/sort1.png' style='float: right'/>" />
						<display:column property="createdby" sortable="true" title="Created By <img src='images/sort1.png' style='float: right'/>" />	
						<display:column property="createddate" sortable="true" title="Create Date <img src='images/sort1.png' style='float: right'/>" />	
						<display:column property="lastupdatedby" sortable="true" title="Updated By <img src='images/sort1.png' style='float: right'/>" />	
						<display:column property="lastupdated" sortable="true" title="Update Date <img src='images/sort1.png' style='float: right'/>" />
				
				
					<display:setProperty name="paging.banner.page.separator" value=""></display:setProperty>

						<display:setProperty name="paging.banner.placement" value="bottom"></display:setProperty>
				
				
				
					</display:table>
				</logic:present>
				
				
				</div>
				<br />
			</div>
		</div>
	</div>


</body>
</html>