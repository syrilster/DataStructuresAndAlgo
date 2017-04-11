package Tree;

import java.util.ArrayList;

/**
 * @author ssadasivan
 * @since 4/10/2017.
 */
public class PrintRootToLeafPath {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(20);
		tree.insert(10);
		tree.insert(30);
		tree.insert(40);
		tree.insert(25);
		tree.insert(7);
		tree.insert(5);
		tree.insert(8);
		tree.insert(9);
		printRootToLeafPaths(tree.root);
	}

	private static void printRootToLeafPaths(BinarySearchTree.Node node) {
		if (node == null) {
			return;
		}
		ArrayList<Integer> pathList = new ArrayList<>();
		printRootToLeafPaths(node, pathList);
	}

	private static void printRootToLeafPaths(BinarySearchTree.Node node, ArrayList<Integer> pathList) {
		if(node == null){
			return;
		}
		pathList.add(node.getData());
		if (node.getLeft() == null && node.getRight() == null) {
			printPath(pathList);
			return;
		}
		printRootToLeafPaths(node.getLeft(), new ArrayList<>(pathList));
		printRootToLeafPaths(node.getRight(), new ArrayList<>(pathList));
	}

	private static void printPath(ArrayList<Integer> pathList) {
		for (Integer data : pathList) {
			System.out.print(data + " ");
		}
		System.out.println("");
	}
}
