package com.centris.campus.util;

public class ParentModuleUtil {

	
	public static final String GET_STUDENT_PARENT_DETAILS = "select p.parentid,p.stu_addmissionNo,s.student_fname_var from campus_parentchildrelation p join campus_student s on s.student_id_int=p.stu_addmissionNo where p.parentid=?";
	
	public static final String GET_EXAM_STUDENT_DETAILS ="select cl.classdetails_name_var,sub.subjectName,ex.examname,ex.startdate,ex.enddate,ti.examtime,ti.endtime from campus_examination_timetable ti,campus_examination ex,campus_classdetail cl,campus_subject sub where ti.examinationid=ex.examid and ti.classid = cl.classdetail_id_int and ti.subjectid=sub.subjectID and cl.classdetail_id_int in (select classdetail_id_int from campus_student where student_id_int=?)";
	
	public static final String GET_ASSIGNMENT_STUDENT_DETAILS = "select cls.classdetails_name_var,case when ass.SubjectID='general' then ass.SubjectID else (select subjectName from campus_subject where subjectID=ass.SubjectID) end subjectname,ass.AssignmentCode,ass.Name,ac.acadamic_year,ass.AssignmentDate,ass.CompletionDate,ass.MaxMarks,sec.classsection_name_var from campus_assignment ass, campus_classdetail cls, campus_acadamicyear ac,campus_classsection sec where ass.ClassID=cls.classdetail_id_int and ass.AcadamicID=ac.acadamic_id and ass.SectionID=sec.classsection_id_int and cls.classdetail_id_int in (select classdetail_id_int from campus_student where student_id_int=?)";
	
	public static final String GET_VIEW_ASSIGNMENT_DETAILS = "select asd.AdmissionNo,asd.ActualCompletionDate,asd.AcquiredMarks,asd.Remarks,sa.Description from campus_assignmentdetails asd join campus_assignment sa on sa.AssignmentCode=asd.AssignmentCode where asd.AssignmentCode=? and asd.AdmissionNo=?";

	
	public static final String GET_STUDENT_INFO_DETAILS = "select st.student_fname_var,st.student_lname_var,st.student_admissionno_var,st.student_application_no,st.student_doj_var,st.student_grade,str.classstream_name_var,st.isRTE,st.emisNo,st.isHostel,st.isConcession,st.isHostel,st.isTransport,cls.classdetails_name_var,ac.acadamic_year,sec.classsection_name_var,q.Quota_Name,st.student_dob_var,st.student_age_int,st.student_gender_var,st.student_identificationmarks_var,st.student_bloodgroup_var,st.student_religion_var,st.student_caste,st.student_nationality_var,st.student_physicallychallenged,st.physicallychallenged_reason,st.student_remarks_var,st.student_siblingId,pt.FatherName,pt.Qualification,pt.mobileno,pt.email,pt.student_mothername_var,pt.student_motherqualification_var,pt.student_mothermobileno_var,pt.student_mother_mailid,pt.student_gaurdianname_var,pt.student_gardian_mobileno,pt.student_gardian_mailid,pt.student_father_occupation,pt.student_mother_occupation,pt.address,tr.VehicleName,st.student_imgurl_var,stg.stage_name,st.student_tc_path,st.student_birthcert_path  from campus_parents pt,campus_parentchildrelation pc,campus_student st left outer join transport_vehicle tr on st.TransportType=tr.VehicleCode  left outer join campus_fee_stage stg on st.StageId=stg.stage_id,campus_classstream str,campus_classdetail cls,campus_acadamicyear ac,campus_classsection sec,campus_quota q  where pc.stu_addmissionNo=st.student_id_int and pc.parentid=pt.ParentID and st.fms_classstream_id_int=str.classstream_id_int and st.classdetail_id_int=cls.classdetail_id_int and st.fms_acadamicyear_id_int = ac.acadamic_id and st.classsection_id_int = sec.classsection_id_int  and st.student_quota=q.Quota_Code and st.student_id_int=?";

	public static final String SAVE_FEEDBACK = "insert into campus_feedback(FeedBackCode,ToUser,Description,FilePath,createdby,createtime) values(?,?,?,?,?,?)";

	public static final String GET_FEEDBACK_DETAILS = "select FeedBackCode,ToUser,FilePath,Description from campus_feedback order by FeedBackCode";
	
	public static final String GET_MONTH_ATTENDANCE_DETAILS = "select count(*) attendence  from  campus_attendence where  attendencedate like ? and addmissionno=?";
	
	public static final String GET_TOTAL_PRESENT_DETAILS = "select count(*) attendence  from  campus_attendence where  attendencedate like ? and attendence='present' and addmissionno=?";
	
	public static final String GET_TOTAL_ABSENT_DETAILS = "select count(*) attendence  from  campus_attendence where  attendencedate like ? and attendence='absent' and addmissionno=?";
	
	public static final String GET_TOTAL_LEAVE_DETAILS ="select count(*) attendence  from  campus_attendence where  attendencedate like ? and attendence='holiday' and addmissionno=?";
	
	public static final String GET_TOTAL_HOLIDAY_DETAILS ="select count(*) attendence  from  campus_attendence where  attendencedate like ? and attendence='leave' and addmissionno=?";
	
	public static final String GET_DAYS_ATTENDANCE_DETAILS = "select attendencedate,attendence from campus_attendence where addmissionno=? and attendencedate like ? ";
	
	public static final String GET_STREAM_DETAILS = "select classstream_id_int,classstream_name_var from campus_classstream order by classstream_name_var";
	
	public static final String GET_CLASS_DETAILS ="select cl.classdetail_id_int,cl.classdetails_name_var from campus_classdetail cl join campus_classstream st on st.classstream_id_int=cl.classstream_id_int where cl.classstream_id_int=?";
	
	public static final String GET_SUBJECT_DETAILS = "select subjectID,subjectName,syllabous,decription from campus_subject where classid=?";

	public static final String FEEDBACK_PATH = "select FilePath from campus_feedback where FeedBackCode=?";
	
	public static final String SUBJECT_SYLLABUS_PATH = "select syllabous from campus_subject where subjectID=?";
 
	public static final String GET_ALL_MEETING_DETAILS = "select me.meetingid,me.meetingdate,me.starttime,me.endtime,me.title,me.venuedetails,md.StudentId,md.TeacherId,case when me.subjectId='general' then me.subjectId else(select subjectName from campus_subject where subjectID=me.subjectId) end subjectname from campus_meeting me, campus_meeting_details md where meetingid=MeetingCode";

	public static final String GET_TEACHER_MEETING ="select FirstName from campus_teachers where TeacherID=?";
	
	public static final String GET_STUDENT_MEETING = "select stu.student_fname_var,cls.classdetails_name_var, sec.classsection_name_var from campus_student stu, campus_classdetail cls ,campus_classsection sec where stu.classdetail_id_int=cls.classdetail_id_int and stu.classsection_id_int=sec.classsection_id_int and stu.student_id_int=?";

	public static final String GET_STUDENT_MEETING_DETAILS = "select me.meetingid,me.meetingdate,me.starttime,me.endtime,me.title,me.venuedetails,md.StudentId,concat(stu.student_fname_var, '' ,student_lname_var) as studentname,cd.classdetails_name_var,cs.classsection_name_var,case when me.subjectId='general' then me.subjectId else(select subjectName from campus_subject where subjectID=me.subjectId) end subjectname from campus_meeting me, campus_meeting_details md,campus_student stu,campus_classdetail cd,campus_classsection cs where meetingid=MeetingCode and stu.student_id_int=md.StudentId and cd.classdetail_id_int = stu.classdetail_id_int and cs.classsection_id_int=stu.classsection_id_int and md.StudentId=?";


	public static final String GET_PARENT_USER_DETAILS = "select usr.employeecode,concat(tea.FirstName, '' ,LastName) as teachername,cls.classdetails_name_var,ts.teacherID from campus_user usr,campus_teachers tea,campus_classdetail cls,campus_teachersettings ts where ts.classID=cls.classdetail_id_int and usr.employeecode = tea.TeacherID and usr.employeecode=ts.teacherID";

	public static final String GET_TEACHER_USER_DETAILS = "select usr.employeecode,concat(tea.FirstName, '' ,LastName) as teachername from campus_user usr,campus_teachers tea where usr.employeecode=tea.TeacherID and usr.type='admin'";

	public static final String SAVE_LEAVE_REQUEST = "insert into campus_student_leave_request(RequestedTo,studentId,StartDate,EndDate,SessionStart,SessionEnd,LeaveType,NoofLeaves,ReasonForLeave,filepaath,LeaveStatus,RequestedBy,RequestedDate) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String GET_LEAVE_REQUEST_DETAILS = "select rq.SNO,rq.NoofLeaves,rq.StartDate,rq.EndDate,rq.SessionStart,rq.SessionEnd,rq.LeaveStatus,rq.LeaveType,concat(tea.FirstName, '' ,LastName) as teachername,usr.type,concat(stu.student_fname_var,' ',student_lname_var)as studentname,rq.ReasonForLeave from campus_student_leave_request rq,campus_teachers tea ,campus_student stu,campus_user usr where rq.studentId=stu.student_id_int and rq.RequestedTo=tea.TeacherID and rq.RequestedBy=usr.employeecode";

	public static final String GET_LEAVE_DETAILS = " select concat(tea.FirstName, '' ,LastName) as teachername,req.RequestedTo,req.NoofLeaves,req.StartDate,stu.student_fname_var,req.EndDate,req.SessionStart,req.SessionEnd,req.LeaveType,req.filepaath,req.ReasonForLeave from campus_student_leave_request req,campus_teachers tea ,campus_student stu where req.RequestedTo=tea.TeacherID and req.studentId=stu.student_id_int and req.SNO=?";
	
	public static final String DELETE_STUDENT_LEAVE_DETAILS = "delete from campus_student_leave_request where SNO=?";
	
	public static final String UPDATE_LEAVE_REQUEST = "update campus_student_leave_request set RequestedTo=?,studentId=?,NoofLeaves=?,StartDate=?,EndDate=?,SessionStart=?,SessionEnd=?,LeaveType=?,filepaath=?,ReasonForLeave=?,RequestedDate=?,RequestedBy=?,LeaveStatus=? where SNO=?";
	
	public static final String GET_TIMETABLE_ID ="select ti.timetable_id,concat(ti.classid, '-' ,sectionid) as classname from campus_timetable_student ti,campus_student st where ti.classid = st.classdetail_id_int and ti.sectionid = st.classsection_id_int and ti.accyearid = st.fms_acadamicyear_id_int and st.student_id_int = ?";
	
	
	public static final String GET_STUDENT_TIME_TABLE = "select days.dayname,days.daycode, ti.period1, ti.period2, ti.period3, ti.period4, ti.period5, ti.period6, ti.period7, ti.period8 from campus_timetable_studentdetails ti join campus_timetable_day days where ti.daycode = days.daycode and timetableid =?";
	
	public static final String GET_SUBJECT_NAME = "select subjectName from campus_subject where subjectID=?";
	public static final String GET_DAY_NAME ="select dayname from campus_timetable_day where daycode=?";
	
	public static final String GET_TEACHER_TIME_TABLE_ID = "select ti.teachertimetable_id from campus_timetable_teacher ti where teacherid=?";
	

	public static final String GET_TEACHER_TIME_TABLE = "select day.dayname,day.daycode,ti.period1,ti.period2,ti.period3,ti.period4,ti.period5,ti.period6,ti.period7,ti.period8 from campus_timetable_teacherdetails ti join campus_timetable_day day where ti.daycode=day.daycode and teachertimetable_id=?";
	
	public static final String GET_CLASS_NAME = "select cls.classdetails_name_var,sec.classsection_name_var  from campus_classdetail cls,campus_classsection sec where cls.classdetail_id_int=sec.classdetail_id_int and cls.classdetail_id_int=? and sec.classsection_id_int=?";
	

	
	
	
	
	
	
	
	
	

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public static final String GET_LEAVE_APPROVED_BY_ADMIN = "select tea.SNO,tea.RequestedBy,tea.ReasonForLeave,tea.NoofLeaves,tea.StartDate,tea.EndDate,tea.RequestedDate,tea.LeaveStatus,tea.LeaveType,tea.RequestedTo,concat(tr.FirstName, ' ' ,LastName)as name from campus_teachers_leave_request tea join campus_teachers tr on tea.RequestedBy=tr.TeacherID where tea.RequestedTo=?";

    public static final String GET_LEAVE_APPROVED_BY_TEACHER = "select st.SNO,st.RequestedBy,st.ReasonForLeave,st.NoofLeaves,st.StartDate,st.EndDate,st.RequestedDate,st.LeaveStatus,st.LeaveType,st.RequestedTo,concat(par.FirstName, ' ' ,LastName)as name from campus_student_leave_request st join campus_parents par on par.ParentID=st.RequestedBy where st.RequestedTo=?";

    public static final String  GET_LEAVE_FOR_APPROVE_DETAILS_TEACHER = "select le.RequestedBy,usr.type,le.StartDate,le.EndDate,le.LeaveType,le.NoofLeaves,le.ReasonForLeave,le.SessionStart,le.SessionEnd from campus_student_leave_request le , campus_user usr where le.RequestedBy=usr.employeecode and le.SNO=?";

    public static final String  GET_LEAVE_FOR_APPROVE_DETAILS_STUDENT = "select le.RequestedBy,usr.type,le.StartDate,le.EndDate,le.LeaveType,le.NoofLeaves,le.ReasonForLeave,le.SessionStart,le.SessionEnd from campus_teachers_leave_request le , campus_user usr where le.RequestedBy=usr.employeecode and le.SNO=?";

    public static final String LEAVE_APPROVAL_BY_ADMIN = "select tea.SNO,tea.RequestedBy,tea.ReasonForLeave,tea.NoofLeaves,tea.StartDate,tea.EndDate,tea.RequestedDate,tea.LeaveStatus,tea.LeaveType,tea.RequestedTo,concat(tr.FirstName, ' ' ,LastName)as name from campus_teachers_leave_request tea join campus_teachers tr on tea.RequestedBy=tr.TeacherID where tea.RequestedTo=?";

    public static final String GET_LEAVE_APPROVING_BY_ADMIN = "update campus_teachers_leave_request set TotalDaysAproved=?,ApprovedStartDate=?,ApprovedEndDate=?,LeaveStatus=?,commennts=?,ApprovedBy=?,AprovedDate=?,ApproveSessionStart=?,ApproveSessionEnd=? where SNO=?";
    public static final String GET_LEAVE_APPROVING_BY_TEACHER = "update campus_student_leave_request set TotalDaysAproved=?,ApprovedStartDate=?,ApprovedEndDate=?,LeaveStatus=?,commennts=?,ApprovedBy=?,AprovedDate=?,ApproveSessionStart=?,ApproveSessionEnd=? where SNO=?";
    


    public static final String DELETE_TEACHER_LEAVE_DETAILS = "delete from campus_teachers_leave_request where SNO=?";

    public static final String  GET_PARENT_REMAINDER = "select remainder_title,description,remainder_to from campus_remainder where parents='Y' ORDER BY created_time DESC";

    public static final String GET_LEAVE_SEARCH_BY_ADMIN = "select tea.SNO,tea.RequestedBy,tea.ReasonForLeave,tea.NoofLeaves,tea.StartDate,tea.EndDate,tea.RequestedDate,tea.LeaveStatus,tea.LeaveType,tea.RequestedTo,concat(tr.FirstName, ' ' ,LastName)as name from campus_teachers_leave_request tea join campus_teachers tr on tea.RequestedBy=tr.TeacherID where tea.RequestedTo like ? or tea.RequestedBy like ? or tea.ReasonForLeave like ? or tea.NoofLeaves like ? or tea.StartDate like ? or tea.EndDate like ? or tea.RequestedDate like ? or tea.LeaveStatus like ? or tea.LeaveType like ? or tr.FirstName like ? or tr.LastName like?";

    public static final String GET_LEAVE_SEARCH_BY_TEACHER = "select st.SNO,st.RequestedBy,st.ReasonForLeave,st.NoofLeaves,st.StartDate,st.EndDate,st.RequestedDate, st.LeaveStatus,st.LeaveType,st.RequestedTo,concat(par.FirstName, ' ' ,LastName)as name  from campus_student_leave_request st join campus_parents par on par.ParentID=st.RequestedBy where st.RequestedTo like ? or st.RequestedBy like ? or st.ReasonForLeave like ? or st.NoofLeaves like ? or st.StartDate like ? or st.EndDate like ? or st.RequestedDate like ? or st.LeaveStatus like ? or st.LeaveType like ? or par.FirstName like ? or par.LastName like ?";
    
    public static final String SEARCH_LEAVE_REQUEST_DETAILS = "select rq.SNO,rq.NoofLeaves,rq.StartDate,rq.EndDate,rq.SessionStart,rq.SessionEnd,rq.LeaveStatus,rq.LeaveType,concat(tea.FirstName, '' ,LastName) as teachername,usr.type,concat(stu.student_fname_var,' ',student_lname_var)as studentname,rq.ReasonForLeave from campus_student_leave_request rq join campus_teachers tea on rq.RequestedTo=tea.TeacherID join campus_student stu on rq.studentId=stu.student_id_int join campus_user usr on rq.RequestedBy=usr.employeecode where rq.NoofLeaves like ? or rq.StartDate like ? or rq.EndDate like ? or rq.SessionStart like ? or rq.SessionEnd like ? or rq.LeaveStatus like ? or rq.LeaveType like ? or tea.FirstName like ? or tea.LastName like ? or usr.type like ? or stu.student_fname_var like ? or stu.student_lname_var like ? or rq.ReasonForLeave like ? "; 




}















