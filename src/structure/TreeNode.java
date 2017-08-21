package structure;

import java.util.Map;

public class TreeNode<K,V> {
	TreeNode<K,V> left = null;
	TreeNode<K,V> right = null;
	K key;
	V value;
	TreeNode<K,V> parent;
	int height = 0;
	
	TreeNode(K key, V value, TreeNode<K,V> parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
    }
	TreeNode (TreeNode t){
		this.left = t.left;
		this.right = t.right;
		this.key = (K)t.key;
		this.value = (V)t.value;
		this.height = t.height;
		
		
	}
	
    K getKey(){
    	return key;
    }

    
    V getValue(){
    	return value;
    }

    
    V setValue(V value){
    	V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    
    public boolean equals(Object o){
    	if (!(o instanceof TreeNode))
            return false;
    	return this.value == ((TreeNode) o).value ?  true :  false;
    }

   
    public int hashCode(){
    	int keyHash = (key==null ? 0 : key.hashCode());
        int valueHash = (value==null ? 0 : value.hashCode());
        return keyHash ^ valueHash;
    }

}
