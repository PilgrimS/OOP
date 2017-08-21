package newcoder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
public class Solution0013 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        /*Deque<ListNode> stack = new ArrayDeque<ListNode>();
        
        while(!stack.isEmpty()){
        	stack.pop().val
        }
		
		return null;*/
		ArrayList<Integer> array = new ArrayList<Integer>();
		ListNode temp = listNode;
        while(temp!= null){
        	array.add(temp.val);
        	temp= temp.next;
        }
        for(int i = 0 ; i < array.size()/2 ; i++){
        	Integer tem = array.get(i);
        	array.set(i,array.get(array.size()-i-1));
        	array.set(array.size()-i-1, tem);
        }
		
		return array;
    }
}
