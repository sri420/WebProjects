package com.sri.webproject.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	
	
	
	

	public static Connection getConnection() {
		Connection conn=null;
		try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/testDB");
             conn = ds.getConnection();
        } catch (NamingException ex) {
            System.err.println(ex);
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}


