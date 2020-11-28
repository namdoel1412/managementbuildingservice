package namdd.managebuilding.webservice.repositories;

import java.util.List;

import namdd.managebuilding.webservice.model.BuildingService;
import namdd.managebuilding.webservice.model.Company;

public interface ICompanyRepository {
	List<Company> getAllCompanies();
	
	Company getCompany(int companyId);
	
	boolean addCompany(Company newData);
	
	boolean updateCompany(int companyId, Company newData);
	
	boolean deleteCompany(int companyId);
}
