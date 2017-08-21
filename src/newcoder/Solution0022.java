package newcoder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution0022 {
	 public ArrayList<Integer> postorderTraversal(TreeNode root) {
		 Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 TreeNode pre=null; //之前访问的节点
		 TreeNode cur; //正在访问的节点
		 
		 if(root == null) return list;
		 stack.push(root);
		 
		 while(!stack.isEmpty()){
			cur = stack.peek();
			if((cur.left == null && cur.right == null) ||
					(pre !=null && ((pre == cur.left) ||(pre == cur.right)))){
				list.add(cur.val);
				stack.pop();
				pre = cur;
			}else{
				if(cur.right != null) stack.push(cur.right);
				if(cur.left != null) stack.push(cur.left);
			}
		 }
		 return list; 
	 }
	 
	 
	 public ArrayList<Integer> preorderTraversal(TreeNode root) {
		 Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 TreeNode temp = root;
		 while(temp != null || !stack.isEmpty()){
			 while(temp != null){
					list.add(temp.val);
					stack.push(temp);
					temp = temp.left;
				}
				if(!stack.isEmpty()){
					temp = stack.pop();
					temp = temp.right;
				}
		 }
		 
		 return list;
	 }
}
