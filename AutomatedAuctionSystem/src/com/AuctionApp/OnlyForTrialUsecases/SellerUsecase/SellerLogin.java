package com.AuctionApp.OnlyForTrialUsecases.SellerUsecase;

import java.util.Scanner;

import com.AuctionApp.Dao.SellerDao;
import com.AuctionApp.Dao.SellerDaoImpl;
import com.AuctionApp.Exceptions.SellerException;
import com.AuctionApp.JavaBeanFiles.Seller;

public class SellerLogin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Seller Username");
		String username = sc.next();
		
		System.out.println("Enter Seller Password");
		String password = sc.next();
		
		SellerDao Sdao = new SellerDaoImpl();
		try {
			Seller seller = Sdao.loginSeller(username, password);
			System.out.println("Welcome Seller " + seller.getsName());
		} catch (SellerException e) {
			System.out.println(e.getMessage());
		}

	}

}
