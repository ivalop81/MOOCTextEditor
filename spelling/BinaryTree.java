package spelling;

public class BinaryTree<E> {
	private TreeNode<E> root;
//	// other constructors and methods here...TODO
//
//	// Pre/Pos are Depth first traversal
//	private void preOrder(TreeNode <E> node) 
//	{
//		if (node != null) 
//		{
//			node.visit();
//			preOrder(node.getLeftChild());
//			preOrder(node.getRightChild());
//		}
//	}
//
//	private void preOrder() 
//	{
//		this.preOrder(root);
//	}
//
//	private void posOrder(TreeNode <E> node) 
//	{
//		if (node != null) 
//		{	
//			posOrder(node.getLeftChild());
//			posOrder(node.getRightChild());
//			node.visit();
//		}
//	}
//
//	private void posOrder() 
//	{
//		this.posOrder(root);
//	}	
//
//	private void inOrder(TreeNode <E> node) 
//	{
//		if (node != null) 
//		{	
//			inOrder(node.getLeftChild());
//			node.visit();	
//			inOrder(node.getRightChild();
//		}
//	}
//
//	private void inOrder() 
//	{
//		this.inOrder(root);
//	}	

//	public void levelOrder() 
//	{
//		Queue< TreeNode<E> > q = new LinkedList< TreeNode<E> >();
//		q.add(root);
//		
//		while(!q.isEmpty()) 
//		{
//			TreeNode<E> curr = q.remove();
//			if(curr != null) 
//			{
//				curr.visit();
//				q.add(curr.getLeftChild());
//				q.add(curr.getRightChildChild());			
//			}
//		}	
//	} 
		
//	
//	 * contains(item, node):
//			if (node == null)
//				return false
//			else if (node.val == item)
//				return true
//			else if (node.val < item)
//				return contains(item, node.right)
//			else // node.val > item
//				return contains(item, node.left)
	 
//	public boolean contains(E value, TreeNode<E> node) 
//	{
//		if (node == null)
//			return false;
//		else if (node.visit().equals(value))
//			return true;
//		else if (node.getValue() < value)
//			return contains(value, node.getRight());
//		else
//			return contains(value, node.getLeftChild());
//	}

//	insert(item, node):
//	
//	// Iterative algorithm for insertions in a BST
//	if (node.valnode.val== item)== item)
//		return false
//	else if (node.valnode.val< item)< item)
//		if (node.rightnode.right== null)== null)
//			add as right child, return true
//		insert(item, node.rightnode.right)
//	else // node.valnode.val> item> item
//		if (node.leftnode.left== null)== null)
//			add as as left left child, return truechild, return true
//		insert(item, , node.leftnode.left)
	
	// TODO public class BST <E extends Comparable <? super E>>
//	public boolean contain(E toFind ) 
//	{
//		TreeNode<E> curr = root;
//		int comp;
//		while (curr != null) 
//		{
//			comp = toFind.compareTo(curr.getValue());
//			if (comp < 0)
//				curr = curr.getLeftChild();
//			else if (comp > 0)
//				curr = curr.getRightChild();
//			else
//				return true,
//		}
//		return false;
//	}

//	public boolean insert(E toInsert) {
//		TreeNode<E> curr = root;
//		int comp = toInsert.compareTo(curr.getValue());
//		while (comp < 0 && curr.getLeftChild() != null || comp > 0 && curr.getRightChild() != null) {
//			if (comp < 0)
//				curr.getLeftChild();
//			else
//				curr.getRightChild();
//			comp = toInsert.compareTo(curr.getValue());
//		}
//		if (comp < 0)
//			curr.addLeftChild(toInsert, curr);
//		else if (comp > 0)
//			curr.setRightChild(toInsert, curr);
//		else
//			return false;
//		return true;
//	}
	
}

