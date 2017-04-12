package Tree.BinaryTree;

/**
 * Created by Syril on 12-04-2017.
 */
public class NodeAtKDistanceFromRoot {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createSampleTree();
        printKDistant(tree.getRoot(), 1);
    }

    private static void printKDistant(BinaryTree.Node node, int k) {
        if (node == null) {
            return;
        }
        if (k == 0) {
            System.out.print(node.getData() + " ");
        } else {
            printKDistant(node.getLeft(), k - 1);
            printKDistant(node.getRight(), k - 1);
        }
    }
}
