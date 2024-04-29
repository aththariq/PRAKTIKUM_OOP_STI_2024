public class Calculator {
    public Calculator() { };

    public double calculate(double a, double b, char operation) throws CalculatorException{
        /**
         * Implementasi
         * Apabila operasi yang dimasukkan pengguna bukan `+`, `-`, `*`, atau `/`, maka
         * kalkulator akan mengembalikan pesan error dari kelas
         * `InvalidOperationException` dengan pesan `Invalid Operation: <operasi yang dimasukan>`
         * 
         * Apabila kalkulator menerima masukan pembagian terhadap 0, maka kalkulator
         * akan mengembalikan pesan error dari kelas `InvalidDivisionException`
         * dengan pesan `Invalid Division: Tidak dapat melakukan pembagian terhadap 0!`
         */ 
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new InvalidDivisionException("Invalid Division: Tidak dapat melakukan pembagian terhadap 0!");
                }
                return a / b;
            default:
                throw new InvalidOperationException("Invalid Operation: " + operation);
    }
}

/**
 * Implementasikan:
 * 1. Calculator Exception
 * 2. InvalidOperationException
 * 3. InvalidDivisionException
 */

class CalculatorException extends Exception {
    public CalculatorException(String message) {
        super(message);
    }
}


class InvalidOperationException extends CalculatorException {
    public InvalidOperationException(String message) {
        super(message);
    }
}

class InvalidDivisionException extends CalculatorException {
    public InvalidDivisionException(String message) {
        super(message);
    }
}
}