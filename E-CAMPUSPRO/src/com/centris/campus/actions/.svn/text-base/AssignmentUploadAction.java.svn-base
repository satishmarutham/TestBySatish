package com.centris.campus.actions;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.campus.delegate.AssignmentUploadBD;
import com.centris.campus.forms.AssignmentUploadForm;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.AssignmentUploadVo;

public class AssignmentUploadAction extends DispatchAction {
	
	
private static Logger logger = Logger.getLogger(AssignmentUploadAction.class);
	
	public synchronized ActionForward getStudentDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadAction : getStudentDetails Starting");
		try {
			
			String section=request.getParameter("section");
		
			JSONObject object=new JSONObject();
			object.put("StudentList", new AssignmentUploadBD().getStudentDetails(section));
			
			response.getWriter().print(object);;
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadAction : getStudentDetails Ending");

		return null;
	}
	
	public synchronized ActionForward insertAssignment(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadAction : insertAssignment Starting");
		try {
			
			System.out.println("insert assignment details");
			
			request.setAttribute(MessageConstants.MODULE_NAME,MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,MessageConstants.MODULE_STUDENT);
			
			
			AssignmentUploadForm assignmentForm=(AssignmentUploadForm)form;
			
			System.out.println("student list :: "+assignmentForm.getStudent().length);
			
			String userId=HelperClass.getCurrentUserID(request);
			String accYearString=request.getSession(false).getAttribute("current_academicYear").toString();
			
			
			
			String status=new AssignmentUploadBD().insertAssignment(assignmentForm,userId,accYearString);
			
			if("true".equalsIgnoreCase(status)){
				
				request.setAttribute("message", "Assignment created successfully");
			
			}else{
				
				request.setAttribute("errormessagediv", "Assignment not created successfully,Try later");
			}
			
			request.setAttribute("AssignmentList", new AssignmentUploadBD().getAssignment(userId, accYearString,""));
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadAction : insertAssignment Ending");

		return mapping.findForward(MessageConstants.ASSIGNMENTVIEW);
	}
	
	public synchronized ActionForward editAssignment(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadAction : editAssignment Starting");
		try {
			
			System.out.println("editAssignment  details");
			
			request.setAttribute(MessageConstants.MODULE_NAME,MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,MessageConstants.MODULE_STUDENT);
			
			String assignmentId=request.getParameter("assignmentId");
			
			ArrayList<AssignmentUploadVo> assignmentDetailsList=new AssignmentUploadBD().getAssignmentDetails(assignmentId);
			AssignmentUploadVo assignmentDetailsVo=new AssignmentUploadBD().getSingleAssignment(assignmentId); 
			
			
			request.setAttribute("AssignmentDetailsList", assignmentDetailsList);
			
			request.setAttribute("AssignmentDetailsVo", assignmentDetailsVo);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadAction : editAssignment Ending");

		return mapping.findForward(MessageConstants.UPDATE_ASSIGNMENT);
	}
	
	public synchronized ActionForward updateAssignmentDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadAction : updateAssignmentDetails Starting");
		try {
			
			System.out.println("editAssignment  details");
			
			request.setAttribute(MessageConstants.MODULE_NAME,MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,MessageConstants.MODULE_STUDENT);
			
			String userId=HelperClass.getCurrentUserID(request);
			String accYearString=request.getSession(false).getAttribute("current_academicYear").toString();
			
			String assignmentId=request.getParameter("assignmentId");
			String studentId=request.getParameter("studentIdArray");
			String actualCompletionDate=request.getParameter("actualcompletionArray"); 
			String aquiredmarks=request.getParameter("aquiredmarksArray");
			String remarks=request.getParameter("remarksArray");
			
			
			
			AssignmentUploadVo assignmentVo=new AssignmentUploadVo();
			
			 assignmentVo.setAssignmentId(assignmentId);
			 assignmentVo.setStudentId(studentId);
			 assignmentVo.setActualcompletedDate(actualCompletionDate);
			 assignmentVo.setAcquiredMarks(aquiredmarks);
			 assignmentVo.setRemarks(remarks);
			 assignmentVo.setUserID(userId);
			
			String status=new AssignmentUploadBD().updateAssignmentDetails(assignmentVo);
			
			JSONObject object=new JSONObject();
			object.put("status", status);
			
			
			response.getWriter().print(object);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadAction : updateAssignmentDetails Ending");

		return null;
	}
	
	public synchronized ActionForward deleteAssignment(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadAction : deleteAssignment Starting");
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,MessageConstants.MODULE_STUDENT);
			
			String assignmentCode=request.getParameter("assignmentCode");
			
			
			String status=new AssignmentUploadBD().deleteAssignment(assignmentCode);
			
			JSONObject object=new JSONObject();
			object.put("status", status);
			
			
			response.getWriter().print(object);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadAction : deleteAssignment Ending");

		return null;
	}
	

}
