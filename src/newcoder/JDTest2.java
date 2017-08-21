package newcoder;

import java.util.Scanner;

public class JDTest2 {
	public static void splitStone(){
		Scanner sc = new Scanner(System.in);
		int m  =  sc.nextInt();
		int n = sc.nextInt();
		int temp = n;
		int count = 0 ;
		do{
			m = m - n - count%2*1;
			temp = n+count%2*1;
			count ++;
		}while(m > n);
		if(m != temp && m >= n) count++;
		System.out.println(count);
	}
	public static void main(String[] args) {
		splitStone();
	}
}
