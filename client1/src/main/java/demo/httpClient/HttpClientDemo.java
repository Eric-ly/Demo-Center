package demo.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class HttpClientDemo
{
	@Test
   public void post() {  
//		从连接池获取连接
      PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
      	connectionManager.setMaxTotal(200);
      	connectionManager.setDefaultMaxPerRoute(1000);
      HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
      httpClientBuilder.setConnectionManager(connectionManager);
      // httpClient实例.    
//		1.从连接池创建
      CloseableHttpClient httpclient = httpClientBuilder.build();
//    2.用httpclients的静态方法创建
//      CloseableHttpClient httpclient = HttpClients.createDefault();  
      // httppost    
      HttpPost httppost = new HttpPost("http://localhost:9080/demo-Center/httpClient/test.do");  
      // 参数list   
      List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
      formparams.add(new BasicNameValuePair("msg", "httpclient message"));  
      formparams.add(new BasicNameValuePair("user", "richard"));
      formparams.add(new BasicNameValuePair("password", "123456"));
      UrlEncodedFormEntity uefEntity;  
//      设置超时时间，通过创建requestconfig 对象，然后把这个对象传入 post 或者  get 方法
//      或者httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000); 

      RequestConfig requestConfig = RequestConfig.custom()  
            .setConnectTimeout(5000).setConnectionRequestTimeout(1000)  
            .setSocketTimeout(5000).build();   
      try {  
          uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
          httppost.setEntity(uefEntity);  
          httppost.setConfig(requestConfig);
          System.out.println("executing request " + httppost.getURI());  
          CloseableHttpResponse response = httpclient.execute(httppost);  
          try {  
              HttpEntity entity = response.getEntity();  
              if (entity != null) {  
                  System.out.println("--------------------------------------");  
                  System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
                  System.out.println("--------------------------------------");  
              }  
          } finally {  
              response.close();  
          }  
      } catch (ClientProtocolException e) {  
          e.printStackTrace();  
      } catch (UnsupportedEncodingException e1) {  
          e1.printStackTrace();  
      } catch (IOException e) {  
          e.printStackTrace();  
      } finally {  
          // 关闭连接,释放资源    
          try {  
              httpclient.close();  
          } catch (IOException e) {  
              e.printStackTrace();  
          }  
      }  
  }  

  /** 
   * 发送 get请求 
   */  
   @Test
   public void getTest(){
   	CloseableHttpClient httpClient = HttpClients.createDefault();
   	HttpGet httpGet = new HttpGet("http://baike.baidu.com/link?url=j8g0AOLTB7J3fFE3WTdzr1BaVKXqcZ0kTFYMc0JZpJB33-p7RTj0RSTehnbVpTcTcmadaVwNSkgbKlizOh11hG89rLaGBNrPodZ11vm8l07");
		CloseableHttpResponse httpResponse;
		try
		{
			httpResponse = httpClient.execute(httpGet);
		
   	try
		{
			HttpEntity httpEntity = httpResponse.getEntity();
			System.out.println(httpResponse.getStatusLine());
			if( httpEntity!=null){
				
			System.out.println("http response context length "+httpEntity.getContentLength());
			System.out.println("http response getContentEncoding"+ httpEntity.getContentEncoding());
			System.out.println("content"+EntityUtils.toString(httpEntity));
			}

		}finally{
			httpResponse.close();
		}
   	}
		catch (ClientProtocolException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try
			{
				httpClient.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
   	
   }
  public void get() {  
      CloseableHttpClient httpclient = HttpClients.createDefault();  
      try {  
          // 创建httpget.    
//      	httpget 里面要放uri，也可以通过URIBuilder 创建
          HttpGet httpget = new HttpGet("http://www.baidu.com/");  
          System.out.println("executing request " + httpget.getURI());  
          // 执行get请求.    
          CloseableHttpResponse response = httpclient.execute(httpget);  
          try {  
              // 获取响应实体    
              HttpEntity entity = response.getEntity();  
              System.out.println("--------------------------------------");  
              // 打印响应状态    
              System.out.println(response.getStatusLine());  
              if (entity != null) {  
                  // 打印响应内容长度    
                  System.out.println("Response content length: " + entity.getContentLength());  
                  // 打印响应内容    
                  System.out.println("Response content: " + EntityUtils.toString(entity));  
              }  
              System.out.println("------------------------------------");  
          } finally {  
              response.close();  
          }  
      } catch (ClientProtocolException e) {  
          e.printStackTrace();  
      } catch (ParseException e) {  
          e.printStackTrace();  
      } catch (IOException e) {  
          e.printStackTrace();  
      } finally {  
          // 关闭连接,释放资源    
          try {  
              httpclient.close();  
          } catch (IOException e) {  
              e.printStackTrace();  
          }  
      }  
  }  
  /** 
   * post方式提交表单（模拟用户登录请求） 
   */  
  public void postForm() {  
      // 创建默认的httpClient实例.    
      CloseableHttpClient httpclient = HttpClients.createDefault();  
      // 创建httppost    
      HttpPost httppost = new HttpPost("http://localhost:9080/demo-Center/httpClient/test.do");  
      // 创建参数队列    
      List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
      formparams.add(new BasicNameValuePair("msg", "demo"));
      formparams.add(new BasicNameValuePair("username", "admin"));  
      formparams.add(new BasicNameValuePair("password", "123456"));  
      UrlEncodedFormEntity uefEntity;  
      try {  
          uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
          httppost.setEntity(uefEntity);  
          System.out.println("executing request " + httppost.getURI());  
          CloseableHttpResponse response = httpclient.execute(httppost);  
          try {  
              HttpEntity entity = response.getEntity();  
              if (entity != null) {  
                  System.out.println("--------------------------------------");  
                  System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
                  System.out.println("--------------------------------------");  
              }  
          } finally {  
              response.close();  
          }  
      } catch (ClientProtocolException e) {  
          e.printStackTrace();  
      } catch (UnsupportedEncodingException e1) {  
          e1.printStackTrace();  
      } catch (IOException e) {  
          e.printStackTrace();  
      } finally {  
          // 关闭连接,释放资源    
          try {  
              httpclient.close();  
          } catch (IOException e) {  
              e.printStackTrace();  
          }  
      }  
  }  
  /** 
   * 上传文件 
   */  
  @Test
  public void upload() {  
      CloseableHttpClient httpclient = HttpClients.createDefault();  
      try {  
          HttpPost httppost = new HttpPost("http://localhost:9080/demo-Center/httpClient/fileUpload.do");  

          FileBody bin = new FileBody(new File("/Users/i325009/Documents/java-project-demo/picture1.jpg"));  
          StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);  

          HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("file", bin).addPart("comment", comment).build();  
          HttpEntity reqEntity2 = MultipartEntityBuilder.create().addPart("desc", bin).build();

          httppost.setEntity(reqEntity);  

          System.out.println("executing request " + httppost.getRequestLine());  
          CloseableHttpResponse response = httpclient.execute(httppost);  
          try {  
              System.out.println("----------------------------------------");  
              System.out.println("response content status"+response.getStatusLine());  
              HttpEntity resEntity = response.getEntity();  
              if (resEntity != null) {  
                  System.out.println("Response content length: " + resEntity.getContentLength()); 
                  System.out.println("response content : "+EntityUtils.toString(resEntity));
              }  
              EntityUtils.consume(resEntity);  
          } finally {  
              response.close();  
          }  
      } catch (ClientProtocolException e) {  
          e.printStackTrace();  
      } catch (IOException e) {  
          e.printStackTrace();  
      } finally {  
          try {  
              httpclient.close();  
          } catch (IOException e) {  
              e.printStackTrace();  
          }  
      }  
  }  
  
  
}
