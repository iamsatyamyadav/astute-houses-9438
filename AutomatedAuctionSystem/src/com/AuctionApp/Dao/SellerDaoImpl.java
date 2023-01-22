package com.AuctionApp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AuctionApp.Exceptions.SellerException;
import com.AuctionApp.Exceptions.SoldItemsDTOException;
import com.AuctionApp.JavaBeanFiles.Items;
import com.AuctionApp.JavaBeanFiles.Seller;
import com.AuctionApp.JavaBeanFiles.SoldItemsDTO;
import com.AuctionApp.Utility.DBUtil;

public class SellerDaoImpl implements SellerDao{

	@Override
	public String registerSeller(Seller seller) {
		    String message = "Seller Not Successfully Inserted";
		    
			try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("Insert into Seller(sName,sEmail,sPassword) values(?,?,?)");
			  
			ps.setString(1, seller.getsName());
			ps.setString(2, seller.getsEmail());
			ps.setString(3, seller.getsPassword());
			
			int x = ps.executeUpdate();
		     if(x>0) {	
		    	 message = "Seller Registered Successfully";
		    	 
		     }	
			 
			} catch (SQLException e) {
				message = e.getMessage();
			}
			      
				return message;
	}

	@Override
	public Seller loginSeller(String username, String password) throws SellerException {
		
		    Seller seller = null;
		    
		    
		    try (Connection conn = DBUtil.provideConnection()){
		    PreparedStatement ps = 
		    conn.prepareStatement("Select * from Seller Where sEmail = ? AND sPassword = ?");
		    
		    ps.setString(1, username);
		    ps.setString(2, password);

		    ResultSet rs = ps.executeQuery();
		    
		    if(rs.next()) {
		    	int id = rs.getInt("sID");
		    	String name = rs.getString("sName");
		    	String email = rs.getString("sEmail");
		    	String pass = rs.getString("sPassword");
		    	seller = new Seller(id, name, email, pass);
		    	
		    }else {
		      throw new SellerException("Invalid Username or Password");
		    }
		    
		    
			} catch (SQLException e) {
			  throw new SellerException(e.getMessage());
			}
		
		    
			return seller;

		
	}

	@Override
	public String AddItemToSell(Items item) {
		
		 String message = "Item not Added";
         try (Connection conn = DBUtil.provideConnection()){
         PreparedStatement ps = 
         conn.prepareStatement("Insert into Items(iName,iCategory,iPrice,iQuantity,sID) values(?,?,?,?,?)");
         ps.setString(1, item.getiName());
     	 ps.setString(2, item.getiCategory());
     	 ps.setInt(3, item.getiPrice());
     	 ps.setInt(4, item.getiQuantity());
    	 ps.setInt(5, item.getsID());
    	 
    	 int x = ps.executeUpdate();
         if(x>0) {	
        	 message = "Item Added Successfully";
         }	
    	} catch (SQLException e) {
    		message = e.getMessage();
    	}
         return message;
		
	}

	@Override
	public List<Items> ViewItemsOfSeller(int sId) {
		
		List<Items> list = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()){
		    PreparedStatement ps = conn.prepareStatement("Select * from items where sID = ?");
	        ps.setInt(1, sId);
		    ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("iId");
			String n = rs.getString("iName");
			int p = rs.getInt("iPrice");
			int q = rs.getInt("iQuantity");
			String c = rs.getString("iCategory");
			int sid = rs.getInt("sID");
			Items item = new Items(id, n, c, p, q, sid);
			list.add(item);
		}
				
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		 return list;
		
	}

	@Override
	public List<SoldItemsDTO> getSoldItemsList() throws SoldItemsDTOException {
		
		List<SoldItemsDTO> list = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()){
		    PreparedStatement ps = conn.prepareStatement("Select * from SoldItems");
		    ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("SolditemId");
			String n = rs.getString("SoldItemName");
			int p = rs.getInt("iPrice");
			int q = rs.getInt("iQuantity");
			String c = rs.getString("iCategory");
			int bid = rs.getInt("bID");
			SoldItemsDTO sold =  new SoldItemsDTO(id, n, p, q, c, bid);
			list.add(sold);
		}
				
		} catch (SQLException e) {
			e.printStackTrace();
		  throw new SoldItemsDTOException(e.getMessage());
		}
		 return list;
		
	}

	@Override
	public String removeItems(int iId) {
		
		String message = "Not Success";
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps =
			conn.prepareStatement("DELETE from Items Where iId = ?");
			ps.setInt(1, iId);
			
			int x = ps.executeUpdate();
			if(x>0) {
				message = "Item Removed Successfully";
			}else {
				message = "Item Does not Exist";
			}
			
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
		
	}

}
