package com.centris.campus.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.ExamDetailsDao;
import com.centris.campus.daoImpl.ExamDetailsDaoImpl;
import com.centris.campus.pojo.ExamDetailsPojo;
import com.centris.campus.pojo.StreamDetailsPojo;
import com.centris.campus.service.ExamDetailsService;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.ExaminationDetailsVo;
import com.centris.campus.vo.StreamDetailsVO;

public class ExamDetailsServiceImpll implements ExamDetailsService {
	private static final Logger logger = Logger
			.getLogger(StreamDetailsServiceImpl.class);

	ExamDetailsDao daoimpl= new ExamDetailsDaoImpl();
	
	@Override
	public List<ExaminationDetailsVo> getExamDetailsService() {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExamDetailsServiceImpl : getExamDetailsService Starting");
		
		List<ExaminationDetailsVo> examvolist = new ArrayList<ExaminationDetailsVo>();
		List<ExamDetailsPojo> examPojoList = new ArrayList<ExamDetailsPojo>();
		
		try {
			
			daoimpl = new ExamDetailsDaoImpl();
			examPojoList=daoimpl.getExamDetailsDao();
			
			for (ExamDetailsPojo examPojo : examPojoList) {
				ExaminationDetailsVo examVo = new ExaminationDetailsVo();
				
				examVo.setExamid(examPojo.getExamid());
				examVo.setExamName(examPojo.getExamName());
				examVo.setStartDate(examPojo.getStartDate());
				examVo.setEndDate(examPojo.getEndDate());
				examVo.setAccyear(examPojo.getAccyear());
				examVo.setDescription(examPojo.getDescription());
				examvolist.add(examVo);
				
			}	
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		

		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExamDetailsServiceImpl : getExamDetailsService Ending");
		
		
		
		return examvolist;
	}
	
	

}
