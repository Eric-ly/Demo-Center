package demo.persistence.dbutil;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DbHelper
{
	
	public static Connection getConnection(){
		DbUtils.loadDriver("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql:///demo?useUnicode=true&characterEncoding=utf8";
		Connection conn=null;
		try
		{
			conn=DriverManager.getConnection(url, "root", "");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn){
		try
		{
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static int executeSql( String sql,Object... params){
		QueryRunner runner = new QueryRunner();
		Connection conn=getConnection();
		int num =0;
		try
		{
			num = runner.update(conn , sql,params);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closeConnection(conn);
		}
		return num;
	}
	public static <T> T getScalarResult(String sql, Class<T> c, Object... params) {
		QueryRunner runner = new QueryRunner();
		try {
			return runner.query(getConnection(), sql, new ScalarHandler<T>(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void executeBatchSQL(String sql, Object[][] params) {
		QueryRunner runner = new QueryRunner();
		try {
			runner.batch(getConnection(), sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static <T> List<T> getResult(String sql, Class<T> c, Object... params) {
		QueryRunner runner = new QueryRunner();
		try {
			return runner.query(getConnection(), sql, new BeanListHandler<T>(c), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T getSingleResult(String sql, Class<T> c, Object... params) {
		QueryRunner runner = new QueryRunner();
		try {
			return runner.query(getConnection(), sql, new BeanHandler<T>(c), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
