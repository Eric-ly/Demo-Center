package demo.mybatis;

import demo.entity.Class;
import demo.entity.Order;
import demo.entity.UserCache;
import demo.entity.user;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * mybatis快速入门
 */
public class operate {

	private Logger logger = LoggerFactory.getLogger(operate.class);
	public static void main(String[] args) throws IOException {
		
		InputStream is =operate.class.getResourceAsStream("conf.xml");
		SqlSessionFactory sessionFactory =new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		String Statement = "demo.mybatis.userMapper.getUser";
		user user1 =session.selectOne(Statement, 2);
		System.out.println(user1);
		
	}
	@Test
	public void getAllUser (){
		SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
		SqlSession session = sessionFactory.openSession(true);
		String statement = "demo.mybatis.userMapper.getAllUsers";
		List<user> userlist = session.selectList(statement);
		logger.debug(userlist.toString());
	}
	@Test
	public void addUserByAnnotation(){
		SqlSessionFactory sessionFactory= MybatisUtil.getSessionFactory();
		SqlSession sqlSession =sessionFactory.openSession(true);
		GetMapperInterface mapper =sqlSession.getMapper(GetMapperInterface.class);
		user u = new user();
		u.setName("zhangsan");
		u.setAge(28);
		u.setId(5);
		Integer num = mapper.addUser(u);
		logger.debug(num.toString());
	}
//数据库字段和 实体类属性不一致
	@Test
	public void getParamValue(){
		SqlSessionFactory sessionFactory= MybatisUtil.getSessionFactory();
		SqlSession sqlSession =sessionFactory.openSession(true);
		Order or =sqlSession.selectOne("demo.mybatis.userMapper.getOrder", 2);
		System.out.println(or);
	}
	@Test
	public void getParamValue2(){
		SqlSessionFactory sessionFactory= MybatisUtil.getSessionFactory();
		SqlSession sqlSession =sessionFactory.openSession(true);
		Order or =sqlSession.selectOne("demo.mybatis.userMapper.getOrder2", 2);
		System.out.println(or);
	}
	@Test
	public void getOneToOneByJoin(){
		SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
		SqlSession session = sessionFactory.openSession(true);
//		嵌套结果，联表查询
		String statement ="demo.mybatis.mapper.getClass";
//		嵌套查询，两次查询
		statement = "demo.mybatis.mapper.getClass2";
		Class class1=session.selectOne(statement,1);
		
		System.out.println(class1.toString());
		
	}
	
	@Test
	public void getOneToMultiByJoin(){
		SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
		SqlSession session = sessionFactory.openSession(true);
//		嵌套结果，联表查询
		String statement ="demo.mybatis.oneToMuMapper.getClass";
//		嵌套查询，两次查询
		statement = "demo.mybatis.oneToMuMapper.getClass2";
		Class class1=session.selectOne(statement,1);
		
		System.out.println(class1.toString());
		
	}
	@Test
	public void mybaitsProcess(){
		SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
		SqlSession session = sessionFactory.openSession(true);
		
		String statement = "demo.mybatis.mapper.getUserCount";
		
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("sexid", 1);
		parameterMap.put("usercount", 0);
		session.selectOne(statement, parameterMap);
		Integer result = parameterMap.get("usercount");
		System.out.println(result);
	}
	
	/*
	 * 一级缓存: 也就Session级的缓存(默认开启)
	 */
	@Test
	public void testCache1() {
		SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
		SqlSession session = sessionFactory.openSession(true);
		
		String statement = "demo.mybatis.mapper.getUserCache";
		UserCache user = session.selectOne(statement, 1);
		System.out.println(user);
		System.out.println("----------------------------------");
//		 * 一级缓存默认就会被使用,查询条件相同
		user = session.selectOne(statement, 1);
		System.out.println(user);		
		System.out.println("----------------------------------");
/*
		//		 1. 必须是同一个Session,如果session对象已经close()过了就不可能用了 
		SqlSession session2 = sessionFactory.openSession(true);
		user = session2.selectOne(statement, 1);
		System.out.println(user);	
		System.out.println("----------------------------------");
//		 3. 没有执行过session.clearCache()清理缓存
		session.clearCache(); 
		user = session.selectOne(statement, 1);
		System.out.println(user);
		System.out.println("----------------------------------");
		
//		 4. 没有执行过增删改的操作(这些操作都会清理缓存)
		session.update("demo.mybatis.mapper.updateUserCache", new UserCache(2, "user", 23));
		user = session.selectOne(statement, 1);
		System.out.println(user);
		*/
		

	}
	
}
