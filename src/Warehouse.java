public class Warehouse {
    private String warehouseName;
    private String location;
    private double stock;
    private final double maxCapacity = 1000;
    private final double minAllowedStock = 0;

    // Constructor with 3 arguments (since maxCapacity and minAllowedStock are fixed)
    public Warehouse(String warehouseName, String location, double stock) {
        this.warehouseName = warehouseName;
        this.location = location;
        if (stock >= minAllowedStock && stock <= maxCapacity) {
            this.stock = stock; // Initialize stock if within allowed range
        } else {
            this.stock = 0; // Default to 0 if stock is invalid
            System.out.println("Invalid initial stock. Set to 0 kg.");
        }
    }

    // Method to add stock
    public void addStock(double stock2) {
        if (stock2 > 0) {  // Ensure positive input
            double totalStock = this.stock + stock2;
            if (totalStock > maxCapacity) {
                System.out.println("Cannot add " + stock2 + " kg. Exceeds max capacity of 1000 kg.");
            } else {
                this.stock = totalStock; // Update stock after successful addition
                System.out.println(stock2 + " kg added. Total stock now: " + this.stock + " kg.");
            }
        } else {
            System.out.println("Invalid input. Stock to add should be positive.");
        }
    }

    // Method to withdraw stock
    public void withdrawStock(double stockToWithdraw) {
        if (stockToWithdraw > 0) {  // Ensure positive input
            if (stockToWithdraw <= this.stock) {
                this.stock =this.stock- stockToWithdraw; // Update stock after withdrawal
                System.out.println(stockToWithdraw + " kg withdrawn. Remaining stock: " + this.stock + " kg.");
            } else {
                System.out.println("Cannot withdraw " + stockToWithdraw + " kg. Not enough stock available.");
            }
        } else {
            System.out.println("Invalid input. Stock to withdraw should be positive.");
        }
    }

    // Method to print current stock details
    public void printStockDetails() {
        System.out.println("Warehouse: " + warehouseName + " | Location: " + location);
        System.out.println("Current stock: " + stock + " kg (Max capacity: " + maxCapacity + " kg)");
    }
}


