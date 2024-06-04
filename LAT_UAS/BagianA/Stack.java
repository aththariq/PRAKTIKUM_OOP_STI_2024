package LAT_UAS;

public class Stack<T extends Displayable>{
    private T[] data;
    int top;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.data = (T[]) new Displayable[size];
        this.top = 0;
    }

    public void push(T item) throws StackOverFlowException {
        if (top >= data.length) {
            throw new StackOverFlowException("Stack is full");
        }
        data[top++] = item;
    }

    public T pop() throws StackEmptyException {
        if (top <= 0) {
            throw new StackEmptyException("Stack is empty");
        }
        return data[--top];
    }

    public void displayTop() throws StackEmptyException {
        if (top <= 0) {
            throw new StackEmptyException("Stack is empty");
        }
        data[top - 1].display();
    }
}
