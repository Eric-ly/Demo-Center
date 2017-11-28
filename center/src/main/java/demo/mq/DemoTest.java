package demo.mq;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

//http://www.oschina.net/translate/getting-started-with-rabbitmq-in-java
public class DemoTest
{
	public DemoTest() throws Exception{
		
		QueueConsumer consumer = new QueueConsumer("queue");
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();
		
		Producer producer = new Producer("queue");
		
		for (int i = 0; i < 1000; i++) {
			HashMap message = new HashMap();
			message.put("message number", i);
			producer.sendMessage(message);
			System.out.println("Message Number "+ i +" sent.");
		}
		Thread.sleep(10000);
		producer.close();
		consumer.close();
	}
	
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception{
	  new DemoTest();
	}
}
