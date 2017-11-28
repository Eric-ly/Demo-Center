package demo.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.*;

public class RedisConnection
{
	Jedis jedis = new Jedis("127.0.0.1",6379);

	public static void main(String[] args){
		Jedis jedis =new Jedis("127.0.0.1", 6379);
		System.out.println(jedis.ping());
	}
	@Test
	public void setGet(){
		
		jedis.set("k1","v1");
		jedis.set("k2","v2");
		jedis.set("k3","v3");
		
		
		System.out.println(jedis.get("k3"));
		
		Set<String> sets = jedis.keys("*");
		System.out.println(sets.size());
	}
	@Test
	public void zset(){
//		zset
		jedis.zadd("zset01", 50, "v1");
		jedis.zadd("zset01", 60, "v2");
		jedis.zadd("zset01", 70, "v3");
		jedis.zadd("zset01", 80, "v4");
		
		Set<String> s1 = jedis.zrange("zset01", 0, -1);
		for(Iterator iterator =s1.iterator() ;iterator.hasNext();){
			String string =(String) iterator.next();
			System.out.println(string);
		}
	}
	@Test
	public void hashtest(){
		jedis.hset("hash1", "username", "zhangsan");
		System.out.println(jedis.hget("hash1", "username"));
		Map<String, String > map=new HashMap<String, String>();
		map.put("phone", "123456");
		map.put("address", "qwertyuio");
		map.put("email", "111@111.com");
		
		jedis.hmset("hash2", map);
		Collection<String> result=jedis.hmget("hash2", "phone","email");
		for(String s:result){
			System.out.println(s);
		}
		
	}
	@Test
	public void transactionTest(){
		Transaction transaction=jedis.multi();
		
		transaction.set("k44", "v44");
		transaction.set("k55", "v55");
		transaction.exec();
//		transaction.discard();

	}

}
