package com.centris.campus.util;

public class FeeCollectionSqlUtils {
	
	public static final String GETFEECOLLECTION_LIST = "select distinct s.student_admissionno_var,concat(s.student_fname_var,' ',s.student_lname_var) studentname,t.termname,t.termid,s.classdetail_id_int,s.classsection_id_int from  campus_fee_setup cfs,campus_student s,campus_fee_termdetails t where s.classdetail_id_int=cfs.ClassCode and s.fms_acadamicyear_id_int=cfs.AccyearCode and t.termid =cfs.Termcode and s.fms_acadamicyear_id_int=?";
	public static final String GET_FEECOLLECTION_LIST = "select is_paid,totalamount from campus_fee_collection where admissionNo=? and accYear=? and termcode=?";
	public static final String GET_FEECOLLECTION_DEDDER ="select concat(s.student_fname_var,' ',s.student_lname_var) studentname,s.student_admissionno_var,a.acadamic_year,c.classdetails_name_var,sec.classsection_name_var,t.termname,conc.percentage from campus_acadamicyear a,campus_classdetail c,campus_classsection sec,campus_fee_termdetails t,campus_student s left outer join campus_fee_concessiondetails conc on s.student_scholorship_var=conc.concessionid where  a.acadamic_id=? and c.classdetail_id_int=s.classdetail_id_int and sec.classsection_id_int=s.classsection_id_int and s.student_admissionno_var=? and t.termid=?";
	public static final String GET_FEECOLLECTION_COUNT ="select count(*) from campus_fee_setup where ClassCode=? and AccyearCode=? and Termcode=?";

	public static final String GET_FEECOLLECTION_AMOUNT ="select fm.FeeCode,fm.FeeName,fm.IsConcession,fsd.feeAmount from campus_fee_master fm,campus_fee_setup fs,campus_fee_setupdetails fsd where fs.feeSettingcode=fsd.feeSettingCode and fm.FeeCode=fsd.feecode and fs.ClassCode=? and fs.AccyearCode=? and fs.Termcode=?";
	
	public static final String GET_TRANSPORT_FEE = "SELECT fsd.feeAmount,fsd.stagecode from campus_fee_stagesetupdetails fsd ,campus_fee_stagesetup fs where  fsd.stageSettingCode=fs.stageSettingCode and fs.ClassCode=? and fs.AccyearCode=? and fs.Termcode=? and fsd.stagecode in (select StageId from campus_student where student_admissionno_var=?)";
	
	public static final String INSERT_FEE_COLLECTION = "insert into campus_fee_collection(feeCollectionCode,admissionNo,accYear,termcode,is_paid,totalamount,actualamount,conc_amount,conc_percent,paidDate,createdby,createdtime) values(?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String INSERT_FEE_COLLECTION_DETAILS = "insert into campus_fee_collectiondetails(feeCollectionCode,feeCode,feeAmount,finalFeeAmt) values(?,?,?,?)";

	public static final String FEE_COLLECTION_COUNT ="select count(*) from campus_fee_collection where admissionNo=? and accYear=? and termcode=?";

	public static final String GET_EXIST_FEECOLLECTION_AMOUNT = "select fm.FeeCode,fm.FeeName,fm.IsConcession,fcd.feeAmount,fcd.finalFeeAmt,fc.conc_percent,fc.actualamount,fc.conc_amount,fc.totalamount  from campus_fee_master fm,campus_fee_collection fc,campus_fee_collectiondetails fcd where fc.admissionNo=? and fc.accYear=? and fc.termcode=? and fc.feeCollectionCode=fcd.feeCollectionCode and fcd.feeCode=fm.FeeCode";

	public static final String GET_EXIST_TRANSPORT_AMOUNT = "SELECT fcd.feeAmount,fs.stage_id from campus_fee_stage fs ,campus_fee_collection fc,campus_fee_collectiondetails fcd where fc.admissionNo=? and fc.accYear=? and fc.termcode=? and fc.feeCollectionCode=fcd.feeCollectionCode and fcd.feeCode=fs.stage_id";

	public static final String GET_COLLECTION_UPDATE_CNT = "select feeCollectionCode from campus_fee_collection where admissionNo=? and accYear=? and termcode=?";

	public static final String UPDATE_FEE_COLLECTION = "update campus_fee_collection set totalamount=? , actualamount=? , conc_amount=?, conc_percent=? ,updatedby=? , updatedtime=? where feeCollectionCode=?";

	public static final String UPDATE_FEE_COLLECTION_DETAILS = "update campus_fee_collectiondetails set feeAmount=?,finalFeeAmt=? where feeCollectionCode=? and feeCode=?";

	public static final String GET_SEARCH_FEECOLLECTION_LIST = "select distinct s.student_admissionno_var,concat(s.student_fname_var,' ',s.student_lname_var) studentname,t.termname,t.termid,s.classdetail_id_int,s.classsection_id_int from  campus_fee_setup cfs,campus_student s,campus_fee_termdetails t  where s.classdetail_id_int=cfs.ClassCode and s.fms_acadamicyear_id_int=cfs.AccyearCode and t.termid =cfs.Termcode and s.fms_acadamicyear_id_int=? and s.classdetail_id_int like ? and s.classsection_id_int like ?";
}
