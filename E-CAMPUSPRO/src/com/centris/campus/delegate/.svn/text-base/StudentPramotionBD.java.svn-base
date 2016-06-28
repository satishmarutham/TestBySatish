package com.centris.campus.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.campus.pojo.StudentPromotionPOJO;
import com.centris.campus.serviceImpl.StudentPramotionServiceImpl;
import com.centris.campus.vo.AcadamicYearVO2;
import com.centris.campus.vo.StudentPramotionVO;

public class StudentPramotionBD {

	public List<AcadamicYearVO2> getAcadamicYear() {
		List<AcadamicYearVO2> yeardetailslist = new ArrayList<AcadamicYearVO2>();
		yeardetailslist = new StudentPramotionServiceImpl().getAcadamicYear();
		return yeardetailslist;
	}

	public List<StudentPramotionVO> getStudentData(String acadamicYear,
			String section) {
		List<StudentPramotionVO> studentlist = new ArrayList<StudentPramotionVO>();
		studentlist = new StudentPramotionServiceImpl().getStudentData(
				acadamicYear, section);
		return studentlist;
	}

	public StudentPramotionVO insertStudentPromotion(
			StudentPromotionPOJO studentPramotionPOJO) {

		StudentPramotionVO result = new StudentPramotionServiceImpl()
				.insertStudentPromotion(studentPramotionPOJO);

		return result;
	}

	public ArrayList<StudentPramotionVO> getpromotionslist() {
		ArrayList<StudentPramotionVO> yeardetailslist = new ArrayList<StudentPramotionVO>();
		yeardetailslist = new StudentPramotionServiceImpl().getpromotionslist();
		return yeardetailslist;
	}

}
