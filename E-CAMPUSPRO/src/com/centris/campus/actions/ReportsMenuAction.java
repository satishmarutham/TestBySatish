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

import com.centris.campus.daoImpl.JDBCConnection;
import com.centris.campus.delegate.ExamDetailsBD;
import com.centris.campus.delegate.FeeCollectionSummaryReportBD;
import com.centris.campus.delegate.ReportsMenuBD;
import com.centris.campus.delegate.StudentAttendanceBD;
import com.centris.campus.delegate.TermMasterDelegate;
import com.centris.campus.forms.FeeCollectionSummaryReportForm;
import com.centris.campus.forms.ReportMenuForm;
import com.centris.campus.pojo.ExamDetailsPojo;
import com.centris.campus.pojo.FeeStatusReportPojo;
import com.centris.campus.pojo.MarksPOJO;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.ExaminationDetailsVo;
import com.centris.campus.vo.FeeReportDetailsVo;
import com.centris.campus.vo.MarksUploadVO;
import com.centris.campus.vo.ParentVO;
import com.centris.campus.vo.ReportMenuVo;
import com.centris.campus.vo.StudentInfoVO;
import com.centris.campus.vo.TermMasterVo;

public class ReportsMenuAction extends DispatchAction {
	
	static ResourceBundle res = ResourceBundle
			.getBundle("com/centris/campus/properties/CAMPUS");
	private static String ImageName = res.getString("ImageName");
	
	private static final Logger logger = Logger.getLogger(AdminMenuAction.class);
	
	public ActionForward studentDetailsReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : studentDetailsReport Starting");
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_REPORTS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_REPORTS);
			
			ArrayList<ReportMenuVo> accYearList=new ReportsMenuBD().getAccYears();
			
			ArrayList<ReportMenuVo> streamList=new ReportsMenuBD().getStream();
			
			request.setAttribute("AccYearList", accYearList);
			
			System.out.println("streamList ::: "+streamList.size());
			
			request.setAttribute("StreamList", streamList);
			
			
	

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : studentDetailsReport Ending");

		return mapping.findForward(MessageConstants.STUDENT_INFORMATION_REPORT);
	}
	
	
	public ActionForward getClassesByStream(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : getClassesByStream Starting");
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_REPORTS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_REPORTS);
			
			String streamId=request.getParameter("streamId");
			
			ArrayList<ReportMenuVo> classesList=new ReportsMenuBD().getClassesByStream(streamId);
			
			JSONObject object=new JSONObject();
			object.put("ClassesList", classesList);
			
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : getClassesByStream Ending");

		return null;
	}
	
	public ActionForward getSectionByClass(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : getSectionByClass Starting");
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_REPORTS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_REPORTS);
			
			String classId=request.getParameter("classId");
			
			ArrayList<ReportMenuVo> classesList=new ReportsMenuBD().getSectionsByClass(classId);
			
			JSONObject object=new JSONObject();
			object.put("SectionList", classesList);
			
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : getSectionByClass Ending");

		return null;
	}
	
	public ActionForward getStudentDetailsReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : getStudentDetailsReport Starting");
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_REPORTS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_REPORTS);
			
			ReportMenuForm reform=(ReportMenuForm)form;
			
			
			ArrayList<ReportMenuVo> accYearList=new ReportsMenuBD().getAccYears();
			
			ArrayList<ReportMenuVo> streamList=new ReportsMenuBD().getStream();
			
			request.setAttribute("AccYearList", accYearList);
			
			request.setAttribute("StreamList", streamList);
			
			ArrayList<StudentInfoVO> studentInfoList=new ReportsMenuBD().getStudentDetailsReport(reform);
			
			ReportMenuVo selectedItems=new ReportsMenuBD().getSelectedItems(reform);
			
			request.setAttribute("StudentInfoList", studentInfoList);
			request.setAttribute("CurrentForm", selectedItems);
			

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : getStudentDetailsReport Ending");

		return mapping.findForward(MessageConstants.STUDENT_INFORMATION_REPORT);
	}
	
	public ActionForward studentDetailsPDFReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : certificateReport Starting");

		String accYear=request.getParameter("AccId");
		String stream=request.getParameter("Stream");
		String classId=request.getParameter("Class");
		String section=request.getParameter("Section");



		try {

			String PropfilePath = getServlet().getServletContext().getRealPath(
					"")
					+ "\\images\\" + ImageName.trim();

			String schName = res.getString("SchoolName");
			String schAddLine1 = res.getString("AddressLine1");

			Map mapdata = new HashMap();

			mapdata.put("Image", PropfilePath);
			mapdata.put("accYear", accYear);
			mapdata.put("stream", stream);
			mapdata.put("classId", classId);
			mapdata.put("section", section);
			
			String filepath = request.getRealPath("Reports/StudentDetailsPDFReport.jrxml");
  
			JasperDesign design = JRXmlLoader.load(filepath);
			JasperReport jasperreport = JasperCompileManager.compileReport(design);
			
			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,mapdata, JDBCConnection.getConnection());
		
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "StudentDetails" + ".pdf\"");

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
				+ " Control in ReportsAction : certificateReport Ending");

		return null;

	}
	
	public ActionForward studentDetailsExcelReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : studentAttendanceReportDisplay Starting");
		
		
		
		String accYear=request.getParameter("AccId");
		String streamId=request.getParameter("Stream");
		String classId=request.getParameter("Class");
		String section=request.getParameter("Section");
		
		System.out.println("accYear "+accYear);
		System.out.println("streamId "+streamId);
		System.out.println("classId "+classId);
		System.out.println("section "+section);
		
		
		
		
		String filePath = null;

		try {
			
			Map mapdata = new HashMap();

			mapdata.put("accYear", accYear);
			mapdata.put("stream", streamId);
			mapdata.put("classId", classId);
			mapdata.put("section", section);
	
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;


			String sourceFileName = request.getRealPath("Reports/StudentDetailsExcelReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager.compileReport(design);
			
			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,mapdata, JDBCConnection.getConnection());
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/StudentDetails.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Student Details" };
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

			pdfxls = new File(request.getRealPath("Reports/StudentDetails.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=StudentDetails.xls");
			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}
			stream.close();

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : getNonBoardSalaryNonAccountReportExcel Ending");

		return null;
	}

	
	public ActionForward studentFeeStatusReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : studentFeeStatusReport Starting");
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_REPORTS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_REPORTS);
			
			ArrayList<ReportMenuVo> accYearList=new ReportsMenuBD().getAccYears();
			
			ArrayList<ReportMenuVo> classList=new ReportsMenuBD().getClassesByStream("%%");
			
			TermMasterVo vo = new TermMasterVo();
		
			ArrayList<TermMasterVo> termlist = new TermMasterDelegate().termList(vo);
			
			request.setAttribute("TermList", termlist);
			
			request.setAttribute("AccYearList", accYearList);
			
			request.setAttribute("classList", classList);
			
			
	

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : studentFeeStatusReport Ending");

		return mapping.findForward(MessageConstants.STUDENT_FEE_STATUS_REPORT);
	}
	
	
	public ActionForward getStdFeeStatusReportDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : getStdFeeStatusReportDetails Starting");
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_REPORTS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_REPORTS);
			
			
			ReportMenuForm reportForm=(ReportMenuForm)form;
			
			System.out.println("accyear :: "+reportForm.getAccyear()+" -- "+reportForm.getHaccyear());
			System.out.println("class :: "+reportForm.getClassname()+" -- "+reportForm.getHclass());
			System.out.println("section :: "+reportForm.getSection()+" -- "+reportForm.getHsection());
			System.out.println("Term :: "+reportForm.getTerm()+" -- "+reportForm.getHterm());
			System.out.println("Status :: "+reportForm.getStatus());
			
			request.setAttribute("reportForm", reportForm);
			
			HashMap<String, ArrayList<FeeReportDetailsVo>> feeStatusReport=new ReportsMenuBD().getStdFeeStatusReportDetails(reportForm);
			
			request.setAttribute("feeStatusReport", feeStatusReport);
			
			ArrayList<ReportMenuVo> accYearList=new ReportsMenuBD().getAccYears();
			
			ArrayList<ReportMenuVo> classList=new ReportsMenuBD().getClassesByStream("%%");
			
			TermMasterVo vo = new TermMasterVo();
		
			ArrayList<TermMasterVo> termlist = new TermMasterDelegate().termList(vo);
			
			request.setAttribute("TermList", termlist);
			
			request.setAttribute("AccYearList", accYearList);
			
			request.setAttribute("classList", classList);
			
			

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : getStdFeeStatusReportDetails Ending");

		return mapping.findForward(MessageConstants.STUDENT_FEE_STATUS_REPORT);
	}
	
	
	public ActionForward feeStatusExcelReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionSummaryReportAction : feeStatusPdfReport Starting");
		
		String accYear=request.getParameter("AccId");
		String Classid=request.getParameter("ClassId");
		String SectionId=request.getParameter("SectionId");
		String TermId=request.getParameter("TermId");
		String TermName=request.getParameter("TermName");
		String Status=request.getParameter("Status");
		
		System.out.println("TermName :: "+TermName);
		System.out.println("Classid :: "+Classid);
		System.out.println("accYear :: "+accYear);
		System.out.println("SectionId :: "+SectionId);
		System.out.println("TermId :: "+TermId);
		System.out.println("Status :: "+Status);
		
		String filePath = null;

		try {
			
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;
			
			FeeStatusReportPojo feeStatusPojo=new FeeStatusReportPojo();
			
			feeStatusPojo.setAccyear(accYear);
			feeStatusPojo.setClassname(Classid);
			feeStatusPojo.setSection(SectionId);
			feeStatusPojo.setTerm(TermId);
			feeStatusPojo.setStatus(Status);
			
			  ArrayList<FeeReportDetailsVo> feeStatusList=new ReportsMenuBD().getStdFeeStatusReportDownload(feeStatusPojo);
			
			String sourceFileName = request
					.getRealPath("Reports/StudentFeeStatusReportExcel.jrxml");

			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("termName", TermName);
			stream = response.getOutputStream();

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(feeStatusList);

			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/TransportDetailsReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			JasperPrint print = JasperFillManager.fillReport(
					jasperreport, parameters, beanColDataSource);
			String[] sheetNames = { TermName
					+ " Class FeeSummary  Report" };
			exporter.setParameter(JRExporterParameter.JASPER_PRINT,
					print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
					fos);
			exporter.setParameter(
					JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
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
			exporter.setParameter(
					JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
					Boolean.TRUE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
					Boolean.FALSE);

			exporter.exportReport();

			pdfxls = new File(
					request.getRealPath("Reports/TransportDetailsReport.xls"));

			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=Class Fee Summary Report.xls");
			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionSummaryReportAction : feeStatusPdfReport Ending");

		return null;
	}
	
	public ActionForward feeStatusPdfReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : feeStatusExcelReport Starting");

		String accYear=request.getParameter("AccId");
		String Classid=request.getParameter("ClassId");
		String SectionId=request.getParameter("SectionId");
		String TermId=request.getParameter("TermId");
		String TermName=request.getParameter("TermName");
		String Status=request.getParameter("Status");


		try {

			String PropfilePath = getServlet().getServletContext().getRealPath(
					"")
					+ "\\images\\" + ImageName.trim();

			String schName = res.getString("SchoolName");
			String schAddLine1 = res.getString("AddressLine1");

			Map mapdata = new HashMap();

			mapdata.put("Image", PropfilePath);
			mapdata.put("termName", TermName);
			
			FeeStatusReportPojo feeStatusPojo=new FeeStatusReportPojo();
			
			feeStatusPojo.setAccyear(accYear);
			feeStatusPojo.setClassname(Classid);
			feeStatusPojo.setSection(SectionId);
			feeStatusPojo.setTerm(TermId);
			feeStatusPojo.setStatus(Status);
			
			  ArrayList<FeeReportDetailsVo> feeStatusList=new ReportsMenuBD().getStdFeeStatusReportDownload(feeStatusPojo);
			
			String sourceFileName = request.getRealPath("Reports/StudentFeeStatusReportPdf.jrxml");
			
			JasperDesign design = JRXmlLoader.load(sourceFileName);

			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(feeStatusList);


			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport, mapdata, beanColDataSource);

			response.setContentType("application/pdf");

			response.setContentLength(bytes.length);

			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "FeeCollectionDetailsPDF - " + ".pdf\"");

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
				+ " Control in ReportsAction : feeStatusExcelReport Ending");

		return null;

	}
	
	
	public ActionForward marksDetailsReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : marksDetailsReport Starting");
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_REPORTS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_REPORTS);
			
			ArrayList<ReportMenuVo> accYearList=new ReportsMenuBD().getAccYears();
			
			ArrayList<ReportMenuVo> classList=new ReportsMenuBD().getClassesByStream("%%");
			
			List<ExaminationDetailsVo> examlist=new ExamDetailsBD().getexamdeligate();
			
			request.setAttribute("examlist", examlist);
			request.setAttribute("AccYearList", accYearList);
			request.setAttribute("classList", classList);
			
			
	

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : marksDetailsReport Ending");

		return mapping.findForward(MessageConstants.STUDENT_MARKS_DETAILS);
	}
	
	public ActionForward getStudentBySection(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : getStudentBySection Starting");
		try {
			
			String classId=request.getParameter("classId");
			String sectionId=request.getParameter("sectionId");
			List<ParentVO> studentList=new StudentAttendanceBD().getAllStudent(classId, sectionId);
			
			JSONObject object=new JSONObject();
			object.put("studentList", studentList);
			
			response.getWriter().print(object);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : getStudentBySection Ending");

		return null;
	}
	
	
	public ActionForward getStdMarksDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : getStdMarksDetails Starting");
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_REPORTS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_REPORTS);
			
			
			ReportMenuForm reportForm=(ReportMenuForm)form;
			
			System.out.println("accyear :: "+reportForm.getAccyear()+" -- "+reportForm.getHaccyear());
			System.out.println("class :: "+reportForm.getClassname()+" -- "+reportForm.getHclass());
			System.out.println("section :: "+reportForm.getSection()+" -- "+reportForm.getHsection());
			System.out.println("student :: "+reportForm.getStudentId()+" -- "+reportForm.getStudentnamelabel());
			System.out.println("Exam :: "+reportForm.getExam()+" --- "+reportForm.getHexam());
			
			request.setAttribute("reportForm", reportForm);
			
			HashMap<String, ArrayList<MarksUploadVO>> marksDetailsReport=new ReportsMenuBD().getStdMarksDetails(reportForm);
			
			request.setAttribute("marksDetailsReport", marksDetailsReport);
			
			ArrayList<ReportMenuVo> accYearList=new ReportsMenuBD().getAccYears();
			
			ArrayList<ReportMenuVo> classList=new ReportsMenuBD().getClassesByStream("%%");
			
			List<ExaminationDetailsVo> examlist=new ExamDetailsBD().getexamdeligate();
			
			request.setAttribute("examlist", examlist);
			request.setAttribute("AccYearList", accYearList);
			request.setAttribute("classList", classList);
			
			

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : getStdMarksDetails Ending");

		return mapping.findForward(MessageConstants.STUDENT_MARKS_DETAILS);
	}
	
	public ActionForward studentMarksExcelReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionSummaryReportAction : feeStatusPdfReport Starting");
		
		String accYear=request.getParameter("AccId");
		String Classid=request.getParameter("ClassId");
		String SectionId=request.getParameter("SectionId");
		String Exam=request.getParameter("Exam");
		String Student=request.getParameter("Student");
		
		System.out.println("Exam :: "+Exam);
		System.out.println("Classid :: "+Classid);
		System.out.println("accYear :: "+accYear);
		System.out.println("SectionId :: "+SectionId);
		System.out.println("Student :: "+Student);
		
		String filePath = null;

		try {
			
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;
			
			MarksPOJO markspojo=new MarksPOJO();
			
			markspojo.setAccyear(accYear);
			markspojo.setClassid(Classid);
			markspojo.setSection(SectionId);
			markspojo.setStudentid(Student);
			markspojo.setExamid(Exam);
			
			  ArrayList<MarksUploadVO> marksList=new ReportsMenuBD().getStdMarksDetailsDownload(markspojo);
			
			String sourceFileName = request
					.getRealPath("Reports/StudentMarksExcel.jrxml");

			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			Map<String, Object> parameters = new HashMap<String, Object>();
			stream = response.getOutputStream();

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(marksList);

			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/StudentMarksReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			JasperPrint print = JasperFillManager.fillReport(
					jasperreport, parameters, beanColDataSource);
			String[] sheetNames = { "Student Marks Report" };
			exporter.setParameter(JRExporterParameter.JASPER_PRINT,
					print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
					fos);
			exporter.setParameter(
					JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
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
			exporter.setParameter(
					JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
					Boolean.TRUE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
					Boolean.FALSE);

			exporter.exportReport();

			pdfxls = new File(
					request.getRealPath("Reports/StudentMarksReport.xls"));

			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=Student Marks Report.xls");
			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionSummaryReportAction : feeStatusPdfReport Ending");

		return null;
	}
	
	public ActionForward studentMarksPdfReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : feeStatusExcelReport Starting");

		String accYear=request.getParameter("AccId");
		String Classid=request.getParameter("ClassId");
		String SectionId=request.getParameter("SectionId");
		String Exam=request.getParameter("Exam");
		String Student=request.getParameter("Student");


		try {

			String PropfilePath = getServlet().getServletContext().getRealPath(
					"")
					+ "\\images\\" + ImageName.trim();

			String schName = res.getString("SchoolName");
			String schAddLine1 = res.getString("AddressLine1");

			Map mapdata = new HashMap();

			mapdata.put("Image", PropfilePath);
			MarksPOJO markspojo=new MarksPOJO();
			
			markspojo.setAccyear(accYear);
			markspojo.setClassid(Classid);
			markspojo.setSection(SectionId);
			markspojo.setStudentid(Student);
			markspojo.setExamid(Exam);
			
			  ArrayList<MarksUploadVO> marksList=new ReportsMenuBD().getStdMarksDetailsDownload(markspojo);
			String sourceFileName = request.getRealPath("Reports/StudentMarksPdf.jrxml");
			
			JasperDesign design = JRXmlLoader.load(sourceFileName);

			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(marksList);


			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport, mapdata, beanColDataSource);

			response.setContentType("application/pdf");

			response.setContentLength(bytes.length);

			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "StudentMarksDetails - " + ".pdf\"");

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
				+ " Control in ReportsAction : feeStatusExcelReport Ending");

		return null;

	}
	
	public ActionForward studentMarksGraph(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : studentMarksGraph Starting");

		String accYear=request.getParameter("AccId");
		String Classid=request.getParameter("ClassId");
		String SectionId=request.getParameter("SectionId");
		String Exam=request.getParameter("Exam");
		String Student=request.getParameter("Student");


		try {

		
			MarksPOJO markspojo=new MarksPOJO();
			
			markspojo.setAccyear(accYear);
			markspojo.setClassid(Classid);
			markspojo.setSection(SectionId);
			markspojo.setStudentid(Student);
			markspojo.setExamid(Exam);
			
			  ArrayList<MarksUploadVO> marksList=new ReportsMenuBD().getStdMarksDetailsDownload(markspojo);
			  
			  
			
			  JSONObject object=new JSONObject();
			  object.put("MARKSDETAILS", marksList);
			  
			  response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : studentMarksGraph Ending");

		return null;

	}
	
	public ActionForward examReportClassWise(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : examReportClassWise Starting");
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_REPORTS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_REPORTS);
			
			ArrayList<ReportMenuVo> accYearList=new ReportsMenuBD().getAccYears();
			
			ArrayList<ReportMenuVo> classList=new ReportsMenuBD().getClassesByStream("%%");
			
			request.setAttribute("AccYearList", accYearList);
			request.setAttribute("classList", classList);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : examReportClassWise Ending");

		return mapping.findForward(MessageConstants.EXAM_CLASSWISE_REPORT);
	}
	
	
	public ActionForward examReportClassWiseDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : examReportClassWiseDetails Starting");
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_REPORTS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_REPORTS);
			
			
			ReportMenuForm reportForm=(ReportMenuForm)form;
			
			
			request.setAttribute("reportForm", reportForm);
			
			ArrayList<ExaminationDetailsVo> examDetailsReport=new ReportsMenuBD().examReportClassWiseDetails(reportForm);
			
			request.setAttribute("examDetailsReport", examDetailsReport);
			
			ArrayList<ReportMenuVo> accYearList=new ReportsMenuBD().getAccYears();
			
			ArrayList<ReportMenuVo> classList=new ReportsMenuBD().getClassesByStream("%%");
			
			request.setAttribute("AccYearList", accYearList);
			request.setAttribute("classList", classList);
			
			

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuAction : examReportClassWiseDetails Ending");

		return mapping.findForward(MessageConstants.EXAM_CLASSWISE_REPORT);
	}
	
	public ActionForward classWiseExamExcelReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionSummaryReportAction : classWiseExamExcelReport Starting");
		
		String accYear=request.getParameter("AccId");
		String Classid=request.getParameter("ClassId");
		String ClassName=request.getParameter("ClassName");
		
		System.out.println("Classid :: "+Classid);
		System.out.println("accYear :: "+accYear);
		System.out.println("ClassName :: "+ClassName);
		
		String filePath = null;

		try {
			
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;
			
			ReportMenuForm rform=new ReportMenuForm();
			rform.setAccyear(accYear);
			rform.setClassname(Classid);
			
			
			ArrayList<ExaminationDetailsVo> examDetailsReport=new ReportsMenuBD().examReportClassWiseDetails(rform);
			
			String sourceFileName = request
					.getRealPath("Reports/ClassWiseExamExcelReport.jrxml");

			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("ClassName", ClassName);
			stream = response.getOutputStream();

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(examDetailsReport);

			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/ClassWiseExamExcelReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			JasperPrint print = JasperFillManager.fillReport(
					jasperreport, parameters, beanColDataSource);
			String[] sheetNames = { "Class Wise Exam Report" };
			exporter.setParameter(JRExporterParameter.JASPER_PRINT,
					print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
					fos);
			exporter.setParameter(
					JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
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
			exporter.setParameter(
					JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
					Boolean.TRUE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
					Boolean.FALSE);

			exporter.exportReport();

			pdfxls = new File(
					request.getRealPath("Reports/ClassWiseExamExcelReport.xls"));

			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=Student Marks Report.xls");
			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionSummaryReportAction : classWiseExamExcelReport Ending");

		return null;
	}
	
	public ActionForward classWiseExamPdfReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : feeStatusExcelReport Starting");

		String accYear=request.getParameter("AccId");
		String Classid=request.getParameter("ClassId");
		String ClassName=request.getParameter("ClassName");
		
		System.out.println("Classid :: "+Classid);
		System.out.println("accYear :: "+accYear);
		System.out.println("ClassName :: "+ClassName);


		try {

			String PropfilePath = getServlet().getServletContext().getRealPath(
					"")
					+ "\\images\\" + ImageName.trim();

			String schName = res.getString("SchoolName");
			String schAddLine1 = res.getString("AddressLine1");

			Map mapdata = new HashMap();

			mapdata.put("Image", PropfilePath);
			mapdata.put("ClassName", ClassName);
			
			ReportMenuForm rform=new ReportMenuForm();
			rform.setAccyear(accYear);
			rform.setClassname(Classid);
			
			
			ArrayList<ExaminationDetailsVo> examDetailsReport=new ReportsMenuBD().examReportClassWiseDetails(rform);
			String sourceFileName = request.getRealPath("Reports/ClassWiseExamPdfReport.jrxml");
			
			JasperDesign design = JRXmlLoader.load(sourceFileName);

			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(examDetailsReport);


			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport, mapdata, beanColDataSource);

			response.setContentType("application/pdf");

			response.setContentLength(bytes.length);

			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "ClassExamDetails - " + ".pdf\"");

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
				+ " Control in ReportsAction : feeStatusExcelReport Ending");

		return null;

	}
	
	

}
