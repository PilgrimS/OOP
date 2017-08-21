package newcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Solution0027 {
	/*
	 * leetCode twoSum BruteForce
	 */
	public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i = 0 ; i < numbers.length-1; i++){
        	for(int j = i+1 ; j < numbers.length;j++){
        		if(numbers[i] + numbers[j] == target) {
        			res[0] = i;
        			res[1] = j;
        			return res;
        		}
        	}
        }
        
        return res;
    }
	/*
	 * leetCode twoSum by Hash
	 */
	public static int[] twoSumHash(int [] nums ,int target){
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		int[] res = new int[2];
		for(int i = 0 ; i < nums.length ; i++){
			int compliment = target - nums[i];
			if(map.containsKey(compliment)) {res[0] = map.get(compliment);res[1] = i; return res;}
			map.put(nums[i],i);
		}
		return res;
	}
	/*
	 * leetCode threeSum BruteForce
	 */
	public static List<List<Integer>>  threeSum(int []nums){
		List<List<Integer>> list = new ArrayList<>();
		int count = 0;
		
		for(int i = 0 ; i < nums.length-2;i++){
			for(int j = i + 1; j< nums.length-1; j++){
				for(int k = j + 1; k < nums.length ; k++){
					if(nums[i] + nums[j] + nums[k] == 0){
						int [] a = new int[3];
						a = threeSort(nums[i],nums[j],nums[k]);
						List<Integer> temp = new ArrayList<>();
						boolean flag =false;
						if(list.isEmpty()) {
							temp.clear();
							temp.add(a[0]);
							temp.add(a[1]);
							temp.add(a[2]);
							list.add(temp);
						}else{
							for(List list1 : list){
								if(list1.get(0).equals(a[0]) && list1.get(1).equals(a[1]) && list1.get(2).equals(a[2])){
									flag = true;
								}
								if(flag == true) break;
							}
							if(flag == false){
								temp.clear();
								temp.add(a[0]);
								temp.add(a[1]);
								temp.add(a[2]);
								list.add(temp);
								flag = false;
							}
							
						}
					}
				}
			}
		}
		return list;
	}
	private static int[] threeSort(int a, int b, int c) {
		int [] arr = {a,b,c};
		int min = arr[0];
		int count = 0;
		for(int i = 0; i < arr.length; i++ ){
			for(int j = i ; j<arr.length ; j++){
				if(min > arr[j]) {min = arr[j];count = j;}
			}
 			arr[count] = arr[i]; 
			arr[i] = min;
			count = i+1;
			if(i< arr.length-1) min = arr[i+1];
			
		}
		return arr;
	}
	public static int[] sort(int[] numbers) throws Exception{
		
		return quickSort(numbers,0,numbers.length-1);
	}
	private static int[] quickSort(int[] numbers, int begin, int end) throws Exception {
		if(begin > end) return numbers;
		if(begin == end) return numbers;
		int temp = numbers[begin];
		int i = begin;
		int j = end;
		while(i < j){
			while(j > i && temp <= numbers[j]){
				j--;
			}
			
			if(temp > numbers[j]) {
				numbers[i] = numbers[j];
				//i++;
			}
			while(j > i && temp >= numbers[i]){
				i++;
			}
			if(temp < numbers[i]){
				numbers[j] = numbers[i];
				//j--;
			}
			
		}
		
		if(i == j ) {
			numbers[i] = temp;
			quickSort(numbers, begin, i-1);
			quickSort(numbers, i+1, end);
		}
		return numbers;
	}
	public static void main(String[] args) {
		/*int[] a = {2,4,7,3,6,8,5,0};
		int [] res = twoSum(a,15);
		for(int i : res) System.out.print(i + "  " );*/
		
		
		
		/*Random rand = new Random();
		int n = rand.nextInt(30);
		int [] a1 = new int[n];
		for(int i = 0; i < n ; i ++){
			a1[i] = rand.nextInt(100);
		}
		try {
			sort(a1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i : a1) System.out.print(i + "  " );*/
		
		
		int [] nums = {-1,0,1,2,-1,-4};
		
		threeSum(nums);
	}
}
