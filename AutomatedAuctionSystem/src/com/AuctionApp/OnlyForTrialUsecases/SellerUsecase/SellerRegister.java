package com.AuctionApp.OnlyForTrialUsecases.SellerUsecase;

import java.util.Scanner;

import com.AuctionApp.Dao.SellerDao;
import com.AuctionApp.Dao.SellerDaoImpl;
import com.AuctionApp.JavaBeanFiles.Seller;

public class SellerRegister {

	
	public static void main(String[] args) {
          
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Seller Name");
		String sName = sc.next();
		
		System.out.println("Enter Seller Email");
		String sEmail = sc.next();
		
		System.out.println("Enter Seller Password");
		String sPassword = sc.next();
		
		sc.close();
		
		SellerDao dao = new SellerDaoImpl();
		
        Seller seller = new Seller(sName, sEmail, sPassword);

        String message =  dao.registerSeller(seller);
        
        System.out.println(message);
		
    }
}
