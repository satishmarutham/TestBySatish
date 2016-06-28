package com.centris.campus.dao;

import java.util.ArrayList;

import com.centris.campus.vo.FeeCollectionVo;

public interface FeeCollectionDao {
	
	public ArrayList<FeeCollectionVo> getFeeCollectionDetails(String currentYear);
	public FeeCollectionVo getFeeCollectionAmount(String FeeCodeDetails);
	public String saveFeeCollection(FeeCollectionVo collectionVo);
	public ArrayList<FeeCollectionVo> getSearchFeeCollectionDetails(
			String currentYear, String classid, String sectionId);

}
