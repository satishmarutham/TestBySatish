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
import org.json.JSONObject;
import com.centris.campus.delegate.StudentAttendanceBD;
import com.centris.campus.pojo.StreamDetailsPojo;
import com.centris.campus.pojo.StudentAttendancePojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.StudentAttendanceVo;

public class StudentAttendanceAction extends DispatchAction {

	private static final Logger logger = Logger.getLogger(StudentAttendanceAction.class);
	static ResourceBundle res = ResourceBundle
			.getBundle("com/centris/campus/properties/CAMPUS");
	private static String ImageName = res.getString("ImageName");
	
	public ActionForward studentattendaceUploadEntry(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentAttendanceAction : studentattendaceUpload Starting");
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentAttendanceAction : studentattendaceUpload Ending");
	
		
		return mapping.findForward(MessageConstants.GET_STU_ATT_ENTRY);
	}
	
	public ActionForward getStudentAttendanceDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentAttendanceAction : getStudentAttendanceDetails Starting");
		
		String classId=request.getParameter("classId");
		String section=request.getParameter("section");
		String date=request.getParameter("date");
		
		StudentAttendancePojo studentPojo=new StudentAttendancePojo();
		studentPojo.setClassId(classId);
		studentPojo.setSectinId(section);
		studentPojo.setDate(date);
		
		ArrayList<StudentAttendanceVo> studentAttendanceList=new StudentAttendanceBD().getStudentAttendanceDetails(studentPojo);
		
		request.setAttribute("attendanceList", studentAttendanceList);
		
		request.setAttribute("classId", classId);
		request.setAttribute("section", section);
		request.setAttribute("date", date);
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentAttendanceAction : getStudentAttendanceDetails Ending");
	
		
		return mapping.findForward(MessageConstants.GET_STU_ATT_ENTRY);
	}
	
	public ActionForward updateAttendanceStatus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentAttendanceAction : updateAttendanceStatus Starting");
		
		String date = request.getParameter("date");
		String teacherId=request.getParameter("teacherIdArray");
		String attendanceStatus=request.getParameter("statusArray");
		
		StudentAttendancePojo attendancepojo=new StudentAttendancePojo();
		
		attendancepojo.setDate(date);
		attendancepojo.setStudentid(teacherId);
		attendancepojo.setStatus(attendanceStatus);
		attendancepojo.setUserId(HelperClass.getCurrentUserID(request));
		
		String status=new StudentAttendanceBD().updateAttendanceStatus(attendancepojo);
		
		JSONObject object=new JSONObject();
		object.put("status", status);
		
		response.getWriter().print(object);
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentAttendanceAction : updateAttendanceStatus Ending");
	
		
		return null;
	}
	
	public ActionForward getStudentPeriodAttendance(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentAttendanceAction : getStudentPeriodAttendance Starting");
		
		String stuId = request.getParameter("stuId");
		String classId=request.getParameter("classId");
		String sectionId=request.getParameter("section");
		String date=request.getParameter("date");
		String status=request.getParameter("status");
		
		System.out.println("stuId :: "+stuId);
		System.out.println("classId :: "+classId);
		System.out.println("sectionId :: "+sectionId);
		System.out.println("date :: "+date);
		System.out.println("status :: "+status);
		
		
		
		StudentAttendancePojo attendancepojo=new StudentAttendancePojo();
		
		attendancepojo.setDate(date);
		attendancepojo.setStudentid(stuId.split(",")[0]);
		attendancepojo.setStudentname(stuId.split(",")[1]);
		attendancepojo.setStatus(status);
		attendancepojo.setUserId(HelperClass.getCurrentUserID(request));
		attendancepojo.setClassId(classId.split(",")[0]);
		attendancepojo.setClassname(classId.split(",")[1]);
		attendancepojo.setSectinId(sectionId.split(",")[0]);
		attendancepojo.setSectionname(sectionId.split(",")[1]);
		
		StudentAttendanceVo stuAttVo=new StudentAttendanceBD().getStudentPeriodAttendance(attendancepojo);
		
		request.setAttribute("stuAttVo", stuAttVo);
		request.setAttribute("attendancepojo", attendancepojo);
	
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentAttendanceAction : getStudentPeriodAttendance Ending");
	
		
		return mapping.findForward(MessageConstants.GET_STU_PERIOD_ATT);
	}
	
	public ActionForward updateStudentPeriodAtt(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentAttendanceAction : updateStudentPeriodAtt Starting");
		
		String stuId = request.getParameter("studentId");
		String classId=request.getParameter("classsId");
		String sectionId=request.getParameter("sectionId");
		String date=request.getParameter("date");
		
		
		StudentAttendancePojo attendancepojo=new StudentAttendancePojo();
		
		attendancepojo.setDate(date);
		attendancepojo.setStudentid(stuId);
		attendancepojo.setUserId(HelperClass.getCurrentUserID(request));
		attendancepojo.setClassId(classId);
		attendancepojo.setSectinId(sectionId);
		attendancepojo.setPeriod1(request.getParameter("period1"));
		attendancepojo.setPeriod2(request.getParameter("period2"));
		attendancepojo.setPeriod3(request.getParameter("period3"));
		attendancepojo.setPeriod4(request.getParameter("period4"));
		attendancepojo.setPeriod5(request.getParameter("period5"));
		attendancepojo.setPeriod6(request.getParameter("period6"));
		attendancepojo.setPeriod7(request.getParameter("period7"));
		attendancepojo.setPeriod8(request.getParameter("period8"));
		
		String status=new StudentAttendanceBD().updateStudentPeriodAtt(attendancepojo);
		
		JSONObject object=new JSONObject();
		object.put("status", status);
	
		response.getWriter().print(object);
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentAttendanceAction : updateStudentPeriodAtt Ending");
	
		
		return null;
	}
	
	public ActionForward downloadStudentAttendanceDetailsXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentAttendanceAction : downloadStudentAttendanceDetailsXLS  Starting");
		
		try {
		
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/Studentattendancexls.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			
			String startdate=request.getParameter("startDate");
			String endDate=request.getParameter("endDate");
			
			ArrayList<StudentAttendanceVo> studentAttendance=new StudentAttendanceBD().getStudentsAttendanceList(startdate, endDate);
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					studentAttendance);
			Map parameters = new HashMap();
			
			
			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/Studentattendancexls.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Student Attendance Excel Report" };
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
					request.getRealPath("Reports/Studentattendancexls.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=Studentattendancexls.xls");
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
				+ " Control in StudentAttendanceAction : downloadStudentAttendanceDetailsXLS   Ending");
				return null;
		
		
	}
	
	public ActionForward downloadStudentAttendanceDetailsPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in StudentAttendanceAction : downloadStudentAttendanceDetailsXLS  Starting");

			try {

				System.out.println("downloading pdf");


				String startdate=request.getParameter("startDate");
				String endDate=request.getParameter("endDate");
				
				ArrayList<StudentAttendanceVo> studentAttendance=new StudentAttendanceBD().getStudentsAttendanceList(startdate, endDate);
				
				
				String sourceFileName = request
						.getRealPath("Reports/studentattendancedetailsPDF.jrxml");
				JasperDesign design = JRXmlLoader.load(sourceFileName);

				JasperReport jasperreport = JasperCompileManager
						.compileReport(design);

				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						studentAttendance);

				String PropfilePath = getServlet().getServletContext().getRealPath(
						"")
						+ "\\images\\" + ImageName.trim();

				String schName = res.getString("SchoolName");
				String schAddLine1 = res.getString("AddressLine1");

				Map parameters = new HashMap();
				
				parameters.put("Image", PropfilePath);


				/*parameters.put("Image", clientImage);

				parameters.put("ClientName", ClientName);

				parameters.put("ClientAddress", ClientAddress_l1);*/

				byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
						parameters, beanColDataSource);

				response.setContentType("application/pdf");

				response.setContentLength(bytes.length);

				response.setHeader("Content-Disposition", "outline; filename=\""
						+ "StudentAttendanceDetailsPDF - " + ".pdf\"");

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
					+ " Control in StudentAttendanceAction : downloadStudentAttendanceDetailsXLS  Ending");
			return null;

		}

	
	
}
