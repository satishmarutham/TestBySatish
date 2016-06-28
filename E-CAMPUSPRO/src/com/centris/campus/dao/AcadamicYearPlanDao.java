package com.centris.campus.dao;

import java.util.ArrayList;

import com.centris.campus.pojo.AcadamicYearPlanPOJO;
import com.centris.campus.vo.AcadamicYearPlanVO;

public interface AcadamicYearPlanDao {

	String insertAcadamicYearPlan(AcadamicYearPlanPOJO acadamicYearPlanPOJO);

	AcadamicYearPlanVO editAcadamicYearPlan(AcadamicYearPlanPOJO acadamicYearPlanPOJO);

	ArrayList<AcadamicYearPlanVO> getSearchDetails(AcadamicYearPlanPOJO acadamicYearPlanPOJO);

	ArrayList<AcadamicYearPlanVO> getAllEventDetails(AcadamicYearPlanPOJO acadamicYearPlanPOJO);

	String deleteAcadamicYearPlan(AcadamicYearPlanPOJO acadamicYearPlanPOJO);

	String updateAcadamicYearPlan(AcadamicYearPlanPOJO acadamicYearPlanPOJO);

	String validateAcadamicYearPlan(AcadamicYearPlanPOJO acadamicYearPlanPOJO);

	String validateAcadamicYearPlanUpdate(AcadamicYearPlanPOJO acadamicYearPlanPOJO);

}
