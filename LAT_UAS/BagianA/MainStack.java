package LAT_UAS;

public class MainStack {
    public static void main(String[] args) throws Exception{
        Stack<MyNumber> stack = new Stack<>(3);
        try {
            stack.push(new MyNumber(10));
            stack.push(new MyNumber(20));
            stack.push(new MyNumber(30));

            // Menampilkan elemen teratas dari stack
            System.out.print("Top of the stack: ");
            stack.displayTop();

            // Mengeluarkan elemen teratas dari stack
            MyNumber poppedElement = stack.pop();
            System.out.println("Popped element: " + poppedElement);

            // Menampilkan elemen teratas dari stack setelah penghapusan
            System.out.print("Top of the stack after popping: ");
            stack.displayTop();

            // Mengeluarkan elemen kedua dari stack
            poppedElement = stack.pop();
            System.out.println("Popped element: " + poppedElement);

            // Menampilkan elemen teratas dari stack setelah penghapusan
            System.out.print("Top of the stack after popping: ");
            stack.displayTop();

            // Mengeluarkan elemen ketiga dari stack
            poppedElement = stack.pop();
            System.out.println("Popped element: " + poppedElement);

            // Menampilkan elemen teratas dari stack setelah penghapusan
            System.out.print("Top of the stack after popping: ");
            stack.displayTop();

            // Memanggil pop() lagi pada stack kosong (akan memunculkan StackEmptyException)
            stack.pop();
        } catch (StackOverFlowException e) {
            System.out.println(e.getMessage());
        } catch (StackEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
