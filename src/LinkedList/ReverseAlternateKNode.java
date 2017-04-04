package LinkedList;

/**
 * @author ssadasivan
 * @since 4/4/2017.
 */
public class ReverseAlternateKNode {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> listOne = new SinglyLinkedList<>();
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
		SinglyLinkedList.Node reversed = reverseAlternateNode(listOne.first, 3 );
		while (reversed != null) {
			System.out.println(reversed.data);
			reversed = reversed.next;
		}
	}

	private static SinglyLinkedList.Node reverseAlternateNode(SinglyLinkedList.Node head, int k) {
		if (head == null)
			return new SinglyLinkedList.Node<>();
		SinglyLinkedList.Node current = head;
		SinglyLinkedList.Node prev;
		SinglyLinkedList.Node next = null;
		prev = null;
		int count = 0;
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		if (next != null) {
			head.next = reverseAlternateNode(next, k);
		}
		return prev;
	}
}
