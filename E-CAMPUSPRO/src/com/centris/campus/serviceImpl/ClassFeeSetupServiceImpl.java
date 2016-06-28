package com.centris.campus.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import com.centris.campus.dao.ClassFeeSetupDao;
import com.centris.campus.daoImpl.ClassFeeSetupDaoImpl;
import com.centris.campus.pojo.ClassFeeSetupPojo;
import com.centris.campus.service.ClassFeeSetupService;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.ClassFeeSetupVo;


public class ClassFeeSetupServiceImpl implements ClassFeeSetupService {

	private static final Logger logger = Logger
			.getLogger(ClassFeeSetupServiceImpl.class);

	

	public ArrayList<ClassFeeSetupVo> getFeeSetupDetails(String currentaccyear) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : getFeeSetupDetails Starting");
		ArrayList<ClassFeeSetupVo> feelist = null;
		ClassFeeSetupDao dao = new ClassFeeSetupDaoImpl();
		try {
			feelist = dao.getFeeSetupDetails(currentaccyear);
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : getFeeSetupDetails Ending");
		return feelist;
	}



	@Override
	public ArrayList<ClassFeeSetupVo> getSearchFeeSetupDetails(String searchTerm,String currentaccyear) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : getSearchFeeSetupDetails Starting");
		
		ArrayList<ClassFeeSetupVo> feelist = null;
		ClassFeeSetupDao dao = new ClassFeeSetupDaoImpl();
		
		try {
			
			feelist = dao.getSearchFeeSetupDetails(searchTerm,currentaccyear);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : getSearchFeeSetupDetails Ending");
		return feelist;
	}

	public ArrayList<ClassFeeSetupVo> getApprovedFees(ClassFeeSetupPojo feeSetupPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : getSearchFeeSetupDetails Starting");
		
		ArrayList<ClassFeeSetupVo> feelist = null;
		ClassFeeSetupDao dao = new ClassFeeSetupDaoImpl();
		
		try {
			
			feelist = dao.getApprovedFees(feeSetupPojo);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : getSearchFeeSetupDetails Ending");
	
		return feelist;
	}



	@Override
	public ArrayList<ClassFeeSetupVo> getAllFees(ClassFeeSetupPojo feeSetupPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : getAllFees Starting");
		
		ArrayList<ClassFeeSetupVo> feelist = null;
		ClassFeeSetupDao dao = new ClassFeeSetupDaoImpl();
		
		try {
			
			feelist = dao.getAllFees(feeSetupPojo);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : getAllFees Ending");
	
		return feelist;
	}
	
	public int insertApproveFees(ArrayList<ClassFeeSetupPojo> approvefeelist) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : insertApproveFees Starting");
		
		int count=0;
		ClassFeeSetupDao dao = new ClassFeeSetupDaoImpl();
		
		try {
			
			count = dao.insertApproveFees(approvefeelist);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : insertApproveFees Ending");
	
		return count;
	}


	@Override
	public boolean deleteFees(ClassFeeSetupPojo feeSetupPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : deleteFees Starting");
		
		boolean flag=false;
		ClassFeeSetupDao dao = new ClassFeeSetupDaoImpl();
		
		try {
			
			flag = dao.deleteFees(feeSetupPojo);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : deleteFees Ending");
	
		return flag;
	}



	@Override
	public boolean insertFeeAmount(ArrayList<ClassFeeSetupPojo> feeSetupList) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : insertFeeAmount Starting");
		
		boolean flag=false;
		ClassFeeSetupDao dao = new ClassFeeSetupDaoImpl();
		
		try {
			
			flag = dao.insertFeeAmount(feeSetupList);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupServiceImpl : insertFeeAmount Ending");
	
		return flag;
	}
	
}
