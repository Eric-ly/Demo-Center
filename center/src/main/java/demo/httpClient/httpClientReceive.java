package demo.httpClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


@Controller
public class httpClientReceive
{
	private static Logger logger = LoggerFactory.getLogger(httpClientReceive.class);
	@RequestMapping("/httpClient/test.do")
	public ModelAndView showMessage( 
			@RequestParam(defaultValue="default") String msg ,
			@RequestParam(defaultValue="defaultuser") String user,
			@RequestParam(defaultValue="password") String password )
	{
		 ModelAndView mav = new ModelAndView("Message");
		 mav.addObject("msg",msg);
		 mav.addObject("user",user);
		 mav.addObject("password",password);
		 logger.info("showMessage.do"+msg);
		return mav;
	}
	
	@RequestMapping("/httpClient/fileUpload.do")
	@ResponseBody
	public String upload(@RequestParam("desc")String desc, @RequestParam("file") MultipartFile file,HttpServletResponse httpResponse) throws IllegalStateException, IOException{
		if(!file.isEmpty()){

			System.out.println(desc);
			file.transferTo(new File("/Users/i325009/Documents/java-project-demo/file/"+file.getOriginalFilename()));
			httpResponse.setStatus(200);

		}
//		Map map =new HashMap<String, String>();
//		map.put("1", "11");
//		map.put("2", "22");
//		return map;
		
		return "success";
		
	}
}
