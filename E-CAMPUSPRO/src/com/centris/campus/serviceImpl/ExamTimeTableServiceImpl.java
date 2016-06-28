package com.centris.campus.serviceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.campus.dao.ClassDao;
import com.centris.campus.dao.ExamTimeTableDao;
import com.centris.campus.daoImpl.ClassDaoImpl;
import com.centris.campus.daoImpl.ExamTimeTableDaoImpl;
import com.centris.campus.pojo.ExamTimetablePojo;
import com.centris.campus.service.ExamTimeTableService;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;

public class ExamTimeTableServiceImpl implements ExamTimeTableService {
	private static final Logger logger = Logger
			.getLogger(ExamTimeTableServiceImpl.class);

	public Map<String, List<ExamTimetablePojo>> getExamDetails(
			ExamTimetablePojo groupLogReportPojo) {

		Map<String, Map<String, List<ExamTimetablePojo>>> consolidatedMap = new LinkedHashMap<String, Map<String, List<ExamTimetablePojo>>>();

		Map<String, List<ExamTimetablePojo>> listMap = null;
		Connection conn = null;
		ExamTimeTableDao examTimeTableDao = new ExamTimeTableDaoImpl();
		try {
			listMap = new LinkedHashMap<String, List<ExamTimetablePojo>>();
			List<ExamTimetablePojo> examMainList = new ArrayList<ExamTimetablePojo>();
			List<ExamTimetablePojo> examList = examTimeTableDao
					.getExamDetails();

			for (int i = 0; i < examList.size(); i++) {

				if (examMainList.size() != 0) {
					System.out.println(examMainList
							.get(examMainList.size() - 1).getExamId()
							+ " ----- " + examList.get(i).getExamId());

					if (!(examMainList.get(examMainList.size() - 1).getExamId()
							.equalsIgnoreCase(examList.get(i).getExamId()))) {

						JSONArray array1 = new JSONArray();
						array1.put(examMainList);
						System.out.println("exam list " + array1);

						listMap.put(examMainList.get(examMainList.size() - 1)
								.getExamId(), examMainList);

						// consolidatedMap.put(examMainList.get(examMainList.size()-1).getExamId(),
						// listMap);

						examMainList = new ArrayList<ExamTimetablePojo>();
					}

				}

				examMainList.add(examList.get(i));

			}

			if (examMainList.size() != 0) {

				listMap.put(examMainList.get(examMainList.size() - 1)
						.getExamName(), examMainList);
				// consolidatedMap.put(examMainList.get(examMainList.size()-1).getExamName(),
				// listMap);
			}

			JSONArray array = new JSONArray();
			array.put(listMap);

			System.out.println("consolidatedMap size " + array);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMap;
	}

	public ArrayList<ExamTimetablePojo> getExamTimeTableDetails(String classId,
			String exam) {

		ExamTimeTableDao examTimeTableDao = new ExamTimeTableDaoImpl();

		return examTimeTableDao.getExamTimeTableDetails(classId, exam);
	}

	public ExamTimetablePojo getExamDate(String examId) {

		ExamTimeTableDao examTimeTableDao = new ExamTimeTableDaoImpl();
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTableServiceIMPL: getExaminations Starting");
		try {

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ExaminationTimeTableServiceIMPL: getExaminations Ending");
		return examTimeTableDao.getExamDate(examId);
	}

	public ArrayList<ExamTimetablePojo> getAllSubjects(String classId) {

		ExamTimeTableDao examTimeTableDao = new ExamTimeTableDaoImpl();
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTableServiceIMPL: getAllSubjects Starting");
		try {

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ExaminationTimeTableServiceIMPL: getAllSubjects Ending");
		return examTimeTableDao.getAllSubjects(classId);
	}

	public String saveExaminationClassMapping(
			ArrayList<ExamTimetablePojo> examinationclassmappinglist) {
		ExamTimeTableDao examTimeTableDao = new ExamTimeTableDaoImpl();
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTableServiceIMPL: saveExaminationClassMapping Starting");
		try {

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ExaminationTimeTableServiceIMPL: saveExaminationClassMapping Ending");
		return examTimeTableDao
				.saveExaminationClassMapping(examinationclassmappinglist);
	}

	public ArrayList<ExamTimetablePojo> getExamdetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTableServiceIMPL: getExamandclass Starting");
		ArrayList<ExamTimetablePojo> maplist = null;
		try {
			ExamTimeTableDao examTimeTableDao = new ExamTimeTableDaoImpl();
			maplist = examTimeTableDao.getExamdetails();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ExaminationTimeTableServiceIMPL: getExamandclass Ending");
		return maplist;

	}

	public ArrayList<ExamTimetablePojo> getclassdetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTableServiceIMPL: getExamandclass Starting");
		ArrayList<ExamTimetablePojo> maplist = null;
		try {
			ExamTimeTableDao examTimeTableDao = new ExamTimeTableDaoImpl();
			maplist = examTimeTableDao.getclassdetails();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ExaminationTimeTableServiceIMPL: getExamandclass Ending");
		return maplist;

	}
}
