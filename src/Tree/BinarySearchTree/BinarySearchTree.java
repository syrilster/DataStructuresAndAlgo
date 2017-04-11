package Tree.BinarySearchTree;

/**
 * @author ssadasivan
 * @since 4/8/2017.
 */
public class BinarySearchTree {
	public Node root;

	public class Node {
		private Node left;
		private Node right;
		private int data;

		public Node(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
	}

	public void insert(int data) {
		root = put(root, data);
	}

	private Node put(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		if (data <= root.data) {
			root.left = put(root.left, data);
		} else {
			root.right = put(root.right, data);
		}
		return root;
	}

	@Override
	public String toString() {
		return root.data+" ";
	}
}
