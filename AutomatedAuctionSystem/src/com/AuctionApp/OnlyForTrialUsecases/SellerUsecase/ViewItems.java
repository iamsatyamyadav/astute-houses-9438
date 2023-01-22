package com.AuctionApp.OnlyForTrialUsecases.SellerUsecase;

import java.util.List;
import java.util.Scanner;

import com.AuctionApp.Dao.SellerDao;
import com.AuctionApp.Dao.SellerDaoImpl;
import com.AuctionApp.JavaBeanFiles.Items;

public class ViewItems {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Seller ID to view Items");
		int sID = sc.nextInt();
		sc.close();
		
		 SellerDao dao = new SellerDaoImpl();
		 List<Items> itemlist = dao.ViewItemsOfSeller(sID);
 		 itemlist.forEach(s -> {
 			System.out.println("Item id is : "+ s.getiId());
 			System.out.println("Item Name is : "+ s.getiName());
 			System.out.println("Item Price is : "+ s.getiPrice());
 			System.out.println("Item Quantity is : "+ s.getiQuantity());
 			System.out.println("Item Category is : "+ s.getiCategory());
 			System.out.println("Item SellerID is : "+ s.getsID());
 			System.out.println("================================");
 		 });

 		 
	}

}
