package com.centris.campus.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.TransportDao;
import com.centris.campus.daoImpl.CreateExaminationDaoImpl;
import com.centris.campus.daoImpl.TransportDaoImpl;
import com.centris.campus.delegate.TransportBD;
import com.centris.campus.forms.TransportForm;
import com.centris.campus.pojo.TransportPojo;
import com.centris.campus.service.TransportService;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.DriverMasterVO;
import com.centris.campus.vo.DriverMsaterListVo;
import com.centris.campus.vo.StageMasterVo;
import com.centris.campus.vo.TransportVo;
import com.centris.campus.vo.VehicleDetailsVO;

public class TransportServiceImpl implements TransportService {

	private static final Logger logger = Logger
			.getLogger(TransportServiceImpl.class);

	TransportDao transportdao = new TransportDaoImpl();

	public ArrayList<VehicleDetailsVO> getAllvehicleDetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getAllvehicleDetails Starting");
		ArrayList<VehicleDetailsVO> getvehiclelist = null;
		try {
			getvehiclelist = transportdao.getAllvehicleDetails();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getAllvehicleDetails  Ending");
		return getvehiclelist;
	}

	public boolean saveVehicleDetails(VehicleDetailsVO transportForm,
			String createUser, String vehiclecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : saveVehicleDetails Starting");
		boolean status = false;
		try {
			status = transportdao.saveVehicleDetails(transportForm, createUser,
					vehiclecode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : saveVehicleDetails  Ending");
		return status;
	}

	public boolean checkingVehicleInsuranceDate(VehicleDetailsVO vehiclecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : checkingVehicleInsuranceDate Starting");
		boolean status = false;
		try {
			status = transportdao.checkingVehicleInsuranceDate(vehiclecode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : checkingVehicleInsuranceDate  Ending");
		return status;
	}

	public VehicleDetailsVO getSingleVehicleDetails(String vehiclecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : checkingVehicleInsuranceDate Starting");
		VehicleDetailsVO ovj = null;
		try {
			ovj = transportdao.getSingleVehicleDetails(vehiclecode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : checkingVehicleInsuranceDate  Ending");
		return ovj;
	}

	public boolean deleteVehicleDetails(String vehiclecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : deleteVehicleDetails Starting");
		boolean status = false;
		try {
			status = transportdao.deleteVehicleDetails(vehiclecode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : deleteVehicleDetails  Ending");
		return status;
	}

	public boolean registernumberValidation(String vehicleregno) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : registernumberValidation Starting");
		boolean status = false;
		try {
			status = transportdao.registernumberValidation(vehicleregno);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : registernumberValidation  Ending");
		return status;
	}

	public boolean updateregisternumberValidation(String vehicleregno,
			String vehicleCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : updateregisternumberValidation Starting");
		boolean status = false;
		try {
			status = transportdao.updateregisternumberValidation(vehicleregno,
					vehicleCode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : updateregisternumberValidation  Ending");
		return status;
	}

	public boolean chassisnovalidationvalidation(String chassisno) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : registernumberValidation Starting");
		boolean status = false;
		try {
			status = transportdao.chassisnovalidationvalidation(chassisno);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : registernumberValidation  Ending");
		return status;
	}

	public boolean updatechassisnovalidation(String chassisno,
			String vehicleCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : updatechassisnovalidation Starting");
		boolean status = false;
		try {
			status = transportdao.updatechassisnovalidation(chassisno,
					vehicleCode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : updatechassisnovalidation  Ending");
		return status;
	}

	public ArrayList<VehicleDetailsVO> searchvehicledetails(String searchTerm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getAllvehicleDetails Starting");
		ArrayList<VehicleDetailsVO> getvehiclelist = null;
		try {
			getvehiclelist = transportdao.searchvehicledetails(searchTerm);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getAllvehicleDetails  Ending");
		return getvehiclelist;
	}

	public boolean checkforduplicateAddTime(VehicleDetailsVO obj) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : checkforduplicateAddTime Starting");
		boolean status = false;
		try {
			status = transportdao.checkforduplicateAddTime(obj);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : checkforduplicateAddTime  Ending");
		return status;
	}

	public boolean checkforduplicateUpdateTime(VehicleDetailsVO obj) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : checkforduplicateUpdateTime Starting");
		boolean status = false;
		try {
			status = transportdao.checkforduplicateUpdateTime(obj);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : checkforduplicateUpdateTime  Ending");
		return status;
	}

	// route master start
	public List<TransportVo> getTransportMasterServiceDetails() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in Transport ServiceImpl: getTransportMasterServiceDetails Starting");
		TransportDao tpSetupDao = new TransportDaoImpl();
		List<TransportVo> transportVOList = new ArrayList<TransportVo>();
		try {
			List<TransportPojo> tplist = tpSetupDao.getTransportMasterDaoDetails();
			for (TransportPojo gatDatas : tplist) {
				TransportVo tpVoObj = new TransportVo();

				tpVoObj.setEndTime(gatDatas.getEndTime());
				tpVoObj.setRouteName(gatDatas.getRouteName());
				tpVoObj.setRouteNo(gatDatas.getRouteNo());
				tpVoObj.setStratTime(gatDatas.getStartTime());
				tpVoObj.setTotalDistance(gatDatas.getTotalDistance());
				tpVoObj.setTotalStops(gatDatas.getTotalStops());
				tpVoObj.setRouteCode(gatDatas.getRouteCode());
				tpVoObj.setHalttime(gatDatas.getHalttime());
				tpVoObj.setDestination(gatDatas.getDestination());
				
				transportVOList.add(tpVoObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeSetupServiceImpl: getFeeMasterServiceDetails Ending");
		return transportVOList;
	}

	public String insertRouteMasterDetails(TransportPojo tpMasterPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportSetupServiceImpl:insertTpMasterDetails  Starting");
		// TODO Auto-generated method stub
		String check = null;
		TransportDao tpSetupDao = new TransportDaoImpl();
		try {

			check = tpSetupDao.insertRouteMasterDetails(tpMasterPojo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeSetupServiceImpl:insertFeeMasterDetails Ending");
		return check;
	}

	public boolean removeRouteMasterDetails(TransportPojo tpMasterPojo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeSetupServiceImpl: removeFeeMasterDetailsService Starting");
		TransportDao routeDaoObj = new TransportDaoImpl();
		boolean message = false;
		try {
			message = routeDaoObj.removeRouteMasterDetails(tpMasterPojo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RouteSetupServiceImpl: removeRouteMasterDetailsService Ending");
		return message;
	}

	public boolean addRoute(TransportForm routeForm) {
		return new TransportDaoImpl().addRoute(routeForm);
	}

	public boolean checkrouteNo(TransportPojo Pojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : checkrouteNo Starting");
		boolean status = false;
		try {
			status = transportdao.checkrouteNo(Pojo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : checkrouteNo  Ending");
		return status;
	}

	public TransportVo editRouteMasterDetails(TransportPojo tpMasterPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : editRouteMasterDetails Starting");
		TransportVo list = null;
		try {
			list = transportdao.editRouteMasterDetails(tpMasterPojo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : editRouteMasterDetails  Ending");

		return list;
	}

	public List<TransportVo> searchDetails(TransportPojo pojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : editRouteMasterDetails Starting");
		List<TransportVo> list = null;
		try {
			list = transportdao.searchDetails(pojo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : editRouteMasterDetails  Ending");

		return list;

	}// route master end

	public List<DriverMsaterListVo> getdriverListService() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getdriverListService Starting");

		ArrayList<DriverMsaterListVo> driverlist = null;
		try {

			driverlist = transportdao.getdriverListDao();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getdriverListService  Ending");

		return driverlist;
	}

	public String addDriverService(TransportForm obj) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : addDriverService Starting");

		DriverMsaterListVo drivervo = new DriverMsaterListVo();
		String result = null;

		if (obj.getDrivercode().equalsIgnoreCase("")
				|| obj.getDrivercode() == null)

		{

			try {
				drivervo.setAddress(obj.getAddress());
				drivervo.setAge(obj.getAge());
				drivervo.setDateofBirth(obj.getDateofBirth());
				drivervo.setDateofJoin(obj.getDateofJoin());
				drivervo.setDl_issued_date(obj.getDl_issued_date());
				drivervo.setDl_validity(obj.getDl_validity());
				drivervo.setDriverName(obj.getDriverName());
				drivervo.setDrivingliecenseNo(obj.getDrivingliecenseNo());
				drivervo.setEmerg_contact(obj.getEmerg_contact());
				drivervo.setExperience(obj.getExperience());
				drivervo.setFather_name(obj.getFather_name());
				drivervo.setGender(obj.getGender());
				drivervo.setLicense(obj.getLicense());
				drivervo.setMobile(obj.getMobile());
				drivervo.setType(obj.getType());
				drivervo.setDriverCode(obj.getDriver_code());
				drivervo.setCreateUser(obj.getCreateUser());

				int res = transportdao.addDriverDao(drivervo);

				if (res == 1) {

					result = "Driver Creation Failed";
				} else {
					result = "Driver Created Successfully";
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}

		}

		else if (!obj.getDrivercode().equalsIgnoreCase("")
				|| obj.getDrivercode() == null) {

			try {

				drivervo.setAddress(obj.getAddress());
				drivervo.setAge(obj.getAge());
				drivervo.setDateofBirth(obj.getDateofBirth());
				drivervo.setDateofJoin(obj.getDateofJoin());
				drivervo.setDl_issued_date(obj.getDl_issued_date());
				drivervo.setDl_validity(obj.getDl_validity());
				drivervo.setDriverName(obj.getDriverName());
				drivervo.setDrivingliecenseNo(obj.getDrivingliecenseNo());
				drivervo.setEmerg_contact(obj.getEmerg_contact());
				drivervo.setExperience(obj.getExperience());
				drivervo.setFather_name(obj.getFather_name());
				drivervo.setGender(obj.getGender());
				drivervo.setLicense(obj.getLicense());
				drivervo.setMobile(obj.getMobile());
				drivervo.setType(obj.getType());
				drivervo.setDriverCode(obj.getDrivercode());
				drivervo.setCreateUser(obj.getCreateUser());

				int res = transportdao.updateDriverDao(drivervo);

				if (res == 1) {

					result = "Driver Update Successfully";
				} else {
					result = "Driver not Update Successfully";
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}

		}

		/*
		 * try {
		 * 
		 * drivervo.setAddress(obj.getAddress()); drivervo.setAge(obj.getAge());
		 * drivervo.setDateofBirth(obj.getDateofBirth());
		 * drivervo.setDateofJoin(obj.getDateofJoin());
		 * drivervo.setDl_issued_date(obj.getDl_issued_date());
		 * drivervo.setDl_validity(obj.getDl_validity());
		 * drivervo.setDriverName(obj.getDriverName());
		 * drivervo.setDrivingliecenseNo(obj.getDrivingliecenseNo());
		 * drivervo.setEmerg_contact(obj.getEmerg_contact());
		 * drivervo.setExperience(obj.getExperience());
		 * drivervo.setFather_name(obj.getFather_name());
		 * drivervo.setGender(obj.getGender());
		 * drivervo.setLicense(obj.getLicense());
		 * drivervo.setMobile(obj.getMobile()); drivervo.setType(obj.getType());
		 * drivervo.setDriverCode(obj.getDriver_code());
		 * drivervo.setCreateUser(obj.getCreateUser());
		 * 
		 * 
		 * } catch (Exception e) { logger.error(e.getMessage(), e);
		 * e.printStackTrace(); }
		 */

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : addDriverService  Ending");
		return result;
	}

	public DriverMsaterListVo editDriverService(DriverMsaterListVo drivervo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : editDriverService Starting");

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : editDriverService  Ending");

		return transportdao.editDriverDao(drivervo);
	}

	public String deleteDriverService(DriverMsaterListVo drivervo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : editDriverService Starting");

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : editDriverService  Ending");
		return transportdao.deleteDriverDao(drivervo);
	}

	public ArrayList<DriverMsaterListVo> searchDriverService(String searchName) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : searchDriverService Starting");

		ArrayList<DriverMsaterListVo> driverlist = transportdao
				.searchDriverDao(searchName);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : searchDriverService  Ending");

		return driverlist;
	}

	public boolean validateDriverService(DriverMsaterListVo drivervo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : validateDriverService Starting");

		boolean driver_validate = false;

		driver_validate = transportdao.validateDriverDao(drivervo);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : validateDriverService  Ending");
		return driver_validate;
	}

	public ArrayList<DriverMsaterListVo> getDriverNamesDetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getDriverNamesDetails Starting");
		ArrayList<DriverMsaterListVo> driverlist = null;
		try {
			driverlist = transportdao.getDriverNamesDetails();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getDriverNamesDetails  Ending");

		return driverlist;

	}

	public ArrayList<DriverMsaterListVo> getDriverEntireDetails(String driverid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getDriverEntireDetails Starting");
		ArrayList<DriverMsaterListVo> driverlist = null;
		try {
			driverlist = transportdao.getDriverEntireDetails(driverid);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getDriverEntireDetails  Ending");

		return driverlist;

	}

	public ArrayList<DriverMsaterListVo> getDriverDetailsWhileUpdate(
			String vehiclecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getDriverDetailsWhileUpdate Starting");
		ArrayList<DriverMsaterListVo> driverlist = null;
		try {
			driverlist = transportdao.getDriverDetailsWhileUpdate(vehiclecode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getDriverDetailsWhileUpdate  Ending");

		return driverlist;

	}

	public DriverMsaterListVo getSingleDriverDetails(String vehiclecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getSingleDriverDetails Starting");
		DriverMsaterListVo driverlist = null;
		try {
			driverlist = transportdao.getSingleDriverDetails(vehiclecode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getSingleDriverDetails  Ending");

		return driverlist;

	}

	public ArrayList<StageMasterVo> getStopNames(String searchTerm) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getStopNames Starting");
		ArrayList<StageMasterVo> driverlist = null;
		try {
			driverlist = transportdao.getStopNames(searchTerm);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getStopNames  Ending");

		return driverlist;

	}

	public ArrayList<TransportVo> getRouteDetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getRouteDetails Starting");
		ArrayList<TransportVo> transportlist = null;
		try {
			transportlist = transportdao.getRouteDetails();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getRouteDetails  Ending");

		return transportlist;
	}

	public ArrayList<TransportVo> GetRouteEntireDetails(String route) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : GetRouteEntireDetails Starting");
		ArrayList<TransportVo> transportlist = null;
		try {
			transportlist = transportdao.GetRouteEntireDetails(route);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : GetRouteEntireDetails  Ending");

		return transportlist;

	}

	public TransportVo getRouteDetails(String vehiclecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getRouteDetails Starting");
		TransportVo transportlist = null;
		try {
			transportlist = transportdao.getRouteDetails(vehiclecode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getRouteDetails  Ending");

		return transportlist;

	}
	
	public List<TransportVo> getTransportMasterServiceDetailsXLS() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in Transport ServiceImpl: getTransportMasterServiceDetails Starting");
		TransportDao tpSetupDao = new TransportDaoImpl();
		List<TransportVo> transportVOList = new ArrayList<TransportVo>();
		try {
			List<TransportPojo> tplist = tpSetupDao
					.getTransportMasterDaoDetailsXLS();
			for (TransportPojo gatDatas : tplist) {
				TransportVo tpVoObj = new TransportVo();

				tpVoObj.setEndTime(gatDatas.getEndTime());
				tpVoObj.setRouteName(gatDatas.getRouteName());
				tpVoObj.setRouteNo(gatDatas.getRouteNo());
				tpVoObj.setStratTime(gatDatas.getStartTime());
				tpVoObj.setTotalDistance(gatDatas.getTotalDistance());
				tpVoObj.setTotalStops(gatDatas.getTotalStops());
				tpVoObj.setRouteCode(gatDatas.getRouteCode());
				tpVoObj.setHalttime(gatDatas.getHalttime());
				tpVoObj.setDestination(gatDatas.getDestination());
				tpVoObj.setStopname(gatDatas.getStopname());

				tpVoObj.setArrivaltime(gatDatas.getArrivaltime());

				tpVoObj.setDeparturetime(gatDatas.getDeparturetime());

				tpVoObj.setDistance(gatDatas.getDistance());

				transportVOList.add(tpVoObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeSetupServiceImpl: getFeeMasterServiceDetails Ending");
		return transportVOList;
	}
	
	
	
}
