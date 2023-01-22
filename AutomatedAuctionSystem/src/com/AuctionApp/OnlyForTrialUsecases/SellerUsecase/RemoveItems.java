package com.AuctionApp.OnlyForTrialUsecases.SellerUsecase;

import java.util.Scanner;

import com.AuctionApp.Dao.SellerDao;
import com.AuctionApp.Dao.SellerDaoImpl;

public class RemoveItems {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
         
         
         System.out.println("Enter Item Id To Remove");
         int ItemId = sc.nextInt();
         sc.close();
         
         
         SellerDao dao = new SellerDaoImpl();
         String message = dao.removeItems(ItemId);
         System.out.println(message);
		
	}

}
