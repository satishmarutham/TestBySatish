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

import com.centris.campus.daoImpl.IDGenerator;
import com.centris.campus.delegate.AcadamicYearPlanBD;
import com.centris.campus.forms.AcadamicYearPlanForm;
import com.centris.campus.pojo.AcadamicYearPlanPOJO;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.AcadamicYearPlanVO;
import com.centris.campus.vo.AddFeeVO;

public class AcadamicYearPlanAction extends DispatchAction{
	
	private static Logger logger = Logger.getLogger(AcadamicYearPlanAction.class);
	static ResourceBundle res = ResourceBundle
			.getBundle("com/centris/campus/properties/CAMPUS");
	private static String ImageName = res.getString("ImageName");
	
	
	public synchronized ActionForward getAcadamicYearPlanEntry(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : getAcadamicYearPlanEntry Starting");
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_ADMIN);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_ADMIN);
			
			
			
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : getAcadamicYearPlanEntry Ending");

		return mapping.findForward(MessageConstants.ACADAMICYEAR_PLAN_ENTRY);
	}
	
	
	
	public synchronized ActionForward insertAcadamicYearPlan(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : insertAcadamicYearPlan Starting");

		String path = null;
		String extension = null;
		File fileURL = null;
		FileOutputStream fos = null;
		
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_ADMIN);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_ADMIN);
			
			AcadamicYearPlanForm acadamicYearPlanForm =(AcadamicYearPlanForm)form;
			
			AcadamicYearPlanPOJO acadamicYearPlanPOJO = new AcadamicYearPlanPOJO();
			
	
			FormFile formFile = acadamicYearPlanForm.getFile();
			
			
			if(acadamicYearPlanForm.getHeventId().length()!=0){
				
				//Update Operation
				
				if(formFile.getFileSize()>0){
					
					path = getServlet().getServletContext().getRealPath("/")+ "FIles\\EVENTS";
					
					
					
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
		
					String fileName = HelperClass.getCurrentSqlDate() + "_"	+ acadamicYearPlanForm.getHeventId() + "." + extension;
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
					
					  acadamicYearPlanPOJO.setFile(file1);
				
			   }else{
						
						 acadamicYearPlanPOJO.setFile(acadamicYearPlanForm.gethFile());
					}
				
				acadamicYearPlanPOJO.setEventid(acadamicYearPlanForm.getHeventId());
				acadamicYearPlanPOJO.setTitle(acadamicYearPlanForm.getTitle());
				acadamicYearPlanPOJO.setDate(acadamicYearPlanForm.getDate());
				acadamicYearPlanPOJO.setDayOfWeekId(acadamicYearPlanForm.getDayOfWeekId());
				acadamicYearPlanPOJO.setStarttime(acadamicYearPlanForm.getStarttime());
				acadamicYearPlanPOJO.setEndtime(acadamicYearPlanForm.getEndtime());
				acadamicYearPlanPOJO.setDescription(acadamicYearPlanForm.getDescription());
				acadamicYearPlanPOJO.setCreatedby( HelperClass.getCurrentUserID(request));
				acadamicYearPlanPOJO.setAcadamicYear(request.getSession(false).getAttribute("current_academicYear").toString());
               String result =new AcadamicYearPlanBD().updateAcadamicYearPlan(acadamicYearPlanPOJO);
				
				if(MessageConstants.TRUE.equalsIgnoreCase(result)){
					
					request.setAttribute("successMessage", MessageConstants.UPDATE_EVENT_SUCCESS);
				}else{
					
					request.setAttribute("errorMessage", MessageConstants.UPDATE_EVENT_FAILURE);
	
				}
				
				
	
			}else{		
			
				String planId= IDGenerator.getPrimaryKeyID("campus_accyearplan");
				
				//insert operation
				
				if(formFile.getFileSize()>0){
		
				path = getServlet().getServletContext().getRealPath("/")+ "FIles\\EVENTS";
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
	
				String fileName = HelperClass.getCurrentSqlDate() + "_"	+ planId + "." + extension;
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
				
				  acadamicYearPlanPOJO.setFile(file1);
				
			}
				
				acadamicYearPlanPOJO.setEventid(planId);
				acadamicYearPlanPOJO.setTitle(acadamicYearPlanForm.getTitle());
				acadamicYearPlanPOJO.setDate(acadamicYearPlanForm.getDate());
				acadamicYearPlanPOJO.setDayOfWeekId(acadamicYearPlanForm.getDayOfWeekId());
				acadamicYearPlanPOJO.setStarttime(acadamicYearPlanForm.getStarttime());
				acadamicYearPlanPOJO.setEndtime(acadamicYearPlanForm.getEndtime());
				acadamicYearPlanPOJO.setDescription(acadamicYearPlanForm.getDescription());
				acadamicYearPlanPOJO.setCreatedby( HelperClass.getCurrentUserID(request));
				acadamicYearPlanPOJO.setAcadamicYear(request.getSession(false).getAttribute("current_academicYear").toString());
				                         
				
				
				String result =new AcadamicYearPlanBD().insertAcadamicYearPlan(acadamicYearPlanPOJO);
				
				if(MessageConstants.TRUE.equalsIgnoreCase(result)){
					
					request.setAttribute("successMessage", MessageConstants.INSERT_EVENT_SUCCESS);
				}else{
					
					request.setAttribute("errorMessage", MessageConstants.INSERT_EVENT_FAILURE);
	
				}
			
		
		
		}
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : insertAcadamicYearPlan Ending");

		return mapping.findForward(MessageConstants.ACADAMICYEAR_PLAN_ENTRY);
	}
	
	public synchronized ActionForward editAcadamicYearPlan(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : editAcadamicYearPlan Starting");

		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_ADMIN);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_ADMIN);
			
			String event_code = request.getParameter("Event_Code");
			
			AcadamicYearPlanPOJO acadamicYearPlanPOJO = new AcadamicYearPlanPOJO();
			acadamicYearPlanPOJO.setEventid(event_code);
		
			AcadamicYearPlanVO  plandetails = new AcadamicYearPlanBD().editAcadamicYearPlan(acadamicYearPlanPOJO);
			
			request.setAttribute("AcadamicYearPlanDetails", plandetails);
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : editAcadamicYearPlan Ending");

		return mapping.findForward(MessageConstants.ACADAMICYEAR_PLAN_ENTRY);
	}
	
	
	public synchronized ActionForward deleteAcadamicYearPlan(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : deleteAcadamicYearPlan Starting");

		try {
			
		   String event_code = request.getParameter("Event_Code");
			
			AcadamicYearPlanPOJO acadamicYearPlanPOJO = new AcadamicYearPlanPOJO();
			acadamicYearPlanPOJO.setEventid(event_code);
		
			String  result = new AcadamicYearPlanBD().deleteAcadamicYearPlan(acadamicYearPlanPOJO);

			JSONObject jsonobject = new JSONObject();
			jsonobject.put("status", result);
			response.getWriter().print(jsonobject);
			
					
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : deleteAcadamicYearPlan Ending");

		return null;
	}
	
	public synchronized ActionForward validateAcadamicYearPlan(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : validateAcadamicYearPlan Starting");

		try {
			
			AcadamicYearPlanPOJO acadamicYearPlanPOJO = new AcadamicYearPlanPOJO();
			acadamicYearPlanPOJO.setTitle(request.getParameter("title"));
			acadamicYearPlanPOJO.setDate(request.getParameter("date"));
			acadamicYearPlanPOJO.setStarttime(request.getParameter("starttime"));
			acadamicYearPlanPOJO.setEndtime(request.getParameter("endtime"));
			
			String  result = new AcadamicYearPlanBD().validateAcadamicYearPlan(acadamicYearPlanPOJO);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status", result);
		    response.getWriter().print(jsonObject);
			
		    
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : validateAcadamicYearPlan Ending");

		return null;
	}
	
	
	public synchronized ActionForward validateAcadamicYearPlanUpdate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : validateAcadamicYearPlanUpdate Starting");

		try {
			AcadamicYearPlanPOJO acadamicYearPlanPOJO = new AcadamicYearPlanPOJO();
			acadamicYearPlanPOJO.setTitle(request.getParameter("title"));
			acadamicYearPlanPOJO.setDate(request.getParameter("date"));
			acadamicYearPlanPOJO.setStarttime(request.getParameter("starttime"));
			acadamicYearPlanPOJO.setEndtime(request.getParameter("endtime"));
			acadamicYearPlanPOJO.setEventid(request.getParameter("AcadamicYearplanCode"));
			
			String  result = new AcadamicYearPlanBD().validateAcadamicYearPlanUpdate(acadamicYearPlanPOJO);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status", result);
		    response.getWriter().print(jsonObject);
			
		    
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : validateAcadamicYearPlanUpdate Ending");

		return null;
	}
	
	
    public synchronized ActionForward download(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : download Starting");

		try {
			String docPath = request.getParameter("filePath");
			response.setContentType("application/octet-stream");
			String fileName = "FileName";
			if (docPath != null) {
				String[] docPathArray = docPath.split("_");
				fileName = docPathArray[1];
			}
			
			response.addHeader("Content-Disposition", "attachment; filename="+ fileName);
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
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportTypeAction : download Ending");

		return null;
	}

    
    public ActionForward AcadamicYearPlanXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StreamDetailsAction : AcadamicYearPlanXLS  Starting");
		
		try {
		
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/AcademicYearPlanDetailsXLSReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
		
			ArrayList<AcadamicYearPlanVO> eventlist = new ArrayList<AcadamicYearPlanVO>();

			String searchTerm = request.getParameter("searchTerm");

			if (searchTerm != null) {

				AcadamicYearPlanPOJO acadamicYearPlanPOJO = new AcadamicYearPlanPOJO();
				acadamicYearPlanPOJO.setSerachText(searchTerm);
				acadamicYearPlanPOJO.setAcadamicYear(request.getSession(false)
						.getAttribute("current_academicYear").toString());
				eventlist = new AcadamicYearPlanBD()
						.getSearchDetails(acadamicYearPlanPOJO);
				request.setAttribute("searchTerm", searchTerm);
				
				
				
				request.setAttribute("searchnamelist", searchTerm);
				
				

			} else {

				AcadamicYearPlanPOJO acadamicYearPlanPOJO = new AcadamicYearPlanPOJO();
				acadamicYearPlanPOJO.setAcadamicYear(request.getSession(false)
						.getAttribute("current_academicYear").toString());

				eventlist = new AcadamicYearPlanBD()
						.getAllEventDetails(acadamicYearPlanPOJO);
			}
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					eventlist);
			Map parameters = new HashMap();
			
			
			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/AcademicYearPlanDetails.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Stream Details Excel Report" };
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
					request.getRealPath("Reports/AcademicYearPlanDetails.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=AcademicYearPlanDetails.xls");
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
				+ " Control in StreamDetailsAction : AcadamicYearPlanXLS   Ending");
				return null;
		
		
	}
	
	public ActionForward AcadamicYearPlanPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in FeeConcession : AcadamicYearPlanPDF  Starting");

			try {

				
				ArrayList<AcadamicYearPlanVO> eventlist = new ArrayList<AcadamicYearPlanVO>();

				String searchTerm = request.getParameter("searchTerm");

				if (searchTerm != null) {

					AcadamicYearPlanPOJO acadamicYearPlanPOJO = new AcadamicYearPlanPOJO();
					acadamicYearPlanPOJO.setSerachText(searchTerm);
					acadamicYearPlanPOJO.setAcadamicYear(request.getSession(false)
							.getAttribute("current_academicYear").toString());
					eventlist = new AcadamicYearPlanBD()
							.getSearchDetails(acadamicYearPlanPOJO);
					request.setAttribute("searchTerm", searchTerm);
					
					
					
					request.setAttribute("searchnamelist", searchTerm);
					
					

				} else {

					AcadamicYearPlanPOJO acadamicYearPlanPOJO = new AcadamicYearPlanPOJO();
					acadamicYearPlanPOJO.setAcadamicYear(request.getSession(false)
							.getAttribute("current_academicYear").toString());
					eventlist = new AcadamicYearPlanBD()
							.getAllEventDetails(acadamicYearPlanPOJO);
				}
				
				

				String sourceFileName = request
						.getRealPath("Reports/AcademicYearPlanDetailsPDF.jrxml");
				JasperDesign design = JRXmlLoader.load(sourceFileName);

				JasperReport jasperreport = JasperCompileManager
						.compileReport(design);

				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						eventlist);

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
						+ "AcademicYearPlanDetailsPDF - " + ".pdf\"");

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
					+ " Control in FeeConcession : AcadamicYearPlanPDF  Ending");
			return null;

		}

	
	public ActionForward getAcadamicYearPlanFilePath(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in FeeConcession : getAcadamicYearPlanFilePath  Starting");

			
			
			try {

				
				String docPath = request.getParameter("Path");
				
				
				response.setContentType("application/octet-stream");
				String fileName = "FileName";
				fileName=docPath;
				
				
				response.addHeader("Content-Disposition", "attachment; filename="+ fileName);
				
				
				
				File docFile = new File( getServlet().getServletContext().getRealPath("/")
						+ "FIles\\SYLLABUS"+("/")+docPath);
				
				
			
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
					+ " Control in FeeConcession : getAcadamicYearPlanFilePath  Ending");
			
			return null;

		}
	
}
