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

import com.centris.campus.dao.AddtSubjectDao;
import com.centris.campus.forms.AddSubjectForm;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.SubjectSqlUtils;
import com.centris.campus.vo.ViewallSubjectsVo;

public class AddSubjectDaoImpl implements AddtSubjectDao {
	private static final Logger logger = Logger
			.getLogger(AddSubjectDaoImpl.class);

	@Override
	public synchronized ArrayList<ViewallSubjectsVo> subjectdetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl : subjectdetails Starting");
		ArrayList<ViewallSubjectsVo> allsubject = new ArrayList<ViewallSubjectsVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int sno = 0;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(SubjectSqlUtils.VIEW_SUBJECT_DETAILS);

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				sno++;
				ViewallSubjectsVo obj = new ViewallSubjectsVo();
				obj.setSubjectid(resultSet.getString("subjectID"));
				obj.setSubjectname(resultSet.getString("subjectName").trim());
				obj.setPath(resultSet.getString("syllabous"));
				obj.setDescription(resultSet.getString("decription"));
				/* obj.setStatus(resultSet.getString("status")); */
				obj.setClassname(resultSet.getString("classdetails_name_var"));
				obj.setSno(sno);

				allsubject.add(obj);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null && (!resultSet.isClosed())) {
					resultSet.close();
				}
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
				+ " Control in AddSubjectDaoImpl: subjectdetails Ending");
		return allsubject;

	}

	public synchronized boolean DeleteSubject(ViewallSubjectsVo voObj) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl : DeleteSubject Starting");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int sno = 0;
		boolean status = false;
		int count = 0;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(SubjectSqlUtils.DELETE_SUBJECT_DETAILS);
			pstmt.setString(1, voObj.getSubjectid());
			count = pstmt.executeUpdate();
			if (count > 0) {
				status = true;
			} else {

				status = false;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null && (!resultSet.isClosed())) {
					resultSet.close();
				}
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
				+ " Control in AddSubjectDaoImpl: DeleteSubject Ending");
		return status;

	}

	public synchronized List<ViewallSubjectsVo> searchsubjectdetails(
			ViewallSubjectsVo voObj) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl : searchsubjectdetails Starting");
		ArrayList<ViewallSubjectsVo> allsubject = new ArrayList<ViewallSubjectsVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int sno = 0;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(SubjectSqlUtils.SEARCH_SUBJECT_DETAILS);
			pstmt.setString(1, "%" + voObj.getSearchName() + "%");
			pstmt.setString(2, "%" + voObj.getSearchName() + "%");
			pstmt.setString(3, "%" + voObj.getSearchName() + "%");

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				sno++;
				ViewallSubjectsVo obj = new ViewallSubjectsVo();
				obj.setSubjectid(resultSet.getString("subjectID"));
				obj.setSubjectname(resultSet.getString("subjectName").trim());
				obj.setPath(resultSet.getString("syllabous"));
				obj.setDescription(resultSet.getString("decription"));
				/* obj.setStatus(resultSet.getString("status")); */
				obj.setClassname(resultSet.getString("classdetails_name_var"));
				obj.setSno(sno);

				allsubject.add(obj);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null && (!resultSet.isClosed())) {
					resultSet.close();
				}
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
				+ " Control in AddSubjectDaoImpl: searchsubjectdetails Ending");
		return allsubject;
	}

	public synchronized boolean addSubject(AddSubjectForm obj) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl : addSubject Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		boolean status = false;
		try {

			boolean flagSubExist = validateSubjectWithClass(obj);
			if (!flagSubExist) {
				conn = JDBCConnection.getSeparateConnection();
				pstmt = conn
						.prepareStatement(SubjectSqlUtils.INSERT_ADDSUBJECT_FORM);

				pstmt.setString(1,
						IDGenerator.getPrimaryKeyID("campus_subject"));
				pstmt.setString(2, obj.getSubjtname().trim());
				pstmt.setString(3, obj.getFilename());
				pstmt.setString(4, obj.getClassname().trim());
				pstmt.setString(5, obj.getDescription().trim());
				pstmt.setString(6, obj.getCreatedUserId().trim());
				result = pstmt.executeUpdate();

				if (result > 0) {
					status = true;
				} else {
					status = false;
				}

			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.getStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		}

		finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl : addSubject Ending");

		return status;
	}

	public synchronized ViewallSubjectsVo getSubjectDetails(
			ViewallSubjectsVo obj) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl : getSubjectDetails Starting");
		ViewallSubjectsVo allsubject = new ViewallSubjectsVo();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int sno = 0;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(SubjectSqlUtils.GET_SINGLE_SUBJECT_DETAILS);
			pstmt.setString(1, obj.getSubjectid());

			
			
			
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {

				allsubject.setSubjectid(resultSet.getString("subjectID"));
				allsubject.setSubjectname(resultSet.getString("subjectName").trim());
				allsubject.setPath(resultSet.getString("syllabous"));
				allsubject.setDescription(resultSet.getString("decription"));
				/* obj.setStatus(resultSet.getString("status")); */
				allsubject.setClassname(resultSet.getString("classid"));
				allsubject.setStatus("update");
				
				
				

			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null && (!resultSet.isClosed())) {
					resultSet.close();
				}
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
				+ " Control in AddSubjectDaoImpl: getSubjectDetails Ending");
		return allsubject;
	}

	public synchronized boolean updateSubjectDetails(AddSubjectForm obj) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl: updateSubjectDetails Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(SubjectSqlUtils.UPDATE_SUBJECT);

			pstmt.setString(1, obj.getSubjtname().trim());
			pstmt.setString(2, obj.getFilename().trim());
			pstmt.setString(3, obj.getClassname().trim());
			pstmt.setString(4, obj.getDescription());
			pstmt.setString(5, obj.getCreatedUserId().trim());
			pstmt.setString(6, obj.getHiddensubjectId().trim());
			
			
			
			
			int res = pstmt.executeUpdate();
			if (res > 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl: updateSubjectDetails Ending");
		return result;
	}

	public synchronized boolean validateSubjectWithClass(
			AddSubjectForm addSubjectPojo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl: validateSubjectWithClass Starting");
		Connection conn = null;
		boolean flagSubExist = false;
		PreparedStatement pstmt = null;
		try {
			int i = 0;
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(SubjectSqlUtils.VALIDATE_CLASS_SUBJECT);
			pstmt.setString(1, addSubjectPojo.getSubjtname());
			pstmt.setString(2, addSubjectPojo.getClassname());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
			if (i > 0) {
				flagSubExist = true;
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
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl: validateSubjectWithClass Ending");

		return flagSubExist;
	}

	public synchronized String getpath(String classname) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl: getpath Starting");

		String path = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet resultSet = null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(SubjectSqlUtils.ViewAllSubjectsPath);
			pstmt.setString(1, classname);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				path = resultSet.getString("syllabous");
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null && (!resultSet.isClosed())) {
					resultSet.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}

			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl: getpath Ending");
		return path;
	}

	public String DdownloadsyllabuspathDao(String subjectid) {
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl: DdownloadsyllabuspathDao Starting");

		
		String path = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(SubjectSqlUtils.GET_SYLLABUS_PATH);
			pstmt.setString(1, subjectid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				
				path = rs.getString("syllabous");
				
			}
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddSubjectDaoImpl: DdownloadsyllabuspathDao Ending");
		
		return path;
	}

}
