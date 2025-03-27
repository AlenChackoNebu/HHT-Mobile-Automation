package appiumtest;

public class TestRunner {

    public static void main(String[] args) {
    	BaseTest baseTest = new BaseTest();
        FileTransfer fileTransfer = new FileTransfer();
        Inventory_Count inventoryCount = new Inventory_Count();
        Adjustments adjustments = new Adjustments();
        Deliveries deliveries = new Deliveries();
        PriceCheck pricecheck = new PriceCheck();
        OrderInventory orderinventory = new OrderInventory();
        ShelfLabels shelflabels = new ShelfLabels();

        try {
            // Open the app
        	baseTest.openApp();

            // Perform login
        	 baseTest.login();

            // Execute file transfer operations
            fileTransfer.fileTransferMain();
            
            // Execute inventory count operations
            inventoryCount.inventoryCountMain();
            
            // Execute adjustments operations
            adjustments.adjustmentsMain();
            
            //Execute Deliveries operations
            deliveries.deliveriesMain();
            
            //Execute Price Check operations
            pricecheck.priceCheckMain();
            
            //Execute Order Inventory operations
            orderinventory.orderInventoryMain();
            
            //Execute Shelf Labels operations
            shelflabels.shelfLabelsMain();

            // Perform logout before closing
            baseTest.logout();

            // Close the app using BaseTest
            baseTest.closeApp();

        } catch (Exception e) {
            System.out.println("Cause: " + e.getCause());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
