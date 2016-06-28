package com.centris.campus.delegate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.centris.campus.pojo.ExamTimetablePojo;
import com.centris.campus.service.ExamTimeTableService;
import com.centris.campus.serviceImpl.ExamTimeTableServiceImpl;

public class ExamTimeTableBD {

	public Map<String, List<ExamTimetablePojo>> getExamDetails(
			ExamTimetablePojo groupLogReportPojo) {
		return new ExamTimeTableServiceImpl()
				.getExamDetails(groupLogReportPojo);
	}

	public ExamTimetablePojo getExamDate(String examId) {
		ExamTimeTableService serviceobj = new ExamTimeTableServiceImpl();
		return serviceobj.getExamDate(examId);
	}

	public ArrayList<ExamTimetablePojo> getAllSubjects(String classId) {
		ExamTimeTableService serviceobj = new ExamTimeTableServiceImpl();
		return serviceobj.getAllSubjects(classId);
	}

	public ArrayList<ExamTimetablePojo> getExamTimeTableDetails(String classId,
			String exam) {

		ExamTimeTableService serviceobj = new ExamTimeTableServiceImpl();

		return serviceobj.getExamTimeTableDetails(classId, exam);
	}

	public String saveExaminationClassMapping(
			ArrayList<ExamTimetablePojo> examinationclassmappinglist) {
		ExamTimeTableService serviceobj = new ExamTimeTableServiceImpl();

		return serviceobj
				.saveExaminationClassMapping(examinationclassmappinglist);
	}

	public ArrayList<ExamTimetablePojo> getExamdetails() {
		ExamTimeTableService serviceobj = new ExamTimeTableServiceImpl();

		return serviceobj.getExamdetails();
	}

	public ArrayList<ExamTimetablePojo> getclassdetails() {
		ExamTimeTableService serviceobj = new ExamTimeTableServiceImpl();

		return serviceobj.getclassdetails();
	}
}
