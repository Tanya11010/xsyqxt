package com.tjl.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tjl.bean.User;
import com.tjl.dao.UserDao_Imp;
import com.tjl.jdbc.JDBCUtils;

public class JDBCUtilsTest {
	
	public void jdbcConnectionTest() throws Exception {
		Connection conn=JDBCUtils.getMysqlConn();
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM info");
		while(result.next()) {
			System.out.println(result.getInt("id"));			
		}				
	} 
	
//	测试登陆
	public void loginTest() throws Exception {
		UserDao_Imp userDao_Imp=new UserDao_Imp();
		User user=new User("admin","damin");
		int type=userDao_Imp.login(user);
	   System.out.println(type);			
			
	} 
//	public void insertTest() throws Exception {
//		UserDao_Imp userDao_Imp=new UserDao_Imp();
//
//		User user=new User("10","张鱼","音乐学院","1班","13369874789","张鱼","13369874780","否","否","否","否","否","否","","258369","北京");
//		boolean flag=userDao_Imp.insert(user);
//	   System.out.println(flag);			-
//			
//	} 
//	
	

}
