package namdd.managebuilding.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import namdd.managebuilding.webservice.model.EmployeeInCompany;
import namdd.managebuilding.webservice.repositories.IEmployeeInCompanyRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/employeeincompany")
public class EmployeeInCompanyController {
	@Autowired
    private IEmployeeInCompanyRepository employeeInCompanyRepo;
 
	public EmployeeInCompanyController(IEmployeeInCompanyRepository employeeInCompanyRepo) {
		this.employeeInCompanyRepo = employeeInCompanyRepo;
	}
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<EmployeeInCompany> getAllEmployees() {
        List<EmployeeInCompany> list = employeeInCompanyRepo.getAllEmployees();
        return list;
    }
    
	@GetMapping(value = "/{emplCode}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public EmployeeInCompany getEmployeeInCompany(@PathVariable("emplCode") int emplCode) {
		EmployeeInCompany res = employeeInCompanyRepo.getEmployee(emplCode);
		return res;
	}
	
	@PostMapping(value = "", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean addEmployee(@RequestBody EmployeeInCompany newData) {
		return employeeInCompanyRepo.addEmployee(newData);
	}
	
	
	@PutMapping(value = "/{emplCode}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean updateEmployee(@PathVariable("emplCode") int emplCode, @RequestBody EmployeeInCompany newData) {
		return employeeInCompanyRepo.updateEmployee(emplCode, newData);
	}
	
	@DeleteMapping(value = "/{emplCode}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean deleteCompany(@PathVariable("emplCode") int emplCode) {
		return employeeInCompanyRepo.deleteEmployee(emplCode);
	}
	
	@GetMapping(value = "/company/{companyId}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<EmployeeInCompany> getEmployeesInACompany(@PathVariable("companyId") int companyId) {
		return employeeInCompanyRepo.getAllEmployeesInACompany(companyId);
	}
}
