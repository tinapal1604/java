package com.jdbc_project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App 
{
    public static void main( String[] args )
    {
        try {
        	//Load driver
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	//Create connection
        	Connection con = DriverManager.getConnection(
        			"jdbc:mysql://127.0.0.1:3306/practice", "root", "root");
        	
        	//create query
        	String q = "Select * from customers limit 5";
        	Statement stmt = con.createStatement();
        	ResultSet set = stmt.executeQuery(q);
        	
        	while(set.next()) {
        		int id = set.getInt("customer_id");
        		String fname = set.getNString("first_name");
        		String lname = set.getNString("last_name");
        		String birth_date = set.getNString("birthdate"); 
        		
        		System.out.println("First name: "+fname+"\nLast name: "+lname+"\nDate of birth: "+birth_date);
        		System.out.println();
        	}
        	
        	//Create table and insert data into table
        	String q2 = "create table if not exist person(id int primary key auto_increment, first_name varchar(50) , last_name varchar(50), dob datetime)";
        	Statement stmt2 = con.createStatement();
        	stmt.executeUpdate(q2);
        	System.out.println("user table created.");
        	
        	String q3 = "insert into person(first_name, last_name, dob) values(?, ?, ?)";
        	PreparedStatement ps = con.prepareStatement(q3); 
        	
        	ps.setInt(1, 1);
        	ps.setString(2, "Tina");
        	ps.setString(3, "Paul");
        	Date date = Date.valueOf("2000-10-28");
        	ps.setDate(4, date);
        	
        	int rows = ps.executeUpdate();
        	System.out.println(rows+" updated.");
        	
        	//adding data from console
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	System.out.println("Enter first name: ");
        	String fname = br.readLine();
        	System.out.println("Enter last name: ");
        	String lname = br.readLine();
        	
        	
        	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        	System.out.println("Enter dob in YYYY-MM-DD format: ");
        	String dob = br.readLine();
        	LocalDate d = LocalDate.parse(dob, dateFormatter);
        	Date date2 = Date.valueOf(d);
        	
        	ps.setString(1, fname);
        	ps.setString(2, lname);
        	ps.setDate(3, date2);
        	ps.executeUpdate();
        	System.out.println("record entered successfully.");
        	
        	br.close();
        	con.close();
        	
        }catch(Exception e) {
        	System.out.println(e);
        }
    }
}
