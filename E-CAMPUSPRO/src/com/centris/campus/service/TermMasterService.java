package com.centris.campus.service;

import java.util.ArrayList;

import com.centris.campus.vo.TermMasterVo;

public interface TermMasterService {

	

	TermMasterVo getaccdetails(TermMasterVo vo);

	boolean getnamecount(TermMasterVo vo);

	String addtermfeedetails(TermMasterVo vo);

	ArrayList<TermMasterVo> termList(TermMasterVo vo);

	TermMasterVo edittermDetails(TermMasterVo vo);

	String deleteTermDetails(TermMasterVo vo);

}
