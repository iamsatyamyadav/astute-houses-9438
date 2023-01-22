package com.AuctionApp.JavaBeanFiles;

public class Items {
	
	private int iId;
	private String iName;
	private String iCategory;
	private int iPrice;
	private int iQuantity;
	private int sID;
	
	public Items() {
		super();
	}

	public Items(int iId, String iName, String iCategory, int iPrice, int iQuantity, int sID) {
		super();
		this.iId = iId;
		this.iName = iName;
		this.iCategory = iCategory;
		this.iPrice = iPrice;
		this.iQuantity = iQuantity;
		this.sID = sID;
	}
	
	// As iID is auto_Incremented in MySQL table...
	public Items(String iName, String iCategory, int iPrice, int iQuantity, int sID) {
		super();
		this.iName = iName;
		this.iCategory = iCategory;
		this.iPrice = iPrice;
		this.iQuantity = iQuantity;
		this.sID = sID;
	}
	

	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getiCategory() {
		return iCategory;
	}

	public void setiCategory(String iCategory) {
		this.iCategory = iCategory;
	}

	public int getiPrice() {
		return iPrice;
	}

	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}

	public int getiQuantity() {
		return iQuantity;
	}

	public void setiQuantity(int iQuantity) {
		this.iQuantity = iQuantity;
	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}

	@Override
	public String toString() {
		return "Items [iId=" + iId + ", iName=" + iName + ", iCategory=" + iCategory + ", iPrice=" + iPrice
				+ ", iQuantity=" + iQuantity + ", sID=" + sID + "]";
	}
	
}
