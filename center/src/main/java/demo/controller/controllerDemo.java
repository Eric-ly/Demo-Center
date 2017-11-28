package demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;


@Controller
public class controllerDemo
{
	private static Logger logger = LoggerFactory.getLogger(controllerDemo.class);
	@RequestMapping("/demo/model.do")
	public ModelAndView modelDemo( String user,  String password,HttpSession session)
	{
		 ModelAndView mav = new ModelAndView("demo");
		 mav.addObject("user",user);
		 mav.addObject("password", password);
		 session.setAttribute("username", user);
		 logger.info("model.do"+user.toString());
		return mav;
	}
	@RequestMapping("/login.do")
	public String loginDemo( String user,  String password,HttpSession session)
	{
		if("richard".equals(user)&&"123456".equals(password)){
			session.setAttribute("sessionUser", user);
			logger.debug("login success");
			return "redirect:/index.jsp";
		}
		System.out.println("login error 's resolt");
		logger.error("login in error");
		return "redirect:/login.jsp";
			
	}
	@RequestMapping("/ajaxDemo.do")
	public String ajaxDemoPage(){
		return "DemoAjax";
	}
//	用参数接 前台ajax 传过来的 url格式的字符串
	@RequestMapping("/checkbox.do")
	@ResponseBody
	public String testCheckbox(String[] c, HttpServletRequest req) {
		System.out.println(req.getParameterValues("c").toString());
		System.out.println(Arrays.toString(req.getParameterValues("c")));
		System.out.println(Arrays.toString(c));
		return "success";
	}
//	用对象接收前台传过来的json字符串，
	@RequestMapping("/checkboxjson.do")
	@ResponseBody
	public String testCheckboxJson(@RequestBody FormElement[] f) {
		System.out.println(Arrays.toString(f));
		return "success";
	}
	@RequestMapping("/checkboxjsonArray.do")
	@ResponseBody
	public String testCheckboxJsonArray(String[] c) {
		System.out.println(Arrays.toString(c));
		return "success";
	}
}

class FormElement {
	@Override
	public String toString()
	{
		return "FormElement [name=" + name + ", value=" + value + "]";
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getValue()
	{
		return value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
	private String name;
	private String value;
	
	
}