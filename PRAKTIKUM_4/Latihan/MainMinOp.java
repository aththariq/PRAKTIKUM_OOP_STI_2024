public class MainMinOp {
    public static void main(String[] args) {
        MinOp minOp = new MinOp();

        // Array of numbers
        Number[] numbers = {1, 1};

        // Mencari jumlah operasi minimum yang diperlukan
        int minimumOperations = minOp.minimumOperationsNeeded(numbers);

        // Menampilkan hasil
        System.out.println("Minimum Operations Needed: " + minimumOperations);
    }
}
