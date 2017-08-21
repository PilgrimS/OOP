package newcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution29 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.next();
			int evenCount = 0;
			Map<Character,Integer> map = new HashMap<>();
			for(int i = 0 ; i<s.length();i++){
				char c = s.charAt(i);
				if(map.containsKey(c)){
					map.put(c, map.get(c)+1);
				}else{
					map.put(c, 1);
				}
			}
			for(int i:map.values()){
				if(i%2 == 1) evenCount ++;
			}
			if(evenCount <= 1) System.out.println(1);
			else{
				System.out.println(evenCount);
			}
			
		}
	}

}
