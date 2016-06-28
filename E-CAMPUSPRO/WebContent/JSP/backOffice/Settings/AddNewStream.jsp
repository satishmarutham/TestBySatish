<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<title>Campus School Stream</title>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<script type="text/javascript" src="JS/newUI/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="JS/newUI/bootstrap.min.js"></script>
<script type="text/javascript" src="JS/common.js"></script>

<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet">
<link href="CSS/newUI/modern-business.css" rel="stylesheet">
<link href="CSS/newUI/custome.css" rel="stylesheet">
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">


<script type="text/javascript"
	src="JS/backOffice/Settings/streamDetails.js"></script>





<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>

<body>

	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span id="pageHeading">Add
				Stream</span>
		</p>
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

		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<div class="panel panel-primary">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" style="color: #767676"> <i
							class="glyphicon glyphicon-menu-hamburger"></i>
							&nbsp;&nbsp;Stream Details
						</a>
					</h4>

					<div class="navbar-right">
						<span id="savestreamid" class="save2"> <img
							src="images/save.png" data-toggle="tooltip"
							data-placement="bottom" title="Save">
						</span>

						<!--  <span id="savestreamid" class="save2">
							 
							 <img src="images/save.png" data-toggle="modal" data-toggle="tooltip" data-placement="bottom" title="Save">
									
							</span>  -->

						<a href="adminMenu.html?method=streamList"><span
							class="glyphicon glyphicon-list2" data-toggle="tooltip"
							data-placement="bottom" title="List"></span></a>
					</div>
				</div>
				<script>
					$(document).ready(function() {
						$('[data-toggle="tooltip"]').tooltip();
					});
				</script>
			 <input type="hidden" name="streamId" class="streamidclass"
					id="streamId"
					value='<logic:present name="list"><bean:write name="list" property="streamId" />
													</logic:present>'></input>
				<div id="collapseOne" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingOne">
					<div class="panel-body">
						<div class="col-md-6"
							style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
							<div class="form-group">

								<input type="hidden" name="streamId" class="form-control"
									id="streamId"
									value='<logic:present name="list"><bean:write name="list" property="streamId" />
													</logic:present>'></input>


								<label for="inputEmail" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Stream
									Name </label>
								<div class="col-xs-7">
									<input type="text" name="streamName" id="streamName" onkeypress="HideError()"
										class="form-control" placeholder="" maxlength="30"
										value='<logic:present name="list"><bean:write name="list" property="streamName" /></logic:present>'></input>
								</div>
							</div>
							<br />

							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Description
								</label>
								<div class="col-xs-7">
									<textarea style="font-size: 12px; resize: none" rows="6"
										class="form-control" name="description" id="description"
										>
										<logic:present name="list">
											<bean:write name="list" property="description" />
										</logic:present>
									</textarea>
								</div>
							</div>
							<br />

						</div>
					</div>
				</div>


			</div>

		</div>

	</div>






</body>
</html:html>