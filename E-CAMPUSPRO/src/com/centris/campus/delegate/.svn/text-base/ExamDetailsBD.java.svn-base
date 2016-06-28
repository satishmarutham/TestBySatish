package com.centris.campus.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.campus.service.ExamDetailsService;
import com.centris.campus.serviceImpl.ExamDetailsServiceImpll;
import com.centris.campus.vo.ExaminationDetailsVo;

public class ExamDetailsBD {

	ExamDetailsService detailsercive;
	
	public List<ExaminationDetailsVo> getexamdeligate() {

		
		List<ExaminationDetailsVo> allexamlist = new ArrayList<ExaminationDetailsVo>();
		detailsercive = new ExamDetailsServiceImpll();
		allexamlist = detailsercive.getExamDetailsService();
		
		return allexamlist;
	}

}
