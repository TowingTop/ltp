package top.towing.ltp.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class LTPTestbed {

	public static void main(String[] args) throws IOException {
		String apiKey = "A49861G0mE8OebxqhD4Hby9bTcygSEMayqmI5v8K";
		String pattern = "srl";
		String format = "plain";
		String fileName = System.getProperty("user.dir") + "/resource/sample.txt";
		
		BufferedReader br = null;
		try {
			String textToParse;
			br = new BufferedReader(new FileReader(fileName));
			
			while ((textToParse = br.readLine()) != null) {
				textToParse = URLEncoder.encode(textToParse, "utf-8");
				String apiUrl = "http://ltpapi.voicecloud.cn/analysis/";
				URL url = new URL(apiUrl + "?"
						+ "api_key=" + apiKey + "&"
						+ "text=" + textToParse + "&"
						+ "format=" + format + "&"
						+ "pattern=" + pattern);
				URLConnection conn = url.openConnection();
		        conn.connect();
		        
		        BufferedReader innet = new BufferedReader(new InputStreamReader(
		                conn.getInputStream(),
		                "utf-8"));
		        String line;
		        while ((line = innet.readLine())!= null) {
		        	System.out.println(line);
		        }
		        innet.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}    
	}

}
