<!DOCTYPE html>
<html lang="en">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>
<head>

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


<script type="text/javascript" src="JS/common.js"></script>

<script type="text/javascript" src="JS/backOffice/Settings/SubjectAmendment.js"></script> 
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
			<img src="images/addstu.png" />&nbsp;<span>New Subject</span>
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
					
						<logic:present name="errorMessage" scope="request">

							<div class="successmessagediv" align="center">
								<div class="message-item">
									<!-- Warning -->
									<a href="#" class="msg-warning bg-msg-warning"><span style="color:red ;">
											<bean:write name="errorMessage" scope="request" />
									</span></a>
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
				
		      
						<br/>
						
						

		<form id="SubjectForm" action="subject.html?method=updateSubject" method="post" enctype="multipart/form-data" >
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-primary">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;New Subject
							</a>

							<div class="navbar-right" style="float: right; margin: -10px;">
								
								 <span
									 id="save"><img src="images/save.png"
									 data-toggle="tooltip" data-placement="bottom" title="Save"></span><img
									src="images/rightline.png" style="margin-top: -13px;"> <a
									href="adminMenu.html?method=subjectdetails"><span class="glyphicon glyphicon-list"
									 data-toggle="tooltip" data-placement="bottom" title="List"></span></a>
							</div>
						</h4>
					</div>
					
					
						
					<script>
				$(document).ready(function() {
					$('[data-toggle="tooltip"]').tooltip();
				});
			</script>	
						
					
					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							<div class="col-md-6" id="txtstyle"
								style="font-size: 11pt;">
								
                               <div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Class</label>
									<div class="col-xs-7">
										<select name="classname"
								id="classnameid" class="form-control" >
									<option value=""></option>
									
							    </select>
									</div>
								</div>
								<br/>
									<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Description</label>
									<div class="col-xs-7">
											<textarea rows="3px" cols="3px" name="description" id="description" class="form-control"    placeholder="" >
											
												<logic:present name="singlesubjectdetails">
											<bean:write name="singlesubjectdetails" property="description" />
										</logic:present>
											
											
											</textarea>
											
											
											
											
									
											
											
											
											
											
											
											
									</div>
								</div>
								
								
							</div>
							<div class="col-md-6" id="txtstyle"
								>
								
							
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Subject Name</label>
									<div class="col-xs-7">
											<input type="text" name="subjtname" id="subjtname" class="form-control"   placeholder="Subject Name" value='<logic:present name="singlesubjectdetails"><bean:write name="singlesubjectdetails" property="subjectname" />
													</logic:present>'/>
									
									
									<%-- 
										<input type="hidden" name="streamId" class="form-control"
									id="streamId"
									value='<logic:present name="list"><bean:write name="list" property="streamId" />
													</logic:present>'></input>
									 --%>
									
									</div>
								</div>
								<br/>
									<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Syllabus</label>
									<div class="col-xs-7">
										<input type="file" class="form-control" id="file" name="file"
											placeholder="Syllabus">
											
									<input type="button" id="document1btn" name="profile" class="downloadDoc" value="Download" />
										<span style="font-size:20px;color:red;cursor:pointer;" id="deleteProfile">  x</span>		
											
											
									</div>
								</div>
							
								
								
								
								
								
							</div>
							
						
						</div>
					</div>
					
				
				</div>
				
					
			      </div>
			      
               <input type="hidden" name="hiddenclass" id="hiddenclassid" value="<logic:present name="singlesubjectdetails" ><bean:write name="singlesubjectdetails" property="classname"/></logic:present>"/>
               <input type="hidden" name="hiddensubject" id="hiddensubject" value="<logic:present name="singlesubjectdetails" ><bean:write name="singlesubjectdetails" property="subjectname"/></logic:present>"/>
               <input type="hidden" name= "hiddendescription" id="hiddendescription" value="<logic:present name="singlesubjectdetails" ><bean:write name="singlesubjectdetails" property="description"/></logic:present>"/>
               <input type="hidden" name="hiddenfile" id="hiddenfile" value="<logic:present name="singlesubjectdetails" ><bean:write name="singlesubjectdetails" property="path"/></logic:present>"/>
               <input type="hidden" name="hiddensubjectId" id="hiddensubjectid" value="<logic:present name="singlesubjectdetails" ><bean:write name="singlesubjectdetails" property="subjectid"/></logic:present>"/>
               <input type="hidden" name="status" id="statusid" value="<logic:present name="singlesubjectdetails" ><bean:write name="singlesubjectdetails" property="status"/></logic:present>"/>
				



  <input type="hidden" name="status" id="hsuccessid" value="<logic:present name="success" ><bean:write name="success"/></logic:present>"/>
				




		</form>
	</div>
	
</body>

</html>
