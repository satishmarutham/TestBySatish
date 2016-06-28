package com.centris.campus.actions;

import java.io.File;




import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
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

import com.centris.campus.delegate.AddSubjectDelegate;
import com.centris.campus.delegate.ClassBD;
import com.centris.campus.delegate.SectionBD;
import com.centris.campus.forms.AddSubjectForm;
import com.centris.campus.forms.SectionForm;
import com.centris.campus.pojo.ClassPojo;
import com.centris.campus.pojo.StreamDetailsPojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.JPropertyReader;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.ViewallSubjectsVo;




public class AddSubjectAction extends DispatchAction {

	private static final Logger logger = Logger
			.getLogger(AddSubjectAction.class);
	static ResourceBundle res = ResourceBundle.getBundle("com/centris/campus/properties/CAMPUS");
	private static String EcampusPro_Documents_Dir  = JPropertyReader
			.getProperty("EcampusPro_Documents_Dir");
		private static String ImageName = res.getString("ImageName");
	
	
	
	public ActionForward classList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : classList Starting");
		try {

			List<ClassPojo> classList = new ArrayList<ClassPojo>();
			ClassBD delegate = new ClassBD();
			classList = delegate.getClassDetails();

			JSONObject object = new JSONObject();
			object.put("classList", classList);
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : classList Ending");

		return null;
	}

	public ActionForward getsubject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : getsubject Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : getsubject Ending");

		return mapping.findForward(MessageConstants.ADD_SUBJECT);
	}

	@SuppressWarnings("resource")
	public ActionForward addSubject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction:  AddSubject Starting");
		String user = HelperClass.getCurrentUser(request);

		
		
		
		try {
			String userId = HelperClass.getCurrentUserID(request);
			String extension = null;
			AddSubjectForm addSubjectForm = (AddSubjectForm) form;
			addSubjectForm.setCreatedUserId(userId);

			FormFile formFile = null;
			
			
			String path = null;

			File fileURL = null;

			FileOutputStream fos = null;

			formFile = addSubjectForm.getFile();

			
			
			
			File secondDir=null;
			File firstDir=null;
			
			
		 /*  firstDir=new File(EcampusPro_Documents_Dir+"/"+"SYLLABUS/");*/
			path = getServlet().getServletContext().getRealPath("/")
					+ "FIles\\SYLLABUS";
			
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
			
			
			
			String fileName = addSubjectForm.getSubjtname() + "_"
					+ addSubjectForm.getClassname() + "." + extension;
			fileURL = new File(path, fileName);
			fos = new FileOutputStream(fileURL);
			fos.write(formFile.getFileData());
			
			String file1 = fileURL.getPath();
			
			
			
			FileOutputStream fileOutStream =null;
			if(!fileURL.exists()){
		
				fileURL.mkdir();
				
				 fileOutStream = new FileOutputStream(fileURL);
				 fileOutStream.write(formFile.getFileData());
				 fileURL.mkdir();
				 addSubjectForm.setFilename(addSubjectForm.getSubjtname() + "_"
							+ addSubjectForm.getClassname() + "." + extension);

				 
			}
			else{
				
				fileURL.mkdir();
				
			
				fileOutStream = new FileOutputStream(fileURL);
				 fileOutStream.write(formFile.getFileData());
				
				
				addSubjectForm.setFilename(addSubjectForm.getSubjtname() + "_"
						+ addSubjectForm.getClassname() + "." + extension);
			}
			
			
			boolean addsubject = new AddSubjectDelegate()
			.addSubject(addSubjectForm);
			
            
			

				if (addsubject == false) {
					request.setAttribute("errorMessage",
							"Subject Already Exists");
				} else if(addsubject == true) {
					request.setAttribute("successmessagediv",
							"Subject created Successfully");
				}
				else
				{
					request.setAttribute("errorMessage",
							"Subject not created ! Try Again");
				}
			

			fileOutStream.close();

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : AddSubject Ending");

		return mapping.findForward(MessageConstants.ADD_SUBJECT);

	}
	
	public ActionForward updateSubject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction:  updateSubject Starting");
		String user = HelperClass.getCurrentUser(request);

		try {
			String userId = HelperClass.getCurrentUserID(request);
			String extension = null;
			AddSubjectForm addSubjectForm = (AddSubjectForm) form;
			addSubjectForm.setCreatedUserId(userId);
			
			

			FormFile formFile = null;
			
			
			String path = null;

			File fileURL = null;

			FileOutputStream fos = null;

			formFile = addSubjectForm.getFile();

			
			
			
			File secondDir=null;
			File firstDir=null;
			FileOutputStream fileOutStream =null;
			
			
			
		  /* firstDir=new File(EcampusPro_Documents_Dir+"/"+"SYLLABUS/");*/
			
			
			path = getServlet().getServletContext().getRealPath("/")
					+ "FIles\\SYLLABUS";
			File files = new File(path);
			if (!files.exists()) {
				if (files.mkdirs()) {
				}
			}
			path = files.getAbsolutePath();
			

		  
		   if(formFile != null){
		  int i = formFile.getFileName().lastIndexOf('.');
			if (i > 0) {
				extension = formFile.getFileName().substring(i + 1);
			}
			
			String fileName = addSubjectForm.getSubjtname() + "_"
					+ addSubjectForm.getClassname() + "." + extension;
			fileURL = new File(path, fileName);
			fos = new FileOutputStream(fileURL);
			fos.write(formFile.getFileData());
			
			String file1 = fileURL.getPath();
			
			
			  
			
		
			
			if(fileURL.exists()){
			
				/* secondDir=new File(EcampusPro_Documents_Dir+"/"+"SYLLABUS/"+addSubjectForm.getSubjtname() + "_"
							+ addSubjectForm.getClassname() + "." + extension);*/
				
				fileURL.mkdir();
				 fileOutStream = new FileOutputStream(fileURL);
				 fileOutStream.write(formFile.getFileData());
				 fileURL.mkdir();
				 addSubjectForm.setFilename(addSubjectForm.getSubjtname() + "_"
							+ addSubjectForm.getClassname() + "." + extension);

				 
			}
			else{
				
				/*firstDir=new File(EcampusPro_Documents_Dir+"/"+"SYLLABUS");*/
				fileURL.mkdir();
				
			/*	secondDir=new File(EcampusPro_Documents_Dir+"/"+"SYLLABUS/"+addSubjectForm.getSubjtname() + "_"
						+ addSubjectForm.getClassname() + "." + extension);*/
				fileOutStream = new FileOutputStream(fileURL);
				 fileOutStream.write(formFile.getFileData());
				
				
				addSubjectForm.setFilename(addSubjectForm.getSubjtname() + "_"
						+ addSubjectForm.getClassname() + "." + extension);
			}
			
		
		   }
			addSubjectForm.setFilename(addSubjectForm.getHiddenfile());
			
			 boolean updatesubject = new AddSubjectDelegate()
				.updateSubjectDetails(addSubjectForm);

			
      	
						 if (updatesubject == false) {
								request.setAttribute("errorMessage",
										"Subject Already Exists");
							    } else if(updatesubject == true){
								request.setAttribute("successmessagediv",
										"Subject Updated Successfully");
							    }
							    else
							    {
							    	request.setAttribute("errorMessage",
											"Subject not Updated ! Try Again");
							    }


			fileOutStream.close();

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : updateSubject Ending");

		return mapping.findForward(MessageConstants.ADD_SUBJECT);

	}
	
	public ActionForward DeleteSubject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : DeleteSubject Starting");

		try {
			ViewallSubjectsVo voOvj = new ViewallSubjectsVo();

			String subjectid = request.getParameter("subjectcode");
			voOvj.setSubjectid(subjectid);
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			boolean status = new AddSubjectDelegate().DeleteSubject(voOvj);

			JSONObject object = new JSONObject();
			object.put("status", status);
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : DeleteSubject Ending");

		return null;
	}

	public ActionForward searchsubjectdetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : searchsubjectdetails Starting");

		try {
			ViewallSubjectsVo voOvj = new ViewallSubjectsVo();
			String SearchName = request.getParameter("searchname");
			voOvj.setSearchName(SearchName);

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			List<ViewallSubjectsVo> subjectlist = new ArrayList<ViewallSubjectsVo>();
			subjectlist = new AddSubjectDelegate().searchsubjectdetails(voOvj);

			request.setAttribute("allsubjects", subjectlist);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : searchsubjectdetails Ending");

		return mapping.findForward(MessageConstants.SUBJECT_LIST);
	}

	public ActionForward getSubjectDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : getSubjectDetails Starting");

		try {
			
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);
			
			
			List<SectionForm> classDetailsIDandClassDetailsNameList = new ArrayList<SectionForm>();
			SectionBD sectionDelegate = new SectionBD();
			classDetailsIDandClassDetailsNameList = sectionDelegate
					.getCampusClassDetailsIDandClassDetailsNameBD();
			
			
			
			/*
			request.setAttribute("classlist",classDetailsIDandClassDetailsNameList);

			JSONObject jsonObject = new JSONObject(
					classDetailsIDandClassDetailsNameList);
			jsonObject.accumulate("classDetailsIDandClassDetailsNameList",
					classDetailsIDandClassDetailsNameList);
			response.getWriter().print(jsonObject);
			*/
			
			
			
			
			
			ViewallSubjectsVo obj = new ViewallSubjectsVo();
			String subjectcode = request.getParameter("subjectcode");
			obj.setSubjectid(subjectcode);
			
			
			
			

			ViewallSubjectsVo subjectdetails = new AddSubjectDelegate().getSubjectDetails(obj);
			
			
			
			request.setAttribute("success", "success");
			request.setAttribute("singlesubjectdetails", subjectdetails);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : getSubjectDetails Ending");

		return mapping.findForward(MessageConstants.UPDATE_SUBJECT);
	}

	public ActionForward getpathdownload(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : getpathdownload Starting");
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
				+ " Control in AddSubjectAction : getpathdownload  Ending");
		return null;
	}
	
	public ActionForward getsyllabusdownload(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : getsyllabusdownload Starting");
	
		try {
			
			String subjectid = request.getParameter("subjectid");
			
			response.setContentType("application/octet-stream");
			
		
			
			String docPath = new AddSubjectDelegate().DdownloadsyllabuspathBD(subjectid);
			
			
			
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
				+ " Control in AddSubjectAction : getsyllabusdownload  Ending");
		return null;
	}
	
	public ActionForward removeMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : removeMessage Starting");
		
		try {
			request.getSession().setAttribute("errormessagediv", null);
			request.getSession().setAttribute("successmessagediv", null);
			response.getWriter().print("Message Removed");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : removeMessage  Ending");
		return null;
	}
	
	public ActionForward downloadsubjectDetailsXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectAction : downloadsubjectDetailsXLS  Starting");
		
		try {
		
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/subjectXLSReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			
			
			
			List<ViewallSubjectsVo> streamList = new ArrayList<ViewallSubjectsVo>();
			
			streamList =  (List<ViewallSubjectsVo>) request.getSession(false)
					.getAttribute("EXcelDownLoad");
			
			
			
			
			
			
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					streamList);
			Map parameters = new HashMap();
			
			
			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/subjectXLSReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Subject Details Excel Report" };
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
					request.getRealPath("Reports/subjectXLSReport.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=subjectXLSReport.xls");
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
				+ " Control in AddSubjectAction : downloadsubjectDetailsXLS   Ending");
				return null;
		
		
	}
	
	public ActionForward downloadsubjectDetailsPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AddSubjectAction : downloadsubjectDetailsPDF  Starting");

			try {

				
/*
				List<ViewallSubjectsVo> Details = new ArrayList<ViewallSubjectsVo>();
				Details = new AddSubjectDelegate().subjectdetails();
				*/
				
				
				
				List<ViewallSubjectsVo> streamList = new ArrayList<ViewallSubjectsVo>();
				
				streamList =  (List<ViewallSubjectsVo>) request.getSession(false)
						.getAttribute("EXcelDownLoad");
				
				
				
				
				
				String sourceFileName = request
						.getRealPath("Reports/subjectPDF.jrxml");
				JasperDesign design = JRXmlLoader.load(sourceFileName);

				JasperReport jasperreport = JasperCompileManager
						.compileReport(design);

				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						streamList);

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
						+ "subjectdetailsPDF - " + ".pdf\"");

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
					+ " Control in AddSubjectAction : downloadsubjectDetailsPDF  Ending");
			return null;

		}


}
