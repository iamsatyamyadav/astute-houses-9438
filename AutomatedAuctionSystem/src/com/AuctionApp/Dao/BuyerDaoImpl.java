package com.AuctionApp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AuctionApp.Exceptions.BuyerException;
import com.AuctionApp.JavaBeanFiles.Buyer;
import com.AuctionApp.JavaBeanFiles.Items;
import com.AuctionApp.Utility.DBUtil;

public class BuyerDaoImpl implements BuyerDao {

	@Override
	public String registerBuyer(Buyer buyer) {
		
       String message = "Buyer Not Successfully Inserted";
		 
		 try(Connection conn = DBUtil.provideConnection()) {
				PreparedStatement ps = conn.prepareStatement("Insert into Buyer(bName,bEmail,bPassword) values(?,?,?)");
				
				ps.setString(1, buyer.getbName());
				ps.setString(2, buyer.getbEmail());
				ps.setString(3, buyer.getbPassword());
				
				int x = ps.executeUpdate();
			     if(x>0) {	
			    	 message = "Buyer Registered Successfully!";
			    	 
			     }	
				 
				} catch (SQLException e) {
					message = e.getMessage();
				}
		   return message;
		
	}

	@Override
	public Buyer loginBuyer(String username, String password) throws BuyerException {
		
           Buyer buyer = null;
	    
	    
	    try (Connection conn = DBUtil.provideConnection()){
	    PreparedStatement ps = 
	    conn.prepareStatement("Select * from Buyer Where bEmail = ? AND bPassword = ?");
	    
	    ps.setString(1, username);
	    ps.setString(2, password);

	    ResultSet rs = ps.executeQuery();
	    
	    if(rs.next()) {
	    	int id = rs.getInt("bID");
	    	String name = rs.getString("bName");
	    	String email = rs.getString("bEmail");
	    	String passw = rs.getString("bPassword");
	    	buyer = new Buyer(id, name, email, passw);
	    	
	    }else {
	      throw new BuyerException("Invalid Username or Password");
	    }
	    
	    
		} catch (SQLException e) {
		  throw new BuyerException(e.getMessage());
		}
	
		return buyer;
		
	}

	@Override
	public List<String> showCategory() throws BuyerException {
		
		List<String> showcat = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()){
		    PreparedStatement ps = conn.prepareStatement("select iCategory from Items group by icategory");
		    ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String c = rs.getString("iCategory");
			showcat.add(c);
		}	
		} catch (SQLException e) {
		   e.printStackTrace();
		  throw new BuyerException(e.getMessage());
		}
		return showcat;
		
	}

	@Override
	public List<Items> showItem() {
		
		List<Items> items = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()){
		    PreparedStatement ps = conn.prepareStatement("Select * from Items");
		    ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("iId");
			String n = rs.getString("iName");
			int p = rs.getInt("iPrice");
			int q = rs.getInt("iQuantity");
			String c = rs.getString("iCategory");
			int sid = rs.getInt("sID");
			Items item = new Items(id, n, c, p, q, sid);
			items.add(item);
		}
				
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		 return items;
		
	}

	@Override
	public List<Items> searchByCategory(String iCategory) throws BuyerException {
		
		List<Items> list = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()){
		    PreparedStatement ps = 
		    conn.prepareStatement("select * from items Where iCategory = ?");
	        ps.setString(1, iCategory);
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
		  throw new BuyerException("Please choose the correct Category");
		}
		 return list;
		
	}

	@Override
	public Items buyItemByID(int iId) {
		
		Items item = new Items();
		try (Connection conn = DBUtil.provideConnection()){
		    PreparedStatement ps = conn.prepareStatement("Select * from items where iId = ?");
	        ps.setInt(1, iId);
		    ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int id = rs.getInt("iId");
			String n = rs.getString("iName");
			int p = rs.getInt("iPrice");
			int q = rs.getInt("iQuantity");
			String c = rs.getString("iCategory");
			int sid = rs.getInt("sID");
			item = new Items(id, n, c, p, q, sid);
		}else {
			System.out.println("Please Enter correct Item Id");
		}
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		 return item;
		
	}

	@Override
	public void ItemPurchasing(Items item, int bID) {
		
		 try(Connection conn = DBUtil.provideConnection()) {
				PreparedStatement ps = conn.prepareStatement("Insert into SoldItems values(?,?,?,?,?,?)");
				
				ps.setInt(1, item.getiId());
				ps.setString(2, item.getiName());
				ps.setInt(3, item.getiPrice());
				ps.setInt(4,item.getiQuantity());
				ps.setString(5, item.getiCategory());
				ps.setInt(6,bID);
				int x = ps.executeUpdate();
			     if(x>0) {	
			    	 System.out.println("Item Purchased Successfully");
			     }else {
			    	 System.out.println("Item Not Purchased");
			     }
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		
	}

}
