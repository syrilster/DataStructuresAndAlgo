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
		tree.root.left = new Node(-10);
		tree.root.right = new Node(30);
		tree.root.right.right = new Node(60);
		tree.root.left.right = new Node(8);
		tree.root.right.left = new Node(25);
		tree.root.right.left.right = new Node(28);
		tree.root.right.right = new Node(60);
		tree.root.left.right.left = new Node(6);
		tree.root.left.right.right = new Node(9);
		tree.root.right.right.right = new Node(78);
		Node nodeOne, nodeTwo;
		nodeOne = tree.root.right.left.right;
		nodeTwo = tree.root.right.right.right;
		System.out.println(lowestCommonAncestor(tree.root, nodeOne, nodeTwo).getData());
	}

	private static Node lowestCommonAncestor(Node root, Node nodeOne, Node nodeTwo) {
		return null;
	}
}
