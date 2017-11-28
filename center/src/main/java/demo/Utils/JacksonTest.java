package demo.Utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import demo.entity.User2;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class JacksonTest
{
	@Test
	public void jsonTest() throws IOException{
		
      Set set=new HashSet();  
      set.add("篮球");  
      set.add("足球");  
      set.add("乒乓球");  
      
      List list=new ArrayList(){};  
      list.add("普洱");  
      list.add("大红袍");  
      
      
      Map map=new HashMap();  
      map.put("aa", "this is aa");  
      map.put("bb", "this is bb");  
      map.put("cc", "this is cc");
      
      
		User2 user2 = new User2();
		user2.setId(1);
		user2.setBirthday("1995-01-01");
		user2.setName("zhangsan");
		user2.setPassword("123456");
		
		
		ObjectMapper objectMapper =new  ObjectMapper();
		String result1 = objectMapper.writeValueAsString(user2);
		System.out.println(result1);
		String resultmap = objectMapper.writeValueAsString(map);
		System.out.println(resultmap);
		Map m1=objectMapper.readValue(resultmap, Map.class);
		System.out.println(m1);
		System.out.println(m1.get("aa"));
		
		System.out.println(objectMapper.writeValueAsString(list));
		
		
	}
	
	
	

}
