package demo.persistence.dbutil;

import demo.entity.User2;

import java.util.List;

public class DbUtilsDao
{

	public void add(User2 user){
		String sql = "insert into user(name,password,birthdate) values(?,?,?)";
		DbHelper.executeSql(sql, user.getName(), user.getPassword(), user.getBirthday());		
	}
	
	public void update(User2 user){
		String sql = "update user set name=?,password=?,birthdate=? where id=?";
		DbHelper.executeSql(sql, user.getName(), user.getPassword(), user.getBirthday(), user.getId());
	}
	public void delete(int id) {
		DbHelper.executeSql("delete from user where id=?", id);
	}
	public User2 getById(int id){
		return DbHelper.getSingleResult("select  id,name name,password,birthdate birthday  from user where id=?", User2.class, id);

	}
	
	public List<User2> getUsers(){
		return DbHelper.getResult("select id,username name,password,birthdate birthday from user", User2.class);

		
	}
	public long getUserCount() {
		return DbHelper.getScalarResult("select count(*) from user", Long.class);
	}
}
