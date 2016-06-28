package com.centris.campus.delegate;

import java.util.ArrayList;

import com.centris.campus.service.FeeCollectionService;
import com.centris.campus.serviceImpl.FeeCollectionServiceImpl;
import com.centris.campus.vo.FeeCollectionVo;

public class FeeCollectionBD {

	
	public ArrayList<FeeCollectionVo> getFeeCollectionDetails(String currentYear){
		
		FeeCollectionService feeCollection=new FeeCollectionServiceImpl();
		
		return feeCollection.getFeeCollectionDetails(currentYear);
	}
	
	public ArrayList<FeeCollectionVo> getSearchFeeCollectionDetails(String currentYear,String classid,String sectionId){
		
		FeeCollectionService feeCollection=new FeeCollectionServiceImpl();
		
		return feeCollection.getSearchFeeCollectionDetails(currentYear,classid,sectionId);
	}
	
	
	public FeeCollectionVo getFeeCollectionAmount(String FeeCodeDetails){
		
		FeeCollectionService feeCollection=new FeeCollectionServiceImpl();
		
		return feeCollection.getFeeCollectionAmount(FeeCodeDetails);
	}
	
	public String saveFeeCollection(FeeCollectionVo collectionVo){
		
		FeeCollectionService feeCollection=new FeeCollectionServiceImpl();
		
		return feeCollection.saveFeeCollection(collectionVo);
	}
	
	
	
	
}
