package lintCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int [] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ; i<numbers.length ;i++){
			if(!map.containsKey(numbers[i]) && !map.containsKey(target-numbers[i])){
				map.put(numbers[i], i);
			}else if(map.containsKey(target-numbers[i])){
				result[0] = map.get(target-numbers[i]);
				result[1] = i;
				break;
			}
		}
		
		return result;
    }
}
