package lintCode.fourth;

import java.util.ArrayList;
import java.util.List;

import lintCode.TreeNode;

public class BinaryTreePathSum {
	
	public static List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root == null) return list;
		if(root.val == target && root.left == null && root.right == null) {
			List<Integer> temp = new ArrayList<>();
			temp.add(root.val);
			list.add(temp);
		}else{
			List<List<Integer>> left = binaryTreePathSum(root.left, target-root.val);
			List<List<Integer>> right = binaryTreePathSum(root.right, target-root.val);
			for(int i = 0 ; i < left.size();i++){
				left.get(i).add(0, root.val);
			}
			for(int i = 0 ; i<right.size();i++){
				right.get(i).add(0, root.val);			
			}
			list.addAll(left);
			list.addAll(right);
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		int[] pre ={1,2,2,3,4};
		int[] in ={2,2,3,1,4};
	}

}
