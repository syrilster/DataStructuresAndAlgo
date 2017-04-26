package Tree.BinarySearchTree;

/**
 * @author ssadasivan
 * @since 4/26/2017.
 */
public class DeleteBSTNode {
	Node root;

	public static void main(String[] args) {
		DeleteBSTNode tree = new DeleteBSTNode();
		tree.root = new Node(20);
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		tree.root.left.left = new Node(8);
		tree.root.left.right = new Node(15);
		tree.root.left.left.left = new Node(7);
		tree.root.right.left = new Node(25);
		BinarySearchTree.printInorder(tree.root);
		Node newRoot = deleteNode(tree.root, 10);
		System.out.println("\nAfter Deletion ");
		BinarySearchTree.printInorder(newRoot);
	}

	public static Node deleteNode(Node root, int key) {
		if (root == null)
			return root;
		if (key < root.getData()) {
			root.left = deleteNode(root.left, key);
		} else if (key < root.getData()) {
			root.right = deleteNode(root.right, key);
		} else if (root.left != null && root.right != null) {
			root.setData(findMin(root.right).getData());
			root.right = deleteNode(root.right, key);
		} else {
			root = root.left != null ? root.left : root.right;
		}
		return root;
	}

	public static Node findMin(Node root) {
		if (root == null)
			return root;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
}
