
/**
 * containing the operations of BST
 * 
 * @author Jenny
 *
 */
public class BinarySearchTree {

	// field
	Node<Integer> root; // the root node

	// constructor
	/**
	 * @param root the root node of the tree
	 */
	public BinarySearchTree(Node<Integer> root) {
		this.root = root;
	}

	/**
	 * @param item
	 * @return whether the item is contained in the tree
	 */
	public boolean contains(int item) {
		// check whether the tree is empty
		if (this.isEmpty()) {
			return false;
		}

		Node<Integer> temp = this.root;
		while (temp != null) {
			// if the item is equaled with current node
			if (temp.getData() == item) {
				return true;
			}
			// if item in the left of current node
			else if (temp.getData() > item) {
				temp = temp.getLeft();
			}
			// if item in the right of current node
			else {
				temp = temp.getRight();
			}
		}
		return false;
	}

	/**
	 * insert an item into correct position
	 * 
	 * @param item
	 */
	public void insert(int item) {
		// TODO
	}

	public void add(int item) {
		// TODO
	}

	/**
	 * @return true is this tree do not contain any node; else, return false
	 */
	public boolean isEmpty() {
		return this.root == null;
	}

	/**
	 * remove the item from the tree
	 * 
	 * @param item a valid item that appear in the tree
	 */
	public void remove(int item) {
		// check whether the tree is empty
		if (this.isEmpty()) {
			return;
		}

		// reach the position of item
		Node<Integer> temp = this.root;
		while (temp.getData() != null) {
			// if the item is equaled with current node
			if (temp.getData() == item) {
				break;
			}
			// if item in the left of current node
			else if (temp.getData() > item) {
				temp = temp.getLeft();
			}
			// if item in the right of current node
			else {
				temp = temp.getRight();
			}
		}
		
		// check the type of node
		// if it's leaf
		if (temp.getLeft() == null && temp.getRight() == null) {
			// check whether it is on the left or right
			if (temp.getParent().getLeft() != null && temp.getParent().getLeft().equals(temp)) {
				// break the link between current node and its parent
				temp.getParent().setLeft(null);
			} else {
				// break the link between cur node and its parent
				temp.getParent().setRight(null);
			}
		}
		// if it has one left child
		else if (temp.getRight() == null) {
			// check whether current node is on the left or right
			if (temp.getParent().getLeft() != null && temp.getParent().getLeft().equals(temp)) {
				// adjusting the link to pass current node
				temp.getParent().setLeft(temp.getLeft());
			} else {
				// adjusting the link to pass current node
				temp.getParent().setRight(temp.getLeft());
			}
			// set the parent of left child as cur's parent
			temp.getLeft().setParent(temp.getParent());
		}
		// if it has one right child
		else if (temp.getLeft() == null) {
			// check whether current node is on the left or right
			if (temp.getParent().getLeft() != null && temp.getParent().getLeft().equals(temp)) {
				// adjusting the link to pass current node
				temp.getParent().setLeft(temp.getRight());
			} else {
				// adjusting the link to pass current node
				temp.getParent().setRight(temp.getRight());
			}
			// set the parent of right child as cur's parent
			temp.getRight().setParent(temp.getParent());

		}
		// if it has two children
		else {
			// save current node
			Node<Integer> change = temp;

			// find its successor
			// start at the right of current node
			temp = temp.getRight();
			// keep searching on the left of the current node
			while (temp.getLeft() != null) {
				temp = temp.getLeft();
			}

			// set the successor at the position of item
			// check whether it is on the left or right
			if (change.getParent().getLeft() != null && change.getParent().getLeft().equals(change)) {
				// adjusting the link form parent to child
				change.getParent().setLeft(temp);
			} else {
				// adjusting the link from parent to child
				change.getParent().setRight(temp);
			}
			// adjusting the link from child to parent
			temp.setParent(change.getParent());
			temp.setLeft(change.getLeft());
			change.getLeft().setParent(temp);

		}
	}

	/**
	 * @return the information of the tree
	 */
	public String toString() {
		// check whether the tree is empty
		if (this.isEmpty()) {
			return "The tree is empty";
		}
		
		return toString_helper(this.root);
	}

	/**
	 * @param current the current node
	 * @return the information of the subtree from current node
	 */
	private String toString_helper(Node<Integer> current) {
		// base case
		if (current == null) {
			return "";
		}

		// recursive root
		return toString_helper(current.getLeft()) + current.getData() + "\n" + toString_helper(current.getRight());
	}
}
