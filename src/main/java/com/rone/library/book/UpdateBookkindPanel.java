package com.rone.library.book;

import com.rone.library.db.DBOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class UpdateBookkindPanel extends JPanel {
	JTextField bookkindtext;
	JTextArea introductiontext;
	JButton button1;
	JButton button2;
	Box basebox;
	Box box0;
	Box box1;
	Box box2;
	Box box3;
	public 	UpdateBookkindPanel() {
		this.setLayout(new FlowLayout());
		setBackground(Color.pink);

		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("修改书种"));

		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("书种："));
		box1.add(Box.createHorizontalStrut(8));
		bookkindtext = new JTextField(15);
		box1.add(bookkindtext);

		introductiontext = new JTextArea();
		box2 = Box.createHorizontalBox();
		box2.add(new JLabel("简介："));
		box2.add(Box.createHorizontalStrut(8));
		box2.add(introductiontext);

		button1 = new JButton("修改");
		button2 = new JButton("重置");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				DBOperation dbinsert = new DBOperation();
				dbinsert.setDatasourceName("library");
				String bookkind = bookkindtext.getText().trim();
				String introduction = introductiontext.getText();
				dbinsert.setSQL("update bookkinds set introduction='"+introduction+"' where bookkind='"+bookkind+"'");
				if (!bookkind.equals("") && !introduction.equals("")) {
					int n = JOptionPane.showConfirmDialog(null, "确认修改吗？", "确认对话框", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						if (dbinsert.executeSQL()) {
							JOptionPane.showMessageDialog(null, "修改成功");
						}else {
							JOptionPane.showMessageDialog(null, "修改失败", "警告", JOptionPane.ERROR_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "请输入需要修改的值");
				}
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				bookkindtext.setText("");
				introductiontext.setText("");
			}
		});
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
