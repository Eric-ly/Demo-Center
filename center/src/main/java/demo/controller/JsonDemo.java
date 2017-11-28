package demo.controller;

import demo.entity.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class JsonDemo
{
	@RequestMapping(value = "/demo/json.do")
//	public  user JsonTest( String username , String userId )//用对象传 用对象接

	public  user JsonTest( @RequestBody user user1)
	{
		System.out.println("json.do"+user1.getName());
		user1.setName("richard");
		user1.setId(325009);
		user1.setAddress("dalian");
		user1.setTelNumber(130);
		return user1;
	}

}
