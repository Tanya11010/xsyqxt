package com.tjl.test;

import com.tjl.bean.User;
import com.tjl.view.View;

public class ViewTest {

public void indeView() throws Exception {
	User user1 = View.indexView();
	System.out.println(user1);
}
}
