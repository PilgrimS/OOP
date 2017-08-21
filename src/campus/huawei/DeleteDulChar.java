package campus.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteDulChar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[] ch = sc.next().toCharArray();
			List<Character> list =new ArrayList<>();
			for(int i = 0 ; i < ch.length ; i++){
				if(list.isEmpty()){
					list.add(ch[i]);
				}else{
					if(!list.contains(ch[i])) list.add(ch[i]);
				}
			}
			String str = "";
			for(int i = 0 ; i < list.size() ; i++){
				str += list.get(i);
			}
			System.out.println(str);
		}
		
		
	}

}
