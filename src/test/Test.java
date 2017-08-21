package test;

import java.util.Scanner;

public class Test {
	public static int f(int x){
		int sum =0 ;
		while(x/10!=0 || x%10!=0){
			sum = sum + x%10;
			x = x/10;
		}
		//System.out.println("10:" + sum);
		return sum;
		
	}
	public static int g(int x){
		String s = Integer.toBinaryString(x);
		x = Integer.parseInt(s);
		//System.out.println("2 :" + x);
		int sum =0 ;
		while(x/10!=0 || x%10!=0){
			sum = sum + x%10;
			x = x/10;
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int x = Integer.parseInt(s);
		int i = 0;
		int count = 0;
		while(i<=x){
			if (g(i) == f(i)){
				//System.out.println("---------"+i+"-----------");
				count ++;
			}
			i++;
		}
		System.out.println(count);
	}
}
