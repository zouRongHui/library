package com.rone.library.user;

import com.rone.library.db.DBOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 删除借阅者
 * @author zou_rong_hui
 * 该类继承JPanel
 */
@SuppressWarnings("serial")
public class DeleteUserPanel extends JPanel {
	private JTextField numbertext;
	private Box basebox;
	private Box box0;
	private Box box1;
	private Box box2;
	private JButton button1;
	private JButton button2;

	/**
	 * 构造函数
	 */
	public DeleteUserPanel() {
		//设置布局及颜色
		this.setLayout(new FlowLayout());
		setBackground(Color.pink);

		//删除借阅者
		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("删除借阅者"));

		//需要删除的编号
		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("需要删除的编号："));
		box1.add(Box.createHorizontalStrut(8));
		numbertext = new JTextField(15);
		box1.add(numbertext);

		//按钮
		button1 = new JButton("确定");
		button2 = new JButton("重置");
		box2 = Box.createHorizontalBox();
		box2.add(Box.createHorizontalStrut(30));
		box2.add(button1);
		box2.add(Box.createHorizontalStrut(45));
		box2.add(button2);

		basebox = Box.createVerticalBox();
		basebox.add(Box.createVerticalStrut(30));
		basebox.add(box0);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box1);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box2);

		add(basebox);

		//为确定按钮绑定监视器
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取删除编号
				String number = numbertext.getText().trim();
				//判断输入编号是否为空
				if (!number.equals("")) {
					int n = JOptionPane.showConfirmDialog(null, "确认删除用户<"+number+">吗？", "确认对话框", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						//自定义数据库操作对象
						DBOperation dbdelete = new DBOperation();
						dbdelete.setDatasourceName("library");
						dbdelete.setSQL("delete from user where number='"+number+"'");
						//判断数据库操作是否操作成功
						if (dbdelete.executeSQL()) {
							JOptionPane.showMessageDialog(null, "删除成功");
						}else{
							JOptionPane.showMessageDialog(null, "删除失败", "警告", JOptionPane.ERROR_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "请输入你需要删除的编号");
				}
			}
		});
		//为重置按钮绑定监视器
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numbertext.setText("");
			}
		});
	}
}
