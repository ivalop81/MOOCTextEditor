package spelling;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
	
    // TODO: Implement the dictionary interface using a TreeSet.  
 	// You'll need a constructor here
	
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
        return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	// TODO: Implement this method
        return 0;
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	//TODO: Implement this method
        return false;
    }

}

public class BinaryTree <E> {
	private TreeNode<E> root;
	// other constructors and methods here...TODO
	
	
	// Pre/Pos are Depth first traversal
	private void preOrder(TreeNode <E> node) 
	{
		if (node != null) {
			node.visit();
			preOrder(node.getLeftChild());
			preOrder(node.getRigthChild());
		}
	}
	private void preOrder() {
		this.preOrder(root);
	}
	
	private void posOrder(TreeNode <E> node) 
	{
		if (node != null) {			
			posOrder(node.getLeftChild());
			posOrder(node.getRigthChild());
			node.visit();
		}
	}
	private void posOrder() {
		this.posOrder(root);
	}	
	
	private void inOrder(TreeNode <E> node) 
	{
		if (node != null) {			
			inOrder(node.getLeftChild());
			node.visit();			
			inOrder(node.getRigthChild());
		}
	}
	
	private void inOrder() {
		this.inOrder(root);
	}	
	
	public void levelOrder() {
		Queue< TreeNode<E> > q = new LinkedList< TreeNode<E> >();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode<E> curr = q.remove();
			if(curr != null) {
				curr.visit();
				q.add(curr.getLeftChild());
				q.add(curr.getRightChild());
			}
		}
	}	
}

public class TreeNode<E> {
	private E value;
	private TreeNode<E> parent;
	private TreeNode<E> left;
	private TreeNode<E> right;
	
	public TreeNode (E value, TreeNode<E> parent)
	{
		this.value = value;
		this.parent = parent;
		this left = null;
		this.right = null;
	}
	
	public TreeNode<E> addLeftChild(E value) 
	{
		this.left = new TreeNode<E>(value , this);
		return this.left;
	}

	public TreeNode<E> addRightChild(E value) 
	{
		this.right = new TreeNode<E>(value , this);
		return this.right;
	}
		
	public TreeNode<E> getLeftChild () {
		return left;
	}

	public TreeNode<E> getRigthChild () {
		return right;
	}
	
	public E visit() {
		return (E) value;
	}	
}

