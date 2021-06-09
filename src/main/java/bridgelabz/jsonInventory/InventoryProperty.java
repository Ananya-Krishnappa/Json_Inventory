package bridgelabz.jsonInventory;

public abstract class InventoryProperty {
	String name;
	long weight;
	long pricePerKg;
	
	@Override
	public String toString() {
		return "InventoryProperty [name=" + name + ", weight=" + weight + ", pricePerKg=" + pricePerKg + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public long getPricePerKg() {
		return pricePerKg;
	}

	public void setPricePerKg(long pricePerKg) {
		this.pricePerKg = pricePerKg;
	}

}
