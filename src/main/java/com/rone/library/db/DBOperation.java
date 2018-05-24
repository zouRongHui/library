package com.rone.library.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBOperation {
	String datasourceName = "";
	String tableName = "";
	String SQL = "";
	String url = "jdbc:mysql://localhost:3306/"+datasourceName;
	String dbuser = "root";
	String dbpassword = "root";
	public DBOperation() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			System.out.println("数据库连接失败");
		}
	}
	public void setDatasourceName (String s) {
		this.datasourceName = s.trim();
	}
	public void setTableName (String s) {
		this.tableName = s.trim();
	}
	public void setSQL (String s) {
		this.SQL = s.trim();
	}
	public void setUrl(String a) {
		this.url = a;
	}
	public void setDbuser(String a) {
		this.dbuser = a;
	}
	public void setDbpassword(String a) {
		this.dbpassword = a;
	}
	public boolean executeSQL () {
		Connection con;
		PreparedStatement sql;
		try {
			url = "jdbc:mysql://localhost:3306/"+datasourceName;
			con = DriverManager.getConnection(url, dbuser, dbpassword);
			sql = con.prepareStatement(SQL);
			sql.execute();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("数据表操作出错！");
			return false;
		}
	}

}

