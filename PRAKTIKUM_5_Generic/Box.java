import java.util.Stack;

public class Box<T> {
    private Stack<T> items;

    public Box() {
        items = new Stack<T>();
    }
    
    public void addItem(T item) {
        items.push(item);
    }

    public void removeItem() {
        items.pop();
    }

    public Stack<T> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}