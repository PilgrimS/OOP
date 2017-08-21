package test;


import java.util.Random;

public class MaxSubSeq {
	//n^3
	public static int maxSubSum1(int[] a){
		long start = System.currentTimeMillis();
		int maxSum = 0 ;
		for(int i = 0; i < a.length ; i++){
			for(int j = i; j < a.length; j++){
				int thisSum = 0 ;
				for( int k = i; k <= j; k++)
					thisSum += a[k];
				if(thisSum > maxSum)
					maxSum = thisSum;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("N^3 运行时间为"+(end-start));
		return maxSum;
	}
	//n^2
	public static int maxSubSum2(int[] a){
		long start = System.currentTimeMillis();
		int maxSum = 0 ;
		for(int i = 0; i < a.length; i++){
			int thisSum = 0;
			for(int j = i; j < a.length; j++){
				thisSum += a[j];
				if(thisSum > maxSum)
					maxSum = thisSum;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("N^2 运行时间为"+(end-start));
		return maxSum;
	}
	//nlogn
	public static int maxSubSum3(int[] a){
		long start = System.currentTimeMillis();
		int b = maxSumRec(a,0,a.length-1);
		long end = System.currentTimeMillis();
		System.out.println("NlogN 运行时间为"+(end-start));
		return b;
	}
	private static int maxSumRec(int[] a, int left, int right) {
		if(left == right)
			if(a[left] > 0)
				return a[left];
			else
				return 0 ;
		
		int center = (left+right)/2;
		int maxLeftSum = maxSumRec(a,left,center);
		int maxRightSum = maxSumRec(a,center+1,right);
		
		int maxLeftBorderSum = 0;
		int leftBorderSum = 0;
		for( int i = center; i >= left ; i--){
			leftBorderSum += a[i];
			if(leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}
		
		int maxRightBorderSum = 0;
		int rightBorderSum = 0;
		for(int i =center+1; i<=right ; i++){
			rightBorderSum += a[i];
			if(rightBorderSum > maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}
		return max(maxLeftSum,maxRightSum,maxLeftBorderSum + maxRightBorderSum);
	}
	
	private static int max(int i, int j, int k) {
		int max = i;
		if(max < j )
			max = j;
		if(max < k)
			max = k;
		return max;
	}
	//n
	public static int maxSubSum4(int[] a){
		long start = System.currentTimeMillis();
		int maxSum =0,thisSum = 0;
		for(int i = 0 ; i < a.length ;i++){
			thisSum += a[i];
			if(maxSum <thisSum)
				maxSum = thisSum;
			else if(thisSum < 0)
				thisSum = 0;	
		}
		long end = System.currentTimeMillis();
		System.out.println("N运行时间为"+(end-start));
		return maxSum;
	}
	
	public static void main(String[] args){
		
		Random rand = new Random(47);
		
		int index =Math.abs(rand.nextInt(1000));
		
		int[] b = new int[index];
		
		for(int i = 0 ; i <= index-1 ;i++){
			
			b[i] = (int) (rand.nextInt(10000) * Math.pow(-1, i));
			
		}
		
		System.out.println(maxSubSum4(b));
		
		System.out.println(maxSubSum3(b));
		
		System.out.println(maxSubSum2(b));
		
		System.out.println(maxSubSum1(b));
		
	}
}
