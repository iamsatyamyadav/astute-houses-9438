package com.AuctionApp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AuctionApp.Exceptions.AdministratorException;
import com.AuctionApp.Exceptions.BuyerException;
import com.AuctionApp.Exceptions.SellerException;
import com.AuctionApp.Exceptions.SoldItemsDTOException;
import com.AuctionApp.JavaBeanFiles.Administrator;
import com.AuctionApp.JavaBeanFiles.Buyer;
import com.AuctionApp.JavaBeanFiles.Seller;
import com.AuctionApp.JavaBeanFiles.SoldItemsDTO;
import com.AuctionApp.Utility.DBUtil;

public class AdministratorDaoImpl implements AdministratorDao {

	@Override
	public Administrator loginAdministrator(String ausername, String apassword) throws AdministratorException {
		Administrator admin = null;
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("Select * from Administrator Where aEmail = ? AND aPassword = ?");
			
			ps.setString(1, ausername);
			ps.setString(2, apassword);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
		    	int id = rs.getInt("aID");
		    	String name = rs.getString("aName");
		    	String email = rs.getString("aEmail");
		    	String password = rs.getString("apassword");
		    	admin = new Administrator(id, name, email, password);
		    	
		    }else {
		      throw new AdministratorException("Invalid Username or Password");
		    }
			
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		
		
		return admin;
	}

	@Override
	public List<Buyer> viewRegisteredBuyerList() throws BuyerException {
		List<Buyer> buyers = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()){
		    PreparedStatement ps = conn.prepareStatement("Select * from Buyer");
		    ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("bID");
			String n = rs.getString("bName");
			String e = rs.getString("bEmail");
			String p = rs.getString("bPassword");
			Buyer buyer = new Buyer(id, n, e, p);
			buyers.add(buyer);
		}
				
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		 return buyers;
	}

	@Override
	public List<Seller> ViewRegisteredSellerList() throws SellerException {
		List<Seller> sellers = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()){
		    PreparedStatement ps = conn.prepareStatement("Select * from Seller");
		    ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("sID");
			String n = rs.getString("sName");
			String e = rs.getString("sEmail");
			String p = rs.getString("sPassword");
			Seller seller = new Seller(id, n, e, p);
			sellers.add(seller);
		}
				
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		 return sellers;
	}

	@Override
	public List<SoldItemsDTO> ViewSellingReport() throws SoldItemsDTOException {
		
		List<SoldItemsDTO> solditems = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()){
		    PreparedStatement ps = conn.prepareStatement("Select * from SoldItems");
		    ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("solditemId");
			String n = rs.getString("soldItemName");
			int p = rs.getInt("iPrice");
			int q = rs.getInt("iQuantity");
			String c = rs.getString("iCategory");
			int bid = rs.getInt("bID");
			SoldItemsDTO sold =  new SoldItemsDTO(id, n, p, q, c, bid);
			solditems.add(sold);
		}
				
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		 return solditems;
		
	}


}
