import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 
 * Implementation of most of the Set interface operations using a Binary Search
 * Tree
 *
 * @author Matt Boutell and Hussein Alawami.
 * @param <T>
 */

public class BinarySearchTree<T extends Comparable<T>> {
	private BinaryNode root;

	private int concurrentTime = 0;
	// Most of you will prefer to use NULL NODES once you see how to use them.
	private final BinaryNode NULL_NODE = new BinaryNode();

	public BinarySearchTree() {
		root = NULL_NODE;
	}

	// For manual tests only
	void setRoot(BinaryNode n) {
		this.root = n;
	}

	// Not private, since we need access for manual testing.
	class BinaryNode {
		private T data;
		private BinaryNode left;
		private BinaryNode right;

		public BinaryNode() {
			this.data = null;
			this.left = null;
			this.right = null;
		}

		public BinaryNode(T element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		public T getData() {
			return this.data;
		}

		public BinaryNode getLeft() {
			return this.left;
		}

		public BinaryNode getRight() {
			return this.right;
		}

		// For manual testing
		public void setLeft(BinaryNode left) {
			this.left = left;
		}

		public void setRight(BinaryNode right) {
			this.right = right;
		}

		public boolean containsNonBST(T item) {
			if (this == NULL_NODE) {
				return false;
			}
			if (this.data.equals(item)) {
				return true;
			}
			return this.left.containsNonBST(item) || this.right.containsNonBST(item);
			// or return this.data.equals(item) ||
			// this.left.containsNonBST(item) || this is more efficient
			// this.right.containsNonBST(item); and delete the second if
			// statement
		}

		public int height() {
			if (this == NULL_NODE) {
				return -1;
			}
			return Math.max(left.height(), right.height()) + 1;
		}

		public int size() {
			if (this == NULL_NODE) {
				return 0;
			}
			return left.size() + right.size() + 1;
		}

		public String toString() {
			if (this == NULL_NODE) {
				return "";
			}
			return this.left.toString() + this.data + ", " + this.right.toString();
		}

		public void toArrayList(ArrayList list) {
			if (this == NULL_NODE) {
				return;
			}
			// Another way of implementing it and returns arraylist
			// else if(this.left == NULL_NODE && this.right == NULL_NODE){
			// list.add(this.data);
			// }
			// this.left.toArrayList(list);
			// if(this.left!=NULL_NODE || this.right != NULL_NODE){
			// list.add(this.data);
			// }
			// this.right.toArrayList(list);
			// return list;
			left.toArrayList(list);
			list.add(this.data);
			right.toArrayList(list);
		}

		public BinarySearchTree<T>.BinaryNode addElements(Stack<BinarySearchTree<T>.BinaryNode> stack) {
			// TODO Auto-generated method stub.
			if (this == NULL_NODE) {
				return NULL_NODE;
			}
			if (this.left != NULL_NODE && this.right != NULL_NODE) {
				BinarySearchTree<T>.BinaryNode node = stack.pop();
				stack.push(this.right);
				stack.push(this.left);
				return node;
			}
			return right;
		}

		public BinaryNode insertHelper(T item) {
			if (this == NULL_NODE) {
				return new BinaryNode(item);
			}
			if (item.compareTo(this.data) > 0) {
				right = right.insertHelper(item);
			}

			if (item.compareTo(this.data) < 0) {
				left = left.insertHelper(item);
			}
			return this;
		}

		public BinaryNode removeHelper(T item) {
			// TODO Auto-generated method stub.
			if (item == null) {
				throw new IllegalArgumentException();
			}

			if (this.data.equals(item)) {
				if (this.left == NULL_NODE) {
					return this.right;
				}
				if (this.right == NULL_NODE) {
					return this.left;
				}
				if (this.left.right == NULL_NODE) {
					this.left.right = this.right;
					return this.left;
				}
				BinaryNode temp = this;
				BinaryNode newNode = this.left;
				while (newNode.right != NULL_NODE) {
					temp = newNode;
					newNode = newNode.right;
				}
				temp.right = newNode.left;
				newNode.right = this.right;
				newNode.left = this.left;
				return newNode;
			}
			if (item.compareTo(this.data) < 0) {
				this.left = this.left.removeHelper(item);
			} else if (item.compareTo(this.data) > 0) {
				this.right = this.right.removeHelper(item);
			}
			return this;
		}

		public boolean contains(T item) {
			// TODO Auto-generated method stub.
			if (item.compareTo(this.data) == 0) {
				return true;
			}
			if (item.compareTo(this.data) > 0 && this.right != NULL_NODE) {
				return this.right.contains(item);
			}
			if (item.compareTo(this.data) < 0 && this.left != NULL_NODE) {
				return this.left.contains(item);
			}

			return false;

		}
	}

	/**
	 * 
	 * Function to get the size of the tree
	 *
	 * @return the size of the tree an integer
	 */
	
	public int size() {
		// TODO Auto-generated method stub.
		return root.size();
	}
	
	/**
	 * 
	 * Function to get the height of the tree
	 *
	 * @return the height of the tree an integer
	 */

	public int height() {
		return root.height();
	}

	/**
	 * 
	 * Function to check if an item exists in the BinaryTree
	 *
	 * @return true if it exists or false otherwise
	 */
	
	public boolean containsNonBST(T item) {
		return root.containsNonBST(item);
	}

	/**
	 * 
	 * Function to turn the tree to a string tree
	 *
	 * @return a string that represents the elements of the tree
	 */
	
	public String toString() {
		String output = "[";
		output += this.root.toString();
		if (output.length() > 3) {
			output = output.substring(0, output.length() - 2);
		}
		output += "]";
		return output;
	}

	/**
	 * 
	 * Function to turn the tree to an arraylist tree
	 *
	 * @return an arraylist that represents the elements of the tree
	 */
	
	public ArrayList<BinarySearchTree<T>.BinaryNode> toArrayList() {
		ArrayList<BinarySearchTree<T>.BinaryNode> output = new ArrayList<>();
		this.root.toArrayList(output);
		return output;
	}
	
	/**
	 * 
	 * Function to turn the tree to an array tree
	 *
	 * @return an array that represents the elements of the tree
	 */

	public Object[] toArray() {
		ArrayList<BinarySearchTree<T>.BinaryNode> arrayList = toArrayList();
		return arrayList.toArray();
	}
	
	/**
	 * 
	 * Function to add an element to the tree
	 *
	 * @return a null node
	 */

	public BinarySearchTree<T>.BinaryNode addElements(Stack<BinarySearchTree<T>.BinaryNode> stack) {
		// TODO Auto-generated method stub.
		if (this.root != NULL_NODE) {
			stack.push(root);
		}
		this.root.addElements(stack);
		return NULL_NODE;
	}
	// TODO: Implement your 3 iterator classes here, plus any other inner helper
	// classes you'd like.

	// Inefficient iterator because we recreate the arraylist, when we pass it
	// we pass a new arraylist
	// and if we use the iterator a lot that vecome very inefficient.

	
	/**
	 * 
	 * In-Order traversal iterator
	 *
	 * 
	 */
	
	public class iterator implements Iterator<T> {

		Stack<BinarySearchTree<T>.BinaryNode> stack;
		int time = concurrentTime;
		int length = 0;
		boolean isTrue = false;
		T variable;

		public iterator(BinarySearchTree<T>.BinaryNode root) {
			// TODO Auto-generated constructor stub.
			stack = new Stack<>();
			while (root != NULL_NODE) {
				stack.push(root);
				root = root.left;
			}
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub.
			return !this.stack.isEmpty();
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub.
			this.isTrue = true;
			this.length = 0;
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			if (this.time != concurrentTime) {
				throw new ConcurrentModificationException();
			}
			BinarySearchTree<T>.BinaryNode newNode = this.stack.pop();
			T result = newNode.data;
			if (newNode.right != NULL_NODE) {
				newNode = newNode.right;
				while (newNode != NULL_NODE) {
					this.stack.push(newNode);
					newNode = newNode.left;
				}
			}
			variable = result;
			return result;

		}

		public void remove() {
			length++;
			if (length > 1) {
				throw new IllegalStateException();
			}
			if (this.isTrue == false) {
				throw new IllegalStateException();
			}
			BinarySearchTree.this.remove(variable);
		}

	}
	
	/**
	 * 
	 * Pre-Order traversal iterator
	 *
	 * 
	 */

	public class preOrderIterator implements Iterator<T> {

		Stack<BinarySearchTree<T>.BinaryNode> stack;
		int time = concurrentTime;
		int length = 0;
		boolean isTrue = false;
		T variable;

		public preOrderIterator() {
			// TODO Auto-generated constructor stub.
			stack = new Stack<BinaryNode>();
			if (root != NULL_NODE) {
				stack.push(root);
			}
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub.
			return !this.stack.isEmpty();
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub.
			this.isTrue = true;
			this.length = 0;
			if (this.time != concurrentTime) {
				throw new ConcurrentModificationException();
			}
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			BinarySearchTree<T>.BinaryNode newNode = this.stack.pop();
			T result = newNode.data;
			if (newNode.right != NULL_NODE) {
				this.stack.push(newNode.right);
			}
			if (newNode.left != NULL_NODE) {
				this.stack.push(newNode.left);
			}
			variable = newNode.data;
			return result;

		}

		public void remove() {
			length++;
			if (length > 1) {
				throw new IllegalStateException();
			}
			if (this.isTrue == false) {
				throw new IllegalStateException();
			}
			BinarySearchTree.this.remove(variable);
		}

	}
	
	/**
	 * 
	 * An iterator that loops through the arraylist elements
	 *
	 * 
	 */

	public class inefficientIterator implements Iterator<T> {

		ArrayList<BinarySearchTree<T>.BinaryNode> aList;
		int currentIndex;
		int time = concurrentTime;

		public inefficientIterator(BinarySearchTree<T> binarySearchTree) {
			// TODO Auto-generated constructor stub.
			aList = binarySearchTree.toArrayList();
			currentIndex = 0;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub.
			return (currentIndex < aList.size());
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub.
			if (currentIndex >= aList.size()) {
				throw new NoSuchElementException();
			}
			if (this.time != concurrentTime) {
				throw new ConcurrentModificationException();
			}
			return (T) aList.get(currentIndex++);
		}

	}

	/**
	 * 	
	 * A function to check if the tree is empty
	 *
	 * @return true if empty or false otherwise
	 */
	
	
	public Boolean isEmpty() {
		// TODO Auto-generated method stub.
		return this.root == NULL_NODE;
	}

	/**
	 * 	
	 * Create a new inefficient iterator
	 *
	 * @return iterator
	 */
	
	public Iterator inefficientIterator() {
		// TODO Auto-generated method stub.
		return new inefficientIterator(this);
	}
	
	/**
	 * 	
	 * Create a new pre-order iterator
	 *
	 * @return iterator
	 */

	public Iterator preOrderIterator() {
		// TODO Auto-generated method stub.
		return new preOrderIterator();
	}

	
	/**
	 * 	
	 * Create a new in-order iterator
	 *
	 * @return iterator
	 */
	public Iterator iterator() {
		// TODO Auto-generated method stub.
		return new iterator(root);
	}

	/**
	 * 
	 * Insert an element into the binary search tree
	 *
	 * @param item
	 * @return true if inserted or false otherwise
	 */
	
	public boolean insert(T item) {
		// TODO Auto-generated method stub.
		if (item == null) {
			throw new IllegalArgumentException();
		}
		if (this.contains(item)) {
			return false;
		}
		this.concurrentTime++;
		root = this.root.insertHelper(item);
		return true;
	}

	
	/**
	 * 
	 * Remove an element from the binary search tree
	 *
	 * @param item
	 * @return true if removed or false otherwise
	 */
	
	public boolean remove(T item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		if (!this.contains(item)) {
			return false;
		}
		this.concurrentTime++;
		root = this.root.removeHelper(item);
		return true;
	}

	/**
	 * 
	 * Check if the binary tree contains an element
	 *
	 * @param item
	 * @return true if it is in the tree or false otherwise
	 */
	
	public boolean contains(T item) {
		if (this.root == NULL_NODE) {
			return false;
		}
		return this.root.contains(item);
	}

}