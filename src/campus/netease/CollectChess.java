package campus.netease;

import java.util.Scanner;

public class CollectChess {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x[] = new int[n];
		int y[] = new int[n];
		int xMax = 0;
		int yMax = 0;
		for(int i = 0 ; i<n ;i++){
			x[i] = sc.nextInt();
			if(x[i] > xMax) xMax = x[i];
		}
		for(int i = 0 ; i<n ;i++){
			y[i] = sc.nextInt();
			if(y[i] > yMax) yMax = y[i];
		}
		for(int i = 1 ; i<=n ;i++){
			int step = 0;
			for(int j = 0; j < n ; j++){
				
			}
			System.out.println(step);
		}
		
		
 	}
}
