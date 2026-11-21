
class DoublyLinkedList {

    class Node {

        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    Node head = null;
    Node tail = null;

    // Insert at beginning
    void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at end
    void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Delete a node
    void delete(int value) {

        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node temp = head;

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println(value + " not found");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }

        System.out.println(value + " deleted");
    }

    // Display forward
    void displayForward() {

        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node temp = head;

        System.out.println("forward direction:");

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Display backward
    void displayBackward() {

        if (tail == null) {
            System.out.println("list is empty");
            return;
        }

        Node temp = tail;

        System.out.println("backward direction:");

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.println("original list:");
        list.displayForward();

        list.insertAtBeginning(5);

        System.out.println("after inserting at beginning:");
        list.displayForward();

        list.insertAtEnd(40);

        System.out.println("after inserting at end:");
        list.displayForward();

        list.delete(20);

        System.out.println("after deleting:");
        list.displayForward();

        list.displayBackward();
    }
}
