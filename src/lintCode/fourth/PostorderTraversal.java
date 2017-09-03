package lintCode.fourth;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import lintCode.TreeNode;

public class PostorderTraversal {
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if(root ==null) return list;
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		TreeNode pre = null;
		while(!st.isEmpty()){
			TreeNode temp = st.peek();
//(temp.left == null && temp.right == null) || 
//((pre != null)&&((pre == temp.right) || (pre == temp.left && temp.right == null)))
			if((temp.left == null && temp.right == null) ||((pre != null)&& 
					 (pre == temp.left || temp.right == pre))){
				list.add(st.pop().val);
				pre = temp;
			}else{
				if(temp.right != null){
					st.push(temp.right);
				}
				if(temp.left != null){
					st.push(temp.left);
				}
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {

	}

}
