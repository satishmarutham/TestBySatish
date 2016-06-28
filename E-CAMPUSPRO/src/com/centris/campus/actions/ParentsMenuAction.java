package com.centris.campus.actions;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.json.JSONObject;










import com.centris.campus.delegate.ParentExamdetailsBD;
import com.centris.campus.delegate.ParentLeaveRequestBD;
import com.centris.campus.delegate.TeacherLeaveModuleBD;
import com.centris.campus.forms.LeaveRequestForm;
import com.centris.campus.pojo.ClassPojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.AssignmentViewVO;
import com.centris.campus.vo.ExaminationDetailsVo;
import com.centris.campus.vo.LeaveRequestVo;
import com.centris.campus.vo.LstmsUpcomingMeetingVO;
import com.centris.campus.vo.ParentFeedbackVo;
import com.centris.campus.vo.ParentVO;
import com.centris.campus.vo.RemainderMasterVO;
import com.centris.campus.vo.StreamDetailsVO;
import com.centris.campus.vo.StudentAttendanceVo;
import com.centris.campus.vo.StudentRegistrationVo;
import com.centris.campus.vo.TimeTableVo;
import com.centris.campus.vo.UserDetailVO;
import com.centris.campus.vo.ViewallSubjectsVo;

public class ParentsMenuAction extends DispatchAction {
	
	private static final Logger logger = Logger.getLogger(ParentsMenuAction.class);

	public ActionForward Home(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ParentsMenuAction : Home Starting");
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);

		

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ParentsMenuAction : Home Ending");

		return mapping.findForward(MessageConstants.PERENTS_HOME);
	}
	
	
	
	public ActionForward studentinformation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentinformation Starting");
		
		request.setAttribute(MessageConstants.MODULE_NAME,
				MessageConstants.BACKOFFICE_STUDENT);
		request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
				MessageConstants.MODULE_STUDENT);
		
		
		
		try {
			StudentRegistrationVo studentinfo = new StudentRegistrationVo();
			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);
			
			vo.setParentID(userid);
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);
			
			
			String studentid = student.get(0).getStdAdmisiionNo();
			vo.setStudentid(studentid);
			
			
			
			
		
			
			
			studentinfo = new ParentExamdetailsBD().getStudentInfoBD(vo);
			
			
		
			
			request.setAttribute("studentdetails", studentinfo);
			request.setAttribute("studentlist", student);
			//request.setAttribute("assstudentid", studentid);
			request.setAttribute("parenthiddenid", vo);
			request.setAttribute("studentexam", studentid);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
	
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentinformation Ending");
		
		return mapping.findForward(MessageConstants.STUDENT_INFORMATION_LIST);
	}
	
	
	
	
	
	public ActionForward getnextchildInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentinformation Starting");
		
		request.setAttribute(MessageConstants.MODULE_NAME,
				MessageConstants.BACKOFFICE_STUDENT);
		request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
				MessageConstants.MODULE_STUDENT);
		
		
		
		try {
			
			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);
			
			
			vo.setParentID(userid);
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);
			
			
			
			String studentid=request.getParameter("studentid");
			String hiddenid=request.getParameter("hiddenid");
			
		
			
			
			StudentRegistrationVo studentinfo = new StudentRegistrationVo();
			
			
			studentinfo.setStudentId(studentid);
			studentinfo.setHiddenid(hiddenid);
			
			//studentinfo = new ParentExamdetailsBD().getStudentInfoBD1(vo);
			
			
			studentinfo = new ParentExamdetailsBD()
			.getnextStudentInfoBD(studentinfo);
			
			
			
			
			request.setAttribute("studentdetails", studentinfo);
			
			
			
			
			
			request.setAttribute("studentexam", studentid);
			
			request.setAttribute("studentlist", student);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
	
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentinformation Ending");
		
		return mapping.findForward(MessageConstants.STUDENT_INFORMATION_LIST);
		
		
		
	}
	
	public ActionForward attendancedetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : attendancedetails Starting");
		
		
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
			

			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);
			
			vo.setParentID(userid);
			
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);
			
			
			String studentid = student.get(0).getStdAdmisiionNo();
			vo.setStudentid(studentid);
			
		
			
			request.setAttribute("studentlist", student);
			request.setAttribute("attnstudentid", studentid);
			request.setAttribute("parenthiddenid", vo);
			
			
			
			
			String month = null;
			String year = null;
			ArrayList<StudentAttendanceVo> list = new ParentExamdetailsBD().getAttendanceMonthList(year, month,vo);
			
			
			for(int i=1; i<list.size(); i++)
				
			{
				
				System.out.println("Month Details"+list.get(i).getMonth());
				
			}
			
			request.setAttribute("attendancelist", list);
			
			
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : attendancedetails Ending");
		return mapping.findForward(MessageConstants.attendancedetails);
		
		
	}
	
	public ActionForward getNextChildAttendance(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getNextChildAttendance Starting");
		
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
			
			StudentAttendanceVo studvo = new StudentAttendanceVo();
			
			String studentid = request.getParameter("studentid");
			String parentid = request.getParameter("parentid");
			
			studvo.setStudentid(studentid);
			studvo.setParentid(parentid);
			
			
			
			
			String month = null;
			String year = null;
			
			ParentVO vo = new ParentVO();
			vo.setParentID(parentid);
			
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);
			ArrayList<StudentAttendanceVo> attnlist = new ParentExamdetailsBD().getNextChildAttendanceMonthList(year, month,studvo);
			
			
			request.setAttribute("hiddenstudentid", studentid);
			request.setAttribute("attendancelist", attnlist);
			request.setAttribute("studentlist", student);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getNextChildAttendance Ending");
		
		return mapping.findForward(MessageConstants.attendancedetails);
	}
	
	public ActionForward getAttendanceView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getAttendanceView Starting");
		
		
		
		try {
			
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
			
			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);
			
			vo.setParentID(userid);
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);
			
			
		/*	String studentid = student.get(0).getStdAdmisiionNo();
			vo.setStudentid(studentid);*/
			
			
			String studentid = request.getParameter("studentid");
			String monthid = request.getParameter("monthid");
			String currentyearid = request.getParameter("currentyearid");
			String studentid1 = request.getParameter("studentid1");
			
			StudentAttendanceVo attvo = new StudentAttendanceVo();
		
			attvo.setStudentid(studentid);
			attvo.setMonth(monthid);
			attvo.setYear(currentyearid);
			attvo.setStudentid1(studentid1);
			
		
			
			
			
			if(studentid != null){
				
				
				
				ArrayList<StudentAttendanceVo> attendancelist = new ParentExamdetailsBD().getAttendanceDayList(attvo);
				
				request.setAttribute("attendancelist", attendancelist);
			}
			
			
		 if(studentid1 != null){
				
				
				
				
				ArrayList<StudentAttendanceVo> attendancelist1 = new ParentExamdetailsBD().getmoreAttendanceDayList(attvo);
				
				request.setAttribute("attendancelist1", attendancelist1);
				
				
			}
			
			
			
		
			
			
			
			
		
			
			request.setAttribute("studentlist", student);
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getAttendanceView Ending");
		
		
		return mapping.findForward(MessageConstants.attendanceview);
		
		
	
		
		
		
	}
	public ActionForward assignmentdetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : assignmentdetails Starting");
		
		
		try {
			
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
			
			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);
			
			vo.setParentID(userid);
			
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);
			
		
			
			
			String studentid = student.get(0).getStdAdmisiionNo();
			vo.setStudentid(studentid);
			
			
		
			
			ArrayList<AssignmentViewVO> assignmentlist = new ParentExamdetailsBD()
			.getAssignmentListBD(vo);
			
			
						
			
			request.setAttribute("studentlist", student);
			
			request.setAttribute("assignmentlist", assignmentlist);
			request.setAttribute("parenthiddenid", vo);
			
			request.setAttribute("assstudentid", studentid);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : assignmentdetails Ending");
		return mapping.findForward(MessageConstants.assignmentdetails);
	}
	
	
	public ActionForward viewAssignmentDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : viewAssignmentDetails Starting");
		
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
			
			String studentid = request.getParameter("studentid");
			String assgnmentid = request.getParameter("assgnmentid");
			
		
			
			AssignmentViewVO assvo = new AssignmentViewVO();
			assvo.setStudentid(studentid);
			assvo.setAssignmentid(assgnmentid);

			AssignmentViewVO result = new ParentExamdetailsBD().getviewAssignmentBD(assvo);
			
			
			
			request.setAttribute("assdetails", result);
			request.setAttribute("studentid", studentid);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : viewAssignmentDetails+" +
				"- Ending");
		
		
		return mapping.findForward(MessageConstants.viewassignment);
		
	}
	
	public ActionForward getmoreassimentlist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getmoreassimentlist Starting");
		
		
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
			
			AssignmentViewVO assvo = new AssignmentViewVO();
			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);
			
			vo.setParentID(userid);
			
			String studentid=request.getParameter("studentid");
			String hiddenid=request.getParameter("hiddenid");
			
		//	String assgnmentid = request.getParameter("assgnmentid");
		
			assvo.setStudentid(studentid);
			assvo.setHiddenid(hiddenid);
			//assvo.setAssignmentid(assgnmentid);
			
			
		
			
			
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);
			
			
		
			
			ArrayList<AssignmentViewVO> assignmentlist = new ParentExamdetailsBD()
			.getmoreAssidnmentListBD(assvo);
			
			
		
			
			request.setAttribute("studentexam", studentid);
			request.setAttribute("assignmentlist", assignmentlist);
			request.setAttribute("studentlist", student);
			request.setAttribute("assstudentid", studentid);

			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getmoreassimentlist Ending");
		
		
		return mapping.findForward(MessageConstants.assignmentdetails);
		
	}
	
	

	
	public ActionForward syllabusdetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : syllabusdetails Starting");
		
		
		
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
			
			List<StreamDetailsVO> streamvo =new ParentExamdetailsBD().getStreamListDetails();
			
			request.setAttribute("streamlist", streamvo);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : syllabusdetails Ending");
		
		
		return mapping.findForward(MessageConstants.syllabusdetails);
		
		
		
	}

	
	public ActionForward sendfeedback(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : sendfeedback Starting");
		
		
		
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
			
			ParentFeedbackVo fbvo = new ParentFeedbackVo();
			
			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);
			
			vo.setParentID(userid);
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);	
			request.setAttribute("studentlist", student);
			
			
			ArrayList<ParentFeedbackVo> fdlist = new ParentExamdetailsBD()
			.getFeedBackDetailsBD(fbvo);
			
			
			
			
			
			request.setAttribute("parentid", vo);
			request.setAttribute("feedbacklist", fdlist);
			
			
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		
		
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : sendfeedback Ending");
		
		
		return mapping.findForward(MessageConstants.sendfeedback);
		
	}
	

	/*

	
	
	public ActionForward getsyllabus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : sendfeedback Starting");
		
		
		request.setAttribute(MessageConstants.MODULE_NAME,
				MessageConstants.BACKOFFICE_STUDENT);
		request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
				MessageConstants.MODULE_STUDENT);
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : sendfeedback Ending");
		
		
		
		return mapping.findForward(MessageConstants.getsyllabus);
		
	}
	*/


	public ActionForward examdetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : examdetails Starting");
		
		
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_EXAM);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_EXAM);
			
			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);
			
			vo.setParentID(userid);
			
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);
			
			
		
			
			String studentid = student.get(0).getStdAdmisiionNo();
			vo.setStudentid(studentid);
			
			
			ArrayList<ExaminationDetailsVo> examlist = new ParentExamdetailsBD()
			.getExamListDetails(vo);
			
			
			
			request.setAttribute("examlist", examlist);
			
			request.setAttribute("studentlist", student);
			
			request.setAttribute("parenthiddenid", vo);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : examdetails Ending");
		
		return mapping.findForward(MessageConstants.examdetails);
				
		
		
	}
	
	public ActionForward getexamlist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getexamlist Starting");
		
		
		
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
			
			ExaminationDetailsVo exmvo = new ExaminationDetailsVo();
			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);
			
			vo.setParentID(userid);
			
			String studentid=request.getParameter("studentid");
			String hiddenid=request.getParameter("hiddenid");
		
			exmvo.setStudentid(studentid);
			exmvo.setHiddenid(hiddenid);
			
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);
			
		
			ArrayList<ExaminationDetailsVo> examslist = new ParentExamdetailsBD()
			.getMoreChildExamListDetails(exmvo);
			
			
			request.setAttribute("studentexam", studentid);
			request.setAttribute("examlist", examslist);
			request.setAttribute("studentlist", student);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getexamlist Ending");
		
		return mapping.findForward(MessageConstants.examdetails);
	}
	
	
	public ActionForward getClassDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getClassDetails Starting");
		
		
		
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
			
			ClassPojo pojo = new ClassPojo();
			String streamname=request.getParameter("streamname");
			
			
			
			pojo.setStreamId(streamname);
			
			List<ClassPojo> classpojo =new ParentExamdetailsBD().getClassListDetails(pojo);
			
			
			

			JSONObject object=new JSONObject();
			 
			 object.put("classlist", classpojo);
			 
			 response.getWriter().print(object);
			 
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getClassDetails Ending");
		
		return null;
	}
	
	
	public ActionForward getSubjectDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getSubjectDetails Starting");
		
		try {
			ClassPojo pojo = new ClassPojo();
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
			
			ViewallSubjectsVo subvo = new ViewallSubjectsVo();
			
			String classid=request.getParameter("classid");
		
			String streamId=request.getParameter("streamId");
			
			subvo.setClassid(classid);
			
			
			
			List<ViewallSubjectsVo> subjectlist =new ParentExamdetailsBD().getSubjectDetails(subvo);
			
			List<StreamDetailsVO> streamvo =new ParentExamdetailsBD().getStreamListDetails();
			List<ClassPojo> classpojo =new ParentExamdetailsBD().getClassListDetails(pojo);
			
			
		/*	JSONObject object=new JSONObject();
			 
			 object.put("classlist", classpojo);
			 
			 response.getWriter().print(object);*/
			
			//request.setAttribute("classlist", classpojo);
			request.setAttribute("streamlist", streamvo);
			request.setAttribute("classid", classid);
			
			request.setAttribute("streamId", streamId);
			request.setAttribute("subjectid", subvo);
		
			request.setAttribute("subjectlist", subjectlist);
		
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getSubjectDetails Ending");
		
		return mapping.findForward(MessageConstants.syllabusdetails);
		
		
	}
	
	
	
	public ActionForward downloadSubject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : downloadSubject Starting");
		
		
		try {
			
			String subid = request.getParameter("subjectid");
			
			String filepath = new ParentExamdetailsBD().getsubjectfilepath(subid);
			
			
			
			String fileName = "FileName";
			fileName=filepath;
			
			
			
			

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);

			response.addHeader("Content-Disposition", "attachment; filename="
					+ fileName);
			File docFile = new File(request.getRealPath("/") + filepath);
			response.setContentLength((int) docFile.length());

			FileInputStream input = new FileInputStream(docFile);
			BufferedInputStream buf = new BufferedInputStream(input);
			int readBytes = 0;
			ServletOutputStream stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}
			

			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : downloadSubject Ending");
		
		
		return null;
			
	}
	
	
	public ActionForward downloadFeedback(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : downloadFeedback Starting");
		
		try {
			
			String fbid = request.getParameter("feedbackId");
			
			
			
			String filepath = new ParentExamdetailsBD().getfeedbackfilepath(fbid);
			
			
			
			String fileName = "FileName";
			fileName=filepath;
			
			
			
			
			response.addHeader("Content-Disposition", "attachment; filename="
					+ fileName);
			File docFile = new File(request.getRealPath("/") + filepath);
			response.setContentLength((int) docFile.length());

			FileInputStream input = new FileInputStream(docFile);
			BufferedInputStream buf = new BufferedInputStream(input);
			int readBytes = 0;
			ServletOutputStream stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}
			
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : downloadFeedback Ending");
		
		
		return null;
	
	}
	
	
	public ActionForward downloadTCfile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : downloadTCfile Starting");
		
		try {
			String docPath = request.getParameter("Path");
			response.setContentType("application/octet-stream");
			String fileName = "FileName";
			fileName=docPath;
			
			
			response.addHeader("Content-Disposition", "attachment; filename="
					+ fileName);
			File docFile = new File(request.getRealPath("/") + docPath);
			response.setContentLength((int) docFile.length());

			FileInputStream input = new FileInputStream(docFile);
			BufferedInputStream buf = new BufferedInputStream(input);
			int readBytes = 0;
			ServletOutputStream stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : downloadTCfile Ending");
		
		return null;
			
	}
	
	
	
	public ActionForward meetingandeventsdetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : meetingandeventsdetails Starting");
		
		try {
			
			

			
			

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
			
			
			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);
			
			vo.setParentID(userid);
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);	
			request.setAttribute("studentlist", student);
		
	List<LstmsUpcomingMeetingVO> meetinglist =new ParentExamdetailsBD().getMeetingListDetails();
	
	
	
			
			request.setAttribute("meetinglist", meetinglist);
			
		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : meetingandeventsdetails Ending");
		
		return mapping.findForward(MessageConstants.getmeetingandevent);
		
	}
	
	
	
	public ActionForward getstudentmeetinglist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getstudentmeetinglist Starting");
		
		try {
			
			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);
			
			vo.setParentID(userid);
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);	
			request.setAttribute("studentlist", student);
		   
			LstmsUpcomingMeetingVO meetvo = new LstmsUpcomingMeetingVO();
			
			String studentid=request.getParameter("studentid");
			String parentid1=request.getParameter("hiddenid");
			
			
			meetvo.setStudentid(studentid);
			meetvo.setParentid(parentid1);
			
			List<LstmsUpcomingMeetingVO> meetinglist =new ParentExamdetailsBD().getstudentmeetinglistBD(meetvo);	
		
			request.setAttribute("studentmeeting", studentid);
			request.setAttribute("meetinglist", meetinglist);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getstudentmeetinglist Ending");
		
		return mapping.findForward(MessageConstants.getmeetingandevent);
		
	}
	
	public ActionForward studentTimeTable(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentTimeTable Starting");
		
		
		try {
			


			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
			
			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);
			String accyearid= HelperClass.getAcademicYear();
			
			
	      	vo.setParentID(userid);
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);	
			
			request.setAttribute("studentlist", student);
			
			
			
			String studentid = student.get(0).getStdAdmisiionNo();
			vo.setStudentid(studentid);
			
			
			 ArrayList<TimeTableVo> timeTableDetails= new ParentExamdetailsBD()
			.getFirstStudentTimeTableBD(vo);
			
			 request.setAttribute("timeTableDetails", timeTableDetails);
			
				
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
	    
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentTimeTable Ending");
		
		return mapping.findForward(MessageConstants.studentTimeTable);

	
	}
	
	
	public ActionForward getStudentTimetable(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getStudentTimetable Starting");
		
		try {
			
			
			String studentid = request.getParameter("studentid");
		    ArrayList<TimeTableVo> timeTableDetails = new ParentExamdetailsBD().getStudentTimetable(studentid);
			
		    
		    
		    request.setAttribute("timeTableDetails", timeTableDetails);
		    
		    
			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);
			String accyearid= HelperClass.getAcademicYear();
			
			
	      	vo.setParentID(userid);
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);	
			
			request.setAttribute("studentlist", student);
			
			request.setAttribute("hiddentstudentid", studentid);
		    
		    
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getStudentTimetable Ending");
		
		return mapping.findForward(MessageConstants.studentTimeTable);
		
		
		
	}
	
	
	public ActionForward requestLeavescreenadd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : requestLeavescreenadd Starting");
		
		
		try {
		
				
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
					.getAttribute("UserDetails");
			String parentid = userDetailVO.getUserId();
			
			
			ParentVO vo = new ParentVO();
			/*String parentid = HelperClass.getCurrentUserID(request);*/
			
			vo.setParentID(parentid);
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);
			
			request.setAttribute("studentlist", student);
			
			request.setAttribute("parentid", vo);
			
			/*UserDetailVO vo = new UserDetailVO();
			
			String userid = request.getParameter("hiddenid");
			vo.setUserId(userid);*/
			
		
			
         List<UserDetailVO> userlist =new ParentExamdetailsBD().getRequestUserListDetails(parentid);
			

         request.setAttribute("userlist", userlist);
          
          
          
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : requestLeavescreenadd Ending");

		
		return mapping.findForward(MessageConstants.LEAVEREQUESTSCREEN);
		
	}
	
	
	
	public ActionForward leaveRequestEntry(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : leaveRequestEntry Starting");
		
		
	

		String path = null;
		String extension = null;
		File fileURL = null;
		FileOutputStream fos = null;
		
		try {
			LeaveRequestForm leaveform =(LeaveRequestForm)form;
			LeaveRequestVo leavevo = new LeaveRequestVo();
			String parentid = HelperClass.getCurrentUserID(request);
			leaveform.setCreateuser(parentid);
			
			/*UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
					.getAttribute("UserDetails");
			String parentid = userDetailVO.getUserId();*/
			
			/*leaveform.setCreateuser(HelperClass.getCurrentUserID(request));*/
			
			ParentVO vo = new ParentVO();
			
			vo.setParentID(parentid);
			
		/*	leaveform.setCreateuser(parentid);*/
		/*	
			String createuser=HelperClass.getCurrentUserID(request);*/
			
			
			
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD().getStudentlist(vo);
			
		   List<UserDetailVO> userlist =new ParentExamdetailsBD().getRequestUserListDetails(HelperClass.getCurrentUserID(request));
			

           request.setAttribute("userlist", userlist);
			
           request.setAttribute("studentlist", student);
			
			request.setAttribute("parentid", vo);
			
			
		
			
		/*	
		    leaveform.setCreateuser(HelperClass.getCurrentUserID(request));
			
			
         	ParentVO vo = new ParentVO();
			//String parentid = HelperClass.getCurrentUserID(request);
			
			vo.setParentID(parentid);
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD()
			.getStudentlist(vo);
			
			
			String studentid = student.get(0).getStdAdmisiionNo();
			vo.setStudentid(studentid);
			leaveform.setStudentid(studentid);*/
         
			
			
			
			
			
			FormFile formFile = leaveform.getFileupload();
			
			
			if(formFile.getFileSize()>0){
				
				path = getServlet().getServletContext().getRealPath("/")+ "FIles\\LEAVEREQUEST";
				File files = new File(path);
				if (!files.exists()) {
					if (files.mkdirs()) {
					}
				}
				path = files.getAbsolutePath();
				
				int i = formFile.getFileName().lastIndexOf('.');
				if (i > 0) {
					extension = formFile.getFileName().substring(i + 1);
				}
				
				String fileName = HelperClass.getCurrentSqlDate() + "_"	+ formFile ;
				fileURL = new File(path, fileName);
	
				fos = new FileOutputStream(fileURL);
				fos.write(formFile.getFileData());
	
				String file1 = fileURL.getPath();
	
				file1 = file1.substring(file1.indexOf("FIles\\"));
	
				if (!fileURL.exists()) {
					FileOutputStream fileOutStream = new FileOutputStream(fileURL);
	
					fileURL.mkdir();
					fileOutStream.write(formFile.getFileData());
	
					fileOutStream.flush();
	
					fileOutStream.close();
				}
				
				leavevo.setFileupload(file1);
				
				
			}
			else{
				
				leavevo.setFileupload(leaveform.getFileupload1());
				
			
				
			}
			
			
			leavevo.setRequestto(leaveform.getRequestto());
			leavevo.setTotalleave(leaveform.getTotalleave());
			leavevo.setFromdate(HelperClass.convertUIToDatabase(leaveform.getFromdate()));
			leavevo.setTodate(HelperClass.convertUIToDatabase(leaveform.getTodate()));
			leavevo.setStarttime(leaveform.getStarttime());
			leavevo.setEndtime(leaveform.getEndtime());
			leavevo.setLeavetype(leaveform.getLeavetype());
			leavevo.setReason(leaveform.getReason());
			leavevo.setCreateuser(leaveform.getCreateuser());
			leavevo.setStudentFname(leaveform.getStudentFname());
			
			leavevo.setSno(leaveform.getSno());
			
			
		
			
			String result =  new ParentLeaveRequestBD()
			.leaveRequestEntryBD(leavevo);
			
			
			
			/*  List<UserDetailVO> userlist =new TeacherLeaveModuleBD().getRequestUserListDetails(HelperClass.getCurrentUserID(request));
		         request.setAttribute("userlist", userlist);*/
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : leaveRequestEntry Ending");
		
		
		return mapping.findForward(MessageConstants.LEAVEREQUESTSCREEN);
	}
	
	
	
	public ActionForward editRequestLeaveAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : editRequestLeaveAction Starting");
		
		try {
			
			
			String parentid = HelperClass.getCurrentUserID(request);
			ParentVO vo = new ParentVO();
			
			vo.setParentID(parentid);
			
			ArrayList<ParentVO> student = new ParentExamdetailsBD().getStudentlist(vo);
			
			  request.setAttribute("studentlist", student);
			
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
					.getAttribute("UserDetails");
			String user = userDetailVO.getUserId();
			
		
         List<UserDetailVO> userlist =new TeacherLeaveModuleBD().getRequestUserListDetails(user);
			

         request.setAttribute("userlist", userlist);
		
			String sno =(String) request.getParameter("snoid");
		
			LeaveRequestVo result = new ParentLeaveRequestBD().getRequestLeaveBD(Integer.parseInt(sno));
			
			
			request.setAttribute("leavedatails", result);
		
		
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : editRequestLeaveAction Ending");
		
		
		return mapping.findForward(MessageConstants.LEAVEREQUESTSCREEN);
	}
	
	
	
	public ActionForward downloadfile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadfile Starting");
		
	try {
			
			String docPath = request.getParameter("Path");
			response.setContentType("application/octet-stream");
			String fileName = "FileName";
			fileName=docPath;
			
			
			response.addHeader("Content-Disposition", "attachment; filename="
					+ fileName);
			
			File docFile = new File(request.getRealPath("/") + docPath);
			response.setContentLength((int) docFile.length());

			FileInputStream input = new FileInputStream(docFile);
			BufferedInputStream buf = new BufferedInputStream(input);
			int readBytes = 0;
			ServletOutputStream stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadfile Ending");
		return null;
	}
		
		
		
	public ActionForward circularRemainderParentAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : circularRemainderParentAction Starting");
		
		
		try {
			

			
			

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT); 
			
	      List<RemainderMasterVO> remainderlist =new ParentLeaveRequestBD().getRemainderlistBD();	
			
			
			
			request.setAttribute("remainderlist", remainderlist);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		
		
		
		
		
		

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : circularRemainderParentAction Ending");
		
		
		
		return mapping.findForward(MessageConstants.parentRemainder);
	}
	
	
	
	
	
	
	
	
	
	
}
