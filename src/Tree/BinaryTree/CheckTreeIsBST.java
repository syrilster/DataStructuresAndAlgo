package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ssadasivan
 * @since 4/11/2017.
 */
public class CheckTreeIsBST {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createSampleTree();
		System.out.println(checkBST(tree.getRoot()));
	}

	private static boolean checkBST(BinaryTree.Node root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean checkBST(BinaryTree.Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.getData() < min || node.getData() > max) {
			return false;
		}
		return (checkBST(node.getLeft(), min, node.getData() - 1) && checkBST(node.getRight(), node.getData() + 1, max));
	}
}
