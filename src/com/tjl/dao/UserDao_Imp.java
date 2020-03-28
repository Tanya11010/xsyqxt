package com.tjl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;


public  class UserDao_Imp implements UserDao {

	
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
	public User select(String sid) {
		Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String password = null;
        String sname = null;
        String type = null;
        String college= null;
        String sclass= null;//班级
        String telephone= null;//电话
        String headmaster= null;//班主任
        String master_telephone= null;//班主任电话
        String wuhanji= null;//是否武汉人员
        String hubeiji= null;//是否湖北人
        String touch_wuhan= null;//接触过武汉人员？
        String touch_hubei= null;//接触过湖北人员？
        String suspected= null;//疑似症状？
        String comfrimed= null;//确诊？
        String address= null;//地址
        String date= null;//填报日期
        try {
            ps = conn.prepareStatement("select * from info where sid = ? ");
            ps.setString(1,sid);//设置第一个问号的值
            rs = ps.executeQuery();
            while(rs.next()){
                password = rs.getString("password");
                sname = rs.getString("sname");
                type = rs.getString("type");
                college= rs.getString("college");
                sclass = rs.getString("sclass");
                telephone = rs.getString("telephone");
                headmaster = rs.getString("headmaster");
                master_telephone = rs.getString("master_telephone");
                wuhanji = rs.getString("wuhanji");
                hubeiji = rs.getString("hubeiji");
                touch_wuhan = rs.getString("touch_wuhan");
                touch_hubei = rs.getString("touch_hubei");
                suspected = rs.getString("suspected");
                comfrimed = rs.getString("comfrimed");
                address = rs.getString("address");
                date = rs.getString("date");
            }
            return new User(sid,sname,college,sclass,telephone,headmaster,master_telephone,wuhanji,hubeiji,touch_wuhan,touch_hubei,suspected,comfrimed,address,date,type,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return null;//查询失败返回null
	}
	
	public boolean count() {
		Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps4 = null;
        PreparedStatement ps5= null;
        PreparedStatement ps6 = null;
        PreparedStatement ps7 = null;
        PreparedStatement ps8 = null;
        PreparedStatement ps9 = null;
        PreparedStatement ps10 = null;
        PreparedStatement ps11 = null;
        PreparedStatement ps12 = null;

        ResultSet rs1 = null;
        ResultSet rs2= null; 
        ResultSet rs3 = null; 
        ResultSet rs4= null; 
        ResultSet rs5 =null; 
        ResultSet rs6 = null; 
        ResultSet rs7 = null;
        ResultSet rs8 = null; 
        ResultSet rs9 = null; 
        ResultSet rs10 = null; 
        ResultSet rs11= null; 
        ResultSet rs12 = null; 
//        int x[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
//        int i=1;
        try {
            ps1 = conn.prepareStatement("SELECT countNum FROM (SELECT count(sid) countNum,MONTH(date) yuefen FROM `info` where comfrimed='是' GROUP BY MONTH(date)) as tongji where yuefen='1' ");
            rs1 = ps1.executeQuery();
            while(rs1.next()){
                String countNum = rs1.getString("countNum");
                System.out.println("1月份:"+countNum);
           } 
            ps2 = conn.prepareStatement("SELECT countNum FROM (SELECT count(sid) countNum,MONTH(date) yuefen FROM `info` where comfrimed='是' GROUP BY MONTH(date)) as tongji where yuefen='2'");
            rs2 = ps2.executeQuery(); 
            while(rs2.next()){
            	 String countNum = rs2.getString("countNum");
                 System.out.println("2月份:"+countNum);
            }

            ps3 = conn.prepareStatement("SELECT countNum FROM (SELECT count(sid) countNum,MONTH(date) yuefen FROM `info` where comfrimed='是' GROUP BY MONTH(date)) as tongji where yuefen='3'");
            rs3 = ps3.executeQuery();
            while(rs3.next()){
           	 String countNum = rs3.getString("countNum");
                System.out.println("3月份:"+countNum);
           }
            ps4 = conn.prepareStatement("SELECT countNum FROM (SELECT count(sid) countNum,MONTH(date) yuefen FROM `info` where comfrimed='是' GROUP BY MONTH(date)) as tongji where yuefen='4' ");
            rs4 = ps4.executeQuery();
            while(rs4.next()){
           	 String countNum = rs4.getString("countNum");
             System.out.println("4月份:"+countNum);
           }

            ps5 = conn.prepareStatement("SELECT countNum FROM (SELECT count(sid) countNum,MONTH(date) yuefen FROM `info` where comfrimed='是' GROUP BY MONTH(date)) as tongji where yuefen='5'");
            rs5 = ps5.executeQuery(); 

            while(rs5.next()){
              	 String countNum = rs5.getString("countNum");
                System.out.println("5月份:"+countNum);
              }
            ps6 = conn.prepareStatement("SELECT countNum FROM (SELECT count(sid) countNum,MONTH(date) yuefen FROM `info` where comfrimed='是' GROUP BY MONTH(date)) as tongji where yuefen='6' ");
            rs6 = ps6.executeQuery(); 
            while(rs6.next()){
              	 String countNum = rs6.getString("countNum");
                System.out.println("6月份:"+countNum);
              }
            ps7 = conn.prepareStatement("SELECT countNum FROM (SELECT count(sid) countNum,MONTH(date) yuefen FROM `info` where comfrimed='是' GROUP BY MONTH(date)) as tongji where yuefen='7'");
            rs7 = ps7.executeQuery(); 
            while(rs7.next()){
              	 String countNum = rs7.getString("countNum");
                System.out.println("7月份:"+countNum);
              }
            ps8 = conn.prepareStatement("SELECT countNum FROM (SELECT count(sid) countNum,MONTH(date) yuefen FROM `info` where comfrimed='是' GROUP BY MONTH(date)) as tongji where yuefen='8' ");
            rs8 = ps8.executeQuery(); 
            while(rs8.next()){
              	 String countNum = rs8.getString("countNum");
                System.out.println("8月份:"+countNum);
              }
            ps9 = conn.prepareStatement("SELECT countNum FROM (SELECT count(sid) countNum,MONTH(date) yuefen FROM `info` where comfrimed='是' GROUP BY MONTH(date)) as tongji where yuefen='9'");
            rs9 = ps9.executeQuery();
            while(rs9.next()){
              	 String countNum = rs9.getString("countNum");
                System.out.println("9月份:"+countNum);
              }
            ps10 = conn.prepareStatement("SELECT countNum FROM (SELECT count(sid) countNum,MONTH(date) yuefen FROM `info` where comfrimed='是' GROUP BY MONTH(date)) as tongji where yuefen='10'");
            rs10 = ps10.executeQuery(); 
            while(rs10.next()){
              	 String countNum = rs10.getString("countNum");
                System.out.println("10月份:"+countNum);
              }
            ps11 = conn.prepareStatement("SELECT countNum FROM (SELECT count(sid) countNum,MONTH(date) yuefen FROM `info` where comfrimed='是' GROUP BY MONTH(date)) as tongji where yuefen='11' ");
            rs11 = ps11.executeQuery();
            while(rs11.next()){
              	 String countNum = rs11.getString("countNum");
                System.out.println("11月份:"+countNum);
              }
            ps12 = conn.prepareStatement("SELECT countNum FROM (SELECT count(sid) countNum,MONTH(date) yuefen FROM `info` where comfrimed='是' GROUP BY MONTH(date)) as tongji where yuefen='12'");
            rs12 = ps12.executeQuery(); 
            while(rs12.next()){
              	 String countNum = rs12.getString("countNum");
                System.out.println("12月份:"+countNum);
              }
                           

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs1,ps1,conn);
            JDBCUtils.close(rs2,ps2,conn);
            JDBCUtils.close(rs3,ps3,conn);
            JDBCUtils.close(rs4,ps4,conn);
            JDBCUtils.close(rs5,ps5,conn);
            JDBCUtils.close(rs6,ps6,conn);
            JDBCUtils.close(rs7,ps7,conn);
            JDBCUtils.close(rs1,ps1,conn);
            JDBCUtils.close(rs8,ps8,conn);
            JDBCUtils.close(rs9,ps9,conn);
            JDBCUtils.close(rs10,ps10,conn);
            JDBCUtils.close(rs11,ps11,conn);
            JDBCUtils.close(rs12,ps12,conn);
        }
        return  false;
	}

}
