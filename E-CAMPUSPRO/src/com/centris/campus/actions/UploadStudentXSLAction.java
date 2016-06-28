package com.centris.campus.actions;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.json.JSONArray;

import com.centris.campus.daoImpl.UploadStudentXLSDaoImpl;
import com.centris.campus.delegate.UploadStudentXSLBD;
import com.centris.campus.forms.UploadStudentXSLForm;
import com.centris.campus.pojo.UploadStudentXlsPOJO;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.UploadStudentXSLUtility;
import com.centris.campus.vo.UploadStudentXlsVO;
import com.centris.campus.vo.UserDetailVO;

public class UploadStudentXSLAction extends DispatchAction {

	private static Logger logger = Logger
			.getLogger(UploadStudentXSLAction.class);


	 
	public ActionForward insertStudentXSL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadStudentXSLAction : insertEmpXSL : Starting");
		int notInsertCount = 0;
		int beforeInsert = 0;
		int successInsert = 0;
		String fileName = null;
		try {
			
			
			System.out.println("InsertStudentXSL Action Is Working");

			UploadStudentXLSDaoImpl daoImpl = new UploadStudentXLSDaoImpl();

			int countBeforeInsert = daoImpl.checkEmpCountBeforeInsert();

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String username = userDetailVO.getUserId();

			System.out.println("username:::" +username);

			UploadStudentXSLForm uploadEmpXSLForm = (UploadStudentXSLForm) form;

			FormFile file = uploadEmpXSLForm.getFormFile();

			String filePath = getServlet().getServletContext().getRealPath("/");

			if (file != null) {

				fileName = file.getFileName();

				File fileURL = new File(filePath, fileName);
				request.setAttribute("fileAttribute", fileName);

				Map<String, Object> employeeMap = new UploadStudentXSLUtility().getExcelData(fileURL, file);
				
				

				List<UploadStudentXlsPOJO> alList = (List<UploadStudentXlsPOJO>) employeeMap.get("List");
				
				for (UploadStudentXlsPOJO uploadStudentXlsPOJO : alList) {
					
					System.out.println("name;:::"+uploadStudentXlsPOJO.getStudentFirstName());
					
				}

				beforeInsert = alList.size();
				
				System.out.println("beforeInsert:::"+beforeInsert);

				UploadStudentXSLBD empXSLBD = new UploadStudentXSLBD();

				Set<UploadStudentXlsVO> empXLSList = new HashSet<UploadStudentXlsVO>();
				
				
				String demo = (String) employeeMap.get("Error");
				
				System.out.println("Going To Delegate");

				
				
				empXLSList = empXSLBD.insertEmpXSL(	(List<UploadStudentXlsPOJO>) employeeMap.get("List"),
						username, demo);

				notInsertCount = empXLSList.size();
				
				
				System.out.println("notInsertCount:::"+notInsertCount);
				System.out.println("After Insert::::"+empXLSList.size());
				

				if (empXLSList.size() != 0) {

					request.setAttribute("FailEmployeeList", empXLSList);

					request.setAttribute("FailEmployeeList",
							request.getAttribute("FailEmployeeList"));

					request.setAttribute(
							"errorMessage",
							notInsertCount
									+ " Display Records Are not Uploaded Please Check For Details");
					
			
					
				} else if (demo != null) {
					request.setAttribute("successmessagediv", demo);

				} else {
					successInsert = beforeInsert - notInsertCount;
					request.setAttribute("successmessagediv", +successInsert
							+ ":Student Registered SuccessFully");
					

					
				}

			} else {

				request.setAttribute("FailEmployeeList",
						request.getAttribute("FailEmployeeList"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);

		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadStudentXSLAction : insertEmpXSL : Ending");

		return mapping.findForward(MessageConstants.STUDENT_EXCEL_UPLOAD);

	}

	
	  public ActionForward downloadfileformat(ActionMapping mapping, ActionForm
	  form,HttpServletRequest request, HttpServletResponse response) throws
	  Exception {
	  
	  logger.setLevel(Level.DEBUG); JLogger.log(0, JDate.getTimeString(new
	  Date()) + MessageConstants.START_POINT);
	  logger.info(JDate.getTimeString(new Date()) +
	  " Control in UploadStudentXSLAction : downloadfileformat : Starting");
	  
	  
	  System.out.println("downloadfileformat");
	  
	  
	  try {
	  
	  
	  
	  
	  String filePath = getServlet().getServletContext().getRealPath("") +
	  "\\FIles\\StudentRegistrationFileUpload\\StudentRegistrationFormate.xls"; 
	  
	  System.out.println("FILEPATH:::"+filePath);
	  
	  ServletOutputStream out  = response.getOutputStream(); FileInputStream in = new
	  FileInputStream(filePath); HttpSession ses = request.getSession();
	  response.setContentType("application/vnd.ms-excel");
	  response.addHeader("content-disposition", "attachment; filename=" +
	  "StudentRegistrationFormate.xls");
	  
	  int octet; while ((octet = in.read()) != -1) out.write(octet);
	  
	  in.close(); out.close();
	  
	  } catch (Exception e) { e.printStackTrace(); logger.error(e.getMessage(),
	  e); }
	  
	  
	  JLogger.log(0, JDate.getTimeString(new Date()) +
	  MessageConstants.END_POINT); logger.info(JDate.getTimeString(new Date())
	  + " Control in UploadStudentXSLAction : downloadfileformat : Ending");
	  
	  return null;
	  
	  }
	 

}
