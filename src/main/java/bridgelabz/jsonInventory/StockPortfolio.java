package bridgelabz.jsonInventory;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public abstract class StockPortfolio {

	protected Stocks stocks;

	/**
	 * Calculate total value of all shares for a stock. Also, calculate total value
	 * of all stocks.
	 */
	protected void calculateStockValue() {
		double allStocksValue = 0;
		for (int i = 0; i < stocks.getStockList().size(); i++) {
			Stock stock = stocks.getStockList().get(i);
			double allSharesValue = 0;
			for (int j = 0; j < stock.getSharesList().size(); j++) {
				Shares shares = stock.getSharesList().get(j);
				allSharesValue = allSharesValue + (shares.getNoOfShare() * shares.getPrice());
			}
			System.out.println("Total value of shares for " + stock.getName() + "is " + allSharesValue);
			allStocksValue = allStocksValue + allSharesValue;
		}
		System.out.println("Total value of all stocks " + allStocksValue);
	}

	/**
	 * Reading the Json file and convert to java object using Jackson ObjectMapper
	 * readValue method
	 */
	protected void readJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// JSON file to Java object
			stocks = mapper.readValue(new File("E:\\workspace\\JsonInventory\\stocks.json"), Stocks.class);
			System.out.println(stocks.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Converting the java object to Json string using Jackson ObjectMapper
	 * writeValueAsString
	 */
	protected void writeToJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Java objects to JSON string - compact-print
			String jsonString = mapper.writeValueAsString(stocks);
			System.out.println(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
