package com.jdbc_project;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class StoreImage {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/practice", "root", "root");
			
			String q = "insert into images(img) values(?)";
			PreparedStatement pst = con.prepareStatement(q);
			
			FileInputStream fis = new FileInputStream("my-picture.png");
			pst.setBinaryStream(1, fis, fis.available());
			
			pst.executeUpdate();
			System.out.println("image saved successfully.");
			
			//Store encrypted password to data base
			String s = "insert into user(user_name, user_password) values(?,?)";
			String pass = "tina123";
			String password = BCrypt.withDefaults().hashToString(12, pass.toCharArray());
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(1, "@tina05");
			ps.setString(2, password);
			ps.executeUpdate();
			System.out.println("user saved successfully...");
			
			
		} catch (Exception e) {
			
			System.out.println(e);
		}

	}

}
