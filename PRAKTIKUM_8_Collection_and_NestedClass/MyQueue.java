package PRAKTIKUM_8_Collection_and_NestedClass;
import java.util.*;

class MyQueue {
    // Definisi variabel penggunaan stack
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    // Konstruktor
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        
    }

    // Menambah elemen x ke belakang Queue
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Menghapus elemen dari depan Queue dan mengembalikan elemen tersebut
    public int pop() {
        return s1.pop();

    }

    // Mengembalikan elemen depan Queue
    public int peek() {
        return s1.peek();
    }

    // Mengembalikan apakah Queue kosong (true) atau tidak (false)
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
