package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.ReportsMenuDao;
import com.centris.campus.forms.ReportMenuForm;
import com.centris.campus.pojo.FeeStatusReportPojo;
import com.centris.campus.pojo.MarksPOJO;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.ReportsMenuSqlConstants;
import com.centris.campus.vo.ExaminationDetailsVo;
import com.centris.campus.vo.FeeReportDetailsVo;
import com.centris.campus.vo.MarksUploadVO;
import com.centris.campus.vo.ReportMenuVo;
import com.centris.campus.vo.StudentInfoVO;

public class ReportsMenuDaoImpl implements ReportsMenuDao{
	
	private static final Logger logger = Logger.getLogger(ReportsMenuDaoImpl.class);

	@Override
	public ArrayList<ReportMenuVo> getAccYears() {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ReportsMenuDaoImpl: getAccYears : Starting");
			
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			Connection conn = null;
			ArrayList<ReportMenuVo> accYearList=new ArrayList<ReportMenuVo>();
		 	
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
				pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_ACCYEAR);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					ReportMenuVo yearVo=new ReportMenuVo();
					yearVo.setAccyearId(rs.getString("acadamic_id"));
					yearVo.setAccyearname(rs.getString("acadamic_year"));
					
					accYearList.add(yearVo);
					
				}
			
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null&& (!rs.isClosed())) {
						rs.close();
					}
					if (pstmt != null&& (!pstmt.isClosed())) {
						pstmt.close();
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
					+ " Control in ReportsMenuDaoImpl : getAccYears : Ending");
			
			return accYearList;
		}

	@Override
	public ArrayList<ReportMenuVo> getStream() {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ReportsMenuDaoImpl: getStream : Starting");
			
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			Connection conn = null;
			ArrayList<ReportMenuVo> streamList=new ArrayList<ReportMenuVo>();
		 	
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
				pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_STREAMS);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					ReportMenuVo streamVo=new ReportMenuVo();
					
					streamVo.setStreamId(rs.getString("classstream_id_int"));
					streamVo.setStreamname(rs.getString("classstream_name_var"));
					
					streamList.add(streamVo);
					
				}
			
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null&& (!rs.isClosed())) {
						rs.close();
					}
					if (pstmt != null&& (!pstmt.isClosed())) {
						pstmt.close();
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
					+ " Control in ReportsMenuDaoImpl : getStream : Ending");
			
			return streamList;
		}

	@Override
	public ArrayList<ReportMenuVo> getClassesByStream(String streamId) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ReportsMenuDaoImpl: getClassesByStream : Starting");
			
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			Connection conn = null;
			ArrayList<ReportMenuVo> streamList=new ArrayList<ReportMenuVo>();
		 	
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
				pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_CLASSES);
				pstmt.setString(1, streamId);
				
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					ReportMenuVo streamVo=new ReportMenuVo();
					
					streamVo.setClassId(rs.getString("classdetail_id_int"));
					streamVo.setClassname(rs.getString("classdetails_name_var"));
					
					streamList.add(streamVo);
					
				}
			
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null&& (!rs.isClosed())) {
						rs.close();
					}
					if (pstmt != null&& (!pstmt.isClosed())) {
						pstmt.close();
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
					+ " Control in ReportsMenuDaoImpl : getClassesByStream : Ending");
			
			return streamList;
		}

	@Override
	public ArrayList<ReportMenuVo> getSectionsByClass(String classId) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ReportsMenuDaoImpl: getSectionsByClass : Starting");
			
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			Connection conn = null;
			ArrayList<ReportMenuVo> streamList=new ArrayList<ReportMenuVo>();
		 	
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
				pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_SECTIONS);
				pstmt.setString(1, classId);
				
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					ReportMenuVo streamVo=new ReportMenuVo();
					
					streamVo.setSectionId(rs.getString("classsection_id_int"));
					streamVo.setSectionname(rs.getString("classsection_name_var"));
					
					streamList.add(streamVo);
					
				}
			
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null&& (!rs.isClosed())) {
						rs.close();
					}
					if (pstmt != null&& (!pstmt.isClosed())) {
						pstmt.close();
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
					+ " Control in ReportsMenuDaoImpl : getSectionsByClass : Ending");
			
			return streamList;
		}

	@Override
	public ArrayList<StudentInfoVO> getStudentDetailsReport(ReportMenuForm reform) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ReportsMenuDaoImpl: getStudentDetailsReport : Starting");
			
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			Connection conn = null;
			ArrayList<StudentInfoVO> studentInfoList=new ArrayList<StudentInfoVO>();
			int count=0;
		 	
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
				pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_STUDENTSiNFORMATION);
				pstmt.setString(1, reform.getAccyear().trim());
				pstmt.setString(2, reform.getStream().trim());
				pstmt.setString(3, reform.getClassname().trim());
				pstmt.setString(4, reform.getSection().trim());
				
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					StudentInfoVO studentinfo=new StudentInfoVO();
					
					count++;
					studentinfo.setSno(count);
					studentinfo.setAdmissionno(rs.getString("student_admissionno_var").trim());
					studentinfo.setName(rs.getString("studentname").trim());
					studentinfo.setAge(rs.getString("student_age_int").trim());
					studentinfo.setDoj(rs.getString("student_doj_var").trim());
					studentinfo.setFathername(rs.getString("FatherName").trim());
					studentinfo.setFathermobno(rs.getString("mobileno").trim());
					studentinfo.setMothername(rs.getString("student_mothername_var").trim());
					studentinfo.setMonthermobno(rs.getString("student_mothermobileno_var").trim());
					
					studentInfoList.add(studentinfo);
					
				}
			
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null&& (!rs.isClosed())) {
						rs.close();
					}
					if (pstmt != null&& (!pstmt.isClosed())) {
						pstmt.close();
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
					+ " Control in ReportsMenuDaoImpl : getStudentDetailsReport : Ending");
			
			return studentInfoList;
		}

	@Override
	public ReportMenuVo getSelectedItems(ReportMenuForm reform) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ReportsMenuDaoImpl: getSelectedItems : Starting");
			
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			Connection conn = null;
			ReportMenuVo selecteditems=new ReportMenuVo();
			int count=0;
		 	
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
				pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_SELECTED_ITEMS);
				pstmt.setString(1, reform.getAccyear().trim());
				pstmt.setString(2, reform.getStream().trim());
				pstmt.setString(3, reform.getClassname().trim());
				pstmt.setString(4, reform.getSection().trim());
				
				
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					count++;
					selecteditems.setAccyearname(rs.getString("acadamic_year"));
					selecteditems.setStreamname(rs.getString("classstream_name_var"));
					selecteditems.setClassname(rs.getString("classdetails_name_var"));
					selecteditems.setSectionname(rs.getString("classsection_name_var"));
					
					selecteditems.setAccyearId(reform.getAccyear().trim());
					selecteditems.setStreamId(reform.getStream().trim());
					selecteditems.setClassId(reform.getClassname().trim());
					selecteditems.setSectionId(reform.getSection().trim());
				
					
				}
			
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null&& (!rs.isClosed())) {
						rs.close();
					}
					if (pstmt != null&& (!pstmt.isClosed())) {
						pstmt.close();
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
					+ " Control in ReportsMenuDaoImpl : getSelectedItems : Ending");
			
			return selecteditems;
		}

	@Override
	public HashMap<String, ArrayList<FeeReportDetailsVo>> getStdFeeStatusReportDetails(
			ReportMenuForm reform) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ReportsMenuDaoImpl: getStdFeeStatusReportDetails : Starting");
			
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			
			PreparedStatement ps_classfesAmt = null;
			ResultSet rs_classfesAmt=null;
			
			PreparedStatement ps_stagefesAmt = null;
			ResultSet rs_stagefesAmt=null;
			
			Connection conn = null;
			ArrayList<FeeReportDetailsVo> feeStatusList=new ArrayList<FeeReportDetailsVo>();
			HashMap<String, ArrayList<FeeReportDetailsVo>> feeMap=new HashMap<String, ArrayList<FeeReportDetailsVo>>();
			int count=0;
		 	
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
				double classFeeAmt=0.0;
				
				ps_classfesAmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_CLASS_FEE_AMOUNT);
				
				ps_classfesAmt.setString(1, reform.getClassname().trim());
				ps_classfesAmt.setString(2, reform.getAccyear().trim());
				ps_classfesAmt.setString(3, reform.getTerm().trim());
			
				
				
				rs_classfesAmt=ps_classfesAmt.executeQuery();
				
				while(rs_classfesAmt.next()){
					
					classFeeAmt=rs_classfesAmt.getInt("ActualAmount");
					
				}
				
				double stageFeeAmt=0.0;
				
				ps_stagefesAmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_STAGE_FEE_AMOUNT);
				
				ps_stagefesAmt.setString(1, reform.getClassname().trim());
				ps_stagefesAmt.setString(2, reform.getAccyear().trim());
				ps_stagefesAmt.setString(3, reform.getTerm().trim());
			
				
				
				rs_stagefesAmt=ps_stagefesAmt.executeQuery();
				
				while(rs_stagefesAmt.next()){
					
					stageFeeAmt=rs_stagefesAmt.getInt("transportfee");
					
				}
				
				if(reform.getStatus().equalsIgnoreCase("ALL")){
					
					pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_FEE_STATUS_REPORT);
					pstmt.setString(1, reform.getTerm().trim());
					pstmt.setString(2, reform.getAccyear().trim());
					pstmt.setString(3, reform.getClassname().trim());
					if(reform.getSection().trim().equalsIgnoreCase("all")){
						pstmt.setString(4, "%%");
					}else{
						pstmt.setString(4, reform.getSection().trim());
					}
					
					
					rs=pstmt.executeQuery();
					
					while(rs.next()){
					

						FeeReportDetailsVo vo=new FeeReportDetailsVo();
						
						if(feeStatusList.size()!=0){
						
						if(!(feeStatusList.get(feeStatusList.size()-1).getSectioncode().equalsIgnoreCase(rs.getString("classsection_id_int")))){
							
							feeMap.put(feeStatusList.get(feeStatusList.size()-1).getClassName()+"-"+feeStatusList.get(feeStatusList.size()-1).getSectionname(), feeStatusList);
							
							count=0;
							feeStatusList = new ArrayList<FeeReportDetailsVo>();
						}
						
						}
						
						count++;
						
						vo.setSno(count);
						vo.setAdmissionNo(rs.getString("student_admissionno_var"));
						vo.setStudentName(rs.getString("studentname"));
						vo.setActualAmount(Math.round(classFeeAmt+stageFeeAmt));
						vo.setConcAmount(rs.getDouble("conc_amount"));
						vo.setPaidAmount(Math.round(rs.getDouble("totalamount")));
						if(rs.getString("paidDate")==null || "".equalsIgnoreCase(rs.getString("paidDate"))){
							
							vo.setPaidDate("-");
						}else{
							
							vo.setPaidDate(HelperClass.convertDatabaseToUI(rs.getString("paidDate")));
						}
						
						vo.setBalanceAmount(Math.round(classFeeAmt+stageFeeAmt-rs.getDouble("totalamount")-rs.getDouble("conc_amount")));
						vo.setStatus(rs.getString("feestatus"));
						vo.setClassName(rs.getString("classdetails_name_var"));
						vo.setSectioncode(rs.getString("classsection_id_int"));
						vo.setSectionname(rs.getString("classsection_name_var"));
						feeStatusList.add(vo);
						
					}
					
					if(feeStatusList.size()!=0){
						
						feeMap.put(feeStatusList.get(feeStatusList.size()-1).getClassName()+"-"+feeStatusList.get(feeStatusList.size()-1).getSectionname(), feeStatusList);
					}
					
				}else if(reform.getStatus().equalsIgnoreCase("Paid")){
					
					pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_FEEPAID_STATUS_REPORT);
					pstmt.setString(1, reform.getClassname().trim());
					if(reform.getSection().trim().equalsIgnoreCase("all")){
						pstmt.setString(2, "%%");
					}else{
						pstmt.setString(2, reform.getSection().trim());
					}
					pstmt.setString(3, reform.getTerm().trim());
					pstmt.setString(4, reform.getAccyear().trim());
					
					
					rs=pstmt.executeQuery();
					
					while(rs.next()){
					

						FeeReportDetailsVo vo=new FeeReportDetailsVo();
						
						if(feeStatusList.size()!=0){
						
						if(!(feeStatusList.get(feeStatusList.size()-1).getSectioncode().equalsIgnoreCase(rs.getString("classsection_id_int")))){
							
							feeMap.put(feeStatusList.get(feeStatusList.size()-1).getClassName()+"-"+feeStatusList.get(feeStatusList.size()-1).getSectionname(), feeStatusList);
							
							count=0;
							feeStatusList = new ArrayList<FeeReportDetailsVo>();
						}
						
						}
						
						count++;
						
						vo.setSno(count);
						vo.setAdmissionNo(rs.getString("student_admissionno_var"));
						vo.setStudentName(rs.getString("studentname"));
						vo.setActualAmount(Math.round(rs.getDouble("actualamount")));
						vo.setConcAmount(rs.getDouble("conc_amount"));
						vo.setPaidAmount(Math.round(rs.getDouble("totalamount")));
						vo.setPaidDate(HelperClass.convertDatabaseToUI(rs.getString("paidDate")));
						vo.setBalanceAmount(Math.round(rs.getDouble("actualamount")-rs.getDouble("totalamount")-rs.getDouble("conc_amount")));
						vo.setStatus("Paid");
						vo.setClassName(rs.getString("classdetails_name_var"));
						vo.setSectioncode(rs.getString("classsection_id_int"));
						vo.setSectionname(rs.getString("classsection_name_var"));
						feeStatusList.add(vo);
						
					}
					
					if(feeStatusList.size()!=0){
						
						feeMap.put(feeStatusList.get(feeStatusList.size()-1).getClassName()+"-"+feeStatusList.get(feeStatusList.size()-1).getSectionname(), feeStatusList);
					}
					
				
				}else if(reform.getStatus().equalsIgnoreCase("NotPaid")){
					
					pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_FEENOTPAID_STATUS_REPORT);
					pstmt.setString(1, reform.getClassname().trim());
					if(reform.getSection().trim().equalsIgnoreCase("all")){
						pstmt.setString(2, "%%");
					}else{
						pstmt.setString(2, reform.getSection().trim());
					}
					pstmt.setString(3, reform.getTerm().trim());
					pstmt.setString(4, reform.getAccyear().trim());
					
					
					rs=pstmt.executeQuery();
					
					while(rs.next()){
					

						FeeReportDetailsVo vo=new FeeReportDetailsVo();
						
						if(feeStatusList.size()!=0){
						
						if(!(feeStatusList.get(feeStatusList.size()-1).getSectioncode().equalsIgnoreCase(rs.getString("classsection_id_int")))){
							
							feeMap.put(feeStatusList.get(feeStatusList.size()-1).getClassName()+"-"+feeStatusList.get(feeStatusList.size()-1).getSectionname(), feeStatusList);
							
							count=0;
							feeStatusList = new ArrayList<FeeReportDetailsVo>();
						}
						
						}
						
						count++;
						
						vo.setSno(count);
						vo.setAdmissionNo(rs.getString("student_admissionno_var"));
						vo.setStudentName(rs.getString("studentname"));
						vo.setActualAmount(Math.round(classFeeAmt+stageFeeAmt));
						vo.setConcAmount(0.0);
						vo.setPaidDate("-");
						vo.setBalanceAmount(Math.round(classFeeAmt+stageFeeAmt));
						vo.setStatus("Not Paid");
						vo.setClassName(rs.getString("classdetails_name_var"));
						vo.setSectioncode(rs.getString("classsection_id_int"));
						vo.setSectionname(rs.getString("classsection_name_var"));
						feeStatusList.add(vo);
						
					}
					
					if(feeStatusList.size()!=0){
						
						feeMap.put(feeStatusList.get(feeStatusList.size()-1).getClassName()+"-"+feeStatusList.get(feeStatusList.size()-1).getSectionname(), feeStatusList);
					}
					
				
					
					
					
				}
				
				
			
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null&& (!rs.isClosed())) {
						rs.close();
					}
					if (pstmt != null&& (!pstmt.isClosed())) {
						pstmt.close();
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
					+ " Control in ReportsMenuDaoImpl : getStdFeeStatusReportDetails : Ending");
			
			
			
			return feeMap;
		}
	@Override
	public ArrayList<FeeReportDetailsVo> getStdFeeStatusReportDownload(FeeStatusReportPojo feestatuspojo) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ReportsMenuDaoImpl: getStdFeeStatusReportDownload : Starting");
			
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			
			PreparedStatement ps_classfesAmt = null;
			ResultSet rs_classfesAmt=null;
			
			PreparedStatement ps_stagefesAmt = null;
			ResultSet rs_stagefesAmt=null;
			
			Connection conn = null;
			ArrayList<FeeReportDetailsVo> feeStatusList=new ArrayList<FeeReportDetailsVo>();
			int count=0;
		 	
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
				double classFeeAmt=0.0;
				
				ps_classfesAmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_CLASS_FEE_AMOUNT);
				
				ps_classfesAmt.setString(1, feestatuspojo.getClassname().trim());
				ps_classfesAmt.setString(2, feestatuspojo.getAccyear().trim());
				ps_classfesAmt.setString(3, feestatuspojo.getTerm().trim());
			
				
				
				rs_classfesAmt=ps_classfesAmt.executeQuery();
				
				while(rs_classfesAmt.next()){
					
					classFeeAmt=rs_classfesAmt.getInt("ActualAmount");
					
				}
				
				double stageFeeAmt=0.0;
				
				ps_stagefesAmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_STAGE_FEE_AMOUNT);
				
				ps_stagefesAmt.setString(1, feestatuspojo.getClassname().trim());
				ps_stagefesAmt.setString(2, feestatuspojo.getAccyear().trim());
				ps_stagefesAmt.setString(3, feestatuspojo.getTerm().trim());
			
				
				
				rs_stagefesAmt=ps_stagefesAmt.executeQuery();
				
				while(rs_stagefesAmt.next()){
					
					stageFeeAmt=rs_stagefesAmt.getInt("transportfee");
					
				}
				
				if(feestatuspojo.getStatus().trim().equalsIgnoreCase("ALL")){
					
					pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_FEE_STATUS_REPORT);
					pstmt.setString(1, feestatuspojo.getTerm().trim());
					pstmt.setString(2, feestatuspojo.getAccyear().trim());
					pstmt.setString(3, feestatuspojo.getClassname().trim());
					if(feestatuspojo.getSection().trim().equalsIgnoreCase("all")){
						pstmt.setString(4, "%%");
					}else{
						pstmt.setString(4, feestatuspojo.getSection().trim());
					}
					
					
					rs=pstmt.executeQuery();
					
					while(rs.next()){
					

						FeeReportDetailsVo vo=new FeeReportDetailsVo();
						
									
						count++;
						
						vo.setSno(count);
						vo.setAdmissionNo(rs.getString("student_admissionno_var"));
						vo.setStudentName(rs.getString("studentname"));
						vo.setActualAmount(Math.round(classFeeAmt+stageFeeAmt));
						vo.setConcAmount(rs.getDouble("conc_amount"));
						vo.setPaidAmount(Math.round(rs.getDouble("totalamount")));
						if(rs.getString("paidDate")==null || "".equalsIgnoreCase(rs.getString("paidDate"))){
							
							vo.setPaidDate("-");
						}else{
							
							vo.setPaidDate(HelperClass.convertDatabaseToUI(rs.getString("paidDate")));
						}
						
						vo.setBalanceAmount(Math.round(classFeeAmt+stageFeeAmt-rs.getDouble("totalamount")-rs.getDouble("conc_amount")));
						vo.setStatus(rs.getString("feestatus"));
						vo.setClassName(rs.getString("classdetails_name_var")+"-"+rs.getString("classsection_name_var"));
						vo.setSectioncode(rs.getString("classsection_id_int"));
						vo.setSectionname(rs.getString("classsection_name_var"));
						feeStatusList.add(vo);
						
					}
									
				}else if(feestatuspojo.getStatus().trim().equalsIgnoreCase("Paid")){
					
					pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_FEEPAID_STATUS_REPORT);
					pstmt.setString(1, feestatuspojo.getClassname().trim());
					if(feestatuspojo.getSection().trim().equalsIgnoreCase("all")){
						pstmt.setString(2, "%%");
					}else{
						pstmt.setString(2, feestatuspojo.getSection().trim());
					}
					pstmt.setString(3, feestatuspojo.getTerm().trim());
					pstmt.setString(4, feestatuspojo.getAccyear().trim());
					
					
					rs=pstmt.executeQuery();
					
					while(rs.next()){
					

						FeeReportDetailsVo vo=new FeeReportDetailsVo();
											
						count++;
						
						vo.setSno(count);
						vo.setAdmissionNo(rs.getString("student_admissionno_var"));
						vo.setStudentName(rs.getString("studentname"));
						vo.setActualAmount(Math.round(rs.getDouble("actualamount")));
						vo.setConcAmount(rs.getDouble("conc_amount"));
						vo.setPaidAmount(Math.round(rs.getDouble("totalamount")));
						vo.setPaidDate(HelperClass.convertDatabaseToUI(rs.getString("paidDate")));
						vo.setBalanceAmount(Math.round(rs.getDouble("actualamount")-rs.getDouble("totalamount")-rs.getDouble("conc_amount")));
						vo.setStatus("Paid");
						vo.setClassName(rs.getString("classdetails_name_var")+"-"+rs.getString("classsection_name_var"));
						vo.setSectioncode(rs.getString("classsection_id_int"));
						vo.setSectionname(rs.getString("classsection_name_var"));
						feeStatusList.add(vo);
						
					}
					
								
				}else if(feestatuspojo.getStatus().trim().equalsIgnoreCase("NotPaid")){
					
					pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_FEENOTPAID_STATUS_REPORT);
					pstmt.setString(1, feestatuspojo.getClassname().trim());
					if(feestatuspojo.getSection().trim().equalsIgnoreCase("all")){
						pstmt.setString(2, "%%");
					}else{
						pstmt.setString(2, feestatuspojo.getSection().trim());
					}
					pstmt.setString(3, feestatuspojo.getTerm().trim());
					pstmt.setString(4, feestatuspojo.getAccyear().trim());
					
					rs=pstmt.executeQuery();
					
					while(rs.next()){
					

						FeeReportDetailsVo vo=new FeeReportDetailsVo();
						
						count++;
						
						vo.setSno(count);
						vo.setAdmissionNo(rs.getString("student_admissionno_var"));
						vo.setStudentName(rs.getString("studentname"));
						vo.setActualAmount(Math.round(classFeeAmt+stageFeeAmt));
						vo.setConcAmount(0.0);
						vo.setPaidDate("-");
						vo.setBalanceAmount(Math.round(classFeeAmt+stageFeeAmt));
						vo.setStatus("Not Paid");
						vo.setClassName(rs.getString("classdetails_name_var")+"-"+rs.getString("classsection_name_var"));
						vo.setSectioncode(rs.getString("classsection_id_int"));
						vo.setSectionname(rs.getString("classsection_name_var"));
						feeStatusList.add(vo);
						
					}
					
									
				}
				
				
			
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null&& (!rs.isClosed())) {
						rs.close();
					}
					if (pstmt != null&& (!pstmt.isClosed())) {
						pstmt.close();
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
					+ " Control in ReportsMenuDaoImpl : getStdFeeStatusReportDownload : Ending");
			
	
			
			return feeStatusList;
		}

	@Override
	public HashMap<String, ArrayList<MarksUploadVO>> getStdMarksDetails(
			ReportMenuForm reform) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ReportsMenuDaoImpl: getStdMarksDetails : Starting");
			
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			
			Connection conn = null;
			ArrayList<MarksUploadVO> marksList=new ArrayList<MarksUploadVO>();
			
			HashMap<String, ArrayList<MarksUploadVO>> marksMap=new HashMap<String, ArrayList<MarksUploadVO>>();
			
			int count=0;
		 	
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
									
					pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_STUDENT_MARKS);
					pstmt.setString(1, reform.getExam().trim());
					pstmt.setString(2, reform.getClassname().trim());
					pstmt.setString(3, reform.getSection().trim());
					pstmt.setString(4, reform.getStudentId().trim());
					pstmt.setString(5, reform.getAccyear().trim());
					
					System.out.println("pstmt :: "+pstmt);
					
					rs=pstmt.executeQuery();
					
					while(rs.next()){
					
						MarksUploadVO vo=new MarksUploadVO();
					
						count++;
						
						vo.setSno(count);
						vo.setAdmissionno(rs.getString("student_admissionno_var"));
						vo.setStudentname(rs.getString("studentName"));
						vo.setExamname(rs.getString("examname"));
						vo.setSubjectname(rs.getString("subjectName"));
						vo.setMaxmarks(rs.getString("maximum_marks"));
						vo.setReqmarks(rs.getString("required_marks"));
						vo.setScoredmarks(rs.getString("scoredmarks"));
						
						vo.setMarkspercent((Double.parseDouble(rs.getString("scoredmarks"))/Double.parseDouble(rs.getString("maximum_marks")))*100);
						
						
						marksList.add(vo);
						
					}
					
					if(marksList.size()!=0){
						marksMap.put(marksList.get(marksList.size()-1).getStudentname()+"-"+marksList.get(marksList.size()-1).getExamname(), marksList);
					}
					
			
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null&& (!rs.isClosed())) {
						rs.close();
					}
					if (pstmt != null&& (!pstmt.isClosed())) {
						pstmt.close();
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
					+ " Control in ReportsMenuDaoImpl : getStdFeeStatusReportDetails : Ending");
			
			return marksMap;
		}
	
	@Override
	public  ArrayList<MarksUploadVO> getStdMarksDetailsDownload(MarksPOJO reform) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ReportsMenuDaoImpl: getStdMarksDetails : Starting");
			
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			
			Connection conn = null;
			ArrayList<MarksUploadVO> marksList=new ArrayList<MarksUploadVO>();
			
			int count=0;
		 	
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
									
					pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_STUDENT_MARKS);
					pstmt.setString(1, reform.getExamid().trim());
					pstmt.setString(2, reform.getClassid().trim());
					pstmt.setString(3, reform.getSection().trim());
					pstmt.setString(4, reform.getStudentid().trim());
					pstmt.setString(5, reform.getAccyear().trim());
					
					System.out.println("pstmt :: "+pstmt);
					
					rs=pstmt.executeQuery();
					
					while(rs.next()){
					
						MarksUploadVO vo=new MarksUploadVO();
					
						count++;
						
						vo.setSno(count);
						vo.setAdmissionno(rs.getString("student_admissionno_var"));
						vo.setStudentname(rs.getString("studentName")+"-"+rs.getString("examname"));
						vo.setExamname(rs.getString("examname"));
						vo.setSubjectname(rs.getString("subjectName"));
						vo.setMaxmarks(rs.getString("maximum_marks"));
						vo.setReqmarks(rs.getString("required_marks"));
						vo.setScoredmarks(rs.getString("scoredmarks"));
						
						vo.setMarkspercent((Double.parseDouble(rs.getString("scoredmarks"))/Double.parseDouble(rs.getString("maximum_marks")))*100);
						
						
						marksList.add(vo);
						
					}
					
			
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null&& (!rs.isClosed())) {
						rs.close();
					}
					if (pstmt != null&& (!pstmt.isClosed())) {
						pstmt.close();
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
					+ " Control in ReportsMenuDaoImpl : getStdFeeStatusReportDetails : Ending");
			
			return marksList;
		}

	@Override
	public ArrayList<ExaminationDetailsVo> examReportClassWiseDetails(ReportMenuForm reform) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ReportsMenuDaoImpl: examReportClassWiseDetails : Starting");
			
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			
			Connection conn = null;
			ArrayList<ExaminationDetailsVo> examlist=new ArrayList<ExaminationDetailsVo>();
			
			int count=0;
		 	
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
									
					pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_CLASS_WISE_EXAM_DETAILS);
				
					pstmt.setString(1, reform.getClassname().trim());
					pstmt.setString(2, reform.getAccyear().trim());
					
					
					System.out.println("pstmt :: "+pstmt);
					
					rs=pstmt.executeQuery();
					
					while(rs.next()){
					
						ExaminationDetailsVo vo=new ExaminationDetailsVo();
					
						count++;
						
						vo.setSno1(count);
						vo.setExamName(rs.getString("examname"));
						vo.setSubjectName(rs.getString("subjectName"));
						vo.setMaxmarks(rs.getString("maximum_marks"));
						vo.setRequiredmarks(rs.getString("required_marks"));
						vo.setExaminationdate(HelperClass.convertDatabaseToUI(rs.getString("examdate")));
						vo.setStartTime(rs.getString("examtime"));
						vo.setEndTime(rs.getString("endtime"));
						
						examlist.add(vo);
						
					}
					
			
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null&& (!rs.isClosed())) {
						rs.close();
					}
					if (pstmt != null&& (!pstmt.isClosed())) {
						pstmt.close();
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
					+ " Control in ReportsMenuDaoImpl : examReportClassWiseDetails : Ending");
			
			return examlist;
		}
	
	


}
