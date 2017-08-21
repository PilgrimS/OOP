package newcoder;

public class Solution0011 {
	 public static  boolean Find(int target, int [][] array) {
		    int y = array.length; 
		    System.out.println(y);
	        if (y ==0) return false;
	        int x = array[0].length;
	        if(x == 0 ) return false;
			
			 for(int i = 0 ; i < y ; i++){
				 if(array[i][x-1] >= target ) {
					 for(int j = x-1 ; j >= 0 ; j--){
						 if(array[i][j] == target) return true;
					 }
				 }
			 }
			 return false;
		
	 }
	 public static void main(String[] args) {
		int [][]array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int [][] array1 = {{}};
		Find(7, array1);
	}
}
