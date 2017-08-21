package newcoder;

import java.util.Random;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class Solution0021 {
	
	/*
	 * 单链表的归并排序
	 */
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode mid = findMiddle(head);
        ListNode midNext = mid.next;
        mid.next = null;
        return mergeSort(sortList(head), sortList(midNext));

    }
	public ListNode findMiddle(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		if(head == null) return null;
		if(head.next == null || head.next.next == null) return head;
		while(fast.next != null && fast.next.next != null ){
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast.next != null && fast.next.next == null){
			slow = slow.next;
		}
		return slow;
	}
	public ListNode mergeSort(ListNode l1,ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode first = l1.next;
		ListNode second = l2.next;
		ListNode res,newHead;
		if(l1.val > l2.val){
			res = l2;
			newHead = l2;
			first = l1;
		}else{
			res = l1;
			newHead = l1;
			second = l2;
		}
		while(first != null || second != null){
			if(first == null){
				res.next = second;
				return newHead;
			}else if(second == null){
				res.next = first;
				return newHead;
			}
			else if(first.val < second.val){
				res.next = first;
				first = first.next;
				res = res.next;
			}else{
				res.next = second;
				second = second.next;
				res = res.next;
			}
		}
		return newHead;
		
	}
	
	/*
	 * 单链表的快速排序
	 */
	public ListNode sortList1(ListNode head){
		return null;
	}
	
	/*
	 * 
	 */
	public static ListNode insertionSortList(ListNode head) {
		if(head == null) return null;
		ListNode sHead = head;
		ListNode uHead = head.next;
		sHead.next = null;
		while(uHead != null){
			ListNode temp = uHead.next;
			uHead.next = null;
			sHead = insert(sHead,uHead);
			uHead = temp;
		}
		return sHead;    
	}
	private static ListNode insert(ListNode sHead, ListNode uHead) {
		ListNode pointer = sHead;
		if(sHead == null) sHead = uHead;
		if(uHead.val <= sHead.val) {
			uHead.next = sHead;
			return sHead = uHead;
		}
		while(pointer.val < uHead.val ){
			if(pointer.next == null ) {pointer.next = uHead; break;}
			else if(pointer.next.val >= uHead.val) {
				ListNode temp = pointer.next;
				pointer.next = uHead;
				uHead.next = temp;
				break;
			}else{
				pointer = pointer.next;
			}
		}
		return sHead;
		
	}
	public static void main(String[] args) {
		Random rand = new Random(47);
		int n = rand.nextInt(40);
		ListNode [] ln = new ListNode[n];
		for(int i = 0 ; i < n ; i++){
			ln[i] = new ListNode(rand.nextInt(60));
		}
		for(int i = 0 ; i < n ; i ++){
			if(i < n-1) ln[i].next = ln[i+1];
			else ln[i] =null;
		}
		ListNode head = ln[0];
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		head = insertionSortList(ln[0]);
		System.out.println("");
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}

