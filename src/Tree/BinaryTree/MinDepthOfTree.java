package Tree.BinaryTree;

import Tree.BinarySearchTree.BinarySearchTree;

/**
 * @author ssadasivan
 * @since 4/10/2017.
 */
public class MinDepthOfTree {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(20);
		tree.insert(10);
		tree.insert(30);
		tree.insert(7);
		tree.insert(15);
		tree.insert(8);
		tree.insert(9);
		System.out.println("Min Depth of this tree : " + getMinDepth(tree.root));
	}

	private static int getMinDepth(BinarySearchTree.Node root) {
		if (root == null) {
			return 0;
		}
		//isLeaf ?
		if (root.getLeft() == null || root.getRight() == null) {
			return 1;
		}
		int leftDepth = root.getLeft() != null ? getMinDepth(root.getLeft()) : Integer.MAX_VALUE;
		int rightDepth = root.getRight() != null ? getMinDepth(root.getRight()) : Integer.MAX_VALUE;
		return 1 + Math.min(leftDepth, rightDepth);
	}
}
