package com.rone.library.business;

import com.rone.library.db.DBOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class BackBookPanel extends JPanel{
	JTextField usernumbertext;
	JTextField booknumbertext;
	Box basebox;
	Box box0;
	Box box1;
	Box box2;
	Box box3;
	JButton button1;
	JButton button2;
	public BackBookPanel() {
		this.setLayout(new FlowLayout());
		setBackground(Color.pink);

		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("归还图书"));

		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("需要归还的图书编号："));
		box1.add(Box.createHorizontalStrut(8));
		booknumbertext = new JTextField(15);
		box1.add(booknumbertext);

		box2 = Box.createHorizontalBox();
		box2.add(new JLabel("       借 阅 者 编 号："));
		box2.add(Box.createHorizontalStrut(26));
		usernumbertext = new JTextField(15);
		box2.add(usernumbertext);

		button1 = new JButton("确定");
		button2 = new JButton("重置");
		box3 = Box.createHorizontalBox();
		box3.add(Box.createHorizontalStrut(30));
		box3.add(button1);
		box3.add(Box.createHorizontalStrut(45));
		box3.add(button2);

		basebox = Box.createVerticalBox();
		basebox.add(Box.createVerticalStrut(30));
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
				String booknumber = booknumbertext.getText().trim();
				String usernumber = usernumbertext.getText().trim();
				if (!booknumber.equals("") && !usernumber.equals("")) {
					int n = JOptionPane.showConfirmDialog(null, "<"+usernumber+">确认归还图书<"+booknumber+">吗？", "确认对话框", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						DBOperation dbdelete = new DBOperation();
						dbdelete.setDatasourceName("library");
						dbdelete.setSQL("delete from business where booknumber='"+booknumber+"' and usernumber='"+usernumber+"'");
						DBOperation dbupdate = new DBOperation();
						dbupdate.setDatasourceName("library");
						String sql = "update books set count =count+1 where number = '"+booknumber+"'";
						dbupdate.setSQL(sql);
						if (dbdelete.executeSQL() && dbupdate.executeSQL()) {
							JOptionPane.showMessageDialog(null, "归还成功");
						}else{
							JOptionPane.showMessageDialog(null, "归还失败", "警告", JOptionPane.ERROR_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "请输入你需要归还的图书编号和借阅者编号");
				}
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				usernumbertext.setText("");
				booknumbertext.setText("");
			}
		});
	}
}
