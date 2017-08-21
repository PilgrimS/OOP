package lintCode;

public class CountOnes {
	 public static int countOnes(int num) {
	       int count =0;
	       String s = Integer.toBinaryString(num);
	       for(int i = 0 ; i < s.length() ; i++){
	    	   if(s.charAt(i) == '1') count++;
	       }
	        return count;
	    }
	 public static void main(String[] args) {
		System.out.println(countOnes(-1));
	}
}
