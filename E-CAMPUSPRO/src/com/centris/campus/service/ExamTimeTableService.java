package com.centris.campus.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.centris.campus.pojo.ExamTimetablePojo;

public interface ExamTimeTableService {

	public ExamTimetablePojo getExamDate(String examId);

	public ArrayList<ExamTimetablePojo> getAllSubjects(String classId);

	public ArrayList<ExamTimetablePojo> getExamTimeTableDetails(String classId,
			String exam);

	public String saveExaminationClassMapping(
			ArrayList<ExamTimetablePojo> examinationclassmappinglist);

	public ArrayList<ExamTimetablePojo> getExamdetails();

	public ArrayList<ExamTimetablePojo> getclassdetails();

}
