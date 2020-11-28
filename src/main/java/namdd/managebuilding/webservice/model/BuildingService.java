package namdd.managebuilding.webservice.model;

public class BuildingService {
	private String serviceCode;
	private String serviceName;
	private String typeOfSerive;
	private long price;
	public BuildingService(String serviceCode, String serviceName, String typeOfSerive, long price) {
		super();
		this.serviceCode = serviceCode;
		this.serviceName = serviceName;
		this.typeOfSerive = typeOfSerive;
		this.price = price;
	}
	public BuildingService() {
		super();
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getTypeOfSerive() {
		return typeOfSerive;
	}
	public void setTypeOfSerive(String typeOfSerive) {
		this.typeOfSerive = typeOfSerive;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	
	
}
