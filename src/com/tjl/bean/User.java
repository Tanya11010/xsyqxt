package com.tjl.bean;

import java.sql.Date;


@SuppressWarnings("all")
public class User {
    private String sid;//用户id
    private String sname;//用户名
    private String password;//用户密码
    private String type;//用户类型 1：管理员 2：学生
    private String college;//学院
    private String sclass;//班级
    private String telephone ;//电话
    private String headmaster;//班主任
    private String master_telephone;//班主任电话
    private String wuhanji;//是否武汉人员
    private String hubeiji;//是否湖北人
    private String touch_wuhan;//接触过武汉人员？
    private String touch_hubei;//接触过湖北人员？
    private String suspected;//疑似症状？
    private String comfirmed;//确诊？
    private String address;//地址
    private String date;//填报日期
    
    
  
    public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getHeadmaster() {
		return headmaster;
	}

	public void setHeadmaster(String headmaster) {
		this.headmaster = headmaster;
	}

	public String getMaster_telephone() {
		return master_telephone;
	}

	public void setMaster_telephone(String master_telephone) {
		this.master_telephone = master_telephone;
	}

	public String getWuhanji() {
		return wuhanji;
	}

	public void setWuhanji(String wuhanji) {
		this.wuhanji = wuhanji;
	}

	public String getHubeiji() {
		return hubeiji;
	}

	public void setHubeiji(String hubeiji) {
		this.hubeiji = hubeiji;
	}

	public String getTouch_wuhan() {
		return touch_wuhan;
	}

	public void setTouch_wuhan(String touch_wuhan) {
		this.touch_wuhan = touch_wuhan;
	}

	public String getTouch_hubei() {
		return touch_hubei;
	}

	public void setTouch_hubei(String touch_hubei) {
		this.touch_hubei = touch_hubei;
	}

	public String getSuspected() {
		return suspected;
	}

	public void setSuspected(String suspected) {
		this.suspected = suspected;
	}

	public String getComfrimed() {
		return comfirmed;
	}

	public void setComfirmed(String comfirmed) {
		this.comfirmed = comfirmed;
	}

	public String getDate() {
		return date;
	}

	public String setDate(String date) {
		return date = date;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}

	public void setAddress(String type) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public User() {
    }

	public User(String sid, String sname, String password, String type) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.password = password;
		this.type = type;
	}

	public User(String sid, String password) {
		super();
		this.sid = sid;
		this.password = password;
	}




	public User(String sid, String sname, String password, String type, String college, String sclass, String telephone,
			String headmaster, String master_telephone, String wuhanji, String hubeiji, String touch_wuhan,
			String touch_hubei, String suspected, String comfirmed, String address, String date) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.password = password;
		this.type = type;
		this.college = college;
		this.sclass = sclass;
		this.telephone = telephone;
		this.headmaster = headmaster;
		this.master_telephone = master_telephone;
		this.wuhanji = wuhanji;
		this.hubeiji = hubeiji;
		this.touch_wuhan = touch_wuhan;
		this.touch_hubei = touch_hubei;
		this.suspected = suspected;
		this.comfirmed = comfirmed;
		this.address = address;
		this.date = date;
	}


	public String toString() {
		return "User [sid=" + sid + ", sname=" + sname + ", password=" + password + ", type=" + type + ", college="
				+ college + ", sclass=" + sclass + ", telephone=" + telephone + ", headmaster=" + headmaster
				+ ", master_telephone=" + master_telephone + ", wuhanji=" + wuhanji + ", hubeiji=" + hubeiji
				+ ", touch_wuhan=" + touch_wuhan + ", touch_hubei=" + touch_hubei + ", suspected=" + suspected
				+ ", comfirmed=" + comfirmed + ", date=" + date + "]";
	}



}

    