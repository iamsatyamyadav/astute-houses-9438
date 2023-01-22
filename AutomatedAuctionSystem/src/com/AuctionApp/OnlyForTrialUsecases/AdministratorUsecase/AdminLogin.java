package com.AuctionApp.OnlyForTrialUsecases.AdministratorUsecase;

import java.util.Scanner;

import com.AuctionApp.Dao.AdministratorDao;
import com.AuctionApp.Dao.AdministratorDaoImpl;
import com.AuctionApp.Exceptions.AdministratorException;
import com.AuctionApp.JavaBeanFiles.Administrator;

public class AdminLogin {

	public static void main(String[] args) {
		 
		   Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter Admin Username:");
			String ausername = sc.next();
			
			System.out.println("Enter Password:");
			String apassword = sc.next();
			
			sc.close();
			
			AdministratorDao dao = new AdministratorDaoImpl();
			
			try {
				
				Administrator admin = dao.loginAdministrator(ausername, apassword);
				
				System.out.println("Heya! Welcome Administrator : "+admin.getaName());
				
			} catch (AdministratorException e) {
				System.out.println(e.getMessage());
			}

	}

}
