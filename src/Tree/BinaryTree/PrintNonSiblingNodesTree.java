package Tree.BinaryTree;

import Tree.BinarySearchTree.BinarySearchTree;

/**
 * Given a binary tree, write a program to print all nodes of that tree which do not have sibling nodes.
 * For example in the following tree, nodes 6, 8, 5, 7 are such nodes because for all of these nodes parent node has only one child.
 */
public class PrintNonSiblingNodesTree {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(20);
		tree.insert(10);
		tree.insert(30);
		tree.insert(40);
		tree.insert(25);
		tree.insert(7);
		tree.insert(15);
		tree.insert(8);
		tree.insert(9);
		printNonSiblingNodesBST(tree.root);
	}

	private static void printNonSiblingNodesBST(Tree.BinarySearchTree.Node node) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right != null) {
			System.out.print(node.right.getData() + " ");
		}
		if (node.right == null && node.left != null) {
			System.out.print(node.left.getData() + " ");
		}
		printNonSiblingNodesBST(node.left);
		printNonSiblingNodesBST(node.right);
	}
}
