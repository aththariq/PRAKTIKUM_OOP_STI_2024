package LAT_UAS;

public class Stack<T extends Displayable>{
    private T[] data;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack(T[] data) {
        this.data = data;
        top =0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                top++;
            }
        }
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
