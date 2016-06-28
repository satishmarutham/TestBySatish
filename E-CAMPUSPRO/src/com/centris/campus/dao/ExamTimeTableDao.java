package com.centris.campus.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.centris.campus.pojo.ExamTimetablePojo;

public interface ExamTimeTableDao {

	public List<ExamTimetablePojo> getExamDetails();

	public ArrayList<ExamTimetablePojo> getExamTimeTableDetails(String classId,
			String exam);

	public ExamTimetablePojo getExamDate(String examId);

	public ArrayList<ExamTimetablePojo> getAllSubjects(String classId);

	public String saveExaminationClassMapping(
			ArrayList<ExamTimetablePojo> examinationclassmappinglist);

	public ArrayList<ExamTimetablePojo> getExamdetails();

	public ArrayList<ExamTimetablePojo> getclassdetails();

}
