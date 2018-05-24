package com.rone.library.book;

import com.rone.library.db.DBOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class DeleteBookkindPanel extends JPanel{
	JTextField numbertext;
	Box basebox;
	Box box0;
	Box box1;
	Box box2;
	JButton button1;
	JButton button2;
	public DeleteBookkindPanel() {
		this.setLayout(new FlowLayout());
		setBackground(Color.pink);

		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("删除书种"));

		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("需要删除的书种名："));
		box1.add(Box.createHorizontalStrut(8));
		numbertext = new JTextField(15);
		box1.add(numbertext);

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

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String number = numbertext.getText().trim();
				if (!number.equals("")) {
					int n = JOptionPane.showConfirmDialog(null, "确认删除书种<"+number+">吗？", "确认对话框", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						DBOperation dbdelete = new DBOperation();
						dbdelete.setDatasourceName("library");
						dbdelete.setSQL("delete from bookkinds where bookkind='"+number+"'");
						if (dbdelete.executeSQL()) {
							JOptionPane.showMessageDialog(null, "删除成功");
						}else{
							JOptionPane.showMessageDialog(null, "删除失败", "警告", JOptionPane.ERROR_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "请输入你需要删除的书种名");
				}
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				numbertext.setText("");
			}
		});
	}
}
