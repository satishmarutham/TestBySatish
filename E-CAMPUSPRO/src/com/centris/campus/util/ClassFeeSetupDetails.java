package com.centris.campus.util;

public class ClassFeeSetupDetails {
	
	public static final String GET_CLASS_DETAILS ="select distinct a.acadamic_id,a.acadamic_year,cd.classdetail_id_int,cd.classdetails_name_var,t.termid,t.termname from campus_acadamicyear a,campus_classdetail cd,campus_fee_termdetails t where a.acadamic_id=? group by a.acadamic_id,cd.classdetail_id_int,t.termid order by length(a.acadamic_id),length(cd.classdetail_id_int),length(t.termid),a.acadamic_id,cd.classdetail_id_int,t.termid";
	public static final String GET_FEE_COUNT="select count(fsd.feecode) as feecount from campus_fee_setup fs,campus_fee_setupdetails fsd where fs.feeSettingcode = fsd.feeSettingCode and fs.ClassCode=? and fs.AccyearCode=? and fs.Termcode=?";
	public static final String SERCH_FEE_DETAILS="select distinct a.acadamic_id,a.acadamic_year,cd.classdetail_id_int,cd.classdetails_name_var,t.termid,t.termname from campus_acadamicyear a,campus_classdetail cd,campus_fee_termdetails t where (a.acadamic_year like ? or cd.classdetails_name_var like ? or t.termname like ?) and a.acadamic_id=? group by a.acadamic_id,cd.classdetail_id_int,t.termid order by length(a.acadamic_id),length(cd.classdetail_id_int),length(t.termid),a.acadamic_id,cd.classdetail_id_int,t.termid";
	public static final String GET_APPROVED_FEES = "select distinct fm.FeeCode,fm.FeeName,fsd.feeSettingCode,fsd.feeAmount from campus_fee_setupdetails fsd,campus_fee_setup fs,campus_fee_master fm where fsd.feeSettingCode=fs.feeSettingcode and fsd.feecode=fm.FeeCode and fs.ClassCode=? and fs.AccyearCode=? and fs.Termcode=?";
	public static final String GET_ALL_FEES = "select distinct fm.FeeCode,fm.FeeName from campus_fee_master fm where fm.FeeCode  not in(select fsdd.FeeCode from campus_fee_setupdetails fsdd, campus_fee_setup fss1 where  fss1.feeSettingcode=fsdd.feeSettingCode  and  fss1.ClassCode=? and fss1.AccyearCode=? and fss1.Termcode=?)";
	public static final String INSERT_APPROVED_FEES_IN_FEE_SETUP = "insert into campus_fee_setup(feeSettingcode,ClassCode,AccyearCode,Termcode,createdby,createtime)values(?,?,?,?,?,now())";
	public static final String INSERT_APPROVED_FEES = "insert into  campus_fee_setupdetails(feeSettingCode,feecode,feeAmount)values(?,?,?);";
	public static final String DELETE_FEE_CODE = "delete from campus_fee_setupdetails where feeSettingCode=? and feecode=?";
	public static final String UPDATE_FEE_AMOUNT = "update campus_fee_setupdetails set feeAmount=? where feeSettingCode in (select feeSettingcode from campus_fee_setup where ClassCode=? and AccyearCode=? and Termcode=?) and feecode=?";
	public static final String FEE_SETUP_COUNT ="select count(*) from campus_fee_setup where ClassCode=? and AccyearCode=? and Termcode=?";
	public static final String INSERT_APPROVED_FEES_AMT="insert into  campus_fee_setupdetails(feeSettingCode,feecode,feeAmount)values((select feeSettingcode from campus_fee_setup where ClassCode=? and AccyearCode=? and Termcode=? ),?,?)";


}
