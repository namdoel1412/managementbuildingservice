package namdd.managebuilding.webservice.repositories;

import java.util.List;

import namdd.managebuilding.webservice.model.EmployeeInBuilding;

public interface IEmployeeInBuildingRepository {
	List<EmployeeInBuilding> getAllEmployeesInBuilding();
	
	EmployeeInBuilding getEmployeeInBuilding(int emplCode);
	
	boolean addEmployeeInBuilding(EmployeeInBuilding newData);
	
	boolean updateEmployeeInBuilding(int emplCode, EmployeeInBuilding newData);
	
	boolean deleteEmployeeInBuilding(int emplCode);
}
					