package com.centris.campus.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.delegate.ExamTimeTableBD;
import com.centris.campus.pojo.ExamTimetablePojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.campus.util.MessageConstants;

public class ExamTimeTableAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(ExamTimeTableAction.class);

	public ActionForward getAllSubjects(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTableAction: getAllSubjects Starting");
		try {
			String examclassiddetails = request.getParameter("classAndExamId");

			String[] examclassid = examclassiddetails.split(",");

			String classId = examclassid[0];
			String exam = examclassid[1];

			ExamTimetablePojo examinationList = new ExamTimetablePojo();
			examinationList = new ExamTimeTableBD().getExamDate(exam);
			ArrayList<ExamTimetablePojo> subject_list = new ExamTimeTableBD()
					.getExamTimeTableDetails(classId, exam);
			ArrayList<ExamTimetablePojo> exam_list = new ArrayList<ExamTimetablePojo>();
			ExamTimetablePojo obj = new ExamTimetablePojo();
			obj.setClassId(classId);
			obj.setExamId(exam);
			exam_list.add(obj);

			request.setAttribute("subject_list", subject_list);
			request.setAttribute("exam_list", exam_list);
			request.setAttribute("examDate", examinationList);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ExaminationTimeTableAction: getAllSubjects Ending");
		return mapping.findForward(MessageConstants.ADD_TIME_TABLE);
	}

	public ActionForward getExamDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTableAction: getExamDetails Starting");
		try {
			request.setAttribute("examList",
					new ExamTimeTableBD().getExamdetails());
			request.setAttribute("classList",
					new ExamTimeTableBD().getclassdetails());

			if ("true".equalsIgnoreCase(request.getParameter("Status"))) {
				request.setAttribute("successMessage",
						MessageConstants.SUCCESSMSG);
			} else if ("false".equalsIgnoreCase(request.getParameter("Status"))) {
				request.setAttribute("errorMessage",
						MessageConstants.UNSUCCESSMSG);
			}

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ExaminationTimeTableAction: getExamDetails Ending");
		return mapping.findForward(MessageConstants.EXAM_TIME_TABLE);
	}

	public ActionForward saveExaminationClassMapping(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTableAction : saveExaminationClassMapping  Starting");
		try {
			String classid = request.getParameter("classId");
			String examid = request.getParameter("examId");

			String subid = request.getParameter("subjectid_str");
			String date = request.getParameter("date_str");
			String starttime = request.getParameter("time_str");
			String endtime = request.getParameter("end_time_str");
			String crreatedby = HelperClass.getCurrentUserID(request);

			String[] datearray = date.split(",");
			String[] subjectarray = subid.split(",");
			String[] timearray = starttime.split(",");
			String[] endtimearray = endtime.split(",");

			ArrayList<ExamTimetablePojo> examinationclassmappinglist = new ArrayList<ExamTimetablePojo>();

			for (int i = 0; i < subjectarray.length; i++) {

				ExamTimetablePojo voObj = new ExamTimetablePojo();
				voObj.setClassId(classid);
				voObj.setExamId(examid);

				voObj.setSubId(subjectarray[i]);

				voObj.setExamDate(HelperClass.convertUIToDatabase(datearray[i]));

				voObj.setExamStartTime(timearray[i]);

				voObj.setExamEndTime(endtimearray[i]);

				voObj.setCreatedBy(crreatedby);

				examinationclassmappinglist.add(voObj);

			}

			String status = new ExamTimeTableBD()
					.saveExaminationClassMapping(examinationclassmappinglist);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTableAction : saveExaminationClassMapping Ending");
		return null;
	}

}
