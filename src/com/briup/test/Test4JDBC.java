package com.briup.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * JDBC连接数据库
 * @author 26503
 * 
 */
public class Test4JDBC {
	
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static String username = "briup";
	static String password = "briup";
	
	static {
		
	}
	
	/*static int id = 1001;
	static String name = "市场部";*/
	
	public static void test_jdbc_insert(int id,String name) throws Exception {
//		System.out.println("2-in test_jdbc_insert()");
		//	1. 加载驱动
		//className类的【全限定名】= 包名+类名
		//Class.forName(className)
		Class.forName(driver);
		//	2. 获取connection对象
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println(conn);
		//	3. 获取Statement对象
		//	同构的sql语句
		String sql = "insert into s_region(id,name) values(?,?)";
		//Statement stmt = conn.createStatement();
		//executeQuery(sql) 返回值是ResultSet，一般用于select
		//ResultSet rs = stmt.executeQuery(sql);
		//execute(sql) 返回值boolean类型，适用于insert,delete,update
//		String sql1 = "insert into s_region(id,name) values('1','市场部')";
//		boolean execute1 = stmt.execute(sql1);
//		sql1 = "insert into s_region(id,name) values('2','销售部')";
//		boolean execute2 = stmt.execute(sql2);
//		String sql3 = "insert into s_region(id,name) values('3','后勤部')";
//		boolean execute3 = stmt.execute(sql3);
		//executeUpdate(sql) 返回值 int，适用于insert,delete,update
		//int eu = stmt.executeUpdate(sql);
		//同构的sql 用起来更加方便，默认有预处理，预编译
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, name);
		//	4. 执行sql语句
		ps.execute();
		//提交事务
		conn.commit();
		//	5. 处理结果集
		//
		//	6. 关闭资源
		if (ps!=null) {
			ps.close();
		}
		if (conn!=null) {
			conn.close();
		}
	}

	public static void test_jdbc_update(int id,String name) throws Exception {
		
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		String sql = "update s_region set name=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setInt(2, id);
		
		ps.execute();
		conn.commit();
		
	}

	public static void test_jdbc_delete(int id) throws Exception {
		
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		String sql = "delete from s_region where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		ps.execute();
		conn.commit();
		
	}

	public static void test_jdbc_select() throws Exception {
		
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		String sql = "select * from s_region";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			/*int id = rs.getInt(1);
			String name = rs.getString(2);*/
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id+" "+name);
		}
		conn.commit();
		
	}

	
	public static void main(String[] args) throws Exception {
		System.out.println("1-in main()");
		//test_jdbc_insert(1002,"销售部");
		
		//test_jdbc_update(1002,"后勤部");
		
		//test_jdbc_delete(1002);
		//System.out.println("删除成功！！！");
		
		test_jdbc_select();
	}
}
