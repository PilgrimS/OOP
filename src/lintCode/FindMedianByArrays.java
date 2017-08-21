package lintCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindMedianByArrays {
	public static double findMedianSortedArrays(int[] A, int[] B) {
		List<Integer> list = new ArrayList<>();
		int m = A.length;
		int n = B.length;
		int j =0,i =  0;
		while(j < m && i < n){
			if(A[j] < B[i] ){
				list.add(A[j]);
				j += 1;
			}else{
				list.add(B[i]);
				i += 1;
			}
		}
		if(j == m) {
			for(;i<n;i++){
				list.add(B[i]);
			}
		}else{
			for(;j<m;j++){
				list.add(A[j]);
			}
		}
		int size = list.size();
		if(size%2 == 1){
			return list.get(size/2);
		}else{
			return (double) (list.get(size/2-1) + list.get(size/2))/2;
		}
		
    }
	public static void main(String[] args) {
		int a[] = {3,5,9,10};
		int b[] = {0,2,3,3,4};
		System.out.println(findMedianSortedArrays(a, b));
	}
}
