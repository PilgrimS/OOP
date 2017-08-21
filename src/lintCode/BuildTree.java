package lintCode;

public class BuildTree {
	
	private static TreeNode build(int[] preorder,int ab,int ae,int[] inorder,int bb, int be){
		if(ab > ae) return null;
		if(ab == ae) return new TreeNode(preorder[ab]);
		TreeNode root = new TreeNode(preorder[ab]);
		int index = 0;
		for(int i = bb; i <= be; i++){
			if(inorder[i] == preorder[ab]) index =i;
		}
		int leftlen = index;
		root.left = build(preorder,ab+1,ab+leftlen,inorder,0,index-1);
		root.right = build(preorder,index+1,ae,inorder,index+1,be);
		return root;
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
		int[] b = {3,2,1};
		buildTree(a, b);
	}

}
