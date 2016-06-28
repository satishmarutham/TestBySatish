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

import com.centris.campus.delegate.FeeMasterDelegate;
import com.centris.campus.delegate.TermMasterDelegate;
import com.centris.campus.pojo.StreamDetailsPojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.AddFeeVO;
import com.centris.campus.vo.TermMasterVo;

public class TermMasterAction extends DispatchAction

{

	private static final Logger logger = Logger
			.getLogger(AdminMenuAction.class);

	static ResourceBundle res = ResourceBundle
			.getBundle("com/centris/campus/properties/CAMPUS");
	private static String ImageName = res.getString("ImageName");

	public ActionForward addtermdetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)

	{

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TermMasterAction : addtermdetails Starting");

		String status = request.getParameter("result");

		if (status != null) {

			if (status.equalsIgnoreCase(MessageConstants.SuccesstermMsg)) {

				request.setAttribute("successmessagediv",
						MessageConstants.SuccesstermMsg);
			}
			if (status.equalsIgnoreCase(MessageConstants.SuccesstermUpMsg)) {

				request.setAttribute("successmessagediv",
						MessageConstants.SuccesstermUpMsg);
			}
		}

		String accyear = (String) request.getSession(false).getAttribute(
				"current_academicYear");

		TermMasterVo vo = new TermMasterVo();

		vo.setAccid(accyear);

		try

		{

			TermMasterDelegate delegate = new TermMasterDelegate();

			TermMasterVo acclist = delegate.getaccdetails(vo);

			request.setAttribute("acclist", acclist);

		}

		catch (Exception e)

		{

			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TermMasterAction : addtermdetails Ending");

		return mapping.findForward(MessageConstants.ADD_TERM);

	}

	public ActionForward getnamecount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)

	{

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TermMasterAction : getnamecount Starting");

		String name = request.getParameter("name");

		String id = request.getParameter("id");

		boolean status = false;

		try {

			TermMasterVo vo = new TermMasterVo();

			vo.setTermname(name);

			vo.setTermid(id);

			TermMasterDelegate delegate = new TermMasterDelegate();

			status = delegate.getnamecount(vo);

			JSONObject jsonObject = new JSONObject();

			jsonObject.put("message", status);

			response.getWriter().println(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TermMasterAction : getnamecount Ending");

		return null;

	}

	public ActionForward addtermfeedetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response)

	{

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TermMasterAction : addtermfeedetails Starting");

		String accyear = (String) request.getSession(false).getAttribute(
				"current_academicYear");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_ADMIN);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_ADMIN);

			TermMasterVo vo = new TermMasterVo();
			vo.setTermid(request.getParameter("id"));
			vo.setTermname(request.getParameter("name"));
			vo.setDescription(request.getParameter("description"));
			vo.setStartdate(request.getParameter("startdate"));
			vo.setEnddate(request.getParameter("enddate"));
			vo.setAccyear(accyear);
			vo.setTransporttype(request.getParameter("transId"));
			vo.setCreateuser(HelperClass.getCurrentUserID(request));

			TermMasterDelegate delegate = new TermMasterDelegate();

			String result = delegate.addtermfeedetails(vo);

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
				+ " Control in TermMasterAction : addtermfeedetails Ending");

		return null;

	}

	public ActionForward edittermDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response)

	{

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TermMasterAction : edittermDetails Starting");

		String id = request.getParameter("id");

		try {

			TermMasterVo vo = new TermMasterVo();

			vo.setTermid(id);

			TermMasterVo editlist = new TermMasterDelegate()
					.edittermDetails(vo);

			request.setAttribute("editlist", editlist);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TermMasterAction : edittermDetails Ending");

		return mapping.findForward(MessageConstants.ADD_TERM);

	}

	public ActionForward deleteTermDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response)

	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TermMasterAction : deleteTermDetails Starting");

		String result = "";

		String name = request.getParameter("name");

		try {

			TermMasterVo vo = new TermMasterVo();

			vo.setTermid(name);

			result = new TermMasterDelegate().deleteTermDetails(vo);

			JSONObject jsonObject = new JSONObject();

			jsonObject.put("jsonResponse", result);

			response.getWriter().println(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TermMasterAction : deleteTermDetails Ending");

		return null;

	}

	public ActionForward downloadtermlistDetailsXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TermMasterAction : downloadtermlistDetailsXLS  Starting");

		try {

			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/termdetailsxls.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			String name = request.getParameter("searchvalue");

			TermMasterVo vo = new TermMasterVo();
			vo.setTermname(name);

			System.out.println("namename" + name);

			ArrayList<TermMasterVo> termlist = new TermMasterDelegate()
					.termList(vo);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					termlist);
			Map parameters = new HashMap();

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/termdetailsxls.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Term Details Excel Report" };
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

			pdfxls = new File(request.getRealPath("Reports/Termdetailsxls.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=Termdetailsxls.xls");
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
				+ " Control in TermMasterAction : downloadtermlistDetailsXLS   Ending");
		return null;

	}

	public ActionForward downloadtermlistDetailsPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TermMasterAction : downloadtermlistDetailsPDF  Starting");

		try {

			System.out.println("downloading pdf");

			TermMasterVo vo = new TermMasterVo();
			String name = request.getParameter("searchvalue");
			vo.setTermname(name);

			System.out.println("namename" + name);

			ArrayList<TermMasterVo> termlist = new TermMasterDelegate()
					.termList(vo);

			String sourceFileName = request
					.getRealPath("Reports/termDetailsPDF.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);

			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					termlist);

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
					+ "TermDetailsPDF - " + ".pdf\"");

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
				+ " Control in TermMasterAction : downloadtermlistDetailsPDF  Ending");
		return null;

	}

}
