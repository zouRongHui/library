package com.rone.library.book;

import com.rone.library.db.DBOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AddBookPanel extends JPanel {
	JTextField numbertext;
	JTextField bookkindtext;
	JTextField booknametext;
	JTextField counttext;
	JTextField authortext;
	JTextField publishertext;
	JButton button1;
	JButton button2;
	Box basebox;
	Box box0;
	Box box1;
	Box box2;
	Box box3;
	Box box4;
	Box box5;
	Box box6;
	Box box7;
	public AddBookPanel() {
		this.setLayout(new FlowLayout());
		setBackground(Color.pink);

		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("添加图书"));

		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("编   号："));
		box1.add(Box.createHorizontalStrut(8));
		numbertext = new JTextField(15);
		box1.add(numbertext);

		bookkindtext = new JTextField(15);
		box2 = Box.createHorizontalBox();
		box2.add(new JLabel("书   种："));
		box2.add(Box.createHorizontalStrut(8));
		box2.add(bookkindtext);

		box3 = Box.createHorizontalBox();
		box3.add(new JLabel("书   名："));
		box3.add(Box.createHorizontalStrut(8));
		booknametext = new JTextField(15);
		box3.add(booknametext);

		box4 = Box.createHorizontalBox();
		box4.add(new JLabel("数   量："));
		box4.add(Box.createHorizontalStrut(8));
		counttext = new JTextField(15);
		box4.add(counttext);

		box5 = Box.createHorizontalBox();
		box5.add(new JLabel("作   者："));
		box5.add(Box.createHorizontalStrut(8));
		authortext = new JTextField(15);
		box5.add(authortext);

		box6 = Box.createHorizontalBox();
		box6.add(new JLabel("出版社："));
		box6.add(Box.createHorizontalStrut(8));
		publishertext = new JTextField(15);
		box6.add(publishertext);

		button1 = new JButton("添加");
		button2 = new JButton("重置");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				DBOperation dbinsert = new DBOperation();
				dbinsert.setDatasourceName("library");
				String number = numbertext.getText();
				String bookkind = bookkindtext.getText();
				String bookname = booknametext.getText();
				String count = counttext.getText();
				String author = authortext.getText();
				String publisher = publishertext.getText();
				dbinsert.setSQL("insert into books values ('"+number+"','"+bookkind+"','"+bookname+"','"+count+"','"+author+"','"+publisher+"')");
				if (!number.equals("") && !bookkind.equals("") && !bookname.equals("") && !count.equals("") && !author.equals("") && !publisher.equals("")) {
					int n = JOptionPane.showConfirmDialog(null, "确认添加吗？", "确认对话框", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						if (dbinsert.executeSQL()) {
							JOptionPane.showMessageDialog(null, "添加成功");
						}else {
							JOptionPane.showMessageDialog(null, "添加失败", "警告", JOptionPane.ERROR_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "以上栏目存在空值!");
				}
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				numbertext.setText("");
				bookkindtext.setText("");
				booknametext.setText("");
				counttext.setText("");
				authortext.setText("");
				publishertext.setText("");
			}
		});
		box7 = Box.createHorizontalBox();
		box7.add(Box.createHorizontalStrut(30));
		box7.add(button1);
		box7.add(Box.createHorizontalStrut(30));
		box7.add(button2);

		basebox = Box.createVerticalBox();
		basebox.add(Box.createVerticalStrut(40));
		basebox.add(box0);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box1);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box2);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box3);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box4);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box5);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box6);
		basebox.add(Box.createVerticalStrut(20));
		basebox.add(box7);

		add(basebox);
	}
}
