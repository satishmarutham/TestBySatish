package com.centris.campus.util;

public class SQLUtilConstants {

	public static final String GET_NEXT_ACCADAMIC_YEAR = "select acadamic_id,acadamic_year from campus_acadamicyear where acadamic_id =?";

	// check password

	public static final String CHECK_PRINCIPAL_PASSWORD = "select count(*) from  campus_user where id = ? and password= ?";
	public static final String CHECK_ADMIN_PASSWORD = "select count(*) from  campus_admin where AdminID = ? and password= ?";
	public static final String CHECK_PARENTS_PASSWORD = "select count(*) from  campus_parents where ParentID = ? and password= ?";
	public static final String CHECK_TEACHERS_PASSWORD = "select count(*) from  campus_teachers where TeacherID = ? and password= ?";

	// change password

	public static final String UPDATE_PRINCIPAL_PASSWORD = "update  campus_user set password= ? where id = ?";
	public static final String UPDATE_ADMIN_PASSWORD = "update  campus_admin set password= ? where AdminID= ? ";
	public static final String UPDATE_PERENTS_PASSWORD = "update  campus_parents set password= ? where ParentID= ?";
	public static final String UPDATE_TEACHERS_PASSWORD = "update  campus_teachers set password= ? where TeacherID= ?";

	public static final String USERDETAILS = "select rpm.shortName,rpm.isApplicable from campus_role_permissions_mapping rpm ,campus_permissions cp where cp.PermissionCode=rpm.permissionCode and rpm.roleCode=?";
	public static final String GET_USER_ROLE = "select Role from campus_admin where username=? and password=?";

	
	// Department Master

	public static final String GET_DEPARTMENT_DETAILS = "select DEPT_ID,DEPT_NAME,DESCRIPTION,isActive,CREATE_DATE,UpdatedBy,createdby,UpdatedTime from campus_department where isActive='Y' order by DEPT_NAME asc";

	public static final String INSERT_DEPARTMENT_DETAILS = "insert into campus_department (DEPT_ID,DEPT_NAME,DESCRIPTION,isActive,CREATE_DATE,createdby) values(?,?,?,?,?,?)";

	public static final String EDIT_DEPARTMENT = "select DEPT_ID,DEPT_NAME,DESCRIPTION,CREATE_DATE,createdby from campus_department where DEPT_ID=?";

	public static final String CHECK_DEPARTMENT_MAP = "select count(*) deptname from campus_teachers where department=?";

	public static final String GET_SINGLE_DEPARTMENT = "select DEPT_NAME from campus_department where DEPT_ID=?";

	public static final String DELETE_DEPARTMENT = "update campus_department set isActive=? where DEPT_ID =?";

	public static final String UPDATE_DEPARTMENT = "update campus_department set DEPT_NAME= ?,DESCRIPTION=?,isActive=?,UpdatedBy=?,UpdatedTime=now() where DEPT_ID =?";

	public static final String SEARCH_DEPARTMENT_DETAILS = "select * from campus_department where (DEPT_NAME like ? or DESCRIPTION like ?) AND isActive='Y'";

	public static final String VALIDATE_DEPT_NAME = "select count(*) deptname from campus_department where DEPT_NAME=? and isActive='Y'";

	public static final String VALIDATE_DEPARTMENT_UPDATE = "select count(*) deptname from campus_department where DEPT_NAME=? and DEPT_ID!=? and isActive='Y'";

	// Designation Master
	public static final String GET_DESIGNATION_DETAILS = "select DesignationCode,designationName,description,createdate,CreatedBy from campus_designation where isActive='Y' order by designationName asc";
	public static final String INSERT_DESIGNATION_DETAILS = "insert into campus_designation (DesignationCode,designationName,description,CreatedBy,isActive) values(?,?,?,?,?)";
	public static final String EDIT_DESIGNATION = "select DesignationCode,designationName,description,createdate,CreatedBy from campus_designation where DesignationCode=?";
	public static final String VALIDE_DES_NAME = "select count(*) desname from campus_designation where designationName=? and isActive='Y'";
	public static final String UPDATE_DES_DETAILS = "update campus_designation set designationName= ?,description=?,isActive=? where DesignationCode =?";
	public static final String GET_SINGLE_DESIGNATION = "select designationName from campus_designation where DesignationCode=?";
	public static final String DELETE_DESIGNATION = "update campus_designation set isActive=? where DesignationCode =?";
	public static final String CHECK_DESIGNATION_MAP = "select count(*) desname from campus_teachers where designation=?";
	public static final String GET_SEARCH_DETAILS = "select *from campus_designation where (designationName like ? or description like ?) and isActive='Y' ";
	public static final String ADD_DESG_COUNT = "SELECT distinct(count(*)) FROM campus_designation where designationName=? and isActive='Y'";
	public static final String EDIT_DESG_COUNT = "select count(*) from campus_designation where DesignationCode!=? and designationName=? and isActive='Y'";

	// stage master
	public static final String GET_STAGEMASTER_DETAILS = "select cs.stage_id,cs.stage_name,cs.description from campus_fee_stage cs";
	public static final String INSERT_STAGE_DETAILS = "insert into campus_fee_stage (stage_id,stage_name,description,createdby) values(?,?,?,?)";
	public static final String UPDATE_STAGE_DETAILS = "update campus_fee_stage set stage_name= ?,description=? where stage_id =?";
	public static final String EDIT_STAGE = "select stage_id,stage_name,description,createdtime,createdby from campus_fee_stage where stage_id=?";
	public static final String CHECK_STAGE_MAP = "select count(*) from campus_fee_stage where stage_id =?";
	public static final String DELETE_STAGEMASTER = "delete from campus_fee_stage where stage_id=?";
	public static final String GET_STAGE_DETAILS = "select * from campus_fee_stage where (stage_name like ? or description like ?) ";
	public static final String ADD_STAGE_COUNT = "select distinct(count(*)) from campus_fee_stage where stage_name=?";
	public static final String EDIT_STAGE_COUNT = "select count(*) from campus_fee_stage where stage_id!=? and stage_name=?";

	// Term Master

	public static final String GET_ACC_DETAILS = "select acadamic_id,acadamic_year,startDate,endDate from campus_acadamicyear where acadamic_id=?";
	public static final String TERM_COUNT = "SELECT distinct(count(*)) FROM campus_fee_termdetails where termname=?";
	public static final String ADD_TERM = "insert into campus_fee_termdetails(termid,termname,startdate,enddate,accyear,description,ternOrder,isTransportTerm,createdby,createdtime) values(?,?,?,?,?,?,?,?,?,?)";
	public static final String GET_TERM = "select te.termid,te.termname,te.startdate,te.enddate,ac.acadamic_year,te.accyear from campus_fee_termdetails te join campus_acadamicyear ac on te.accyear=ac.acadamic_id order by te.termname";
	public static final String EDIT_TERM = "select termid,termname,description,startdate,enddate,isTransportTerm from campus_fee_termdetails where termid=?";
	public static final String EDIT_TERM_COUNT = "SELECT distinct(count(*)) FROM campus_fee_termdetails where termid!=? and termname=?";
	public static final String EDIT_TERM_DETAILS = "update campus_fee_termdetails set termname=?,startdate=?,enddate=?,accyear=?,description=?,isTransportTerm=?,updatedby=?,updatedtime=? where termid= ?";
	public static final String CHECK_TERM_MAP = "select count(*) termcode from campus_fee_collection where termcode=?";
	public static final String CHECK_TERM_MAP1 = "select count(*) Termcode from campus_fee_setup where Termcode=?";
	public static final String DELETE_TERM = "delete from campus_fee_termdetails where termid=?";
	public static final String SEARCH_TERM_DETAILS = "select te.termid,te.termname,te.startdate,te.enddate,ac.acadamic_year,te.accyear from campus_fee_termdetails te join campus_acadamicyear ac on te.accyear=ac.acadamic_id where te.termname like ? or te.startdate like ? or te.enddate like ? or ac.acadamic_year like ? or te.accyear like ?  order by te.termname"; 

	// Quota Details
	public static final String GET_QUOTA_DETAILS = "select Quota_Code,Quota_Name,Quota_Description from campus_quota order by Quota_Name";

	public static final String INSERT_QUOTA_DETAILS = "insert into campus_quota(Quota_Code,Quota_Name,Quota_Description,created_date,created_by) values(?,?,?,?,?);";

	public static final String GET_QUOTA_COUNT_BEFOREDELETE = "select count(student_quota) from  campus_student where student_quota=?";

	public static final String DELETE_QUOTA = "Delete from campus_quota where Quota_Code=?";

	public static final String GET_PARTICULAR_QUOTA = "select Quota_Code,Quota_Name,Quota_Description from campus_quota where Quota_Code=?";

	public static final String GET_QUOTA_COUNT_FOR_UPDATE = "select count(*) from campus_quota where Quota_Name=? and Quota_Code!=?;";

	public static final String UPDATE_QUOTA_DETAILS = "update campus_quota set Quota_Name=?,Quota_Description=?,updated_by=?,updated_date=? where Quota_Code=?";

	public static final String SEARCH_QUOTA_DETAILS = "select * from campus_quota where Quota_Name like ? or Quota_Description like ?";

	public static final String VALIDATE_QUOTA_NAME = "select count(*) quotaname from campus_quota where Quota_Name=?";

	public static final String VALIDATE_QUOTA_UPDATE = "select count(*) quotaname from campus_quota where Quota_Name=? and Quota_Code!=?";

	// REMAINDER_DETAILS

	public static final String REMAINDER_COUNT = "SELECT distinct(count(*)) FROM campus_remainder where remainder_title=?";
	public static final String ADD_REMAINDER = "insert into campus_remainder(remainder_id,remainder_title,description,remainder_to,teacher,parents,backoffice,created_by,created_time) values(?,?,?,?,?,?,?,?,?)";
	public static final String GET_REMAINDER = "select remainder_id,remainder_title,description,remainder_to from campus_remainder order by remainder_title";
	public static final String EDIT_REMAINDER = "select remainder_id,remainder_title,description,remainder_to from campus_remainder where remainder_id=?";
	public static final String EDIT_REMAINDER_COUNT = "SELECT distinct(count(*)) FROM campus_remainder where remainder_id!=? and remainder_title=?";
	public static final String UPDATE_REMAINDER_DETAILS = "update campus_remainder set remainder_title=?,description=?,remainder_to=?,teacher=?,parents=?,backoffice=?,updated_by=?,updated_time=? where remainder_id= ?";
	public static final String DELETE_REMAINDER = "delete from campus_remainder where remainder_id=?";
	public static final String SEARCH_REMAINDER_DETAILS = "select remainder_id,remainder_title,description,remainder_to from campus_remainder where remainder_title like ? or remainder_to like ?  order by remainder_title";

	// TEACHER MAPPING

	public static final String GET_CLASS = "select classdetail_id_int,classdetails_name_var from campus_classdetail";
	public static final String GET_SECTION = "select se.classsection_id_int,se.classsection_name_var from campus_classsection se join campus_classdetail cl on cl.classdetail_id_int=se.classdetail_id_int where se.classdetail_id_int=? and se.classsection_id_int not in (select SectionCode from campus_classteacher where ClassCode=?)";
	public static final String GET_TEACHER = "select TeacherID,FirstName from campus_teachers";
	public static final String ADD_CLASS_TEACHER = "insert into campus_classteacher(CTCode,ClassCode,SectionCode,TeacherCode,CreateUser,CreateTime) values(?,?,?,?,?,?)";
	public static final String GET_MAPPING_DETAILS = "select ct.CTCode,ct.ClassCode,ct.SectionCode,ct.TeacherCode,cl.classdetails_name_var,se.classsection_name_var,te.FirstName from campus_classteacher ct join campus_classdetail cl on cl.classdetail_id_int=ct.ClassCode join campus_classsection se on se.classsection_id_int=ct.SectionCode join campus_teachers te on te.TeacherID=ct.TeacherCode";
	public static final String GET_CHECK_SECTION = "select ClassCode,SectionCode from campus_classteacher where ClassCode=?";
	public static final String GET_CLASS_DETAILS = "select ct.CTCode,ct.ClassCode,ct.SectionCode,ct.TeacherCode,cl.classdetails_name_var,se.classsection_name_var,te.FirstName from campus_classteacher ct join campus_classdetail cl on cl.classdetail_id_int=ct.ClassCode join campus_classsection se on se.classsection_id_int=ct.SectionCode join campus_teachers te on te.TeacherID=ct.TeacherCode order by length(ct.ClassCode),ct.ClassCode";
	public static final String GET_CLASS_UPDATE = "select cl.classdetail_id_int,cl.classdetails_name_var from campus_classdetail cl join campus_classteacher te on te.ClassCode=cl.classdetail_id_int where te.CTCode=?";
	public static final String GET_CLASS_UPVALUES = "select classdetail_id_int,classdetails_name_var from campus_classdetail where classdetail_id_int !=?";
	public static final String GET_SECTION_UPDATE = "select se.classsection_id_int,se.classsection_name_var from campus_classsection se where (se.classdetail_id_int=? and se.classsection_id_int not in (select SectionCode from campus_classteacher where ClassCode=?)) or (se.classsection_id_int in (select SectionCode from campus_classteacher where CTCode=?))";
	public static final String GET_CLASS_VALUES = "select ClassCode from campus_classteacher where CTCode=?";
	public static final String GET_CLASS_TEACHER_UPDATE = "select te.TeacherID,te.FirstName from campus_teachers te join campus_classteacher ct on ct.TeacherCode=te.TeacherID where ct.CTCode=?";
	public static final String GET_TEACHER_COUNT = "select TeacherCode from campus_classteacher where CTCode=?";
	public static final String GET_TEACHER_UPDATE = "select TeacherID,FirstName from campus_teachers where TeacherID !=?";
	public static final String UPDATE_MAPPING_DETAILS = "update campus_classteacher set ClassCode=?,SectionCode=?,TeacherCode=? where CTCode= ?";
	public static final String DELETE_TEACHER_MAPPING = "delete from campus_classteacher where CTCode=?";
	public static final String GET_DOWNLOAD_EXCEL = "select ct.CTCode,ct.ClassCode,ct.SectionCode,ct.TeacherCode,cl.classdetails_name_var,se.classsection_name_var,te.FirstName from campus_classteacher ct join campus_classdetail cl on cl.classdetail_id_int=ct.ClassCode join campus_classsection se on se.classsection_id_int=ct.SectionCode join campus_teachers te on te.TeacherID=ct.TeacherCode order by length(ct.ClassCode),ct.ClassCode";

	public static final String CHECK_CONCESSION_NAME = "select count(*) usercount from campus_fee_concessiondetails where concessionname=?";
	public static final String GET_CONCESSION_DETAILS = "select * from campus_fee_concessiondetails order by concessionname";
	/*
	 * public static final String INSERT_CONCESSION_DETAILS =
	 * "INSERT INTO campus_fee_concessiondetails (concessionid,concessionname,percentage, description, createdby,createdtime,updatedby,updatedtime) VALUES (?,?,?,?,?,?,?,?)"
	 * ;
	 */public static final String INSERT_CONCESSION_DETAILS = "INSERT INTO campus_fee_concessiondetails (concessionid,concessionname,percentage, description, createdby) VALUES (?,?,?,?,?)";

	public static final String UPDATE_CONCESSION_DETAILS = "UPDATE campus_fee_concessiondetails SET concessionname=?,description= ? ,percentage=? ,updatedby= ?, updatedtime = ?  WHERE concessionid =?";
	public static final String GET_SEARCH = "select * from campus_fee_concessiondetails where concessionname like ? or description like ? or percentage like ? ";
	public static final String EDIT_CONCESSION = "select concessionid,concessionname,percentage,description,createdtime,CreatedBy from campus_fee_concessiondetails where concessionid=?";
	public static final String CHECK_FEE_CONCESSION_MAP = "select count(*) from campus_student where student_scholorship_var=?";
	public static final String DELETE_FEE_CONCESSION = "delete from campus_fee_concessiondetails where concessionid=?";
	public static final String ADD_FEE_CONCESSION_COUNT = "SELECT distinct(count(*)) FROM campus_fee_concessiondetails where concessionname=?";
	public static final String EDIT_FEE_CONCESSION_COUNT = "select count(*) from campus_fee_concessiondetails where concessionid!=? and concessionname=?";
	public static final String UPDATE_FEE_CONCESSION_DETAILS = "update campus_fee_concessiondetails set concessionname= ?,description=?,percentage=? where concessionid =?";

	public static final String GET_SIBLING_DETAILS = "select sib.student_id_int as siblingId,sib.student_admissionno_var as siblingAdmissionNo,case when sib.student_lname_var is null then sib.student_fname_var else concat(sib.student_fname_var,' ',sib.student_lname_var)  end siblingName,cd.classdetails_name_var from campus_student st   join campus_student sib on sib.student_id_int = st.student_siblingId  join campus_classdetail  cd on cd.classdetail_id_int=st.classdetail_id_int  where st.student_id_int = ?";
	public static final String GET_STUDENT_DETAIL_BY_SEARCH_TERM = "select acc.acadamic_year,st.isRTE,st.isConcession,st.student_fname_var,st.student_lname_var,st.student_id_int,st.student_rollno,st.student_admissionno_var,student_application_no,isTransport,isHostel,st.fms_classstream_id_int,strm.classstream_name_var,st.fms_acadamicyear_id_int,st.classdetail_id_int,cd.classdetails_name_var,st.classsection_id_int,sec.classsection_name_var,st.student_regno_var,st.student_dob_var,st.student_gender_var,st.student_bloodgroup_var,st.student_age_int,st.student_imgurl_var,st.student_doj_var,st.student_religion_var,st.student_nationality_var,st.student_scholorship_var,st.student_promotionstatus,st.student_physicallychallenged,st.student_identificationmarks_var,st.student_grade,par.FatherName,par.student_mothername_var,par.student_gaurdianname_var,par.Qualification,par.mobileno,par.student_mothermobileno_var,par.student_motherqualification_var,st.student_siblingId,st.student_status_var,st.student_prehistory_var,st.student_remarks_var,st.student_quota,par.email,par.student_mother_mailid,par.student_gardian_mailid,par.student_gardian_mobileno,st.student_caste,par.ParentID,cpr.relationship,ttd.type_name,ttd.type_id,cfs.stage_name,cfs.stage_id,ttd.type_collectFee,st.student_tc_path,st.student_birthcert_path,par.student_father_occupation,par.student_mother_occupation,par.address from campus_student st join campus_classstream strm on strm.classstream_id_int=st.fms_classstream_id_int  join campus_classdetail cd on cd.classdetail_id_int=st.classdetail_id_int join campus_classsection sec on sec.classsection_id_int=st.classsection_id_int join campus_acadamicyear acc on acc.acadamic_id=st.fms_acadamicyear_id_int join campus_quota qt on qt.Quota_Code=st.student_quota join campus_parentchildrelation cpr on cpr.stu_addmissionNo=st.student_id_int join campus_parents par on cpr.parentid=par.ParentID left outer  join transport_typedetails ttd on ttd.type_id=st.TransportType left outer join campus_fee_stage cfs on cfs.stage_id=st.StageId left outer join campus_fee_stagesetup fss on fss.stageSettingCode=cfs.stage_id and fss.AccyearCode=st.fms_acadamicyear_id_int where st.student_status_var ='active' and st.student_id_int=?";


	// Fee Master

		public static final String ADD_FEE_COUNT = "SELECT distinct(count(*)) FROM campus_fee_master where FeeName=?";
		public static final String EDIT_FEE_COUNT = "select count(*) from campus_fee_master where FeeCode!=? and FeeName=?";
		public static final String ADD_FEE_DETAILS = "insert into campus_fee_master(FeeCode,FeeName,description,createdby,createtime,IsConcession) values(?,?,?,?,?,?)";
		public static final String GET_FEE_DETAILS = "select FeeCode,FeeName,description,IsConcession from campus_fee_master order by FeeName";
		public static final String GET_EDIT_DETAILS = "select FeeCode,FeeName,description,IsConcession from campus_fee_master where FeeCode=?";
		public static final String EDIT_FEE_DETAILS = "update campus_fee_master set FeeName=?,description=?,createdby=?,createtime=?,IsConcession=? where FeeCode= ?";
		public static final String DELETE_FEE_DETAILS = "delete from campus_fee_master where FeeCode=?";
		public static final String SEARCH_FEE_DETAILS = "select FeeName,FeeCode,description,IsConcession from campus_fee_master where FeeName like ? or description like ? or IsConcession like ?";

		
		
		
		
		
	//Teacher Module	
		
		
		public static final String  SAVE_LEAVE_REQUEST	= "insert into  campus_teachers_leave_request(RequestedTo,StartDate,EndDate,SessionStart,SessionEnd,LeaveType,NoofLeaves,ReasonForLeave,filepaath,LeaveStatus,RequestedBy,RequestedDate) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		public static final String UPDATE_LEAVE_REQUEST = "update campus_teachers_leave_request set RequestedTo=?,NoofLeaves=?,StartDate=?,EndDate=?,SessionStart=?,SessionEnd=?,LeaveType=?,filepaath=?,ReasonForLeave=?,RequestedDate=?,RequestedBy=?,LeaveStatus=? where SNO=?";
		
		
		public static final String GET_LEAVE_REQUEST_DETAILS = "select rq.SNO,rq.NoofLeaves,rq.StartDate,rq.EndDate,rq.SessionStart,rq.SessionEnd,rq.LeaveStatus,rq.LeaveType,concat(tea.FirstName, '' ,LastName) as teachername,usr.type,rq.ReasonForLeave from campus_teachers_leave_request rq,campus_teachers tea ,campus_user usr where rq.RequestedTo=tea.TeacherID and rq.RequestedBy=usr.employeecode";
		
		public static final String  GET_LEAVE_DETAILS = "select concat(tea.FirstName, '' ,LastName) as teachername,req.RequestedTo,req.NoofLeaves,req.StartDate,req.EndDate,req.SessionStart,req.SessionEnd,req.LeaveType,req.filepaath,req.ReasonForLeave from campus_teachers_leave_request req,campus_teachers tea where req.RequestedTo=tea.TeacherID and req.SNO=?";
		
		
		
		public static final String GET_TEACHER_DOJ_YEAR = "select ac.acadamic_id,ac.acadamic_year, month(te.dateofJoining) as month from campus_teachers te,campus_acadamicyear ac where acadamic_year>=YEAR(STR_TO_DATE(te.dateofJoining, '%Y-%m-%d')) and te.TeacherID=?";
		
		
	
		
		
		public static final String GET_TEACHER_DETAILS = "select TeacherID,concat(FirstName,' ',LastName) as teachername from campus_teachers where TeacherID=?";
		
		
		public static final String GET_TEACHER_MEETING_DETAILS = "select me.meetingid,me.meetingdate,me.starttime,me.endtime,me.title,me.venuedetails,concat(te.FirstName, ' ' ,LastName) as teachername, case when me.subjectId='general' then me.subjectId else(select subjectName from campus_subject where subjectID=me.subjectId)end subjectname from campus_meeting me, campus_meeting_details md,campus_teachers te where me.meetingid=md.MeetingCode and md.TeacherId=te.TeacherID and md.TeacherId=? ";
		
		public static final String GET_TEACHER_LEAVE_REQUEST = "select rq.SNO,rq.NoofLeaves,rq.LeaveType,rq.LeaveStatus,rq.ReasonForLeave,rq.StartDate,rq.EndDate,rq.SessionStart,rq.SessionEnd,concat(te.FirstName,' ',LastName) as teachername,usr.type from campus_teachers_leave_request rq,campus_teachers te,campus_user usr where rq.RequestedTo=te.TeacherID and rq.RequestedBy=usr.employeecode ORDER BY rq.StartDate,rq.EndDate DESC";
		
		public static final String GET_PARENT_LEAVE_REQUEST = "select rq.SNO,rq.NoofLeaves,rq.StartDate,rq.EndDate,rq.SessionStart,rq.SessionEnd,rq.LeaveStatus,rq.LeaveType,concat(tea.FirstName, ' ' ,LastName) as teachername,usr.type,concat(stu.student_fname_var,' ',student_lname_var)as studentname,rq.ReasonForLeave from campus_student_leave_request rq,campus_teachers tea ,campus_student stu,campus_user usr where rq.studentId=stu.student_id_int and rq.RequestedTo=tea.TeacherID and rq.RequestedBy=usr.employeecode ORDER BY rq.StartDate,rq.EndDate DESC";
		
		
		public static final String GET_TEACHER_REMAINDER = "select remainder_title,description,remainder_to from campus_remainder where teacher='Y' ORDER BY created_time DESC";
		
		public static final String GET_SL_COUNT = "select sum(le.TotalDaysAproved) as totaldaysaproved from campus_teachers_leave_request le where le.LeaveType='SL' and le.RequestedBy=? and ((substring(ApprovedStartDate,1,4) and substring(ApprovedStartDate,6,2)>06) or(substring(ApprovedStartDate,1,4) and substring(ApprovedStartDate,6,2)<05))";
		
		public static final String GET_CL_COUNT = "select sum(le.TotalDaysAproved) as totaldaysaproved from campus_teachers_leave_request le where le.LeaveType='CL' and le.RequestedBy=? and ((substring(ApprovedStartDate,1,4) and substring(ApprovedStartDate,6,2)>06) or(substring(ApprovedStartDate,1,4) and substring(ApprovedStartDate,6,2)<05))";
		
		public static final String GET_PL_COUNT = "select sum(le.TotalDaysAproved) as totaldaysaproved from campus_teachers_leave_request le where le.LeaveType='PL' and le.RequestedBy=? and ((substring(ApprovedStartDate,1,4) and substring(ApprovedStartDate,6,2)>06) or(substring(ApprovedStartDate,1,4) and substring(ApprovedStartDate,6,2)<05))";
		
		public static final String GET_TOTAL_LEAVES = "select SL,PL,CL from campus_teacher_leave_bank where AccyearCode=?";
		
		
		
		
		
		//Releiving Order
		
		public static final String GET_ALLTEACHERS = "select TeacherID,concat(FirstName,' ',LastName) as teachername from campus_teachers where isActive='Y'";
		
		//student Attedance
		
		public static final String ALLSTUDENTNAME = "select concat(student_fname_var,' ',student_lname_var) as studentname,student_id_int,student_admissionno_var from campus_student where classdetail_id_int=? and classsection_id_int=?";
		
		
		public static final String LEAVEBANK_DETAILS = "select le.sno,yr.acadamic_id,yr.acadamic_year,le.total_leaves,le.allowed_per_month from campus_acadamicyear yr join campus_teacher_leave_bank le on yr.acadamic_id=le.AccyearCode order by yr.acadamic_year asc"; 
		public static final String INSERT_LEAVEBANK_DETAILS = "insert into campus_teacher_leave_bank (AccyearCode,total_leaves,allowed_per_month,CreatedBy,SL,PL,CL) values(?,?,?,?,?,?,?)"; 
		public static final String UPDATE_LEAVEBANK_DETAILS = "update campus_teacher_leave_bank set total_leaves= ?,allowed_per_month=?,SL=?,PL=?,CL=?,AccyearCode =? where sno=? ";
		public static final String EDIT_LEAVEBANK_DETAILS	="select AccyearCode,total_leaves,allowed_per_month,CreatedBy,SL,PL,CL from campus_teacher_leave_bank where sno=?";
		public static final String GET_SEARCH_LEAVEBANKDETAILS = "select le.sno,yr.acadamic_id,yr.acadamic_year,le.total_leaves,le.allowed_per_month from campus_acadamicyear yr join campus_teacher_leave_bank le on yr.acadamic_id=le.AccyearCode where (acadamic_year like ? or total_leaves like ? or allowed_per_month like ?) order by yr.acadamic_year asc";
		public static final String DELETE_LEAVEBANK_DETAILS	="delete from campus_teacher_leave_bank where sno=?";

		public static final String SEARCH_LEAVE_REQUEST_DETAILS = "select rq.SNO,rq.NoofLeaves,rq.StartDate,rq.EndDate,rq.SessionStart,rq.SessionEnd,rq.LeaveStatus,rq.LeaveType,concat(tea.FirstName, '' ,LastName) as teachername,usr.type,rq.ReasonForLeave from campus_teachers_leave_request rq join campus_teachers tea  on rq.RequestedTo=tea.TeacherID join campus_user usr on rq.RequestedBy=usr.employeecode where  rq.NoofLeaves like ? or rq.StartDate like ? or rq.EndDate like ? or rq.SessionStart like ? or rq.SessionEnd like ? or rq.LeaveStatus like ? or rq.LeaveType like ? or tea.FirstName like ? or tea.LastName like ? or usr.type like ? or rq.ReasonForLeave like ? ";

		//salary details
		
		public static final String CALCULATE_LATE_TIME="select  bt.EMP_ID empid, GROUP_CONCAT(bt.TOTAL_HOURS) TotalHours,GROUP_CONCAT(bt.TOTAL_WORKING_HOURS) TotalWorkingHour,GROUP_CONCAT(case when bt.LATE_TIME!='00:00:00' then bt.LATE_TIME end) LateTime,GROUP_CONCAT(case when bt.EARLY_TIME!='00:00:00' then bt.EARLY_TIME end ) EarlyTime,GROUP_CONCAT(bt.ATTENDANCE_DATE) AttendenceDate,bs.AI_SHIFT_LTOC_NO_EXEC lateexex,bs.AI_SHIFT_ETOG_GC earlyexec from ai_bio_timesheet bt,ai_shift_deatails bs,ai_emp_details be where be.EMPID=bt.EMP_ID and be.SHIFT_ID=bs.AI_SHIFT_ID and ATTENDANCE_DATE between ? and ? and bt.EMP_ID=? group by bt.EMP_ID";
		public static final String CALCULATE_OVERTIME="select  bt.EMP_ID empid, GROUP_CONCAT(bt.TOTAL_HOURS) TotalHours,GROUP_CONCAT(bt.TOTAL_WORKING_HOURS) TotalWorkingHour,GROUP_CONCAT(case when bt.OT_BEFORE_SHIFT!='00:00:00' then bt.OT_BEFORE_SHIFT end) otbeforeshift,GROUP_CONCAT(case when bt.OT_AFTER_SHIFT!='00:00:00' then bt.OT_AFTER_SHIFT end ) otaftershift,GROUP_CONCAT(bt.ATTENDANCE_DATE) AttendenceDate from ai_bio_timesheet bt where ATTENDANCE_DATE between ? and ? and bt.EMP_ID=? group by bt.EMP_ID";
		public static final String GET_EMP_SALARYDETAILS_FOR_PAYROLL="select BankAccNumber,Basic,LeaveDeductions,LateDeductions,IsApplicableForOt,StandardSalary,Allowances,TransportAllowances,Ca,IncomeTax,OtherDeductions from ai_EmployeeSalaryDetails where EmployeeId=?";
		public static final String MONTHLY_PAYROLL="insert into monthly_payroll (EmpId,BankAccountNumber,BasicSalary,No_of_Leaves,LeaveDeduction,LateTime,LateDeduction,EarlyTime,EarlyDeduction,OT_Before_shift_time,OT_Before_shift_amount,OT_After_shift_time,OT_After_shift_amount,Payabledays,GrossSalary,EmployeePf,EmployerPf,PT,AdvanceTaken,NetSalary,Month,Year,PaymentType,CreatedBy,CreatedDate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		public static final String DELETE_PAYROLL="delete from monthly_payroll where EmpId=? and Month=? and Year=? and PaymentType=?";
		public static final String GET_EMP_SALARY_DETAILS="select EmployeeId,BankAccNumber,EmployeePfNo,PaymentType,Basic,Hra,Convenience,Allowances,TransportAllowances,Medical,GrossSalary,Ca,Da,EmployerPf,EmployeePf,IncomeTax,Pt,OtherDeductions,LeaveDeductions,LateDeductions,IsApplicableForOt,LTA,MedicalAllowances,CTC from ai_employeesalarydetails where EmployeeId=?";
		public static final String EMP_SAL_DETAILS_FOR_PAYROLL="select es.EmployeeId,e.EMPNAME,des.designationName,d.DEPT_NAME,es.Basic,es.Da,es.Hra,es.Ca,es.LTA,es.MedicalAllowances,es.Others,es.GrossSalary,es.EmployeePf,es.EmployerPf,es.Pt,es.IncomeTax,es.CTC,es.LeaveDeductions,es.LateDeductions,es.IsApplicableForOt,es.EmployeePfNo,es.AdminCharges from ai_EmployeeSalaryDetails es,ai_bio_department d,ai_emp_designation des,ai_emp_details e where e.EMPID=es.EmployeeId and d.DEPT_ID in (select DEPARTMENT from ai_emp_details where EMPID=es.EmployeeId) and  des.designationId in (select EMPDESIGNATION from ai_emp_details where EMPID=es.EmployeeId) and es.EmployeeId=?";
		
		
		
}
