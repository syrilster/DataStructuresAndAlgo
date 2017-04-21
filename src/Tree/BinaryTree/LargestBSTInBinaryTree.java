package Tree.BinaryTree;

/**
 * Created by Syril on 20-04-2017.
 */
public class LargestBSTInBinaryTree {
	Node root;

	public static void main(String args[]) {
		int min = 0, max = 0, maxBSTSize = 0;
		boolean isBST = false;
		LargestBSTInBinaryTree tree = new LargestBSTInBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(7);
		//tree.root.right = new Node(12);
		tree.root.left.left = new Node(6);
		tree.root.left.right = new Node(9);
		//tree.root.right.left = new Node(9);
		//tree.root.right.right = new Node(14);
		//tree.root.right.right.left = new Node(13);
		//tree.root.right.right.right = new Node(16);
		System.out.println(tree.largestBST(tree.root));
	}

	public int largestBST(Node root) {
		MinMax m = largest(root);
		return m.size;
	}

	private MinMax largest(Node root) {
		//if root is null return min as Integer.MAX and max as Integer.MIN
		if (root == null) {
			return new MinMax();
		}
		//post order traversal of tree. First visit left and right then
		//use information of left and right to calculate largest BST.
		MinMax leftMinMax = largest(root.left);
		MinMax rightMinMax = largest(root.right);
		MinMax m = new MinMax();
		//if either of left or right subtree says its not BST or the data
		//of this node is not greater/equal than max of left and less than min of right
		//then subtree with this node as root will not be BST.
		//Return false and max size of left and right subtree to parent
		if (leftMinMax.isBST == false || rightMinMax.isBST == false || (leftMinMax.max > root.getData() || rightMinMax.min <= root.getData())) {
			m.isBST = false;
			m.size = Math.max(leftMinMax.size, rightMinMax.size);
			return m;
		}
		//if we reach this point means subtree with this node as root is BST.
		//Set isBST as true. Then set size as size of left + size of right + 1.
		//Set min and max to be returned to parent.
		m.isBST = true;
		m.size = leftMinMax.size + rightMinMax.size + 1;
		//if root.left is null then set root.getData() as min else
		//take min of left side as min
		m.min = root.left != null ? leftMinMax.min : root.getData();
		//if root.right is null then set root.getData() as max else
		//take max of right side as max.
		m.max = root.right != null ? rightMinMax.max : root.getData();
		return m;
	}
}

/**
 * Object of this class holds information which child passes back
 * to parent node.
 */
class MinMax {
	int min;
	int max;
	boolean isBST;
	int size;

	MinMax() {
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		isBST = true;
		size = 0;
	}
}
