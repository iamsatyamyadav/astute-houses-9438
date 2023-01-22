package com.AuctionApp.Usecases;

import java.util.List;
import java.util.Scanner;

import com.AuctionApp.Dao.SellerDao;
import com.AuctionApp.Dao.SellerDaoImpl;
import com.AuctionApp.Exceptions.SellerException;
import com.AuctionApp.JavaBeanFiles.Items;
import com.AuctionApp.JavaBeanFiles.Seller;

public class SellerUsecases {

	public static Seller SellerLogin() {
		
		Seller seller = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Seller Username");
		String username = sc.next();
		
		System.out.println("Enter Seller Password");
		String password = sc.next();
//		sc.close();
		SellerDao Sdao = new SellerDaoImpl();
		try {
			seller = Sdao.loginSeller(username, password);
			System.out.println("Welcome Seller " + seller.getsName());
		} catch (SellerException e) {
			System.out.println(e.getMessage());
		}
		return seller;
	}
	
	public static String SellerRegister() {
		String message = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Seller Name");
		String sName = sc.next();
		
		System.out.println("Enter Seller Email");
		String sEmail = sc.next();
		
		System.out.println("Enter Seller Password");
		String sPassword = sc.next();
		
//		sc.close();
		
		SellerDao dao = new SellerDaoImpl();
		
        Seller seller = new Seller(sName, sEmail, sPassword);

        message =  dao.registerSeller(seller);
        
         return message;
	}
	
	public static String addItems(int sID) {
		
        String message = null; 	
		Scanner sc = new Scanner(System.in);
	    
	    
        System.out.println("Enter Item Name");
        String iName = sc.next();
        
        System.out.println("Enter Item Price");
        int iPrice = sc.nextInt();
        
        System.out.println("Enter Item Quantity");
        int iQuantity = sc.nextInt();
        
        System.out.println("Enter Item Category");
        String iCategory = sc.next();
        
        
        SellerDao sdao = new SellerDaoImpl();
        Items item = new Items(iName, iCategory, iPrice, iQuantity, sID);
        message = sdao.AddItemToSell(item);
        return message;
	}
	
	public static String removeItems() {
        Scanner sc = new Scanner(System.in);
        String message = null; 	
         
         System.out.println("Enter Item Id To Remove");
         int ItemId = sc.nextInt();
//         sc.close();
         
         
         SellerDao dao = new SellerDaoImpl();
         message = dao.removeItems(ItemId);
         return message;
	}
	
	public static void ViewItemBySeller(int sID) {
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

