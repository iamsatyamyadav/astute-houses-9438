package com.AuctionApp.OnlyForTrialUsecases.BuyerUsecase;


import java.util.Scanner;

import com.AuctionApp.Dao.BuyerDao;
import com.AuctionApp.Dao.BuyerDaoImpl;
import com.AuctionApp.Exceptions.BuyerException;
import com.AuctionApp.JavaBeanFiles.Buyer;

public class BuyerLogin {

	public static void main(String[] args) {
		
           Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter your username...");
			String username = sc.next();
			
			System.out.println("Enter your password...");
			String password = sc.next();
			
			sc.close();
			
			BuyerDao buyer = new BuyerDaoImpl();
		
			
			Buyer b = buyer.loginBuyer(username, password);
			
			System.out.println("Welcome to the System " + b.getbName());
				
			} catch (BuyerException e) {
				System.out.println(e.getMessage());
			}

	}

}
