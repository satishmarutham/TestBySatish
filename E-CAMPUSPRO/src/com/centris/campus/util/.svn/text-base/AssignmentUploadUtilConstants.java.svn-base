package com.centris.campus.util;

public class AssignmentUploadUtilConstants {
	
	public static final String GET_STUDENT_DETAILS = "select student_id_int,student_admissionno_var,concat(student_fname_var,' ',student_lname_var) studentName from campus_student where classsection_id_int=?";
	
	public static final String INSERT_ASSIGNMENT = "insert into campus_assignment(AssignmentCode,StreamID,ClassID,SectionID,AssignmentDate,CompletionDate,AssignmentType,Name,Description,SubjectID,MaxMarks,AcadamicID,CreatedBy,CreatedDate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String GET_ASSIGNMENT = "select a.AssignmentCode,a.Name,a.AssignmentDate,a.CompletionDate,case when a.SubjectID='general' then a.SubjectID else (select subjectName from campus_subject where subjectID = a.SubjectID) end as subjectName,cls.classdetails_name_var,sec.classsection_name_var,a.MaxMarks from campus_assignment a,campus_classsection sec,campus_classdetail cls where a.ClassID=cls.classdetail_id_int and a.SectionID=sec.classsection_id_int and a.AcadamicID=? and CreatedBy=? and Name like ?";

	public static final String GET_ASSIGNMENT_DETAILS = "select s.student_id_int,s.student_admissionno_var,concat(s.student_fname_var,' ',s.student_lname_var) as studentName,ad.ActualCompletionDate,ad.AcquiredMarks,ad.Remarks from campus_assignmentdetails ad,campus_student s where s.student_id_int=ad.AdmissionNo and AssignmentCode=?";

	public static final String GET_SINGLE_ASSIGNMENT = "select a.AssignmentCode,a.Name,a.AssignmentDate,a.CompletionDate,case when a.SubjectID='general' then a.SubjectID else (select subjectName from campus_subject where subjectID = a.SubjectID) end as subjectName,cls.classdetails_name_var,sec.classsection_name_var,a.MaxMarks from campus_assignment a,campus_classsection sec,campus_classdetail cls where a.ClassID=cls.classdetail_id_int and a.SectionID=sec.classsection_id_int and a.AssignmentCode=?";

	public static final String UPDATE_ASSIGNMENT_DETAILS = "update campus_assignmentdetails set ActualCompletionDate=?,AcquiredMarks=?,Remarks=?,UpdatedBy=?,UpdatedTime=? where AssignmentCode=? and AdmissionNo=?";
	
	public static final String INSERT_ASSIGNMENT_DETAILS = "insert into campus_assignmentdetails(AssignmentCode,AdmissionNo,ActualCompletionDate,CreatedBy,CreatedTime) values(?,?,?,?,?)";

	public static final String DELETE_ASSIGNMENT = "delete from campus_assignment where AssignmentCode=?";
	
	public static final String DELETE_ASSIGNMENT_DETAILS = "delete from campus_assignmentdetails where AssignmentCode=?";

}
