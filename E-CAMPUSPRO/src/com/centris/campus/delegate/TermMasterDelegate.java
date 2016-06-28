package com.centris.campus.delegate;

import java.util.ArrayList;

import com.centris.campus.service.FeeMasterService;
import com.centris.campus.service.TermMasterService;
import com.centris.campus.serviceImpl.FeeMasterServiceImpl;
import com.centris.campus.serviceImpl.TermMasterServiceIMPL;
import com.centris.campus.vo.TermMasterVo;

public class TermMasterDelegate 

{

	TermMasterService obj_Term = new TermMasterServiceIMPL();

	public TermMasterVo getaccdetails(TermMasterVo vo) {
		
		return obj_Term.getaccdetails(vo);
	}

	public boolean getnamecount(TermMasterVo vo) 
	
	{
		
		return obj_Term.getnamecount(vo);
	}

	public String addtermfeedetails(TermMasterVo vo) {
		
		return obj_Term.addtermfeedetails(vo);
	}

	public ArrayList<TermMasterVo> termList(TermMasterVo vo) {
		
		return obj_Term.termList(vo);
	}

	public TermMasterVo edittermDetails(TermMasterVo vo) {
		
		return obj_Term.edittermDetails(vo);
	}

	public String deleteTermDetails(TermMasterVo vo) {
		
		return obj_Term.deleteTermDetails(vo);
	}

	
}
