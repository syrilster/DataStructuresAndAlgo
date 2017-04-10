package Tree;

/**
 * @author ssadasivan
 * @since 4/9/2017.
 */
public class BSTPreOrder {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(40);
		bst.insert(25);
		bst.insert(5);
		bst.insert(15);
		printPostOrder(bst.root);
	}

	private static void printPostOrder(BinarySearchTree.Node node) {
		if(node == null){
			return;
		}
		System.out.print(node.getData() + " ");
		printPostOrder(node.getLeft());
		printPostOrder(node.getRight());
	}
}
