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

import com.centris.campus.delegate.CreateExaminationBD;
import com.centris.campus.delegate.ExamDetailsBD;
import com.centris.campus.forms.CreateExaminationForm;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.ExaminationDetailsVo;

public class ExamDetailsAction extends DispatchAction {

	private static final Logger logger = Logger
			.getLogger(StreamDetailsAction.class);

	static ResourceBundle res = ResourceBundle
			.getBundle("com/centris/campus/properties/CAMPUS");
	private static String ImageName = res.getString("ImageName");

	public ActionForward createExamAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : createExamAction Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_EXAM);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_EXAM);

			CreateExaminationForm examform = new CreateExaminationForm();

			String createUser = HelperClass.getCurrentUser(request);

			String examid = request.getParameter("examid").trim();
			String eamName = request.getParameter("examname");
			String examdate = request.getParameter("examdate");
			String endDate = request.getParameter("enddate");
			String accadamicyear = request.getParameter("accadamicyear");
			String description = request.getParameter("description");

			examform.setExamId(examid);
			examform.setExamname(eamName);
			examform.setExamdate(examdate);
			examform.setEnddate(endDate);
			examform.setAccyear(accadamicyear);
			examform.setDescription(description);
			examform.setCreateUser(createUser);

			String result = new CreateExaminationBD()
					.createExamination(examform);

			JSONObject jsonobj = new JSONObject();

			jsonobj.put("jsonResponse", result);

			response.getWriter().print(jsonobj);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction :createExamAction Ending");

		return null;
	}

	public ActionForward editExamAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : editExam Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_EXAM);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_EXAM);

			String examid = request.getParameter("examid");

			ExaminationDetailsVo examvo = new ExaminationDetailsVo();

			examvo.setExamid(examid);

			ExaminationDetailsVo result = new CreateExaminationBD()
					.editExamination(examvo);

			CreateExaminationForm examform = new CreateExaminationForm();
			List<Object> examnameslist = null;
			String accyear = examform.getAccyear();

			examnameslist = new CreateExaminationBD().getAllExamNames(examform);

			Map<String, String> map = (Map<String, String>) new CreateExaminationBD()
					.getAccadamicYearsBD();

			request.setAttribute("ALLACCYEARS", map);
			request.setAttribute("examlist", result);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : editExam Ending");

		return mapping.findForward(MessageConstants.EXAM_CREATION);

	}

	public ActionForward getExam(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getExam Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_EXAM);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_EXAM);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getExam Ending");

		return mapping.findForward(MessageConstants.EXAM_CREATION);

	}

	public ActionForward deleteExamAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : deleteExam Starting");

		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_EXAM);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_EXAM);

			String examid = request.getParameter("examid");

			ExaminationDetailsVo examvo = new ExaminationDetailsVo();

			examvo.setExamid(examid);

			String check = new CreateExaminationBD().deleteExamination(examvo);

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
				+ " Control in AdminMenuAction : deleteExam Ending");

		return null;

	}

	public ActionForward searchexamdetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : searchExam Starting");

		try {

			String SearchName = request.getParameter("searchname");

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_EXAM);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_EXAM);

			ArrayList<ExaminationDetailsVo> examlist = new CreateExaminationBD()
					.searchExamination(SearchName);

			request.setAttribute("examDetailsList", examlist);
			request.setAttribute("searchname", SearchName);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : searchExam Ending");

		return mapping.findForward(MessageConstants.EXAM_LIST);

	}

	public ActionForward validateExamName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : validateExam Starting");

		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_EXAM);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_EXAM);

			String examid = request.getParameter("examid");
			String examname = request.getParameter("examname");
			String accyear = request.getParameter("accyear");

			ExaminationDetailsVo examvo = new ExaminationDetailsVo();

			examvo.setExamid(examid);
			examvo.setExamName(examname);
			examvo.setAccyear(accyear);

			boolean examname_Available = new CreateExaminationBD()
					.validateExamination(examvo);

			JSONObject jsonobject = new JSONObject();
			if (examname_Available) {

				jsonobject.put("status", "true");
			} else {
				jsonobject.put("status", "false");
			}
			response.getWriter().print(jsonobject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : validateEnding");
		return null;

	}

	public ActionForward downloadExamDetailsXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExamDetailsAction : downloadExamDetailsXLS Starting");

		try {

			System.out.println("download exam action");

			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/ExamDetailsXLSReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			/*
			 * List<ExaminationDetailsVo> examList = new
			 * ArrayList<ExaminationDetailsVo>(); examList =
			 * (List<ExaminationDetailsVo>) request.getSession(false)
			 * .getAttribute("EXcelDownLoad");
			 */

			String searchTerm = request.getParameter("searchTerm");

			List<ExaminationDetailsVo> examvo = new ArrayList<ExaminationDetailsVo>();

			ExamDetailsBD examdeligate = new ExamDetailsBD();

			if (searchTerm != null) {

				examvo = new CreateExaminationBD()
						.searchExamination(searchTerm);

				request.setAttribute("searchexamlist", searchTerm);
			} else {

				examvo = examdeligate.getexamdeligate();
				System.out.println("listing is working");
			}

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					examvo);
			Map parameters = new HashMap();

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/ExamDetailsXLSReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Exam Details Excel Report" };
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
					request.getRealPath("Reports/ExamDetailsXLSReport.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=ExamDetailsXLSReport.xls");
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
				+ " Control in ExamDetailsAction : downloadExamDetailsXLS");
		return null;

	}

	public ActionForward downloadExamDetailsPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExamDetailsAction : downloadExamDetailsPDF  Starting");

		try {

			System.out.println("downloading pdf");

		/*	List<ExaminationDetailsVo> examList = new ArrayList<ExaminationDetailsVo>();
			examList = (List<ExaminationDetailsVo>) request.getSession(false)
					.getAttribute("EXcelDownLoad");*/
			String searchTerm = request.getParameter("searchTerm");

			List<ExaminationDetailsVo> examvo = new ArrayList<ExaminationDetailsVo>();

			ExamDetailsBD examdeligate = new ExamDetailsBD();

			if (searchTerm != null) {

				examvo = new CreateExaminationBD()
						.searchExamination(searchTerm);

				request.setAttribute("searchexamlist", searchTerm);
			} else {

				examvo = examdeligate.getexamdeligate();
				System.out.println("listing is working");
			}


			String sourceFileName = request
					.getRealPath("Reports/ExamDetailsPDF.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);

			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					examvo);

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
					+ "ExamDetailsPDF - " + ".pdf\"");

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
				+ " Control in ExamDetailsAction : downloadExamDetailsPDF  Ending");
		return null;

	}

}
