package lintCode.fourth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lintCode.TreeNode;

public class LevelOrder {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list  =  new ArrayList<>();
		if(root == null) return null;
		LinkedList<TreeNode> ll = new LinkedList<>();
		ll.offer(root);
		while(!ll.isEmpty()){
			List<Integer> temp = new ArrayList<>();
			//很关键！！ 将当前队列长度记录下来
			int size = ll.size();
			for(int i = 0 ; i < size ; i++){
				TreeNode node = ll.poll();
				if(node.left != null) ll.offer(node.left);
				if(node.right != null) ll.offer(node.right);
				temp.add(node.val);
			}
			list.add(temp);
		}
		return list;
	}
	
	public static void main(String[] args) {
		
	}

}
