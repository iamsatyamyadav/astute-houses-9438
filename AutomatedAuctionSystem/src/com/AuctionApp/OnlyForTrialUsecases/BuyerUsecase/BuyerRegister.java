package com.AuctionApp.OnlyForTrialUsecases.BuyerUsecase;

import java.util.Scanner;

import com.AuctionApp.Dao.BuyerDao;
import com.AuctionApp.Dao.BuyerDaoImpl;
import com.AuctionApp.JavaBeanFiles.Buyer;

public class BuyerRegister {

	public static void main(String[] args) {
		
       Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name : ");
		String bName = sc.next();
		
		System.out.println("Enter your email : ");
		String bEmail = sc.next();
		
		System.out.println("Enter your password : ");
		String bPassword = sc.next();
		
		sc.close();
		
		BuyerDao buyer = new BuyerDaoImpl();
		
		Buyer buyerDetails =  new Buyer(bName, bEmail, bPassword);
		
		String message = buyer.registerBuyer(buyerDetails);
			
		
			System.out.println(message);
		}
	
	   
		
	}
