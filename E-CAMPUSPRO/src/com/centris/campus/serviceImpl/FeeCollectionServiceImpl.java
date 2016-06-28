package com.centris.campus.serviceImpl;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.centris.campus.actions.FeeCollectionAction;
import com.centris.campus.dao.FeeCollectionDao;
import com.centris.campus.daoImpl.FeeCollectionDaoImpl;
import com.centris.campus.delegate.FeeCollectionBD;
import com.centris.campus.service.FeeCollectionService;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.FeeCollectionVo;

public class FeeCollectionServiceImpl implements FeeCollectionService{
	
	private static Logger logger = Logger.getLogger(FeeCollectionServiceImpl.class);
	
	@Override
	public ArrayList<FeeCollectionVo> getFeeCollectionDetails(String currentYear) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionServiceImpl : getFeeCollectionDetails Starting");
		
		FeeCollectionDao dao=new FeeCollectionDaoImpl();
		ArrayList<FeeCollectionVo> feeCollectionList=new ArrayList<FeeCollectionVo>();
		
		try {
			
			feeCollectionList=dao.getFeeCollectionDetails(currentYear);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionServiceImpl : getFeeCollectionDetails Ending");

		return feeCollectionList;
	}

	@Override
	public FeeCollectionVo getFeeCollectionAmount(String FeeCodeDetails) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionServiceImpl : getFeeCollectionAmount Starting");
		
		FeeCollectionDao dao=new FeeCollectionDaoImpl();
		FeeCollectionVo feeCollection=new FeeCollectionVo();
		
		try {
			
			feeCollection=dao.getFeeCollectionAmount(FeeCodeDetails);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionServiceImpl : getFeeCollectionAmount Ending");

		return feeCollection;
	}

	@Override
	public String saveFeeCollection(FeeCollectionVo collectionVo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionServiceImpl : saveFeeCollection Starting");
		
		FeeCollectionDao dao=new FeeCollectionDaoImpl();
		String status=null;
		
		try {
			
			status=dao.saveFeeCollection(collectionVo);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionServiceImpl : saveFeeCollection Ending");

		return status;
	}

	@Override
	public ArrayList<FeeCollectionVo> getSearchFeeCollectionDetails(
			String currentYear, String classid, String sectionId) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionServiceImpl : getSearchFeeCollectionDetails Starting");
		
		FeeCollectionDao dao=new FeeCollectionDaoImpl();
		ArrayList<FeeCollectionVo> feeCollectionList=new ArrayList<FeeCollectionVo>();
		
		try {
			
			feeCollectionList=dao.getSearchFeeCollectionDetails(currentYear,classid,sectionId);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionServiceImpl : getSearchFeeCollectionDetails Ending");

		return feeCollectionList;
	}
	

}
