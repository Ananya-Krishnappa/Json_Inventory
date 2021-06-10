package bridgelabz.jsonInventory;

import java.util.List;

public class Stock {
	private String name;
	private List<Shares> sharesList;
	private List<CompanyShares> companySharesList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Shares> getSharesList() {
		return sharesList;
	}

	public void setSharesList(List<Shares> sharesList) {
		this.sharesList = sharesList;
	}

	public List<CompanyShares> getCompanySharesList() {
		return companySharesList;
	}

	public void setCompanySharesList(List<CompanyShares> companySharesList) {
		this.companySharesList = companySharesList;
	}

	@Override
	public String toString() {
		return "Stock [name=" + name + ", sharesList=" + sharesList + ", companySharesList=" + companySharesList + "]";
	}
}
