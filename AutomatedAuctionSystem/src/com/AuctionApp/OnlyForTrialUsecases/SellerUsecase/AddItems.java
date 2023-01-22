package com.AuctionApp.OnlyForTrialUsecases.SellerUsecase;

import java.util.Scanner;

import com.AuctionApp.Dao.SellerDao;
import com.AuctionApp.Dao.SellerDaoImpl;
import com.AuctionApp.JavaBeanFiles.Items;

public class AddItems {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
    
    
        System.out.println("Enter Item Name");
        String iName = sc.next();
        
        System.out.println("Enter Item Price");
        int iPrice = sc.nextInt();
        
        System.out.println("Enter Item Quantity");
        int iQuantity = sc.nextInt();
        
        System.out.println("Enter Item Category");
        String iCategory = sc.next();
        
        System.out.println("Enter Seller ID");
        int sID = sc.nextInt();
        
        SellerDao sdao = new SellerDaoImpl();
        Items item = new Items(iName, iCategory, iPrice, iQuantity, sID);
        String message = sdao.AddItemToSell(item);
        System.out.println(message);


	}

}
