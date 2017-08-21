package newcoder;

import java.util.Random;

public class Solution0025 {
	
	
	public static ListNode reorderList(ListNode head) {
        if(head == null )  return null;
		ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        fast = fast.next;
        ListNode uHead = slow.next;
        uHead  = reverse(uHead);
        fast = head;
        slow = uHead;
        while(uHead != null){
        	ListNode temp = fast.next;
        	if(uHead.next != null) slow = uHead.next; 
        	else slow = null;
        	fast.next = uHead;
        	uHead.next = temp;
        	fast = temp;
        	uHead = slow;
        }
        fast.next =null;
        return head;
    }
	private static ListNode reverse(ListNode uHead) {
		if(uHead == null)  return uHead;
		if(uHead.next == null) return uHead;
		ListNode temp ;
		ListNode lHead = uHead.next;
		uHead.next = null;
		while(lHead != null ){
			temp = lHead.next;
			lHead.next = uHead;
			uHead = lHead;
			lHead = temp;
		}
		return uHead;
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		a.next = b;
		b.next = c;
		
		/*Random rand = new Random(47);
		int n = rand.nextInt(40);
		ListNode [] ln = new ListNode[n];
		for(int i = 0 ; i < n ; i++){
			ln[i] = new ListNode(rand.nextInt(60));
		}
		for(int i = 0 ; i < n ; i ++){
			if(i < n-1) ln[i].next = ln[i+1];
			else ln[i] =null;
		}*/
		ListNode head = a;
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		head = reorderList(a);
		System.out.println("");
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		
	}
}
