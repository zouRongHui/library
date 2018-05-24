package com.rone.library.signinwindow;

import java.awt.*;

/**
 * 入口类
 * @author zou_rong_hui
 *
 */
public class Start {
	/**
	 * 入口方法
	 * @param args
	 */
	public static void main(String[] args) {
		//创建登陆窗口
		SignInWindow win = new SignInWindow();
		//设置窗体颜色
		Container con = win.getContentPane();
		con.setBackground(Color.pink);
		//设置窗口的大小位置及标题
		win.setBounds(300, 100, 500, 400);
		win.setTitle("欢迎使用图书管理系统");
	}

}
