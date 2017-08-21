package newcoder;

import java.util.Scanner;

public class Solution0005 {
	private static final int GREATER = 1;
	private static final int LESS = -1;
	private static final int EQUAL = 0;
	
	private static int pivot = 0;
	private static int count = 0;
	
	public static int isPlalindrome(int [] array){
		int len = array.length;
		int flag = 0;
		for(int i = 0 ; i < len ;i++){
			if(array[i] > array[len-i-1] ){
				pivot = len-i-1;
				flag = GREATER;
				break;
			}else if(array[i] < array[len-i-1]){
				pivot = i;
				flag = LESS;
				break;
			}else{
				flag = 0;
			}
		}
		return flag;
	}
	
	
	public static int[] modify(int[] array ,int flag){
		int[] temp =new int[array.length-1]; 
		if(flag == GREATER){
			for(int i = 0 ; i < pivot-1; i++){
				temp[i] = array[i];
			}
			temp[pivot-1] = array[pivot-1] + array[pivot];
			for(int i = pivot; i < array.length-1 ;i++){
				temp[i] = array[i+1];
			}
		}else{
			for(int i = 0 ; i< pivot;i++){
				temp[i] = array[i];
			}
			temp[pivot] = array[pivot] + array[ pivot+1];
			for(int i = pivot +1 ; i <array.length-1;i++){
				temp[i] = array[i+1];
			}
		}
		return temp;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input N:");
		int n = sc.nextInt();
		System.out.println("Please input Array:");
		int[] array = new int[n];
		for(int i = 0 ; i < n ; i++){
			array[i] = sc.nextInt();
		}
		int flag = isPlalindrome(array);
		while(flag != 0){
			count++;
			array = modify(array, flag);
			flag = isPlalindrome(array);
		}
		System.out.println(count++);
		for(int i = 0 ; i < array.length ; i ++){
			System.out.print(array[i] + "  ");
		}
	}
}
