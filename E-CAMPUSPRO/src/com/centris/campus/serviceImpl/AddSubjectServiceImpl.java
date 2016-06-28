package com.centris.campus.serviceImpl;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;



import com.centris.campus.dao.AddtSubjectDao;
import com.centris.campus.daoImpl.AddSubjectDaoImpl;
import com.centris.campus.forms.AddSubjectForm;
import com.centris.campus.service.AddSubjectService;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.VehicleDetailsVO;
import com.centris.campus.vo.ViewallSubjectsVo;

public class AddSubjectServiceImpl implements AddSubjectService {
	private static final Logger logger = Logger
			.getLogger(AddSubjectServiceImpl.class);
	AddtSubjectDao daoObj=new AddSubjectDaoImpl();
	
	public synchronized List<ViewallSubjectsVo> subjectdetails()
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectServiceImpl : subjectdetails Starting");
		ArrayList<ViewallSubjectsVo> subjectdetails = null;
		try {
			subjectdetails = daoObj.subjectdetails();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectServiceImpl : subjectdetails  Ending");
    return subjectdetails;
}

	public synchronized boolean DeleteSubject(ViewallSubjectsVo voObj){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectServiceImpl : DeleteSubject Starting");
		boolean status=false;
		try {
			status = daoObj.DeleteSubject(voObj);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectServiceImpl : DeleteSubject  Ending");
    
		return status;
	}
	
	public synchronized List<ViewallSubjectsVo> searchsubjectdetails(ViewallSubjectsVo voObj)
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectServiceImpl : searchsubjectdetails Starting");
		List<ViewallSubjectsVo> subjectdetails = null;
		try {
			subjectdetails = daoObj.searchsubjectdetails(voObj);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectServiceImpl : searchsubjectdetails  Ending");
    return subjectdetails;
	}
	
	public synchronized boolean addSubject(AddSubjectForm obj)
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectServiceImpl : addSubject Starting");
		boolean status=false;
		try {
			status = daoObj.addSubject(obj);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectServiceImpl : addSubject  Ending");
    
		return status;
	}
	
	public synchronized ViewallSubjectsVo getSubjectDetails(ViewallSubjectsVo obj)
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectServiceImpl : getSubjectDetails Starting");
	
		try {
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectServiceImpl : getSubjectDetails  Ending");
		return daoObj.getSubjectDetails(obj);
	}
	
	
	
	public synchronized boolean updateSubjectDetails(AddSubjectForm obj)
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectServiceImpl : updateSubjectDetails Starting");
		boolean status=false;
		try {
			status = daoObj.updateSubjectDetails(obj);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectServiceImpl : updateSubjectDetails  Ending");
    
		return status;
	}
	
	public synchronized String getpath(String classname) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ViewallSubjectsServiceImpl: getpath  Starting");
		String path=null;
		try{
		 path = new AddSubjectDaoImpl().getpath(classname);
		}
		catch(Exception exception){
			exception.printStackTrace();
			logger.error(exception);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ViewallSubjectsServiceImpl: getpath Ending");
		return path;
	}

	
	public String DdownloadsyllabuspathService(String subjectid) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ViewallSubjectsServiceImpl: DdownloadsyllabuspathService  Starting");
		
		
		String path = null;
		
		try {
			
			 path = new AddSubjectDaoImpl().DdownloadsyllabuspathDao(subjectid);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ViewallSubjectsServiceImpl: DdownloadsyllabuspathService Ending");
		return path;
	}
	
}
