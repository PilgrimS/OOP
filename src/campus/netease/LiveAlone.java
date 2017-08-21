package campus.netease;

import java.util.Scanner;

public class LiveAlone {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int x = sc.nextInt();
			int f = sc.nextInt();
			int d = sc.nextInt();
			int p = sc.nextInt();
			
			if(d/x <= f) System.out.println(d/x);
			else {
				int sum = d - x*f ;
				System.out.println(f+sum/(x+p));
			}
		}
		
	}
}
