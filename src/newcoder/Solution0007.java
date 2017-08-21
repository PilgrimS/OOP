package newcoder;

import java.util.Scanner;

public class Solution0007 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		int[] xtxS = new int[n];
		int[] ytxS = new int[n];
		for(int i = 0; i< n ; i++){
			xtxS[i] = sc.nextInt();
		}
		for(int i = 0 ; i< n ; i++){
			ytxS[i] = sc.nextInt();
		}
		int gx = sc.nextInt();
		int gy = sc.nextInt();
		
		int walktime = sc.nextInt();
		int taxtime = sc.nextInt();
		
		int time = 0;
		int[] temp = new int[n];
		int min = (gx +gy)*walktime;
		
		for(int i = 0 ; i< n ;i++){
			time = (xtxS[i] + ytxS[i])*walktime + (Math.abs(xtxS[i]-gx) + Math.abs(ytxS[i]-gy))* taxtime; 
			if( min > time ) {
				 min = time;
			 }
		}
		System.out.println(min);
		
	}

}
