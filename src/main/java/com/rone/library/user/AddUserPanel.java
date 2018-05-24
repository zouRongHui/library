package com.rone.library.user;

import com.rone.library.db.DBOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 添加用户类
 * @author zou_rong_hui
 * 该类继承JPanel
 */
@SuppressWarnings("serial")
public class AddUserPanel extends JPanel {
	private JTextField numbertext;
	private JTextField nametext;
	private JButton button1;
	private JButton button2;
	private Box basebox;
	private Box box1;
	private Box box2;
	private Box box3;
	private Box box0;

	/**
	 * 构造函数
	 */
	public AddUserPanel() {
		//设置布局
		setLayout(new FlowLayout());
		//背景颜色
		setBackground(Color.pink);

		//添加借阅者
		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("添加借阅者"));

		//编号
		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("编号："));
		box1.add(Box.createHorizontalStrut(8));
		numbertext = new JTextField(15);
		box1.add(numbertext);

		//称谓
		nametext = new JTextField(15);
		box2 = Box.createHorizontalBox();
		box2.add(new JLabel("称谓："));
		box2.add(Box.createHorizontalStrut(8));
		box2.add(nametext);

		button1 = new JButton("添加");
		button2 = new JButton("重置");
		//为添加按钮绑定监视器
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//自定义数据库操作对象
				DBOperation dbinsert = new DBOperation();
				dbinsert.setDatasourceName("library");
				//用于接收文本框中的内容
				String number = numbertext.getText();
				String name = nametext.getText().trim();
				//设置SQL语句
				dbinsert.setSQL("insert into user values ('"+number+"','"+name+"')");
				if (!number.equals("")) {
					int n = JOptionPane.showConfirmDialog(null, "确认添加吗？", "确认对话框", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						//判断操作是否执行成功
						if (dbinsert.executeSQL()) {
							JOptionPane.showMessageDialog(null, "添加成功");
						}else {
							JOptionPane.showMessageDialog(null, "添加失败", "警告", JOptionPane.ERROR_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "编号不能为空");
				}
			}
		});
		//为重置按钮绑定监视器
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numbertext.setText("");
				nametext.setText("");
			}
		});

		//按钮
		box3 = Box.createHorizontalBox();
		box3.add(Box.createHorizontalStrut(30));
		box3.add(button1);
		box3.add(Box.createHorizontalStrut(30));
		box3.add(button2);

		basebox = Box.createVerticalBox();
		basebox.add(Box.createVerticalStrut(40));
		basebox.add(box0);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box1);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box2);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box3);

		add(basebox);
	}
}
