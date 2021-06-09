package bridgelabz.jsonInventory;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class InventoryManagementSystem {

	private Inventory inventory;

	public static void main(String[] args) {
		InventoryManagementSystem inventoryManagementSystem = new InventoryManagementSystem();
		inventoryManagementSystem.readJson();
		inventoryManagementSystem.calculateInventoryValue();
		inventoryManagementSystem.writeToJson();
	}

	/**
	 * Calculating inventory value for rice,wheat,pulses
	 */
	private void calculateInventoryValue() {
		long inventoryValueRice = inventory.getRiceList().stream().map(rice -> rice.getWeight() * rice.getPricePerKg())
				.reduce(0L, (total, value) -> total + value);
		System.out.println("Inventory value for rice: " + inventoryValueRice);

		long inventoryValuePulses = inventory.getPulsesList().stream()
				.map(pulses -> pulses.getWeight() * pulses.getPricePerKg()).reduce(0L, (total, value) -> total + value);
		System.out.println("Inventory value for pulses: " + inventoryValuePulses);

		long inventoryValueWheat = inventory.getWheatList().stream()
				.map(wheat -> wheat.getWeight() * wheat.getPricePerKg()).reduce(0L, (total, value) -> total + value);
		System.out.println("Inventory value for wheat: " + inventoryValueWheat);

	}

	/**
	 * Reading the Json file and convert to java object using Jackson ObjectMapper
	 * readValue method
	 */
	private void readJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// JSON file to Java object
			inventory = mapper.readValue(new File("E:\\workspace\\JsonInventory\\inventory.json"), Inventory.class);
			System.out.println(inventory.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Converting the java object to Json string using Jackson ObjectMapper
	 * writeValueAsString
	 */
	private void writeToJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Java objects to JSON string - compact-print
			String jsonString = mapper.writeValueAsString(inventory);
			System.out.println(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
