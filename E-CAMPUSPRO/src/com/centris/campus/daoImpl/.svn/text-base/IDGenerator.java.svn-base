package com.centris.campus.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;

public class IDGenerator {

	private static final Logger logger = Logger.getLogger(IDGenerator.class);

	public static String getPrimaryKeyID(String tableName) throws SQLException {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in IDGenerator: getPrimaryKeyID Starting");
		String NextID = null;
		try {
			tableName = tableName.trim().toLowerCase();
			int currentID = 0;
			String pre = null;
			String previousID = getPreviousID(tableName);

			if (previousID == null) {
				currentID = 0;
			} else {
				String id = previousID.substring(3);
				currentID = Integer.parseInt(id);
			}
			if (tableName.equalsIgnoreCase("campus_parents"))
				pre = "PAR";

			else if (tableName.equalsIgnoreCase("campus_department"))
				pre = "DEP";

			else if (tableName.equalsIgnoreCase("transport_vehicle")) {
				pre = "VEH";
			}

			else if (tableName.equalsIgnoreCase("campus_examination")) {
				pre = "EXM";
			}

			else if (tableName.equalsIgnoreCase("campus_comments")) {
				pre = "RMK";
			}

			else if (tableName.equalsIgnoreCase("campus_meeting")) {
				pre = "MET";
			}
			else if (tableName.equalsIgnoreCase("campus_dob_details")) {
				pre = "DOB";
			}
			else if (tableName.equalsIgnoreCase("campus_feedback")) {
				pre = "FED";
			}
			else if (tableName.equalsIgnoreCase("campus_classteacher")) {
				pre = "CTC";
			}


			else if (tableName.equalsIgnoreCase("campus_fee_master"))
				pre = "CFM";
			else if (tableName.equalsIgnoreCase("campus_acadamicyear"))
				pre = "ACY";
			else if (tableName.equalsIgnoreCase("campus_designation"))
				pre = "DES";
			else if (tableName.equalsIgnoreCase("campus_classdetail"))
				pre = "CCD";
			else if (tableName.equalsIgnoreCase("campus_role"))
				pre = "ROL";

			else if (tableName.equalsIgnoreCase("campus_subject"))
				pre = "SUB";

			else if (tableName.equalsIgnoreCase("campus_classstream"))
				pre = "CLS";

			else if (tableName.equalsIgnoreCase("campus_classsection")) {
				pre = "CCS";
			}

			else if (tableName.equalsIgnoreCase("campus_quota"))
				pre = "CQA";

			else if (tableName.equalsIgnoreCase("transport_typedetails"))
				pre = "TTD";

			else if (tableName.equalsIgnoreCase("campus_teachers"))
				pre = "TEA";

			else if (tableName.equalsIgnoreCase("campus_careers"))
				pre = "JOB";

			else if (tableName.equalsIgnoreCase("campus_fee_termdetails"))
				pre = "TRM";

			else if (tableName.equalsIgnoreCase("transport_fuel_maintainence"))
				pre = "FUE";

			else if (tableName.equalsIgnoreCase("campus_accyearplan"))
				pre = "APL";

			else if (tableName.equalsIgnoreCase("campus_remainder"))
				pre = "RDR";

			else if (tableName.equalsIgnoreCase("campus_accyearplan"))
				pre = "APL";

			else if (tableName.equalsIgnoreCase("transport_route"))
				pre = "ROU";

			else if (tableName.equalsIgnoreCase("campus_fee_stage"))
				pre = "FSM";

			else if (tableName.equalsIgnoreCase("transport_stopsdetails"))
				pre = "STO";

			else if (tableName.equalsIgnoreCase("campus_classteacher"))
				pre = "CCT";

			else if (tableName.equalsIgnoreCase("campus_student"))
				pre = "STU";

			else if (tableName.equalsIgnoreCase("transport_driver"))
				pre = "DRV";

			else if (tableName.equalsIgnoreCase("campus_fee_setup"))
				pre = "FMS";
			else if (tableName.equalsIgnoreCase("campus_fee_stagesetup"))
				pre = "SFS";
			else if (tableName.equalsIgnoreCase("campus_fee_concessiondetails"))
				pre = "CNC";
			else if (tableName.equalsIgnoreCase("campus_fee_collection"))
				pre = "CFC";
			else if (tableName.equalsIgnoreCase("campus_student_enquiry"))
				pre = "ENQ";
			else if (tableName.equalsIgnoreCase("campus_studentpromotion"))
				pre = "STP";
			else if (tableName.equalsIgnoreCase("campus_assignment"))
				pre = "ASM";
			else if (tableName.equalsIgnoreCase("campus_user"))
				pre = "USR";
			else if (tableName.equalsIgnoreCase("campus_timetable_student"))
				pre = "CST";
			else if (tableName.equalsIgnoreCase("campus_timetable_teacher"))
				pre = "CTT";
			else if (tableName.equalsIgnoreCase("campus_marks_upload"))
				pre = "CMU";
			

			else {
			}

			NextID = pre + ++currentID;
			System.out.println("New ID" + NextID);
		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.getStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in IDGenerator: getPrimaryKeyID Ending");
		return NextID;
	}

	private static String getPreviousID(String tableName) throws SQLException {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in IDGenerator: getPreviousID Starting");
		int counter = 0;
		String columnName = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String sql = "SHOW KEYS FROM " + tableName
					+ " WHERE Key_name = 'PRIMARY'";

			ps = (PreparedStatement) JDBCConnection.getStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				columnName = (String) rs.getString("Column_name");
			}
			ps.close();
			String sql2 = "select max(" + columnName + ") from " + tableName
					+ " group by length(" + columnName + ") desc limit 1";
			System.out.println(sql2);
			ps = (PreparedStatement) JDBCConnection.getStatement(sql2);
			rs = ps.executeQuery();
			while (rs.next()) {
				counter++;
				columnName = (String) rs.getString(1);
			}

			ps.close();
			if (counter == 0) {
				return null;
			} else {

			}
		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.getStackTrace();
		} finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}

				if (ps != null && !ps.isClosed()) {
					JDBCConnection.closeStatement();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in IDGenerator: getPreviousID Ending");
		return columnName;
	}
}