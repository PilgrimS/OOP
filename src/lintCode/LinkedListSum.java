package lintCode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListSum {
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
	
	public static ListNode addLists(ListNode l1, ListNode l2) {
		List<Integer> list = new ArrayList<>();
		ListNode temp = l1;
		while(temp != null){
			list.add(temp.val);
			temp = temp.next;
		}
		temp = l2;
		int i = 0;
		int size = list.size();
		while(temp != null){
			if(i<size){
				int val = list.get(i);
				if(val >= 10) {
					list.set(i, val%10);
					if(i+1 > size) {
						list.add(i+1,1);
						size = list.size();
					}else {
						list.set(i+1, list.get(i+1) + 1);
					}
				} 
				int tem = val + temp.val;
				if(tem >= 10 ){
					if(i+1 >=size){
						list.add(i+1, 1);
						list.set(i, tem%10);
						size = list.size();
					}else{
						list.set(i+1, list.get(i+1) + 1);
						list.set(i, tem%10);
					}
				}else{
					list.set(i, tem);
				}
			}else{
				list.add(i, temp.val);
			}
			
			temp = temp.next;
			i +=1;
		}
		if(list.get(size-1)>=10){
			list.add(size,list.get(size-1)/10);
			list.set(size-1, list.get(size-1)%10);
			
		}
		return buildList(list);
		
    }
	public static ListNode addLists2(ListNode l1, ListNode l2) {
		List<Integer> list1 = new ArrayList<>();
		ListNode temp = l1;
		while(temp != null){
			list1.add(temp.val);
			temp = temp.next;
		}
		
		List<Integer> list2 = new ArrayList<>();
		temp = l2;
		while(temp != null){
			list2.add(temp.val);
			temp = temp.next;
		}
		int a = list1.size();
		int b = list2.size();
		if(a>=b){
			for(int i = a-1 ; i >= 0; i--){
				if(i-a+b >= 0){
					int tem = list1.get(i)+list2.get(i-a+b);
					if(tem >= 10){
						if(i == 0){
							list1.set(i, tem);
						}else{
							list1.set(i, tem%10);
							list1.set(i-1, tem/10+list1.get(i-1));
						}	
					}else{
						list1.set(i,list1.get(i)+list2.get(i-a+b));
					}	
				}
			}
			int s = list1.get(0);
			if(s>=10){
				
				list1.add(0,s/10);
				list1.set(1,s%10);
				
			}
			return buildList(list1);
		}else{
			for(int i = b-1 ; i >=0; i--){
				if(i-b+a >= 0){
					int tem = list1.get(i-b+a)+list2.get(i);
					if(tem >= 10){
						if(i == 0){
							list2.set(i, tem);
						}else{
							list2.set(i, tem%10);
							list2.set(i-1, tem/10+list2.get(i-1));
						}	
					}else{
						list2.set(i,list1.get(i-b+a)+list2.get(i));
					}
				}
			}
			int s = list1.get(0);
			if(s>=10){
				
				list2.add(0,s/10);
				list2.set(1,s%10);
				
			}
			return buildList(list2);
		}
		
		
		
    }
	public static void main(String[] args) {
		int [] a = {1,1,1};
		int [] b = {9,8,8};
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i< a.length ; i++){
			list.add(a[i]);
		}
		
		ListNode l1 = buildList(list);
		list.clear();
		for(int i = 0 ; i< b.length ; i++){
			list.add(b[i]);
		}
		ListNode l2 = buildList(list);
		
		ListNode l3 = addLists2(l1,l2);
		while(l3 != null){
			System.out.print(l3.val);
			l3 = l3.next;
		}

		
	}
}
