package com.centris.campus.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.campus.vo.TermMasterVo;

public class TermMasterDecorator extends TableDecorator 

{

	public String getView() {
		
		
		TermMasterVo term = (TermMasterVo) getCurrentRowObject();
		
		String result = "<input type=\"checkbox\" class=\"academic_Checkbox_Class\" id=\"academicCheckBox_"
				+ term.getTermid()
				+ ","
				+ "\" />";

	
		return result;
	}
	
	
}
