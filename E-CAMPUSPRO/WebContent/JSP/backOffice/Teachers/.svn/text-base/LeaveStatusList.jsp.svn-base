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
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JS/newUI/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.datepicker.js"></script>

<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet">
<link href="CSS/newUI/modern-business.css" rel="stylesheet">
<link href="CSS/newUI/custome.css" rel="stylesheet">
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">


<script type="text/javascript"
	src="JS/backOffice/Teacher/LeaveRequest.js"></script>

<!-- <script type="text/javascript"
	src="JS/backOffice/Teacher/LeaveRequestTeacher.js"></script>  -->

<title>eCampus Pro</title>

<style>
#plus:hover {
	cursor: pointer;
}

#editID:hover {
	cursor: pointer;
}

#delete:hover {
	cursor: pointer;
}

.download:hover {
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
		<div class="col-md-8" id="div2">

			<p style="margin: 16px 0px;">
				<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<span
					id="pageHeading">LEAVE REQUEST DETAILS</span>
			</p>
		</div>

		<div class="input-group col-md-4" style="margin: 20px 0px;">

			<input type="text" class="form-control" Placeholder="Search......"
				id="searchterm"> <span class="input-group-btn">
				<button class="btn btn-default" type="button" id="search">
					<i class="fa fa-search"></i>
				</button>
			</span>


			<div class="form-group">
				<%-- <label for="inputPassword" class="control-label col-xs-3"
										style="text-align: left;    line-height: 35px;    color: #797676;    font-size: 16px;    font-family: Open Sans Light;">Student</label> 
									<div class="col-xs-7">
									
									<logic:present name="studentlist" scope="request">
								          <select name="studentFname" id="parentchild" class="form-control" >
									  <option value="">---Select--- </option>
										    <logic:iterate id="stream" name="studentlist" scope="request">
											<option value='<bean:write name='stream' property='stdAdmisiionNo'/>'>
											<bean:write name='stream' property='studentFnameVar'/></option>
										    </logic:iterate>
							                </select>
											</logic:present>
										
									</div>  --%>
			</div>
		</div>


		<div class="errormessagediv" align="center" style="display: none;">
			<div class="message-item">
				<!-- Warning -->
				<a href="#" class="msg-warning bg-msg-warning"><span
					class="validateTips"></span></a>
			</div>
		</div>


		<div class="successmessagediv" align="center" style="display: none;">
			<div class="message-item">
				<!-- Warning -->
				<a href="#" class="msg-success bg-msg-succes"><span
					class="validateTips"></span></a>
			</div>
		</div>



		<input type="hidden" name="userhidden" class="userhiddenclass"
			id="userhiddenid"
			value='<logic:present name="parentid"><bean:write name="parentid" />
													</logic:present>'></input>
													
													

		<input type="hidden" name="searchterm" class="searchtermclass"
			id="searchterms"
			value='<logic:present name="searchterm"><bean:write name="searchterm" />

													</logic:present>'></input>






		<input type="hidden" name="attnhidden" id="snoid" value="" /> <input
			type="hidden" name="attnhidden1" id="requesttoid" value="" />



		<div class="panel panel-primary">
			<div class="panel-heading">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#collapseOne" style="color: #fff;"><h3
						class="panel-title" style="color: #767676;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;Leave Request Details
					</h3></a>
				<div class="navbar-right">
					<!--  <a href="parentMenu.html?method=requestLeavescreenadd"  id="plus" > -->
					<a onClick='sendrequest()' id="plus"> <span
						class="glyphicon glyphicon-plus"></span>
					</a>

					<!--  <a href="teachermenuaction.html?method=requestLeavescreen" id="editID"> -->

					<a onClick='editequest()' id="editID"> <span
						class="glyphicon glyphicon-pencil"></span>
					</a>
					<!--  </a> -->

					<!--  <a href="teachermenuaction.html?method=leaveRequest">  -->
					<span id="delete" class="glyphicon glyphicon-trash"></span>
					<!--  </a> -->

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

					<logic:present name="leavelist" scope="request">
						<display:table class="meeting table" pagesize="10"
							name="requestScope.leavelist"
							requestURI="teachermenuaction.html?method=leaveRequest"
							id="allstudent">

							<display:column title="Select" headerClass="heading1">
								<input type="checkbox" name="getempid"
									onClick='getvaldetails(this)' value="Get Salary Details"
									id="${allstudent.sno}"> </>
							</display:column>



							<%-- 	id="${tableid.yearvalcode},${tableid.status},${tableid. }"	 --%>


							<%-- 	<display:column property="check" sortable="true"
								title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />" />  --%>

							<%--  <display:column property="check" sortable="true" title='Select'></display:column> --%>

							<display:column property="requestby" sortable="true"
								title="RequestBy <img src='images/sort1.png' style='float: right'/>"></display:column>

							<display:column property="studentname" sortable="true"
								title="Student Name<img src='images/sort1.png' style='float: right'/>"></display:column>

							<display:column property="requestto" sortable="true"
								title="RequestTo<img src='images/sort1.png' style='float: right'/>"></display:column>

							<display:column property="fromdate" sortable="true"
								title="Satrt Date<img src='images/sort1.png' style='float: right'/>"></display:column>

							<display:column property="todate" sortable="true"
								title="End Date<img src='images/sort1.png' style='float: right'/>"></display:column>

							<display:column property="starttime" sortable="true"
								title="Start Time<img src='images/sort1.png' style='float: right'/>"></display:column>

							<display:column property="endtime" sortable="true"
								title="End Time<img src='images/sort1.png' style='float: right'/>"></display:column>

							<display:column property="totalleave" sortable="true"
								title="Total Leaves<img src='images/sort1.png' style='float: right'/>"></display:column>



							<display:column property="leavetype" sortable="true"
								title="Leave Type<img src='images/sort1.png' style='float: right'/>"></display:column>

							<display:setProperty name="paging.banner.page.separator" value=""></display:setProperty>

							<display:setProperty name="paging.banner.placement"
								value="bottom"></display:setProperty>



							<%-- <display:column property="reason" sortable="true"
								title="Reason<img src='images/sort1.png' style='float: right'/>"></display:column>		 --%>


							<%-- <display:column property="description" sortable="true"
								title="Meeting Description<img src='images/sort1.png' style='float: right'/>"></display:column> --%>


						</display:table>

					</logic:present>








					<!-- <table class="table" id="allstudent">
						<tr>
							<th>Check</th>
							<th>Requested By</th>
							<th>No of Leaves</th>
							<th>Reason For Leave</th>
							<th>StartDate</th>
							<th>End Date</th>
							<th>Requested Date</th>
							<th>Leave Status</th>
							<th>Leave Type</th>
						</tr>
						<tr>
							<td><input type="checkbox" /></td>
							<td>chiru</td>
							<td>2</td>
							<td>fever</td>
							<td>11-11-2015</td>
							<td>12-11-2015</td>
							<td>10-11-2015</td>
							<td>NOT APPROVED</td>
							<td>SL</td>
						</tr>
						<tr>
							<td><input type="checkbox" /></td>
							<td>sathish</td>
							<td>2</td>
							<td>fever</td>
							<td>11-11-2015</td>
							<td>12-11-2015</td>
							<td>10-11-2015</td>
							<td>APPROVED</td>
							<td>SL</td>
						</tr>
						<tr>
							<td><input type="checkbox" /></td>
							<td>Guru</td>
							<td>2</td>
							<td>fever</td>
							<td>11-11-2015</td>
							<td>12-11-2015</td>
							<td>10-11-2015</td>
							<td>NOT APPROVED</td>
							<td>SL</td>
						</tr>
						<tr>
							<td><input type="checkbox" /></td>
							<td>priya</td>
							<td>2</td>
							<td>fever</td>
							<td>11-11-2015</td>
							<td>12-11-2015</td>
							<td>10-11-2015</td>
							<td>NOT APPROVED</td>
							<td>SL</td>
						</tr>
						<tr>
							<td><input type="checkbox" /></td>
							<td>shiva</td>
							<td>2</td>
							<td>fever</td>
							<td>11-11-2015</td>
							<td>12-11-2015</td>
							<td>10-11-2015</td>
							<td>NOT APPROVED</td>
							<td>SL</td>
						</tr>
					</table> -->

					<!-- <ul class="pagination" style="float: right; margin: 0;">
						<li><a href="#">&laquo;</a></li>
						<li class="active"><a href="#">1</a></li>
						<li class=""><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">&raquo;</a></li>
					</ul> -->
				</div>
				<br />
			</div>
		</div>
	</div>


</body>
</html>