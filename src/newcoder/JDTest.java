package newcoder;

import java.util.Scanner;

public class JDTest {
	public static void findTheif(){
		Scanner sc = new Scanner(System.in);
		int count = 0 ;
		int n = sc.nextInt();
		String s = sc.next();
		char[] ch = s.toCharArray();
		boolean [] flag = new boolean[n];
		for(int i = 0 ; i < n ; i++){
			flag[i] = false;
		}
		for(int i = 0 ; i < n ; i++){
			
			if(ch[i]<='9' && ch[i] >= '1'){
				int a = Integer.parseInt(String.valueOf(ch[i]));
				System.out.println(a);
				for(int j = i ; j <= i+a && j < n ; j++){
					if(ch[j] == 'X' || ch[j] == 'x'){
						flag[j] = true;
					}
				}
				for(int j = i ; j >= i-a && j>=0; j--){
					if(ch[j] == 'X' || ch[j] == 'x'){
						flag[j] = true;
					}
				}
			}
		}
		
		for(int i = 0 ; i < n ; i++){
			if(flag[i] == true){
				count ++;
			}
		}
		
		
		System.out.println(count);
		
		
		
		
	}
	public static void main(String[] args) {
		findTheif();
	}
}
