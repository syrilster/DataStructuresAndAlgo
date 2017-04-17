package Tree.BinaryTree;

/**
 * @author ssadasivan
 * @since 4/17/2017.
 */
public class MirrorTree {
	public Node root;

	/*
     * Create a sample tree
     *                1
     *          2           3
     *      4           5
     *
     */
	public static Node createSampleTree() {
		CheckBTIdentical tree = new CheckBTIdentical();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.right.left = new Node(5);
		return tree.root;
	}

	public static void main(String[] args) {
		MirrorTree tree = new MirrorTree();
		tree.root = tree.createSampleTree();
		inorder(tree.root);
		convertToMirror(tree.root);
		System.out.println("\n");
		inorder(tree.root);
	}

	private static void convertToMirror(Node root) {
		if (root == null)
			return;
		convertToMirror(root.left);
		convertToMirror(root.right);

		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	private static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.getData() + " ");
		inorder(root.right);
	}
}
