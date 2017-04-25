package Tree.BinarySearchTree;

import Tree.BinaryTree.Node;

/**
 * @author ssadasivan
 * @since 4/25/2017.
 */
public class LowestCommonAncestorBST {
	Node root;

	public static void main(String[] args) {
		LowestCommonAncestorBST tree = new LowestCommonAncestorBST();
		tree.root = new Node(3);
		tree.root.left = new Node(6);
		tree.root.right = new Node(8);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(11);
		tree.root.left.right.left = new Node(9);
		tree.root.left.right.right = new Node(5);
		tree.root.right.right = new Node(13);
		tree.root.right.right.left = new Node(7);
		Node nodeOne, nodeTwo;
		nodeOne = tree.root.right;
		nodeTwo = tree.root.right.right.left;
		System.out.println(lowestCommonAncestor(tree.root, nodeOne, nodeTwo).getData());
	}

	private static Node lowestCommonAncestor(Node root, Node nodeOne, Node nodeTwo) {
		if (root == null)
			return null;
		// If either nodeOne or nodeTwo matches with root's key, report the presence by returning root
		if (root.getData() == nodeOne.getData() || root.getData() == nodeTwo.getData()) {
			return root;
		}
		Node left = lowestCommonAncestor(root.left, nodeOne, nodeTwo);
		Node right = lowestCommonAncestor(root.right, nodeOne, nodeTwo);
		// If left and right returned a not null value then this node itself is the LCA
		if (left != null && right != null) {
			return root;
		}
		//Else return the not null node
		return left != null ? left : right;
	}
}
