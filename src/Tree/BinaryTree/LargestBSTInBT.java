package Tree.BinaryTree;

/**
 * Created by Syril on 20-04-2017.
 */
public class LargestBSTInBT {
    Node root;

    public static void main(String args[]) {
        int min = 0, max = 0, maxBSTSize = 0;
        boolean isBST = false;
        TopViewOfTree tree = new TopViewOfTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        findSizeOfLargestBST(tree.root, min, max, isBST, maxBSTSize);
    }

    private static int minimum(int a, int b)
    {
        if (a < b) return a;
        return b;
    }

    private static int maximum(int a, int b)
    {
        if (a > b) return a;
        return b;
    }

    private static int findSizeOfLargestBST(Node node, int min, int max, boolean isBST, int maxBSTSize) {
        min = Integer.MIN_VALUE;
        max = Integer.MAX_VALUE;
        if(node == null){
            isBST = true;
            return 0;
        }
        int leftTreeSize = findSizeOfLargestBST(node.left, min, max, isBST, maxBSTSize);
        boolean isLeftValid = isBST && (node.getData() > max);

        int tempMin = minimum(node.getData(), min);
        int tempMax = maximum(node.getData(), max);

        int rightTreeSize = findSizeOfLargestBST(node.right, min, max, isBST, maxBSTSize);
        boolean isRightValid = isBST && (node.getData() > min);

        min = minimum(tempMin, min);
        max = maximum(tempMax, max);

        if(isLeftValid && isRightValid){
            isBST = true;

        }
        return 0;
    }
}
