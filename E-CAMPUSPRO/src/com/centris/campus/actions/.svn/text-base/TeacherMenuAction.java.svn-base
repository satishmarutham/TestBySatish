package com.centris.campus.actions;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.json.JSONObject;

import com.centris.campus.delegate.AssignmentUploadBD;
import com.centris.campus.delegate.CreateExaminationBD;
import com.centris.campus.delegate.ExamDetailsBD;
import com.centris.campus.delegate.MarksUploadDelegate;
import com.centris.campus.delegate.ParentExamdetailsBD;
import com.centris.campus.delegate.ParentLeaveRequestBD;
import com.centris.campus.delegate.ReportsMenuBD;
import com.centris.campus.delegate.RoleMasterBD;
import com.centris.campus.delegate.StudentAttendanceBD;
import com.centris.campus.delegate.TeacherLeaveModuleBD;
import com.centris.campus.forms.LeaveRequestForm;
import com.centris.campus.pojo.StreamDetailsPojo;
import com.centris.campus.serviceImpl.TeacherServiceImpl;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.ExaminationDetailsVo;
import com.centris.campus.vo.LeaveBalanceVo;
import com.centris.campus.vo.LeaveRequestVo;
import com.centris.campus.vo.LstmsUpcomingMeetingVO;
import com.centris.campus.vo.ParentVO;
import com.centris.campus.vo.RemainderMasterVO;
import com.centris.campus.vo.StudentAttendanceVo;
import com.centris.campus.vo.TimeTableVo;
import com.centris.campus.vo.UserDetailVO;

public class TeacherMenuAction extends DispatchAction {

	static ResourceBundle res = ResourceBundle
			.getBundle("com/centris/campus/properties/CAMPUS");
	private static String EcampusPro_Payslip_Dir = res
			.getString("EcampusPro_Payslip_Dir");

	private static final Logger logger = Logger
			.getLogger(TeacherMenuAction.class);

	private static String ImageName = res.getString("ImageName");

	public ActionForward Home(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : Home Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TEACHERS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TEACHERS);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : Home Ending");

		return mapping.findForward(MessageConstants.TEACHER_HOME);
	}

	public ActionForward leaveRequest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : leaveRequest Starting");
		try {

			String searchTerm = request.getParameter("searchTerm");

			ArrayList<LeaveRequestVo> leavelist = new ArrayList<LeaveRequestVo>();

			ParentExamdetailsBD leavedeligate = new ParentExamdetailsBD();

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TEACHERS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TEACHERS);

			String parentid = HelperClass.getCurrentUserID(request);

			request.setAttribute("parentid", parentid);

			ParentVO vo = new ParentVO();

			request.setAttribute("parentid", vo);

			LeaveRequestVo leavevo = new LeaveRequestVo();

			if (searchTerm != null) {
				System.out.println("Searching is working");

				leavelist = leavedeligate.searchleaverequest(searchTerm);

				// request.setAttribute("examDetailsList", examvo);
				request.setAttribute("searchterm", searchTerm);
			} else {

				leavelist = leavedeligate.getleaveRequestDetailsBD(leavevo);
				System.out.println("listing is working");
			}

			request.setAttribute("leavelist", leavelist);
			request.getSession(false).setAttribute("excelDownLoad", leavelist);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : leaveRequest Ending");

		return mapping.findForward(MessageConstants.LEAVEREQUEST);
	}

	/*
	 * public ActionForward requestLeavescreen(ActionMapping mapping, ActionForm
	 * form, HttpServletRequest request, HttpServletResponse response) throws
	 * Exception {
	 * 
	 * logger.setLevel(Level.DEBUG); JLogger.log(0, JDate.getTimeString(new
	 * Date()) + MessageConstants.START_POINT);
	 * logger.info(JDate.getTimeString(new Date()) +
	 * " Control in TeacherMenuAction : requestLeavescreen Starting"); try {
	 * String status = "status";
	 * request.setAttribute(MessageConstants.MODULE_NAME,
	 * MessageConstants.BACKOFFICE_TEACHERS);
	 * request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
	 * MessageConstants.MODULE_TEACHERS); request.setAttribute("status",
	 * status);
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(), e);
	 * e.printStackTrace(); }
	 * 
	 * JLogger.log(0, JDate.getTimeString(new Date()) +
	 * MessageConstants.END_POINT); logger.info(JDate.getTimeString(new Date())
	 * + " Control in TeacherMenuAction : requestLeavescreen Ending");
	 * 
	 * return mapping.findForward(MessageConstants.LEAVEREQUESTSCREEN); }
	 */

	public ActionForward leaveApproval(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : leaveApproval Starting");
		try {

			String userid = HelperClass.getCurrentUserID(request);

			String usertype = HelperClass.getCurrentUser(request);

			LeaveRequestVo leavevo = new LeaveRequestVo();

			leavevo.setUserid(userid);
			leavevo.setUsertype(usertype);

			String searchTerm = request.getParameter("searchTerm");

			System.out.println("searchTerm::" + searchTerm);

			ArrayList<LeaveRequestVo> leaveapproval = null;

			if (searchTerm != null) {

				leaveapproval = new ParentExamdetailsBD()
						.searchleave(searchTerm);

				request.setAttribute("search", searchTerm);

			} else {

				leaveapproval = new ParentExamdetailsBD()
						.getleaveApprovalDetailsBD(leavevo);

			}

			request.setAttribute("leaveapproval", leaveapproval);
			request.getSession(false).setAttribute("excel", leaveapproval);

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_LEAVE);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TEACHERS);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : leaveApproval Ending");

		return mapping.findForward(MessageConstants.LEAVEAPPROVAL);
	}

	public ActionForward LeaveApprovalScreen(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : LeaveApprovalScreen Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TEACHERS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TEACHERS);

			/* String userid = HelperClass.getCurrentUserID(request); */

			LeaveRequestVo leavevo = new LeaveRequestVo();

			String sno = request.getParameter("snoid");

			// leavevo.setUserid(sno);

			// leavevo.setSno1(sno);

			LeaveRequestVo result = new ParentExamdetailsBD()
					.getLeaveApprovalBD(Integer.parseInt(sno));
			request.setAttribute("attnhidden", sno);
			request.setAttribute("leaveapprovelist", result);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : LeaveApprovalScreen Ending");

		return mapping.findForward(MessageConstants.LEAVEAPPROVALSCREEN);
	}

	public ActionForward ApprovingLeaveforleaveRequest(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : leaveApproval Starting");
		try {

			String userid = HelperClass.getCurrentUserID(request);

			String usertype = HelperClass.getCurrentUser(request);

			LeaveRequestVo leavevo = new LeaveRequestVo();

			String sno = request.getParameter("snoid");

			String leavesapproved = request.getParameter("leavesapproved");

			String approvedstartdate = request
					.getParameter("approvedstartdate");

			String approvedleavestatus = request
					.getParameter("approvedleavestatus");

			String comments = request.getParameter("comments");

			String approvedenddate = request.getParameter("approvedenddate");

			String approvedendsessionDay = request
					.getParameter("approvedendsessionDay");

			String approvedstartsessionDay = request
					.getParameter("approvedstartsessionDay");

			leavevo.setSno(Integer.parseInt(sno));

			leavevo.setLeavesapproved(leavesapproved);

			leavevo.setApprovedstartdate(approvedstartdate);

			leavevo.setApprovedenddate(approvedenddate);

			leavevo.setApprovedleavestatus(approvedleavestatus);

			leavevo.setComments(comments);

			leavevo.setUserid(userid);

			leavevo.setUsertype(usertype);

			leavevo.setApprovedstartsessionDay(approvedstartsessionDay);

			leavevo.setApprovedendsessionDay(approvedendsessionDay);

			ArrayList<LeaveRequestVo> leaveapproval = new ParentExamdetailsBD()
					.ApprovingLeaveforleaveRequestBD(leavevo);

			request.setAttribute("leaveapproval", leaveapproval);

			ArrayList<LeaveRequestVo> leaveapproval1 = new ParentExamdetailsBD()
					.getleaveApprovalDetailsBD(leavevo);

			request.setAttribute("leaveapproval", leaveapproval1);

			request.setAttribute("success", "success");

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TEACHERS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TEACHERS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : leaveApproval Ending");

		return mapping.findForward(MessageConstants.LEAVEAPPROVAL);
	}

	public ActionForward attendaceStatus(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : attendaceStatus Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);

			String startdate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");

			ArrayList<StudentAttendanceVo> studentAttendance = new StudentAttendanceBD()
					.getStudentsAttendanceList(startdate, endDate);

			request.setAttribute("attendancelist", studentAttendance);

			request.setAttribute("StartDate", startdate);
			request.setAttribute("EndDate", endDate);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : attendaceStatus Ending");

		return mapping.findForward(MessageConstants.ATTENDANCESTATUS);
	}

	public ActionForward attendaceUpload(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : attendaceUpload Starting");
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
				+ " Control in TeacherMenuAction : attendaceUpload Ending");

		return mapping.findForward(MessageConstants.ATTENDANCEUPLOAD);
	}

	public ActionForward assignmentView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : assignmentView Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);

			String searchTerm = request.getParameter("searchTerm");

			if (searchTerm == null) {

				searchTerm = "";
			}

			String userId = HelperClass.getCurrentUserID(request);
			String accYearString = request.getSession(false)
					.getAttribute("current_academicYear").toString();

			request.setAttribute("AssignmentList", new AssignmentUploadBD()
					.getAssignment(userId, accYearString, searchTerm));

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : assignmentView Ending");

		return mapping.findForward(MessageConstants.ASSIGNMENTVIEW);
	}

	public ActionForward addassignment(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : addassignment Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);

			request.setAttribute("StreamList", new ReportsMenuBD().getStream());
			request.setAttribute("SubjectsList",
					new TeacherServiceImpl().getSubjects());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : addassignment Ending");

		return mapping.findForward(MessageConstants.ADDASSIGNMENT);
	}

	public ActionForward marksStatus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : marksStatus Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);

			String searchTerm = request.getParameter("searchTerm");

			if (searchTerm == null) {

				searchTerm = "";
			}
			request.setAttribute("MarksUploadList",
					new MarksUploadDelegate().getMarksUploadList(searchTerm));

			request.getSession(false).setAttribute("EXcelDownLoad",
					new MarksUploadDelegate().getMarksUploadList(searchTerm));

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : marksStatus Ending");

		return mapping.findForward(MessageConstants.MARKSUPLOAD);
	}

	public ActionForward uploadMarks(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : uploadMarks Starting");
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
				+ " Control in TeacherMenuAction : uploadMarks Ending");

		return mapping.findForward(MessageConstants.MARKSUPLOADSCREEN);
	}

	public ActionForward requestLeavescreenadd(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : requestLeavescreenadd Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String parentid = userDetailVO.getUserId();

			ParentVO vo = new ParentVO();

			vo.setParentID(parentid);

			ArrayList<ParentVO> student = new ParentExamdetailsBD()
					.getStudentlist(vo);

			request.setAttribute("studentlist", student);

			request.setAttribute("parentid", vo);

			List<UserDetailVO> userlist = new ParentExamdetailsBD()
					.getRequestUserListDetails(parentid);

			request.setAttribute("userlist", userlist);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : requestLeavescreenadd Ending");

		return mapping.findForward(MessageConstants.teacherLeaveRequest);

	}

	public ActionForward addassignmentedit(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : addassignment Starting");
		try {

			String status = "status";
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TEACHERS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TEACHERS);
			request.setAttribute("status", status);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : addassignment Ending");

		return mapping.findForward(MessageConstants.ADDASSIGNMENT);
	}

	public ActionForward uploadMarksedit(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : uploadMarksedit Starting");
		try {

			String status = "status";
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TEACHERS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TEACHERS);
			request.setAttribute("status", status);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : uploadMarksedit Ending");

		return mapping.findForward(MessageConstants.MARKSUPLOADSCREEN);
	}

	public ActionForward leaveRequestEntry(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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

			System.out.println("dnfhdnfhdnfdh dsfnd");

			LeaveRequestForm leaveform = (LeaveRequestForm) form;
			LeaveRequestVo leavevo = new LeaveRequestVo();
			String parentid = HelperClass.getCurrentUserID(request);
			leaveform.setCreateuser(parentid);

			/*
			 * UserDetailVO userDetailVO = (UserDetailVO)
			 * request.getSession(false) .getAttribute("UserDetails"); String
			 * parentid = userDetailVO.getUserId();
			 */

			leaveform.setCreateuser(HelperClass.getCurrentUserID(request));

			ParentVO vo = new ParentVO();

			vo.setParentID(parentid);

			leaveform.setCreateuser(parentid);

			/*
			 *  * String createuser=HelperClass.getCurrentUserID(request);
			 */

			ArrayList<ParentVO> student = new ParentExamdetailsBD()
					.getStudentlist(vo);

			List<UserDetailVO> userlist = new ParentExamdetailsBD()
					.getRequestUserListDetails(HelperClass
							.getCurrentUserID(request));

			request.setAttribute("userlist", userlist);

			request.setAttribute("studentlist", student);

			request.setAttribute("parentid", parentid);

			/*
			 * leaveform.setCreateuser(HelperClass.getCurrentUserID(request));
			 * 
			 * 
			 * ParentVO vo = new ParentVO(); //String parentid =
			 * HelperClass.getCurrentUserID(request);
			 * 
			 * vo.setParentID(parentid);
			 * 
			 * ArrayList<ParentVO> student = new ParentExamdetailsBD()
			 * .getStudentlist(vo);
			 * 
			 * 
			 * String studentid = student.get(0).getStdAdmisiionNo();
			 * vo.setStudentid(studentid); leaveform.setStudentid(studentid);
			 */

			FormFile formFile = leaveform.getFileupload();

			if (formFile.getFileSize() > 0) {

				path = getServlet().getServletContext().getRealPath("/")
						+ "FIles\\LEAVEREQUEST";
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

				String fileName = HelperClass.getCurrentSqlDate() + "_"
						+ formFile;
				fileURL = new File(path, fileName);

				fos = new FileOutputStream(fileURL);
				fos.write(formFile.getFileData());

				String file1 = fileURL.getPath();

				file1 = file1.substring(file1.indexOf("FIles\\"));

				if (!fileURL.exists()) {
					FileOutputStream fileOutStream = new FileOutputStream(
							fileURL);

					fileURL.mkdir();
					fileOutStream.write(formFile.getFileData());

					fileOutStream.flush();

					fileOutStream.close();
				}

				leavevo.setFileupload(file1);

			} else {

				leavevo.setFileupload(leaveform.getFileupload1());

			}

			leavevo.setRequestto(leaveform.getRequestto());
			leavevo.setTotalleave(leaveform.getTotalleave());
			leavevo.setFromdate(HelperClass.convertUIToDatabase(leaveform
					.getFromdate()));
			leavevo.setTodate(HelperClass.convertUIToDatabase(leaveform
					.getTodate()));
			leavevo.setStarttime(leaveform.getStarttime());
			leavevo.setEndtime(leaveform.getEndtime());
			leavevo.setLeavetype(leaveform.getLeavetype());
			leavevo.setReason(leaveform.getReason());
			leavevo.setCreateuser(leaveform.getCreateuser());
			leavevo.setStudentFname(leaveform.getStudentFname());

			leavevo.setSno(leaveform.getSno());

			String result = new TeacherLeaveModuleBD()
					.leaveRequestEntryBD(leavevo);

			/*
			 * List<UserDetailVO> userlist =new
			 * TeacherLeaveModuleBD().getRequestUserListDetails
			 * (HelperClass.getCurrentUserID(request));
			 * request.setAttribute("userlist", userlist);
			 */

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : leaveRequestEntry Ending");

		return mapping.findForward(MessageConstants.teacherLeaveRequest);

		/*
		 * return mapping.findForward(MessageConstants.LEAVEREQUEST);
		 */}

	public ActionForward editRequestLeaveAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : editRequestLeaveAction Starting");

		try {
			System.out.println("Action for GET_LEAVE_DETAILS is working");

			String parentid = HelperClass.getCurrentUserID(request);
			ParentVO vo = new ParentVO();

			vo.setParentID(parentid);

			ArrayList<ParentVO> student = new ParentExamdetailsBD()
					.getStudentlist(vo);

			request.setAttribute("studentlist", student);

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String user = userDetailVO.getUserId();

			List<UserDetailVO> userlist = new TeacherLeaveModuleBD()
					.getRequestUserListDetails(user);

			request.setAttribute("userlist", userlist);

			String sno = (String) request.getParameter("snoid");

			LeaveRequestVo result = new TeacherLeaveModuleBD()
					.getRequestLeaveBD(Integer.parseInt(sno));

			request.setAttribute("leavedatails", result);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : editRequestLeaveAction Ending");

		return mapping.findForward(MessageConstants.teacherLeaveRequest);

	}

	public ActionForward deleteLeaveRequestAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : deleteLeaveRequestAction Starting");

		try {

			String userid = HelperClass.getCurrentUserID(request);
			String sno = (String) request.getParameter("snoid");

			LeaveRequestVo check = new ParentExamdetailsBD()
					.deleteRequestLeaveBD(Integer.parseInt(sno), userid);

			request.setAttribute("delete", check);
			JSONObject json = new JSONObject();

			json.put("status", check);

			response.getWriter().print(json);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : deleteLeaveRequestAction Ending");

		return null;
	}

	public ActionForward viewTeacherTimeTable(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : viewTeacherTimeTable Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STAFF);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STAFF);

			String userid = HelperClass.getCurrentUserID(request);

			ArrayList<TimeTableVo> timeTableDetails = new TeacherLeaveModuleBD()
					.getTeacherTimetable(userid);

			request.setAttribute("timeTableDetails", timeTableDetails);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : viewTeacherTimeTable Ending");

		return mapping.findForward(MessageConstants.teacherTimeTable);

	}

	public ActionForward downloadPayslip(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadPayslip Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STAFF);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STAFF);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadPayslip Ending");

		return mapping.findForward(MessageConstants.DOWNLOAD_PAYSLIP);

	}

	public ActionForward teacherLeaveRequestAdd(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : teacherLeaveRequestAdd Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String parentid = userDetailVO.getUserId();

			// System.out.println("parentid"+parentid);

			ParentVO vo = new ParentVO();
			/* String parentid = HelperClass.getCurrentUserID(request); */

			vo.setParentID(parentid);

			ArrayList<ParentVO> student = new ParentExamdetailsBD()
					.getStudentlist(vo);

			request.setAttribute("studentlist", student);

			request.setAttribute("parentid", vo);

			List<UserDetailVO> userlist = new ParentExamdetailsBD()
					.getRequestUserListDetails(parentid);

			request.setAttribute("userlist", userlist);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : leaveRequestEntry Ending");

		return mapping.findForward(MessageConstants.teacherLeaveRequest);
	}

	public ActionForward viewLeaveBalance(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : viewLeaveBalance Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String userid = userDetailVO.getUserId();

			String accyear = HelperClass.getCurrentYearID();

			String username = request.getParameter("teachername");
			LeaveRequestForm leaveform = (LeaveRequestForm) form;
			leaveform.setCreateuser(username);

			List<LeaveBalanceVo> leavebalancelist = new TeacherLeaveModuleBD()
					.viewLeaveBalListDetails(userid, accyear, leaveform);

			JSONObject leave_Object = new JSONObject();
			leave_Object.put("leavedetails", leavebalancelist);

			response.getWriter().print(leave_Object);

			request.setAttribute("viewbalance", leavebalancelist);

			request.setAttribute("success", "success");

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : viewLeaveBalance Ending");

		return null;

	}

	public ActionForward viewMeetingdandEvents(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : viewMeetingdandEvents Starting");

		try {
			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);

			vo.setParentID(userid);

			ArrayList<ParentVO> teacher = new TeacherLeaveModuleBD()
					.getTeacherlist(vo);

			request.setAttribute("teacherlist", teacher);

			List<LstmsUpcomingMeetingVO> meetinglist = new ParentExamdetailsBD()
					.getMeetingListDetails();
			request.setAttribute("meetinglist", meetinglist);
			request.setAttribute("parenthiddenid", userid);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : viewMeetingdandEvents Ending");

		return mapping.findForward(MessageConstants.teachermeetingandevent);
	}

	public ActionForward getTeacherMeeting(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : viewMeetingdandEvents Starting");

		try {

			ParentVO vo = new ParentVO();
			String userid = HelperClass.getCurrentUserID(request);

			vo.setParentID(userid);

			ArrayList<ParentVO> teacher = new TeacherLeaveModuleBD()
					.getTeacherlist(vo);

			request.setAttribute("teacherlist", teacher);

			LstmsUpcomingMeetingVO meetvo = new LstmsUpcomingMeetingVO();

			String teacherid = request.getParameter("hiddenid");

			meetvo.setTeacher(teacherid);

			List<LstmsUpcomingMeetingVO> meetinglist = new TeacherLeaveModuleBD()
					.getteachermeetinglistBD(meetvo);

			request.setAttribute("meetinglist", meetinglist);

			request.setAttribute("studentmeeting", userid);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : viewMeetingdandEvents Ending");

		return mapping.findForward(MessageConstants.teachermeetingandevent);
	}

	public synchronized ActionForward downloadPayslipDocument(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherRegistrationAction: downloadDocument Starting");

		boolean flag = false;
		String month = null;
		String year = null;
		try {

			month = (String) request.getParameter("month");

			year = (String) request.getParameter("accyear");

			UserDetailVO userDetailsVo = (UserDetailVO) request.getSession(
					false).getAttribute(MessageConstants.USER_DETAILS);
			String userid = userDetailsVo.getUserId();
			String username = userDetailsVo.getFirstName().replace(" ", "_");

			String docPath = EcampusPro_Payslip_Dir + "/" + year + "-" + month
					+ "/" + userid + "-" + username + ".pdf";

			System.out.println(docPath);

			File docFile = new File(docPath);

			if (docFile.exists() && !docFile.isDirectory()) {

				flag = true;

				response.setContentType("application/octet-stream");
				String fileName = "FileName";
				fileName = docPath;

				response.addHeader("Content-Disposition",
						"attachment; filename=" + userid + "-" + username
								+ ".pdf");

				response.setContentLength((int) docFile.length());

				FileInputStream input = new FileInputStream(docFile);
				BufferedInputStream buf = new BufferedInputStream(input);
				int readBytes = 0;
				ServletOutputStream stream = response.getOutputStream();
				while ((readBytes = buf.read()) != -1) {
					stream.write(readBytes);
				}

			} else {
				flag = false;

			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherRegistrationAction: downloadDocument Ending");

		if (flag) {
			return null;
		} else {

			request.setAttribute("month", month);
			request.setAttribute("year", year);

			request.setAttribute("error",
					"For selected month and year payslip not generated");

			return mapping.findForward(MessageConstants.DOWNLOAD_PAYSLIP);
		}
	}

	public ActionForward downloadLeaveDetailsXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadLeaveDetailsXLS  Starting");

		try {

			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/LeaveApprovalDetailsXls.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			

			
			String userid = HelperClass.getCurrentUserID(request);

			String usertype = HelperClass.getCurrentUser(request);

			LeaveRequestVo leavevo = new LeaveRequestVo();

			leavevo.setUserid(userid);
			leavevo.setUsertype(usertype);

			String searchTerm = request.getParameter("searchTerm");

			System.out.println("downloadsearchTerm::" + searchTerm);

			ArrayList<LeaveRequestVo> leaveapproval = null;

			if (searchTerm != null) {

				leaveapproval = new ParentExamdetailsBD()
						.searchleave(searchTerm);

				request.setAttribute("search", searchTerm);

			} else {

				leaveapproval = new ParentExamdetailsBD()
						.getleaveApprovalDetailsBD(leavevo);

			}

			
			
			
			
			
			/*
			 * List<LeaveRequestVo> List = new ArrayList<LeaveRequestVo>();
			 * ParentExamdetailsBD delegate = new ParentExamdetailsBD(); List =
			 * delegate.getleaveApprovalDetailsBD(leavevo);
			 */

		/*	ArrayList<LeaveRequestVo> leavelist = new ArrayList<LeaveRequestVo>();
			leavelist = (ArrayList<LeaveRequestVo>) request.getSession(false)
					.getAttribute("excel");*/

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					leaveapproval);
			Map parameters = new HashMap();

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/LeaveApprovalDetailsXls.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Leave Approval Details Excel Report" };
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.FALSE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.SHEET_NAMES,
					sheetNames);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
					Boolean.FALSE);

			exporter.exportReport();

			pdfxls = new File(
					request.getRealPath("Reports/LeaveApprovalDetailsXls.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=LeaveApprovalDetailsXls.xls");
			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
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
				+ " Control in TeacherMenuAction : downloadLeaveDetailsXLS   Ending");
		return null;

	}

	public ActionForward downloadLeaveDetailsPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadLeaveDetailsPDF  Starting");

		try {

			
			/*
			 * List<LeaveRequestVo> Details = new ArrayList<LeaveRequestVo>();
			 * ParentExamdetailsBD delegate = new ParentExamdetailsBD(); Details
			 * = delegate.getleaveApprovalDetailsBD(leavevo);
			 */

		/*	ArrayList<LeaveRequestVo> leavelist = new ArrayList<LeaveRequestVo>();
			leavelist = (ArrayList<LeaveRequestVo>) request.getSession(false)
					.getAttribute("excel");*/
			

			String userid = HelperClass.getCurrentUserID(request);

			String usertype = HelperClass.getCurrentUser(request);

			LeaveRequestVo leavevo = new LeaveRequestVo();

			leavevo.setUserid(userid);
			leavevo.setUsertype(usertype);

			String searchTerm = request.getParameter("searchTerm");

			System.out.println("downloadsearchTerm::" + searchTerm);

			ArrayList<LeaveRequestVo> leaveapproval = null;

			if (searchTerm != null) {

				leaveapproval = new ParentExamdetailsBD()
						.searchleave(searchTerm);

				request.setAttribute("searchTerm", searchTerm);

			} else {

				leaveapproval = new ParentExamdetailsBD()
						.getleaveApprovalDetailsBD(leavevo);

			}

			String sourceFileName = request
					.getRealPath("Reports/LeaveDetailsPDF.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);

			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					leaveapproval);

			String PropfilePath = getServlet().getServletContext().getRealPath(
					"")
					+ "\\images\\" + ImageName.trim();

			String schName = res.getString("SchoolName");
			String schAddLine1 = res.getString("AddressLine1");

			Map parameters = new HashMap();

			parameters.put("Image", PropfilePath);

			/*
			 * parameters.put("Image", clientImage);
			 * 
			 * parameters.put("ClientName", ClientName);
			 * 
			 * parameters.put("ClientAddress", ClientAddress_l1);
			 */

			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanColDataSource);

			response.setContentType("application/pdf");

			response.setContentLength(bytes.length);

			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "LeaveDetailsPDF - " + ".pdf\"");

			ServletOutputStream outstream = response.getOutputStream();

			outstream.write(bytes, 0, bytes.length);

			outstream.flush();

		}

		catch (Exception e)

		{
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadLeaveDetailsPDF  Ending");
		return null;

	}

	public ActionForward downloadmeetingsandeventsXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadmeetingsandeventsXLS  Starting");

		try {

			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/meetingsandeventxls.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			List<LstmsUpcomingMeetingVO> meetinglist = new ParentExamdetailsBD()
					.getMeetingListDetails();

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					meetinglist);
			Map parameters = new HashMap();

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/meetingsandeventxls.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Meetings and Events Excel Report" };
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.FALSE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.SHEET_NAMES,
					sheetNames);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
					Boolean.FALSE);

			exporter.exportReport();

			pdfxls = new File(
					request.getRealPath("Reports/meetingsandeventxls.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=MeetingsandEventxls.xls");
			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
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
				+ " Control in TeacherMenuAction : downloadmeetingsandeventsXLS   Ending");
		return null;

	}

	public ActionForward downloadmeetingsandeventsPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadmeetingsandeventsPDF  Starting");

		try {

			System.out.println("downloading pdf");

			List<LstmsUpcomingMeetingVO> Details = new ParentExamdetailsBD()
					.getMeetingListDetails();

			String sourceFileName = request
					.getRealPath("Reports/meetingandeventgDetailsPDF.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);

			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					Details);

			String PropfilePath = getServlet().getServletContext().getRealPath(
					"")
					+ "\\images\\" + ImageName.trim();

			String schName = res.getString("SchoolName");
			String schAddLine1 = res.getString("AddressLine1");

			Map parameters = new HashMap();

			parameters.put("Image", PropfilePath);

			/*
			 * parameters.put("Image", clientImage);
			 * 
			 * parameters.put("ClientName", ClientName);
			 * 
			 * parameters.put("ClientAddress", ClientAddress_l1);
			 */

			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanColDataSource);

			response.setContentType("application/pdf");

			response.setContentLength(bytes.length);

			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "MeetingandEventgDetailsPDF - " + ".pdf\"");

			ServletOutputStream outstream = response.getOutputStream();

			outstream.write(bytes, 0, bytes.length);

			outstream.flush();

		}

		catch (Exception e)

		{
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadmeetingsandeventsPDF  Ending");
		return null;

	}

	public ActionForward downloadTeacherTimetableXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadTeacherTimetableXLS  Starting");

		try {

			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/teachertimetablexls.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			String userid = HelperClass.getCurrentUserID(request);

			ArrayList<TimeTableVo> timeTableDetails = new TeacherLeaveModuleBD()
					.getTeacherTimetable(userid);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					timeTableDetails);
			Map parameters = new HashMap();

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/teachertimetablexls.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Teacher TimeTable Excel Report" };
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.FALSE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.SHEET_NAMES,
					sheetNames);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
					Boolean.FALSE);

			exporter.exportReport();

			pdfxls = new File(
					request.getRealPath("Reports/teachertimetablexls.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=TeacherTimetablexls.xls");
			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
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
				+ " Control in TeacherMenuAction : downloadTeacherTimetableXLS   Ending");
		return null;

	}

	public ActionForward downloadTeacherTimetablePDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadTeacherTimetablePDF  Starting");

		try {

			System.out.println("downloading pd f");

			String userid = HelperClass.getCurrentUserID(request);

			ArrayList<TimeTableVo> timeTableDetails = new TeacherLeaveModuleBD()
					.getTeacherTimetable(userid);

			String sourceFileName = request
					.getRealPath("Reports/teachertimetablePDF.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);

			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					timeTableDetails);

			String PropfilePath = getServlet().getServletContext().getRealPath(
					"")
					+ "\\images\\" + ImageName.trim();

			String schName = res.getString("SchoolName");
			String schAddLine1 = res.getString("AddressLine1");

			Map parameters = new HashMap();

			parameters.put("Image", PropfilePath);

			/*
			 * parameters.put("Image", clientImage);
			 * 
			 * parameters.put("ClientName", ClientName);
			 * 
			 * parameters.put("ClientAddress", ClientAddress_l1);
			 */

			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanColDataSource);

			response.setContentType("application/pdf");

			response.setContentLength(bytes.length);

			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "TeacherTimetablePDF - " + ".pdf\"");

			ServletOutputStream outstream = response.getOutputStream();

			outstream.write(bytes, 0, bytes.length);

			outstream.flush();

		}

		catch (Exception e)

		{
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadTeacherTimetablePDF  Ending");
		return null;

	}

	public ActionForward circularRemainder(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : circularRemainder  Starting");

		try {

			List<RemainderMasterVO> remainderlist = new TeacherLeaveModuleBD()
					.getRemainderlistBD();

			request.setAttribute("remainderlist", remainderlist);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : circularRemainder  Ending");

		return mapping.findForward(MessageConstants.teacherRemainder);

	}

	public ActionForward downloadLeaveRequestXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadLeaveRequestXLS  Starting");

		try {

			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/leaverequestdetailsxls.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			String searchTerm = request.getParameter("searchTerm");

			System.out.println("searchTerm" + searchTerm);

			ArrayList<LeaveRequestVo> leavelist = new ArrayList<LeaveRequestVo>();

			ParentExamdetailsBD leavedeligate = new ParentExamdetailsBD();

			LeaveRequestVo leavevo = new LeaveRequestVo();

			if (searchTerm != null) {
				System.out.println("Searching is working");

				leavelist = leavedeligate.searchleaverequest(searchTerm);

				request.setAttribute("searchterm", searchTerm);
			} else {

				leavelist = leavedeligate.getleaveRequestDetailsBD(leavevo);
				System.out.println("listing is working");
			}

			/*
			 * ArrayList<LeaveRequestVo> leavelist = new
			 * ArrayList<LeaveRequestVo>(); leavelist =
			 * (ArrayList<LeaveRequestVo>) request.getSession(false)
			 * .getAttribute("excelDownLoad");
			 */

			/*
			 * LeaveRequestVo leavevo = new LeaveRequestVo();
			 * 
			 * ArrayList<LeaveRequestVo> leavelist = new ParentExamdetailsBD()
			 * .getleaveRequestDetailsBD(leavevo);
			 */
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					leavelist);
			Map parameters = new HashMap();

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/LeaveRequestDetailsxls.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "LeaveRequest Details Excel Report" };
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.FALSE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.SHEET_NAMES,
					sheetNames);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
					Boolean.FALSE);

			exporter.exportReport();

			pdfxls = new File(
					request.getRealPath("Reports/LeaveRequestDetailsxls.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=LeaveRequestDetailsxls.xls");
			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
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
				+ " Control in TeacherMenuAction : downloadLeaveRequestXLS   Ending");
		return null;

	}

	public ActionForward downloadLeaveRequestPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadLeaveRequestPDF  Starting");

		try {

			System.out.println("downloading pdf");

			/*
			 * LeaveRequestVo leavevo = new LeaveRequestVo();
			 * 
			 * ArrayList<LeaveRequestVo> leavelist = new ParentExamdetailsBD()
			 * .getleaveRequestDetailsBD(leavevo);
			 */
			/*
			 * ArrayList<LeaveRequestVo> leavelist = new
			 * ArrayList<LeaveRequestVo>(); leavelist =
			 * (ArrayList<LeaveRequestVo>) request.getSession(false)
			 * .getAttribute("excelDownLoad");
			 */

			String searchTerm = request.getParameter("searchTerm");

			System.out.println("searchTerm" + searchTerm);

			ArrayList<LeaveRequestVo> leavelist = new ArrayList<LeaveRequestVo>();

			ParentExamdetailsBD leavedeligate = new ParentExamdetailsBD();

			LeaveRequestVo leavevo = new LeaveRequestVo();

			if (searchTerm != null) {
				System.out.println("Searching is working");

				leavelist = leavedeligate.searchleaverequest(searchTerm);

				request.setAttribute("searchterm", searchTerm);
			} else {

				leavelist = leavedeligate.getleaveRequestDetailsBD(leavevo);
				System.out.println("listing is working");
			}
			String sourceFileName = request
					.getRealPath("Reports/leaverequestDetailsPDF.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);

			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					leavelist);

			String PropfilePath = getServlet().getServletContext().getRealPath(
					"")
					+ "\\images\\" + ImageName.trim();

			String schName = res.getString("SchoolName");
			String schAddLine1 = res.getString("AddressLine1");

			Map parameters = new HashMap();

			parameters.put("Image", PropfilePath);

			/*
			 * parameters.put("Image", clientImage);
			 * 
			 * parameters.put("ClientName", ClientName);
			 * 
			 * parameters.put("ClientAddress", ClientAddress_l1);
			 */

			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanColDataSource);

			response.setContentType("application/pdf");

			response.setContentLength(bytes.length);

			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "LeaveRequestDetailsPDF - " + ".pdf\"");

			ServletOutputStream outstream = response.getOutputStream();

			outstream.write(bytes, 0, bytes.length);

			outstream.flush();

		}

		catch (Exception e)

		{
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadLeaveRequestPDF  Ending");
		return null;

	}

	public ActionForward downloadcircularandremainderXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadcircularandremainderXLS  Starting");

		try {

			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/circularandRemainderXLSReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			List<RemainderMasterVO> remainderlist = new TeacherLeaveModuleBD()
					.getRemainderlistBD();
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					remainderlist);
			Map parameters = new HashMap();

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/circularandRemainderXLSReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Circular And Remainder Details Excel Report" };
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.FALSE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.SHEET_NAMES,
					sheetNames);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
					Boolean.FALSE);

			exporter.exportReport();

			pdfxls = new File(
					request.getRealPath("Reports/CircularAndRemainderXLSReport.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=CircularAndRemainderXLSReport.xls");
			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
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
				+ " Control in TeacherMenuAction : downloadcircularandremainderXLS   Ending");
		return null;

	}

	public ActionForward downloadcircularandremainderPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadcircularandremainderPDF  Starting");

		try {

			System.out.println("downloading pdf");

			List<RemainderMasterVO> remainderlist = new TeacherLeaveModuleBD()
					.getRemainderlistBD();
			String sourceFileName = request
					.getRealPath("Reports/circularandRemainderPDFReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);

			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					remainderlist);

			String PropfilePath = getServlet().getServletContext().getRealPath(
					"")
					+ "\\images\\" + ImageName.trim();

			String schName = res.getString("SchoolName");
			String schAddLine1 = res.getString("AddressLine1");

			Map parameters = new HashMap();

			parameters.put("Image", PropfilePath);

			/*
			 * parameters.put("Image", clientImage);
			 * 
			 * parameters.put("ClientName", ClientName);
			 * 
			 * parameters.put("ClientAddress", ClientAddress_l1);
			 */

			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanColDataSource);

			response.setContentType("application/pdf");

			response.setContentLength(bytes.length);

			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "CircularAndRemainderPDFReport - " + ".pdf\"");

			ServletOutputStream outstream = response.getOutputStream();

			outstream.write(bytes, 0, bytes.length);

			outstream.flush();

		}

		catch (Exception e)

		{
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherMenuAction : downloadcircularandremainderPDF  Ending");
		return null;

	}

}
