package Tree.BinaryTree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author ssadasivan
 * @since 4/18/2017.
 */
public class TopViewOfTree {
	Node root;

	public static void main(String args[]) {
		TopViewOfTree tree = new TopViewOfTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		topViewOfTree(tree.root);
	}

	private static void topViewOfTree(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Set<Integer> levelSet = new HashSet<>();
		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			int level = temp.getLevel();
			if (!levelSet.contains(level)) {
				levelSet.add(level);
				System.out.print(temp.getData() + " ");
			}
			if (temp.left != null) {
				temp.left.setLevel(temp.getLevel() - 1);
				queue.add(temp.left);
			}
			if (temp.right != null) {
				temp.right.setLevel(temp.getLevel() + 1);
				queue.add(temp.right);
			}
		}
	}
}
