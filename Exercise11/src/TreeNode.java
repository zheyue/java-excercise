
public class TreeNode <T extends Comparable<T>>{
	public TreeNode<T> left;
	public TreeNode<T> right;
	public T value;
	
	TreeNode(T v){
		value = v;
	}
	
}
