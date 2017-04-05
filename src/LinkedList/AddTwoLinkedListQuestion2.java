package LinkedList;

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
        listOne.insertAtFirst(7);
        listOne.insertAtFirst(9);
        listOne.insertAtFirst(8);
        listOne.insertAtFirst(9);

        SinglyLinkedList<Integer> listTwo = new SinglyLinkedList<>();
        listTwo.insertAtFirst(8);
        listTwo.insertAtFirst(9);
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
        //first we will make sure that both the Linked list has same no of nodes
        // to ensure that we will append 0 in front of shorter list
        int listOneLength = getLength(listOne);
        int listTwoLength = getLength(listTwo);
        if (listOneLength > listTwoLength) {
            int diff = listOneLength - listTwoLength;
            while (diff > 0) {
                SinglyLinkedList.Node tempNode = new SinglyLinkedList.Node(0);
                tempNode.next = listTwo;
                listTwo = tempNode;
                diff--;
            }
        }
        if (listOneLength < listTwoLength) {
            int diff = listTwoLength - listOneLength;
            while (diff > 0) {
                SinglyLinkedList.Node tempNode = new SinglyLinkedList.Node(0);
                tempNode.next = listOne;
                listOne = tempNode;
                diff--;
            }
        }

        SinglyLinkedList.Node newHead = addBackRecursion(listOne, listTwo);
        //check for the carry forward, if not 0 then we need to create another node for the end
        //example adding 1->1 and 9->9 then recursive function will return 0->0 and carry =1
        if (carry != 0) {
            SinglyLinkedList.Node n = new SinglyLinkedList.Node(carry);
            n.next = newHead;
            newHead = n;
        }
        return newHead;
    }

    public static SinglyLinkedList.Node addBackRecursion(SinglyLinkedList.Node listOne, SinglyLinkedList.Node listTwo) {
        if (listOne == null && listTwo == null) {
            return null;
        }
        addBackRecursion(listOne.next, listTwo.next);
        int a = Integer.valueOf(listOne.data.toString()) + Integer.valueOf(listTwo.data.toString()) + carry;
        carry = 0;
        if (a >= 10) {
            carry = 1;
            a = a % 10;
        }
        SinglyLinkedList.Node tempNode = new SinglyLinkedList.Node(a);
        if (newHead == null) {
            newHead = tempNode;
        } else {
            tempNode.next = newHead;
            newHead = tempNode;
        }
        return newHead;
    }

    public static int getLength(SinglyLinkedList.Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
