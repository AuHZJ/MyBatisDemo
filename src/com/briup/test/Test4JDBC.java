package com.briup.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * JDBC�������ݿ�
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
	static String name = "�г���";*/
	
	public static void test_jdbc_insert(int id,String name) throws Exception {
//		System.out.println("2-in test_jdbc_insert()");
		//	1. ��������
		//className��ġ�ȫ�޶�����= ����+����
		//Class.forName(className)
		Class.forName(driver);
		//	2. ��ȡconnection����
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println(conn);
		//	3. ��ȡStatement����
		//	ͬ����sql���
		String sql = "insert into s_region(id,name) values(?,?)";
		//Statement stmt = conn.createStatement();
		//executeQuery(sql) ����ֵ��ResultSet��һ������select
		//ResultSet rs = stmt.executeQuery(sql);
		//execute(sql) ����ֵboolean���ͣ�������insert,delete,update
//		String sql1 = "insert into s_region(id,name) values('1','�г���')";
//		boolean execute1 = stmt.execute(sql1);
//		sql1 = "insert into s_region(id,name) values('2','���۲�')";
//		boolean execute2 = stmt.execute(sql2);
//		String sql3 = "insert into s_region(id,name) values('3','���ڲ�')";
//		boolean execute3 = stmt.execute(sql3);
		//executeUpdate(sql) ����ֵ int��������insert,delete,update
		//int eu = stmt.executeUpdate(sql);
		//ͬ����sql ���������ӷ��㣬Ĭ����Ԥ����Ԥ����
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, name);
		//	4. ִ��sql���
		ps.execute();
		//�ύ����
		conn.commit();
		//	5. ��������
		//
		//	6. �ر���Դ
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
		//test_jdbc_insert(1002,"���۲�");
		
		//test_jdbc_update(1002,"���ڲ�");
		
		//test_jdbc_delete(1002);
		//System.out.println("ɾ���ɹ�������");
		
		test_jdbc_select();
	}
}
