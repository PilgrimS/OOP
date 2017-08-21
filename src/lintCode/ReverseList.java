package lintCode;

import java.util.ArrayList;
import java.util.List;

public class ReverseList {
	public static ListNode buildList(List<Integer> list){
		
		if(list.isEmpty()) return null;
		else {
			ListNode head  = new ListNode(list.get(0));
			ListNode index = head;
			int i = 1;
			while(i < list.size()){
				
				ListNode temp = new ListNode(list.get(i));
				index.next = temp ;
				index = index.next;
				i +=1;
			}
			return head;
		}
	}
	public static ListNode reverse(ListNode head) {
		ListNode pre = head;
		if(pre == null) return null;
		if(pre.next == null) return pre;
		pre = pre.next;
		head.next = null;
		while(pre != null){
			ListNode temp = pre.next;
			pre.next = head;
			head = pre;
			pre = temp;
		}
		return head;
	}
	public static void main(String[] args) {
		int [] a = {1,2,3,4};
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i< a.length ; i++){
			list.add(a[i]);
		}
		ListNode head = reverse(buildList(list));
		while(head != null){
			System.out.print(head.val);
			head = head.next;
		}
	}
}
