public class Smartphone extends StoreItem {
    private int storageCapacity;
    private int batteryLife;

    /**
     * Smartphone constructor
     * @param brand
     * @param model
     * @param storageCapacity
     * @param batteryLife
     */
    public Smartphone(String brand, String model, int storageCapacity, int batteryLife) {
        super(brand, model);
        this.storageCapacity = storageCapacity;
        this.batteryLife = batteryLife;
    }
    
    /**
     * Mencetak tambahan detail sebuah barang dengan format seperti berikut (tanpa [])
     * Cetak brand dan model dengan metode displayDetails dari class StoreItem
     * Storage capacity: [Jumlah storage dengan satuan GB]
     * Battery life: [Lama battery life dengan satuan hours]
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Storage capacity: " + storageCapacity + " GB");
        System.out.println("Battery life: " + batteryLife + " hours");
    }

    /**
     * Menghitung harga dari smartphone
     * Apabila nama brand "Legowo", maka rumus: 200 + (Jumlah storage * 5) + (Lama battery life * 2)
     * Selain nama brand "Legowo", rumus: 200 + (Jumlah storage * 10) + (Lama battery life * 5)
     */
    @Override
    public int calculatePrice() {
        if (getBrand().equals("Legowo")) {
            return 200 + (storageCapacity * 5) + (batteryLife * 2);
        } else {
            return 200 + (storageCapacity * 10) + (batteryLife * 5);
        }

    }
    
}