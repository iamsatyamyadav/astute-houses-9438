package com.AuctionApp.JavaBeanFiles;

public class Buyer {

	private int bID;
	private String bName;
	private String bEmail;
	private String bPassword;
	
	public Buyer() {
	    super();
	}

	public Buyer(int bID, String bName, String bEmail, String bPassword) {
		super();
		this.bID = bID;
		this.bName = bName;
		this.bEmail = bEmail;
		this.bPassword = bPassword;
	}
	
	// As bID is auto_Incremented in MySQL table...
	
	public Buyer(String bName, String bEmail, String bPassword) {
		super();
		this.bName = bName;
		this.bEmail = bEmail;
		this.bPassword = bPassword;
	}

	public int getbID() {
		return bID;
	}

	public void setbID(int bID) {
		this.bID = bID;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbEmail() {
		return bEmail;
	}

	public void setbEmail(String bEmail) {
		this.bEmail = bEmail;
	}

	public String getbPassword() {
		return bPassword;
	}

	public void setbPassword(String bPassword) {
		this.bPassword = bPassword;
	}

	@Override
	public String toString() {
		return "Buyer [bID=" + bID + ", bName=" + bName + ", bEmail=" + bEmail + ", bPassword=" + bPassword + "]";
	}
	
}
