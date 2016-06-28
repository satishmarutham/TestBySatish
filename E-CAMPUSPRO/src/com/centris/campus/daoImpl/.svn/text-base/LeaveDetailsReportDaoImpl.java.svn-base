package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.campus.dao.LeaveDetailsReportDao;
import com.centris.campus.forms.LeaveDetailsReportForm;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.LeaveReportSqlUtils;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.LeaveDetailsReportVo;
import com.centris.campus.vo.LeaveStatusListVO;
import com.centris.campus.vo.TeacherVo;



public class LeaveDetailsReportDaoImpl implements LeaveDetailsReportDao{
	
private static Logger logger = Logger.getLogger(LeaveDetailsReportDaoImpl.class);
	
	Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
	int year=localCalendar.get(Calendar.YEAR);
	
	
	public  ArrayList<LeaveDetailsReportVo> getLeaveDetails(LeaveDetailsReportForm leaveDetailsReportForm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveDetailsReportDaoImpl: getLeaveDetails : Starting");
		
		PreparedStatement ps_leave=null;
		ResultSet rs_leave=null;
		Connection connection=null;
		
		PreparedStatement ps_leaveType=null;
		ResultSet rs_leaveType=null;
		
		PreparedStatement ps_Accyear=null;
		ResultSet rs_Accyear=null;
		
		PreparedStatement ps_leave1=null;
		ResultSet rs_leave1=null;
		
		
		PreparedStatement ps_leavecount=null;
		ResultSet rs_leave_count=null;
		double total_no_of_leaves=0;
		double total_no_of_sl=0, total_no_of_pl=0, total_no_of_cl=0;
		
		if(leaveDetailsReportForm.getDepartment().equalsIgnoreCase("all")){
			
			leaveDetailsReportForm.setDepartment("%%");
		}
		
		if(leaveDetailsReportForm.getTeachingtype().equalsIgnoreCase("all")){
			
			leaveDetailsReportForm.setTeachingtype("%%");
		}
		
		if(leaveDetailsReportForm.getTeachername().equalsIgnoreCase("all")){
			
			leaveDetailsReportForm.setTeachername("%%");
		}
		
		
	
		ArrayList<LeaveDetailsReportVo> leave_list=new ArrayList<LeaveDetailsReportVo>();
		
		
		ArrayList<TeacherVo> teacherList=new ArrayList<TeacherVo>();
		try {
		
			connection=JDBCConnection.getSeparateConnection();
			
			
			ps_leavecount=connection.prepareStatement(LeaveReportSqlUtils.GET_NO_OF_LEAVES);
			ps_leavecount.setString(1,leaveDetailsReportForm.getAccyear());
			
			System.out.println("no of leaves  ::: "+ps_leavecount);
			
			rs_leave_count=ps_leavecount.executeQuery();
			
			while(rs_leave_count.next()){
				
				total_no_of_leaves=rs_leave_count.getDouble("total_leaves");
				 total_no_of_sl=rs_leave_count.getDouble("SL");
				 total_no_of_pl=rs_leave_count.getDouble("PL");
				 total_no_of_cl=rs_leave_count.getDouble("CL");
				
			}
		
	
				String[] date_of_join=new String[10];
				LeaveDetailsReportVo leave_vo=null;
				
				
				
				ps_leave1=connection.prepareStatement(LeaveReportSqlUtils.GET_EMP_FOR_LEAVES);
				ps_leave1.setString(1,leaveDetailsReportForm.getTeachername());
				ps_leave1.setString(2,leaveDetailsReportForm.getDepartment());
				ps_leave1.setString(3,leaveDetailsReportForm.getTeachingtype());
				
				System.out.println("emp for leaves  ::: "+ps_leave1);
		
				rs_leave1=ps_leave1.executeQuery();
				
				while(rs_leave1.next()){
					
					TeacherVo	teacherLeaveVo=new TeacherVo();
					
					teacherLeaveVo.setTeacherName(rs_leave1.getString("teacherName"));
					teacherLeaveVo.setDoj(rs_leave1.getString("dateofJoining"));
					teacherLeaveVo.setTeacherId(rs_leave1.getString("TeacherID"));
					
					teacherList.add(teacherLeaveVo);
				
				}
							
				for(int i=0;i<teacherList.size();i++){
					
					
					 int slj =0 , plj=0, clj=0;
					 int slf =0, plf=0 , clf=0;
					 int slm=0, plm=0, clm=0;
					 int slap=0, plap=0, clap=0;
					 int slmay=0, plmay=0, clmay=0;
					 int sljune=0, pljune=0, cljune=0;
					 int sljuly=0, pljuly=0, cljuly=0;
					 int slaug=0, plaug=0, claug=0;
					 int slsep=0, plsep=0, clsep=0;
					 int sloct=0, ploct=0, cloct=0;
					 int slnov=0, plnov=0, clnov=0;
					 int sldec=0, pldec=0, cldec=0;
					
					int joining_month=0;
					int joining_Year=0;
					int tot_taken_leaves=0;
					int jan=0, feb=0, mar=0, aprl=0, may=0, june=0,july=0;
					int aug=0, sep=0, oct=0, nov=0, dec=0;
					String jan_str=null;
					String feb_str=null;
					String mar_str=null;
					String aprl_str=null;
					String may_str=null;
					String june_str=null;
					String july_str=null;
					String aug_str=null;
					String sep_str=null;
					String oct_str=null;
					String nov_str=null;
					String dec_str=null;
					String monthfullname ="";
			
			
			leave_vo=new LeaveDetailsReportVo();
			
			leave_vo.setTeachername(teacherList.get(i).getTeacherName());
			leave_vo.setTeacherId(teacherList.get(i).getTeacherId());
			leave_vo.setDoj(teacherList.get(i).getDoj());
			
			
			date_of_join=teacherList.get(i).getDoj().split("-");
			
			

			 joining_Year=Integer.parseInt(date_of_join[2]);
			 joining_month=Integer.parseInt(date_of_join[1]);
			 
			 
			 ArrayList<LeaveStatusListVO> status_list = new ArrayList<LeaveStatusListVO>();
				
				
			 LeaveStatusListVO statusListVO = new LeaveStatusListVO();
			 
			 ps_Accyear=connection.prepareStatement(LeaveReportSqlUtils.GET_ACC_YEAR);
			 ps_Accyear.setString(1, leaveDetailsReportForm.getAccyear());
			 
			 System.out.println("get acc year  ::: "+ps_Accyear);
			 
			 rs_Accyear=ps_Accyear.executeQuery();
			 
			 String startYear=null;
			 String endYear=null;
			 
			 while(rs_Accyear.next()){
				 
				 startYear=rs_Accyear.getString("acadamic_year").split("-")[0];
				 endYear=rs_Accyear.getString("acadamic_year").split("-")[1];
				 
			 }
			 
			 
			 ps_leaveType=connection.prepareStatement(LeaveReportSqlUtils.GET_LEAVES_TYPE_FROM_ATTENDANCE);	
			 
			 ps_leaveType.setString(1,teacherList.get(i).getTeacherId());
			 ps_leaveType.setString(2,startYear);
			 ps_leaveType.setString(3,endYear);
			 
			 System.out.println("get leave type fro att  ::: "+ps_leaveType);
				
			 rs_leaveType=ps_leaveType.executeQuery();
				
	
			 while(rs_leaveType.next()){
				 
				 
				 String LeaveType = rs_leaveType.getString("LeaveType");
				 String[] leavetype_date = rs_leaveType.getString("ApprovedStartDate").split("-");
				  monthfullname=HelperClass.getMonthFullName(leavetype_date[1]);
				 
			
				 if("January".equalsIgnoreCase(monthfullname)){
					 

					 if("SL".equalsIgnoreCase(LeaveType)){
						jan++;
						tot_taken_leaves++;
						slj++;
						
					
					 }
					 if("CL".equalsIgnoreCase(LeaveType)){
							jan++;
							tot_taken_leaves++;
							clj++;
						 }
					 if("PL".equalsIgnoreCase(LeaveType)){
							jan++;
							tot_taken_leaves++;
							plj++;
						
						 }
					}
				 
				 else if("February".equalsIgnoreCase(monthfullname)){
					 if("SL".equalsIgnoreCase(LeaveType)){
							feb++;
							tot_taken_leaves++;
							slf++;
						 }
						 if("CL".equalsIgnoreCase(LeaveType)){
								feb++;
								tot_taken_leaves++;
								clf++;
							 }
						 if("PL".equalsIgnoreCase(LeaveType)){
								feb++;
								tot_taken_leaves++;
								plf++;
							 }
						}
					
				else if("March".equalsIgnoreCase(monthfullname)){
					 
					 if("SL".equalsIgnoreCase(LeaveType)){
							jan++;
							tot_taken_leaves++;
							slm++;
						 }
						 if("CL".equalsIgnoreCase(LeaveType)){
								jan++;
								tot_taken_leaves++;
								clm++;
							 }
						 if("PL".equalsIgnoreCase(LeaveType)){
								jan++;
								tot_taken_leaves++;
								plm++;
							 }
						
					}
				 
				  else if("April".equalsIgnoreCase(monthfullname)){
					
					 if("SL".equalsIgnoreCase(LeaveType)){
							jan++;
							tot_taken_leaves++;
							slap++;
						 }
						 if("CL".equalsIgnoreCase(LeaveType)){
								jan++;
								tot_taken_leaves++;
								clap++;
							 }
						 if("PL".equalsIgnoreCase(LeaveType)){
								jan++;
								tot_taken_leaves++;
								plap++;
							 }
						}
					 
							 
				  	else if("May".equalsIgnoreCase(monthfullname)){
						 if("SL".equalsIgnoreCase(LeaveType)){
								jan++;
								tot_taken_leaves++;
								slmay++;
							 }
							 if("CL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									clmay++;
								 }
							 if("PL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									plmay++;
								 }
							
					}
				  	
				  	else if("June".equalsIgnoreCase(monthfullname)){
						 if("SL".equalsIgnoreCase(LeaveType)){
								jan++;
								tot_taken_leaves++;
								sljune++;
							 }
							 if("CL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									cljune++;
								 }
							 if("PL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									pljune++;
								 }
							
					}else if("July".equalsIgnoreCase(monthfullname)){
						 if("SL".equalsIgnoreCase(LeaveType)){
								jan++;
								tot_taken_leaves++;
								sljuly++;
							 }
							 if("CL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									cljuly++;
								 }
							 if("PL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									pljuly++;
								 }
							
					}else if("August".equalsIgnoreCase(monthfullname)){
						 if("SL".equalsIgnoreCase(LeaveType)){
								jan++;
								tot_taken_leaves++;
								slaug++;
							 }
							 if("CL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									claug++;
								 }
							 if("PL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									plaug++;
								 }
							
					}else if("September".equalsIgnoreCase(monthfullname)){
						 if("SL".equalsIgnoreCase(LeaveType)){
								jan++;
								tot_taken_leaves++;
								slsep++;
							 }
							 if("CL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									clsep++;
								 }
							 if("PL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									plsep++;
								 }
							
					}else if("October".equalsIgnoreCase(monthfullname)){
						 if("SL".equalsIgnoreCase(LeaveType)){
								jan++;
								tot_taken_leaves++;
								sloct++;
							 }
							 if("CL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									cloct++;
								 }
							 if("PL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									ploct++;
								 }
							
					}else if("November".equalsIgnoreCase(monthfullname)){
						
						 if("SL".equalsIgnoreCase(LeaveType)){
								jan++;
								tot_taken_leaves++;
								slnov++;
							 }
							 if("CL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									clnov++;
								 }
							 if("PL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									plnov++;
								 }
							
					}else if("December".equalsIgnoreCase(monthfullname)){
						 if("SL".equalsIgnoreCase(LeaveType)){
								jan++;
								tot_taken_leaves++;
								sldec++;
							 }
							 if("CL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									cldec++;
								 }
							 if("PL".equalsIgnoreCase(LeaveType)){
									jan++;
									tot_taken_leaves++;
									pldec++;
								 }
							
					}
					
			 }	 
				 
				
			 
			
			if(!(joining_Year<year)){
			
		
				
			for(int j=0;j<Integer.parseInt(date_of_join[1]);j++){
				
				if(j==1){
					
					jan_str="NA";
					
				}
				if(j==2){
					
					feb_str="NA";
					System.out.println("feb_str" +feb_str);
				}
				
				if(j==3)
				{
					mar_str="NA";
				}
				if(j==4)
				{
					aprl_str="NA";
				}
				if(j==5)
				{
					may_str="NA";
				}
				if(j==6)
				{
					june_str="NA";
				}
				if(j==7)
				{
					july_str="NA";
				}
				if(j==8)
				{
					aug_str="NA";
				}
				if(j==9)
				{
					sep_str="NA";
				}
				if(j==10)
				{
					oct_str="NA";
				}
				if(j==11)
				{
					nov_str="NA";
				}
				if(j==12)
				{
					dec_str="NA";
				}
				
			}
			
			}	
			
			if("NA".equalsIgnoreCase(jan_str)){
			//	leave_vo.setJan(jan_str);
				statusListVO.setSljan(jan_str);
				statusListVO.setPljan(jan_str);
				statusListVO.setCljan(jan_str);
				leave_vo.setJan(status_list);
			}
			else
			{
				
				statusListVO.setSljan(slj+"");
				statusListVO.setPljan(plj+"");
				statusListVO.setCljan(clj+"");
				
				leave_vo.setJan(status_list);
				
			}
			
			if("NA".equalsIgnoreCase(feb_str)){
				
				statusListVO.setSlfeb(feb_str);
				statusListVO.setPlfeb(feb_str);
				statusListVO.setClfeb(feb_str);
				leave_vo.setFeb(status_list);

				}
			
			else 
			
			{
					statusListVO.setSlfeb(slf+"");
					statusListVO.setPlfeb(plf+"");
					statusListVO.setClfeb(clf+"");
				
					leave_vo.setFeb(status_list);
					
				}
			
			if("NA".equalsIgnoreCase(mar_str)){
				
				statusListVO.setSlmar(mar_str);
				statusListVO.setPlmar(mar_str);
				statusListVO.setClmar(mar_str);
				leave_vo.setMar(status_list);
				
				}else{
					
					
					statusListVO.setSlmar(slm+"");
					statusListVO.setPlmar(plm+"");
					statusListVO.setClmar(clm+"");
					
					leave_vo.setMar(status_list);
					
				
					
				}
				if("NA".equalsIgnoreCase(aprl_str)){
					
					statusListVO.setSlaprl(aprl_str);
					statusListVO.setPlaprl(aprl_str);
					statusListVO.setClaprl(aprl_str);
					leave_vo.setAprl(status_list);
					
				
				}else{
					
					
					statusListVO.setSlaprl(slap+"");
					statusListVO.setPlaprl(plap+"");
					statusListVO.setClaprl(clap+"");
					
					leave_vo.setAprl(status_list);
					
					
					
				}
					if("NA".equalsIgnoreCase(may_str)){
				
						statusListVO.setSlmay(may_str);
						statusListVO.setPlmay(may_str);
						statusListVO.setClmay(may_str);
						leave_vo.setMay(status_list);
				
				}
			else
				{
					
					statusListVO.setSlmay(slmay+"");
					statusListVO.setPlmay(plmay+"");
					statusListVO.setClmay(clmay+"");
					
					leave_vo.setMay(status_list);
					
					
				
				}
			if("NA".equalsIgnoreCase(june_str)){
				
				statusListVO.setSljune(june_str);
				statusListVO.setPljune(june_str);
				statusListVO.setCljune(june_str);
				leave_vo.setJune(status_list);
				}
			
			else
			{
					
					statusListVO.setSljune(sljune+"");
					statusListVO.setPljune(pljune+"");
					statusListVO.setCljune(cljune+"");
				
					leave_vo.setJune(status_list);
					
					
					
				}
			if("NA".equalsIgnoreCase(july_str)){
				
				statusListVO.setSljuly(july_str);
				statusListVO.setPljuly(july_str);
				statusListVO.setCljuly(july_str);
				leave_vo.setJuly(status_list);
				}
			
			else
			{
				
					statusListVO.setSljuly(sljuly+"");
					statusListVO.setPljuly(pljuly+"");
					statusListVO.setCljuly(cljuly+"");
				
					leave_vo.setJuly(status_list);
					
					
				}
			if("NA".equalsIgnoreCase(aug_str)){
				
				statusListVO.setSlaug(aug_str);
				statusListVO.setPlaug(aug_str);
				statusListVO.setClaug(aug_str);
				leave_vo.setAug(status_list);
				
				}else{
				
					
					statusListVO.setSlaug(slaug+"");
					statusListVO.setPlaug(plaug+"");
					statusListVO.setClaug(claug+"");
				
					leave_vo.setAug(status_list);
					
					
				}
			if("NA".equalsIgnoreCase(sep_str)){
				
				statusListVO.setSlsep(sep_str);
				statusListVO.setPlsep(sep_str);
				statusListVO.setClsep(sep_str);
				leave_vo.setSep(status_list);
				
				
				}else{
					
			
					statusListVO.setSlsep(slsep+"");
					statusListVO.setPlsep(plsep+"");
					statusListVO.setClsep(clsep+"");
				
					leave_vo.setSep(status_list);
					
					
				}
			if("NA".equalsIgnoreCase(oct_str)){
				
				statusListVO.setSloct(oct_str);
				statusListVO.setPloct(oct_str);
				statusListVO.setCloct(oct_str);
				leave_vo.setOct(status_list);
			} 
			else
			{
				
					statusListVO.setSloct(sloct+"");
					statusListVO.setPloct(ploct+"");
					statusListVO.setCloct(cloct+"");
					
					leave_vo.setOct(status_list);
					
					
					
				}
			if("NA".equalsIgnoreCase(nov_str)){
				
				statusListVO.setSlnov(nov_str);
				statusListVO.setPlnov(nov_str);
				statusListVO.setClnov(nov_str);
				leave_vo.setNov(status_list);
								
				}else{
					
				
					statusListVO.setSlnov(slnov+"");
					statusListVO.setPlnov(plnov+"");
					statusListVO.setClnov(clnov+"");
				
					leave_vo.setNov(status_list);
					
					
				}
			if("NA".equalsIgnoreCase(dec_str))
			{
				statusListVO.setSldec(dec_str);
				statusListVO.setPldec(dec_str);
				statusListVO.setCldec(dec_str);
				leave_vo.setDec(status_list);
			}
			else{
					
									
					statusListVO.setSldec(sldec+"");
					statusListVO.setPldec(pldec+"");
					statusListVO.setCldec(cldec+"");
				
					leave_vo.setDec(status_list);
					
				}
			
			double leaves=total_no_of_leaves-tot_taken_leaves;
			leave_vo.setTotal(total_no_of_leaves);
			leave_vo.setBalance(leaves);
			
		
			
			status_list.add(statusListVO);
		
			leave_list.add(leave_vo);
		
			
			}
				
	
		}
	catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs_leave != null && (!rs_leave.isClosed())) {

					rs_leave.close();
				}
				if (rs_leave_count != null && (!rs_leave_count.isClosed())) {

					rs_leave_count.close();
				}
				if (ps_leave != null && (! ps_leave.isClosed())) {

					 ps_leave.close();
				}
				if (ps_leavecount != null && (! ps_leavecount.isClosed())) {

					ps_leavecount.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}
				

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveDetailsReportDaoImpl: getLeaveDetails : Ending");
		
		JSONArray array=new JSONArray();
		array.put(leave_list);
		
		System.out.println("list of leaves :: "+array);
		
		return leave_list;
	}
	
	public ArrayList<LeaveDetailsReportVo> getLeaveLabelDetails(
			LeaveDetailsReportForm detailsReportForm) {
		
		PreparedStatement ps_leavelabel = null;
		ResultSet rs_leave = null;
		Connection connectionl=null;
		LeaveDetailsReportVo leaveDetailsReportVo = new LeaveDetailsReportVo();
		
		PreparedStatement ps_Accyear=null;
		ResultSet rs_Accyear=null;
		
		ArrayList<LeaveDetailsReportVo> leave_label=new ArrayList<LeaveDetailsReportVo>();
		try{
			
			connectionl=JDBCConnection.getSeparateConnection();
			
			
			 ps_Accyear=connectionl.prepareStatement(LeaveReportSqlUtils.GET_ACC_YEAR);
			 ps_Accyear.setString(1, detailsReportForm.getAccyear());
			 
			 rs_Accyear=ps_Accyear.executeQuery();
			 
			 String yearname=null;
			 
			 while(rs_Accyear.next()){
				 
				 yearname=rs_Accyear.getString("acadamic_year");
				
				 
			 }
			
			ps_leavelabel=connectionl.prepareStatement(LeaveReportSqlUtils.GET_ALL_LABEL);
			
			ps_leavelabel.setString(1,detailsReportForm.getTeachername());
			ps_leavelabel.setString(2,detailsReportForm.getDepartment());
			ps_leavelabel.setString(3,detailsReportForm.getTeachingtype());
			
			rs_leave=ps_leavelabel.executeQuery();
		
			while(rs_leave.next()){
				
				leaveDetailsReportVo.setAccyearName(yearname);
				leaveDetailsReportVo.setDepartmentname(rs_leave.getString("DEPT_NAME"));
				leaveDetailsReportVo.setTeachertype(rs_leave.getString("teachingType"));
				leaveDetailsReportVo.setTeacherId(rs_leave.getString("TeacherID"));
				leaveDetailsReportVo.setTeachername(rs_leave.getString("teacherName"));
				
				
			leave_label.add(leaveDetailsReportVo);
			}
		
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs_leave != null && (!rs_leave.isClosed())) {

					rs_leave.close();
				}
			
				if (ps_leavelabel != null && (! ps_leavelabel.isClosed())) {

					ps_leavelabel.close();
				}
				
				if (connectionl != null && (!connectionl.isClosed())) {

					connectionl.close();
				}
				

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveDetailsReportDaoImpl: getLeaveDetails : Ending");
		
		
		return leave_label;
	}

	@Override
	public ArrayList<TeacherVo> getTeachername(String teachingtype, String dept) {
		
		PreparedStatement ps_leavelabel = null;
		ResultSet rs_leave = null;
		
		Connection connectionl=null;
		
		ArrayList<TeacherVo> teacherList=new ArrayList<TeacherVo>();
		
		try{
			
			connectionl=JDBCConnection.getSeparateConnection();
			
			
			ps_leavelabel=connectionl.prepareStatement(LeaveReportSqlUtils.GET_TEACHERS);
			if(dept.equalsIgnoreCase("all") && teachingtype.equalsIgnoreCase("all")){
				
				ps_leavelabel.setString(1,"%%");
				ps_leavelabel.setString(2,"%%");
			}
			else if(teachingtype.equalsIgnoreCase("all")){
				
				ps_leavelabel.setString(1,"%%");
				ps_leavelabel.setString(2,dept);
				
			}else if(dept.equalsIgnoreCase("all")){
				
				ps_leavelabel.setString(1,teachingtype);
				ps_leavelabel.setString(2,"%%");
			
			}else{
			
				ps_leavelabel.setString(1,teachingtype);
				ps_leavelabel.setString(2,dept);
			}
			
			
			rs_leave=ps_leavelabel.executeQuery();
		
			while(rs_leave.next()){
				
				TeacherVo teacherVo=new TeacherVo();
				
				teacherVo.setTeacherId(rs_leave.getString("TeacherID"));
				teacherVo.setTeacherName(rs_leave.getString("teacherName"));
				
				teacherList.add(teacherVo);
			}
		
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs_leave != null && (!rs_leave.isClosed())) {

					rs_leave.close();
				}
			
				if (ps_leavelabel != null && (! ps_leavelabel.isClosed())) {

					ps_leavelabel.close();
				}
				
				if (connectionl != null && (!connectionl.isClosed())) {

					connectionl.close();
				}
				

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveDetailsReportDaoImpl: getLeaveDetails : Ending");
		
		
		return teacherList;
	}
	
	
	public static void main(String[] args) {
		
		LeaveDetailsReportForm reportform=new LeaveDetailsReportForm();
		reportform.setAccyear("ACY1");
		reportform.setTeachingtype("all");
		reportform.setDepartment("all");
		reportform.setTeachername("all");
		
		new LeaveDetailsReportDaoImpl().getLeaveDetails(reportform);
	}
	

}
