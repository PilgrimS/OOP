package newcoder;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

import sun.reflect.generics.tree.Tree;

public class Solution0010 {
	
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		TreeNode root = new TreeNode(pre[0]);
		int count = 0;
		int index = 0;
		int posRoot = 0;
		Queue<TreeNode> qT = new ArrayDeque<TreeNode>();
		
		if(pre.length != in.length) return null;
		if(pre.length == 0 ) return null;
		
		boolean[] flag = new boolean[in.length];
		for(boolean i : flag){
			i = false;
		}
		flag[0] = true;
		qT.offer(root);
		count++;
		while(count != pre.length){
			TreeNode temp = qT.poll();
			index = in.toString().lastIndexOf(temp.val);
			posRoot = pre.toString().lastIndexOf(temp.val);
			if(flag[posRoot+1] == false){
				TreeNode left = new TreeNode(pre[posRoot+1]);
				temp.left = left;
				qT.offer(left);
				count++;
			}
			if(flag[index+1] == false){
				TreeNode right = new TreeNode(pre[index+1]);
				temp.right = right;
				qT.offer(right);
				count++;
			}	
		}		
		
		return null;
    }
	//二叉树重建 递归方法
	public static TreeNode reConstructBinaryTreeRec(int [] pre,int [] in){
		if(pre.length != in.length || pre.length == 0) return null;
		TreeNode root = new TreeNode(pre[0]);
		int index = findInArray(in, pre[0]);
		int [] leftpre = Arrays.copyOfRange(pre, 1,index+1);
		int [] leftin  = Arrays.copyOfRange(in, 0, index);
		int [] rightpre = Arrays.copyOfRange(pre, index+1, pre.length);
		int [] rightin = Arrays.copyOfRange(in, index+1, in.length);
		root.left = reConstructBinaryTreeRec(leftpre, leftin);
		root.right = reConstructBinaryTreeRec(rightpre, rightin);
		return root;
	}
	
	
	//二叉树前序遍历非递归
	public static String preTravel(TreeNode root){
		StringBuilder sb = new StringBuilder();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode temp = root;
		
		while(temp != null || !stack.isEmpty()){
			while(temp != null){
				sb.append(temp.val);
				stack.push(temp);
				temp = temp.left;
			}
			if(!stack.isEmpty()){
				temp = stack.pop();
				temp = temp.right;
			}
		}
		
		return sb.toString();
	}
	
	//二叉树中序遍历非递归
	public static String midTravel(TreeNode root){
		StringBuilder sb = new StringBuilder();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode temp = root;
		
		while(temp != null || !stack.isEmpty()){
			while(temp != null){
				stack.push(temp);
				temp = temp.left;
			}
			if(!stack.isEmpty()){
				
				temp = stack.pop();
				sb.append(temp.val);
				temp = temp.right;
			}
		}
		
		return sb.toString();
	}
	//二叉树后序遍历非递归
	public static String postTravel(TreeNode root){
		StringBuilder sb = new StringBuilder();    //存储树值
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();    //缓存树节点
		TreeNode cur ;   //当前访问节点
		TreeNode pre  = null;  //之前访问的节点
		stack.push(root);
		while(!stack.isEmpty()){
			cur = stack.peek();
			/*
			 * 判断当前节点值是否该打印：
			 * 若无左右节点打印
			 * 若左右节点访问过打印
			 */
			if((cur.left == null && cur.right == null) ||
					((pre != null ) && (pre == cur.left || pre == cur.right))){
				sb.append(cur.val);
				stack.pop();
				pre = cur;
			}else{
				if(cur.right != null){
					stack.push(cur.right);
				}
				if(cur.left != null){
					stack.push(cur.left);
				}
			}
		}
		return sb.toString();
	}
	
	//二叉树前序遍历递归
	public static String preTravelRec(TreeNode root){
		StringBuilder sb = new StringBuilder();
		StringBuilder leftSb = new StringBuilder();
		StringBuilder rightSb = new StringBuilder();
		if(root == null) 
			return "";
		else{
			sb.append(root.val);
		}
		leftSb = leftSb.append(preTravelRec(root.left));
		rightSb = rightSb.append(preTravelRec(root.right));
		sb = sb.append(leftSb).append(rightSb);
		return sb.toString();
	}
	//二叉树中序遍历递归
	public static String midTravelRec(TreeNode root){
		StringBuilder sb = new StringBuilder();
		StringBuilder leftSb = new StringBuilder();
		StringBuilder rightSb = new StringBuilder();
		if(root == null) 
			return "";
		else{
			sb.append(root.val);
		}
		leftSb = leftSb.append(midTravelRec(root.left));
		rightSb = rightSb.append(midTravelRec(root.right));
		//sb = sb.append(leftSb).append(rightSb);
		sb = leftSb.append(sb).append(rightSb);
		return sb.toString();
	}
	//二叉树后序遍历递归
	public static String postTravelRec(TreeNode root){
		StringBuilder sb = new StringBuilder();
		StringBuilder leftSb = new StringBuilder();
		StringBuilder rightSb = new StringBuilder();
		if(root == null) 
			return "";
		else{
			sb.append(root.val);
		}
		leftSb = leftSb.append(postTravelRec(root.left));
		rightSb = rightSb.append(postTravelRec(root.right));
		//sb = sb.append(leftSb).append(rightSb);
		//sb = leftSb.append(sb).append(rightSb);
		sb = leftSb.append(rightSb).append(sb);
		return sb.toString();
	}
	
	
	
	public static void main(String[] args) {
		int [] array = {1,2,3,4,5,6,7,8,9,0};
		TreeNode [] treeArray = new TreeNode[10];
		for(int i = 0 ; i < array.length ; i++){
			treeArray[i] = new TreeNode(array[i]);
		}
		for(int i = 0 ; i < array.length ; i ++){
			if(2*i+1 < array.length){
				treeArray[i].left = treeArray[2*i+1 ];
			}
			if(2*i+2 < array.length){
				treeArray[i].right = treeArray[2*i +2];
			}
		}
		System.out.println(preTravelRec(treeArray[0]));
		System.out.println(midTravelRec(treeArray[0]));
		//1248950367
		//8492051637
		int [] pre = {1,2,4,8,9,5,0,3,6,7};
		int [] in = {8,4,9,2,0,5,1,3,6,7};
		reConstructBinaryTreeRec(pre,in);
		System.out.println(postTravelRec(treeArray[0]));
		System.out.println(preTravel(treeArray[0]));
		System.out.println(midTravel(treeArray[0]));
		System.out.println(postTravel(treeArray[0]));
		
		System.out.println(preTravel(reConstructBinaryTreeRec(pre, in)));
	}
	
	public static int [] stringToint(String s){
		int [] a = new int[s.length()];
		long sint = Long.parseLong(s);
		for(int i = a.length-1 ; i >= 0 ; i--){
			a[i] =(int) sint%10;
			sint = sint/10;
		}
		return a;
	}
	public static int findInArray(int [] a , int target){
		int index = -1;
		for(int i = 0 ; i < a.length ; i++){
			if(a[i] == target){
				index = i;
				break;
			}
		}
		return index;
	}

}
