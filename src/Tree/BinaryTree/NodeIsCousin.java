package Tree.BinaryTree;

import Tree.BinarySearchTree.BinarySearchTree;

/**
 * Created by Syril on 12-04-2017.
 */
public class NodeIsCousin {
	Node root;

	// Recursive function to check if two Nodes are
	// siblings
	boolean isSibling(Node root, Node nodeOne, Node nodeTwo)
	{
		// Base case
		if (root == null)
			return false;

		return ((root.left == nodeOne && root.right == nodeTwo) ||
				(root.left == nodeTwo && root.right == nodeOne) ||
				isSibling(root.left, nodeOne, nodeTwo) ||
				isSibling(root.right, nodeOne, nodeTwo));
	}

	// Recursive function to find level of Node 'ptr' in
	// a binary tree
	int level(Node root, Node node, int lev)
	{
		// base cases
		if (root == null)
			return 0;

		if (root == node)
			return lev;

		// Return level if Node is present in left subtree
		int level = level(root.left, node, lev + 1);
		if (level != 0)
			return level;

		// Else search in right subtree
		return level(root.right, node, lev + 1);
	}

	// Returns 1 if a and b are cousins, otherwise 0
	boolean isCousin(Node root, Node nodeOne, Node nodeTwo)
	{
		/*1. The two Nodes should be on the same level
		       in the binary tree.
		2. The two Nodes should not be siblings (means
		   that they should not have the same parent Node).*/
		return ((level(root, nodeOne, 1) == level(root, nodeTwo, 1)) &&
				(!isSibling(root, nodeOne, nodeTwo)));
	}

	//Driver program to test above functions
	public static void main(String args[])
	{
		NodeIsCousin tree = new NodeIsCousin();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.right = new Node(15);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);

		Node Node1, Node2;
		Node1 = tree.root.left.left;
		Node2 = tree.root.right.right;
		if (tree.isCousin(tree.root, Node1, Node2))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
