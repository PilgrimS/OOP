package newcoder;

/*
 * 波兰式   
 */

public class Solution0002 {
	public static int evalRPN(String[] tokens) {
		int length = tokens.length;
		String[] temp = new String[length];
		int j = 0;
        for(int i = 0 ; i < tokens.length ;i ++){
        	if(tokens[i].equals("/") || tokens[i].equals("*") || tokens[i].equals("+") || tokens[i].equals("-")){
        		if(temp.length>=2){
        			int a = Integer.parseInt(temp[j-1]);
        			int b = Integer.parseInt(temp[j-2]);
        			int tmp = 0;
        			switch(tokens[i]){
        				case "/":
        					tmp = b/a;
        					break;
        				case "*":
        					tmp = b * a;
        					break;
        				case "-":
        					tmp = b - a;
        					break;
        				case "+":
        					tmp = b + a ;
        					break;
        				default : break;
        			}
        			temp[j-2] = Integer.toString(tmp);
        			j --;
        		} 
        	}else{
        		temp[j] = tokens[i];
        		j += 1;
        	}
        }
		return Integer.parseInt(temp[0]);
    }
	public static void main(String[] args) {
		String [] a = {"18"};
		evalRPN(a);
	}

}
