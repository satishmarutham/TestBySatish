	$(document).ready(function(){	
		
		
		$('.accBody').css('display', 'none');
		$('.accBody:first').css('display', 'block');
		$('.accordHead').click(function() {
			var displaypro = $(this).next('div').css('display');
			if (displaypro == 'none') {
				$(this).next('div').css({
					'display' : 'block'
				});
			} else {
				$(this).next('div').css({
					'display' : 'none'
				});
			}
			$('div .accordHead:last-child', this).hide();
		});

	
		
	// for settings color js
		$("#dropdown").click(function(){
		
			$("#hbox").slideToggle("slow");
			
		});
	
		$('.col-md-10, .vertical').click(function(){
			$("#hbox").hide();
		});
		
		// for showing search destails
	
		/*$("#allstudent").hide();
		$(".selecteditems").hide();*/
		
		if($("#hideenId").val()!="" && $("#hideenId").val()!=undefined ){
			
			$(".selecteditems").show(1000);
			$("#allstudent").show(1000);
			$("#txtstyle, #txtstyle").slideToggle();
			
		}
		
		$("#accyear").click(function(){
			
			$("#haccyear").val($("#accyear option:selected").text().trim());
		});
		
		$("#section").click(function(){
			
			$("#hsection").val($("#section option:selected").text().trim());
		});
		
		$("#term").click(function(){
			
			$("#hterm").val($("#term option:selected").text().trim());
		});
		
		
		$("#search").click(function(){
			
			var accyear=$("#accyear").val();
			var classid=$("#class").val();
			var section=$("#section").val();
			var term=$("#term").val();
			var status=$("#status").val();
			
			if(accyear=="" && classid=="" && section=="" && term==""){
				
				$("#txtstyle, #txtstyle").slideToggle();
				
				
			}
			
			if(accyear==""){
				
				$('.errormessagediv').show();
				$('.validateTips').text("Select Academic Year");
				
				return false;
				
			}else if(classid==""){
				
				$('.errormessagediv').show();
				$('.validateTips').text("Select Class");
				
				return false;
				
			}else if(section==""){
				
				$('.errormessagediv').show();
				$('.validateTips').text("Select Section");
				
				return false;
				
			}else if(term==""){
				
				$('.errormessagediv').show();
				$('.validateTips').text("Select term");
				
				return false;
				
			}else if(status.trim()==""){
				
				$('.errormessagediv').show();
				$('.validateTips').text("Select Status");
				
				return false;
				
			}
				else{
				
				return true;
			}
			
		});
		
		

		
		$("#excelDownload").click(function(){
			
			
			
		window.location.href ='reportaction.html?method=feeStatusExcelReport&AccId='
			+ $("#haccyearid").val()
			+ ' &ClassId='
			+ $("#hclassid").val()
			+ '&SectionId='
			+ $("#hsectionid").val()
			+'&TermId='
			+ $("#htermid").val()
			+'&TermName='
			+ $("#termname").text()
			+ ' &Status='
			+ $("#hstatus").val();
			
		});
		
		$("#pdfDownload").click(function(){
			
			window.location.href = 'reportaction.html?method=feeStatusPdfReport&AccId='
				+ $("#haccyearid").val()
				+ ' &ClassId='
				+ $("#hclassid").val()
				+ '&SectionId='
				+ $("#hsectionid").val()
				+'&TermId='
				+ $("#htermid").val()
				+'&TermName='
				+ $("#termname").text()
				+ ' &Status='
				+ $("#hstatus").val();
			
			
		});

		
		$("#class").change(function(){
			
			var classId=$("#class").val();
			
			$("#hclass").val($("#class option:selected").text().trim());
			
			
			$.ajax({
				type : "GET",
				url : "reportaction.html?method=getSectionByClass",
				data : {"classId":classId},
				async : false,
				success : function(data) {
					var result = $.parseJSON(data);
					
					$("#section").html("");
					$("#section").append(
							'<option value="' + "" + '">' + ""
									+ '</option>');
					
					$("#section").append(
							'<option value="' + "all" + '">' + "All"
									+ '</option>');
					
					for (var j = 0; j < result.SectionList.length; j++) {
						

						$("#section").append(
										'<option value="'
												+ result.SectionList[j].sectionId
												+ '">'
												+ result.SectionList[j].sectionname
												+ '</option>');
					}
				
					
				
				}

			});
			
		});
	
});
	