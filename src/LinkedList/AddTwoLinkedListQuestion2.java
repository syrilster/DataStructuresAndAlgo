package LinkedList;

import java.util.InputMismatchException;

/**
 * @author ssadasivan
 * @since 4/5/2017.
 */
public class AddTwoLinkedListQuestion2 {
	public static int carry = 0;
	public static SinglyLinkedList.Node newHead = null;

	public static void main(String[] args) {
		SinglyLinkedList<Integer> listOne = new SinglyLinkedList<>();
		listOne.insertAtFirst(6);
		listOne.insertAtFirst(8);
		listOne.insertAtFirst(9);
		SinglyLinkedList<Integer> listTwo = new SinglyLinkedList<>();
		listTwo.insertAtFirst(2);
		listTwo.insertAtFirst(9);
		System.out.println(listOne.toString());
		System.out.println(listTwo.toString());
		System.out.println("Added result:");
		SinglyLinkedList.Node result = addTwoLists(listOne.first, listTwo.first);
		while (result != null) {
			System.out.print(result.data + " ");
			result = result.next;
		}
	}

	private static SinglyLinkedList.Node addTwoLists(SinglyLinkedList.Node nodeOne, SinglyLinkedList.Node nodeTwo) {
		//first we will make sure that both the Linked list has same no of node. To ensure that we will append 0 in front of shorter list
		int listOneLength = getLength(nodeOne);
		int listTwoLength = getLength(nodeTwo);
		int diff = 0;
		if (listOneLength > listTwoLength) {
			diff = listOneLength - listTwoLength;
			while (diff > 0) {
				SinglyLinkedList.Node temp = new SinglyLinkedList.Node(0);
				temp.next = nodeTwo;
				nodeTwo = temp;
				diff--;
			}
		}
		if (listTwoLength > listOneLength) {
			diff = listTwoLength - listOneLength;
			while (diff > 0) {
				SinglyLinkedList.Node temp = new SinglyLinkedList.Node(0);
				temp.next = nodeOne;
				nodeOne = temp;
				diff--;
			}
		}
		SinglyLinkedList.Node newHead = addBackRecursion(nodeOne, nodeTwo);
		if (carry != 0) {
			SinglyLinkedList.Node temp = new SinglyLinkedList.Node(carry);
			temp.next = newHead;
			newHead = temp;
		}
		return newHead;
	}

	public static SinglyLinkedList.Node addBackRecursion(SinglyLinkedList.Node nodeOne, SinglyLinkedList.Node nodeTwo) {
		if (nodeOne == null && nodeTwo == null) {
			return null;
		}
		addBackRecursion(nodeOne.next, nodeTwo.next);
		int sum = Integer.valueOf(nodeOne.data.toString()) + Integer.valueOf(nodeTwo.data.toString()) + carry;
		carry = 0;
		if (sum >= 10) {
			carry = 1;
			sum = sum % 10;
		}
		SinglyLinkedList.Node tempNode = new SinglyLinkedList.Node(sum);
		if (newHead == null) {
			newHead = tempNode;
		} else {
			tempNode.next = newHead;
			newHead = tempNode;
		}
		return newHead;
	}

	public static int getLength(SinglyLinkedList.Node node) {
		int length = 0;
		while (node != null) {
			length++;
			node = node.next;
		}
		return length;
	}
}
