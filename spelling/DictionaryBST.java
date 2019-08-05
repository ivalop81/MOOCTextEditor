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
	public DictionaryBST()
	{
		dict = new TreeSet<String>();
	}
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method 	
        return dict.add(word.toLowerCase());
    	//return dict.add(word);
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	// TODO: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	//TODO: Implement this method  	
        return dict.contains(s.toLowerCase());
    }

}
/*
public class BinaryTree <E> 
{
	private TreeNode<E> root;
	// other constructors and methods here...TODO

	// Pre/Pos are Depth first traversal
	private void preOrder(TreeNode <E> node) 
	{
		if (node != null) 
		{
			node.visit();
			preOrder(node.getLeftChild());
			preOrder(node.getRigthChild());
		}
	}

	private void preOrder() 
	{
		this.preOrder(root);
	}

	private void posOrder(TreeNode <E> node) 
	{
		if (node != null) 
		{	
			posOrder(node.getLeftChild());
			posOrder(node.getRigthChild());
			node.visit();
		}
	}

	private void posOrder() 
	{
		this.posOrder(root);
	}	

	private void inOrder(TreeNode <E> node) 
	{
		if (node != null) 
		{	
			inOrder(node.getLeftChild());
			node.visit();	
			inOrder(node.getRigthChild());
		}
	}

	private void inOrder() 
	{
		this.inOrder(root);
	}	

	public void levelOrder() 
	{
		Queue< TreeNode<E> > q = new LinkedList< TreeNode<E> >();
		q.add(root);
		
		while(!q.isEmpty()) 
		{
			TreeNode<E> curr = q.remove();
			if(curr != null) 
			{
				curr.visit();
				q.add(curr.getLeftChild());
				q.add(curr.getRigthChild());			
			}
		}	
	}
		
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
	 
	public boolean contains(E value, TreeNode<E> node) 
	{
		if (node == null)
			return false;
		else if (node.visit().equals(value))
			return true;
		else if (node.getValue() < value)
			return contains(value, node.getRigthChild());
		else
			return contains(value, node.getLeftChild());
	}
}

public class TreeNode<E> 
{
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

	public TreeNode<E> getLeftChild () 
	{
		return this.left;
	}

	public TreeNode<E> getRigthChild () 
	{
		return this.right;
	}
	
	public TreeNode<E> visit () 
	{
		return this.parent;
	}

	public E getValue() 
	{
		return (E) this.value;
	}	
		
}
*/