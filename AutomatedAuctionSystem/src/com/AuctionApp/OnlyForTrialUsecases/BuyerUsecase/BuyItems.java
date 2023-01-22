package com.AuctionApp.OnlyForTrialUsecases.BuyerUsecase;

import java.util.List;
import java.util.Scanner;

import com.AuctionApp.Dao.BuyerDao;
import com.AuctionApp.Dao.BuyerDaoImpl;
import com.AuctionApp.JavaBeanFiles.Items;

public class BuyItems {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BuyerDao dao = new BuyerDaoImpl();
		List<Items> list = dao.showItem();
		list.forEach(A -> System.out.println(A));
	    System.out.println("Please Select Item-ID to buy the Item");
		int iID = sc.nextInt();
		list.forEach(s -> {
			if(s.getiId()== iID){
			    Items item = dao.buyItemByID(iID);
			    dao.ItemPurchasing(item, iID);
			    System.out.println("Item id is : "+ item.getiId());
	 			System.out.println("Item Name is : "+ item.getiName());
	 			System.out.println("Item Price is : "+ item.getiPrice());
	 			System.out.println("Item Quantity is : "+ item.getiQuantity());
	 			System.out.println("Item Category is : "+ item.getiCategory());
	 			System.out.println("Item SellerID is : "+ item.getsID());
	 			System.out.println("================================");
			}
		});

	}

}
