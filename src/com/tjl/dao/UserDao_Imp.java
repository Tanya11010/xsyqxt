package com.tjl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;

public class UserDao_Imp implements UserDao {

	
    	private static final String SQL_INFO_LOGIN="select type from info where sid=? and password=?";
		private static final String SQL_INFO_INSERT="insert into info(sid,sname,college,sclass,telephone,headmaster,master_telephone,wuhanji,hubeiji,touch_wuhan,touch_hubei,suspected,comfrimed,date,password,type,address) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		private static final String SQL_INFO_DELETE="delete from info where sid = ?";
		private static final String SQL_INFO_UPDATE="update info set password = ? where sid = ?";
//		private static final String SQL_INFO_SELECT="select * from user where sname = ? and date = ?"
				
	    public int login(User user) {
	    

	    	Connection conn = JDBCUtils.getMysqlConn();
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        int type = -1;
	        try {
	            ps = conn.prepareStatement(SQL_INFO_LOGIN);
	            ps.setString(1,user.getSid());//设置第一个问号的值
	            ps.setString(2,user.getPassword());//设置第二个问号的值
	            rs = ps.executeQuery();

	            while(rs.next()){
	                type = rs.getInt("type");
	            }
	            return type;

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            JDBCUtils.close(rs,ps,conn);
	        }
	        return -1;//登录失败

    }

	@Override
	public boolean insert(User user) {
//	    连接数据库，创建链接对象conn
		
		Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
//        int rs = null;
        try {
            //数据库中已经将type的默认值设置为2，所以这里不需要设置type的值
            ps = conn.prepareStatement(SQL_INFO_INSERT);
            ps.setString(1,user.getSid());//设置第一个问号的值
            ps.setString(2,user.getSname());//设置第二个问号的值
            ps.setString(3,user.getCollege());
            ps.setString(4,user.getSclass());
            ps.setString(5,user.getTelephone());
            ps.setString(6,user.getHeadmaster());
            ps.setString(7,user.getMaster_telephone());
            ps.setString(8,user.getWuhanji());
            ps.setString(9,user.getHubeiji());
            ps.setString(10,user.getTouch_wuhan());
            ps.setString(11,user.getTouch_hubei());
            ps.setString(12,user.getSuspected());
            ps.setString(13,user.getComfrimed() );
            ps.setString(14,user.getDate());
            ps.setString(15,user.getPassword());
            ps.setString(16,user.getType());
            ps.setString(17,user.getAddress());
            int rs = ps.executeUpdate();
              return rs>0?true:false;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }
        return false;
	}

	@Override
	public boolean delete(String sid) {
		 Connection conn = JDBCUtils.getMysqlConn();
	        PreparedStatement ps = null;
	        try {
	            ps = conn.prepareStatement(SQL_INFO_DELETE);
	            ps.setString(1,sid);//设置第一个问号的值
	            ps.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            JDBCUtils.close(ps,conn);
	        }
	        return false;
	}

	@Override
	public boolean update(User user) {
		  Connection conn = JDBCUtils.getMysqlConn();
	        PreparedStatement ps = null;
	        try {
	            ps = conn.prepareStatement(SQL_INFO_UPDATE);
	            ps.setString(1,user.getPassword());//设置第一个问号的值
	            ps.setString(2,user.getSid());//设置第二个问号的值
	            ps.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            JDBCUtils.close(ps,conn);
	        }
	        return false;
	}

	@Override
	public User select(String sname) {
		Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String password = null;
        try {
            ps = conn.prepareStatement("select * from user where sname = ? ");
            ps.setString(1,sname);//设置第一个问号的值
//            ps.setString(2,date);
            rs = ps.executeQuery();
            while(rs.next()){
                password = rs.getString("upass");
            }
            return new User(sname,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return null;//查询失败返回null
	}

}
