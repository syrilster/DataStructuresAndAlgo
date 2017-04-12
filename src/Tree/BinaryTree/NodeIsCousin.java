package Tree.BinaryTree;

import Tree.BinarySearchTree.BinarySearchTree;

/**
 * Created by Syril on 12-04-2017.
 */
public class NodeIsCousin {
    Node root;
    public static void main(String[] args) {
        NodeIsCousin tree = new NodeIsCousin();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(15);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
            if (tree.isCousin(tree.root, new Node(3), new Node(5)))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private boolean isCousin(Node root, Node node, Node node1) {
        return false;
    }
}
