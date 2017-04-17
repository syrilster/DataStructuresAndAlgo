package Tree.BinaryTree;

/**
 * @author ssadasivan
 * @since 4/17/2017.
 */
public class CheckBTIdentical {
	Node root;

	public static Node createSampleTree() {
		CheckBTIdentical tree = new CheckBTIdentical();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		return tree.root;
	}

	public static Node createSampleTreeTwo() {
		CheckBTIdentical tree = new CheckBTIdentical();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(10);
		return tree.root;
	}

	public static void main(String[] args) {
		Node t1 = createSampleTree();
		Node t2 = createSampleTreeTwo();
		System.out.println(areIdenticalTrees(t1, t2) ? "The trees are identical" : " The trees are not identical");
	}

	private static boolean areIdenticalTrees(Node treeOne, Node treeTwo) {
		if (treeOne == null && treeTwo == null) {
			return true;
		}
		if (treeOne != null && treeTwo != null) {
			return ((treeOne.getData() == treeTwo.getData()) && areIdenticalTrees(treeOne.left, treeTwo.left) && areIdenticalTrees(treeOne.right,
					treeTwo.right));
		}
		return false;
	}
}
