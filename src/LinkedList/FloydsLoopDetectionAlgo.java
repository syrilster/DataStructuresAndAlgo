package LinkedList;

/**
 * @author ssadasivan
 * @since 4/5/2017.
 */
public class FloydsLoopDetectionAlgo {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		FloydsLoopDetectionAlgo list = new FloydsLoopDetectionAlgo();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);
		// Creating a loop for testing
		head.next.next.next.next.next = head.next.next;
		list.detectAndRemoveLoop(head);
		System.out.println("Linked List after removing loop : ");
		list.printList(head);
	}

	private void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	private void detectAndRemoveLoop(Node head) {
		Node slowPtr = head;
		Node fastPtr = head;
		boolean isLooped;
		while (true) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if (fastPtr.next == null) {
				System.out.println("No Loop Detected");
				return;
			} else if (fastPtr.data == slowPtr.data) {
				isLooped = true;
				break;
			}
		}
		if (isLooped) {
			fastPtr = head;
			while (fastPtr.data != slowPtr.data) {
				fastPtr = fastPtr.next;
				slowPtr = slowPtr.next;
			}
			int loopStart = fastPtr.data;
			System.out.println("Starting point of Loop is " + loopStart);
			int count = 0;
			fastPtr = fastPtr.next;
			while (fastPtr.data != loopStart) {
				fastPtr = fastPtr.next;
				count++;
			}
			System.out.println("Loop Length is " + count);
		}
		//Let slowPtr be at loop start and fastPtr be pointing to loopStart.next
		fastPtr = fastPtr.next;
		while (fastPtr.next.data != slowPtr.data) {
			fastPtr = fastPtr.next;
		}
		fastPtr.next = null;
		return;
	}
}
