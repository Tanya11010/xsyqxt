package com.tjl.view;


import java.sql.Date;
import java.util.Scanner;
import com.tjl.bean.User;

public class View {

	private static Scanner input = new Scanner(System.in);//输入键盘扫描器
	
	//系统首页视图
	public static User indexView() {
	
		
		System.out.println("***********************************************************");
		System.out.println("********\t\t新冠肺炎疫情登记\t\t*********");
		System.out.println("********\t\t欢迎来到登录界面！         \t\t*********");
		System.out.println("********\t\t请根据提示操作！\t\t*********");
		System.out.println("********\t\t请输入学号：\t\t*********");
		String sid=input.nextLine();
		System.out.println("***********\t\t请输入密码\t\t*****************");
		String password=input.nextLine();
		
		System.out.println("***********************************************************");
		System.out.println("***********************************************************");
		return new User(sid,password);
	}
	

	/**
     * 管理者菜单界面
     * @return 返回操作选项
     */
    public static int managerMenuView(){
        System.out.println("***********************************************************");
        System.out.println("********\t管理员界面：\t*******");
        System.out.println("*********\t请选择操作！\t*******");
        System.out.println("*********\t0.退出\t\t*********");
        System.out.println("*********\t1.添加学生信息\t***********");
        System.out.println("*********\t2.删除学生信息\t**********");
        System.out.println("*********\t3.修改账户密码 \t**********");
        System.out.println("*********\t4查询学生疫情情况\t**********");

      boolean flag = true;
      int num = -1;
//        获取用户输入信息,，这里只能使用nextLine，不能使用nextInt，否则会直接跳转到下一个输入      
//        String type=input.nextLine();
//        将获得的数据转为int类型parseInt
//        int num = Integer.parseInt(type);


        while(flag)
        {
        	num = Integer.parseInt(input.nextLine());
//      判断用户输入在0-4之间，超出范围提示重新输入
            if (num >=0 && num <=4) 
            {
                flag = false;//退出循环
                break;
              }
            System.out.println("输入错误，请重新输入：");
//            return  managerMenuView();
         }
//  输入正确，返回用户输入选项
        System.out.println("***********************************************************");
        
        return num;
    }
    

    /**
     * 增加用户界面
     * @return 返回增加的用户信息
     */
    public static User addMenuView(){
        System.out.println("***********************************************************");
        System.out.println("********\t添加用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入学号：\t***********");
        String sid = input.nextLine();
        System.out.println("**********\t请输入密码：\t***********");
        String password = input.nextLine();
        System.out.println("**********\t请输入姓名：\t***********");
        String sname = input.nextLine();
        System.out.println("**********\t请输入学院：\t***********");
        String college = input.nextLine();
        System.out.println("**********\t请输入班级：\t***********");
        String sclass = input.nextLine();
        System.out.println("**********\t请输入电话：\t***********");
        String telephone = input.nextLine();
        System.out.println("**********\t请输入班主任姓名：\t***********");
        String headmaster = input.nextLine();
        System.out.println("**********\t请输入班主任电话：\t***********");
        String master_telephone = input.nextLine();
        System.out.println("**********\t是否为武汉籍人员？（是/否）\t***********");
        String wuhanji = input.nextLine();
        System.out.println("**********\t是否为湖北籍（除武汉外）人员？（是/否）：\t***********");
        String hubeiji = input.nextLine();
        System.out.println("**********\t是否接触过武汉疫区人员？（是/否）\t***********");
        String touch_wuhan = input.nextLine();
        System.out.println("**********\t是否接触过湖北（除武汉外）疫区人员？（是/否）：\t***********");
        String touch_hubei= input.nextLine();
        System.out.println("**********\t是否有疑似病症？（是/否）\t***********");
        String suspected = input.nextLine();
        System.out.println("**********\t是否为确诊人员？（是/否）：\t***********");
        String comfirmed= input.nextLine();
        System.out.println("**********\t请输入住址\t***********");
        String address = input.nextLine();
        System.out.println("**********\t请输入填报日期：\t***********");
        String date = input.nextLine();
        System.out.println("**********\t请输入用户类型：（1/2）\t***********");
       String type = input.nextLine();
       
        System.out.println("********************************************************");
        return new User(sid,sname,password,type,college,sclass,telephone,headmaster,master_telephone,wuhanji,hubeiji,touch_wuhan,touch_hubei,suspected,comfirmed,address,date);
    }
   

//  删除学生信息视图

	public static String deleteMenuView() {
		System.out.println("********************************************************");
		System.out.println("********\t请根据提示进行操作\t\t\t********");
		System.out.println("********\t请输入要删除学生的学号:\t\t\t********");
		String sid = input.nextLine();
		System.out.println("********************************************************");
		return sid;
	}


	 /**
     * 修改学生信息菜单视图
     * @return 返回修改的用户类，旧帐户sname对应的新密码password
     */
    public static User updateMenuView(){
        System.out.println("***********************************************************");
        System.out.println("********\t修改用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入账号：\t***********");
        String sname = input.nextLine();
        System.out.println("**********\t请输入新密码：\t***********");
        String password = input.nextLine();
        System.out.println("***********************************************************");
        return new User(sname,password);
    }
	

    
    /**
     * 学生菜单界面
     * @return 返回操作选项
     */
    public static int studentMenuView(){
        System.out.println("***********************************************************");
        System.out.println("********\t\t 学生菜单界面\t\t********");
        System.out.println("********\t\t 请根据提示操作\t\t********");
        System.out.println("********\t\t 0.退出 \t\t*********");
        System.out.println("********\t\t 1.修改密码 \t\t*********");
        boolean flag = true;
        int num = -1;
        while(flag){
            num = Integer.parseInt(input.nextLine());
            if (num >= 0 && num <= 1) {
                flag = false;//退出循环
                break;
            }
            System.out.println("输入错误，请重新输入：");
        }
        System.out.println("***********************************************************");
        return num;
    }
    
    /**
     * 修改密码界面
     * @return 返回修改的用户类
     */
    public static String alterPassView(){
        System.out.println("***********************************************************");
        System.out.println("********\t\t 修改密码界面  \t\t*******");
        System.out.println("********\t\t 请根据提示操作 \t\t*******");
        System.out.println("********\t\t 请输入新密码：\t\t********");
        String password = input.nextLine();
        System.out.println("***********************************************************");
        return password;
    }
    
    /**
     * 查询用户界面
     * @return 返回查询的用户信息
     */
    public static String selectMenuView(){
        System.out.println("***********************************************************");
        System.out.println("********\t查询用户界面\t*********");
        System.out.println("********\t请根据提示操作\t*********");
        System.out.println("********\t请输入查询学号：\t*********");
        String sid = input.nextLine();
        System.out.println("***********************************************************");
        return sid;
    }

	
	
}
