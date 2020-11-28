package namdd.managebuilding.webservice.model;

public class Company {
public Company() {
		super();
	}
//	 tên
//	 công ty, mã số thuế, vốn điều lệ, lĩnh vực hoạt động, số nhân viên, địa chỉ
//	 trong toà nhà, số điện thoại, diện tích mặt bằng. 
	private int companyId;
	private String companyName;
	private String taxNumber;
	private long authorizedCapital;
	private String operationFeild;
	private int numOfEmployees;
	private String address;
	private String locatedBuilding;
	private String phoneNumber;
	private long groundArea;
	public Company(int companyId, String companyName, String taxNumber, long authorizedCapital,
			String operationFeild, int numOfEmployees, String address, String locatedBuilding, String phoneNumber,
			long groundArea) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.taxNumber = taxNumber;
		this.authorizedCapital = authorizedCapital;
		this.operationFeild = operationFeild;
		this.numOfEmployees = numOfEmployees;
		this.address = address;
		this.locatedBuilding = locatedBuilding;
		this.phoneNumber = phoneNumber;
		this.groundArea = groundArea;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	public long getAuthorizedCapital() {
		return authorizedCapital;
	}
	public void setAuthorizedCapital(long authorizedCapital) {
		this.authorizedCapital = authorizedCapital;
	}
	public String getOperationFeild() {
		return operationFeild;
	}
	public void setOperationFeild(String operationFeild) {
		this.operationFeild = operationFeild;
	}
	public int getNumOfEmployees() {
		return numOfEmployees;
	}
	public void setNumOfEmployees(int numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocatedBuilding() {
		return locatedBuilding;
	}
	public void setLocatedBuilding(String locatedBuilding) {
		this.locatedBuilding = locatedBuilding;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getGroundArea() {
		return groundArea;
	}
	public void setGroundArea(long groundArea) {
		this.groundArea = groundArea;
	}
	
	
}
