package com.centris.campus.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.actions.LeaveBankAction;
import com.centris.campus.daoImpl.AddDesignationDaoImpl;
import com.centris.campus.daoImpl.IDGenerator;
import com.centris.campus.daoImpl.LeaveBankDAOIMPL;
import com.centris.campus.forms.AddDesignation;
import com.centris.campus.forms.LeaveBankForm;
import com.centris.campus.pojo.AddDesignationPojo;
import com.centris.campus.service.LeaveBankService;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.LeaveBankVO;
import com.centris.campus.vo.LeaveRequestVo;

public class LeaveBankServiceImpl implements LeaveBankService {
	
	private static Logger logger = Logger
			.getLogger(LeaveBankServiceImpl.class);
	

	public ArrayList<LeaveBankVO> leavebanklist(LeaveBankVO vo) {

		return new LeaveBankDAOIMPL().leavebanklist(vo);
	}

	public String insertLeaveBankservice(LeaveBankForm aform) 
	
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationServiceImpl:insertDesignationDetails: Starting");

		LeaveBankDAOIMPL dao = new LeaveBankDAOIMPL();

		String check = "";

		if(aform.getSno()==null||aform.getSno()=="")
		
		{
			IDGenerator id = new IDGenerator();

			LeaveBankVO vo = new LeaveBankVO();

		

				System.out.println("Add leavebank  serviceImpl is Working");



				vo.setAcademicyear(aform.getAcademicyear());

				vo.setSl(aform.getSickleave());
				vo.setPl(aform.getPaidleave());

				vo.setCl(aform.getCasualleave());
				vo.setTotalleaves(aform.getTotalleaves());
				
				vo.setPermonth(aform.getPermonth());

				vo.setCreateuser(aform.getCreatedby());

				check = dao.insertLeaveBanksDAO(vo);

		}

	else if (!(aform.getSno() == null))

		{
			
			LeaveBankVO vo = new LeaveBankVO();


			System.out.println("Updateleavebank  serviceImpl is Working");



			vo.setAcademicyear(aform.getAcademicyear());

			vo.setSl(aform.getSickleave());

			vo.setCl(aform.getCasualleave());
			
			vo.setTotalleaves(aform.getTotalleaves());
			
			vo.setPermonth(aform.getPermonth());
			
			vo.setAcademicyear(aform.getAcademicyear());
			
			vo.setSno(aform.getSno());

			vo.setCreateuser(aform.getCreatedby());

			check = dao.updateLeaveBanksDAO(vo);

		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationServiceImpl:insertDesignationDetails: Ending");
		return check;

	}

	public LeaveBankForm editleavebank(LeaveBankForm aform)
	{
		return new LeaveBankDAOIMPL().editleavebank(aform);
	}

	@Override
	public ArrayList<LeaveBankVO> getSearchDetails(String searchTextVal) {
		return new LeaveBankDAOIMPL().getSearchDetails(searchTextVal);

	}

	@Override
	public Boolean deleteLeave(String[] deletelist)
	{
		// TODO Auto-generated method stub
		return new LeaveBankDAOIMPL().deleteLeave(deletelist);
	}

	
	
	

	
}
