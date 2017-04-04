package LinkedList;

/**
 * @author ssadasivan
 * @since 4/4/2017.
 */
public class ReverseLinkedListAlternateNode {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> listOne = new SinglyLinkedList<>();
		listOne.insertAtFirst(90);
		listOne.insertAtFirst(80);
		listOne.insertAtFirst(70);
		listOne.insertAtFirst(60);
		listOne.insertAtFirst(50);
		listOne.insertAtFirst(40);
		listOne.insertAtFirst(30);
		listOne.insertAtFirst(20);
		listOne.insertAtFirst(10);
		System.out.println("Original List ");
		SinglyLinkedList.Node head = listOne.first;
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
		System.out.println("Reversed List");
		SinglyLinkedList.Node reversed = reverseAlternateNode(listOne.first, 3);
		while (reversed != null) {
			System.out.println(reversed.data);
			reversed = reversed.next;
		}
	}

	private static SinglyLinkedList.Node reverseAlternateNode(SinglyLinkedList.Node<Integer> node, int k) {

		SinglyLinkedList.Node current = node;
		SinglyLinkedList.Node prev = null;
		SinglyLinkedList.Node next = null;
		int count = 0;
		/*1) reverse first k nodes of the linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		 /*2) Now head points to the kth node.  So change next
         of head to (k+1)th node*/
		if (node != null) {
			node.next = current;
		}
		/* 3) We do not want to reverse next k nodes. So move the current
         pointer to skip next k nodes */
		count = 0;
		while (count < k-1 && current != null) {
			current = current.next;
			count++;
		}
		/* 4) Recursively call for the list starting from current->next.
         And make rest of the list as next of first node */
		if (current != null) {
			current.next = reverseAlternateNode(current.next, k);
		}
		/* 5) prev is new head of the input list */
		return prev;
	}
}
