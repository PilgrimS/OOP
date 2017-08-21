package newcoder;

import java.util.Scanner;

public class Solution0023 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		int index = 0;
		int min;
		int premin = 0;
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++){
			arr[i] = sc.nextInt();
		}
		if(n < 3) System.out.println(-1);
		else{
		min =arr[0];
		premin = 0;
		for(int j = 0 ; j<3;j++){
			for(int i = j ; i < n ; i++){
				if( arr[i] <= min && arr[i] > premin) {
					min = arr[i];
					index = i;
					count++;
					break;
				}
			}
			int temp = arr[j];
			arr[j] = arr[index];
			arr[index] =temp;
			premin = arr[j];
			for(int i = j+1; i < n ; i++){
				if(arr[i] > premin){
					min = arr[i];
					break;
				}
			}
			for(int i = j+1; i< n ; i++){
				if(arr[i] > premin && arr[i] <min)min =arr[i];
			}
		}
		System.out.println((count == 3)? arr[2]:-1);
		
		}
		
	}
}
