package bst;

import java.util.ArrayList;

/**
 *
 * Exam 2a. Tree methods.
 * 
 * @author
 */

/*
 * TODO Directions: Implement the methods below. See the paper for details.
 */
public class BinarySearchTree {

	BinaryNode root;

	final BinaryNode NULL_NODE = new BinaryNode(); 

	public BinarySearchTree() {
		root = NULL_NODE;
	}

	/**
	 * Calculates the number of positive elements in the tree minus the number of negative
	 * elements in the tree.
	 * 
	 * @return the number of positives minus number of negatives in the tree
	 */
	public int numPosMinusNumNeg() {
		// DONE Write this!
		return this.root.numPosMinusNumNegHelper();
	}
	
	/**
	 * Determines whether the tree contains an element strictly within the given range, i.e.
	 * whether the tree contains some x where low < x < high. Should run in time O(height).
	 * @param low
	 * @param high
	 * @return true iff the tree contains some x where low < x < high
	 */
	public boolean containsStrictlyInRange(Integer low, Integer high) {
		// DONE Write this!
		return this.root.containsStrictlyInRangeHelper(low,high);
	}

	/**
	 * Removes all single parents (nodes with exactly one child) from the tree.
	 */
	public void removeSingleParents() {
		// TODO Write this!
		if(this.root.left!=NULL_NODE && this.root.right==NULL_NODE){
			this.root=this.root.left;
		}
		if(this.root.left==NULL_NODE && this.root.right!=NULL_NODE){
			this.root=this.root.right;
		}
		this.root.removeSingleParentsHelper();
		if(this.root.left!=NULL_NODE && this.root.right==NULL_NODE){
			this.root=this.root.left;
		}
		if(this.root.left==NULL_NODE && this.root.right!=NULL_NODE){
			this.root=this.root.right;
		}
	}
		
	
	// The next methods are used by the unit tests
	public void insert(Integer e) {
		root = root.insert(e);
	}

	/**
	 * Feel free to call from tests to use to verify the shapes of your trees
	 * while debugging. Just remove the calls you are done so the output isn't
	 * cluttered.
	 * 
	 * @return A string showing a traversal of the nodes where children are
	 *         indented so that the structure of the tree can be determined.
	 * 
	 */
	public String toIndentString() {
		return root.toIndentString("");
	}

	@Override
	public String toString() {
		return this.toArrayList().toString();
	}

	
	public ArrayList<Integer> toArrayList() {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		root.toArrayList(ar);
		return ar;
	}

	// /////////////// BinaryNode
	public class BinaryNode {
		
		public Integer data;
		public BinaryNode left;
		public BinaryNode right;
		public BinaryNode parent;

		// The rest of the methods are used by the unit tests and for debugging
		public BinaryNode() {
			this.data = null;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
		
		private void removeSingleParentsHelper2(BinaryNode binaryNode, BinaryNode right2, BinaryNode left2) {
			// TODO Auto-generated method stub.
			if(this==NULL_NODE){
				return;
			}
//			if(binaryNode == NULL_NODE || right2 == NULL_NODE || left2 == NULL_NODE){
//				return;
//			}
//			if(this.left.left==NULL_NODE && this.left.right!=NULL_NODE){
//				binaryNode.left = this.left.right;
//			}if(this.left.left!=NULL_NODE && this.left.right==NULL_NODE){
//				binaryNode.left = this.left.left;
//			}
//			if(this.right.left==NULL_NODE && this.right.right!=NULL_NODE){
//				binaryNode.right = this.right.right;
//			}if(this.right.left!=NULL_NODE && this.right.right==NULL_NODE){
//				binaryNode.right = this.right.left;
//			}
			System.out.println(this.data);
			if(binaryNode == NULL_NODE || right2 == NULL_NODE || left2 == NULL_NODE){
				return;
			}
			else if(left2.left==NULL_NODE && left2.right!=NULL_NODE){
				binaryNode.left = left2.right;
			}else if(left2.left!=NULL_NODE && left2.right==NULL_NODE){
				binaryNode.left = left2.left;
			}
			else if(right2.left==NULL_NODE && right2.right!=NULL_NODE){
				binaryNode.right = right2.right;
			}else if(right2.left!=NULL_NODE && right2.right==NULL_NODE){
				binaryNode.right = right2.left;
			}
			removeSingleParentsHelper2(binaryNode.right,binaryNode.right.right,binaryNode.right.left);
			removeSingleParentsHelper2(binaryNode.left,binaryNode.left.right,binaryNode.left.left);
			
		}
		
		public void removeSingleParentsHelper() {
			
//			this.removeSingleParentsHelper2(this,this.right,this.left);
			// TODO Auto-generated method stub.
//			if(this==NULL_NODE){
//				return;
//			}
//			if(this.left==NULL_NODE && this.right!=NULL_NODE && parent.right==this){
//				BinaryNode newNode = this.right;
//				parent.right = newNode;
//				parent.left.removeSingleParentsHelper(parent);
//				parent.right.removeSingleParentsHelper(parent);
//				return;
//				
//			}
//			if(this.left!=NULL_NODE && this.right==NULL_NODE && parent.right==this){
//				BinaryNode newNode = this.left;
//				parent.right = newNode;	
//				parent.left.removeSingleParentsHelper(parent);
//				parent.right.removeSingleParentsHelper(parent);
//				return;
//			}
//			if(this.left==NULL_NODE && this.right!=NULL_NODE && parent.left==this){
//				BinaryNode newNode = this.right;
//				parent.left = newNode;
//				parent.left.removeSingleParentsHelper(parent);
//				parent.right.removeSingleParentsHelper(parent);
//				return;
//				
//			}
//			if(this.left!=NULL_NODE && this.right==NULL_NODE && parent.left==this){
//				BinaryNode newNode = this.left;
//				parent.left = newNode;	
//				parent.left.removeSingleParentsHelper(parent);
//				parent.right.removeSingleParentsHelper(parent);
//				return;
//			}
//			else{
//				this.left.removeSingleParentsHelper(parent.left);
//				this.right.removeSingleParentsHelper(parent.right);
//			}
			
			
//			System.out.println(this.data);
			if(this==NULL_NODE){
				return;
			}
			if(this.left.left == NULL_NODE && this.left.right!=NULL_NODE){
				this.left = this.left.right; 
				this.removeSingleParentsHelper();
				return;				
			}
			if(this.left.left != NULL_NODE && this.left.right==NULL_NODE){
				this.left = this.left.left;
				this.removeSingleParentsHelper();
				return;
			}
			if(this.right.right == NULL_NODE && this.right.left!=NULL_NODE){
				this.right = this.right.left;
				this.removeSingleParentsHelper();
				return;
			}
			if(this.right.right != NULL_NODE && this.right.left==NULL_NODE){
				this.right = this.right.right;
				this.removeSingleParentsHelper();
				return;
			}
			if(this.right.right==NULL_NODE && this.left!= NULL_NODE && this.left.left==NULL_NODE && this.left.right==NULL_NODE){
				this.left.left=NULL_NODE;
				this.left.removeSingleParentsHelper();
				return;
			}
			if(this.right.right!=NULL_NODE && this.left== NULL_NODE && this.left.left==NULL_NODE && this.left.right==NULL_NODE){
				this.right.right=NULL_NODE;
				this.right.removeSingleParentsHelper();
				return;
			}
			else{
				this.left.removeSingleParentsHelper();
				this.right.removeSingleParentsHelper();
			}
		}

		


		public boolean containsStrictlyInRangeHelper(Integer low, Integer high) {
			// TODO Auto-generated method stub.
			if(this==NULL_NODE){
				return false;
			}
			if(this.data>high){
				return this.left.containsStrictlyInRangeHelper(low, high);
			}
			if(this.data<low){
				return this.right.containsStrictlyInRangeHelper(low, high);
			}
			if(this.data<high && this.data>low){
				return true;
			}
			return false;
		}

		public int numPosMinusNumNegHelper() {
			// TODO Auto-generated method stub.
			if(this ==NULL_NODE){
				return 0;
			}
			if(this.data>0){
				return 1 + this.left.numPosMinusNumNegHelper()+this.right.numPosMinusNumNegHelper();
			}
			if(this.data==0){
				return 0;
			}
			else {
				return -1 + this.left.numPosMinusNumNegHelper()+this.right.numPosMinusNumNegHelper();
			}
		}

		public BinaryNode(Integer element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		public BinaryNode insert(Integer e) {
			if (this == NULL_NODE) {
				return new BinaryNode(e);
			} else if (e < data) {
				left = left.insert(e);
			} else if (e > data) {
				right = right.insert(e);
			} else {
				// do nothing
			}
			return this;
		}
		
		public void toArrayList(ArrayList<Integer> ar) {
			if (this == NULL_NODE) {
				return;
			}
			left.toArrayList(ar);
			ar.add(data);
			right.toArrayList(ar);
		}


		public String toIndentString(String indent) {
			if (this == NULL_NODE) {
				return indent + "NULL\n";
			}
			String myInfo = indent + String.format("%d\n", this.data);
			return myInfo + this.left.toIndentString(indent + "  ") + this.right.toIndentString(indent + "  ");
		}
	}

}