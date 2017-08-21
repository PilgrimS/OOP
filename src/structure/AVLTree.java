package structure;

import java.util.Comparator;


public class AVLTree<K,V> {
	private transient TreeNode<K,V> root ;
	
	public AVLTree() {
		root = null;
	}
	public boolean insert(TreeNode t){
		if(root == null)	root = t;
		else{
			
		}
		return false;
	}
}
