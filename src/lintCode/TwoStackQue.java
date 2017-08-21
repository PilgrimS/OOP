package lintCode;

import java.util.Stack;

public class TwoStackQue {
	private Stack<Integer> st1;
    private Stack<Integer> st2;
    
    boolean flag = false;

    public TwoStackQue() {
    	st1 = new Stack<>();
    	st2 = new Stack<>();
    }
    
    public void push(int element) {
    	if(flag == false){
    		if(st1.isEmpty() && st2.isEmpty()){
    			st1.push(element);
    		}else if(!st1.isEmpty()){
    			st1.push(element);
    		}else if(!st2.isEmpty()){
    			st2.push(element);
    		}
    	}else{
    		flag = false;
    		if(st1.isEmpty() && st2.empty()){
    			st1.push(element);
    		}else if(!st1.isEmpty()){
    			while(!st1.isEmpty()){
    				st2.push(st1.pop());
    			}
    			st2.push(element);
    		}else if(!st2.isEmpty()){
    			while(!st2.isEmpty()){
    				st1.push(st2.pop());
    			}
    			st1.push(element);
    		}
    	}
    }

    public int pop() {
		if(flag == true){
			if(st1.isEmpty() && st2.isEmpty()){
			}else if(!st1.isEmpty()){
				return st1.pop();
			}else if(!st2.isEmpty()){
				return st2.pop();
			}
		}else{
			flag = true;
			if(!st1.isEmpty()){
				while(!st1.isEmpty()){
					st2.push(st1.pop());	
				}
				return st2.pop();
			}else if(!st2.isEmpty()){
				while(!st2.isEmpty()){
					st1.push(st2.pop());
				}
				return st1.pop();
			}
		}
    	return 0;
    }

    public int top() {
    	if(flag == true){
			if(st1.isEmpty() && st2.isEmpty()){
			}else if(!st1.isEmpty()){
				return st1.peek();
			}else if(!st2.isEmpty()){
				return st2.peek();
			}
		}else{
			flag = true;
			if(!st1.isEmpty()){
				while(!st1.isEmpty()){
					st2.push(st1.pop());	
				}
				return st2.peek();
			}else if(!st2.isEmpty()){
				while(!st2.isEmpty()){
					st1.push(st2.pop());
				}
				return st1.peek();
			}
		}
    	return 0;
    }
    public static void main(String[] args) {
		TwoStackQue s = new TwoStackQue();
		s.push(1);
		s.pop();
		s.push(2);
		s.push(3);
		s.top();
		s.pop();
	}
}
