package newcoder;

import java.util.Scanner;

public class Solution0019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long start = sc.nextLong();
		long end = sc.nextLong();
		long divider = sc.nextLong();
		
		long flag = start;
		long count = 0;
		for(long i = start ; i <=end ; i++){
			if(i%divider == 0) {flag = i; break;}
		}
		count = (end - flag)/divider + 1;
		
		System.out.println(count);
	}

}
