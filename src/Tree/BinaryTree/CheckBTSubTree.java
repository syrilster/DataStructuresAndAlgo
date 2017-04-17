package Tree.BinaryTree;

/**
 * If function checkIfSubtree(TreeNode bigTreeRoot, TreeNode smallTreeRoot) implements this algorithm then the steps of this intuitive algorithm are as following -
 1. If 'smallTreeRoot is equal to null' then return true since 'null' tree is sub-tree for any tree.
 2. If condition #1 is not true then check if 'bigTreeRoot is equal to null'. If it is then return false since null tree cannot have any sub-tree except null tree for which we have already checked in #1.
 3. If both conditions #1 and #2 are not true then check if value of smallTreeRoot is equal to value of bigTreeRoot.
 4. If condition #3 evaluated to true then we check if left sub-tree of smallTreeRoot exactly matches to left sub-tree of bigTreeRoot and right sub-tree of smallTreeRoot exactly matches to right sub-tree of bigTreeRoot. If both sub-trees match then we return true since we know that smallTree is now a sub-tree of bigTree.
 5. If either #3 or #4 evaluate to false then we check if left sub-tree of bigTreeRoot contains smallTree or right sub-tree of bigTreeRoot contains smallTree. For checking this we simply make recursive calls.

 Time complexity for this approach is O(n^2) and space complexity for this approach is O(1).
 */
public class CheckBTSubTree {
	Node root;

	public static void main(String[] args) {
		/*
								1
                          2             3
                      4      5       6    7
                               8

        */
		CheckBTSubTree bigTree = new CheckBTSubTree();
		bigTree.root = createBigTree();


        /*
						  2
                      4      5
                                8
        */
		CheckBTSubTree smallTree = new CheckBTSubTree();
		smallTree.root = createSmallTree();
		System.out.println("If small tree is sub-tree of big tree: " + checkIfSubtree(bigTree.root, smallTree.root));
	}

	private static boolean checkIfSubtree(Node bigTree, Node smallTree) {
		if (smallTree == null)
			return true;
		if (bigTree == null)
			return false;
		if (bigTree.getData() == smallTree.getData()) {
			if (completeMatch(bigTree, smallTree)) {
				return true;
			}
		}
		return checkIfSubtree(bigTree.left, smallTree) || checkIfSubtree(bigTree.right, smallTree);
	}

	private static boolean completeMatch(Node treeOne, Node treeTwo) {
		if (treeOne == null && treeTwo == null)
			return true;
		if (treeOne == null || treeTwo == null)
			return false;
		if (treeOne.getData() == treeTwo.getData()) {
			return completeMatch(treeOne.left, treeTwo.left) && completeMatch(treeOne.right, treeTwo.right);
		}
		return false;
	}

	private static Node createBigTree() {
		CheckBTIdentical tree = new CheckBTIdentical();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.right = new Node(8);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		return tree.root;
	}

	private static Node createSmallTree() {
		CheckBTIdentical tree = new CheckBTIdentical();
		tree.root = new Node(2);
		tree.root.left = new Node(4);
		tree.root.right = new Node(5);
		tree.root.right.right = new Node(8);
		return tree.root;
	}
}
