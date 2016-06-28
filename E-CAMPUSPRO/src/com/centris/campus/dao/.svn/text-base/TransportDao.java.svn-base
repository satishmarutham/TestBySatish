package com.centris.campus.dao;

import java.util.ArrayList;
import java.util.List;

import com.centris.campus.forms.TransportForm;
import com.centris.campus.pojo.TransportPojo;
import com.centris.campus.vo.DriverMsaterListVo;
import com.centris.campus.vo.StageMasterVo;
import com.centris.campus.vo.TransportVo;
import com.centris.campus.vo.VehicleDetailsVO;

public interface TransportDao {

	public ArrayList<VehicleDetailsVO> getAllvehicleDetails();

	public boolean saveVehicleDetails(VehicleDetailsVO transportForm,
			String createUser, String vehiclecode);

	public boolean checkingVehicleInsuranceDate(VehicleDetailsVO vehiclecode);

	public VehicleDetailsVO getSingleVehicleDetails(String vehiclecode);

	public boolean deleteVehicleDetails(String vehiclecode);

	public boolean registernumberValidation(String vehicleregno);

	public boolean updateregisternumberValidation(String vehicleregno,
			String vehicleCode);

	public boolean chassisnovalidationvalidation(String chassisno);

	public boolean updatechassisnovalidation(String chassisno,
			String vehicleCode);

	public ArrayList<VehicleDetailsVO> searchvehicledetails(String searchTerm);

	public boolean checkforduplicateAddTime(VehicleDetailsVO obj);

	public boolean checkforduplicateUpdateTime(VehicleDetailsVO obj);

	// route master start
	public List<TransportPojo> getTransportMasterDaoDetails();
	
	public List<TransportPojo> getTransportMasterDaoDetailsXLS();


	public int getTpRouteCheckDao(String tpName);

	public String insertRouteMasterDetails(TransportPojo tpPojo);

	public boolean removeRouteMasterDetails(TransportPojo tpMasterPojo);

	public boolean addRoute(TransportForm routeForm);

	public boolean checkrouteNo(TransportPojo Pojo);

	public TransportVo editRouteMasterDetails(TransportPojo tpMasterPojo);

	public List<TransportVo> searchDetails(TransportPojo pojo);

	// route master end

	public ArrayList<DriverMsaterListVo> getdriverListDao();

	public int addDriverDao(DriverMsaterListVo drivervo);

	public DriverMsaterListVo editDriverDao(DriverMsaterListVo drivervo);

	public String deleteDriverDao(DriverMsaterListVo drivervo);

	public ArrayList<DriverMsaterListVo> searchDriverDao(String searchName);

	public int updateDriverDao(DriverMsaterListVo drivervo);

	public boolean validateDriverDao(DriverMsaterListVo drivervo);

	public ArrayList<DriverMsaterListVo> getDriverNamesDetails();

	public ArrayList<DriverMsaterListVo> getDriverEntireDetails(String driverid);

	public ArrayList<DriverMsaterListVo> getDriverDetailsWhileUpdate(
			String vehiclecode);

	public DriverMsaterListVo getSingleDriverDetails(String vehiclecode);

	public ArrayList<StageMasterVo> getStopNames(String searchTerm);

	public ArrayList<TransportVo> getRouteDetails();

	public ArrayList<TransportVo> GetRouteEntireDetails(String route);

	public TransportVo getRouteDetails(String vehiclecode);
}
