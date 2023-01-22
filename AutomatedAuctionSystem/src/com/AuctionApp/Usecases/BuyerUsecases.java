package com.AuctionApp.Usecases;

import java.util.List;
import java.util.Scanner;

import com.AuctionApp.Dao.BuyerDao;
import com.AuctionApp.Dao.BuyerDaoImpl;
import com.AuctionApp.Exceptions.BuyerException;
import com.AuctionApp.JavaBeanFiles.Buyer;
import com.AuctionApp.JavaBeanFiles.Items;

public class BuyerUsecases {

	public static Buyer BuyerLogin() {
		  Buyer buyer = null;
		 Scanner sc = new Scanner(System.in);
			
			try {
				System.out.println("Enter your username...");
				String username = sc.next();
				
				System.out.println("Enter your password...");
				String password = sc.next();
				
//				sc.close();
				
				BuyerDao dao = new BuyerDaoImpl();
			
				
				 buyer = dao.loginBuyer(username, password);
				
				System.out.println("Welcome to the System " + buyer.getbName());
					
				} catch (BuyerException e) {
					System.out.println(e.getMessage());
				}
			return buyer;
	}
	
	public static String BuyerRegister() {
		String register = null;
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name : ");
		String bName = sc.next();
		
		System.out.println("Enter your email : ");
		String bEmail = sc.next();
		
		System.out.println("Enter your password : ");
		String bPassword = sc.next();
		
//		sc.close();
		
		BuyerDao buyer = new BuyerDaoImpl();
		
		Buyer buyerDetails =  new Buyer(bName, bEmail, bPassword);
		
		register = buyer.registerBuyer(buyerDetails);
			
		
		return register;
	}
	
	public static void searchItemsCategoryWise() throws BuyerException{
		
		Scanner sc = new Scanner(System.in);
		BuyerDao dao = new BuyerDaoImpl();
		System.out.println("Select a Category from following");
		List<String> list = dao.showCategory();
		for(String s:list) {
			System.out.println(s);
		}
		String category = sc.next();
//		sc.close();
		List<Items> listbyCategory = dao.searchByCategory(category);
		if(listbyCategory.isEmpty()) {
			System.out.println("No Items Available with this Category");
		}else {
			listbyCategory.forEach(s -> {
	 			System.out.println("Item Id is : "+ s.getiId());
	 			System.out.println("Item Name is : "+ s.getiName());
	 			System.out.println("Item Price is : "+ s.getiPrice());
	 			System.out.println("Item Quantity is : "+ s.getiQuantity());
	 			System.out.println("Item Category is : "+ s.getiCategory());
	 			System.out.println("Item SellerID is : "+ s.getsID());
	 			System.out.println("================================");
	 		 });	
		}
	}
	
	public static void buyItem(int BuyerID) {
		Scanner sc = new Scanner(System.in);
		BuyerDao dao = new BuyerDaoImpl();
		List<Items> list = dao.showItem();
		list.forEach(A -> System.out.println(A));
	    System.out.println("Please Select Item-ID to buy the Item");
		int iID = sc.nextInt();
		list.forEach(s -> {
			if(s.getiId()== iID){
			    Items item = dao.buyItemByID(iID);
			    dao.ItemPurchasing(item, iID);
			    System.out.println("Item id is : "+ item.getiId());
	 			System.out.println("Item Name is : "+ item.getiName());
	 			System.out.println("Item Price is : "+ item.getiPrice());
	 			System.out.println("Item Quantity is : "+ item.getiQuantity());
	 			System.out.println("Item Category is : "+ item.getiCategory());
	 			System.out.println("Item SellerID is : "+ item.getsID());
	 			System.out.println("================================");
			}
		});
	}
	
	
}
