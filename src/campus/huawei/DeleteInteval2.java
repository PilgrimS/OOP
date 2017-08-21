package campus.huawei;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import campus.huawei.LoopDeque.DeNode;



class LoopDeque<AnyType extends Comparable<? super AnyType>>{
	static class DeNode<AnyType>{
		DeNode(AnyType theElement){
			this(theElement,null);
		}
		DeNode(AnyType theElement,DeNode<AnyType> next){
			element = theElement;
			this.next = next;
		}
		AnyType element;
		DeNode <AnyType> next;
	}
	private DeNode<AnyType> head;
	private DeNode<AnyType> tail;
	LoopDeque(){
		head = null;
		tail = null;
	}
	LoopDeque(AnyType x){
		head =new DeNode(x);
		head.next = head;
		tail =head;
		
	}
	public void insert(AnyType x){
		if(head == null && tail ==null) {
			head =new DeNode(x);
			head.next = head;
			tail =head;
		}else{
			tail.next = new DeNode(x,head);
			tail = tail.next;
		}
		
	}
	public DeNode getHead(){
		return head;
	}
	public DeNode getTail(){
		return tail;
	}
}

public class DeleteInteval2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new LinkedList<>();
		LoopDeque<Integer> ld = new LoopDeque<>();
		for(int i = 0 ; i < n ; i++){
			ld.insert(i);
		}		
		DeNode dn = ld.getHead();
		DeNode dnc = ld.getHead();
		dn = ld.getHead().next.next;
		dnc = ld.getHead().next;
		while(n > 0){
			DeNode temp = dn.next;
			dn = dn.next.next.next;
			dnc.next = temp;
			dnc = dnc.next.next;
			n = n-1;
		}
		System.out.println(dn.element);
	}

}
