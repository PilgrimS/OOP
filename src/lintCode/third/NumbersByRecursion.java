package lintCode.third;

import java.util.ArrayList;
import java.util.List;

public class NumbersByRecursion {
	List<Integer> list = new ArrayList<Integer>();
	public List<Integer> numbersByRecursion(int n) {
		List<Integer> result = new ArrayList<>();
		if(n <= 0){
			return new ArrayList<Integer>();
		}else if(n == 1){
			for(int i = 1;i<=9;i++){
				result.add(i);
			}
			return result;
		}else{
			List<Integer> list = numbersByRecursion(n-1);
			result = new ArrayList<>(list);
			for(int i = 1 ; i<=9; i++){
				int topdigit = (int)Math.pow(10, n-1) * i;
				result.add(topdigit);
				for(int j = 0; j<list.size() ;j++){
					result.add(list.get(j)+topdigit);
				}
			}
			return result;
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
