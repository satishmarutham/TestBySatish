package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.campus.dao.TransportDao;
import com.centris.campus.forms.TransportForm;
import com.centris.campus.pojo.TransportPojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.TransportUtilConstants;
import com.centris.campus.vo.DriverMsaterListVo;
import com.centris.campus.vo.StageMasterVo;
import com.centris.campus.vo.TransportVo;
import com.centris.campus.vo.VehicleDetailsVO;

public class TransportDaoImpl implements TransportDao {

	private static final Logger logger = Logger
			.getLogger(TransportDaoImpl.class);

	public ArrayList<VehicleDetailsVO> getAllvehicleDetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getAllvehicleDetails Starting");
		ArrayList<VehicleDetailsVO> getvehiclelist = new ArrayList<VehicleDetailsVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		int sno = 0;
		try {
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TransportUtilConstants.GET_ALL_VEHICLE_DETAILS);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				sno++;
				VehicleDetailsVO detailsVO = new VehicleDetailsVO();
				detailsVO.setSno(String.valueOf(sno));
				detailsVO.setVehiclecode(rs.getString("VehicleCode"));
				detailsVO.setVehicleregno(rs.getString("Vehicle_Reg_No"));
				detailsVO.setVehiclename(rs.getString("VehicleName"));
				detailsVO.setVehicletype(rs.getString("VehicleType"));
				detailsVO.setTypeofbody(rs.getString("Type_Of_Body"));
				detailsVO.setMakersname(rs.getString("Makers_name"));
				detailsVO.setManufacturerdate(HelperClass
						.convertDatabaseToUI(rs.getString("Manifacture_Date")));
				detailsVO.setChassisno(rs.getString("Chassis_No"));
				detailsVO.setSettingcapacity(rs.getString("Seating_Capacity"));
				detailsVO.setFuelusedintheengine(rs.getString("Fuel_Type"));
				detailsVO.setColorofbody(rs.getString("Body_Color"));

				getvehiclelist.add(detailsVO);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getAllvehicleDetails  Ending");
		return getvehiclelist;
	}

	public boolean saveVehicleDetails(VehicleDetailsVO transportForm,
			String createUser, String vehiclecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : saveVehicleDetails Starting");
		int count = 0;
		boolean status = false;
		PreparedStatement pstmt = null;
		Connection connection = null;
		PreparedStatement updatepstmt = null;

		PreparedStatement updatepstmt2 = null;

		PreparedStatement pstmt3 = null;

		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt4 = null;

		try {

			connection = JDBCConnection.getSeparateConnection();
			if (!transportForm.getStatus().equals("update")) {
				pstmt = connection
						.prepareStatement(TransportUtilConstants.SAVE_VEHICLE_DETAILS);
				pstmt.setString(1, vehiclecode);
				pstmt.setString(2, transportForm.getVehicleregno());
				pstmt.setString(3, transportForm.getVehiclename());
				pstmt.setString(4, transportForm.getVehicletype());
				pstmt.setString(5, transportForm.getTypeofbody());
				pstmt.setString(6, transportForm.getMakersname());
				pstmt.setString(7, HelperClass
						.convertUIToDatabase(transportForm
								.getManufacturerdate()));
				pstmt.setString(8, transportForm.getChassisno());
				pstmt.setString(9, transportForm.getSettingcapacity());
				pstmt.setString(10, transportForm.getFuelusedintheengine());
				pstmt.setString(11, transportForm.getColorofbody());
				pstmt.setString(12, createUser);

				count = pstmt.executeUpdate();

				pstmt = connection
						.prepareStatement(TransportUtilConstants.SAVE_VEHICLE_INSURANCE_DETAILS);
				pstmt.setString(1, vehiclecode);
				pstmt.setString(2, transportForm.getCompanyname());
				pstmt.setString(3, HelperClass
						.convertUIToDatabase(transportForm.getIssueddate()));
				pstmt.setString(4, HelperClass
						.convertUIToDatabase(transportForm.getExpirydate()));
				pstmt.setString(5, transportForm.getCreatedby());
				pstmt.setString(6, createUser);

				count = pstmt.executeUpdate();

				updatepstmt2 = connection
						.prepareStatement(TransportUtilConstants.MAP_DRIVER_VEHICLE_INSERTING);
				updatepstmt2.setString(1, transportForm.getDrivercode());
				updatepstmt2.setString(2, vehiclecode);
				updatepstmt2.setString(3, createUser);

				updatepstmt2.executeUpdate();

				pstmt3 = connection
						.prepareStatement(TransportUtilConstants.MAP_DRIVER_VEHICLE_ROUTE_MAPPING);
				pstmt3.setString(1, transportForm.getRoutecode());
				pstmt3.setString(2, vehiclecode);
				pstmt3.setString(3, createUser);
				pstmt3.executeUpdate();

			} else {
				updatepstmt = connection
						.prepareStatement(TransportUtilConstants.UPDATE_VEHICLE_DETAILS);

				updatepstmt.setString(1, transportForm.getVehicleregno());
				updatepstmt.setString(2, transportForm.getVehiclename());
				updatepstmt.setString(3, transportForm.getVehicletype());
				updatepstmt.setString(4, transportForm.getTypeofbody());
				updatepstmt.setString(5, transportForm.getMakersname());
				updatepstmt.setString(6, HelperClass
						.convertUIToDatabase(transportForm
								.getManufacturerdate()));
				updatepstmt.setString(7, transportForm.getChassisno());
				updatepstmt.setString(8, transportForm.getSettingcapacity());
				updatepstmt
						.setString(9, transportForm.getFuelusedintheengine());
				updatepstmt.setString(10, transportForm.getColorofbody());
				updatepstmt.setTimestamp(11, HelperClass.getCurrentTimestamp());
				updatepstmt.setString(12, createUser);
				updatepstmt.setString(13, transportForm.getUpdateVehicleCode());

				count = updatepstmt.executeUpdate();

				updatepstmt = connection
						.prepareStatement(TransportUtilConstants.UPDATE_VEHICLE_INSURANCE_DETAILS);

				updatepstmt.setString(1, transportForm.getCompanyname());
				updatepstmt.setString(2, HelperClass
						.convertUIToDatabase(transportForm.getIssueddate()));
				updatepstmt.setString(3, HelperClass
						.convertUIToDatabase(transportForm.getExpirydate()));
				updatepstmt.setString(4, transportForm.getCreatedby());
				updatepstmt.setString(5, createUser);
				updatepstmt.setTimestamp(6, HelperClass.getCurrentTimestamp());
				updatepstmt.setString(7, transportForm.getUpdateVehicleCode());

				count = updatepstmt.executeUpdate();

				if (transportForm.getDrivercode() != ""
						|| transportForm.getDrivercode() != null) {

					pstmt2 = connection
							.prepareStatement(TransportUtilConstants.CHECKING_DRIVER);

					pstmt2.setString(1, transportForm.getDrivercode());

					ResultSet rst = pstmt2.executeQuery();
					int count1 = 0;
					while (rst.next()) {
						count1 = rst.getInt(1);
					}

					if (count1 > 0) {
						updatepstmt2 = connection
								.prepareStatement(TransportUtilConstants.MAP_DRIVER_VEHICLE_WHILE_UPDATE);
						updatepstmt2
								.setString(1, transportForm.getDrivercode());
						updatepstmt2.setString(2,
								transportForm.getUpdateVehicleCode());
						updatepstmt2.setString(3, createUser);
						updatepstmt2.setString(4,
								transportForm.getUpdateVehicleCode());

						updatepstmt2.executeUpdate();
					} else {
						updatepstmt2 = connection
								.prepareStatement(TransportUtilConstants.MAP_DRIVER_VEHICLE_INSERTING);
						updatepstmt2
								.setString(1, transportForm.getDrivercode());
						updatepstmt2.setString(2,
								transportForm.getUpdateVehicleCode());
						updatepstmt2.setString(3, createUser);
						updatepstmt2.executeUpdate();
					}

				}
				pstmt4 = connection
						.prepareStatement(TransportUtilConstants.CHECK_VEHICLE_MAPPING);
				pstmt4.setString(1, transportForm.getUpdateVehicleCode());
				ResultSet rs = pstmt4.executeQuery();
				int cou = 0;
				while (rs.next()) {
					cou = rs.getInt(1);
				}
				if (cou > 0) {
					pstmt3 = connection
							.prepareStatement(TransportUtilConstants.MAP_DRIVER_VEHICLE_ROUTE_MAPPING_UPDATING);
					pstmt3.setString(1, transportForm.getRoutecode());
					pstmt3.setString(2, transportForm.getUpdateVehicleCode());
					pstmt3.setString(3, createUser);
					pstmt3.setString(4, transportForm.getUpdateVehicleCode());
					pstmt3.executeUpdate();
				} else {
					pstmt3 = connection
							.prepareStatement(TransportUtilConstants.MAP_DRIVER_VEHICLE_ROUTE_MAPPING);
					pstmt3.setString(1, transportForm.getRoutecode());
					pstmt3.setString(2, transportForm.getUpdateVehicleCode());
					pstmt3.setString(3, createUser);
					pstmt3.executeUpdate();
				}

			}

			if (count > 0) {
				status = true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : saveVehicleDetails  Ending");
		return status;
	}

	public boolean checkingVehicleInsuranceDate(VehicleDetailsVO vehiclecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : checkingVehicleInsuranceDate Starting");
		int count = 0;
		boolean status = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();

			pstmt = connection
					.prepareStatement(TransportUtilConstants.CHECKING_VEHICLE_INSURANCE_DATE);
			pstmt.setString(1, vehiclecode.getVehiclecode());
			pstmt.setString(2, HelperClass.convertUIToDatabase(vehiclecode
					.getIssueddate()));
			pstmt.setString(3, HelperClass.convertUIToDatabase(vehiclecode
					.getExpirydate()));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				status = true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : checkingVehicleInsuranceDate  Ending");
		return status;
	}

	public VehicleDetailsVO getSingleVehicleDetails(String vehiclecode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getSingleVehicleDetails Starting");
		int count = 0;
		boolean status = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		VehicleDetailsVO obj = null;
		try {
			connection = JDBCConnection.getSeparateConnection();

			pstmt = connection
					.prepareStatement(TransportUtilConstants.GET_VEHCILE_INSURANCE_DETAILS);
			pstmt.setString(1, vehiclecode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				obj = new VehicleDetailsVO();
				obj.setVehiclecode(rs.getString("VehicleCode"));
				obj.setVehicleregno(rs.getString("Vehicle_Reg_No"));
				obj.setVehiclename(rs.getString("VehicleName"));
				obj.setVehicletype(rs.getString("VehicleType"));
				obj.setTypeofbody(rs.getString("Type_Of_Body"));
				obj.setMakersname(rs.getString("Makers_name"));
				obj.setManufacturerdate(HelperClass.convertDatabaseToUI(rs
						.getString("Manifacture_Date")));
				obj.setChassisno(rs.getString("Chassis_No"));
				obj.setSettingcapacity(rs.getString("Seating_Capacity"));
				obj.setFuelusedintheengine(rs.getString("Fuel_Type"));
				obj.setColorofbody(rs.getString("Body_Color"));
				obj.setCompanyname(rs.getString("CompanyName"));
				obj.setIssueddate(HelperClass.convertDatabaseToUI(rs
						.getString("IssuedDate")));
				obj.setExpirydate(HelperClass.convertDatabaseToUI(rs
						.getString("ExpiryDate")));
				obj.setDoneby(rs.getString("doneby"));

				obj.setStatus("update");

			}

			System.out.println("regditration no in dao "
					+ obj.getVehicleregno());

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getSingleVehicleDetails  Ending");
		return obj;
	}

	public boolean deleteVehicleDetails(String vehiclecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : deleteVehicleDetails Starting");
		int count = 0;
		boolean status = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		VehicleDetailsVO obj = null;
		try {
			connection = JDBCConnection.getSeparateConnection();

			pstmt = connection
					.prepareStatement(TransportUtilConstants.DELETE_VEHICLE_DETAILS);
			pstmt.setString(1, vehiclecode);
			count = pstmt.executeUpdate();

			pstmt = connection
					.prepareStatement(TransportUtilConstants.DELETE_INSURANCE_DETAILS);
			pstmt.setString(1, vehiclecode);
			count = pstmt.executeUpdate();

			if (count > 0) {
				status = true;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : deleteVehicleDetails  Ending");
		return status;
	}

	public boolean registernumberValidation(String vehicleregno) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : registernumberValidation Starting");
		int count = 0;
		boolean status = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();

			pstmt = connection
					.prepareStatement(TransportUtilConstants.VALIDATE_VEHICLE_REG_NO);

			pstmt.setString(1, vehicleregno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				status = true;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : registernumberValidation  Ending");
		return status;
	}

	public boolean updateregisternumberValidation(String vehicleregno,
			String vehicleCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : updateregisternumberValidation Starting");
		int count = 0;
		boolean status = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TransportUtilConstants.VALIDATE_UPDATE_VEHICLE_REG_NO);

			pstmt.setString(1, vehicleregno);
			pstmt.setString(2, vehicleCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				status = true;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : updateregisternumberValidation  Ending");

		return status;
	}

	public boolean chassisnovalidationvalidation(String chassisno) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : chassisnovalidationvalidation Starting");
		boolean status = false;
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		try {

			connection = JDBCConnection.getSeparateConnection();

			pstmt = connection
					.prepareStatement(TransportUtilConstants.VALIDATE_VEHICLE_CHASSIS_NO);

			pstmt.setString(1, chassisno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				status = true;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : chassisnovalidationvalidation  Ending");
		return status;
	}

	public boolean updatechassisnovalidation(String chassisno,
			String vehicleCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : updatechassisnovalidation Starting");
		int count = 0;
		boolean status = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TransportUtilConstants.VALIDATE_UPDATE_VEHICLE_CHASSIS_NO);

			pstmt.setString(1, chassisno);
			pstmt.setString(2, vehicleCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				status = true;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : updatechassisnovalidation  Ending");
		return status;
	}

	public ArrayList<VehicleDetailsVO> searchvehicledetails(String searchTerm) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : searchvehicledetails Starting");
		ArrayList<VehicleDetailsVO> getvehiclelist = new ArrayList<VehicleDetailsVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		int sno = 0;
		try {
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TransportUtilConstants.SEARCH_VEHICLE_DETAILS);
			pstmt.setString(1, "%" + searchTerm + "%");
			pstmt.setString(2, "%" + searchTerm + "%");
			pstmt.setString(3, "%" + searchTerm + "%");
			pstmt.setString(4, "%" + searchTerm + "%");
			pstmt.setString(5, "%" + searchTerm + "%");
			pstmt.setString(6, "%" + searchTerm + "%");
			pstmt.setString(7, "%" + searchTerm + "%");
			pstmt.setString(8, "%" + searchTerm + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				sno++;
				VehicleDetailsVO detailsVO = new VehicleDetailsVO();
				detailsVO.setSno(String.valueOf(sno));
				detailsVO.setVehiclecode(rs.getString("VehicleCode"));
				detailsVO.setVehicleregno(rs.getString("Vehicle_Reg_No"));
				detailsVO.setVehiclename(rs.getString("VehicleName"));
				detailsVO.setVehicletype(rs.getString("VehicleType"));
				detailsVO.setTypeofbody(rs.getString("Type_Of_Body"));
				detailsVO.setMakersname(rs.getString("Makers_name"));
				detailsVO.setManufacturerdate(HelperClass
						.convertDatabaseToUI(rs.getString("Manifacture_Date")));
				detailsVO.setChassisno(rs.getString("Chassis_No"));
				detailsVO.setSettingcapacity(rs.getString("Seating_Capacity"));
				detailsVO.setFuelusedintheengine(rs.getString("Fuel_Type"));
				detailsVO.setColorofbody(rs.getString("Body_Color"));

				getvehiclelist.add(detailsVO);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : searchvehicledetails  Ending");
		return getvehiclelist;
	}

	public boolean checkforduplicateAddTime(VehicleDetailsVO obj) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : updatechassisnovalidation Starting");
		int count = 0;
		boolean status = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TransportUtilConstants.CHECK_FOR_DUPLICATE_ADD_TIME);

			pstmt.setString(1, obj.getVehicleregno());
			pstmt.setString(2, obj.getVehiclename());
			pstmt.setString(3, obj.getVehicletype());
			pstmt.setString(4, obj.getTypeofbody());
			pstmt.setString(5, obj.getMakersname());
			pstmt.setString(6,
					HelperClass.convertUIToDatabase(obj.getManufacturerdate()));
			pstmt.setString(7, obj.getChassisno());
			pstmt.setString(8, obj.getFuelusedintheengine());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				status = true;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : updatechassisnovalidation  Ending");
		return status;

	}

	public boolean checkforduplicateUpdateTime(VehicleDetailsVO obj) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : checkforduplicateUpdateTime Starting");
		int count = 0;
		boolean status = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TransportUtilConstants.CHECK_FOR_DUPLICATE_UPDATE_TIME);

			pstmt.setString(1, obj.getVehicleregno());
			pstmt.setString(2, obj.getVehiclename());
			pstmt.setString(3, obj.getVehicletype());
			pstmt.setString(4, obj.getTypeofbody());
			pstmt.setString(5, obj.getMakersname());
			pstmt.setString(6,
					HelperClass.convertUIToDatabase(obj.getManufacturerdate()));
			pstmt.setString(7, obj.getChassisno());
			pstmt.setString(8, obj.getFuelusedintheengine());
			pstmt.setString(9, obj.getVehiclecode());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				status = true;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : checkforduplicateUpdateTime  Ending");
		return status;

	}

	// route master start
	public List<TransportPojo> getTransportMasterDaoDetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportSetupDaoImpl: getTransportMasterDaoDetails Starting");
		ArrayList<TransportPojo> tpMasterPojoList = new ArrayList<TransportPojo>();
		PreparedStatement pstmt = null;
		TransportPojo obj = null;
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TransportUtilConstants.ROUTE_ALLLISTDATAS);
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
				while (resultSet.next()) {

					obj = new TransportPojo();
					obj.setRouteName(resultSet.getString("RouteName"));
					obj.setRouteNo(resultSet.getString("Route_No"));
					obj.setRouteCode(resultSet.getString("RouteCode"));
					obj.setStartTime(resultSet.getString("Start_Time"));
					obj.setEndTime(resultSet.getString("End_Time"));
					obj.setTotalStops(resultSet.getString("Total_Stops"));
					obj.setTotalDistance(resultSet.getString("TotalDistance"));
					obj.setHalttime(resultSet.getString("HaltTime"));
					obj.setDestination(resultSet.getString("Destination"));

					tpMasterPojoList.add(obj);
				}
			}
		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeSetupDaoImpl: getRouteMasterDaoDetails Ending");
		return tpMasterPojoList;
	}

	public String insertRouteMasterDetails(TransportPojo tpPojo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeSetupDaoImpl: insertRouteMasterDetails Starting");
		String result_Status = null;

		PreparedStatement pstmt = null;
		int result1 = 0;
		Connection connection = null;
		PreparedStatement pstmt1 = null;
		Connection conn = null;
		ResultSet rs = null;
		int count = 0;
		try {

			connection = JDBCConnection.getSeparateConnection();

			if ("NULL".equalsIgnoreCase(tpPojo.getCheck())) {

				conn = JDBCConnection.getSeparateConnection();
				pstmt1 = conn
						.prepareStatement(TransportUtilConstants.TRANSPORT_ROUTECHECK);
				pstmt1.setString(1, tpPojo.getRouteNo());
				rs = pstmt1.executeQuery();

				while (rs.next()) {
					count = rs.getInt(1);
				}
				if (count == 0) {
					pstmt = connection
							.prepareStatement(TransportUtilConstants.ROUTE_INSERT);
					pstmt.setString(1, tpPojo.getRouteCode());
					pstmt.setString(2, tpPojo.getRouteName());
					pstmt.setString(3, tpPojo.getRouteNo());
					pstmt.setString(4, tpPojo.getRouteLogicName());
					pstmt.setString(5, tpPojo.getDestination());
					pstmt.setString(6, tpPojo.getHalttime());
					pstmt.setString(7, tpPojo.getStartTime());
					pstmt.setString(8, tpPojo.getEndTime());
					pstmt.setString(9, tpPojo.getTotalStops());
					pstmt.setString(10, tpPojo.getTotalDistance());
					pstmt.setTimestamp(11, HelperClass.getCurrentTimestamp());
					pstmt.setString(12, tpPojo.getCreateUser());
					result1 = pstmt.executeUpdate();
					if (result1 > 0) {
						result_Status = MessageConstants.SUCCESS;
					} else {
						result_Status = MessageConstants.FAILD;
					}
				}

			} else {

				pstmt = connection
						.prepareStatement(TransportUtilConstants.ROUTE_UPDATEROUTEMASTER);
				pstmt.setString(1, tpPojo.getRouteName());
				pstmt.setString(2, tpPojo.getRouteNo());

				pstmt.setString(3, tpPojo.getRouteLogicName());
				pstmt.setString(4, tpPojo.getDestination());
				pstmt.setString(5, tpPojo.getHalttime());
				pstmt.setString(6, tpPojo.getStartTime());
				pstmt.setString(7, tpPojo.getEndTime());
				pstmt.setString(8, tpPojo.getTotalStops());
				pstmt.setString(9, tpPojo.getTotalDistance());
				pstmt.setTimestamp(10, HelperClass.getCurrentTimestamp());
				pstmt.setString(11, tpPojo.getCreateUser());
				pstmt.setString(12, tpPojo.getRouteCode());
				result1 = pstmt.executeUpdate();
				if (result1 > 0) {
					result_Status = MessageConstants.SUCCESS;
				} else {
					result_Status = MessageConstants.FAILD;
				}

			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}
			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RouteSetupDaoImpl: insertRouteMasterDetails Ending");

		return result_Status;
	}

	@Override
	public int getTpRouteCheckDao(String tpName) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RouteSetupDaoImpl: getRouteCheckDao Starting");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();

			pstmt = (PreparedStatement) JDBCConnection
					.getStatement(TransportUtilConstants.TRANSPORT_ROUTECHECK);
			pstmt.setString(1, tpName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeSetupDaoImpl: getFeeNameCheckDao Ending");
		return count;
	}

	public boolean removeRouteMasterDetails(TransportPojo tpMasterPojo) {
		PreparedStatement pstmt = null;
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeSetupDaoImpl: removeRouteMasterDetails Starting");
		int count = 0;
		boolean status = false;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();

			pstmt = connection
					.prepareStatement(TransportUtilConstants.ROUTE_REMOVEFEE);
			pstmt.setString(1, tpMasterPojo.getRouteCode());
			count = pstmt.executeUpdate();

			if (count > 0) {
				status = true;
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}
			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RouteSetupDaoImpl: removeRouteMasterDetails Ending");
		return status;
	}

	@Override
	public boolean addRoute(TransportForm routeForm) {
		boolean status = false;

		PreparedStatement pstm = null;
		Connection connection = null;
		int result = 0;
		try {

			connection = JDBCConnection.getSeparateConnection();

			if (routeForm.getRouteCode() != null) {

				String noArray[] = routeForm.getStopNoArray().trim().split(",");
				String nameArray[] = routeForm.getStopNameArray().trim()
						.split(",");
				String arrivalArray[] = routeForm.getStopArrivalTimeArray()
						.trim().split(",");
				String haltArray[] = routeForm.getStopHaltTimeArray().trim()
						.split(",");
				String deptArray[] = routeForm.getStopDepartureTimeArray()
						.trim().split(",");
				String distArray[] = routeForm.getStopDistanceArray()
						.split(",");

				for (int i = 0; i < noArray.length; i++) {

					pstm = connection
							.prepareStatement(TransportUtilConstants.ADD_ROUTE_STOPDETAILS);
					pstm.setString(
							1,
							IDGenerator.getPrimaryKeyID(
									"transport_stopsdetails").trim());
					pstm.setString(2, routeForm.getRouteCode());

					pstm.setString(3, nameArray[i].trim());
					pstm.setString(4, arrivalArray[i].trim());
					pstm.setString(5, haltArray[i].trim());
					pstm.setString(6, deptArray[i].trim());
					pstm.setDouble(7,
							Double.parseDouble(distArray[i].toString()));
					result = pstm.executeUpdate();

				}

			}

		}

		catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null && (!pstm.isClosed())) {
					pstm.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		if (result == 1) {
			status = true;
		} else {
			status = false;
		}

		return status;

	}

	public boolean checkrouteNo(TransportPojo Pojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : checkrouteNo Starting");
		int count = 0;
		boolean status = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		try {

			if ("NULL".equalsIgnoreCase((Pojo.getRouteCode()))) {
				connection = JDBCConnection.getSeparateConnection();

				pstmt = connection
						.prepareStatement(TransportUtilConstants.TRANSPORT_ROUTECHECK);

				pstmt.setString(1, Pojo.getRouteNo());

				rs = pstmt.executeQuery();

				while (rs.next()) {
					count = rs.getInt(1);
				}
				if (count > 0) {
					status = true;
				}
			} else {
				connection = JDBCConnection.getSeparateConnection();

				pstmt = connection
						.prepareStatement(TransportUtilConstants.TRANSPORT_ROUTECHECK_WHILE_UPDATING);

				pstmt.setString(1, Pojo.getRouteNo());
				pstmt.setString(2, Pojo.getRouteCode());
				System.out.println(pstmt);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					count = rs.getInt(1);
				}
				if (count > 0) {
					status = true;
				}
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : checkrouteNo  Ending");
		return status;
	}

	public TransportVo editRouteMasterDetails(TransportPojo tpMasterPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : editRouteMasterDetails Starting");
		TransportVo obj = new TransportVo();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TransportUtilConstants.ETID_ROUTE_ALLLISTDATAS);

			pstmt.setString(1, tpMasterPojo.getRouteCode());

			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
				while (resultSet.next()) {
					obj.setRouteName(resultSet.getString("RouteName"));
					obj.setRouteNo(resultSet.getString("Route_No"));
					obj.setRouteCode(resultSet.getString("RouteCode"));
					obj.setRouteLogicName(resultSet
							.getString("Route_logical_name"));
					obj.setDestination((resultSet.getString("Destination")));
					obj.setHalttime(resultSet.getString("HaltTime"));
					obj.setStratTime(resultSet.getString("Start_Time"));
					obj.setEndTime(resultSet.getString("End_Time"));
					obj.setTotalStops(resultSet.getString("Total_Stops"));
					obj.setTotalDistance(resultSet.getString("TotalDistance"));
				}
			}
		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : editRouteMasterDetails  Ending");

		return obj;
	}

	public List<TransportVo> searchDetails(TransportPojo pojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : searchDetails Starting");
		ArrayList<TransportVo> tpMasterList = new ArrayList<TransportVo>();
		PreparedStatement pstmt = null;
		TransportVo obj = null;
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TransportUtilConstants.ROUTE_SEARCHLISTDATAS);
			pstmt.setString(1, "%" + pojo.getRouteName() + "%");
			pstmt.setString(2, "%" + pojo.getRouteName() + "%");
			pstmt.setString(3, "%" + pojo.getRouteName() + "%");
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
				while (resultSet.next()) {
					obj = new TransportVo();
					obj.setRouteName(resultSet.getString("RouteName"));
					obj.setRouteNo(resultSet.getString("Route_No"));
					obj.setRouteCode(resultSet.getString("RouteCode"));
					obj.setRouteLogicName(resultSet
							.getString("Route_logical_name"));
					obj.setRouteType(resultSet.getString("RouteType"));
					obj.setCostPerPerson(resultSet.getString("Cost_per_person"));
					obj.setStratTime(resultSet.getString("Start_Time"));
					obj.setEndTime(resultSet.getString("End_Time"));
					obj.setTotalStops(resultSet.getString("Total_Stops"));
					obj.setTotalDistance(resultSet.getString("TotalDistance"));
					tpMasterList.add(obj);
				}
			}
		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : searchDetails  Ending");

		return tpMasterList;

	}

	public ArrayList<DriverMsaterListVo> getdriverListDao() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getdriverListDao Starting");

		System.out.println("driver dao");

		ArrayList<DriverMsaterListVo> driverlist = new ArrayList<DriverMsaterListVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TransportUtilConstants.GET_DRIVER_LIST);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				DriverMsaterListVo listvo = new DriverMsaterListVo();
				String IssuedDate = "";
				String validity = "";
				String dlno = "";

				if (rs.getString("DLIssuedDate") != null
						&& !rs.getString("DLIssuedDate").isEmpty()) {
					IssuedDate = HelperClass.convertDatabaseToUI(rs
							.getString("DLIssuedDate"));

				}

				if (rs.getString("DLExpirayDate") != null
						&& !rs.getString("DLExpirayDate").isEmpty()) {
					validity = HelperClass.convertDatabaseToUI(rs
							.getString("DLExpirayDate"));

				}

				if (rs.getString("DLNo") != null
						&& !rs.getString("DLNo").isEmpty()) {
					dlno = rs.getString("DLNo");

				}

				listvo.setType(rs.getString("type"));
				listvo.setDriverName(rs.getString("Name"));
				listvo.setDateofBirth(HelperClass.convertDatabaseToUI(rs
						.getString("DOB")));
				listvo.setDateofJoin(HelperClass.convertDatabaseToUI(rs
						.getString("DOJ")));
				listvo.setMobile(rs.getString("MobileNo"));
				listvo.setDrivingliecenseNo(dlno);
				listvo.setDriverCode(rs.getString("DriverCode"));
				listvo.setFather_name(rs.getString("FatherName"));
				listvo.setEmerg_contact(rs.getString("EmergencyContactNo"));
				listvo.setAddress(rs.getString("Address"));
				listvo.setAge(rs.getString("Age"));
				listvo.setGender(rs.getString("Gender"));
				listvo.setDl_issued_date(IssuedDate);
				listvo.setDl_validity(validity);
				listvo.setLicense(rs.getString("LicencetoDrive"));
				listvo.setExperience(rs.getString("Experience"));
				driverlist.add(listvo);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getdriverListDao  Ending");
		return driverlist;
	}

	public int addDriverDao(DriverMsaterListVo drivervo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : addDriverDao Starting");

		PreparedStatement pstmt = null;
		java.util.Date today = new java.util.Date();
		java.sql.Timestamp time_stamp = new java.sql.Timestamp(today.getTime());
		Connection connection = null;
		int result = 0;
		int rs = 0;
		try {

			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TransportUtilConstants.ADD_DRIVER);

			pstmt.setString(1, IDGenerator.getPrimaryKeyID("transport_driver"));
			pstmt.setString(2, "driver");
			pstmt.setString(3, drivervo.getDriverName());
			pstmt.setString(4, drivervo.getFather_name());
			pstmt.setString(5,
					HelperClass.convertUIToDatabase(drivervo.getDateofBirth()));
			pstmt.setString(6, drivervo.getMobile());
			pstmt.setString(7, drivervo.getEmerg_contact());
			pstmt.setString(8, drivervo.getAddress());
			pstmt.setString(9,
					HelperClass.convertUIToDatabase(drivervo.getDateofJoin()));
			pstmt.setString(10, drivervo.getAge());
			pstmt.setString(11, drivervo.getGender());
			pstmt.setString(12, drivervo.getDrivingliecenseNo());
			pstmt.setString(13, HelperClass.convertUIToDatabase(drivervo
					.getDl_issued_date()));
			pstmt.setString(14,
					HelperClass.convertUIToDatabase(drivervo.getDl_validity()));
			pstmt.setString(15, drivervo.getLicense());
			pstmt.setTimestamp(16, time_stamp);
			pstmt.setString(17, drivervo.getCreateUser());
			pstmt.setString(18, drivervo.getExperience());

			rs = pstmt.executeUpdate();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : addDriverDao  Ending");
		return result;
	}

	public DriverMsaterListVo editDriverDao(DriverMsaterListVo drivervo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : editDriverDao Starting");

		DriverMsaterListVo driverobj = null;
		Connection conn = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			driverobj = new DriverMsaterListVo();
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TransportUtilConstants.GET_DRIVER_DETAILS);

			pstmt.setString(1, drivervo.getDriverCode());
			rs = pstmt.executeQuery();

			while (rs.next()) {

				driverobj.setDriverCode(rs.getString("DriverCode"));
				driverobj.setDriverName(rs.getString("Name"));
				driverobj.setFather_name(rs.getString("FatherName"));
				driverobj.setDateofBirth(HelperClass.convertDatabaseToUI(rs
						.getString("DOB")));
				driverobj.setMobile(rs.getString("MobileNo"));
				driverobj.setEmerg_contact(rs.getString("EmergencyContactNo"));
				driverobj.setExperience(rs.getString("Experience"));
				driverobj.setAddress(rs.getString("Address"));
				driverobj.setDateofJoin(HelperClass.convertDatabaseToUI(rs
						.getString("DOJ")));
				driverobj.setAge(rs.getString("Age"));
				driverobj.setGender(rs.getString("Gender"));
				driverobj.setDrivingliecenseNo(rs.getString("DLNo"));
				driverobj.setDl_issued_date(HelperClass.convertDatabaseToUI(rs
						.getString("DLIssuedDate")));
				driverobj.setDl_validity(HelperClass.convertDatabaseToUI(rs
						.getString("DLExpirayDate")));
				driverobj.setLicense(rs.getString("LicencetoDrive"));

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		finally {
			try {

				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : editDriverDao  Ending");

		return driverobj;
	}

	public String deleteDriverDao(DriverMsaterListVo drivervo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : deleteDriverDao Starting");

		PreparedStatement pstmt = null;
		String check = "";
		int streamcount = 0;
		String drivecode = drivervo.getDriverCode();
		int count = 0;
		Connection conn = null;
		ResultSet rs = null;

		try {

			if (streamcount == 0) {
				conn = JDBCConnection.getSeparateConnection();
				pstmt = conn
						.prepareStatement(TransportUtilConstants.DELETE_DRIVER);
				pstmt.setString(1, drivecode);

				count = pstmt.executeUpdate();

				if (count > 0) {

					check = MessageConstants.DELETE_SUCCESS_DRIVER;
				} else {
					check = MessageConstants.DELETE_FAIL_DRIVER;
				}
			} else {

				check = MessageConstants.DELETE_WARNING_DRIVER;

			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : deleteDriverDao  Ending");

		return null;
	}

	public ArrayList<DriverMsaterListVo> searchDriverDao(String searchName) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : searchDriverDao Starting");

		ArrayList<DriverMsaterListVo> driverlist = new ArrayList<DriverMsaterListVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		int sno = 0;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TransportUtilConstants.SEARCH_DRIVER_DETAILS);

			pstmt.setString(1, "%" + searchName + "%");
			pstmt.setString(2, "%" + searchName + "%");
			pstmt.setString(3, "%" + searchName + "%");
			pstmt.setString(4, "%" + searchName + "%");
			pstmt.setString(5, "%" + searchName + "%");
			pstmt.setString(6, "%" + searchName + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				sno++;
				DriverMsaterListVo driverobj = new DriverMsaterListVo();

				driverobj.setSno(String.valueOf(sno));
				// driverobj.setDriverCode(rs.getString("DriverCode"));
				driverobj.setDriverName(rs.getString("Name"));
				driverobj.setDateofJoin(rs.getString("DOJ"));
				driverobj.setMobile(rs.getString("MobileNo"));
				driverobj.setDrivingliecenseNo(rs.getString("DLNo"));
				driverobj.setDl_issued_date(rs.getString("DLIssuedDate"));
				driverobj.setDl_validity(rs.getString("DLExpirayDate"));

				driverlist.add(driverobj);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : searchDriverDao  Ending");
		return driverlist;
	}

	public int updateDriverDao(DriverMsaterListVo drivervo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : updateDriverDao Starting");

		PreparedStatement pstmt = null;
		java.util.Date today = new java.util.Date();
		java.sql.Timestamp time_stamp = new java.sql.Timestamp(today.getTime());
		int result = 0;
		Connection connection = null;

		try {

			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TransportUtilConstants.UPDATE_DRIVER);

			/* pstmt.setString(1, drivervo.getType()); */
			pstmt.setString(1, drivervo.getDriverName());
			pstmt.setString(2, drivervo.getFather_name());
			pstmt.setString(3,
					HelperClass.convertUIToDatabase(drivervo.getDateofBirth()));
			pstmt.setString(4, drivervo.getMobile());
			pstmt.setString(5, drivervo.getEmerg_contact());
			pstmt.setString(6, drivervo.getAddress());
			pstmt.setString(7,
					HelperClass.convertUIToDatabase(drivervo.getDateofJoin()));
			pstmt.setString(8, drivervo.getAge());
			pstmt.setString(9, drivervo.getGender());
			pstmt.setString(10, drivervo.getDrivingliecenseNo());
			pstmt.setString(11, HelperClass.convertUIToDatabase(drivervo
					.getDl_issued_date()));
			pstmt.setString(12,
					HelperClass.convertUIToDatabase(drivervo.getDl_validity()));
			pstmt.setString(13, drivervo.getLicense());
			pstmt.setTimestamp(14, time_stamp);
			pstmt.setString(15, drivervo.getCreateUser());
			pstmt.setString(16, drivervo.getExperience());
			pstmt.setString(17, drivervo.getDriverCode());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : updateDriverDao  Ending");
		return result;
	}

	public boolean validateDriverDao(DriverMsaterListVo drivervo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : validateDriverDao Starting");

		boolean driver_validate = false;

		int count = 0;
		PreparedStatement pscheckExamName = null;
		ResultSet rsCheckExamName = null;
		Connection conn = null;

		try {

			conn = JDBCConnection.getSeparateConnection();

			pscheckExamName = conn
					.prepareStatement(TransportUtilConstants.VALIDATE_DRIVER);

			pscheckExamName.setString(1, drivervo.getDriverName());
			pscheckExamName.setString(2, drivervo.getDateofBirth());
			pscheckExamName.setString(3, drivervo.getMobile());
			pscheckExamName.setString(4, drivervo.getAddress());
			pscheckExamName.setString(5, drivervo.getDateofJoin());

			rsCheckExamName = pscheckExamName.executeQuery();

			while (rsCheckExamName.next()) {

				count = rsCheckExamName.getInt(1);

			}

			if (count > 0) {

				driver_validate = true;

			} else {

				driver_validate = false;
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : validateDriverDao  Ending");

		return driver_validate;
	}

	public ArrayList<DriverMsaterListVo> getDriverNamesDetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getDriverNamesDetails Starting");
		ArrayList<DriverMsaterListVo> driverlist = new ArrayList<DriverMsaterListVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TransportUtilConstants.GET_UNMAPPED_DRIVER_DETAILS);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				DriverMsaterListVo listVo = new DriverMsaterListVo();

				listVo.setDriverCode(rs.getString("DriverCode"));
				listVo.setDriverName(rs.getString("Name"));
				driverlist.add(listVo);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getDriverNamesDetails  Ending");
		return driverlist;

	}

	public ArrayList<DriverMsaterListVo> getDriverEntireDetails(String driverid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getDriverEntireDetails Starting");
		ArrayList<DriverMsaterListVo> driverlist = new ArrayList<DriverMsaterListVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TransportUtilConstants.GET_DRIVER_DETAILS_BY_ID);
			pstmt.setString(1, driverid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				DriverMsaterListVo listVo = new DriverMsaterListVo();

				listVo.setDriverCode(rs.getString("DriverCode"));
				listVo.setDriverName(rs.getString("Name"));
				listVo.setMobile(rs.getString("MobileNo"));
				listVo.setExperience(rs.getString("Experience"));
				listVo.setDateofJoin(HelperClass.convertDatabaseToUI(rs
						.getString("DOJ")));
				listVo.setDrivingliecenseNo(rs.getString("DLNo"));
				listVo.setDl_issued_date(HelperClass.convertDatabaseToUI(rs
						.getString("DLIssuedDate")));
				listVo.setDl_validity(HelperClass.convertDatabaseToUI(rs
						.getString("DLExpirayDate")));
				listVo.setLicense(rs.getString("LicencetoDrive"));
				driverlist.add(listVo);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getDriverEntireDetails  Ending");

		return driverlist;

	}

	public ArrayList<DriverMsaterListVo> getDriverDetailsWhileUpdate(
			String vehiclecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getDriverDetailsWhileUpdate Starting");
		ArrayList<DriverMsaterListVo> driverlist = new ArrayList<DriverMsaterListVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TransportUtilConstants.GET_UNMAPPED_DRIVER_DETAILS_WHILE_UPDATE);
			pstmt.setString(1, vehiclecode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				DriverMsaterListVo listVo = new DriverMsaterListVo();

				listVo.setDriverCode(rs.getString("DriverCode"));
				listVo.setDriverName(rs.getString("Name"));
				driverlist.add(listVo);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getDriverDetailsWhileUpdate  Ending");
		return driverlist;

	}

	public DriverMsaterListVo getSingleDriverDetails(String vehiclecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getSingleDriverDetails Starting");
		DriverMsaterListVo driverlist = new DriverMsaterListVo();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TransportUtilConstants.GET_SINGLE_DRIVER_DETAILS);
			pstmt.setString(1, vehiclecode);
			pstmt.setString(2, vehiclecode);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				driverlist.setDriverCode(rs.getString("DriverCode"));
				driverlist.setDriverName(rs.getString("Name"));
				driverlist.setMobile(rs.getString("MobileNo"));
				driverlist.setExperience(rs.getString("Experience"));
				driverlist.setDateofJoin(HelperClass.convertDatabaseToUI(rs
						.getString("DOJ")));
				driverlist.setDrivingliecenseNo(rs.getString("DLNo"));
				driverlist.setDl_issued_date(HelperClass.convertDatabaseToUI(rs
						.getString("DLIssuedDate")));
				driverlist.setDl_validity(HelperClass.convertDatabaseToUI(rs
						.getString("DLExpirayDate")));
				driverlist.setLicense(rs.getString("LicencetoDrive"));
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getSingleDriverDetails  Ending");

		return driverlist;

	}

	public ArrayList<StageMasterVo> getStopNames(String searchTerm) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getStopNames Starting");
		ArrayList<StageMasterVo> stoplist = new ArrayList<StageMasterVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TransportUtilConstants.GET_STOP_NAMES);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				StageMasterVo stopvo = new StageMasterVo();
				stopvo.setStageCode(rs.getString("stage_id"));
				stopvo.setStageName(rs.getString("stage_name"));
				stoplist.add(stopvo);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getStopNames  Ending");

		return stoplist;

	}

	public ArrayList<TransportVo> getRouteDetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getRouteDetails Starting");
		ArrayList<TransportVo> transportlist = new ArrayList<TransportVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TransportUtilConstants.GET_ROUTE_NAMES);

			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TransportVo vo = new TransportVo();
				vo.setRouteCode(rs.getString("RouteCode"));
				vo.setRouteName(rs.getString("RouteName"));
				transportlist.add(vo);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getRouteDetails  Ending");

		return transportlist;
	}

	public ArrayList<TransportVo> GetRouteEntireDetails(String route) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : GetRouteEntireDetails Starting");
		ArrayList<TransportVo> transportlist = new ArrayList<TransportVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TransportUtilConstants.GET_ROUTE_DETAILS);
			pstmt.setString(1, route);

			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TransportVo vo = new TransportVo();
				vo.setRouteCode(rs.getString("RouteCode"));
				vo.setRouteName(rs.getString("RouteName"));
				vo.setTotalDistance(rs.getString("TotalDistance"));
				vo.setRouteCode(rs.getString("Route_No"));
				vo.setTotalStops(rs.getString("Total_Stops"));
				vo.setDestination(rs.getString("Destination"));
				vo.setHalttime(rs.getString("HaltTime"));
				transportlist.add(vo);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : GetRouteEntireDetails  Ending");

		return transportlist;

	}

	public TransportVo getRouteDetails(String vehiclecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getRouteDetails Starting");
		TransportVo vo = new TransportVo();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TransportUtilConstants.GET_ROUTE_DETAILS_EDIT);
			pstmt.setString(1, vehiclecode);

			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setRouteCode(rs.getString("RouteCode"));
				vo.setRouteName(rs.getString("RouteName"));
				vo.setTotalDistance(rs.getString("TotalDistance"));
				vo.setRouteNo(rs.getString("Route_No"));
				vo.setTotalStops(rs.getString("Total_Stops"));
				vo.setDestination(rs.getString("Destination"));
				vo.setHalttime(rs.getString("HaltTime"));
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportServiceImpl : getRouteDetails  Ending");

		return vo;

	}

	@Override
	public List<TransportPojo> getTransportMasterDaoDetailsXLS() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportSetupDaoImpl: getTransportMasterDaoDetails Starting");
		ArrayList<TransportPojo> tpMasterPojoList = new ArrayList<TransportPojo>();
		PreparedStatement pstmt = null;
		TransportPojo obj = null;
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			System.out.println("DownloadDAOIMPLis WORKING");
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TransportUtilConstants.ROUTE_ALLLISTDATASTOP);
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
				while (resultSet.next()) {

					obj = new TransportPojo();
					obj.setRouteName(resultSet.getString("RouteName"));
					obj.setRouteNo(resultSet.getString("Route_No"));
					obj.setRouteCode(resultSet.getString("RouteCode"));
					obj.setStartTime(resultSet.getString("Start_Time"));
					obj.setEndTime(resultSet.getString("End_Time"));
					obj.setTotalStops(resultSet.getString("Total_Stops"));
					obj.setTotalDistance(resultSet.getString("TotalDistance"));
					obj.setHalttime(resultSet.getString("HaltTime"));
					obj.setDestination(resultSet.getString("Destination"));
					obj.setStopname(resultSet.getString("Stop_Name"));
					obj.setArrivaltime(resultSet.getString("ArrivalTime"));
					obj.setDeparturetime(resultSet.getString("DepTime"));
					obj.setDistance(resultSet.getString("Distance"));
					
					System.out.println("RouteNameRouteName"+resultSet.getString("RouteName"));
					
					System.out.println(resultSet.getString("Route_No"));

					System.out.println(resultSet.getString("RouteCode"));

					System.out.println(resultSet.getString("Start_Time"));

					System.out.println(resultSet.getString("End_Time"));

					System.out.println(resultSet.getString("Total_Stops"));

					
					System.out.println(resultSet.getString("TotalDistance"));

					System.out.println(resultSet.getString("HaltTime"));

					System.out.println(resultSet.getString("Destination"));

					
					System.out.println(resultSet.getString("Stop_Name"));
					
					System.out.println(resultSet.getString("ArrivalTime"));
					
					System.out.println(resultSet.getString("DepTime"));
					
					System.out.println(resultSet.getString("Distance"));

					

					
					tpMasterPojoList.add(obj);
				}
			}
		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeSetupDaoImpl: getRouteMasterDaoDetails Ending");
		return tpMasterPojoList;
	}
}
