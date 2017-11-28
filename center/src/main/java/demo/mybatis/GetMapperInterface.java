package demo.mybatis;

import demo.entity.user;
import org.apache.ibatis.annotations.Insert;

public interface GetMapperInterface
{

	@Insert("Select * from users Where id = #{id}")
	public user getUserById(String id);

	@Insert("insert into users (name,id,age) values(#{name},#{id},#{age})")
	public int addUser(user u);
	
	
}
