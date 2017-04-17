package Tree.BinaryTree;

/**
 * Created by Syril on 12-04-2017.
 */
public class NodeAtKDistanceFromRoot {
    Node root;
    public static void main(String[] args) {
        NodeAtKDistanceFromRoot tree = new NodeAtKDistanceFromRoot();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        printKDistant(tree.root, 2);
    }

    private static void printKDistant(Node node, int k) {
        if (node == null) {
            return;
        }
        if (k == 0) {
            System.out.print(node.getData() + " ");
        } else {
            printKDistant(node.left, k - 1);
            printKDistant(node.right, k - 1);
        }
    }
}
