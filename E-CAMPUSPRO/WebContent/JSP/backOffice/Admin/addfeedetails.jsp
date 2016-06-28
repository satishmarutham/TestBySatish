<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Campus School Stream</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect-blind.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<script type="text/javascript" src="JS/Admin/Latheef.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript"
	src="JS/backOffice/Admin/addfeedetails.js"></script>

<style>
#save:hover {
	cursor: pointer;
}
</style>

<style>
#view:hover {
	cursor: pointer;
}
</style>
</head>

<body>
	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span id="pageHeading">Add
				Fee Details</span>
		</p>

		<div class="successmessagediv" align="center" style="display: none;">
			<div class="message-item">
				<!-- Warning -->
				<a href="#" class="msg-success bg-msg-succes"><span
					class="validateTips"></span></a>
			</div>
		</div>
		<logic:present name="errormessagediv" scope="request">
			<div class="errormessagediv" align="center" style="display: none;">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-warning bg-msg-warning"><span
						class="validateTips"><bean:write name="errormessagediv"
								scope="request" /></span></a>
				</div>
			</div>
		</logic:present>

		<div class="errormessagediv1" align="center"
			style="display: none; text-align: center;">
			<div class="message-item1">
				<!-- Warning -->
				<a href="#" class="msg-warning1 bg-msg-warning1"
					style="width: 35%; font-size: 13px; color: red;"><span
					class="validateTips1"></span></a>
			</div>
		</div>




		<form action="addfee.html?method=AddFeeDetailsMaster" method="post">
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-primary">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i> &nbsp;&nbsp; Add
								Fee Details
							</a>
						</h4>

						<div class="navbar-right">

							<span id="save" class="save2"><img src="images/save.png"
								data-toggle="modal" data-target="#myModal" data-toggle="tooltip"
								data-placement="bottom" title="Save"></span> <span id="view"
								class="glyphicon glyphicon-list2" data-toggle="modal"
								data-target="#myModal" data-toggle="tooltip"
								data-placement="bottom" title="List"></span>

						</div>

						<script>
							$(document).ready(function() {
								$('[data-toggle="tooltip"]').tooltip();
							});
						</script>


					</div>
					<input type="hidden" id="feemasterid"
						value='<logic:present name="editlist"><bean:write name="editlist" property="id" />
													</logic:present>'></input>



					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Fee Name</label>
									<div class="col-xs-7">
										<input type="text" class="form-control" name="feename"
											id="feename"
											value='<logic:present name="editlist"><bean:write name="editlist" property="name"/></logic:present>'></input>
									</div>
								</div>




							</div>



							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<input type="hidden" id="concession"
									value='<logic:present name="editlist"><bean:write name="editlist" property="concession" /></logic:present>'></input>


								<div class="form-group">
									<label for="inputtype" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Concession
										Type </label>
									<div class="col-xs-7" id="radioDiv" style="margin-top: 8px">
										<input type="radio" name="concession" value="Y" id="yes"
											class="concession" />&nbsp;&nbsp;&nbsp;Yes <input
											type="radio" name="concession" class="concession" value="N"
											id="no" />&nbsp;&nbsp;&nbsp;No
									</div>
								</div>
								<%-- 							'<logic:present name="editlist"><bean:write name="editlist" property="concessiontype"/></logic:present>'
 --%>
							</div>
							<%-- <div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Fee
										Description</label>
									<div class="col-xs-7">
										<input type="text" class="form-control" name="feedescription"
											id="feedescription"
											value='<logic:present name="editlist"><bean:write name="editlist" property="description" /></logic:present>'></input>
									</ div>--%>

							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<label for="inputDescription" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px; margin-right: 1px;">Description
								</label>
								<div class="col-xs-7">
									<textarea style="resize: none" rows="4" class="form-control"
										maxlength="250" name="feedescription" id="feedescription">
										<logic:present name="editlist">
											<bean:write name="editlist" property="description"></bean:write>
										</logic:present>
									</textarea>
								</div>
							</div>


						</div>
					</div>


				</div>
			</div>
	</div>

	<!-- <button type="submit" class="btn btn-info col-md-offset-5">Savechanges</button>
				<button type="reset" class="btn btn-info">Clear</button> -->
	</form>
	</div>
	</div>
</body>

</html>
