package bridgelabz.jsonInventory;

public class InventoryManager extends InventoryFactory {

	public static void main(String[] args) {
		InventoryManager inventoryManager = new InventoryManager();
		inventoryManager.readJson();
		inventoryManager.calculateInventoryValue();
		inventoryManager.writeToJson();
	}
}
