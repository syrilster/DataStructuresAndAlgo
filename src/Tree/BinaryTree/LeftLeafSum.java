package Tree.BinaryTree;

import Tree.BinarySearchTree.BinarySearchTree;

/**
 * The solution to this problem is as simple as traversing the complete tree using any traversal method in order to visit all nodes and checking if a
 * node has a left-child which is also a leaf node. If that is the case then add that left-child's value to the sum.
 */
public class LeftLeafSum {
	private static int leftLeavesSum = 0;

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(20);
		tree.insert(10);
		tree.insert(30);
		tree.insert(15);
		tree.insert(8);
		tree.insert(7);
		tree.insert(25);
		findLeftLeavesSum(tree.root);
		System.out.println(leftLeavesSum);
	}

	private static void findLeftLeavesSum(Tree.BinarySearchTree.Node root) {
		if (root == null) {
			return;
		}
		if (isLeafNode(root.left)) {
			leftLeavesSum += root.left.getData();
		}
		findLeftLeavesSum(root.left);
		findLeftLeavesSum(root.right);
	}

	private static boolean isLeafNode(Tree.BinarySearchTree.Node node) {
		if (node == null) {
			return false;
		}
		if (node.left == null && node.right == null) {
			return true;
		}
		return false;
	}
}
