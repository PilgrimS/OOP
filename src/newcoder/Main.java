package newcoder;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static boolean resolve(int[] A) {
        int len = A.length;
        int temp = 0;
        for(int i = 0 ; i < len ; i++){
        	temp += A[i];
        }
        for(int i = 1 ; i < len -3;i++){
        	for(int j = i+1;j < len -2;j ++){
        		for(int k = j+1; k<len-1; k ++){
        			temp = temp -A[i] -A[j] -A[k];
        		}
        	}
        }
        int mod = temp%4;
        if(mod == 0){
        	return true;
        }else{
        	return false;
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while(line != null && !line.isEmpty()) {
            int value = Integer.parseInt(line.trim());
            if(value == 0) break;
            inputs.add(value);
            line = in.nextLine();
        }
        int[] A = new int[inputs.size()];
        for(int i=0; i<inputs.size(); i++) {
            A[i] = inputs.get(i).intValue();
        }
        Boolean res = resolve(A);

        System.out.println(String.valueOf(res));
    }
}
