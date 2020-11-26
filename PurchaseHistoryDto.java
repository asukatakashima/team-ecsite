package jp.co.internous.lollipop.model.domain.dto;



public class PurchaseHistoryDto{

	
	//tbl_purchase_history
	private String purchasedAt;
	private int productCount;
	//mst_product
	private String productName;
	private int price;
	//mst_destination
	private String familyName,firstName;
	private String address;
	
	
	public String getPurchasedAt() {
		return purchasedAt;
	}
	public void  setPurchasedAt(String purchasedAt) {
		this.purchasedAt = purchasedAt;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price  = price;
	}

	public String getFamilyName() {
		return familyName ;
	}
	public void setFamilyName(String familyName) {
		this.familyName=familyName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
		
}
