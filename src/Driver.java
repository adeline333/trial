public class Driver {
    public static void main(String[] args) {
        Warehouse test1= new Warehouse("magerwa","gikondo",1200);
        test1.addStock(-10);
        test1.addStock(500);
        test1.addStock(800);


        test1.withdrawStock(400);

        test1.printStockDetails();

    }
}
