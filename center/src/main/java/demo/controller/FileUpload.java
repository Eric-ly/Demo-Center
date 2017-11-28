package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class FileUpload
{
	@RequestMapping("/demo/fileUpload.do")
	@ResponseBody
	public String upload(@RequestParam("desc")String desc, @RequestParam("file") MultipartFile file,HttpServletResponse httpResponse) throws IllegalStateException, IOException{
		if(!file.isEmpty()){
			System.out.println(desc);
			file.transferTo(new File("/Users/i325009/Documents/java-project-demo/file/"+file.getOriginalFilename()));
			httpResponse.setStatus(200);;
		}
//		Map map =new HashMap<String, String>();
//		map.put("1", "11");
//		map.put("2", "22");
//		return map;
		
		return "success";
		
	}
}
