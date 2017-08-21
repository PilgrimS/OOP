package newcoder;

import java.util.ArrayList;
import java.util.Scanner;

class Trian{
	String c ;
	int x ;
	int y ;
	int z ;
	public Trian(String s,int x,int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.c = s;
	}
}

public class Solution0024 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Trian> list = new ArrayList<Trian>();
		for(int i =0 ; i<n ;i++){
			String s = sc.next();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			list.add(new Trian(s,x,y,z));
		}
		int max1 = 0;
		for(Trian t : list){
			
		}
		int max2 = 0;
		
		
	}
	
	public static float square(Trian a,Trian b,Trian c){
		boolean flag = isTrian(a,b,c);
		if(flag){
			double l1 = Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2)+Math.pow(a.z-b.z, 2));
			double l2 = Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2)+Math.pow(a.z-b.z, 2));
			double l3 = Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2)+Math.pow(a.z-b.z, 2));
			
		}
		return 0;
	}

	private static boolean isTrian(Trian a, Trian b, Trian c) {
		if(a.x == b.x && a.y == b.y && a.z == b.z) return false;
		if(a.x == c.x && a.y == c.y && a.z == c.z) return false;
		if(c.x == b.x && c.y == b.y && c.z == b.z) return false;
		if(a.x == b.x && b.x == c.x && a.y == b.y && b.y == c.y) return false;
		if(a.x == b.x && b.x == c.x && a.z == b.z && b.z == c.z) return false;
		if(a.z == b.z && b.z == c.z && a.y == b.y && b.y == c.y) return false;
		return true;
	}
}
