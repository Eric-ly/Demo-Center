package demo.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class socketclient2 {
	public static final String IP_ADDR = "localhost";//服务器地址 
	public static final int PORT = 12345;//服务器端口号  
	
    public static void main(String[] args) {  
        System.out.println("客户端启动...");  
        	Socket socket;
			try
			{
				socket = new Socket("localhost", 40000);
				BufferedReader br=new BufferedReader( new InputStreamReader(socket.getInputStream()));
	        	String message=br.readLine();
	        	System.out.println("服务器发来的信息："+message);
	        	
	        	
	        	br.close();
	        	socket.close();
			}
			catch (UnknownHostException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}  
	        	
        	} 
    }  
