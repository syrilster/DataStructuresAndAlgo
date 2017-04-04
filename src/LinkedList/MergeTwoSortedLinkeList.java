package LinkedList;

/**
 * @author ssadasivan
 * @since 4/3/2017.
 */
public class MergeTwoSortedLinkeList {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> listOne = new SinglyLinkedList<>();
		listOne.insertAtFirst(100);
		listOne.insertAtFirst(90);
		listOne.insertAtFirst(70);
		listOne.insertAtFirst(50);
		listOne.insertAtFirst(10);
		SinglyLinkedList<Integer> listTwo = new SinglyLinkedList<>();
		listTwo.insertAtFirst(80);
		listTwo.insertAtFirst(60);
		listTwo.insertAtFirst(40);
		listTwo.insertAtFirst(30);
		listTwo.insertAtFirst(20);
		System.out.println(listOne.toString());
		System.out.println(listTwo.toString());
		System.out.println("Merged List:");
		SinglyLinkedList.Node merged = mergeList(listOne.first, listTwo.first);

		while (merged != null) {
			System.out.println(merged.data);
			merged = merged.next;
		}
	}

	private static SinglyLinkedList.Node mergeList(SinglyLinkedList.Node nodeOne, SinglyLinkedList.Node nodeTwo) {
		SinglyLinkedList.Node head = new SinglyLinkedList.Node();
		SinglyLinkedList.Node p = head;
		SinglyLinkedList.Node tempNodeOne = nodeOne;
		SinglyLinkedList.Node tempNodeTwo = nodeTwo;
		while (tempNodeOne != null && tempNodeTwo != null) {
			int p1Data = Integer.valueOf(tempNodeOne.data.toString());
			int p2Data = Integer.valueOf(tempNodeTwo.data.toString());
			if (p1Data < p2Data) {
				p.next = tempNodeOne;
				tempNodeOne = tempNodeOne.next;
			} else {
				p.next = tempNodeTwo;
				tempNodeTwo = tempNodeTwo.next;
			}
			p = p.next;
		}
		if (tempNodeOne != null) {
			p.next = tempNodeOne;
		}
		if (tempNodeTwo != null) {
			p.next = tempNodeTwo;
		}
		return head.next;
	}
}
