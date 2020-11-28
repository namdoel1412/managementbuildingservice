package namdd.managebuilding.webservice.model;

public class EmployeeInBuilding {
	private int emplCode;
	private String peopleId;
	private String emplName;
	private String dateOfBirth;
	private String phoneNumber;
	private String address;
	private String position;
	public EmployeeInBuilding(int emplCode, String peopleId, String emplName, String dateOfBirth, String phoneNumber,
			String address, String position) {
		super();
		this.emplCode = emplCode;
		this.peopleId = peopleId;
		this.emplName = emplName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.position = position;
	}
	public EmployeeInBuilding() {
		super();
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
