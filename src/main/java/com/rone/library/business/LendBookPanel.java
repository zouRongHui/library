package com.rone.library.business;

import com.rone.library.db.DBOperation;
import com.rone.library.db.DBQuery;
import com.sun.rowset.CachedRowSetImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class LendBookPanel extends JPanel{
	private Box box0;
	private Box box1;
	private Box box2;
	private Box box3;
	private Box basebox;
	private JTextField usernumbertext;
	private JTextField booknumbertext;
	public LendBookPanel() {
		setLayout(new FlowLayout());
		setBackground(Color.pink);

		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("借阅图书"));

		usernumbertext = new JTextField(20);
		booknumbertext = new JTextField(20);
		JButton button1 = new JButton("确定");
		JButton button2 = new JButton("重置");

		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("借阅者的编号："));
		box1.add(Box.createHorizontalStrut(8));
		box1.add(usernumbertext);

		box2 = Box.createHorizontalBox();
		box2.add(new JLabel("借阅书籍编号："));
		box2.add(Box.createHorizontalStrut(8));
		box2.add(booknumbertext);

		box3 = Box.createHorizontalBox();
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
				String usernumber = usernumbertext.getText();
				String booknumber = booknumbertext.getText();
				if (!usernumber.equals("") && !booknumber.equals("")) {
					CachedRowSetImpl rowset;
					int count = 0;
					DBQuery dbquery = new DBQuery();
					dbquery.setDatasourceName("library");
					dbquery.setSQL("SELECT count FROM books where number='"+booknumber+"'");
					rowset = dbquery.executeSQL();
					try {
						while (rowset.next()) {
							count = rowset.getInt("count");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if (count >= 1) {
						int n = JOptionPane.showConfirmDialog(null, "确认借阅吗？", "确认对话框", JOptionPane.YES_NO_OPTION);
						if (n == JOptionPane.YES_OPTION) {
							DBOperation dbinsert = new DBOperation();
							dbinsert.setDatasourceName("library");
							dbinsert.setSQL("insert into business (usernumber, booknumber ) values ('"+usernumber+"','"+booknumber+"' )");
							DBOperation dbupdate = new DBOperation();
							dbupdate.setDatasourceName("library");
							String sql = "update books set count =count-1 where number = '"+booknumber+"'";
							dbupdate.setSQL(sql);
							if (dbinsert.executeSQL() && dbupdate.executeSQL()) {
								JOptionPane.showMessageDialog(null, "借书成功！");
							}else{
								JOptionPane.showMessageDialog(null, "操作失败！");
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "库存不足！无法借阅！");
					}
				}else {
					JOptionPane.showMessageDialog(null, "请输入借阅者编号及借阅图书编号值");
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
