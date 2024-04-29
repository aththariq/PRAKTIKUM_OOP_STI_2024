import java.util.Scanner;



public class MainCal {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        char operation = scanner.next().charAt(0);
        try {
            System.out.println(calculator.calculate(a, b, operation));
        } catch (Calculator.CalculatorException e) {
            System.out.println(e.getMessage());
        }
    }
}
