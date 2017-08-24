package lintCode.third;

import lintCode.ListNode;

public class RemoveNthFromList {
	
	ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		int count = n;
		while(count != 0 ){
			fast = fast.next;
			count--;
		}
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next;
		}
		ListNode temp = slow.next;
		slow.next = temp.next;
		temp.next = null;
		return head;
	}
	
	public static void main(String[] args) {
		
	}

}
