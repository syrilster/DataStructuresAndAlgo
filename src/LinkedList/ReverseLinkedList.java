package LinkedList;

/**
 * @author ssadasivan
 * @since 4/4/2017.
 */
public class ReverseLinkedList {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> listOne = new SinglyLinkedList<>();
		listOne.insertAtFirst(10);
		listOne.insertAtFirst(20);
		listOne.insertAtFirst(30);
		listOne.insertAtFirst(40);
		listOne.insertAtFirst(50);
		SinglyLinkedList reversed = reverseLinkedList(listOne);
		SinglyLinkedList.Node reverse = reversed.first;
		while (reverse != null) {
			System.out.println(reverse.data);
			reverse = reverse.next;
		}
	}

	private static SinglyLinkedList reverseLinkedList(SinglyLinkedList<Integer> list) {
		if (list == null)
			return new SinglyLinkedList();
		SinglyLinkedList.Node current, prev, next;
		prev = null;
		current = list.first;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		list.first = prev;
		return list;
	}
}
