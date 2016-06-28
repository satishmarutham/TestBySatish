package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.campus.dao.FeeCollectionDao;
import com.centris.campus.util.FeeCollectionSqlUtils;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.FeeCollectionVo;
import com.centris.campus.vo.FeeNameVo;

public class FeeCollectionDaoImpl implements FeeCollectionDao{
	
	private static final Logger logger = Logger.getLogger(FeeCollectionDaoImpl.class);

	@Override
	public ArrayList<FeeCollectionVo> getFeeCollectionDetails(String currentYear) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in FeeCollectionDaoImpl: getFeeCollectionDetails : Starting");
			
			PreparedStatement ps_insertPlan = null;
			ResultSet rs=null;
			Connection conn = null;
			ArrayList<FeeCollectionVo> feeCollectionList=new ArrayList<FeeCollectionVo>();
			int count=0;
			PreparedStatement ps1= null;
			ResultSet rs1=null;
			
			try {
				
				conn = JDBCConnection.getSeparateConnection();
			
				ps_insertPlan = conn.prepareStatement(FeeCollectionSqlUtils.GETFEECOLLECTION_LIST);
				ps_insertPlan.setString(1,currentYear);
				
				rs=ps_insertPlan.executeQuery();
				
				while(rs.next()){
					
					boolean flag=true;
					count++;
					
					FeeCollectionVo collectionVo=new FeeCollectionVo();
					
					collectionVo.setAddmissionno(rs.getString("student_admissionno_var"));
					collectionVo.setStudentname(rs.getString("studentname"));
					collectionVo.setTerm(rs.getString("termname"));
					collectionVo.setSno(count);
					collectionVo.setClassId(rs.getString("classdetail_id_int"));
					collectionVo.setSectionId(rs.getString("classsection_id_int"));
					collectionVo.setTermid(rs.getString("termid"));
					collectionVo.setAccYear(currentYear);
					
					
					ps1 = conn.prepareStatement(FeeCollectionSqlUtils.GET_FEECOLLECTION_LIST);
					ps1.setString(1, rs.getString("student_admissionno_var"));
					ps1.setString(2, currentYear);
					ps1.setString(3, rs.getString("termid"));
					
					System.out.println("ps1:: "+ps1);
					
					rs1=ps1.executeQuery();
					
					while(rs1.next()){
						flag=false;
						collectionVo.setAmount(rs1.getString("totalamount"));
						collectionVo.setStatus("Paid");
					}
					
					if(flag){
						
						collectionVo.setAmount("0.0");
						collectionVo.setStatus("Not Paid");
					}
					
					feeCollectionList.add(collectionVo);
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
					if (ps_insertPlan != null&& (!ps_insertPlan.isClosed())) {
						ps_insertPlan.close();
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
					+ " Control in FeeCollectionDaoImpl: getFeeCollectionDetails: Ending");
			
			return feeCollectionList;
		}

	public FeeCollectionVo getFeeCollectionAmount(String feecollectioncode) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in FeeCollectionDaoImpl: getFeeCollectionAmount : Starting");
			
			PreparedStatement ps_insertPlan = null;
			ResultSet rs=null;
			Connection conn = null;
			int count=0;
			
			PreparedStatement ps_collection_count= null;
			ResultSet rs_collection_count=null;
			
			PreparedStatement ps_feelist= null;
			ResultSet rs_feelist=null;
			
			PreparedStatement ps_transportfee= null;
			ResultSet rs_transportfee=null;
			
			FeeCollectionVo collectionVo=new FeeCollectionVo();
			
			try {
				
				String[] feeDatails=feecollectioncode.split(",");
				
				String addmissionno=feeDatails[0];
				String classId=feeDatails[1];
				String termId=feeDatails[2];
				String accyearId=feeDatails[3];
				
				conn = JDBCConnection.getSeparateConnection();
			
				ps_insertPlan = conn.prepareStatement(FeeCollectionSqlUtils.GET_FEECOLLECTION_DEDDER);
				ps_insertPlan.setString(1,accyearId);
				ps_insertPlan.setString(2,addmissionno);
				ps_insertPlan.setString(3,termId);
				
				System.out.println("hedder details :: "+ps_insertPlan);
				
				rs=ps_insertPlan.executeQuery();
				
				while(rs.next()){
					
					collectionVo.setAddmissionno(rs.getString("student_admissionno_var"));
					collectionVo.setStudentname(rs.getString("studentname"));
					
					collectionVo.setTerm(rs.getString("termname"));
					collectionVo.setTermid(termId);
				
					collectionVo.setClassname(rs.getString("classdetails_name_var"));
					collectionVo.setClassId(classId);
					
					collectionVo.setSectionname(rs.getString("classsection_name_var"));
				
					collectionVo.setAccYear(accyearId);
					collectionVo.setAccYearname(rs.getString("acadamic_year"));
					
					collectionVo.setConcession(rs.getDouble("percentage"));
					
					ps_collection_count = conn.prepareStatement(FeeCollectionSqlUtils.FEE_COLLECTION_COUNT);
					
					ps_collection_count.setString(1, addmissionno);
					ps_collection_count.setString(2, accyearId);
					ps_collection_count.setString(3, termId);
					
					System.out.println("count  :: "+ps_collection_count);
					
					rs_collection_count=ps_collection_count.executeQuery();
					
					int feeCollectionCount=0;
					
					while(rs_collection_count.next()){
						
						feeCollectionCount=rs_collection_count.getInt(1);
					}
					
					if(feeCollectionCount==0){
						
						ps_feelist=conn.prepareStatement(FeeCollectionSqlUtils.GET_FEECOLLECTION_AMOUNT);
						
						ps_feelist.setString(1, classId);
						ps_feelist.setString(2, accyearId);
						ps_feelist.setString(3, termId);
						
						System.out.println("fee name list :: "+ps_feelist);
						
						rs_feelist=ps_feelist.executeQuery();
						
						ArrayList<FeeNameVo> feeNameList=new ArrayList<FeeNameVo>();
						
						double tot_actual_amt=0;
						double tot_concessionl_amt=0;
						double tot_paid_amt=0;
						
						
						while(rs_feelist.next()){
							
							count++;
							
							FeeNameVo feeNameVo=new FeeNameVo();
							
							feeNameVo.setSno(count);
							feeNameVo.setFeecode(rs_feelist.getString("FeeCode"));
							feeNameVo.setFeename(rs_feelist.getString("FeeName"));
							feeNameVo.setIsconcession(rs_feelist.getString("isconcession"));
							
							double actualamt=rs_feelist.getDouble("feeAmount");
							double concessionAmt=0.0;
							
							if("Y".equalsIgnoreCase(rs_feelist.getString("isconcession"))){
								
								concessionAmt=(actualamt*rs.getDouble("percentage"))/100;
							}
							double paidAmt=actualamt-concessionAmt;
							
							feeNameVo.setActualAmt(actualamt);
							
							feeNameVo.setConcessionAmt(concessionAmt);
							feeNameVo.setPaidAmt(paidAmt);
							
							feeNameList.add(feeNameVo);
							
							tot_actual_amt=tot_actual_amt+actualamt;
							tot_concessionl_amt=tot_concessionl_amt+concessionAmt;
							tot_paid_amt=tot_paid_amt+paidAmt;
							
							
						}
						
						ps_transportfee=conn.prepareStatement(FeeCollectionSqlUtils.GET_TRANSPORT_FEE);
						ps_transportfee.setString(1, classId);
						ps_transportfee.setString(2, accyearId);
						ps_transportfee.setString(3, termId);
						ps_transportfee.setString(4, addmissionno);
						
						rs_transportfee=ps_transportfee.executeQuery();
						
						while(rs_transportfee.next()){
							
							count++;
							FeeNameVo feeNameVo=new FeeNameVo();
							feeNameVo.setSno(count);
							feeNameVo.setFeename("TransportFee");
							feeNameVo.setFeecode(rs_transportfee.getString("stagecode"));
							feeNameVo.setActualAmt(rs_transportfee.getDouble("feeAmount"));
							feeNameVo.setPaidAmt(rs_transportfee.getDouble("feeAmount"));
							
							feeNameList.add(feeNameVo);
							
							tot_actual_amt=tot_actual_amt+rs_transportfee.getDouble("feeAmount");
							tot_paid_amt=tot_paid_amt+rs_transportfee.getDouble("feeAmount");
						}
						
						collectionVo.setFeeNamelist(feeNameList);
						collectionVo.setTot_actual_amt(tot_actual_amt);
						collectionVo.setTot_concession_amt(tot_concessionl_amt);
						collectionVo.setTot_paid_amt(tot_paid_amt);
						
						
						
						
					}else{
						
						System.out.println("in side else");
						
						ps_feelist=conn.prepareStatement(FeeCollectionSqlUtils.GET_EXIST_FEECOLLECTION_AMOUNT);
						
						ps_feelist.setString(1, addmissionno);
						ps_feelist.setString(2, accyearId);
						ps_feelist.setString(3, termId);
						
						System.out.println("fee name list :: "+ps_feelist);
						
						rs_feelist=ps_feelist.executeQuery();
						
						ArrayList<FeeNameVo> feeNameList=new ArrayList<FeeNameVo>();
						
						double tot_actual_amt=0;
						double tot_concessionl_amt=0;
						double tot_paid_amt=0;
						
						
						while(rs_feelist.next()){
							
							count++;
							
							FeeNameVo feeNameVo=new FeeNameVo();
							
							feeNameVo.setSno(count);
							feeNameVo.setFeecode(rs_feelist.getString("FeeCode"));
							feeNameVo.setFeename(rs_feelist.getString("FeeName"));
							feeNameVo.setIsconcession(rs_feelist.getString("isconcession"));
							
							
							
							tot_actual_amt=Double.parseDouble(rs_feelist.getString("actualamount"));
							tot_concessionl_amt=Double.parseDouble(rs_feelist.getString("conc_amount"));
							tot_paid_amt=Double.parseDouble(rs_feelist.getString("totalamount"));
							
							double actualamt=Double.parseDouble(rs_feelist.getString("feeAmount"));
							double paidAmt=Double.parseDouble(rs_feelist.getString("finalFeeAmt"));
							double concessionAmt=actualamt-paidAmt;
							
							feeNameVo.setActualAmt(actualamt);
					
							feeNameVo.setPaidAmt(paidAmt);
							
							
							feeNameVo.setConcessionAmt(concessionAmt);
							
							feeNameList.add(feeNameVo);
							
							
						}
						
						ps_transportfee=conn.prepareStatement(FeeCollectionSqlUtils.GET_EXIST_TRANSPORT_AMOUNT);
						
						ps_transportfee.setString(1, addmissionno);
						ps_transportfee.setString(2, accyearId);
						ps_transportfee.setString(3, termId);
						
						rs_transportfee=ps_transportfee.executeQuery();
						
						while(rs_transportfee.next()){
							
							count++;
							FeeNameVo feeNameVo=new FeeNameVo();
							feeNameVo.setSno(count);
							feeNameVo.setFeename("TransportFee");
							feeNameVo.setFeecode(rs_transportfee.getString("stage_id"));
							feeNameVo.setActualAmt(rs_transportfee.getDouble("feeAmount"));
							feeNameVo.setPaidAmt(rs_transportfee.getDouble("feeAmount"));
							
							feeNameList.add(feeNameVo);
							
						}
						
						collectionVo.setFeeNamelist(feeNameList);
						collectionVo.setTot_actual_amt(tot_actual_amt);
						collectionVo.setTot_concession_amt(tot_concessionl_amt);
						collectionVo.setTot_paid_amt(tot_paid_amt);
						
					}
			
				}
				
				JSONArray array=new JSONArray();
				
				array.put(collectionVo.getFeeNamelist());
				
				System.out.println("collectionVo :: "+array);
				
				
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
					if (ps_insertPlan != null&& (!ps_insertPlan.isClosed())) {
						ps_insertPlan.close();
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
					+ " Control in FeeCollectionDaoImpl: getFeeCollectionAmount: Ending");
			
			return collectionVo;
		}
	

	@Override
	public String saveFeeCollection(FeeCollectionVo collectionVo) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in FeeCollectionDaoImpl: saveFeeCollection : Starting");
			
			PreparedStatement ps_insertPlan = null;
			Connection conn = null;
			int count=0;
			PreparedStatement ps1= null;
			int result=0;
			String status=null;
			
			PreparedStatement ps_collection_count=null;
			ResultSet rs_collection_count=null;
			
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
				ps_collection_count = conn.prepareStatement(FeeCollectionSqlUtils.GET_COLLECTION_UPDATE_CNT);
				
				ps_collection_count.setString(1, collectionVo.getAddmissionno());
				ps_collection_count.setString(2, collectionVo.getAccYear());
				ps_collection_count.setString(3, collectionVo.getTermid());
				
				System.out.println("count  :: "+ps_collection_count);
				
				rs_collection_count=ps_collection_count.executeQuery();
				
				String feeCollectionCount=null;
				
				while(rs_collection_count.next()){
					
					feeCollectionCount=rs_collection_count.getString(1);
				}
				
				if(feeCollectionCount==null){
				
				String primaryKey=IDGenerator.getPrimaryKeyID("campus_fee_collection");
				
			
				ps_insertPlan = conn.prepareStatement(FeeCollectionSqlUtils.INSERT_FEE_COLLECTION);
				
				ps_insertPlan.setString(1,primaryKey);
				ps_insertPlan.setString(2,collectionVo.getAddmissionno());
				ps_insertPlan.setString(3,collectionVo.getAccYear());
				ps_insertPlan.setString(4,collectionVo.getTermid());
				ps_insertPlan.setString(5,"Y");
				ps_insertPlan.setDouble(6,collectionVo.getTot_paid_amt());
				ps_insertPlan.setDouble(7,collectionVo.getTot_actual_amt());
				ps_insertPlan.setDouble(8,collectionVo.getTot_concession_amt());
				ps_insertPlan.setDouble(9,collectionVo.getConcession());
				ps_insertPlan.setDate(10,HelperClass.getCurrentSqlDate());
				ps_insertPlan.setString(11,collectionVo.getUserID());
				ps_insertPlan.setTimestamp(12,HelperClass.getCurrentTimestamp());
				
				count=ps_insertPlan.executeUpdate();
				
				if(count>0){
					
					ps1 = conn.prepareStatement(FeeCollectionSqlUtils.INSERT_FEE_COLLECTION_DETAILS);
					
					for(int i=0;i<collectionVo.getFeeNamelist().size();i++){
					
						ps1.setString(1,primaryKey);
						ps1.setString(2,collectionVo.getFeeNamelist().get(i).getFeecode());
						ps1.setDouble(3,collectionVo.getFeeNamelist().get(i).getActualAmt());
						ps1.setDouble(4,collectionVo.getFeeNamelist().get(i).getPaidAmt());
						
						result=ps1.executeUpdate();
					}
					
				}
				
			}else{
				
			
				ps_insertPlan = conn.prepareStatement(FeeCollectionSqlUtils.UPDATE_FEE_COLLECTION);
				
			
				ps_insertPlan.setDouble(1,collectionVo.getTot_paid_amt());
				ps_insertPlan.setDouble(2,collectionVo.getTot_actual_amt());
				ps_insertPlan.setDouble(3,collectionVo.getTot_concession_amt());
				ps_insertPlan.setDouble(4,collectionVo.getConcession());
				ps_insertPlan.setString(5,collectionVo.getUserID());
				ps_insertPlan.setTimestamp(6,HelperClass.getCurrentTimestamp());
				ps_insertPlan.setString(7,feeCollectionCount);
				
				count=ps_insertPlan.executeUpdate();
				
				if(count>0){
					
					ps1 = conn.prepareStatement(FeeCollectionSqlUtils.UPDATE_FEE_COLLECTION_DETAILS);
					
					for(int i=0;i<collectionVo.getFeeNamelist().size();i++){
					
						ps1.setDouble(1,collectionVo.getFeeNamelist().get(i).getActualAmt());
						ps1.setDouble(2,collectionVo.getFeeNamelist().get(i).getPaidAmt());
						ps1.setString(3,feeCollectionCount);
						ps1.setString(4,collectionVo.getFeeNamelist().get(i).getFeecode());
						
						result=ps1.executeUpdate();
					}
					
				}
				
			}
				
				if(result>0){
					
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
					
					if (ps_insertPlan != null&& (!ps_insertPlan.isClosed())) {
						ps_insertPlan.close();
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
					+ " Control in FeeCollectionDaoImpl: getFeeCollectionDetails: Ending");
			
			return status;
		}

	@Override
	public ArrayList<FeeCollectionVo> getSearchFeeCollectionDetails(
			String currentYear, String classid, String sectionId) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in FeeCollectionDaoImpl: getSearchFeeCollectionDetails : Starting");
			
			PreparedStatement ps_insertPlan = null;
			ResultSet rs=null;
			Connection conn = null;
			ArrayList<FeeCollectionVo> feeCollectionList=new ArrayList<FeeCollectionVo>();
			int count=0;
			PreparedStatement ps1= null;
			ResultSet rs1=null;
			
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
				if(classid.trim().equalsIgnoreCase("")){
					
					classid="%%";
				}
				
				if(sectionId.trim().equalsIgnoreCase("")){
					
					sectionId="%%";
				}
			
				ps_insertPlan = conn.prepareStatement(FeeCollectionSqlUtils.GET_SEARCH_FEECOLLECTION_LIST);
				ps_insertPlan.setString(1,currentYear);
				ps_insertPlan.setString(2,classid);
				ps_insertPlan.setString(3,sectionId);
				
				rs=ps_insertPlan.executeQuery();
				
				while(rs.next()){
					
					boolean flag=true;
					count++;
					
					FeeCollectionVo collectionVo=new FeeCollectionVo();
					
					collectionVo.setAddmissionno(rs.getString("student_admissionno_var"));
					collectionVo.setStudentname(rs.getString("studentname"));
					collectionVo.setTerm(rs.getString("termname"));
					collectionVo.setSno(count);
					collectionVo.setClassId(rs.getString("classdetail_id_int"));
					collectionVo.setSectionId(rs.getString("classsection_id_int"));
					collectionVo.setTermid(rs.getString("termid"));
					collectionVo.setAccYear(currentYear);
					
					
					ps1 = conn.prepareStatement(FeeCollectionSqlUtils.GET_FEECOLLECTION_LIST);
					ps1.setString(1, rs.getString("student_admissionno_var"));
					ps1.setString(2, currentYear);
					ps1.setString(3, rs.getString("termid"));
					
					System.out.println("ps1:: "+ps1);
					
					rs1=ps1.executeQuery();
					
					while(rs1.next()){
						flag=false;
						collectionVo.setAmount(rs1.getString("totalamount"));
						collectionVo.setStatus("Paid");
					}
					
					if(flag){
						
						collectionVo.setAmount("0.0");
						collectionVo.setStatus("Not Paid");
					}
					
					feeCollectionList.add(collectionVo);
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
					if (ps_insertPlan != null&& (!ps_insertPlan.isClosed())) {
						ps_insertPlan.close();
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
					+ " Control in FeeCollectionDaoImpl: getSearchFeeCollectionDetails: Ending");
			
			return feeCollectionList;
		}

	   

}
