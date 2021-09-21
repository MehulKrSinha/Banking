package com.lti;

import javax.persistence.Embeddable;

@Embeddable
public class PanCard {

	private String panNumber;
	private String issuedBy;
	
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}
	
	
	
}
