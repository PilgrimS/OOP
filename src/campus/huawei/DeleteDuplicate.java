package campus.huawei;

import java.util.Scanner;

public class DeleteDuplicate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int [] arr = new int[n];
			int k =0;
			while(k < n){
				arr[k] = sc.nextInt();
				k++;
			}
			sort(arr);
			int temp = arr[0];
			System.out.println();
			System.out.println(temp);
			for(int i = 0 ; i < arr.length ; i++){
				if(temp != arr[i]){
					System.out.println(arr[i]);
					temp = arr[i];
				}
				
			}
		}
		
	}
	public static void sort(int [] arr){
		quickSort(arr,0,arr.length-1);
	}
	public static int[] quickSort(int [] arr, int low, int high ){
		int begin = low;
		int end = high;
		if(low >= high) return arr;
		int temp = arr[low];
		while(low < high){
			while(temp <= arr[high] && low < high){
				high --;
			}
			if(temp > arr[high]) {
				arr[low] = arr[high];
				arr[high] = temp;
				low++;
			}
			while(temp >= arr[low] && low <high){
				low++;
			}
			if(temp < arr[low]){
				arr[high] = arr[low];
				arr[low] = temp;
				high--;
			}
		}
		quickSort(arr,begin, low-1);
		quickSort(arr, high+1, end);
		return arr;
	}
}







