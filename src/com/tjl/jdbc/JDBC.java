package com.tjl.jdbc;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class JDBC {

	public static void main(String[] args) {
		
		try {
//          加载驱动器
			Class.forName("com.mysql.cj.jdbc.Driver");//里面写的是要加载的驱动的名称
			System.out.println("驱动加载成功");
//          连接数据库,获得连接对象conn;
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useSSL=false&serverTimezone=UTC","root","root");//数据库地址，账号，密码
			System.out.println("数据库连接成功");
//         
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动加载失败");
			System.out.println("数据库连接失败");
			
		}

	}

}
