package Tree.BinaryTree;

/**
 * @author ssadasivan
 * @since 4/11/2017.
 */
public class CheckTreeIsBST {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createSampleTree();
		System.out.println(isBSTUtil(tree.getRoot()));
	}

	private static boolean isBSTUtil(BinaryTree.Node root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBSTUtil(BinaryTree.Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.getData() < min || node.getData() > max) {
			return false;
		}
		return (isBSTUtil(node.getLeft(), min, node.getData() - 1) && isBSTUtil(node.getRight(), node.getData() + 1, max));
	}
}
