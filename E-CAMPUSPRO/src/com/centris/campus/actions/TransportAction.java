package com.centris.campus.actions;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.campus.daoImpl.IDGenerator;
import com.centris.campus.delegate.TransportBD;
import com.centris.campus.forms.TransportForm;
import com.centris.campus.pojo.TransportPojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.AddFeeVO;
import com.centris.campus.vo.DriverMsaterListVo;
import com.centris.campus.vo.StageMasterVo;
import com.centris.campus.vo.TransportVo;
import com.centris.campus.vo.VehicleDetailsVO;

public class TransportAction extends DispatchAction {
	private static final Logger logger = Logger
			.getLogger(TransportAction.class);
	static ResourceBundle res = ResourceBundle
			.getBundle("com/centris/campus/properties/CAMPUS");
	private static String ImageName = res.getString("ImageName");
	
	

	public ActionForward addvehicledetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : addvehicledetails Starting");

		try {
			String succesmessage = request.getParameter("message");
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TRANSPORT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TRANSPORT);

			request.setAttribute("successmessagediv", succesmessage);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : addvehicledetails Ending");

		return mapping.findForward(MessageConstants.ADD_VEHICLE);
	}

	public ActionForward saveVehicleDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : saveVehicleDetails Starting");
		try {
			System.out.println("add method vehicle");
			IDGenerator id = new IDGenerator();

			String createUser = HelperClass.getCurrentUserID(request);
			String vehiclecode = id.getPrimaryKeyID("transport_vehicle");

			VehicleDetailsVO transportForm = new VehicleDetailsVO();
			transportForm.setVehicleregno(request.getParameter("vehicleregno"));
			transportForm.setVehiclename(request.getParameter("vehiclename"));
			transportForm.setVehicletype(request.getParameter("vehicletype"));
			transportForm.setTypeofbody(request.getParameter("typeofbody"));
			transportForm.setMakersname(request.getParameter("makersname"));
			transportForm.setManufacturerdate(request
					.getParameter("manufacturerdate"));
			transportForm.setChassisno(request.getParameter("chassisno"));
			transportForm.setSettingcapacity(request
					.getParameter("settingcapacity"));
			transportForm.setFuelusedintheengine(request
					.getParameter("fuelengine"));
			transportForm.setColorofbody(request.getParameter("colorofbody"));

			transportForm.setCompanyname(request.getParameter("companyname"));
			transportForm.setIssueddate(request.getParameter("issueddate"));
			transportForm.setExpirydate(request.getParameter("expirydate"));
			transportForm.setCreatedby(request.getParameter("doneby"));
			transportForm.setUpdateVehicleCode(request
					.getParameter("updatevehiclecode"));
			transportForm.setStatus(request.getParameter("status"));

			transportForm.setDrivercode(request.getParameter("driverCode"));
			transportForm.setRoutecode(request.getParameter("routename"));

			boolean status = new TransportBD().saveVehicleDetails(
					transportForm, createUser, vehiclecode);
			System.out.println("status in action" + status);

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
				+ " Control in TransportAction : saveVehicleDetails  Ending");

		return null;
	}

	public ActionForward checkingVehicleInsuranceDate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : checkingVehicleInsuranceDate Starting");
		try {

			System.out.println("checking vehicle details issued date ");

			VehicleDetailsVO vehiclecode = new VehicleDetailsVO();

			vehiclecode.setVehiclecode(request.getParameter("vehiclename"));
			vehiclecode.setIssueddate(request.getParameter("issueddate"));
			vehiclecode.setExpirydate(request.getParameter("expirydate"));

			boolean status = new TransportBD()
					.checkingVehicleInsuranceDate(vehiclecode);

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
				+ " Control in TransportAction : checkingVehicleInsuranceDate  Ending");

		return null;
	}

	public ActionForward getSingleVehicleDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : getSingleVehicleDetails Starting");

		try {
			String vehiclecode = request.getParameter("vehiclecode");
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TRANSPORT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TRANSPORT);

			VehicleDetailsVO vehicleDetails = new TransportBD()
					.getSingleVehicleDetails(vehiclecode);

			DriverMsaterListVo driverDetails = new TransportBD()
					.getSingleDriverDetails(vehiclecode);

			TransportVo RouteDetails = new TransportBD()
					.getRouteDetails(vehiclecode);

			request.setAttribute("vehicleDetails", vehicleDetails);
			request.setAttribute("driverDetails", driverDetails);
			request.setAttribute("RouteDetails", RouteDetails);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : getSingleVehicleDetails Ending");

		return mapping.findForward(MessageConstants.ADD_VEHICLE);
	}

	public ActionForward deleteVehicleDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : deleteVehicleDetails Starting");

		try {

			System.out.println("delete action");
			String vehiclecode = request.getParameter("vehiclecode");
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TRANSPORT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TRANSPORT);

			boolean status = new TransportBD()
					.deleteVehicleDetails(vehiclecode);

			System.out.println("delete status " + status);

			/* request.setAttribute("vehicleDetails", vehicleDetails); */

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
				+ " Control in TransportAction : deleteVehicleDetails Ending");

		return null;
	}

	public ActionForward registernumberValidation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : registernumberValidation Starting");
		try {

			String vehicleregno = request.getParameter("vehicleregno");

			boolean status = new TransportBD()
					.registernumberValidation(vehicleregno);

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
				+ " Control in TransportAction : registernumberValidation  Ending");

		return null;
	}

	public ActionForward updateregisternumberValidation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : updateregisternumberValidation Starting");
		try {

			String vehicleregno = request.getParameter("vehicleregno");
			String vehicleCode = request.getParameter("vehicleCode");

			boolean status = new TransportBD().updateregisternumberValidation(
					vehicleregno, vehicleCode);
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
				+ " Control in TransportAction : updateregisternumberValidation  Ending");

		return null;
	}

	public ActionForward chassisnovalidationvalidation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : chassisnovalidationvalidation Starting");
		try {

			String chassisno = request.getParameter("chassisno");

			boolean status = new TransportBD()
					.chassisnovalidationvalidation(chassisno);

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
				+ " Control in TransportAction : chassisnovalidationvalidation  Ending");

		return null;
	}

	public ActionForward updatechassisnovalidation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : chassisnovalidationvalidation Starting");
		try {

			String chassisno = request.getParameter("chassisno");
			String vehicleCode = request.getParameter("vehicleCode");

			boolean status = new TransportBD().updatechassisnovalidation(
					chassisno, vehicleCode);

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
				+ " Control in TransportAction : chassisnovalidationvalidation  Ending");

		return null;
	}

	public ActionForward searchvehicledetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : searchvehicledetails Starting");
		System.out.println("search vehicle");
		try {
			String SearchName = request.getParameter("searchname");
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TRANSPORT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TRANSPORT);

			ArrayList<VehicleDetailsVO> getvehiclelist = new TransportBD()
					.searchvehicledetails(SearchName);
			request.setAttribute("getvehiclelist", getvehiclelist);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : searchvehicledetails Ending");

		return mapping.findForward(MessageConstants.VEHICLE_LIST);
	}

	public ActionForward checkforduplicateAddTime(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : checkforduplicateAddTime Starting");
		try {
			VehicleDetailsVO obj = new VehicleDetailsVO();
			obj.setVehicleregno(request.getParameter("vehicleregno"));
			obj.setVehiclename(request.getParameter("vehiclename"));
			obj.setVehicletype(request.getParameter("vehicletype"));
			obj.setTypeofbody(request.getParameter("typeofbody"));
			obj.setMakersname(request.getParameter("makersname"));
			obj.setManufacturerdate(request.getParameter("manufacturerdate"));
			obj.setChassisno(request.getParameter("chassisno"));
			obj.setFuelusedintheengine(request.getParameter("fuelengine"));

			boolean status = new TransportBD().checkforduplicateAddTime(obj);

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
				+ " Control in TransportAction : checkforduplicateAddTime  Ending");

		return null;
	}

	public ActionForward checkforduplicateUpdateTime(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : checkforduplicateUpdateTime Starting");
		try {
			VehicleDetailsVO obj = new VehicleDetailsVO();
			obj.setVehicleregno(request.getParameter("vehicleregno"));
			obj.setVehiclename(request.getParameter("vehiclename"));
			obj.setVehicletype(request.getParameter("vehicletype"));
			obj.setTypeofbody(request.getParameter("typeofbody"));
			obj.setMakersname(request.getParameter("makersname"));
			obj.setManufacturerdate(request.getParameter("manufacturerdate"));
			obj.setChassisno(request.getParameter("chassisno"));
			obj.setFuelusedintheengine(request.getParameter("fuelengine"));
			obj.setVehiclecode(request.getParameter("vehicleCode"));

			boolean status = new TransportBD().checkforduplicateUpdateTime(obj);

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
				+ " Control in TransportAction : checkforduplicateUpdateTime  Ending");

		return null;
	}

	public ActionForward removeMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StreamDetailsAction : removeMessage Starting");
		System.out.println("remove message");
		try {
			/* request.setAttribute("errormessagediv", null); */
			request.setAttribute("successmessagediv", "");
			response.getWriter().print("Message Removed");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StreamDetailsAction : removeMessage  Ending");
		return null;
	}

	// Route master Start

	public ActionForward addRouteScreen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : addRouteScreen Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TRANSPORT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TRANSPORT);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : addRouteScreen  Ending");

		return mapping.findForward(MessageConstants.ADDROUTESCREEN);

	}

	public ActionForward insertRouteMasterDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RouteSetupAction : insertRouteMasterDetails Starting");
		try {

			TransportPojo tpMasterPojo = new TransportPojo();
			String routeName = request.getParameter("routeName");
			String routeNo = request.getParameter("routeNo");
			String routeLogicName = request.getParameter("routeLogicName");
			String destination = request.getParameter("destination");
			String halttime = request.getParameter("halttime");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String totalStops = request.getParameter("totalStops");
			String totalDistance = request.getParameter("totalDistance");

			String createUser = HelperClass.getCurrentUserID(request);
			tpMasterPojo.setHalttime(halttime);
			tpMasterPojo.setEndTime(endTime);
			tpMasterPojo.setRouteLogicName(routeLogicName);
			tpMasterPojo.setRouteName(routeName);
			tpMasterPojo.setRouteNo(routeNo);
			tpMasterPojo.setDestination(destination);
			tpMasterPojo.setStartTime(startTime);
			tpMasterPojo.setTotalDistance(totalDistance);
			tpMasterPojo.setTotalStops(totalStops);
			tpMasterPojo.setCreateUser(createUser);

			if ("NULL".equalsIgnoreCase(request.getParameter("routeid"))) {
				tpMasterPojo.setRouteCode(IDGenerator
						.getPrimaryKeyID("transport_route"));
				tpMasterPojo.setCheck("NULL");
			} else {
				tpMasterPojo.setRouteCode(request.getParameter("routeid"));
			}

			String status = new TransportBD()
					.insertRouteMasterDetails(tpMasterPojo);

			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("status", status);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RouteSetupAction : insertRouteMasterDetails Ending");
		return null;
	}

	public ActionForward editRouteMasterDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportSetupAction : editRouteMasterDetails Starting");

		try {

			TransportPojo tpMasterPojo = new TransportPojo();

			tpMasterPojo.setRouteCode(request.getParameter("Code"));

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TRANSPORT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TRANSPORT);

			TransportVo masterDetails = new TransportBD()
					.editRouteMasterDetails(tpMasterPojo);

			request.setAttribute("masterDetails", masterDetails);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RouteSetupAction : editRouteMasterDetails Ending");
		return mapping.findForward(MessageConstants.ADDROUTESCREEN);
	}

	public ActionForward removeRouteMasterDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RouteSetupAction : removeRouteMasterDetails Starting");
		try {

			TransportPojo tpMasterPojo = new TransportPojo();

			tpMasterPojo.setRouteCode(request.getParameter("Code"));

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TRANSPORT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TRANSPORT);

			boolean status = new TransportBD()
					.removeRouteMasterDetails(tpMasterPojo);

			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("status", status);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RouteSetupAction : removeRouteMasterDetails Ending");
		return null;
	}

	public ActionForward addRoute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RouteSetupAction : addRoute Starting");

		TransportForm routeForm = (TransportForm) form;

		routeForm.setCurrentUser(HelperClass.getCurrentUser(request));

		boolean status = new TransportBD().addRoute(routeForm);

		List<TransportVo> getTpMasterDetails = new TransportBD()
				.getTransportMasterDetails();

		if (status) {
			request.setAttribute("message", "Route Details Saved SuccessFully");
		} else {
			request.setAttribute("error",
					"Route Details not-Saved, Please try again");
		}

		request.setAttribute("getTpMasterDetails", getTpMasterDetails);
		request.setAttribute(MessageConstants.MODULE_NAME,
				MessageConstants.BACKOFFICE_TRANSPORT);
		request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
				MessageConstants.MODULE_TRANSPORT);

		return mapping.findForward(MessageConstants.TRANSPORTMASTER);
	}

	public ActionForward checkrouteNo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : checkrouteNo Starting");
		try {
			TransportPojo Pojo = new TransportPojo();

			Pojo.setRouteNo(request.getParameter("routeNo"));
			Pojo.setRouteCode(request.getParameter("routeid"));

			boolean status = new TransportBD().checkrouteNo(Pojo);

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
				+ " Control in TransportAction : checkrouteNo  Ending");

		return null;
	}

	public ActionForward stopDetailsScreen(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : stopDetailsScreen Starting");
		try {
			String stopdetail = request.getParameter("stopdetails");

			String temp[] = stopdetail.split(",");

			TransportVo transportVo = new TransportVo();

			transportVo.setTotalStops(temp[0]);
			transportVo.setRouteCode(temp[1]);
			transportVo.setHalttime(temp[2]);

			System.out
					.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"
							+ temp[2]);

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TRANSPORT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TRANSPORT);

			request.setAttribute("stopdetails", transportVo);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : stopDetailsScreen  Ending");

		return mapping.findForward(MessageConstants.STOPDETAILSSCREEN);

	}

	// Route master End

	public ActionForward getDriverDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : getDriverDetails Starting");
		try {

			ArrayList<DriverMsaterListVo> drivernamelist = new TransportBD()
					.getDriverNamesDetails();

			JSONObject object = new JSONObject();
			object.put("drivernamelist", drivernamelist);
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : getDriverDetails  Ending");

		return null;
	}

	public ActionForward getDriverEntireDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : getDriverEntireDetails Starting");
		try {

			ArrayList<DriverMsaterListVo> driverlist = new TransportBD()
					.getDriverEntireDetails(request.getParameter("driverid"));

			JSONObject object = new JSONObject();
			object.put("driverlist", driverlist);
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : getDriverEntireDetails  Ending");

		return null;
	}

	public ActionForward getDriverDetailsWhileUpdate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : getDriverDetailsWhileUpdate Starting");
		try {

			ArrayList<DriverMsaterListVo> drivernamelist = new TransportBD()
					.getDriverDetailsWhileUpdate(request
							.getParameter("vehicleCode"));

			JSONObject object = new JSONObject();
			object.put("drivernamelist", drivernamelist);
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : getDriverDetailsWhileUpdate  Ending");

		return null;
	}

	public ActionForward getStopNames(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : getStopNames Starting");
		try {

			ArrayList<StageMasterVo> list = new TransportBD()
					.getStopNames(request.getParameter("searchTerm"));

			JSONObject object = new JSONObject();
			object.put("stopslist", list);
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : getStopNames  Ending");

		return null;
	}

	public ActionForward getRouteDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : getRouteDetails Starting");
		try {

			ArrayList<TransportVo> routelist = new TransportBD()
					.getRouteDetails();

			JSONObject object = new JSONObject();
			object.put("routelist", routelist);
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : getRouteDetails  Ending");

		return null;
	}

	public ActionForward GetRouteEntireDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : GetRouteEntireDetails Starting");
		try {

			ArrayList<TransportVo> routelist = new TransportBD()
					.GetRouteEntireDetails(request.getParameter("routeid"));

			JSONObject object = new JSONObject();
			object.put("routelist", routelist);
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : GetRouteEntireDetails  Ending");

		return null;
	}
	
	public ActionForward VehicleDetailsXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : VehicleDetailsXLS  Starting");
		
		try {
		System.out.println("DOWNLOADING EXCEL");
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/VehicleDetailsXLSReport1.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			/*List<VehicleDetailsVO> List = new ArrayList<VehicleDetailsVO>();
			List = (List<VehicleDetailsVO>) request.getSession(false).getAttribute("vehiclelistdownload");
*/
			ArrayList<VehicleDetailsVO> List = new TransportBD()
			.getAllvehicleDetails();
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					List);
			Map parameters = new HashMap();
			
			
			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/VehicleDetailsXLSReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "vehicle Details Excel Report" };
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
					request.getRealPath("Reports/VehicleDetailsXLSReport.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=VehicleDetailsXLSReport.xls");
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
				+ " Control in TransportAction : VehicleDetailsXLS   Ending");
				return null;
		
		
	}
	
	public ActionForward VehicleDetailsPDFReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in TransportAction : VehicleDetailsPDFReport  Starting");

			try {

				System.out.println("downloading pdf");

				/*List<VehicleDetailsVO> Details = new ArrayList<VehicleDetailsVO>();
				Details = (List<VehicleDetailsVO>) request.getSession(false).getAttribute("vehiclelistdownload");
*/
				ArrayList<VehicleDetailsVO> Details = new TransportBD()
				.getAllvehicleDetails();
				
				String sourceFileName = request
						.getRealPath("Reports/VehicleDetailsPDF.jrxml");
				JasperDesign design = JRXmlLoader.load(sourceFileName);

				JasperReport jasperreport = JasperCompileManager
						.compileReport(design);

				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						Details);

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
						+ "VehicleDetailsPDF - " + ".pdf\"");

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
					+ " Control in TransportAction : VehicleDetailsPDFReport  Ending");
			return null;

		}
	
	public ActionForward RouteDetailsXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportAction : RouteDetailsXLS  Starting");
		
		try {
		System.out.println("DOWNLOADING EXCEL");
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			
			
			
			
			String sourceFileName = request
					.getRealPath("Reports/RouteDetailsXLSReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			
			/*List<AddFeeVO> List = new ArrayList<AddFeeVO>();
			List = (List<AddFeeVO>) request.getSession(false)
					.getAttribute("feelistdownload");*/
			
			List<TransportVo> List=new ArrayList<TransportVo>();
			List = new TransportBD().getTransportMasterDetailsXLS();
			
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					List);
			Map parameters = new HashMap();
			
			
			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/RouteDetailsXLSReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Route Details XLS Report" };
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
					request.getRealPath("Reports/RouteDetailsXLSReport.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=RouteDetailsXLSReport.xls");
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
				+ " Control in TransportAction : RouteDetailsXLS   Ending");
				return null;
		
		
	}
	
	public ActionForward RouteDetailsPDFReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in TransportAction : RouteDetailsPDFReport  Starting");

			try {

				System.out.println("downloading pdf");

				List<TransportVo> Details=new ArrayList<TransportVo>();
				Details = new TransportBD().getTransportMasterDetailsXLS();
				
				String sourceFileName = request
						.getRealPath("Reports/RouteDetailsPDFReport.jrxml");
				JasperDesign design = JRXmlLoader.load(sourceFileName);

				JasperReport jasperreport = JasperCompileManager
						.compileReport(design);

				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						Details);

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
						+ "RouteDetailsPDFReport - " + ".pdf\"");

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
					+ " Control in TransportAction : RouteDetailsPDFReport  Ending");
			return null;

		}

}
