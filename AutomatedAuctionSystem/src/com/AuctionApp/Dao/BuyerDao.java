package com.AuctionApp.Dao;

import java.util.List;

import com.AuctionApp.Exceptions.BuyerException;
import com.AuctionApp.JavaBeanFiles.Buyer;
import com.AuctionApp.JavaBeanFiles.Items;

public interface BuyerDao {

	
	public String registerBuyer(Buyer buyer);
	
	public Buyer loginBuyer(String username, String password) throws BuyerException;
	
	public List<String> showCategory() throws BuyerException;
	
	public List<Items> showItem();
	
	public List<Items> searchByCategory(String iCategory) throws BuyerException;
	
	public Items buyItemByID(int iId); 
	
	public void ItemPurchasing(Items item, int bID);
	
}
