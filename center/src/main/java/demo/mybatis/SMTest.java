package demo.mybatis;

import demo.entity.SMUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-smBeans.xml")
public class SMTest
{	
	@Autowired
	private demo.mybatis.UserMapperDao UserMapperDao;
	
	@Test
	public void testADD(){
//		SMUser user=new SMUser();
		SMUser user=new SMUser(-1,"alex",new Date(),123456);
		user.setId(-1);
		user.setBirthday(new Date());
		user.setName("alex");
		user.setSalary(345678765);
		System.out.println(UserMapperDao);
		System.out.println(user);
		UserMapperDao.save(user);
		List aEs=new ArrayList();
	}
	@Test
	public void update() {
		SMUser user = UserMapperDao.findById(2);
		System.out.println(user);
		user.setSalary(2000);
		UserMapperDao.update(user);
		Map<String, String> map=new HashMap<String, String>();
	}

	@Test
	public void delete() {
		UserMapperDao.delete(3);
	}

	@Test
	public void findById() {
		SMUser user = UserMapperDao.findById(1);
		System.out.println(user);
	}

	@Test
	public void findAll() {
		List<SMUser> users = UserMapperDao.findAll();
		System.out.println(users);
	}

	
}
