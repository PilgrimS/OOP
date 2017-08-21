package newcoder;

/*sf  
 * 1->2->3
 *    s  f
 * 1->2->3
 *    f  s
 * 1->2->3
 *fs
 * 1->2->3
 *sf
 * 1->2->3->4
 *    s  f
 * 1->2->3->4
 * f     s 
 * 1->2->3->4
 *       f  s 
 * 1->2->3->4
 *fs
 * 1->2->3->4
 * sf
 * 1->2->3->4
 *    s  f 
 * 1->2->3->4
 * f     s 
 * 1->2->3->4
 *       f  s
 * 1->2->3->4
 *   fs      
 * 1->2->3->4
 *sf
 * 1->2->3->4->5->6->7->8
 *    s  f
 * 1->2->3->4->5->6->7->8
 *       s     f
 * 1->2->3->4->5->6->7->8
 *          s        f
 * 1->2->3->4->5->6->7->8
 *    f        s         
 * 1->2->3->4->5->6->7->8
 *          f     s
 * 1->2->3->4->5->6->7->8
 *                f  s     
 * 1->2->3->4->5->6->7->8
 *                     fs
 * 1->2->3->4->5->6->7->8
 * 
 * 
 */

public class Solution0026 {
	public static ListNode detectCycle(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       ListNode res = head;
       int count = 0;
       int temp = 0;
       if(head == null) return null;
       while(true){
    	   if(fast.next == null || fast.next.next == null)  {res = null;return res;}
    	   slow = slow.next;
    	   fast = fast.next.next;
    	   count++;
    	   if(slow  == fast) {
    		   temp = count;
    		   break;
    	   }
    	   
       }
       fast = head;
       while(fast != slow){
    	   slow = slow.next;
    	   fast = fast.next;
       }
       return res = slow;
    }
	
	public static boolean isCycle(ListNode head){
		if(head == null) return false;
		ListNode fast = head;
		ListNode slow = head;
		/*while(fast.next!= null || fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) return true;
		}*/
		while(true){
			if(fast.next == null || fast.next.next==null) return false;
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) return true;
		}
	}
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = c;
		System.out.println(detectCycle(a).val);
		System.out.println(isCycle(a));
	}
	
	
}
