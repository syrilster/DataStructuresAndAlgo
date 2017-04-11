package Tree.BinaryTree;

/**
 * @author ssadasivan
 * @since 4/11/2017.
 */
public class BinaryTree {
	private Node root;

	public Node getRoot() {
		return root;
	}

	class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
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

		public Node() {
			super();
		}

		public Node(int data) {
			super();
			this.data = data;
		}

		@Override
		public String toString() {
			return data + "";
		}
	}

	/*
     * Create a sample tree
     *              1
     *      2               3
     * 4        5       6       7
     *
     */
	public void createSampleTree() {
		root = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5, null, null));
	}

	/*
	 * Print preorder traversal
	 */
	public void printPreorder() {
		printPreorder(root);
	}

	private void printPreorder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.getData() + " ");
		printPreorder(root.getLeft());
		printPreorder(root.getRight());
	}
}
