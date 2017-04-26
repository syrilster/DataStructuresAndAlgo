package Tree.BinaryTree;

import Tree.BinarySearchTree.BinarySearchTree;

/**
 * If we do a level order traversal of tree such that the left most node of each level is visited before all other nodes in that level then all we
 * need to do is to print out the first visited node at each level to print the left view of tree. This can be done by doing a level order traversal
 * from left end to right end and keeping track of max-level seen so far to find out when the new level starts. As soon as we find out that the new
 * level has started, we print out the current node that is being visited.
 */
public class LeftViewOfTree {
	public static int maxLevelSeenSoFar = -1;

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
		printLeftView(tree.root, 0);
	}

	private static void printLeftView(Tree.BinarySearchTree.Node node, int currentLevel) {
		if (node == null) {
			return;
		}
		if (currentLevel > maxLevelSeenSoFar) {
			System.out.print(node.getData() + " ");
			maxLevelSeenSoFar = currentLevel;
		}
		printLeftView(node.left, currentLevel + 1);
		printLeftView(node.right, currentLevel + 1);
	}
}
