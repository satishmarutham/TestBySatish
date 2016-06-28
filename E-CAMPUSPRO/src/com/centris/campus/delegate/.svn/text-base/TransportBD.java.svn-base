package com.centris.campus.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.campus.forms.TransportForm;
import com.centris.campus.pojo.TransportPojo;
import com.centris.campus.service.TransportService;
import com.centris.campus.serviceImpl.TransportServiceImpl;
import com.centris.campus.vo.DriverMsaterListVo;
import com.centris.campus.vo.StageMasterVo;
import com.centris.campus.vo.TransportVo;
import com.centris.campus.vo.VehicleDetailsVO;

public class TransportBD {

	TransportService service = new TransportServiceImpl();

	public ArrayList<VehicleDetailsVO> getAllvehicleDetails() {
		return service.getAllvehicleDetails();
	}

	public boolean saveVehicleDetails(VehicleDetailsVO transportForm,
			String createUser, String vehiclecode) {
		return service.saveVehicleDetails(transportForm, createUser,
				vehiclecode);
	}

	public boolean checkingVehicleInsuranceDate(VehicleDetailsVO vehiclecode) {
		return service.checkingVehicleInsuranceDate(vehiclecode);
	}

	public VehicleDetailsVO getSingleVehicleDetails(String vehiclecode) {
		return service.getSingleVehicleDetails(vehiclecode);
	}

	public boolean deleteVehicleDetails(String vehiclecode) {
		return service.deleteVehicleDetails(vehiclecode);
	}

	public boolean registernumberValidation(String vehicleregno) {
		return service.registernumberValidation(vehicleregno);
	}

	public boolean updateregisternumberValidation(String vehicleregno,
			String vehicleCode) {
		return service
				.updateregisternumberValidation(vehicleregno, vehicleCode);
	}

	public boolean chassisnovalidationvalidation(String chassisno) {
		return service.chassisnovalidationvalidation(chassisno);
	}

	public boolean updatechassisnovalidation(String chassisno,
			String vehicleCode) {
		return service.updatechassisnovalidation(chassisno, vehicleCode);
	}

	public ArrayList<VehicleDetailsVO> searchvehicledetails(String searchTerm) {
		return service.searchvehicledetails(searchTerm);
	}

	public boolean checkforduplicateAddTime(VehicleDetailsVO obj) {
		return service.checkforduplicateAddTime(obj);
	}

	public boolean checkforduplicateUpdateTime(VehicleDetailsVO obj) {
		return service.checkforduplicateUpdateTime(obj);
	}

	// route master start

	public List<TransportVo> getTransportMasterDetails() {
		TransportService transpService = new TransportServiceImpl();
		List<TransportVo> transportDetails = transpService
				.getTransportMasterServiceDetails();
		return transportDetails;
	}

	public String insertRouteMasterDetails(TransportPojo tpMasterPojo) {
		TransportService tpService = new TransportServiceImpl();

		String check = tpService.insertRouteMasterDetails(tpMasterPojo);
		return check;
	}

	public boolean removeRouteMasterDetails(TransportPojo tpMasterPojo) {
		TransportService routeService = new TransportServiceImpl();
		return routeService.removeRouteMasterDetails(tpMasterPojo);
	}

	public boolean addRoute(TransportForm routeForm) {
		return new TransportServiceImpl().addRoute(routeForm);
	}

	public boolean checkrouteNo(TransportPojo Pojo) {
		return service.checkrouteNo(Pojo);
	}

	public TransportVo editRouteMasterDetails(TransportPojo tpMasterPojo) {
		TransportService tpService = new TransportServiceImpl();

		TransportVo list = tpService.editRouteMasterDetails(tpMasterPojo);
		return list;
	}

	public List<TransportVo> searchDetails(TransportPojo pojo) {
		TransportService transpService = new TransportServiceImpl();
		List<TransportVo> transportDetails = transpService.searchDetails(pojo);
		return transportDetails;
	}

	public List<TransportVo> getTransportMasterDetailsXLS() {
		TransportService transpService = new TransportServiceImpl();
		List<TransportVo> transportDetails = transpService
				.getTransportMasterServiceDetailsXLS();
		return transportDetails;
	}

	// route master end

	public List<DriverMsaterListVo> getdriverList() {

		TransportService driverservice = new TransportServiceImpl();
		return driverservice.getdriverListService();
	}

	public String addDriverBD(TransportForm obj) {
		TransportService service = new TransportServiceImpl();
		return service.addDriverService(obj);
	}

	public DriverMsaterListVo editDriverBD(DriverMsaterListVo drivervo) {
		TransportService service = new TransportServiceImpl();
		return service.editDriverService(drivervo);
	}

	public String deleteDriverBD(DriverMsaterListVo drivervo) {

		TransportService service = new TransportServiceImpl();
		return service.deleteDriverService(drivervo);
	}

	public ArrayList<DriverMsaterListVo> searchDriverBD(String searchName) {

		TransportService service = new TransportServiceImpl();
		return service.searchDriverService(searchName);
	}

	public boolean validateDriverBD(DriverMsaterListVo drivervo) {

		TransportService service = new TransportServiceImpl();
		return service.validateDriverService(drivervo);
	}

	public ArrayList<DriverMsaterListVo> getDriverNamesDetails() {

		TransportService service = new TransportServiceImpl();
		return service.getDriverNamesDetails();
	}

	public ArrayList<DriverMsaterListVo> getDriverEntireDetails(String driverid) {
		TransportService service = new TransportServiceImpl();
		return service.getDriverEntireDetails(driverid);
	}

	public ArrayList<DriverMsaterListVo> getDriverDetailsWhileUpdate(
			String vehiclecode) {

		TransportService service = new TransportServiceImpl();
		return service.getDriverDetailsWhileUpdate(vehiclecode);
	}

	public DriverMsaterListVo getSingleDriverDetails(String vehiclecode) {
		TransportService service = new TransportServiceImpl();
		return service.getSingleDriverDetails(vehiclecode);
	}

	public ArrayList<StageMasterVo> getStopNames(String searchTerm) {
		TransportService service = new TransportServiceImpl();
		return service.getStopNames(searchTerm);
	}

	public ArrayList<TransportVo> getRouteDetails() {

		TransportService service = new TransportServiceImpl();
		return service.getRouteDetails();
	}

	public ArrayList<TransportVo> GetRouteEntireDetails(String route) {

		TransportService service = new TransportServiceImpl();
		return service.GetRouteEntireDetails(route);
	}

	public TransportVo getRouteDetails(String vehiclecode) {
		TransportService service = new TransportServiceImpl();
		return service.getRouteDetails(vehiclecode);
	}

}
