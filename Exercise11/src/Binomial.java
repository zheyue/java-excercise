
public class Binomial <E extends Comparable<E>>{
	
	private TreeNode<E> root;
	
	public boolean search(E element) {

		TreeNode<E> current = root; // Start from the root
		while (current != null) {

			if (element.compareTo(current.value) > 0) {
				
				current = current.left; // Go left
		
			}
			else if (element.compareTo(current.value) < 0) {
				current = current.right; // Go right
	
			}
			else // Element matches current.element
				return true; // Element is found

		} // end while
	
		return false; // Element is not in the tree

	} // end search
	
		 

	public boolean insert(E element) {

		if (root == null) {
			root = new TreeNode<>(element);
		} else {
			// Locate the parent node
			TreeNode<E> current = root;
			TreeNode<E> parent = root;
	
			while(current != null) {
				if (element.compareTo(current.value) < 0) {
					parent = current;
					current = current.left;
				} else if (element.compareTo(current.value) > 0 ) {
					parent = current;
					current = current.right;
				} else
					return false; // Duplicate node not inserted
			}
			// Create the new node and attach it to the parent node
			if (element.compareTo(parent.value) < 0 )
				parent.left = new TreeNode<>(element);
			else
				parent.right = new TreeNode<>(element);

		}// end else

		return true; // Element inserted
	}

	public void print() {
		
		System.out.println(preorder(root, new StringBuilder("Preorder:  ")));
		System.out.println(inorder(root, new StringBuilder("Inorder:   ")));
		System.out.println(postorder(root, new StringBuilder("Postorder: ")));
	}	
	
	public StringBuilder preorder(TreeNode<E> n, StringBuilder sb) {
		sb.append(n.value);
		sb.append(" ");
		
		if (n.left != null) {
			preorder(n.left, sb);
		}
		
		if (n.right != null) {
			preorder(n.right, sb);
		}
		
		return sb;
	}

	
	public StringBuilder inorder (TreeNode<E> n, StringBuilder sb) {
		if (n.left != null) {
			inorder(n.left, sb);
		}
		
		sb.append(n.value);
		sb.append(" ");
		
		if (n.right != null) {
			inorder(n.right, sb);
		}
		
		return sb;
	}
		
	public StringBuilder postorder (TreeNode<E> n, StringBuilder sb) {
		
		if (n.left != null) {
			postorder(n.left, sb);
		}
		
		if (n.right != null) {
			postorder(n.right, sb);
		}
		
		sb.append(n.value);
		sb.append(" ");
		
		return sb;
	}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
