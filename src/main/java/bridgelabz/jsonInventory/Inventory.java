package bridgelabz.jsonInventory;

import java.util.List;

public class Inventory {
	private List<Rice> riceList;
	private List<Pulses> pulsesList;
	private List<Wheat> wheatList;

	@Override
	public String toString() {
		return "Inventory [riceList=" + riceList + ", pulsesList=" + pulsesList + ", wheatList=" + wheatList + "]";
	}

	public List<Rice> getRiceList() {
		return riceList;
	}

	public void setRiceList(List<Rice> riceList) {
		this.riceList = riceList;
	}

	public List<Pulses> getPulsesList() {
		return pulsesList;
	}

	public void setPulsesList(List<Pulses> pulsesList) {
		this.pulsesList = pulsesList;
	}

	public List<Wheat> getWheatList() {
		return wheatList;
	}

	public void setWheatList(List<Wheat> wheatList) {
		this.wheatList = wheatList;
	}

}
