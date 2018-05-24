package com.rone.library.db;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DBQuery {
	String datasourceName = "";
	String tableName = "";
	String SQL = "";
	String url = "jdbc:mysql://localhost:3306/"+datasourceName;
	String dbuser = "root";
	String dbpassword = "root";
	String user;
	String password;
	public DBQuery() {
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
	public CachedRowSetImpl executeSQL () {
		Connection con;
		PreparedStatement sql;
		ResultSet rs;
		CachedRowSetImpl rowset = null;
		try {
			url = "jdbc:mysql://localhost:3306/"+datasourceName;
			con = DriverManager.getConnection(url, dbuser, dbpassword);
			sql = con.prepareStatement(SQL);
			rs = sql.executeQuery();
			rowset = new CachedRowSetImpl();
			rowset.populate(rs);
		/*	while (rs.next()) {
				user = rs.getString(1);
				password = rs.getString(2);

			}*/
			con.close();//关闭connection其余两个也会被关闭
			return rowset;
		} catch (SQLException e) {
			System.out.println("数据表操作失败！");
			return rowset;
		}
	}

}
