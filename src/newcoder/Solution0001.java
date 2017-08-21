package newcoder;

public class Solution0001 {
	/*
	 * 求到叶节点的最短路径长度
	 */
	public int run(TreeNode root){
		int leftmin = 0;
		int rightmin = 0;
		if(root == null) return 0;
		if(root.left == null ){
			return run(root.right);
		}
		if(root.right == null){
			return run(root.left);
		}
		leftmin = run(root.left);
		rightmin = run(root.right);
		
		return (leftmin <= rightmin) ? leftmin + 1 : rightmin + 1;
		
	}
}
