package com.centris.campus.delegate;

import java.util.ArrayList;

import com.centris.campus.forms.LeaveBankForm;
import com.centris.campus.serviceImpl.LeaveBankServiceImpl;
import com.centris.campus.vo.LeaveBankVO;




public class LeaveBankDelegate {
	
	
	public  ArrayList<LeaveBankVO> leavebanklist(LeaveBankVO vo){
		
		System.out.println("DesignationDetailsTable delegate is Working");

			return new LeaveBankServiceImpl().leavebanklist(vo);
		
	}
     public String insertLeaveBankDelegate(LeaveBankForm aform){
		
		System.out.println("Leavebank delegate is Working");

			return new LeaveBankServiceImpl().insertLeaveBankservice(aform);
	}

	public LeaveBankForm editleavebankdelegate(LeaveBankForm aform){

			return new LeaveBankServiceImpl().editleavebank(aform);
	}
		
	public ArrayList<LeaveBankVO> getSearchDetails(String searchTextVal)

	{
		return new LeaveBankServiceImpl().getSearchDetails(searchTextVal);
		}
	
	public Boolean deleteLeave(String[] deletelist)
	{
		return new LeaveBankServiceImpl().deleteLeave(deletelist);
	}
	
	
}
