package LinkedList;

/**
 * @author ssadasivan
 * @since 4/5/2017.
 */
public class AddTwoLinkedListQuestion2 {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> listOne = new SinglyLinkedList<>();
		listOne.insertAtFirst(5);
		listOne.insertAtFirst(3);
		listOne.insertAtFirst(2);
		SinglyLinkedList<Integer> listTwo = new SinglyLinkedList<>();
		listTwo.insertAtFirst(7);
		listTwo.insertAtFirst(2);
		listTwo.insertAtFirst(1);
		System.out.println(listOne.toString());
		System.out.println(listTwo.toString());
		System.out.println("Added result:");
		SinglyLinkedList.Node result = addTwoLists(listOne.first, listTwo.first);
		while (result != null) {
			System.out.print(result.data + " ");
			result = result.next;
		}
	}

	private static SinglyLinkedList.Node addTwoLists(SinglyLinkedList.Node listOne, SinglyLinkedList.Node listTwo) {
		return new SinglyLinkedList.Node();
	}
}
