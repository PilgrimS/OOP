package newcoder;

import java.util.Scanner;

public class Solution31 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i = 0 ; i<n ;i++){
			arr[i] = sc.nextInt();
		}
		int [] maxA = {-1,-1,-1};
		int [] minA = {-1,-1,-1};
		
		for(int i = 0;i<3;i++){
			int max = minA[0] > 0? arr[minA[0]] : (arr[0] < 0? arr[0] : 0);
			int min = arr[0];
			for(int j = 0; j < n ; j++){
				if(j != maxA[0] && j != maxA[1] && j!= maxA[2]){
					if(arr[j] >= max ) {max = arr[j];maxA[i] = j;}
				}
				if(j != minA[0] && j != minA[1] && j != minA[2]){
					if(arr[j] <= min && arr[j] < 0) {min = arr[j];minA[i] =j;}
				}
				
			}
		}

		if(minA[0] < 0) {
			System.out.println(arr[maxA[0]]*arr[maxA[1]]*arr[maxA[2]]);
		}else if(minA[1] < 0){
			System.out.println(arr[maxA[0]]*arr[maxA[1]]*arr[maxA[2]]);
		}else {
			if(arr[maxA[0]]*arr[maxA[1]]*arr[maxA[2]] >= arr[maxA[0]]*arr[minA[0]]*arr[minA[1]]){
				System.out.println(arr[maxA[0]]*arr[maxA[1]]*arr[maxA[2]]);
			}else{
				System.out.println(arr[maxA[0]]*arr[minA[0]]*arr[minA[1]]);
			}
		}
		
	}

}
