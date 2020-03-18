package tsest;
//
//import static org.junt.Assert*;
//import static org.junt.Test;
import com.tjl.bean.User;
import com.tjl.view.View;

public class ViewTest {
    public static void indexViewTest() throws Exception{
        User user1 = View.indexView();
        System.out.println(user1.toString());
    }

    public static void managerMenuViewTest() throws Exception{
       int num=View.managerMenuView();
        System.out.println(num);
//    	System.out.println(View.managerMenuView());
    }

    public static void main(String[] args) {
        try {
			indexViewTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//首页测试
       try {
		managerMenuViewTest();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//管理界面测试

    }
}
