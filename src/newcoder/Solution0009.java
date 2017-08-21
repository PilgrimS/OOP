package newcoder;

import java.util.Scanner;

public class Solution0009 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] array = new int[n];
		for(int i = 0 ; i < n ; i++){
			array[i] = sc.nextInt();
		}
		int[] temp = new int [n];
		
		for(int i = 0 ; i < k ; i++){
			for(int j = 0 ; j < n ; j++){
				temp[j] = array[(j+1)%n];
			}
			for(int j = 0 ; j < n ; j++){
				array[j] =  (temp[j] + array[j])%100;
			}
		}
		for(int i = 0 ; i < n ; i++){
			System.out.print(array[i] + " ");
		}
	}

}
