package Tree.BinaryTree;

import LinkedList.SinglyLinkedList;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author ssadasivan
 * @since 4/17/2017.
 */
public class VerticalOrderTraversal {
	Node root;

	public static void main(String args[]) {
		NodeIsCousin tree = new NodeIsCousin();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		verticalOrderTraversal(tree.root);
	}

	private static void verticalOrderTraversal(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Map<Integer, Integer> verticalOrderMap = new TreeMap();
		int level = 0;
		while (!queue.isEmpty()) {
			Node tempNode = queue.remove();
			level = tempNode.getLevel();
			verticalOrderMap.put(level, tempNode.getData());
			if (tempNode.left != null) {
				tempNode.left.setLevel(tempNode.getLevel() - 1);
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				tempNode.right.setLevel(tempNode.getLevel() + 1);
				queue.add(tempNode.right);
			}
		}
		for (Map.Entry<Integer, Integer> verticalOrderEntry : verticalOrderMap.entrySet()) {
			System.out.print(verticalOrderEntry.getValue() + " ");
		}
	}
}
