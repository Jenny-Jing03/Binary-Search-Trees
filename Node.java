
/**
 * generate the node of binary tree, that contains left child, right child, its
 * parent, and data
 * 
 * @author Jenny
 *
 */
public class Node<T> {

	// fields
	private T data; // the data of the node
	private Node<T> left; // the left child of the node
	private Node<T> right; // the right child of the node
	private Node<T> parent; // the parent node

	// constructor
	/**
	 * build up a node without children and parent
	 * 
	 * @param data
	 */
	public Node(T data) {
		// set the data field
		this.data = data;
	}

	/**
	 * @return the left node
	 */
	public Node<T> getLeft() {
		return this.left;
	}

	/**
	 * @return the right node
	 */
	public Node<T> getRight() {
		return this.right;
	}

	/**
	 * @return the parent node
	 */
	public Node<T> getParent() {
		return this.parent;
	}

	/**
	 * @return the data of this node
	 */
	public T getData() {
		return this.data;
	}

	/**
	 * set the left child node
	 * 
	 * @param left the data of left child node
	 */
	public void setLeft(Node<T> left) {
		this.left = left;
	}

	/**
	 * set the right child node
	 * 
	 * @param right the data of the right child node
	 */
	public void setRight(Node<T> right) {
		this.right = right;
	}

	/**
	 * set the parent node
	 * 
	 * @param parent the parent node
	 */
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	/**
	 * return the information of current node
	 */
	@Override
	public String toString() {
		String information = "";
		// get the left child node information
		information += "left: ";
		if (this.left != null) {
			information += this.left.getData();
		}

		// get the parent node information
		information += "\nparent: ";
		if (this.parent != null) {
			information += this.parent.getData();
		}

		// get the right child node information
		information += "\nright: ";
		if (this.right != null) {
			information += this.right.getData();
		}

		// get the current node information
		information += "\ndata: ";
		if (this.data != null) {
			information += this.data;
		}

		return information;
	}

}
