package com.AuctionApp.Utility;

import java.sql.Connection;
import java.sql.SQLException;

public class TestingConnection {

	public static void main(String[] args) throws SQLException{
		
		Connection test = DBUtil.provideConnection();
		System.out.println("Connection Estabilished..! "+test);
		
	}
}
