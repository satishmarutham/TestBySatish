package com.centris.campus.dao;

import java.util.ArrayList;

import com.centris.campus.pojo.ClassFeeSetupPojo;
import com.centris.campus.vo.ClassFeeSetupVo;


public interface ClassFeeSetupDao {
	
	public ArrayList<ClassFeeSetupVo> getFeeSetupDetails(String currentaccyear);
	public ArrayList<ClassFeeSetupVo> getSearchFeeSetupDetails(String searchTerm,String currentaccyear);
	public ArrayList<ClassFeeSetupVo> getApprovedFees(ClassFeeSetupPojo feeSetupPojo);
	public ArrayList<ClassFeeSetupVo> getAllFees(ClassFeeSetupPojo feeSetupPojo);
	public int insertApproveFees(ArrayList<ClassFeeSetupPojo> approvefeelist);
	public boolean deleteFees(ClassFeeSetupPojo feeSetupPojo);
	public boolean insertFeeAmount(ArrayList<ClassFeeSetupPojo> feeSetupPojo);

	
}
