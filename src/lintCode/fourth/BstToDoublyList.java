package lintCode.fourth;

import java.util.Stack;

import lintCode.DoublyListNode;
import lintCode.TreeNode;

public class BstToDoublyList {
	public static DoublyListNode bstToDoublyList(TreeNode root) {
		DoublyListNode head = null;
		DoublyListNode tempD = head;
		int count = 0;
		Stack<TreeNode> st = new Stack<>();
		TreeNode tempT = root;
		while(tempT != null && !st.isEmpty()){
			while(tempT != null){
				st.push(tempT);
				tempT = tempT.left;
			}
			if(!st.isEmpty()){
				tempT = st.pop();
				if(count == 0){
					tempD = new DoublyListNode(tempT.val);
				}else{
					tempD.next = new DoublyListNode(tempT.val);
					tempD.next.prev = tempD;
					tempD = tempD.next;
				}
				count ++;
				tempT = tempT.right;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(5);
		bstToDoublyList(root);
	}
}
