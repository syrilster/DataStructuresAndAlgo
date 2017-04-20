package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author ssadasivan
 * @since 4/20/2017.
 */
public class BottomViewOfTree {
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
		bottomViewOfTree(tree.root);
	}

	private static void bottomViewOfTree(Node node) {
		if (node == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		int level = 0;
		Map<Integer, Integer> bottomViewMap = new TreeMap<>();
		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			level = temp.getLevel();
			bottomViewMap.put(level, temp.getData());
			if (temp.left != null) {
				temp.left.setLevel(temp.getLevel() - 1);
				queue.add(temp.left);
			}
			if (temp.right != null) {
				temp.right.setLevel(temp.getLevel() + 1);
				queue.add(temp.right);
			}
		}
		for (Map.Entry<Integer, Integer> mapentry : bottomViewMap.entrySet()) {
			System.out.print(mapentry.getValue() + " ");
		}
	}
}
