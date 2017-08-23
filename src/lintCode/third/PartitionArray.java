package lintCode.third;

public class PartitionArray {
	
	public static void partitionArray(int[] nums) {
		if(nums.length == 0) return ;
		int i = 0 ;
		int j = 0 ;
		while(i < nums.length && nums[i]%2 == 1){
			i++;
		}
		j = i;
		while(j < nums.length){
			if(nums[j] % 2 == 1) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				i++;
			}
			j++;
		}
		for(int k = 0 ; k < nums.length ;k++){
			System.out.print(nums[k]+" ");
		}
		
	}
	
	public static void main(String[] args) {
		int [] a = {1,5,7,2,6,4,3};
		partitionArray(a);
	}

}
