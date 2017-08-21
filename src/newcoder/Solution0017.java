package newcoder;

import java.util.Scanner;

public class Solution0017 {
	static int run(String numbers){
		int[] res = new int[numbers.length()];
		for(int i = 0 ; i < numbers.length();i++){
			res[i] = numbers.indexOf(i);
		}
		int[] des = {1,2,3,4,5,6,7,8,0};
		int[] dis = new int[9];
		
		
		
		
		return 0;
			
	 }
	public static void main(String[] args) {
		  Scanner scan = new Scanner(System.in);
	      
	        String numbers = new String();
	        for(int rows=3; rows>0; rows--){
	            for(String n: scan.nextLine().split(" ")){
	                numbers += n;
	            }
	        }
	        int res = run(numbers);
	        
	        System.out.println(String.valueOf(res));
	}

}
