package com.rone.library.user;

import com.rone.library.db.DBOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 修改借阅者
 * @author zou_rong_hui
 * 该类继承JPanel
 */
@SuppressWarnings("serial")
public class UpdateUserPanel extends JPanel {
	private Box box0;
	private Box box1;
	private Box box2;
	private Box box3;
	private Box basebox;
	private JTextField numbertext;
	private JTextField nametext;

	public UpdateUserPanel() {
		setLayout(new FlowLayout());
		setBackground(Color.pink);

		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("修改借阅者"));

		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("需要修改的编号："));
		box1.add(Box.createHorizontalStrut(8));
		numbertext = new JTextField(15);
		nametext = new JTextField(15);
		box1.add(numbertext);

		box2 = Box.createHorizontalBox();
		box2.add(new JLabel(" 修改后的名称  ："));
		box2.add(Box.createHorizontalStrut(9));
		box2.add(nametext);

		box3 = Box.createHorizontalBox();
		JButton button1 = new JButton("确定");
		JButton button2 = new JButton("重置");
		box3.add(button1);
		box3.add(Box.createHorizontalStrut(10));
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

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String number = numbertext.getText();
				String name = nametext.getText();
				if (!number.equals("")) {
					int n = JOptionPane.showConfirmDialog(null, "确认修改吗？","确认对话框", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						DBOperation dbupdate = new DBOperation();
						dbupdate.setDatasourceName("library");
						dbupdate.setSQL("update user set name='"+name+"' where number='"+number+"'");
						if (dbupdate.executeSQL()) {
							JOptionPane.showMessageDialog(null, "修改成功");
						}else {
							JOptionPane.showMessageDialog(null, "修改失败");
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "请输入需要修改的用户编号：");
				}
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				numbertext.setText("");
				nametext.setText("");
			}
		});
	}
}
