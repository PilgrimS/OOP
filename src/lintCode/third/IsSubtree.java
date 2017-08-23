package lintCode.third;

import lintCode.TreeNode;

public class IsSubtree {
	//逻辑考虑要完整
	private static boolean equal(TreeNode T1,TreeNode T2){
		if(T1 == null && T2 == null) return true;
		//短路式很精妙
		if(T1 == null || T2 == null || T1.val != T2.val) return false;
		else return equal(T1.left,T2.left) && equal(T1.right,T2.right);
	}
	
	private static boolean isSub(TreeNode T1,TreeNode T2){
		//顺序很重要
		if(T2 == null) return true;
		if(T1 == null) return false;
		if(T1.val == T2.val){
			 if(equal(T1,T2)){
				 return true;
			 }
		}
		return isSub(T1.left, T2) || isSub(T1.right,T2) ;
	}
	
	public boolean isSubtree(TreeNode T1, TreeNode T2) {
		return isSub(T1,T2);
	}
	
	public static void main(String[] args) {
		
	}

}
