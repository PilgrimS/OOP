package lintCode.third;

import lintCode.ListNode;

public class MergeTwoList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode l3 = new ListNode(l1.val < l2.val?l1.val:l2.val);
		ListNode temp = l3;
		if(l1.val < l2.val) l1 = l1.next;
		else l2 = l2.next;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val) {
				temp.next = new ListNode(l1.val);
				l1 = l1.next;
			}else {
				temp.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			temp = temp.next;
		}
		if(l1 == null ) temp.next = l2;
		else{
			temp.next = l1;
		}
		return l3;
	}
}
