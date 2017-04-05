package LinkedList;

/**
 * @author ssadasivan
 * @since 4/5/2017.
 */
public class AddTwoLinkedList {
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
		SinglyLinkedList.Node result = null;
		SinglyLinkedList.Node prev = null;
		SinglyLinkedList.Node temp = null;
		int carry = 0, sum = 0;
		while (listOne != null || listTwo != null) {
			sum = carry + ((listOne != null ? Integer.valueOf(listOne.data.toString()) : 0) + (listTwo != null ?
					Integer.valueOf(listTwo.data.toString()) :
					0));
			carry = (sum >= 10) ? 1 : 0;
			sum = sum % 10;
			temp = new SinglyLinkedList.Node(sum);
			if (result == null) {
				result = temp;
			} else {
				prev.next = temp;
			}
			prev = temp;
			if (listOne != null) {
				listOne = listOne.next;
			}
			if (listTwo != null) {
				listTwo = listTwo.next;
			}
		}
		//This step is required so that if the second list is smaller the carry is taken as a new node in the linked list
		if(carry > 0){
			prev.next = new SinglyLinkedList.Node<>(carry);
		}
		return result;
	}
}
