package com.centris.campus.delegate;

import java.util.ArrayList;

import com.centris.campus.service.StaffPayrollService;
import com.centris.campus.serviceImpl.StaffPayrollServiceImpl;
import com.centris.campus.vo.PayRollVo;
import com.centris.campus.vo.StaffPayrollListVo;

public class StaffPayrollBD {
	
	public ArrayList<StaffPayrollListVo> getPayrollList(String year,String month) {

		StaffPayrollService service = new StaffPayrollServiceImpl();
		
		return service.getPayrollList(year,month);

	}
	
	public ArrayList<PayRollVo> getFlatpayRollProcess(String year,String month,String userId) {

		StaffPayrollService service = new StaffPayrollServiceImpl();
		
		return service.getFlatpayRollProcess(year,month,userId);

	}
	
	public ArrayList<PayRollVo> getPayrollDetails(int year,int month) {

		StaffPayrollService service = new StaffPayrollServiceImpl();
		
		return service.getPayrollDetails(year,month);

	}
	
	public ArrayList<PayRollVo> getEmpMonthPayrollDetails(String month,String year,String empId) {

		StaffPayrollService service = new StaffPayrollServiceImpl();
		
		return service.getEmpMonthPayrollDetails(month,year,empId);

	}
	
	
	

}
