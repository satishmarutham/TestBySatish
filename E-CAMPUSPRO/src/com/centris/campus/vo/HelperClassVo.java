package com.centris.campus.vo;

import java.io.Serializable;

public class HelperClassVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String accId;
	private String accName;

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}
}
