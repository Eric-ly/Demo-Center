package demo.controller;


import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class IoDemo {
	@RequestMapping("/iodemo.do")
	public ResponseEntity<byte[]> iodemocontroller(HttpSession session) throws IOException{
		System.out.println("io controller start");
		consoletToFile();
		byte [] body = null;
		ServletContext servletContext = session.getServletContext();
		FileInputStream in =new FileInputStream(new File("/Users/i325009/Documents/java-project-demo/file-folder/iofile.txt"));
		body = new byte[in.available()];
		in.read(body);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=iodemo.txt");
		HttpStatus statusCode = HttpStatus.OK;
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
	}
	
	@Test
	public void consoletToFile(){
		System.out.println("io demo start");
		BufferedReader br=null;
		BufferedWriter bw=null;
		String str = null;
		try{
		File f=new File("/Users/i325009/Documents/java-project-demo/file-folder/iofile.txt");
		br=new BufferedReader(new InputStreamReader(System.in));
		
		if(!f.exists()){
			f.createNewFile();
		}
		bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		bw.write("下面是控制台的输入：");
		bw.newLine();
		bw.flush();
		if((str=br.readLine())!=null){
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		bw.write(" 输入结束");
		bw.flush();
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try
			{
				bw.close();
				br.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
/**
 * 从文件中读取数据
 */
	public void readfile(){
		BufferedReader br=null;
		BufferedWriter bw=null;
		File f = new File("/Users/i325009/Documents/java-project-demo/file-folder/iofile.txt");
		
		 try
		{
			br=new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			
			
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * 字符流操作控制台输入输出(高效)
	 */
	@Test
	public void test() {
		System.out.println("a");
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			// 利用转换流将控制台上的字节流转换成字符流
			System.out.println("test");
			br = new BufferedReader(new InputStreamReader(System.in));
			// 利用转换流将缓冲区中的字符流转成控制台上的字符流
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			// 单个字符的循环输入输出
//			oneWordIO(br, bw);
			// 一行一行循环输入输出
			oneLineIO(br, bw);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 一行一行循环输入输出
	 */
	private static void oneLineIO(BufferedReader in, BufferedWriter out)
			throws IOException {
		String str = null;
		while ((str = in.readLine()) != null) {
			out.write(str, 0, str.length());
//			换行
			out.newLine();
//			如果此输出流的实现已经缓冲了以前写入的任何字节，则调用此方法指示应将这些字节立即写入它们预期的目标
			out.flush();
		}
	}

	/**
	 * 单个字符的输入整行输出
	 */
	private static void oneWordIO(BufferedReader in, BufferedWriter out)
			throws IOException {
		int ch = -1;
		while ((ch = in.read()) != -1) {
			out.write(ch);
			out.flush();
		}
	}

}
