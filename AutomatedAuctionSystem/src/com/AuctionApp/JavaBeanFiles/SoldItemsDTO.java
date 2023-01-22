package com.AuctionApp.JavaBeanFiles;

public class SoldItemsDTO {

	private int SolditemId;  
	private String SoldItemName; 
	private int iPrice; 
	private int iQuantity;  
	private String iCategory;  
	private int bID;
	
	public SoldItemsDTO() {
		super();
	}

	public SoldItemsDTO(int solditemId, String soldItemName, int iPrice, int iQuantity, String iCategory, int bID) {
		super();
		SolditemId = solditemId;
		SoldItemName = soldItemName;
		this.iPrice = iPrice;
		this.iQuantity = iQuantity;
		this.iCategory = iCategory;
		this.bID = bID;
	}

	public int getSolditemId() {
		return SolditemId;
	}

	public void setSolditemId(int solditemId) {
		SolditemId = solditemId;
	}

	public String getSoldItemName() {
		return SoldItemName;
	}

	public void setSoldItemName(String soldItemName) {
		SoldItemName = soldItemName;
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

	public String getiCategory() {
		return iCategory;
	}

	public void setiCategory(String iCategory) {
		this.iCategory = iCategory;
	}

	public int getbID() {
		return bID;
	}

	public void setbID(int bID) {
		this.bID = bID;
	}

	@Override
	public String toString() {
		return "SoldItemsDTO [SolditemId=" + SolditemId + ", SoldItemName=" + SoldItemName + ", iPrice=" + iPrice
				+ ", iQuantity=" + iQuantity + ", iCategory=" + iCategory + ", bID=" + bID + "]";
	}
	
	
	
	
}
