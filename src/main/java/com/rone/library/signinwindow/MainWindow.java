package com.rone.library.signinwindow;

import com.rone.library.book.*;
import com.rone.library.business.*;
import com.rone.library.user.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 主界面类
 * @author zou_rong_hui
 *
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	/**
	 * 构造方法
	 */
	public MainWindow() {
		//窗口界面的布局
		this.init();
		this.setBounds(400,200,600,500);
		setTitle("主界面");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void init () {
		//创建对象
		final JPanel panel1;
		final CardLayout card;
		JLabel bgi;
		AddUserPanel adduser;
		DeleteUserPanel deleteuser;
		UpdateUserPanel updateuser;
		BackBookPanel backbook;
		LendBookPanel lendbook;
		AddBookkindPanel addbookkind;
		AddBookPanel addbook;
		DeleteBookkindPanel deletebookkind;
		DeleteBookPanel deletebook;
		UpdateBookkindPanel updatebookkind;
		UpdateBookPanel updatebook;

		panel1 = new JPanel();
		//card布局
		card = new CardLayout();
		bgi = new JLabel(new ImageIcon("image/book.jpg"));
		adduser = new AddUserPanel();
		deleteuser = new DeleteUserPanel();
		updateuser = new UpdateUserPanel();
		backbook = new BackBookPanel();
		lendbook = new LendBookPanel();
		addbookkind = new AddBookkindPanel();
		addbook = new AddBookPanel();
		deletebookkind = new DeleteBookkindPanel();
		deletebook = new DeleteBookPanel();
		updatebookkind = new UpdateBookkindPanel();
		updatebook = new UpdateBookPanel();

		//将组件添加到面板中
		panel1.setLayout(card);
		panel1.add("first", bgi);
		panel1.add("adduser", adduser);
		panel1.add("deleteuser", deleteuser);
		panel1.add("updateuser", updateuser);
		panel1.add("backbook", backbook);
		panel1.add("lendbook", lendbook);
		panel1.add("addbookkind", addbookkind);
		panel1.add("addbook", addbook);
		panel1.add("deletebookkind", deletebookkind);
		panel1.add("deletebook", deletebook);
		panel1.add("updatebookkind", updatebookkind);
		panel1.add("updatebook", updatebook);

		//将面板添加到当前窗口中
		this.add(panel1);

		//菜单条
		JMenuBar menubar = new JMenuBar();
		//借阅者管理模块
		JMenu menu1 = new JMenu(" 借阅者管理");
		//添加借阅者
		//创建菜单项，以及添加图标
		JMenuItem menuitem1_2 = new JMenuItem("添加借阅者", new ImageIcon("sign_in.gif"));
//		menuitem1_2.setIcon(new ImageIcon("sign_in.gif"));
		//绑定监视器
		menuitem1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				AddUserWindow win = new AddUserWindow();
//				win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				//布局显示名为adduser的组件
				card.show(panel1, "adduser");
			}
		});
		menu1.add(menuitem1_2);
		//修改借阅者
		JMenuItem menuitem1_3 = new JMenuItem("修改借阅者", new ImageIcon("change_user.gif"));
		menuitem1_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel1, "updateuser");
//				UpdateUserWindow win = new UpdateUserWindow();
//				win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		menu1.add(menuitem1_3);
		//删除借阅者
		JMenuItem menuitem1_4 = new JMenuItem("删除借阅者", new ImageIcon("delete_user.gif"));
		menuitem1_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel1, "deleteuser");
//				DeleteUserWindow win = new DeleteUserWindow();
//				win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//				String s = JOptionPane.showInputDialog(null, "输入你需要删除的用户的编号：", "删除借阅者", JOptionPane.PLAIN_MESSAGE);
//				if (!s.equals("")) {
//             		int n = JOptionPane.showConfirmDialog(null, "确认删除用户<"+s+">吗？", "确认对话框", JOptionPane.YES_NO_OPTION);
//             		if (n == JOptionPane.YES_OPTION) {
//             			DBOperation dbdelete = new DBOperation();
//    					dbdelete.setDatasourceName("library");
//    					dbdelete.setSQL("delete from user where number='"+s+"'");
//    					if (dbdelete.executeSQL()) {
//    						JOptionPane.showMessageDialog(null, "删除成功");
//    					}else{
//    						JOptionPane.showMessageDialog(null, "删除失败", "警告", JOptionPane.ERROR_MESSAGE);
//    					}
//             		}
//				}else{
//					JOptionPane.showMessageDialog(null, "你没有输入需要删除的用户编号");
//				}
			}
		});
		menu1.add(menuitem1_4);
		//基本业务模块
		JMenu menu2 = new JMenu(" 基本业务 ");
		//借书处理
		JMenuItem menuitem2_1 = new JMenuItem("借书处理", new ImageIcon("lend_book.gif"));
		//绑定快捷键
		menuitem2_1.setAccelerator(KeyStroke.getKeyStroke('L'));
		menuitem2_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel1, "lendbook");
//				LendBookWindow win = new LendBookWindow();
//				win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		menu2.add(menuitem2_1);
		//还书处理
		JMenuItem menuitem2_2 = new JMenuItem("还书处理", new ImageIcon("back_book.gif"));
		menuitem2_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel1, "backbook");
//				BackBookWindow win = new BackBookWindow();
//				win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//				String s = JOptionPane.showInputDialog(null, "请输入图书编号", "归还图书", JOptionPane.PLAIN_MESSAGE);
//				if (s != null) {
//					int n = JOptionPane.showConfirmDialog(null, "确认归还？", "确认", JOptionPane.YES_NO_OPTION);
//					if (n == JOptionPane.YES_OPTION) {
//						DBOperation dbdelete = new DBOperation();
//    					dbdelete.setDatasourceName("library");
//    					dbdelete.setSQL("delete from business where booknumber='"+s+"'");
//    					if (dbdelete.executeSQL()) {
//    						JOptionPane.showMessageDialog(null, "删除成功");
//    					}else{
//    						JOptionPane.showMessageDialog(null, "删除失败", "警告", JOptionPane.ERROR_MESSAGE);
//    					}
//					}
//				}else{
//					JOptionPane.showMessageDialog(null, "请输入归还的图书编号");
//				}
			}
		});
		menu2.add(menuitem2_2);
		//预定图书
		JMenuItem menuitem2_3 = new JMenuItem("预定图书", new ImageIcon("yuding_book.gif"));
		menuitem2_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "该模块暂未完成！");
			}
		});
		menu2.add(menuitem2_3);
		//图书维护模块
		JMenu menu3 = new JMenu(" 图书维护");
		//添加物理书刊
		JMenuItem menuitem3_1 = new JMenuItem("添加物理书刊", new ImageIcon("add_book.gif"));
		menuitem3_1.setAccelerator(KeyStroke.getKeyStroke('A'));
		menuitem3_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel1, "addbook");
//				AddBookWindow win = new AddBookWindow();
//				win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		menu3.add(menuitem3_1);
		//修改物理书刊
		JMenuItem menuitem3_2 = new JMenuItem("修改物理书刊", new ImageIcon("change_book.gif"));
		menuitem3_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel1, "updatebook");
//				UpdateBookWindow win = new UpdateBookWindow();
//				win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		menu3.add(menuitem3_2);
		//删除物理书刊
		JMenuItem menuitem3_3 = new JMenuItem("删除物理书刊", new ImageIcon("delete_book.gif"));
		menuitem3_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel1, "deletebook");
//				DeleteBookWindow win = new DeleteBookWindow();
//				win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//				String s = JOptionPane.showInputDialog(null, "请输入图书编号", "删除图书", JOptionPane.PLAIN_MESSAGE);
//				if (s != null) {
//					int n = JOptionPane.showConfirmDialog(null, "确认删除？", "确认", JOptionPane.YES_NO_OPTION);
//					if (n == JOptionPane.YES_OPTION) {
//						DBOperation dbdelete = new DBOperation();
//    					dbdelete.setDatasourceName("library");
//    					dbdelete.setSQL("delete from books where number='"+s+"'");
//    					if (dbdelete.executeSQL()) {
//    						JOptionPane.showMessageDialog(null, "删除成功");
//    					}else{
//    						JOptionPane.showMessageDialog(null, "删除失败", "警告", JOptionPane.ERROR_MESSAGE);
//    					}
//					}
//				}else{
//					JOptionPane.showMessageDialog(null, "请输入要删除的图书编号");
//				}
			}
		});
		menu3.add(menuitem3_3);
		//添加书种
		JMenuItem menuitem3_4 = new JMenuItem("添加书种", new ImageIcon("add_book_class.gif"));
		menuitem3_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel1, "addbookkind");
//				AddBookkindWindow win = new AddBookkindWindow();
//				win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		menu3.add(menuitem3_4);
		//修改书种
		JMenuItem menuitem3_5 = new JMenuItem("修改书种", new ImageIcon("change_book_class.gif"));
		menuitem3_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel1, "updatebookkind");
//				UpdateBookkindWindow win = new UpdateBookkindWindow();
//				win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		menu3.add(menuitem3_5);
		//删除书种
		JMenuItem menuitem3_6 = new JMenuItem("删除书种", new ImageIcon("delete_book_class.gif"));
		menuitem3_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel1, "deletebookkind");
//				DeleteBookkindWindow win = new DeleteBookkindWindow();
//				win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//				String s = JOptionPane.showInputDialog(null, "请输入书种名", "删除书种", JOptionPane.PLAIN_MESSAGE);
//				if (s != null) {
//					int n = JOptionPane.showConfirmDialog(null, "确认删除？", "确认", JOptionPane.YES_NO_OPTION);
//					if (n == JOptionPane.YES_OPTION) {
//						DBOperation dbdelete = new DBOperation();
//    					dbdelete.setDatasourceName("library");
//    					dbdelete.setSQL("delete from bookkinds where bookkind='"+s+"'");
//    					if (dbdelete.executeSQL()) {
//    						JOptionPane.showMessageDialog(null, "删除成功");
//    					}else{
//    						JOptionPane.showMessageDialog(null, "删除失败", "警告", JOptionPane.ERROR_MESSAGE);
//    					}
//					}
//				}else{
//					JOptionPane.showMessageDialog(null, "请输入要删除的书种名");
//				}
			}
		});
		menu3.add(menuitem3_6);
		//帮助模块
		JMenu menu4 = new JMenu(" 帮助 ");
		//开发人员
		JMenuItem menuitem4_1 = new JMenuItem("开发人员", new ImageIcon("help.gif"));
		menuitem4_1.setAccelerator(KeyStroke.getKeyStroke('H'));
		menuitem4_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "开发人员：", "开发人员", JOptionPane.PLAIN_MESSAGE);
			}
		});
		menu4.add(menuitem4_1);
		//主页
		JMenuItem menuitem4_2 = new JMenuItem("主页");
		menuitem4_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel1, "first");
			}
		});
		menu4.add(menuitem4_2);

		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.add(menu4);
		setJMenuBar(menubar);
	}
}
