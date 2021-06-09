package bridgelabz.jsonInventory;

public class StockMain extends StockPortfolio {
	public static void main(String[] args) {
		StockMain stockMain = new StockMain();
		stockMain.readJson();
		stockMain.calculateStockValue();
		stockMain.writeToJson();
	}
}
