package Tree.BinaryTree;

/**
 * Created by Syril on 12-04-2017.
 */
public class Node {
    private int data;
    private int level;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
