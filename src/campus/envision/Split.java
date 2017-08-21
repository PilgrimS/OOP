package campus.envision;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Split {
	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			int n = sc.nextInt();
			 if (n > 0 && n < str.getBytes("GBK").length) {
			StringBuffer sb = new StringBuffer();
			char c = str.charAt(0);
			for(int i = 0 ; i < n;i++){
				c = str.charAt(i); 
				 if(i!=n-1){
	            	 sb.append(c);
	            	 if (String.valueOf(c).getBytes("GBK").length > 1) {   
	                     --n;   
	                 } 
	            }    
			}
			System.out.println(sb.toString());
			 }
		}
		
		
		
		
		
	}
}
