package com.centris.campus.delegate;

import java.util.ArrayList;

import com.centris.campus.pojo.ClassFeeSetupPojo;
import com.centris.campus.service.ClassFeeSetupService;
import com.centris.campus.serviceImpl.ClassFeeSetupServiceImpl;
import com.centris.campus.vo.ClassFeeSetupVo;


public class ClassFeeSetupBD {

	public ArrayList<ClassFeeSetupVo> getFeeSetupDetails(String currentaccyear) {
		ClassFeeSetupService service = new ClassFeeSetupServiceImpl();
		return service.getFeeSetupDetails(currentaccyear);
	}
	
	public ArrayList<ClassFeeSetupVo> getSearchFeeSetupDetails(String searchTerm,String currentaccyear) {
		ClassFeeSetupService service = new ClassFeeSetupServiceImpl();
		return service.getSearchFeeSetupDetails(searchTerm,currentaccyear);
	}
	
	public ArrayList<ClassFeeSetupVo> getApprovedFees(ClassFeeSetupPojo feeSetupPojo) {

		ClassFeeSetupService service = new ClassFeeSetupServiceImpl();

		return service.getApprovedFees(feeSetupPojo);
	}
	
	public ArrayList<ClassFeeSetupVo> getAllFees(ClassFeeSetupPojo feeSetupPojo) {

		ClassFeeSetupService service = new ClassFeeSetupServiceImpl();

		return service.getAllFees(feeSetupPojo);
	}
	
	public int insertApproveFees(ArrayList<ClassFeeSetupPojo> approvefeelist) {

		ClassFeeSetupService service = new ClassFeeSetupServiceImpl();

		return service.insertApproveFees(approvefeelist);
	}
	
	public boolean deleteFees(ClassFeeSetupPojo feeSetupPojo) {

		ClassFeeSetupService feeSetupService = new ClassFeeSetupServiceImpl();

		return feeSetupService.deleteFees(feeSetupPojo);
	}

	public boolean insertFeeAmount(ArrayList<ClassFeeSetupPojo> feeSetupList) {

		ClassFeeSetupService feeSetupService = new ClassFeeSetupServiceImpl();

		return feeSetupService.insertFeeAmount(feeSetupList);
	}
}