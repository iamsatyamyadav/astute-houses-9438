package com.AuctionApp.OnlyForTrialUsecases.AdministratorUsecase;

import java.util.List;

import com.AuctionApp.Dao.AdministratorDao;
import com.AuctionApp.Dao.AdministratorDaoImpl;
import com.AuctionApp.Exceptions.SellerException;
import com.AuctionApp.JavaBeanFiles.Seller;

public class ViewRegisteredSeller {

	public static void main(String[] args) {
		 AdministratorDao dao = new AdministratorDaoImpl();
			
			try {
			List<Seller> sellerDetails= dao.ViewRegisteredSellerList();
			
			sellerDetails.forEach(s ->{
				
				System.out.println("Seller id :"+s.getsID());
				System.out.println("Seller Name: "+s.getsName());
				System.out.println("Seller email: "+s.getsEmail());
				
				System.out.println("===================================");
			});
			
			
			}catch(SellerException e) {
				System.out.println(e.getMessage());
			}

	}

}
