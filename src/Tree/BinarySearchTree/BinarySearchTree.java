package Tree.BinarySearchTree;

/**
 * @author ssadasivan
 * @since 4/8/2017.
 */
public class BinarySearchTree {
	public Node root;

	public void insert(int data) {
		root = put(root, data);
	}

	private Node put(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		if (data <= root.getData()) {
			root.left = put(root.left, data);
		} else {
			root.right = put(root.right, data);
		}
		return root;
	}

	public static void printInorder(Node root) {
		if(root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.getData() + " ");
		printInorder(root.right);
	}

	@Override
	public String toString() {
		return root.getData()+" ";
	}
}
