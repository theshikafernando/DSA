
class CircularQueue {

    int[] queue;
    int front, rear, size, capacity;

    CircularQueue(int capacity) {

        this.capacity = capacity;
        queue = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue operation
    void enqueue(int x) {

        if (size == capacity) {
            System.out.println("queue is full");
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = x;
        size++;

        System.out.println(x + " inserted");
    }

    // Dequeue operation
    void dequeue() {

        if (size == 0) {
            System.out.println("queue is empty");
            return;
        }

        int value = queue[front];

        front = (front + 1) % capacity;
        size--;

        if (size == 0) {
            front = 0;
            rear = -1;
        }

        System.out.println("deleted: " + value);
    }

    // Peek operation
    void peek() {

        if (size == 0) {
            System.out.println("queue is empty");
            return;
        }

        System.out.println("front element: " + queue[front]);
    }

    // Display operation
    void display() {

        if (size == 0) {
            System.out.println("queue is empty");
            return;
        }

        System.out.println("queue elements:");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % capacity;

            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }
}

public class ArrayCircularQueue {

    public static void main(String[] args) {

        CircularQueue q = new CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display();

        q.dequeue();

        q.display();

        q.enqueue(50);
        q.enqueue(60);

        q.display();

        q.peek();
    }
}
