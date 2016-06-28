package com.centris.campus.actions;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import com.centris.campus.delegate.CommunicationSettingsBD;
import com.centris.campus.delegate.TimeTableBD;
import com.centris.campus.pojo.TeacherTimeTablePojo;
import com.centris.campus.pojo.TimeTablePojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.TeacherTimeTableVo;
import com.centris.campus.vo.TimeTableVo;
import com.centris.campus.vo.UpcomingBdayVo;
import com.centris.campus.vo.UpcomingRemarksVO;

public class TimeTableAction extends DispatchAction {
	
	static ResourceBundle res = ResourceBundle
			.getBundle("com/centris/campus/properties/CAMPUS");
	
	private static String ImageName = res.getString("ImageName"); 
	
	private static final Logger logger = Logger
			.getLogger(TimeTableAction.class);

	public ActionForward getTimeTableDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : getTimeTableDetails Starting");
		TimeTableBD obj = new TimeTableBD();
		try {
			
			String TimeTableDetails = request.getParameter("TimeTableDetails").trim();
			
			String[] details=TimeTableDetails.split(",");
		
			System.out.println("list count :: "+obj.getTimeTableDetails(details[0]).size());

			request.setAttribute("timeTableDetails",obj.getTimeTableDetails(details[0]));
			
			request.setAttribute("TimetableID", details[0]);
			request.setAttribute("selected_classid", details[1]);
			request.setAttribute("selected_sectionid", details[2]);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : getTimeTableDetails  Ending");
		return mapping.findForward(MessageConstants.VIEW_TIMETABLE);
	}

	public ActionForward getClassName(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : getClassName Starting");
		TimeTableBD obj = new TimeTableBD();
		try {
			ArrayList<TimeTableVo> details = new ArrayList<TimeTableVo>();
			details = obj.getClassName();

			JSONObject jsonObject = new JSONObject(details);
			jsonObject.accumulate("classList", details);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : getClassName  Ending");
		return null;
	}

	public ActionForward getSectionName(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : getSectionName Starting");
		TimeTableBD obj = new TimeTableBD();
		try {
			String classid = request.getParameter("classIdVal").trim();
			ArrayList<TimeTableVo> details = new ArrayList<TimeTableVo>();
			details = obj.getSectionName(classid);
			JSONObject jsonObject = new JSONObject(details);
			jsonObject.accumulate("sectionList", details);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : getSectionName  Ending");
		return null;
	}

	public ActionForward updateTimeTableDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : updateTimeTableDetails Starting");
		TimeTableBD obj = new TimeTableBD();
		try {

			String user = HelperClass.getCurrentUserID(request);

			TimeTablePojo pojoObj = new TimeTablePojo();
			pojoObj.setUserid(user.trim());
			String accyearid=request.getSession(false).getAttribute("current_academicYear").toString();
			
			pojoObj.setAccyearid(accyearid);
			pojoObj.setClassid(request.getParameter("ClassId"));
			pojoObj.setSectionid(request.getParameter("SectionId"));
			pojoObj.setTimetableID(request.getParameter("timetableID").trim());
			

			pojoObj.setPeriod1(request.getParameter("period1Array").split(","));
			pojoObj.setPeriod2(request.getParameter("period2Array").split(","));
			pojoObj.setPeriod3(request.getParameter("period3Array").split(","));

			pojoObj.setPeriod4(request.getParameter("period4Array").split(","));
			pojoObj.setPeriod5(request.getParameter("period5Array").split(","));
			pojoObj.setPeriod6(request.getParameter("period6Array").split(","));

			pojoObj.setPeriod7(request.getParameter("period7Array").split(","));
			pojoObj.setPeriod8(request.getParameter("period8Array").split(","));
			pojoObj.setDayid(request.getParameter("dayidArray").split(","));

			String result = obj.updateTimeTableDetails(pojoObj);

			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("timetable_Result", result);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : updateTimeTableDetails  Ending");
		return null;
	}

	public ActionForward getTeacherTimeTableDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : getTeacherTimeTableDetails Starting");
		TimeTableBD obj = new TimeTableBD();
		try {
			String accyearid = request.getSession(false).getAttribute("current_academicYear").toString();
			String[] teacherdetails = request.getParameter("TimeTableDetails").trim().split(",");

			request.setAttribute("teacherTimeTableDetails",obj.getTeacherTimeTableDetails(teacherdetails[0], accyearid));
			request.setAttribute("selected_teacherid", teacherdetails[0]);
			request.setAttribute("selected_teacherName", teacherdetails[1]);
			request.setAttribute("selected_accyearid", accyearid);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : getTeacherTimeTableDetails  Ending");
		return mapping.findForward(MessageConstants.VIEW_TEACHER_TIMETABLE);
	}

	public ActionForward getTeacherName(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : getTeacherName Starting");
		TimeTableBD obj = new TimeTableBD();
		try {
			ArrayList<TeacherTimeTableVo> details = new ArrayList<TeacherTimeTableVo>();
			details = obj.getTeacherName();

			JSONObject jsonObject = new JSONObject(details);
			jsonObject.accumulate("teacherList", details);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : getTeacherName  Ending");
		return null;
	}
	
	public ActionForward updateTeacherTimeTableDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : updateTeacherTimeTableDetails Starting");
		TimeTableBD obj = new TimeTableBD();
		try {

			String user = HelperClass.getCurrentUserID(request);

			TeacherTimeTablePojo pojoObj = new TeacherTimeTablePojo();
			
			
			
			pojoObj.setUserid(user.trim());
			pojoObj.setAccyearid(request.getSession(false).getAttribute("current_academicYear").toString());
			pojoObj.setTeacherid(request.getParameter("ClassId").trim());

			pojoObj.setPeriod1(request.getParameter("period1Array").split(","));
			pojoObj.setPeriod2(request.getParameter("period2Array").split(","));
			pojoObj.setPeriod3(request.getParameter("period3Array").split(","));

			pojoObj.setPeriod4(request.getParameter("period4Array").split(","));
			pojoObj.setPeriod5(request.getParameter("period5Array").split(","));
			pojoObj.setPeriod6(request.getParameter("period6Array").split(","));

			pojoObj.setPeriod7(request.getParameter("period7Array").split(","));
			pojoObj.setPeriod8(request.getParameter("period8Array").split(","));
			pojoObj.setDayid(request.getParameter("dayidArray").split(","));

			String result = obj.updateTeacherTimeTableDetails(pojoObj);

			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("timetable_Result", result);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : updateTeacherTimeTableDetails  Ending");
		return null;
	}
	
	public ArrayList<TimeTableVo> getClassSectionList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : getClassSectionList Starting");
		TimeTableBD obj = new TimeTableBD();
		try {
			ArrayList<TimeTableVo> details = new ArrayList<TimeTableVo>();
			details = obj.getClassSectionList();

			JSONObject jsonObject = new JSONObject(details);
			jsonObject.accumulate("ClassSectionList", details);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : getClassSectionList  Ending");
		return null;
	}
	
	
	
	public ArrayList<TimeTableVo> classTimeTableDownloadXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : classTimeTableDownloadXLS Starting");
	
		System.out.println("class time table");
		
		try {
			
			
			

			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/TimeTableXLSReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			
            String viewBy=request.getParameter("viewBy");
			
			String accyearid=request.getSession(false).getAttribute("current_academicYear").toString();
			
			
			ArrayList<TimeTableVo> ClassTimeTableList =  new TimeTableBD().getClassTimeTableList( accyearid,viewBy);
			
		
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					ClassTimeTableList);
			Map parameters = new HashMap();

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/TimeTableXLSReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Role Details Excel Report" };
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
					request.getRealPath("Reports/TimeTableXLSReport.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=TimeTableXLSReport.xls");
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
				+ " Control in TimeTableAction : classTimeTableDownloadXLS  Ending");
		return null;
	}
	
	
	public ArrayList<TimeTableVo> teacherTimeTableDownloadXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : teacherTimeTableDownloadXLS Starting");
		System.out.println("teacher time table");
		
		try {
			
			
			
			


			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/TeacherTimeTableXLSReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			
            String viewBy=request.getParameter("viewBy");
			
			String accyearid=request.getSession(false).getAttribute("current_academicYear").toString();
			
			
			ArrayList<TimeTableVo> TeacherTimeTableList =  new TimeTableBD().getClassTimeTableList( accyearid,viewBy);
			
		
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					TeacherTimeTableList);
			Map parameters = new HashMap();

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/TeacherTimeTableXLSReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Role Details Excel Report" };
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
					request.getRealPath("Reports/TeacherTimeTableXLSReport.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=TeacherTimeTableXLSReport.xls");
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
				+ " Control in TimeTableAction : teacherTimeTableDownloadXLS  Ending");
		return null;
	}
	
	
	
	
	
	public ArrayList<TimeTableVo> classTimeTableDownloadPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : classTimeTableDownloadPDF Starting");
		
		System.out.println("class time table pdf");
	
		try {
			
			 String viewBy=request.getParameter("viewBy");
				
				String accyearid=request.getSession(false).getAttribute("current_academicYear").toString();
				
				
				ArrayList<TimeTableVo> TeacherTimeTableList =  new TimeTableBD().getClassTimeTableList( accyearid,viewBy);
			/*ArrayList<UpcomingBdayVo> bdaylist = new CommunicationSettingsBD()
			.getBdayListDetails();*/

			String sourceFileName = request
					.getRealPath("Reports/classTimaTablePDFReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);

			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					TeacherTimeTableList);

			String PropfilePath = getServlet().getServletContext().getRealPath(
					"")
					+ "\\images\\" + ImageName.trim();

			String schName = res.getString("SchoolName");
			String schAddLine1 = res.getString("AddressLine1");

			Map parameters = new HashMap();
			
			parameters.put("Image", PropfilePath);


			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanColDataSource);

			response.setContentType("application/pdf");

			response.setContentLength(bytes.length);

			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "classTimaTablePDFReport - " + ".pdf\"");

			ServletOutputStream outstream = response.getOutputStream();

			outstream.write(bytes, 0, bytes.length);

			outstream.flush();
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
	

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : classTimeTableDownloadPDF  Ending");
		
		return null;
	}
	
	
	
	

	
	public ArrayList<TimeTableVo> teacherTimeTableDownloadPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : teacherTimeTableDownloadPDF Starting");
		
		System.out.println("teacher time table pdf");
	
		try {
			
			 String viewBy=request.getParameter("viewBy");
				
				String accyearid=request.getSession(false).getAttribute("current_academicYear").toString();
				
				
				ArrayList<TimeTableVo> TeacherTimeTableList =  new TimeTableBD().getClassTimeTableList( accyearid,viewBy);
			/*ArrayList<UpcomingBdayVo> bdaylist = new CommunicationSettingsBD()
			.getBdayListDetails();*/

			String sourceFileName = request
					.getRealPath("Reports/teacherTimaTablePDFReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);

			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					TeacherTimeTableList);

			String PropfilePath = getServlet().getServletContext().getRealPath(
					"")
					+ "\\images\\" + ImageName.trim();

			String schName = res.getString("SchoolName");
			String schAddLine1 = res.getString("AddressLine1");

			Map parameters = new HashMap();
			
			parameters.put("Image", PropfilePath);


			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanColDataSource);

			response.setContentType("application/pdf");

			response.setContentLength(bytes.length);

			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "teacherTimaTablePDFReport - " + ".pdf\"");

			ServletOutputStream outstream = response.getOutputStream();

			outstream.write(bytes, 0, bytes.length);

			outstream.flush();
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableAction : teacherTimeTableDownloadPDF  Ending");
		
		return null;
	}
	
	
	
	
	
	
	
	
}