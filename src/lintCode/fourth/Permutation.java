package lintCode.fourth;

import java.util.HashMap;
import java.util.Map;

public class Permutation {
	public static boolean permutation(String A, String B) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < A.length() ;i++){
			if(map.containsKey(A.charAt(i))){
				map.put(A.charAt(i),map.get(A.charAt(i))+1);
			}else{
				map.put(A.charAt(i),1);
			}
		}
		for(int i =0;i<B.length();i++){
			if(map.containsKey(B.charAt(i))){
				map.put(A.charAt(i),map.get(B.charAt(i))-1);
			}else{
				return false;
			}
		}
		for(int i : map.values()){
			if(i != 0) return false;
		}
		return true;
    }
	public String sortStr(String s){
		
		return s;
	}
	public static void main(String[] args) {
		permutation("abcd", "bcad");
	}
}
