package newcoder;


public class Solution0015 {
	//旋转数组
	public int minNumberInRotateArray(int [] array) {
    	int flag = 0;
    	int temp = array[0];
    	for(int i = 1 ; i < array.length ; i++){
    		if(temp > array[i]){
    			flag = i;
    			break;
    		}
    		temp = array[i];
    	}
    	
		return array[flag] ;
    }
	//斐波那契数列
	 public int Fibonacci(int n) {
		 int result = 0;
		 int big  = 1;
		 int small = 0;
		 if( n == 0)  return 0;
		 if( n == 1)  return 1;
		 for(int i = 1 ; i <=  n-1 ; i++){
			 result = big + small;
			 small = big;
			 big = result;
		 }
		 return result;
	 }
	 //跳台阶
	 public int JumpFloor(int target) {
		int prepre = 1 ;
		int pre = 1;
		int result = 1;
		if(target == 0 ) return 0;
		if(target == 1) return 1;
		if(target == 2) return 2;
		
		for(int i = 3 ; i <= target ; i++){
			
			result = prepre + pre;
			prepre = pre;
			pre =result;
		}
		 return result;
	 }
}
