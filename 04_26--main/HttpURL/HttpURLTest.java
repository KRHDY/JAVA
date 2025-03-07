package HttpURL;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class HttpURLTest {

	public static void main(String[] args)  throws Exception {
		 URL url  = new URL("https://www.google.com/search?q=java");
		 HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
		 con.setRequestMethod("GET");
		 con.setRequestProperty("User-Agent", "Mozilla/5.0");
	
		 int responseCode = con.getResponseCode();
		 
		 System.out.println("Reasponse code : "+ responseCode);
	
		 InputStream stream = con.getInputStream();
			
			InputStreamReader isReader = new InputStreamReader(stream, "utf-8");
			
			BufferedReader reader = new BufferedReader(isReader);
			String line ;
			
			while ((line = reader.readLine())!=null){
				System.out.println(line);}
	}
}