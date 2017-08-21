package lintCode;

public class FindMin {
	 public int findMin(int[] nums) {
		 int len = nums.length;
		 int a = nums[0];
		 int b = nums[len-1];
		 if(a < b ){
			 return a;
		 }else{
			 int begin = 0 ; 
			 int end = len;
			 while(a > b){
				 a = nums[(begin+end)/2] ;
				 if(a > b) begin = (begin+end)/2;
				 else end = (begin+end)/2;
			 }
			 for(int i = end ; i >= begin ; i--){
				 if(nums[i] < nums[i-1])  return nums[i];
			 }
		 }
		 return 0;
	 }
}
