package com.centris.campus.dao;

import java.util.List;

import com.centris.campus.forms.SectionForm;
import com.centris.campus.pojo.ClassPojo;
import com.centris.campus.pojo.SectionPojo;

public interface SectionDao {
	
	public boolean insertCampusClassSectionDao(SectionPojo campusClassSectionPojo)throws Exception;
	public boolean updateCampusClassSectionDao(SectionPojo campusClassSectionPojo)throws Exception;
	public boolean deleteCampusClassSectionDao(SectionPojo campusClassSectionPojo)throws Exception;
	
	public List<SectionPojo>  getCampusClassSectionAndClassDetailsDao() throws Exception;
	public List<SectionPojo>  getCampusClassDetailsIDandClassDetailsNameDao() throws Exception;
	public boolean checkSectionName(String sectionName, String secDetailId);
	public List<SectionForm> searchSection(SectionForm  searchText);
	public SectionForm editSection(SectionForm classCode);
	public List<SectionPojo>  sectiondetailsdownload() throws Exception;


}
