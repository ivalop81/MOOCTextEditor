package spelling;

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
		this.left = null;
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

	public TreeNode<E> getLeftChild() 
	{
		return this.left;
	}

	public TreeNode<E> getRightChild() 
	{
		return this.right;
	}
	
	public TreeNode<E> visit() 
	{
		return this.parent;
	}

	public E getValue() 
	{
		return (E) this.value;
	}	

}
