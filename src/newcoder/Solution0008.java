package newcoder;

import java.util.Arrays;
import java.util.Scanner;

public class Solution0008 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] sArray = s.toCharArray();
		/*for(int i = 0; i < s.length() ; i++ ){
			System.out.println(sArray[i]+ "   ");
		}*/
		int count = 0;
		int B = 0;
		int bCount = 0;
		int G = 0;
		int gCount = 0;
		for(int i = 0 ; i< s.length() ;i++){
			if(sArray[i] =='B'){
				bCount ++;
				B += i;
			}else if(sArray[i] == 'G'){
				gCount ++;
				G += i;
			}
		}
		if(B > G) {
			count = G - gCount;
		}else if(B < G){
			count = B - bCount;
		}else{
			count = G - gCount;
		}
		System.out.println(count);
		
	}

}
