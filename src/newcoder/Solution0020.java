package newcoder;

import java.util.Scanner;

/*
 * 组装三角形
 */
public class Solution0020 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] a = new int[n];
		int count = 0;
		for(int i = 0 ; i < n ; i++){
			a[i] = sc.nextInt();
		}
		for(int i = 0 ; i < n - 2; i ++){
			for(int j = i + 1 ; j < n-1 ;j++ ){
				for(int k = j + 1; k < n ; k++){
					if(a[i] + a[j] > a[k] 
							&& a[j] + a[k] > a[i] && a[i] + a[k] > a[j])
						count ++;
				}
			}
		}
		System.out.println(count);
	}

}
