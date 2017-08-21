package newcoder;

import java.util.Stack;
/*
 * 两个栈实现队列
 */
public class Solution0014 {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    int flag = 0;
    public void push(int node) {
    	flag = 0;
        if(stack1.isEmpty() && stack2.isEmpty()){
        	stack1.push(node);
        }else if(!stack1.isEmpty() && stack2.isEmpty()){
        	stack1.push(node);
        }else if(stack1.isEmpty() && !stack2.isEmpty()){
        	stack2.push(node);
        }else{
        	System.out.println("队列出错");
        }
    }
    
    public int pop() {
		int temp = 0 ;
    	if(!stack1.isEmpty() && flag ==0){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			temp = stack2.pop();
			flag = 1;
		}else if(!stack1.isEmpty() && flag ==1){
			temp = stack1.pop();
		}else if(!stack2.isEmpty() && flag == 0){
			while(!stack2.isEmpty()){
				stack1.push(stack2.pop());
			}
			temp = stack1.pop();
			flag = 1;
		}else if(!stack2.isEmpty() && flag == 1){
			temp = stack2.pop();
		}
    	
    	return temp;
    }
}
