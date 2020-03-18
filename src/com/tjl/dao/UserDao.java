package com.tjl.dao;

import com.tjl.bean.User;

public interface UserDao {

	/**
	 * 验证登录的方法
	 * @param user
	 * @return int类型 -1 登录失败 ，1  管理员登录 ，2 学生登录
	 */
	int login(User user);
	
	/**
	 * 增加学生信息
	 * @param user要添加的对象，包含账户和密码
	 * @return 添加成功，返回true,添加失败，返回false
	 */
	boolean insert(User user);
	
	
	/**
	 * 删除学生信息
	 * @param user 要添加的对象，包含账户和密码
	 * @return 删除成功，返回true，删除失败，返回false
	 */
	boolean delete(String sname);
	
	/**
	 * 用来修改学生信息的方法
	 * @param user 要修改的对象，包含账户和密码
	 * @return 如果修改成功，返回true，修改失败，返回false
	 */
	boolean update(User user);
	
	
	/**
	 * 用来查询学生信息的方法
	 * @param user 要查询的学生的账号
	 * @return 如果查询成功，返回user，修改失败，返回null
	 */
	User select(String sname);
	
}
