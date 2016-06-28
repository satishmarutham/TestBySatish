package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.AssignmentUploadDao;
import com.centris.campus.forms.AssignmentUploadForm;
import com.centris.campus.util.AssignmentUploadUtilConstants;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.AssignmentUploadVo;

public class AssignmentUploadDaoImpl implements AssignmentUploadDao{
	
	 private static final Logger logger = Logger.getLogger(AssignmentUploadDaoImpl.class);

	 @Override
	public String insertAssignment(AssignmentUploadForm form, String userId,String accYearString) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AssignmentUploadDaoImpl : insertAssignment : Starting");
			
			PreparedStatement ps_getstudents = null;
			Connection conn = null;
			
			PreparedStatement ps_insetassDetails = null;
			int detailsCount=0;
			
			int count=0;
			String status=null;
			
			try {
				
				conn = JDBCConnection.getSeparateConnection();
			String assignmentID=new IDGenerator().getPrimaryKeyID("campus_assignment");
				
				ps_getstudents = conn.prepareStatement(AssignmentUploadUtilConstants.INSERT_ASSIGNMENT);
				ps_getstudents.setString(1,assignmentID);
				ps_getstudents.setString(2, form.getStreamid());
				ps_getstudents.setString(3, form.getClassid());
				ps_getstudents.setString(4, form.getSection());
				ps_getstudents.setString(5, HelperClass.convertUIToDatabase(form.getAssdate()));
				ps_getstudents.setString(6, HelperClass.convertUIToDatabase(form.getCompdate()));
				if(form.getSubject().equalsIgnoreCase("general")){
				ps_getstudents.setString(7, "General");
				}else{
					
					ps_getstudents.setString(7, "Subject");
				}
				ps_getstudents.setString(8, form.getAssname());
				ps_getstudents.setString(9, form.getDescription());
				ps_getstudents.setString(10, form.getSubject());
				ps_getstudents.setString(11, form.getMaxid());
				ps_getstudents.setString(12,accYearString);
				ps_getstudents.setString(13, userId);
				ps_getstudents.setTimestamp(14, HelperClass.getCurrentTimestamp());
				
				System.out.println("insert assignemnet ::: "+ps_getstudents);
				
				count=ps_getstudents.executeUpdate();
				
				if(count>0){
					
						ps_insetassDetails = conn.prepareStatement(AssignmentUploadUtilConstants.INSERT_ASSIGNMENT_DETAILS);
						
					//	String[] studentId=form.getStudent().split(",");
						
						for(int i=0;i<form.getStudent().length;i++){
							
							ps_insetassDetails.setString(1, assignmentID);
							ps_insetassDetails.setString(2, form.getStudent()[i]);
							ps_insetassDetails.setString(3, HelperClass.convertUIToDatabase(form.getCompdate()));
							ps_insetassDetails.setString(4, userId);
							ps_insetassDetails.setTimestamp(5, HelperClass.getCurrentTimestamp());
							
							detailsCount=ps_insetassDetails.executeUpdate();
						
						}
						
					
				}
				
				if(detailsCount>0){
					
					status="true";
				}else{
					
					status="false";
				}
				
				
				
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					
					if (ps_getstudents != null&& (!ps_getstudents.isClosed())) {
						ps_getstudents.close();
					}
					if (conn != null && (!conn.isClosed())) {
						conn.close();
					}
				} catch (SQLException sqle) {

					logger.error(sqle.getMessage(), sqle);
					sqle.printStackTrace();
				} catch (Exception e1) {

					logger.error(e1.getMessage(), e1);
					e1.printStackTrace();
				}
			}

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AssignmentUploadDaoImpl : insertAssignment: Ending");
			
			return status;
		}


	@Override
	public ArrayList<AssignmentUploadVo> getStudentDetails(String section) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AssignmentUploadDaoImpl : insertAssignment : Starting");
			
			PreparedStatement ps_getstudents = null;
			ResultSet rs_getstudents=null;
			Connection conn = null;
			
			ArrayList<AssignmentUploadVo> StudentList=new ArrayList<AssignmentUploadVo>();
			
		 	
			try {
				
				conn = JDBCConnection.getSeparateConnection();
			
				ps_getstudents = conn.prepareStatement(AssignmentUploadUtilConstants.GET_STUDENT_DETAILS);
				ps_getstudents.setString(1, section);
				
				rs_getstudents=ps_getstudents.executeQuery();
				
				while(rs_getstudents.next()){
					
					AssignmentUploadVo assignmentVo=new AssignmentUploadVo();
					
					assignmentVo.setStudentId(rs_getstudents.getString("student_id_int"));
					assignmentVo.setStudentName(rs_getstudents.getString("studentName"));
					assignmentVo.setAdmissionNo(rs_getstudents.getString("student_admissionno_var"));
					
					StudentList.add(assignmentVo);
				}
				
				
				
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					
					if (ps_getstudents != null&& (!ps_getstudents.isClosed())) {
						ps_getstudents.close();
					}
					if (conn != null && (!conn.isClosed())) {
						conn.close();
					}
				} catch (SQLException sqle) {

					logger.error(sqle.getMessage(), sqle);
					sqle.printStackTrace();
				} catch (Exception e1) {

					logger.error(e1.getMessage(), e1);
					e1.printStackTrace();
				}
			}

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AssignmentUploadDaoImpl : insertAssignment: Ending");
			
			return StudentList;
		}


	 
		public ArrayList<AssignmentUploadVo> getAssignment(String userId,String accYearString,String searchTerm) {
			   
				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.START_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in AssignmentUploadDaoImpl : getAssignment : Starting");
				
				PreparedStatement ps_getassignment = null;
				ResultSet rs_assignment=null;
				Connection conn = null;
				
				ArrayList<AssignmentUploadVo> assignmentList=new ArrayList<AssignmentUploadVo>();
				
				try {
					
					conn = JDBCConnection.getSeparateConnection();
				
					ps_getassignment = conn.prepareStatement(AssignmentUploadUtilConstants.GET_ASSIGNMENT);
					
					ps_getassignment.setString(1,accYearString);
					ps_getassignment.setString(2, userId);
					ps_getassignment.setString(3, "%"+searchTerm+"%");
					
					System.out.println("get assignment ::: "+ps_getassignment);
					
					rs_assignment=ps_getassignment.executeQuery();
					
					while(rs_assignment.next()){
						
						AssignmentUploadVo assignmentvo=new AssignmentUploadVo();
						
						assignmentvo.setAssignmentId(rs_assignment.getString("AssignmentCode"));
						assignmentvo.setClassname(rs_assignment.getString("classdetails_name_var"));
						assignmentvo.setSection(rs_assignment.getString("classsection_name_var"));
						assignmentvo.setAssigName(rs_assignment.getString("Name"));
						assignmentvo.setStartdate(HelperClass.convertDatabaseToUI(rs_assignment.getString("AssignmentDate")));
						assignmentvo.setEnddate(HelperClass.convertDatabaseToUI(rs_assignment.getString("CompletionDate")));
						assignmentvo.setSubjectname(rs_assignment.getString("subjectName"));
						assignmentvo.setMarks(rs_assignment.getString("MaxMarks"));
					
						assignmentList.add(assignmentvo);
					}
					
				} catch (SQLException e) {
					logger.error(e.getMessage(), e);
					e.printStackTrace();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
					e1.printStackTrace();
				} finally {
					try {
						
						if (ps_getassignment != null&& (!ps_getassignment.isClosed())) {
							ps_getassignment.close();
						}
						if (conn != null && (!conn.isClosed())) {
							conn.close();
						}
					} catch (SQLException sqle) {

						logger.error(sqle.getMessage(), sqle);
						sqle.printStackTrace();
					} catch (Exception e1) {

						logger.error(e1.getMessage(), e1);
						e1.printStackTrace();
					}
				}

				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.END_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in AssignmentUploadDaoImpl : getAssignment: Ending");
				
				return assignmentList;
			}


		@Override
		public ArrayList<AssignmentUploadVo> getAssignmentDetails(
				String assignmentId) {
			   
				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.START_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in AssignmentUploadDaoImpl : getAssignmentDetails : Starting");
				
				PreparedStatement ps_getassignment = null;
				ResultSet rs_assignment=null;
				Connection conn = null;
				int count=0;
				
				ArrayList<AssignmentUploadVo> assignmentList=new ArrayList<AssignmentUploadVo>();
				
				try {
					
					conn = JDBCConnection.getSeparateConnection();
				
					ps_getassignment = conn.prepareStatement(AssignmentUploadUtilConstants.GET_ASSIGNMENT_DETAILS);
					
					ps_getassignment.setString(1,assignmentId);
					
					rs_assignment=ps_getassignment.executeQuery();
					
					while(rs_assignment.next()){
						
						AssignmentUploadVo assignmentvo=new AssignmentUploadVo();
						count++;
						
						assignmentvo.setSno(count);
						assignmentvo.setAssignmentId(assignmentId);
						assignmentvo.setStudentId(rs_assignment.getString("student_id_int"));
						assignmentvo.setAdmissionNo(rs_assignment.getString("student_admissionno_var"));
						assignmentvo.setStudentName(rs_assignment.getString("studentName"));
						if("".equalsIgnoreCase(rs_assignment.getString("ActualCompletionDate")) || rs_assignment.getString("ActualCompletionDate")==null){
							
							assignmentvo.setActualcompletedDate("");
							
						}else{
							
							assignmentvo.setActualcompletedDate(HelperClass.convertDatabaseToUI(rs_assignment.getString("ActualCompletionDate")));
						}
						assignmentvo.setAcquiredMarks(rs_assignment.getString("AcquiredMarks"));
						assignmentvo.setRemarks(rs_assignment.getString("Remarks"));
					
						assignmentList.add(assignmentvo);
					}
					
				} catch (SQLException e) {
					logger.error(e.getMessage(), e);
					e.printStackTrace();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
					e1.printStackTrace();
				} finally {
					try {
						
						if (ps_getassignment != null&& (!ps_getassignment.isClosed())) {
							ps_getassignment.close();
						}
						if (conn != null && (!conn.isClosed())) {
							conn.close();
						}
					} catch (SQLException sqle) {

						logger.error(sqle.getMessage(), sqle);
						sqle.printStackTrace();
					} catch (Exception e1) {

						logger.error(e1.getMessage(), e1);
						e1.printStackTrace();
					}
				}

				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.END_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in AssignmentUploadDaoImpl : getAssignmentDetails: Ending");
				
				return assignmentList;
			}


		@Override
		public AssignmentUploadVo getSingleAssignment(String assignmentId) {
			   
				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.START_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in AssignmentUploadDaoImpl : getSingleAssignment : Starting");
				
				PreparedStatement ps_getassignment = null;
				ResultSet rs_assignment=null;
				Connection conn = null;
				
				AssignmentUploadVo assignmentvo=new AssignmentUploadVo();
				
				try {
					
					conn = JDBCConnection.getSeparateConnection();
				
					ps_getassignment = conn.prepareStatement(AssignmentUploadUtilConstants.GET_SINGLE_ASSIGNMENT);
					
					ps_getassignment.setString(1,assignmentId);
					
					rs_assignment=ps_getassignment.executeQuery();
					
					while(rs_assignment.next()){
						
						assignmentvo.setAssignmentId(assignmentId);
						assignmentvo.setAssignmentId(rs_assignment.getString("AssignmentCode"));
						assignmentvo.setClassname(rs_assignment.getString("classdetails_name_var"));
						assignmentvo.setSection(rs_assignment.getString("classsection_name_var"));
						assignmentvo.setAssigName(rs_assignment.getString("Name"));
						assignmentvo.setStartdate(HelperClass.convertDatabaseToUI(rs_assignment.getString("AssignmentDate")));
						assignmentvo.setEnddate(HelperClass.convertDatabaseToUI(rs_assignment.getString("CompletionDate")));
						assignmentvo.setSubjectname(rs_assignment.getString("subjectName"));
						assignmentvo.setMarks(rs_assignment.getString("MaxMarks"));
					
					}
					
				} catch (SQLException e) {
					logger.error(e.getMessage(), e);
					e.printStackTrace();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
					e1.printStackTrace();
				} finally {
					try {
						
						if (ps_getassignment != null&& (!ps_getassignment.isClosed())) {
							ps_getassignment.close();
						}
						if (conn != null && (!conn.isClosed())) {
							conn.close();
						}
					} catch (SQLException sqle) {

						logger.error(sqle.getMessage(), sqle);
						sqle.printStackTrace();
					} catch (Exception e1) {

						logger.error(e1.getMessage(), e1);
						e1.printStackTrace();
					}
				}

				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.END_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in AssignmentUploadDaoImpl : getSingleAssignment: Ending");
				
				return assignmentvo;
			}


		@Override
		public String updateAssignmentDetails(AssignmentUploadVo assignmentVo) {
			   
				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.START_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in AssignmentUploadDaoImpl : updateAssignmentDetails : Starting");
				
				PreparedStatement ps_getstudents = null;
				Connection conn = null;
				
				int count=0;
				String status=null;
				
				try {
					
					conn = JDBCConnection.getSeparateConnection();
				
					ps_getstudents = conn.prepareStatement(AssignmentUploadUtilConstants.UPDATE_ASSIGNMENT_DETAILS);
					
					String[] studentId=assignmentVo.getStudentId().split(",");
					String[] completionDate=assignmentVo.getActualcompletedDate().split(",");
					String[] marks=assignmentVo.getAcquiredMarks().split(",");
					String[] remarks=assignmentVo.getRemarks().split(",");
					
					
					
					for(int i=0;i<studentId.length;i++){
						
					ps_getstudents.setString(1, HelperClass.convertUIToDatabase(completionDate[i]));
					ps_getstudents.setString(2, marks[i]);
					if(remarks[i].equalsIgnoreCase("null")){
						ps_getstudents.setString(3, "");
					}else{
					ps_getstudents.setString(3, remarks[i]);
					}
					ps_getstudents.setString(4, assignmentVo.getUserID());
					ps_getstudents.setTimestamp(5, HelperClass.getCurrentTimestamp());
					ps_getstudents.setString(6, assignmentVo.getAssignmentId());
					ps_getstudents.setString(7, studentId[i]);
					
					System.out.println("ps_getstudents :::: "+ps_getstudents);
					
					count=ps_getstudents.executeUpdate();
					
					}
					
					if(count>0){
						
						status="true";
					}else{
						status="false";
					}
					
					
				} catch (SQLException e) {
					logger.error(e.getMessage(), e);
					e.printStackTrace();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
					e1.printStackTrace();
				} finally {
					try {
						
						if (ps_getstudents != null&& (!ps_getstudents.isClosed())) {
							ps_getstudents.close();
						}
						if (conn != null && (!conn.isClosed())) {
							conn.close();
						}
					} catch (SQLException sqle) {

						logger.error(sqle.getMessage(), sqle);
						sqle.printStackTrace();
					} catch (Exception e1) {

						logger.error(e1.getMessage(), e1);
						e1.printStackTrace();
					}
				}

				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.END_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in AssignmentUploadDaoImpl : updateAssignmentDetails: Ending");
				
				return status;
			}


		@Override
		public String deleteAssignment(String assignmentCode) {
			   
				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.START_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in AssignmentUploadDaoImpl : updateAssignmentDetails : Starting");
				
				PreparedStatement ps_deleteassgnment = null;
				Connection conn = null;
				PreparedStatement ps_deleteassgnmentdetails = null;
				int count=0;
				int detailscount=0;
				String status=null;
				
				try {
					
					conn = JDBCConnection.getSeparateConnection();
				
					ps_deleteassgnment = conn.prepareStatement(AssignmentUploadUtilConstants.DELETE_ASSIGNMENT);
					
					ps_deleteassgnment.setString(1, assignmentCode);
					
					count=ps_deleteassgnment.executeUpdate();
					
				if(count>0){
					
					ps_deleteassgnmentdetails = conn.prepareStatement(AssignmentUploadUtilConstants.DELETE_ASSIGNMENT_DETAILS);
					
					ps_deleteassgnmentdetails.setString(1, assignmentCode);
					
					detailscount=ps_deleteassgnmentdetails.executeUpdate();
					
				}
					
					if(detailscount>0){
						
						status="true";
					}else{
						status="false";
					}
					
					
				} catch (SQLException e) {
					logger.error(e.getMessage(), e);
					e.printStackTrace();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
					e1.printStackTrace();
				} finally {
					try {
						
						if (ps_deleteassgnment != null&& (!ps_deleteassgnment.isClosed())) {
							ps_deleteassgnment.close();
						}
						if (conn != null && (!conn.isClosed())) {
							conn.close();
						}
					} catch (SQLException sqle) {

						logger.error(sqle.getMessage(), sqle);
						sqle.printStackTrace();
					} catch (Exception e1) {

						logger.error(e1.getMessage(), e1);
						e1.printStackTrace();
					}
				}

				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.END_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in AssignmentUploadDaoImpl : updateAssignmentDetails: Ending");
				
				return status;
			}
	
}
