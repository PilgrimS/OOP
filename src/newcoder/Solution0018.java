package newcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 最长公共子串
 */
public class Solution0018 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println(lcs(s1,s2));
		System.out.println(lcsMy(s1,s2));
		
	}
	
	public static String lcsMy(String s1 , String s2){
		long start = System.nanoTime();
		
		int max = 0 ;
		int index = 0;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		while(index + max <= c2.length){
			@SuppressWarnings("unchecked")
			ArrayList<Integer> list = findIndex(c1, c2[index]); 
			if(!list.isEmpty()){
				for(Integer i : list){
					int temp2 = index;
					int temp1 = i.intValue();
					int count = 0;
					while(temp1 < c1.length && c2[temp2] == c1[temp1]){
						count++;
						temp2++;
						temp1++;
					}
					if(count > max){
						max = count;
					}
				}
			}
			index++;
		}
		long end = System.nanoTime();
		
		return end-start +": " + max;
	}
	
	public static ArrayList findIndex(char[] cA , char c ){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i < cA.length ; i++){
			if(cA[i] == c) list.add(i);
		}
		
		return list;
	}
	public static int lcs(String s1 , String s2){
		//long start = System.nanoTime();
		int len1 = s1.length();
		int len2 = s2.length();
		int result = 0;
		int [][] c = new int[len1+1][len2+1];
		for(int i = 0 ; i <= len1 ; i++){
			for(int j = 0 ; j <= len2 ; j++){
				if( i == 0 || j == 0){
					c[i][j] = 0;
				}else if(s1.charAt(i-1) == s2.charAt(j-1)){
					c[i][j] = c[i-1][j-1] + 1;
					result = (c[i][j] > result) ? c[i][j] : result;
				}else{
					c[i][j] = 0;
				}
			}
		}
		//long end = System.nanoTime();
		return  result;
	}
}
