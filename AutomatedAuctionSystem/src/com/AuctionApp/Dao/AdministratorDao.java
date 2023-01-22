package com.AuctionApp.Dao;

import java.util.List;

import com.AuctionApp.Exceptions.AdministratorException;
import com.AuctionApp.Exceptions.BuyerException;
import com.AuctionApp.Exceptions.SellerException;
import com.AuctionApp.Exceptions.SoldItemsDTOException;
import com.AuctionApp.JavaBeanFiles.Administrator;
import com.AuctionApp.JavaBeanFiles.Buyer;
import com.AuctionApp.JavaBeanFiles.Seller;
import com.AuctionApp.JavaBeanFiles.SoldItemsDTO;

public interface AdministratorDao {
	
	// In this Project Admin can...
	
	public Administrator loginAdministrator(String ausername, String apassword) throws AdministratorException;

	public List<Buyer> viewRegisteredBuyerList()throws BuyerException;
	
	public List<Seller> ViewRegisteredSellerList() throws SellerException;
	
	public List<SoldItemsDTO> ViewSellingReport()throws SoldItemsDTOException;
	
}
