package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtils {
	public static void sendRequest(String url){
		try {
			String resultStr = "";
			URL sendurl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) sendurl.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(6 * 1000);
			conn.setReadTimeout(6 * 1000);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:31.0) Gecko/20100101 Firefox/31.0"); 
            conn.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01"); 
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
            conn.setRequestProperty("Content-Language","zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3" );
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.flush();
            out.close();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            
            String currentLine = "";
            while ((currentLine = reader.readLine()) != null) {
                 resultStr += currentLine;
            }
            reader.close();
            
            System.out.println(resultStr);
			
		} catch (MalformedURLException e) {
			System.out.println("URL格式错误！！");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args){
		String url = "https://www.baidu.com";
		sendRequest(url);
	}
}
