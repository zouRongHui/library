package com.rone.library.signinwindow;

import com.rone.library.db.DBQuery;
import com.sun.rowset.CachedRowSetImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 登陆界面类
 * @author zou_rong_hui
 *
 */
@SuppressWarnings("serial")
public class SignInWindow extends JFrame {
	private JTextField usertext;
	private JTextField passwordtext;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private Box basebox;
	private Box box1;
	private Box box2;
	private Box box3;

	/**
	 * 构造方法
	 */
	public SignInWindow (){
		//调用封装了该类属性的方法
		this.init();
		//设置可见及关闭选项为关闭该窗体
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 封装了该类属性
	 */
	void init () {
		//设置布局为水平流水布局
		this.setLayout(new FlowLayout());
		//设置盒式为水平
		box1 = Box.createHorizontalBox();
		//添加组件
		//添加标签
		box1.add(new JLabel("账号："));
		//添加水平间距
		box1.add(Box.createHorizontalStrut(8));
		usertext = new JTextField(20);
		//添加文本框
		box1.add(usertext);
		//为box2添加组件
		passwordtext = new JPasswordField(20);
		box2 = Box.createHorizontalBox();
		box2.add(new JLabel("密码："));
		box2.add(Box.createHorizontalStrut(8));
		box2.add(passwordtext);
		//为box3添加组件
		button1 = new JButton("登陆");
		button2 = new JButton("退出");
		button3 =new JButton("重置");
		box3 = Box.createHorizontalBox();
		box3.add(Box.createHorizontalStrut(40));
		box3.add(button1);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(button3);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(button2);
		//创建垂直盒式布局
		basebox = Box.createVerticalBox();
		//合适布局嵌套
		basebox.add(Box.createVerticalStrut(100));
		basebox.add(box1);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box2);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box3);
		//将布局添加到该窗口中
		add(basebox);
		//为button1添加监视器，使用匿名类
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String inuser;
					String inpassword;
					String user = null ;
					String password = null ;
					//该对象用来存储数据库查询操作的ResultSet对象
					CachedRowSetImpl rowset;
					//数据库查询操作
					DBQuery dbquery;
					//获取输入的文本
					inuser = usertext.getText();
					inpassword = passwordtext.getText();
					dbquery = new DBQuery();
					dbquery.setDatasourceName("library");
					dbquery.setTableName("manager");
					dbquery.setSQL("SELECT * FROM manager where user='"+inuser+"'");
					rowset = dbquery.executeSQL();
					//取出查询结果
					while (rowset.next()) {
						user = rowset.getString("com/rone/library/user");
						password = rowset.getString("password");
					}
					//判断用户名，密码是否规范，以及是否正确
					String regex = "[a-zA-Z0-9]+";
					if (inuser.equals(user) && inpassword.equals(password)) {
						//正确就创建新的窗口
						MainWindow win = new MainWindow();
						win.setVisible(true);
						//销毁当前界面
						dispose();
					}else {
						if (inuser.isEmpty() || inpassword.isEmpty()) {
							//消息对话框
							JOptionPane.showMessageDialog(null, "账号或密码不能为空", "警告", JOptionPane.WARNING_MESSAGE);
						}else { if(!(inuser.matches(regex)) || !(inpassword.matches(regex))) {
							JOptionPane.showMessageDialog(null, "账号或密码存在非法字符", "警告", JOptionPane.WARNING_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "账号或密码错误", "警告", JOptionPane.WARNING_MESSAGE);
						}
						}
					}
				} catch (Exception exp) {
					// TODO: handle exception
					System.out.println("error");
					System.out.println(exp);
				}
			}
		});
		//为button2添加监视器，使用匿名类
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n;
				//确认对话框
				n = JOptionPane.showConfirmDialog(null, "确认退出", "确认对话框", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		} );
		//为button3添加监视器，使用匿名类
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				usertext.setText(null);
				passwordtext.setText(null);
			}
		});
	}
}
