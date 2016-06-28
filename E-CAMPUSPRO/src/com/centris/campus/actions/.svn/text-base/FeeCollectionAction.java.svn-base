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

import com.centris.campus.delegate.FeeCollectionBD;
import com.centris.campus.delegate.ReportsMenuBD;
import com.centris.campus.pojo.StreamDetailsPojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.FeeCollectionVo;
import com.centris.campus.vo.FeeNameVo;
import com.centris.campus.vo.ReportMenuVo;

public class FeeCollectionAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(FeeCollectionAction.class);
	static ResourceBundle res = ResourceBundle
			.getBundle("com/centris/campus/properties/CAMPUS");
	private static String ImageName = res.getString("ImageName");

	public synchronized ActionForward getFeeCollectionDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionAction : getFeeCollectionDetails Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_FEE);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_FEE);

			String FeeCodeDetails = request.getParameter("FeeCode");

			FeeCollectionVo collectionVo = new FeeCollectionBD()
					.getFeeCollectionAmount(FeeCodeDetails);

			request.setAttribute("FeeCollectionVo", collectionVo);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionAction : getFeeCollectionDetails Ending");

		return mapping.findForward(MessageConstants.FEE_COLLECTION_ENTRY);
	}

	public synchronized ActionForward saveFeeCollection(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionAction : saveFeeCollection Starting");
		try {

			System.out.println("in saveFeeCollection ");

			String addmissionNo = request.getParameter("addmissionNo");
			String accYear = request.getParameter("accodemicyear");
			String termId = request.getParameter("termid");
			String classId = request.getParameter("classd");
			String concession = request.getParameter("concession");
			String tot_actual_amt = request.getParameter("tot_actual_amt");
			String tot_concession_amt = request
					.getParameter("tot_concession_amt");
			String tot_paid_amt = request.getParameter("tot_paid_amt");
			String feeId = request.getParameter("feeIdArray");
			String actualAmt = request.getParameter("actualamtArray");
			String concessionAmt = request.getParameter("concessionAmtArray");
			String paidAmt = request.getParameter("paidAmtArray");

			ArrayList<FeeNameVo> feeList = new ArrayList<FeeNameVo>();

			for (int i = 0; i < feeId.split(",").length; i++) {

				FeeNameVo feevo = new FeeNameVo();

				feevo.setFeecode(feeId.split(",")[i]);
				feevo.setActualAmt(Double.parseDouble(actualAmt.split(",")[i]));
				feevo.setConcessionAmt(Double.parseDouble(concessionAmt
						.split(",")[i]));
				feevo.setPaidAmt(Double.parseDouble(paidAmt.split(",")[i]));

				feeList.add(feevo);
			}

			FeeCollectionVo collectionVo = new FeeCollectionVo();

			collectionVo.setAddmissionno(addmissionNo);
			collectionVo.setAccYear(accYear);
			collectionVo.setTermid(termId);
			collectionVo.setClassId(classId);
			collectionVo.setConcession(Double.parseDouble(concession));
			collectionVo.setTot_actual_amt(Double.parseDouble(tot_actual_amt));
			collectionVo.setTot_concession_amt(Double
					.parseDouble(tot_concession_amt));
			collectionVo.setTot_paid_amt(Double.parseDouble(tot_paid_amt));
			collectionVo.setFeeNamelist(feeList);
			collectionVo.setUserID(HelperClass.getCurrentUserID(request));

			String status = new FeeCollectionBD()
					.saveFeeCollection(collectionVo);

			JSONObject object = new JSONObject();
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
				+ " Control in FeeCollectionAction : saveFeeCollection Ending");

		return null;
	}

	public ActionForward getSectionByClass(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionAction : getSectionByClass Starting");
		try {

			String classId = request.getParameter("classId");

			ArrayList<ReportMenuVo> classesList = new ReportsMenuBD()
					.getSectionsByClass(classId);

			JSONObject object = new JSONObject();
			object.put("SectionList", classesList);

			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionAction : getSectionByClass Ending");

		return null;
	}

	public ActionForward downloadfeecollectionXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionAction : downloadfeecollectionXLS  Starting");

		try {

			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/feecollectiondetailsxls.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			String currentYear = request.getSession(false)
					.getAttribute("current_academicYear").toString();

			ArrayList<FeeCollectionVo> feeCollectionList = null;
			
				feeCollectionList = new FeeCollectionBD()
						.getFeeCollectionDetails(currentYear);
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					feeCollectionList);
			Map parameters = new HashMap();

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/Feecollectiondetailsxls.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Fee Collection Details Excel Report" };
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
					request.getRealPath("Reports/Feecollectiondetailsxls.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=Feecollectiondetailsxls.xls");
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
				+ " Control in FeeCollectionAction : downloadfeecollectionXLS   Ending");
		return null;

	}

	public ActionForward downloadfeecollectionPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeCollectionAction : downloadfeecollectionPDF  Starting");

		try {

			System.out.println("downloading pdf");

			String currentYear = request.getSession(false)
					.getAttribute("current_academicYear").toString();

			ArrayList<FeeCollectionVo> feeCollectionList = null;
			
				feeCollectionList = new FeeCollectionBD()
						.getFeeCollectionDetails(currentYear);
	

			String sourceFileName = request
					.getRealPath("Reports/feecollectionDetailsPDF.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);

			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					feeCollectionList);

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
					+ "FeeCollectionDetailsPDF - " + ".pdf\"");

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
				+ " Control in FeeCollectionAction : downloadfeecollectionPDF  Ending");
		return null;

	}

}
