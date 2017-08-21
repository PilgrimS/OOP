package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class InputStreamTest {

	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir");
		
		System.out.println(path);
		
		File file = new File("E:\\Java\\workspace\\oop\\src\\test.properties");
		File file1 = new File(path+"\\src\\test.properties");
		File file2 = new File("test.properties");
		File file3 = new File(path+"\\output.properties");
		
		
		try {
			InputStream is = new FileInputStream(file2);
			/*InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bd = new BufferedReader(isr);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = bd.readLine()) != null ){
				sb.append(line);
			}
			System.out.println(sb.toString());
			bd.close();
			isr.close();
			*/
			OutputStream os = new FileOutputStream(file3);
			byte [] data = new byte[1024];
			int length = -1; 
			while((length = is.read(data) )!= -1){
				os.write(data, 0, length);
			}
			//bd.close();
			//isr.close();
			os.close();
			is.close();
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
