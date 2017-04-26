package Tree.BinaryTree;

import Tree.BinarySearchTree.*;

/**
 * @author ssadasivan
 * @since 4/9/2017.
 */
public class TreeInOrder {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(40);
		bst.insert(25);
		bst.insert(5);
		bst.insert(15);
		printInOrder(bst.root);
	}

	private static void printInOrder(Tree.BinarySearchTree.Node node) {
		if(node == null){
			return;
		}
		printInOrder(node.left);
		System.out.print(node.getData() + " ");
		printInOrder(node.right);
	}
}
