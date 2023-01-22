package com.AuctionApp.Dao;

import java.util.List;

import com.AuctionApp.Exceptions.SellerException;
import com.AuctionApp.Exceptions.SoldItemsDTOException;
import com.AuctionApp.JavaBeanFiles.Items;
import com.AuctionApp.JavaBeanFiles.Seller;
import com.AuctionApp.JavaBeanFiles.SoldItemsDTO;

public interface SellerDao {

	
	public String registerSeller(Seller seller);
	
	public Seller loginSeller(String username, String password) throws SellerException;
	
	public String AddItemToSell(Items item);
	
	public List<Items> ViewItemsOfSeller(int sId);
	
	public List<SoldItemsDTO> getSoldItemsList() throws SoldItemsDTOException;
	
	public String removeItems(int iId);
	
}
