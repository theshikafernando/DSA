
class SinglyLinkedList {

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head = null;

    // Insert at beginning
    void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Delete a node
    void delete(int value) {

        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        if (head.data == value) {
            head = head.next;
            System.out.println(value + " deleted");
            return;
        }

        Node temp = head;

        while (temp.next != null &&
                temp.next.data != value) {

            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println(value + " not found");
            return;
        }

        temp.next = temp.next.next;

        System.out.println(value + " deleted");
    }

    // Search an element
    void search(int value) {

        Node temp = head;

        while (temp != null) {

            if (temp.data == value) {
                System.out.println(value + " found");
                return;
            }

            temp = temp.next;
        }

        System.out.println(value + " not found");
    }

    // Display linked list
    void display() {

        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node temp = head;

        System.out.println("linked list elements:");

        while (temp != null) {

            System.out.print(temp.data + " -> ");

            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.display();

        list.insertAtBeginning(5);

        System.out.println("after inserting at beginning:");
        list.display();

        list.delete(20);

        System.out.println("after deleting:");
        list.display();

        list.search(30);
    }
}
