package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.ExamDetailsDao;
import com.centris.campus.pojo.ExamDetailsPojo;
import com.centris.campus.util.ExamSqlUtils;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;

public class ExamDetailsDaoImpl implements ExamDetailsDao {
	private static final Logger logger = Logger
			.getLogger(StreamDetailsDaoImpl.class);

	@Override
	public List<ExamDetailsPojo> getExamDetailsDao() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExamDetailsDaoImpl : getExamDetailsDao Starting");
		
		List<ExamDetailsPojo> examPojoList = new ArrayList<ExamDetailsPojo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(ExamSqlUtils.GET_EXAM_DETAILS);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				ExamDetailsPojo examPojo = new ExamDetailsPojo();
				
				examPojo.setExamid(rs.getString("examid"));
				examPojo.setExamName(rs.getString("examname"));
				examPojo.setStartDate(HelperClass.convertDatabaseToUI(rs.getString("startdate")));
				examPojo.setEndDate(HelperClass.convertDatabaseToUI(rs.getString("enddate")));
				examPojo.setAccyear(rs.getString("acadamic_year"));
				examPojo.setDescription(rs.getString("description"));
				examPojoList.add(examPojo);
				
			}
			
		} catch (Exception e) {
			
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExamDetailsDaoImpl : getExamDetailsDao Endinging");
		return examPojoList;
	}

}
