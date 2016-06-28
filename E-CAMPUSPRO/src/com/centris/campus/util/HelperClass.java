package com.centris.campus.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.centris.campus.admin.LstmsParents;
import com.centris.campus.admin.LstmsPrinciple;
import com.centris.campus.admin.LstmsTeachers;
import com.centris.campus.admin.lstmsUser;
import com.centris.campus.daoImpl.JDBCConnection;
import com.centris.campus.pojo.TeacherRegistrationPojo;
import com.centris.campus.vo.HelperClassVo;
import com.centris.campus.vo.UserDetailVO;

public class HelperClass {
	private static final Logger logger = Logger.getLogger(HelperClass.class);
	public static boolean con = true;

	public static Time getCurrentTime() {
		Time t = null;
		try {
			t = new Time(new Date().getTime());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return t;
	}

	public static java.sql.Date getCurrentSqlDate(String date) {
		java.util.Date sd;
		java.sql.Date currdate = null;

		try {
			sd = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			currdate = new java.sql.Date(sd.getTime());

		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return currdate;
	}

	public static java.sql.Date getCurrentSqlDate() {
		java.util.Date sd = new java.util.Date();
		java.sql.Date currdate = null;
		try {
			currdate = new java.sql.Date(sd.getTime());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return currdate;
	}

	/*
	 * public static java.sql.Date getSQLDate(java.util.Date date1){
	 * 
	 * 
	 * MessageResources res =
	 * MessageResources.getMessageResources("com.centris.tds.properties.CMS");
	 * String ConnectionString=""; String
	 * DriverName=res.getMessage("mySqlDriver");
	 * 
	 * 
	 * return ""; }
	 */
	public static Time getStringToTime(String getTime) {
		Time time = null;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date d = null;
		try {
			d = sdf.parse(getTime);
			time = new Time(d.getTime());
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return time;

	}

	public static java.sql.Date getSQLDate(java.util.Date date1) {

		java.sql.Date sqldate = new java.sql.Date(date1.getTime());
		return sqldate;
	}

	public static String getCurrentUserID(HttpServletRequest request) {

		String current_user = null;

		try {
			
			HttpSession ses = request.getSession(false);
			
			UserDetailVO userDetailsVo = (UserDetailVO)ses.getAttribute(MessageConstants.USER_DETAILS);
			
			current_user=userDetailsVo.getUserId();

			/*if (user.equalsIgnoreCase("Admin")) {
				lstmsUser Admin_user = (lstmsUser) ses
						.getAttribute(MessageConstants.USER);
				current_user = Admin_user.getId();

			} else if (user.equalsIgnoreCase("Teacher")) {
				LstmsTeachers teacher_user = (LstmsTeachers) ses
						.getAttribute(MessageConstants.USER);
				current_user = teacher_user.getTeacherId();
			} else if (user.equalsIgnoreCase("Principle")) {
				LstmsPrinciple teacher_user = (LstmsPrinciple) ses
						.getAttribute(MessageConstants.USER);
				current_user = teacher_user.getId();
			} else {
				LstmsParents parent_user = (LstmsParents) ses
						.getAttribute(MessageConstants.USER);
				current_user = parent_user.getParentId();
			}*/
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return current_user;
	}

	public static String getCurrentUser(HttpServletRequest request) {

		String user = null;

		HttpSession ses = request.getSession(false);
		try {
			user = (String) ses.getAttribute("user");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return user;
	}

	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static String getCurrentYearID() throws SQLException {

		CallableStatement proc = null;
		String accYear = null;
		ResultSet rs = null;
		Connection conn = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			proc = conn.prepareCall("{ call getCurrentAccYear() }");
			proc.execute();
			rs = proc.getResultSet();

			while (rs.next()) {
				accYear = rs.getString("ACCYEARID");

			}
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		} finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (proc != null && !proc.isClosed()) {
					proc.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}

		return accYear;
	}

	public static java.sql.Date getSqlDateFromDdMmYyFormat(String date) {
		java.util.Date sd;
		java.sql.Date currdate = null;

		try {
			sd = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			currdate = new java.sql.Date(sd.getTime());

		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return currdate;
	}

	public static String getDateFromSQLDateinDDMMYYYYFormat(java.sql.Date date) {

		String strDate = null;

		try {
			java.util.Date utildate = new Date(date.getTime());
			strDate = new SimpleDateFormat("dd-MM-yyyy").format(utildate);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return strDate;
	}

	public static String convertDatabaseToUI(String date) {

		String currdate = null;

		try {
			Date sd = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			currdate = new SimpleDateFormat("dd-MM-yyyy").format(sd);

		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return currdate;
	}

	public static String convertUIToDatabase(String date) {

		String currdate = null;

		try {
			Date sd = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			currdate = new SimpleDateFormat("yyyy-MM-dd").format(sd);

		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return currdate;
	}

	/* Written by Arul gor Getting PreviousYear */
	public static int getPreviousYear() {
		Calendar prevYear = Calendar.getInstance();
		prevYear.add(Calendar.YEAR, -1);
		return prevYear.get(Calendar.YEAR);
	}

	/* Written by Arul gor Getting NextYear */
	public static int getNextYear() {
		Calendar nextYear = Calendar.getInstance();
		nextYear.add(Calendar.YEAR, +1);
		return nextYear.get(Calendar.YEAR);
	}

	/* Written by Arul gor Getting CurrentMonthNo */
	public static int getCurrentMonthNo() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	/* Written by Arul gor Getting Current Academic Year */
	public static String getAcademicYear() {
		int currentyear = Calendar.getInstance().get(Calendar.YEAR);
		int nextYear = getNextYear();
		int prevYear = getPreviousYear();
		int currentMonth = getCurrentMonthNo();
		currentMonth = ++currentMonth;
		String accYear = null;
		if (currentMonth <= 6) {
			accYear = Integer.toString(prevYear) + "/"
					+ Integer.toString(currentyear);
		} else {
			accYear = Integer.toString(currentyear) + "/"
					+ Integer.toString(nextYear);
		}
		return accYear;
	}

	public static long getDateDifference(String startdate, String endDate) {
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		long dateDifference = 0l;
		try {
			Date sdate = sd.parse(startdate);
			long slong = sdate.getTime();
			Date edate = sd.parse(endDate);
			long elong = edate.getTime();
			dateDifference = elong - slong;
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return dateDifference;
	}

	public static String getMonthName(String month) {

		Map<String, String> monthMap = new HashMap<String, String>();
		monthMap.put("01", "Jan");
		monthMap.put("02", "Feb");
		monthMap.put("03", "Mar");
		monthMap.put("04", "Apr");
		monthMap.put("05", "May");
		monthMap.put("06", "Jun");
		monthMap.put("07", "Jul");
		monthMap.put("08", "Aug");
		monthMap.put("09", "Sep");
		monthMap.put("10", "Oct");
		monthMap.put("11", "Nov");
		monthMap.put("12", "Dec");
		return monthMap.get(month.length() < 2 ? "0" + month : month);
	}

	public static String getMonthFullName(String month) {

		Map<String, String> monthMap = new HashMap<String, String>();
		monthMap.put("01", "January");
		monthMap.put("02", "February");
		monthMap.put("03", "March");
		monthMap.put("04", "April");
		monthMap.put("05", "May");
		monthMap.put("06", "June");
		monthMap.put("07", "July");
		monthMap.put("08", "August");
		monthMap.put("09", "September");
		monthMap.put("10", "October");
		monthMap.put("11", "November");
		monthMap.put("12", "December");
		return monthMap.get(month.length() < 2 ? "0" + month : month);
	}

	public static int getCurrentYear() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	public static int getMonthDifference(String startDate, String endDate) {
		int monthDiff = 0;

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Calendar c1 = Calendar.getInstance();
			c1.setTime(format.parse(startDate));
			Calendar c2 = Calendar.getInstance();
			c2.setTime(format.parse(endDate));
			if (c2.get(Calendar.YEAR) > c1.get(Calendar.YEAR)) {
				int temp = 11 - c1.get(Calendar.MONTH);
				monthDiff = temp + c2.get(Calendar.MONTH) + 1;
			} else if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) {
				monthDiff = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
			}

		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return monthDiff;
	}

	public static java.sql.Date getSqlDateFromYyMmDdFormat(String date) {
		java.util.Date sd;
		java.sql.Date currdate = null;

		try {
			sd = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			currdate = new java.sql.Date(sd.getTime());

		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return currdate;
	}

	public static String convertDatabaseToUIWithDateTime(String date) {

		String currdate = null;

		try {
			Date sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
			currdate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(sd);

		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return currdate;
	}

	public static String convertUItoDatabaseWithDateTime(String date) {

		String currdate = null;

		try {
			Date sd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(date);
			currdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sd);

		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return currdate;
	}

	public static java.sql.Date getTwentythDayDate() {
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(sqlDate);
			cal.add(Calendar.DATE, -20);
			sqlDate = new java.sql.Date(cal.getTimeInMillis());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return sqlDate;
	}

	public static int getDaysByMonthAndYear(int month, int year) {
		int days = 0;
		try {
			Calendar c1 = Calendar.getInstance();
			c1.clear();
			c1.set(year, (month - 1), 1);
			days = c1.getActualMaximum(Calendar.DAY_OF_MONTH);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return days;
	}

	public static List<String> getDateListBetweenDates(String fromDate,
			String toDate) {
		List<String> dateList = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fDate = sdf.parse(fromDate);
			Date tDate = sdf.parse(toDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(fDate);
			cal.add(Calendar.DATE, -1);
			while (cal.getTime().before(tDate)) {
				cal.add(Calendar.DATE, 1);
				if (sdf.format(cal.getTime()) != null)
					dateList.add(sdf.format(cal.getTime()));
			}
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return dateList;
	}

	public static ArrayList<String> getNextAccYearDetails(String curentyear) {

		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(SQLUtilConstants.GET_NEXT_ACCADAMIC_YEAR);

			String num = curentyear.substring(3);

			int temper = Integer.parseInt(num) + 1;

			pstmt.setString(1, "ACY" + temper);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add(rs.getString("acadamic_id"));
				list.add(rs.getString("acadamic_year"));

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return list;
	}

	public static List<HelperClassVo> getAllAcademicYear() {

		CallableStatement proc = null;
		List<HelperClassVo> accYear = new ArrayList<HelperClassVo>();
		ResultSet rs = null;
		Connection conn = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			proc = conn.prepareCall("{ call getAllAccYear() }");
			proc.execute();
			rs = proc.getResultSet();

			while (rs.next()) {
				HelperClassVo vo = new HelperClassVo();
				vo.setAccId(rs.getString("ACCYEARID"));
				vo.setAccName(rs.getString("acadamic_year"));
				accYear.add(vo);
			}
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		} finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (proc != null && !proc.isClosed()) {
					proc.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}
		return accYear;
	}

	public static String getCurrentYearIDSelected(HttpServletRequest request)
			throws SQLException {

		String accYear = null;
		try {
			HttpSession session = request.getSession(false);
			accYear = (String) session.getAttribute("accYear");

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.getStackTrace();
		}

		return accYear;
	}

	public static String genaratePasswordForTeacher(
			TeacherRegistrationPojo teaPojo) {

		String pswd = null;
		String[] sp = { "@", "#", "%", "&", "*", "_" };
		Random rand = new Random();

		String pswd1 = teaPojo.getTfastname().toString().substring(teaPojo.getTfastname().length() - 3,	teaPojo.getTfastname().length()).toLowerCase();
		String pswd2 = teaPojo.getTeachermobno().toString().substring(1, 3);

		String pswd4 = sp[rand.nextInt((5 - 1) + 1) + 1];
		String pswd5 = teaPojo.getTeacheremail().toString().substring(1, 3)
				.toUpperCase();

		pswd = pswd1 + pswd2 + pswd4 + pswd5;
		pswd = pswd.replace(" ", "").trim();
		return pswd;
	}
	
	
	
	public static String getLastThirtyDateFromNow(String date) {
		String lastThirdDate = "";
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {

			Calendar now = Calendar.getInstance();
			Date fDate = sd.parse(date);
			now.setTime(fDate);
			now.add(Calendar.DATE, -30);
			lastThirdDate = sd.format(now.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lastThirdDate;
	}
	
	public static String getWeekDay(String date) {
		
		String finalDay=null;
		
		try {
			  SimpleDateFormat format1=new SimpleDateFormat("dd-MM-yyyy");
			  Date dt1;
			  dt1 = format1.parse(date);
			  DateFormat format2=new SimpleDateFormat("EEEE"); 
			   finalDay=format2.format(dt1);
			  
			  System.out.println("finalDay :: "+finalDay);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return finalDay;
	}
	
	public static String addTimeArray(String[] getTime) {
		String time = null;
		long cal_time = 0l;
		TimeZone UTC = TimeZone.getTimeZone("UTC");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		sdf.setTimeZone(UTC);
		Date d = null;
		try {
			for (int i = 0; i < getTime.length; i++) {
				d = sdf.parse(getTime[i]);
				cal_time = cal_time + d.getTime();
			}
			long seconds = (cal_time / 1000);
			long lhours = seconds / 3600;
			long min = seconds % 3600;
			long lmin1 = min / 60;
			long lsec = min % 60;

			String hours = (lhours + "").length() > 1 ? (lhours + "") : "0"
					+ lhours;
			String min1 = (lmin1 + "").length() > 1 ? (lmin1 + "") : "0"
					+ lmin1;
			String sec = (lsec + "").length() > 1 ? (lsec + "") : "0" + lsec;
			time = hours + ":" + min1 + ":" + sec;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return time;

	}


}