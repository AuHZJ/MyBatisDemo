package com.briup.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.briup.bean.Student;

public class StudentAndAddressImpl implements StudentAndAddressMapper{

	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static String username = "briup";
	static String password = "briup";
	
	@Override
	public Student findStudentAndAddressById(int id) {
		try {
			//1.注册驱动
			Class.forName(driver);
			//2.获取连接对象
			Connection conn = DriverManager.getConnection(url, username, password);
			//3.获取statement对象
			String sql = "select * from students where stud_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			//4.执行sql
			ResultSet rs = ps.executeQuery();
			//5.处理结果集
			Student stu = new Student();
			while(rs.next()) {
				int sid = rs.getInt("id");
				String name = rs.getString(2);
				//...
				
				stu.setId(sid);
				stu.setName(name);
				//...
			}
			System.out.println(stu);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		StudentAndAddressImpl sai = new StudentAndAddressImpl();
		sai.findStudentAndAddressById(2);
	}
}
