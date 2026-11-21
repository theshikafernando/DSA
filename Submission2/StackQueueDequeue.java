
import java.util.Stack;

class StackQueueDequeueFriendly {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void enqueue(int x) {

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(x);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    void dequeue() {

        if (s1.isEmpty()) {
            System.out.println("queue is empty");
            return;
        }

        s1.pop();
    }

    void display() {

        if (s1.isEmpty()) {
            System.out.println("queue is empty");
            return;
        }

        for (int i = s1.size() - 1; i >= 0; i--) {
            System.out.print(s1.get(i) + " ");
        }

        System.out.println();
    }
}

public class StackQueueDequeue {

    public static void main(String[] args) {

        StackQueueDequeueFriendly q =
                new StackQueueDequeueFriendly();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("queue elements:");
        q.display();

        q.dequeue();

        System.out.println("after dequeue:");
        q.display();
    }
}
