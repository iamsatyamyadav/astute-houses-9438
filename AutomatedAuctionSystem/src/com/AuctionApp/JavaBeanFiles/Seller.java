package com.AuctionApp.JavaBeanFiles;

public class Seller {
	
	private int sID;
	private String sName;
	private String sEmail;
	private String sPassword;
	
	public Seller() {
		super();
	}

	public Seller(int sID, String sName, String sEmail, String sPassword) {
		super();
		this.sID = sID;
		this.sName = sName;
		this.sEmail = sEmail;
		this.sPassword = sPassword;
	}
	
	// As sID is auto_Incremented in MySQL table...
	
	public Seller(String sName, String sEmail, String sPassword) {
		super();
		this.sName = sName;
		this.sEmail = sEmail;
		this.sPassword = sPassword;
	}
	

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	@Override
	public String toString() {
		return "Seller [sID=" + sID + ", sName=" + sName + ", sEmail=" + sEmail + ", sPassword=" + sPassword + "]";
	}
	
	
}
