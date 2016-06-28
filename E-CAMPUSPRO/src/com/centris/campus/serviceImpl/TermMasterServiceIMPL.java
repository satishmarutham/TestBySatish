package com.centris.campus.serviceImpl;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.actions.AdminMenuAction;
import com.centris.campus.dao.FeeMasterDAO;
import com.centris.campus.dao.TermMasterDAO;
import com.centris.campus.daoImpl.FeeMasterDAOIMPL;
import com.centris.campus.daoImpl.TermMasterDAOIMPL;
import com.centris.campus.service.TermMasterService;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.TermMasterVo;

public class TermMasterServiceIMPL implements TermMasterService 

{
	private static final Logger logger = Logger
			.getLogger(AdminMenuAction.class);
	TermMasterDAO obj_Term = new TermMasterDAOIMPL();

	
	public TermMasterVo getaccdetails(TermMasterVo vo) 
	
	{
		
		return obj_Term.getaccdetails(vo);
	}


	
	public boolean getnamecount(TermMasterVo vo) {
		
		return obj_Term.getnamecount(vo);
	}




	public String addtermfeedetails(TermMasterVo vo) {
		

		
		
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TermMasterServiceIMPL :addtermfeedetails  Starting");
		// TODO Auto-generated method stub
		
		String check="";
		TermMasterDAO TermMasterDAO = new TermMasterDAOIMPL();
		
		if (vo.getTermid().equalsIgnoreCase(""))
			
		{
		
		try
		
		{
			
			check = TermMasterDAO.addtermfeedetails(vo);
			
		}
		
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		}
		
		else if (!vo.getTermid().equalsIgnoreCase(""))
			
		{
			
			
			try
			
			{
				
				check = TermMasterDAO.updatetermDetails(vo);
				
			}
			
			catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
			
			
		}
		

		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TermMasterServiceIMPL :addtermfeedetails Ending");
		return check;
		
	
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
