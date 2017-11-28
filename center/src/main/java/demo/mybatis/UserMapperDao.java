package demo.mybatis;

import demo.entity.SMUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component 
public interface UserMapperDao
{
	void save(SMUser user);
	void update(SMUser user);
	void delete(int id);
	SMUser findById(int id);
	List<SMUser> findAll();
}
