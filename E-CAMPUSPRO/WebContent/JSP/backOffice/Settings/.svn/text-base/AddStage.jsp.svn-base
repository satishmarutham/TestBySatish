<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript" src="JS/backOffice/Settings/StageDetails.js"></script>
<script type="text/javascript" src="JS/common.js"></script>
<script type="text/javascript">


	$('.carousel').carousel({
		interval : 5000
	//changes the speed
	})
	$(document).scroll(function() {
		var y = $(this).scrollTop();
		if (y > 100) {
			$('.topimg').fadeIn();
		} else {
			$('.topimg').fadeOut();
		}
	});
</script>
<script>
	$('.carousel').carousel({
		interval : 5000
	//changes the speed
	})
</script>
</head>


<body>

	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span id="pageHeading">New Stage</span>
		</p>
		
			<logic:present name="successmessagediv" scope="request">
			<div class="successmessagediv" align="center">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-success bg-msg-succes"><span><bean:write
								name="successmessagediv" scope="request" /></span></a>
				</div>
			</div>
		</logic:present>

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

		<div class="errormessagediv1"
			style="display: none; text-align: center;">
			<div class="message-item1">
				<!-- Warning -->
				<a href="#" class="msg-warning1 bg-msg-warning1"
					style="width: 50%; font-size: 11pt; color: red;"><span
					class="validateTips1"></span></a>
			</div>
		</div>
		
		
		
		
		
		

		
		<form  method="post" >
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-primary">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Stage Details
							</a>
							</h4>
							
							
							
							<div class="navbar-right">
							
							
							
							 <span id="savestage" class="save2">
								 <img src="images/save.png" 
									 data-toggle="tooltip" data-placement="bottom" title="Save">
									</span> 
								
							
							
									
									 <span id="view" class="glyphicon glyphicon-list2"
									 data-toggle="tooltip" data-placement="bottom" title="List" ></span>
							</div>
							
							
							
							
							
							
							
							
							
							

							<!-- <div class="navbar-right" style="float: right; margin: -10px;">
								<img src="images/rightline.png" style="margin-top: -13px;">
								
								<a href="all-studentslist.html">
								
								<spanclass="glyphicon glyphicon-pencil"
									style="font-size: 20px; line-height: 34px; color: #989898;">
									</span>
									<img src="images/rightline.png" style="margin-top: -13px;">
									</a> <a	href="">
									
									<span class="glyphicon glyphicon-trash"
									
									style="font-size: 20px; line-height: 34px; color: #989898;">
									
									</span><img src="images/rightline.png" style="margin-top: -13px;">
									
									</a> <a	href="" id="submit" ><img src="images/save.png"
									
									style="font-size: 20px; line-height: 34px; color: #989898; margin-top: -5px;">
									
									<img src="images/rightline.png" style="margin-top: -13px;"></a> <a
									href=""><img src="images/download.png"
									style="font-size: 20px; line-height: 34px; color: #989898; margin-top: -5px;"><img
									src="images/rightline.png" style="margin-top: -13px;"></a> <a
									href=""><span class="glyphicon glyphicon-list"
									style="font-size: 20px; line-height: 34px; color: #989898;"></span></a>
							</div> -->
					</div>
					<script>
					$(document).ready(function() {
						$('[data-toggle="tooltip"]').tooltip();
					});
				</script>
					
					
					
					
					
					
					
					
					<input type="hidden" id="stageid" value='<logic:present name="StageLIst"><bean:write name="StageLIst" property="stageid"/></logic:present>'></input>
					
					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							<div class="col-md-6"
								id="txtstyle">
								
								<div class="form-group">
									<label for="inputEmail"  class="control-label col-xs-4"
										style="text-align: right;  line-height: 35px;">Stage</label>
									<div class="col-xs-7">
										<input type="text" name="stagename" class="form-control" id="stagename"
											 value='<logic:present name="StageLIst"><bean:write name="StageLIst" property="stage_name"/></logic:present>'></input> 						
											
											<!-- stage_id,stage_name -->
									</div>
								</div>
								<br />

								<div class="form-group">
								
								
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Description</label>
									<div class="col-xs-7">
										<textarea   name="description" class="form-control" id="description">
											 <logic:present name="StageLIst"><bean:write name="StageLIst" property="stage_description"/></logic:present></textarea>
									</div>
								</div>
								<br />
							</div>
								</div>
								</div>
								
				</div>
				</div>				
								
		</form>
	</div>
	
</body>

</html>
