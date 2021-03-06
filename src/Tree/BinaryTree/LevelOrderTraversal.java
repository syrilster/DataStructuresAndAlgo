package Tree.BinaryTree;

import Tree.BinarySearchTree.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ssadasivan
 * @since 4/9/2017.
 */
public class LevelOrderTraversal {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(40);
		bst.insert(25);
		bst.insert(5);
		bst.insert(15);
		printLevelOrder(bst.root);
	}

	private static void printLevelOrder(Tree.BinarySearchTree.Node node) {
		Queue<Tree.BinarySearchTree.Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Tree.BinarySearchTree.Node tempNode = queue.remove();
			System.out.print(tempNode.getData() + " ");
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}
}
