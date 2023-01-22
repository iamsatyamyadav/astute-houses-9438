package com.AuctionApp.Usecases;

import java.util.List;
import java.util.Scanner;

import com.AuctionApp.Dao.AdministratorDao;
import com.AuctionApp.Dao.AdministratorDaoImpl;
import com.AuctionApp.Dao.SellerDao;
import com.AuctionApp.Dao.SellerDaoImpl;
import com.AuctionApp.Exceptions.BuyerException;
import com.AuctionApp.JavaBeanFiles.Buyer;
import com.AuctionApp.JavaBeanFiles.Seller;
import com.AuctionApp.JavaBeanFiles.SoldItemsDTO;

// It is an Application Software that is used for the buying and selling of products.

public class MainFlow {

	public static void start() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("To Continue as Administrator, Press 1 \r\n" 
				+ "To Continue as Seller, Press 2 \r\n" 
				+ "To Continue as Buyer, Press 3 \r\n"
				+ "To Exit, Press 4");
		System.out.println();		
		System.out.print("--------->>>>>>  ");
		
		int num = sc.nextInt();
		
		if(num == 1)
		{
			boolean login = AdministratorUsecases.adminLogin();
			if(login)
			{
				while(true)
				{
					 System.out.println("***************************************");
					 System.out.println("*       Please Enter Your Choice      *");
	              	 System.out.println("*  1. View the registered buyer list. *");
	              	 System.out.println("*  2. View the registered Seller list.*");
	              	 System.out.println("*  3. View the selling report.        *");
	              	 System.out.println("*  4. Exit                            *");
	               	 System.out.println("***************************************");
	              	 int numA = sc.nextInt();
	              	 AdministratorDao admin = new AdministratorDaoImpl();
	              	 
	              	 if(numA == 1)
	              	 {
	              		 List<Buyer> buyerlist = admin.viewRegisteredBuyerList();
	              		 
	              		buyerlist.forEach(b ->{
	              			System.out.println("=================================");
	              			System.out.println("Buyer Id is : "+ b.getbID());
	              			System.out.println("Buyer Name is : "+ b.getbName());
	              			System.out.println("Buyer Email is : "+ b.getbEmail());
	              			System.out.println("Buyer Password is : "+ b.getbPassword());
	              			System.out.println("=================================");
	              		});
	              	 }
	              	 else if(numA == 2)
	              	 {
	              		 List<Seller> sellerlist = admin.ViewRegisteredSellerList();
	              		 
	              		 sellerlist.forEach(s -> {
	              			System.out.println("================================");
	              			System.out.println("Seller id is : "+ s.getsID());
	              			System.out.println("Seller Name is : "+ s.getsName());
	              			System.out.println("Seller Email is : "+ s.getsEmail());
	              			System.out.println("Seller Password is : "+ s.getsPassword());
	              			System.out.println("================================");
	              		 });
	              	 }
	              	else if(numA == 3 ) {
	              		 List<SoldItemsDTO> soldList = admin.ViewSellingReport();
	              		 soldList.forEach(s ->{
	              			System.out.println("================================");
	              			System.out.println("Sold Item Id is : "+ s.getSolditemId());
	              			System.out.println("Sold Item Name is : "+ s.getSoldItemName());
	              			System.out.println("Sold Item Price is : "+ s.getiPrice());
	              			System.out.println("Sold Item Quantity is : "+ s.getiQuantity());
	              			System.out.println("Sold Item Category is : "+ s.getiCategory());
	              			System.out.println("Sold Item BuyerID is : "+ s.getbID());
	              			System.out.println("================================");
	              		 });
	              	}
	              	else if(numA == 4) {
	                    System.out.println("Thank you for your valuable visit..!");  
	              		break;
	              	 }
	              	else
	    			{
	    				System.out.println("Please try again by choosing the correct options..!");
	    			}
				}
			}
			
		}
		else if(num == 2)
		{
			  System.out.println("========================");
			     System.out.println("Choose A Option :");
	      	   System.out.println("1. Login as a Seller");
	      	   System.out.println("2. Register as a Seller");
	      	   int numS = sc.nextInt();
	      	   if(numS == 1)
	      	   {
	      		   Seller seller = SellerUsecases.SellerLogin();
	      		   int sellerKey = seller.getsID();
	      		   
	      		   if(seller != null)
	      		   {
	      			   while(true)
	      			   {
	      				 System.out.println("========================");
	      				 System.out.println("Please Enter Your Choice");
	                     System.out.println("1. Add new Items to sell.");
	                     System.out.println("2. View All the Items of the seller");
	                     System.out.println("3. Remove items from the list.");
	                     System.out.println("4. View the sold Item history.");	
	                     System.out.println("5. Exit");
	                     System.out.println("========================");
	                     
	                     int choice = sc.nextInt();
	                     if(choice == 1)
	                     {
	                    	 System.out.println("How Many Items You Want To Add..? ");
	                    	 System.out.println();
	           		         int itemNum = sc.nextInt();
	           		         for(int i=0;i<itemNum;i++) {
	           		             String addedItems = SellerUsecases.addItems(sellerKey);
	           		             System.out.println(addedItems);
	           		           }
	           		         }
	                     else if(choice == 2)
	                     {
	                    	 SellerUsecases.ViewItemBySeller(sellerKey);
	                     }
	                     else if(choice == 3)
	                     {
	                    	 String removeItem = SellerUsecases.removeItems();
	                    	 System.out.println(removeItem);
	                     }
	                     else if(choice == 4)
	                     {
	                         SellerDao dao = new SellerDaoImpl();
	                         List<SoldItemsDTO> soldList = dao.getSoldItemsList();
	                         soldList.forEach(s -> {
	                        	System.out.println("================================");
	         					System.out.println("Sold-Item id is : "+ s.getSolditemId());
	         					System.out.println("Sold-Item Name is : "+ s.getSoldItemName());
	         					System.out.println("Sold-Item Price is : "+ s.getiPrice());
	         					System.out.println("Sold-Item Quantity is : "+ s.getiQuantity());
	         					System.out.println("Sold-Item Category is : "+ s.getiCategory());
	         					System.out.println("Sold-Item Buyer-ID is : "+ s.getbID());
	         					System.out.println("================================");
	         				 });
	                     }
	                     else if(choice == 5)
	                     {
	                    	 System.out.println("Thank you for your valuable visit..!");  
	 	              	    	break;
	                     }
	                     else
	                     {
	                    	 System.out.println("Please try again by choosing the correct options..!");
	                     } 
	                  }
	      		    }
	         	 }
	      	   else if(numS == 2)
	      	   {
	      		 String register = SellerUsecases.SellerRegister();
	          	   System.out.println(register);  
	      	   }
	      	   else
	      	   {
	      		 System.out.println("Please select a correct option"); 
	      	   }
		}
		else if(num ==3)
		{
			   System.out.println("=================");
			 System.out.println("Choose A Option :");
	           System.out.println("1. Login as a Buyer");
	           System.out.println("2. Register as a Buyer");
	           System.out.println("=================");
	           int numB = sc.nextInt();
	           if(numB == 1)
	           {
	        	   Buyer buyer = BuyerUsecases.BuyerLogin();
	           	   int BuyerId = buyer.getbID();
	             	if(buyer != null) 
	             	{
	             	   while(true) 
	             	   {
	             		    System.out.println("====================================");
	             		   	System.out.println("Please Enter Your Choice");
		                    System.out.println("1. Search and view Items by category");
		                    System.out.println("2. Select Items to buy.");	
		                    System.out.println("3. Exit");
		                    System.out.println("=====================================");
		                    int Bchoice = sc.nextInt();
		                 	System.out.println(Bchoice);
		                 	 if(Bchoice == 1) 
		                 	 {
	                 		 try {
	   					    	BuyerUsecases.searchItemsCategoryWise();
	   					     } catch (BuyerException e) {
	   					    	System.out.println(e.getMessage());
	   					     }
	                 	     }
		                 	 else if (Bchoice == 2) 
	                 	     {
	                 	       BuyerUsecases.buyItem(BuyerId);
	                 	  
	                 	     }
		                 	 else if (Bchoice == 3) 
		                 	 {
		                 		 System.out.println("Thank you for your valuable visit..!");  
	                 		     break;
	                 	     }
		                 	 else 
		                 	 {
		                 		System.out.println("Please try again by choosing the correct options..!");
	                 	     }
	             	     }
	             	}
	           }
	           else if(numB == 2)
	           {
	        	   String register = BuyerUsecases.BuyerRegister();
	          	   System.out.println(register);
	           }
	           else
	           {
	        	   System.out.println("Please try again by choosing the correct options..!"); 
	           }
		}
		else if(num == 4)
		{
			System.out.println("*******************************************************************");
			System.out.println(" Thank you So Much For Investing your valuable time in AuctVerse :)");
			System.out.println("*******************************************************************");
		}
		else
		{
			System.out.println("Please try again by choosing the correct options..!"); 
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		  System.out.println("*************************************************");
		  System.out.println("------------------💻AuctVerse💻-------------------");
	      System.out.println("👋 Hey! Welcome to the Automated Auction System..!");
	      System.out.println("*************************************************");
	     
	      start();
		  
	}
}
