package bridgelabz.jsonInventory;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;

public class StockAccount implements IStockAccount {
	protected Stocks stocks;

	public static void main(String[] args) {
		StockAccount stockAccount = new StockAccount();
		stockAccount.readStockAccount("E:\\workspace\\JsonInventory\\stocksCompanyShares.json");
		stockAccount.valueOf();
		stockAccount.buy(10, "test share1", "Advanced Micro Devices Inc");
		stockAccount.sell(3, "test share1", "Advanced Micro Devices Inc");
		stockAccount.save("JsonInventory");
		stockAccount.printReport();
	}

	@Override
	public void readStockAccount(String fileName) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// JSON file to Java object
			stocks = mapper.readValue(new File(fileName), Stocks.class);
			System.out.println(stocks.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public double valueOf() {
		double allStocksValue = 0;
		for (int i = 0; i < stocks.getStockList().size(); i++) {
			Stock stock = stocks.getStockList().get(i);
			double allSharesValue = 0;
			for (int j = 0; j < stock.getCompanySharesList().size(); j++) {
				CompanyShares shares = stock.getCompanySharesList().get(j);
				allSharesValue = allSharesValue + (shares.getNoOfShares() * shares.getPrice());
			}
			System.out.println("Total value of shares for " + stock.getName() + "is " + allSharesValue);
			allStocksValue = allStocksValue + allSharesValue;
		}
		System.out.println("Total value of all stocks " + allStocksValue);

		return allStocksValue;
	}

	@Override
	public void buy(int noOfShares, String shareName, String stockName) {
		boolean isPresent = false;
		for (int i = 0; i < stocks.getStockList().size(); i++) {
			Stock stock = stocks.getStockList().get(i);
			if (stock.getName().equalsIgnoreCase(stockName)) {
				for (int j = 0; j < stock.getCompanySharesList().size(); j++) {
					CompanyShares shares = stock.getCompanySharesList().get(j);
					if (shares.getStockSymbol().equalsIgnoreCase(shareName)) {
						shares.setNoOfShares(shares.getNoOfShares() + noOfShares);
						isPresent = true;
						break;
					}
				}
				if (!isPresent) {
					CompanyShares companyShares = new CompanyShares();
					companyShares.setDateTime(new Date());
					companyShares.setNoOfShares(noOfShares);
					companyShares.setPrice(10);
					companyShares.setStockSymbol(shareName);
					stock.getCompanySharesList().add(companyShares);
				}
			}
		}

		System.out.println(stocks.toString());
	}

	@Override
	public void sell(int noOfShares, String shareName, String stockName) {

		for (int i = 0; i < stocks.getStockList().size(); i++) {
			Stock stock = stocks.getStockList().get(i);
			if (stock.getName().equalsIgnoreCase(stockName)) {
				for (int j = 0; j < stock.getCompanySharesList().size(); j++) {
					CompanyShares shares = stock.getCompanySharesList().get(j);
					if (shares.getStockSymbol().equalsIgnoreCase(shareName)) {
						shares.setNoOfShares(shares.getNoOfShares() - noOfShares);
						break;
					}
				}
			}
		}
		System.out.println(stocks.toString());

	}

	@Override
	public void save(String fileName) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Java objects to JSON file
			mapper.writeValue(new File("E:\\workspace\\JsonInventory\\stocksCompanyShares.json"), stocks);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printReport() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(stocks);
			System.out.println(jsonInString2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
