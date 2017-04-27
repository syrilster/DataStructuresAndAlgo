package Tree.BinaryTree;

import Tree.BinarySearchTree.LowestCommonAncestorBST;

/**
 * @author ssadasivan
 * @since 4/25/2017.
 */
public class LowestCommonAncestorBT {
	Node root;

	public static void main(String[] args) {
		LowestCommonAncestorBT tree = new LowestCommonAncestorBT();
		tree.root = new Node(10);
		tree.root.left = new Node(4);
		tree.root.right = new Node(30);
		tree.root.right.right = new Node(60);
		tree.root.left.right = new Node(8);
		tree.root.right.left = new Node(25);
		tree.root.right.left.right = new Node(28);
		tree.root.left.right.left = new Node(6);
		tree.root.left.right.right = new Node(9);
		tree.root.right.right.right = new Node(78);
		tree.root.left.left = new Node(2);
		Node nodeOne, nodeTwo;
		nodeOne = tree.root.left.left;
		nodeTwo = tree.root.left.right.right;
		System.out.println(lowestCommonAncestor(tree.root, nodeOne, nodeTwo).getData());
	}

	private static Node lowestCommonAncestor(Node root, Node nodeOne, Node nodeTwo) {
		if (root == null)
			return root;
		//Start from root to check if it has one of the node. If yes then return root
		if ((root.getData() == nodeOne.getData()) || (root.getData() == nodeTwo.getData())) {
			return root;
		}
		root.left = lowestCommonAncestor(root.left, nodeOne, nodeTwo);
		root.right = lowestCommonAncestor(root.right, nodeOne, nodeTwo);
		//If both left and right are not null then return root
		if (root.left != null && root.right != null) {
			return root;
		}
		//Else return the not null node
		return root.left != null ? root.left : root.right;
	}
}
