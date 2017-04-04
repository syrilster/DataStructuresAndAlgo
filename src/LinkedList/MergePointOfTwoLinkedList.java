package LinkedList;

/**
 * @author ssadasivan
 * @since 4/4/2017.
 */
public class MergePointOfTwoLinkedList {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> listOne = new SinglyLinkedList<>();
		listOne.insertAtFirst(100);
		listOne.insertAtFirst(90);
		listOne.insertAtFirst(80);
		listOne.insertAtFirst(30);
		System.out.println("List One");
		SinglyLinkedList.Node head = listOne.first;
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		SinglyLinkedList<Integer> listTwo = new SinglyLinkedList<>();
		listTwo.insertAtFirst(100);
		listTwo.insertAtFirst(90);
		listTwo.insertAtFirst(80);
		listTwo.insertAtFirst(70);
		listTwo.insertAtFirst(60);
		listOne.insertAtFirst(20);
		listOne.insertAtFirst(10);

		System.out.println("\nList Two");
		SinglyLinkedList.Node headTwo = listTwo.first;
		while (headTwo != null) {
			System.out.print(headTwo.data + " ");
			headTwo = headTwo.next;
		}
		System.out.println("\nIntersection Point is " + getIntersection(listOne, listTwo));
	}

	public static int getIntersection(SinglyLinkedList listOne, SinglyLinkedList listTwo) {
		SinglyLinkedList.Node tempOne = listOne.first;
		SinglyLinkedList.Node tempTwo = listTwo.first;
		//Go till end using tempOne
		int lengthOne = 0;
		while (tempOne.next != null) {
			tempOne = tempOne.next;
			lengthOne++;
		}
		//Go till end using tempTwo
		int lengthTwo = 0;
		while (tempTwo.next != null) {
			tempTwo = tempTwo.next;
			lengthTwo++;
		}
		//If tempOne and tempTwo are not equal then no intersection point
		if (tempOne.data != tempTwo.data) {
			return 0;
		}
		//Find difference in length between the two list
		int diff = 0;
		if (lengthOne > lengthTwo) {
			tempOne = listOne.first;
			tempTwo = listTwo.first;
			diff = lengthOne - lengthTwo;
		} else {
			tempOne = listTwo.first;
			tempTwo = listOne.first;
			diff = lengthTwo - lengthOne;
		}
		//Move ahead till the difference
		while (diff > 0) {
			tempOne = tempOne.next;
			diff--;
		}
		//Traverse till the data are equal
		while (tempOne.data != tempTwo.data) {
			tempOne = tempOne.next;
			tempTwo = tempTwo.next;
		}
		return Integer.valueOf(tempOne.data.toString());
	}
}
