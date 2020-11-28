package namdd.managebuilding.webservice.model;

public class EmployeeInCompany {
	private int emplCode;
	private String peopleId;
	private String emplName;
	private String dateOfBirth;
	private String phoneNumber;
	private int companyId;
	public EmployeeInCompany() {
		super();
	}
	public EmployeeInCompany(int emplCode, String peopleId, String emplName, String dateOfBirth, String phoneNumber, int companyId) {
		super();
		this.emplCode = emplCode;
		this.peopleId = peopleId;
		this.emplName = emplName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.companyId = companyId;
	}
	public int getEmplCode() {
		return emplCode;
	}
	public void setEmplCode(int emplCode) {
		this.emplCode = emplCode;
	}
	public String getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(String peopleId) {
		this.peopleId = peopleId;
	}
	public String getEmplName() {
		return emplName;
	}
	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
}
