package demo.javaBasic;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class socketserver2
{

	public static void main(String[] args) throws IOException{
		System.out.println("socketserver2 start ");
		ServerSocket serverSocket=new ServerSocket(40000);
		while(true){
			System.out.println("socket 1 start ");
			Socket socket=serverSocket.accept();
			PrintStream printStream =new PrintStream(socket.getOutputStream());
			printStream.println("here");
			printStream.close();
			socket.close();
			System.out.println("socket1 end");
		}
	}
}
