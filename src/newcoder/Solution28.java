package newcoder;

import java.util.Scanner;

public class Solution28 {
	public static boolean isOdd(String s){
		return s.substring(s.length()/2).equals(s.substring(0, s.length()/2));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.next();
			s = s.substring(0,s.length()-2 > 0 ? s.length()-2 : 0);
			while(!isOdd(s)){
				s = s.substring(0,s.length()-2 > 0 ? s.length()-2 : 0);
			}
			if(s.length() > 0 ) System.out.println(s.length());
			else System.out.println(0);
		}
	}

}
