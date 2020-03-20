package Main;

import java.awt.GridLayout;
import java.sql.Date;
import java.sql.ResultSet;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;

import com.tjl.bean.User;
import com.tjl.chart.Chart;
import com.tjl.dao.UserDao;
import com.tjl.dao.UserDao_Imp;
import com.tjl.view.View;

/**
 * 程序入口
 */
public class Main {
	
	 static UserDao_Imp UserDao = new UserDao_Imp();
    public static void main(String[] args) {
    	
        User user = null;
        int type = -1;
        boolean flag=true;
        while (flag) {
            user = View.indexView();
            type=UserDao.login(user);
            switch (type) {
                case -1:
                    System.out.println("登录失败，请重新登录！");
                    break;
                case 1:
                    System.out.println("管理员登录成功！");
                    managerServer();
                    break;
                case 2:
                    System.out.println("学生登录成功！");
                    studentServer(user.getSname());
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 管理员控制
     */
    public static void managerServer(){
        boolean flag=true;//循环标志位
        while (flag){
            int choice = View.managerMenuView();//选择操作
            switch (choice){
                case 0:
                    System.out.println("退出系统，再见！");
                    flag=false;
                    break;
                case 1:
                    User newUser = View.addMenuView();
                    if (UserDao.insert(newUser)){
                        System.out.println("添加成功！");
                    }else {
                        System.out.println("插入失败");
                        //
                    }
                    break;
                case 2:
                    String sid = View.deleteMenuView();
                    if (UserDao.delete(sid)){
                        System.out.println("删除成功");
                    }else {
                        System.out.println("删除失败");
                        //
                    }
                    break;
                case 3:
                    User user = View.updateMenuView();
                    if (UserDao.update(user)){
                        System.out.println("修改成功！");
                    }else {
                        System.out.println("修改失败");
                        //
                    }
                    break;
                case 4:
                    String sid1 = View.selectMenuView();
                    User selectUser = UserDao.select(sid1);
                    if (selectUser!=null){
                        System.out.println("您查询的信息如下：");
                        System.out.printf("学号：%s\n 姓名：%s\n  学院：%s\n 班级:%s\n 电话号码：%s\n 班主任：%s\n  班主任电话：%s\n 是否为武汉籍？：%s\n 是否为湖北籍（除武汉外）？：%s\n 是否接触过武汉疫区人员？:%s\n 是否接触过湖北疫区（除武汉）人员：%s\n 是否有疑似病症？：%s\n 是否为确诊患者？：%s\n 地址:%s\n 上报日期:%s\n  " ,
                        		selectUser.getSid(),selectUser.getSname(),selectUser.getCollege(),selectUser.getSclass(),selectUser.getTelephone(),selectUser.getHeadmaster(),selectUser.getMaster_telephone(),selectUser.getWuhanji(),selectUser.getHubeiji(),selectUser.getTouch_wuhan(),selectUser.getTouch_hubei(),selectUser.getSuspected(),selectUser.getComfrimed(),selectUser.getAddress(),selectUser.getDate());
                    }else {
                        System.out.println("查询失败，查无此人");
                    }

                    break;
                case 5:
                	View.countMenuView();

                	 if (UserDao.count()){
                         System.out.println("查询成功！");

                         JFrame frame=new JFrame("数据统计图");
                         frame.setLayout(new GridLayout(2,2,10,10));
                         frame.add(new Chart().getChartPanel());
                         frame.setBounds(50, 50, 800, 600);
                     	frame.setVisible(true);
                     }else {
                         System.out.println("查询失败");

                     }
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * 学生控制
     * @param uname 学生的账户名
     */
    public static void studentServer(String uname){
        boolean flag=true;//循环标志位
        while (flag){
            int choice = View.studentMenuView();//选择操作
            switch (choice){
                case 0:
                    System.out.println("退出系统，再见！");
                    flag=false;
                    break;
                case 1:
                    String psw = View.alterPassView();
                    if (UserDao.update(new User(uname,psw))){
                        System.out.println("恭喜修改密码成功！");
                    }else {
                        System.out.println("修改密码失败！");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}


