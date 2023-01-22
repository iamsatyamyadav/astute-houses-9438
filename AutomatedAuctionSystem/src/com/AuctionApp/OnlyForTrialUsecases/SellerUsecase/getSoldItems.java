package com.AuctionApp.OnlyForTrialUsecases.SellerUsecase;

import java.util.List;

import com.AuctionApp.Dao.SellerDao;
import com.AuctionApp.Dao.SellerDaoImpl;
import com.AuctionApp.Exceptions.SoldItemsDTOException;
import com.AuctionApp.JavaBeanFiles.SoldItemsDTO;

public class getSoldItems {

	public static void main(String[] args) {
		
		 SellerDao dao = new SellerDaoImpl();
		 List<SoldItemsDTO> itemlist;
		try {
			itemlist = dao.getSoldItemsList();
			
			 itemlist.forEach(s -> {
					System.out.println("Sold-Item id is : "+ s.getSolditemId());
					System.out.println("Sold-Item Name is : "+ s.getSoldItemName());
					System.out.println("Sold-Item Price is : "+ s.getiPrice());
					System.out.println("Sold-Item Quantity is : "+ s.getiQuantity());
					System.out.println("Sold-Item Category is : "+ s.getiCategory());
					System.out.println("Sold-Item Buyer-ID is : "+ s.getbID());
					System.out.println("================================");
				 });
			 
		} catch (SoldItemsDTOException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
