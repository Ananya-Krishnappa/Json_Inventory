package bridgelabz.jsonInventory;

import java.util.List;

public class Stocks {
	private List<Stock> stockList;

	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

	@Override
	public String toString() {
		return "Stocks [stockList=" + stockList + "]";
	}
}
