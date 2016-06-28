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
import com.centris.campus.delegate.ClassFeeSetupBD;
import com.centris.campus.pojo.ClassFeeSetupPojo;
import com.centris.campus.pojo.StreamDetailsPojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.ClassFeeSetupVo;


public class ClassFeeSetupAction extends DispatchAction {


	static ResourceBundle res = ResourceBundle
			.getBundle("com/centris/campus/properties/CAMPUS");
	private static String ImageName = res.getString("ImageName");
	
	private static final Logger logger = Logger.getLogger(ClassFeeSetupAction.class);

	public ActionForward getEditedFeeSetupDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupAction : getFeeSetupDetails Starting");

		try {

			String feeCode=request.getParameter("FeeCode");
			
			ClassFeeSetupBD feeSetupBD = new ClassFeeSetupBD();
			
			ArrayList<ClassFeeSetupVo> getActiveFeeMasterSetupDetails = null;
			ArrayList<ClassFeeSetupVo> getApprovedFeeMasterSetupDetails = null;
			
			ClassFeeSetupPojo feeSetupPojo = new ClassFeeSetupPojo();
			
			feeSetupPojo.setClassId(feeCode.split(",")[1]);
			feeSetupPojo.setAcadamicYear(feeCode.split(",")[0]);
			feeSetupPojo.setTerm(feeCode.split(",")[2]);

			try {
				getActiveFeeMasterSetupDetails = feeSetupBD.getAllFees(feeSetupPojo);
				getApprovedFeeMasterSetupDetails = feeSetupBD.getApprovedFees(feeSetupPojo);

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}

			request.setAttribute("getActiveFeeMasterSetupDetails",getActiveFeeMasterSetupDetails);
			request.setAttribute("getApprovedFeeMasterSetupDetails",getApprovedFeeMasterSetupDetails);

			request.getSession().setAttribute("classidVal", feeCode.split(",")[1]);
			request.getSession().setAttribute("acadamicYearVal", feeCode.split(",")[0]);
			request.getSession().setAttribute("termVal", feeCode.split(",")[2]);


		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupAction : getFeeSetupDetails Ending");
		
		return mapping.findForward(MessageConstants.FEE_SETUP_ENTRY);
	}
	
	public ActionForward insertApproveFees(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupAction : insertApproveFees Starting");


		String uniqueId = request.getParameter("FeeCode");
		String feeId = request.getParameter("FeeIdtoApprove");
		String accyearId=uniqueId.split(",")[0];
		String classId=uniqueId.split(",")[1];
		String term=uniqueId.split(",")[2];
		String user = HelperClass.getCurrentUserID(request);
		
		String[] feeId_array = feeId.split(",");

		ArrayList<ClassFeeSetupPojo> approvefeelist = new ArrayList<ClassFeeSetupPojo>();
		int message = 0;

		try {

			for (int i = 0; i < feeId_array.length; i++) {

				ClassFeeSetupPojo feeSetupPojo = new ClassFeeSetupPojo();

				feeSetupPojo.setClassId(classId);
				feeSetupPojo.setAcadamicYear(accyearId);
				feeSetupPojo.setTerm(term);
				feeSetupPojo.setFeeId(feeId_array[i]);
				feeSetupPojo.setCreatedby(user);
				

				approvefeelist.add(feeSetupPojo);

			}
			
			message = new ClassFeeSetupBD().insertApproveFees(approvefeelist);
			
			ClassFeeSetupPojo feeSetupPojos = new ClassFeeSetupPojo();
			feeSetupPojos.setClassId(classId);
			feeSetupPojos.setAcadamicYear(accyearId);
			feeSetupPojos.setTerm(term);
			
			request.setAttribute("getApprovedFeeMasterSetupDetails",
					new ClassFeeSetupBD().getApprovedFees(feeSetupPojos));
			request.setAttribute("getActiveFeeMasterSetupDetails",
					new ClassFeeSetupBD().getAllFees(feeSetupPojos));
			
			if (message == 1) {
				
				request.setAttribute("success",
						MessageConstants.FEE_APPROVE_SUCCESS);

			} else {

				request.setAttribute("error",
						MessageConstants.FEE_APPROVE_SUCCESS);
			}
			
			request.getSession().setAttribute("classidVal", classId);
			request.getSession().setAttribute("acadamicYearVal", accyearId);
			request.getSession().setAttribute("termVal", term);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupAction : insertApproveFees Ending");
		return mapping.findForward(MessageConstants.FEE_SETUP_ENTRY);
	}
	
	public ActionForward deleteFees(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeSetupAction : deleteFees Starting");

		try {
			String feeSettingsCode = request.getParameter("FeeSettingsCode");
			String FeeCode = request.getParameter("FeeCode");
			String classid = request.getParameter("classid");
			String acadamicYear = request.getParameter("acadamicYear");
			String term = request.getParameter("term");

			ClassFeeSetupPojo feeSetupPojo = new ClassFeeSetupPojo();
			feeSetupPojo.setFeeId(FeeCode);
			feeSetupPojo.setFeesettingCode(feeSettingsCode);
			feeSetupPojo.setClassId(classid);
			feeSetupPojo.setAcadamicYear(acadamicYear);
			feeSetupPojo.setTerm(term);
			boolean status = new ClassFeeSetupBD().deleteFees(feeSetupPojo);

			request.setAttribute("getActiveFeeMasterSetupDetails",
					new ClassFeeSetupBD().getAllFees(feeSetupPojo));
			request.setAttribute("getApprovedFeeMasterSetupDetails",
					new ClassFeeSetupBD().getApprovedFees(feeSetupPojo));
			
			request.getSession().setAttribute("classidVal", classid);
			request.getSession().setAttribute("acadamicYearVal", acadamicYear);
			request.getSession().setAttribute("termVal", term);
			
			if (status) {

				request.setAttribute("success",MessageConstants.FEE_SETUP_DELETE_SUCCESS);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupAction : deleteFees Ending");

		return mapping.findForward(MessageConstants.FEE_SETUP_ENTRY);

	}
	
	public ActionForward insertFeeAmount(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupAction : insertFeeAmount Starting");

		boolean flag = false;

		try {
			String classid = request.getParameter("classid");
			String acadamicYear = request.getParameter("acadamicYear");
			String term = request.getParameter("term");
			String FeeCode = request.getParameter("FeeCodeArray");
			String Fee = request.getParameter("FeeArray");
			

			String[] feecode_array = FeeCode.split(",");
			String[] fee_array = Fee.split(",");
			
			ArrayList<ClassFeeSetupPojo> feeAmountList=new ArrayList<ClassFeeSetupPojo>();

			for (int i = 0; i < feecode_array.length; i++) {

				ClassFeeSetupPojo feeSetupPojo = new ClassFeeSetupPojo();
				feeSetupPojo.setFeeId(feecode_array[i]);
				feeSetupPojo.setFeeamount(fee_array[i]);
				feeSetupPojo.setClassId(classid);
				feeSetupPojo.setAccYear(acadamicYear);
				feeSetupPojo.setTermId(term);
				feeAmountList.add(feeSetupPojo);
			}
			
			flag = new ClassFeeSetupBD().insertFeeAmount(feeAmountList);
			
			String currentaccyear=request.getSession(false).getAttribute("current_academicYear").toString();
			ArrayList<ClassFeeSetupVo> classSetupList=new ArrayList<ClassFeeSetupVo>();
			classSetupList=new ClassFeeSetupBD().getFeeSetupDetails(currentaccyear);
			request.setAttribute("classSetupList", classSetupList);

			if (flag) {
				request.setAttribute("success",
						MessageConstants.FEE_SETUP_INSERT_SUCCESS);
			} else {

				request.setAttribute("error",
						MessageConstants.FEE_SETUP_INSERT_FAILURE);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupAction : insertFeeAmount Ending");

		return mapping.findForward(MessageConstants.CLASS_FEE_SETUP);

	}
	
	public ActionForward downloadclassfeesetupXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupAction : downloadclassfeesetupXLS  Starting");
		
		try {
		
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/classfeesetupdetailsxls.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			/*String currentaccyear = request.getSession(false)
					.getAttribute("current_academicYear").toString();
			
			
			ArrayList<ClassFeeSetupVo> classSetupList = new ArrayList<ClassFeeSetupVo>();
			classSetupList = new ClassFeeSetupBD().getFeeSetupDetails(currentaccyear);
			*/
			String currentaccyear = request.getSession(false)
					.getAttribute("current_academicYear").toString();
			String searchTerm = request.getParameter("searchTerm");

			ArrayList<ClassFeeSetupVo> classSetupList = new ArrayList<ClassFeeSetupVo>();

			if (searchTerm == null || "".equalsIgnoreCase(searchTerm)) {

				classSetupList = new ClassFeeSetupBD()
						.getFeeSetupDetails(currentaccyear);

			} else {

				classSetupList = new ClassFeeSetupBD()
						.getSearchFeeSetupDetails(searchTerm, currentaccyear);

			}
			
			
			
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					classSetupList);
			Map parameters = new HashMap();
			
			
			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/Classfeesetupdetailsxls.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Class Fee Setup Details Excel Report" };
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
					request.getRealPath("Reports/Classfeesetupdetailsxls.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=Classfeesetupdetailsxls.xls");
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
				+ " Control in ClassFeeSetupAction : downloadclassfeesetupXLS   Ending");
				return null;
		
		
	}
	
	public ActionForward downloadclassfeesetupPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ClassFeeSetupAction : downloadclassfeesetupPDF  Starting");

			try {

				System.out.println("downloading pdf");
			/*	String currentaccyear = request.getSession(false)
						.getAttribute("current_academicYear").toString();
				ArrayList<ClassFeeSetupVo> classSetupList = new ArrayList<ClassFeeSetupVo>();
				classSetupList = new ClassFeeSetupBD()
				.getFeeSetupDetails(currentaccyear);*/
				
				String currentaccyear = request.getSession(false)
						.getAttribute("current_academicYear").toString();
				String searchTerm = request.getParameter("searchTerm");

				ArrayList<ClassFeeSetupVo> classSetupList = new ArrayList<ClassFeeSetupVo>();

				if (searchTerm == null || "".equalsIgnoreCase(searchTerm)) {

					classSetupList = new ClassFeeSetupBD()
							.getFeeSetupDetails(currentaccyear);

				} else {

					classSetupList = new ClassFeeSetupBD()
							.getSearchFeeSetupDetails(searchTerm, currentaccyear);

				}
				
				String sourceFileName = request
						.getRealPath("Reports/classfeesetupDetailsPDF.jrxml");
				JasperDesign design = JRXmlLoader.load(sourceFileName);

				JasperReport jasperreport = JasperCompileManager
						.compileReport(design);

				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						classSetupList);

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
						+ "ClassFeeSetupDetailsPDF - " + ".pdf\"");

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
					+ " Control in ClassFeeSetupAction : downloadclassfeesetupPDF  Ending");
			return null;

		}



}