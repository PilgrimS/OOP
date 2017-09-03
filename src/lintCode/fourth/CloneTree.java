package lintCode.fourth;

import lintCode.TreeNode;

public class CloneTree {
	 public TreeNode cloneTree(TreeNode root) {
		if(root == null) return null;
		else{
			TreeNode rootNew = new TreeNode(root.val);
			rootNew.left = cloneTree(root.left);
			rootNew.right = cloneTree(root.right);
			return rootNew;
		}
	}
}
