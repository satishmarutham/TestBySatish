package com.centris.campus.delegate;

import java.util.ArrayList;

import com.centris.campus.forms.AddDesignation;
import com.centris.campus.forms.AddStageForm;
import com.centris.campus.serviceImpl.AddDesignationServiceImpl;
import com.centris.campus.serviceImpl.StageServiceIMPL;
import com.centris.campus.vo.AddDesignationVO;
import com.centris.campus.vo.AddStageVO;

public class StageDelegateBD {

	public  ArrayList<AddStageVO> StageDetails(AddStageVO vo){
		
		
			return new StageServiceIMPL().StageDetails(vo);
		
	}
	
	public String insertStage(AddStageForm aform){
		
	

			return new StageServiceIMPL().insertStage(aform);
		
	}
	
	public AddStageForm EditStageDetails(AddStageForm aform){
		
		

			return new StageServiceIMPL().EditStageDetails(aform);
	}
	
	public String deleteStage(AddStageVO vo) 
	{
		

		return new StageServiceIMPL().deleteStage(vo);
	}

public boolean getstagecount(AddStageVO vo) {
	
	return new StageServiceIMPL().getstagecount(vo);
}
	
	
	
}
