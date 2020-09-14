package com.rsh.bal;

import java.sql.Timestamp;

public class Domain {

	
	private String domainHash;
	private String domainUrl;
	private boolean activated;
	private Timestamp modified;
	private Timestamp created;
	
	
	
	
	public Domain(String domainHash, String domainUrl) {
		super();
		this.domainHash = domainHash;
		this.domainUrl = domainUrl;
	}
	
	
	/*
	 Used when populating from database
	 */
	
	public Domain(String domainHash, String domainUrl, boolean activated, Timestamp modified, Timestamp created) {
		super();
		this.domainHash = domainHash;
		this.domainUrl = domainUrl;
		this.activated = activated;
		this.modified = modified;
		this.created = created;
	}




	public String getDomainHash() {
		return domainHash;
	}
	public void setDomainHash(String domainHash) {
		this.domainHash = domainHash;
	}
	public String getDomainUrl() {
		return domainUrl;
	}
	public void setDomainUrl(String domainUrl) {
		this.domainUrl = domainUrl;
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public Timestamp getModified() {
		return modified;
	}
	public void setModified(Timestamp modified) {
		this.modified = modified;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	
	
}
