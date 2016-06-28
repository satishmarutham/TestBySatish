package com.centris.campus.delegate;

import java.util.List;

import com.centris.campus.forms.SectionForm;
import com.centris.campus.pojo.ClassPojo;
import com.centris.campus.service.ClassService;
import com.centris.campus.service.SectionService;
import com.centris.campus.serviceImpl.ClassServiceImpl;
import com.centris.campus.serviceImpl.SectionServiceImpl;
import com.centris.campus.vo.SectionVO;

public class SectionBD {
	
	public boolean insertCampusClassSectionBD(
			
			SectionForm campusClassSectionForm) throws Exception {
		SectionService sectionService=new SectionServiceImpl();
		 return sectionService.insertCampusClassSectionService(campusClassSectionForm);
	}
	
	public boolean updateCampusClassSectionBD(
			SectionForm campusClassSectionForm) throws Exception {
		SectionService sectionService=new SectionServiceImpl();
		return sectionService.updateCampusClassSectionService(campusClassSectionForm);
	}
	
	public boolean deleteCampusClassSectionBD(
			SectionForm campusClassSectionForm) throws Exception {
		SectionService sectionService=new SectionServiceImpl();
		
		return sectionService.deleteCampusClassSectionService(campusClassSectionForm);
	}
	
	public List<SectionForm> getCampusClassSectionAndClassDetailsBD() throws Exception {
		SectionService sectionService=new SectionServiceImpl();
		List<SectionForm> sectionList=sectionService.getCampusClassSectionAndClassDetailsService();
		return sectionList;
		
	}
	public List<SectionForm> getCampusClassDetailsIDandClassDetailsNameBD() throws Exception {
		SectionService sectionService=new SectionServiceImpl();
		List<SectionForm> sectionList=sectionService.getCampusClassDetailsIDandClassDetailsNameService();
		return sectionList;
		
	}

	
	public boolean checkSectionNameForUpdate(String sectionId,
			String sectionName, String className) {
	
		return new SectionServiceImpl().checkSectionNameForUpdate(sectionId,sectionName,className);
	}
	
	public List<SectionForm> searchSection(SectionForm searchText) {
		SectionService sectionService=new SectionServiceImpl();
		return sectionService.searchSection(searchText);
	}
	
	public SectionForm editSection(SectionForm secCode) {
		SectionService sectionService=new SectionServiceImpl();
		return sectionService.editSection(secCode);
	}
	
	public List<SectionVO> sectiondetailsdownload() throws Exception  {
		SectionService sectionService=new SectionServiceImpl();
		List<SectionVO> sectionList=sectionService.sectiondetailsdownload();
		return sectionList;
		
	}
	
	

}
