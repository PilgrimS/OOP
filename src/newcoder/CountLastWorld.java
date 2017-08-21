package newcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountLastWorld {
	
	
	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	
	//String str = s.nextLine();
	//int index = str.lastIndexOf(" ");
	//int len = str.length()-index-1;
	//System.out.println(len);
		
	String  str = s.nextLine();
	char[] cArray = str.toCharArray();
	String flag = s.nextLine();
	int count =0;
	for(int i = 0 ; i < cArray.length ; i++){
		if(String.valueOf(cArray[i]).equals(flag)) count++;
	}
	System.out.println(count);
	}

}
