package namdd.managebuilding.webservice.repositories;

import java.util.List;

import namdd.managebuilding.webservice.model.EmployeeInCompany;

public interface IEmployeeInCompanyRepository {
	List<EmployeeInCompany> getAllEmployees();
	
	EmployeeInCompany getEmployee(int emplCode);
	
	boolean addEmployee(EmployeeInCompany newData);
	
	boolean updateEmployee(int emplCode, EmployeeInCompany newData);
	
	boolean deleteEmployee(int emplCode);
	
	List<EmployeeInCompany> getAllEmployeesInACompany(int companyId);
}
