package com.AuctionApp.OnlyForTrialUsecases.BuyerUsecase;

import java.util.List;
import java.util.Scanner;

import com.AuctionApp.Dao.BuyerDao;
import com.AuctionApp.Dao.BuyerDaoImpl;
import com.AuctionApp.Exceptions.BuyerException;
import com.AuctionApp.JavaBeanFiles.Items;

public class SelectItemsCategoryWise {

	public static void main(String[] args) throws BuyerException {
		
		Scanner sc = new Scanner(System.in);
		BuyerDao dao = new BuyerDaoImpl();
		System.out.println("Select a Category from following");
		List<String> list = dao.showCategory();
		for(String s:list) {
			System.out.println(s);
		}
		String category = sc.next();
		List<Items> listbyCategory = dao.searchByCategory(category);
		if(listbyCategory.isEmpty()) {
			System.out.println("No Items Available with this Category");
		}else {
			listbyCategory.forEach(s -> {
	 			System.out.println("Item Id is : "+ s.getiId());
	 			System.out.println("Item Name is : "+ s.getiName());
	 			System.out.println("Item Price is : "+ s.getiPrice());
	 			System.out.println("Item Quantity is : "+ s.getiQuantity());
	 			System.out.println("Item Category is : "+ s.getiCategory());
	 			System.out.println("Item SellerID is : "+ s.getsID());
	 			System.out.println("================================");
	 		 });
			
		}

	}

}
