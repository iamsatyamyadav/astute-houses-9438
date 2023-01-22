package com.AuctionApp.OnlyForTrialUsecases.AdministratorUsecase;

import java.util.List;

import com.AuctionApp.Dao.AdministratorDao;
import com.AuctionApp.Dao.AdministratorDaoImpl;
import com.AuctionApp.Exceptions.BuyerException;
import com.AuctionApp.JavaBeanFiles.Buyer;

public class ViewRegisteredBuyer {

	public static void main(String[] args) {
		
      AdministratorDao dao = new AdministratorDaoImpl();
		
		try {
		List<Buyer> buyerDetails= dao.viewRegisteredBuyerList();
		
		buyerDetails.forEach(s ->{
			
			System.out.println("Buyer id :"+s.getbID());
			System.out.println("Buyer Name: "+s.getbName());
			System.out.println("Buyer email: "+s.getbEmail());
			
			System.out.println("=======================");
		});
		
		
		
		
		}catch(BuyerException e) {
			System.out.println(e.getMessage());
		}

	}

}
