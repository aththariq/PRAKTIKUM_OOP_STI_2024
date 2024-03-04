import java.util.Scanner;

public class TokoElektronik {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlahBarang = input.nextInt();
        input.nextLine();


        int price = 0; 
        int totalPrice = 0;

        for(int i = 0; i < jumlahBarang; i++){
            int jenisBarang = input.nextInt();
            input.nextLine();
            if (jenisBarang == 1){
                String brand = input.nextLine();
                String model = input.nextLine();
                int storageCapacity = input.nextInt();
                input.nextLine();
                int batteryLife = input.nextInt();
                input.nextLine();
                Smartphone smartphone = new Smartphone(brand, model, storageCapacity, batteryLife);
                price = smartphone.calculatePrice();
                totalPrice += price;
                smartphone.displayDetails();
                System.out.println("Price: " + price);
                
            } else if (jenisBarang == 2) {
                String brand = input.nextLine();
                String model = input.nextLine();
                String processorType = input.nextLine();
                int ram = input.nextInt();
                input.nextLine();
                String inputString = input.nextLine();
                boolean isTouchScreen = inputString.equals("1");
                Laptop laptop = new Laptop(brand, model, processorType, ram, isTouchScreen);
                price = laptop.calculatePrice();
                totalPrice += price;
                laptop.displayDetails();
                System.out.println("Price: " + price);
                
            } else if (jenisBarang == 3) {
                String brand = input.nextLine();
                String model = input.nextLine();
                int screenSize = input.nextInt();
                input.nextLine();
                String inputString = input.nextLine();
                boolean hasCellular = inputString.equals("1");
                Tablet tablet = new Tablet(brand, model, screenSize, hasCellular);
                price = tablet.calculatePrice();
                totalPrice += price;
                tablet.displayDetails();
                System.out.println("Price: " + price);
                
            }
        }
        input.close();
        System.out.println("Total price: " + totalPrice);
    }
}