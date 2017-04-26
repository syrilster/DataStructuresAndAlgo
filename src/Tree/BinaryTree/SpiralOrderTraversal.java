package Tree.BinaryTree;

import java.util.Stack;

/**
 * @author ssadasivan
 * @since 4/26/2017.
 */
public class SpiralOrderTraversal {
	Node root;
	public static void main(String args[]) {
		SpiralOrderTraversal tree = new SpiralOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		spiralOrderTraversal(tree.root);
	}

	private static void spiralOrderTraversal(Node node) {
		Stack<Node> stackOne = new Stack<>();
		Stack<Node> stackTwo = new Stack<>();
		stackOne.push(node);
		while(!stackOne.isEmpty() || !stackTwo.isEmpty()){
			while(!stackOne.isEmpty()){
				Node temp = stackOne.pop();
				System.out.print(temp.getData() + " ");
				if(temp.left!=null){
					stackTwo.push(temp.left);
				}
				if(temp.right!=null){
					stackTwo.push(temp.right);
				}
			}
			while(!stackTwo.isEmpty()){
				Node temp = stackTwo.pop();
				System.out.print(temp.getData() + " ");
				if(temp.right!=null){
					stackOne.push(temp.right);
				}
				if(temp.left!=null){
					stackOne.push(temp.left);
				}
			}
		}
	}
}
