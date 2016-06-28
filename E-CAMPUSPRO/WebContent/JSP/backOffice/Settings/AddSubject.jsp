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
<script type="text/javascript" src="JS/newUI/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="JS/newUI/bootstrap.min.js"></script>


<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet">
<link href="CSS/newUI/modern-business.css" rel="stylesheet">
<link href="CSS/newUI/custome.css" rel="stylesheet">
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
	<script type="text/javascript" src="JS/common.js"></script>
<script type="text/javascript" src="JS/backOffice/Settings/AddSubject.js"></script> 
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
			<img src="images/addstu.png" />&nbsp;<span id="pageHeading">New Subject</span>
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
						
						

		<form id="SubjectForm" action="subject.html?method=addSubject" method="post" enctype="multipart/form-data" >
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
							</h4>

							<div class="navbar-right">
								
								
								
								
								 <span id="save" class="save2">
								 <img src="images/save.png" 
									 data-toggle="tooltip" data-placement="bottom" title="Save">
									</span> 
								
							
								
								
								<!--  <span
									 id="save"><img src="images/save.png"
									style="font-size: 20px; line-height: 34px; color: #989898; margin-top: -5px; cursor:pointer"  data-toggle="tooltip" data-placement="bottom" title="Save" ></span>
									
									 -->
									
									 <a
									href="adminMenu.html?method=subjectdetails"><span class="glyphicon glyphicon-list2"
									 data-toggle="tooltip" data-placement="bottom" title="List" ></span></a>
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
								id="classname" class="form-control" >
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
											<input type="text" name="subjtname" id="subjtname" class="form-control"   placeholder="" value=""/>
									</div>
								</div>
								<br/>
									<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Syllabus</label>
									<div class="col-xs-7">
										<input type="file" class="form-control" id="file" name="file"
											placeholder="">
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
				
		</form>
	</div>
	
</body>

</html>
