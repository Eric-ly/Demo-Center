package demo.jdbc;

import org.junit.Test;

import java.sql.*;

public class crud
{
	public static String diver="com.mysql.jdbc.Driver";
   public static String dburl = "jdbc:mysql://localhost:3306/mybatis";  
   public static String dbuser = "root";  
   public static String dbpassword = "";  
   
   public static void main(String[] args) {
   	try{
   		Class.forName(diver);
   		Connection conn =DriverManager.getConnection(dburl, dbuser, dbpassword);
   		
//   		String sql1 ="update users set name = 'zhangsan' where id = 2";
//   		String sql2 ="update users set name = 'zhangsan' where id = 3";
   		Statement stmt = conn.createStatement();
//   		stmt.addBatch(sql1);
//   		stmt.addBatch(sql2);
//   		int[] is = stmt.executeBatch();
//   		executebatch 是批量 更新的操作，
   		
   		ResultSet result=stmt.executeQuery("select * from users");
   		
   		while(result.next()){
   			System.out.println( "name: "+result.getString("name")+"  id  : "+result.getString("id")+ "  age : "+result.getString("age") );
   		}
   		result.close();
   		
   		int i =stmt.executeUpdate("update users set name = 'lisi' where id = 5 ");
   		System.out.println("effect : " + i );
   	}
   	catch(Exception e){
   		e.printStackTrace();
   	}
   	finally {
		}
   	
   }
//   prepareStatement 预处理，穿参数进到sql 中
   @Test
   public void jdbcSql(){
		try
		{   	
			Class.forName(diver);
			Connection conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
			
			String sql = "insert into users (name,id,age ) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
					
	        pstmt.setString(1, "wangwu");
	        pstmt.setInt(2, 6);
	        pstmt.setInt(3, 18);
	        int i = pstmt.executeUpdate();
	        conn.close();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   @Test
   public void likeSql(){
		try
		{   	
			Class.forName(diver);
			Connection conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
			
			String sql = "select * from users where name like ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, "%"+"wang"+"%");

	        ResultSet resultSet = pstmt.executeQuery();
	        while(resultSet.next()){
	      	  System.out.println(resultSet.getString("name"));
	        }
	        conn.close();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   

}
