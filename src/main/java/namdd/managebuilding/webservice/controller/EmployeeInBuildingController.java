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

import namdd.managebuilding.webservice.model.EmployeeInBuilding;
import namdd.managebuilding.webservice.repositories.IEmployeeInBuildingRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/employeeinbuilding")
public class EmployeeInBuildingController {
	@Autowired
    private IEmployeeInBuildingRepository employeeInBuildingRepo;
 
	public EmployeeInBuildingController(IEmployeeInBuildingRepository employeeInBuildingRepo) {
		this.employeeInBuildingRepo = employeeInBuildingRepo;
	}
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<EmployeeInBuilding> getAllEmployeesInBuilding() {
        List<EmployeeInBuilding> list = employeeInBuildingRepo.getAllEmployeesInBuilding();
        return list;
    }
    
	@GetMapping(value = "/{emplCode}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public EmployeeInBuilding getEmployeeInBuilding(@PathVariable("emplCode") int emplCode) {
		EmployeeInBuilding list = employeeInBuildingRepo.getEmployeeInBuilding(emplCode);
		return list;
	}
	
	@PostMapping(value = "", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean addEmployeeInBuilding(@RequestBody EmployeeInBuilding newData) {
		return employeeInBuildingRepo.addEmployeeInBuilding(newData);
	}
	
	
	@PutMapping(value = "/{emplCode}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean updateEmployeeInBuilding(@PathVariable("emplCode") int emplCode, @RequestBody EmployeeInBuilding newData) {
		return employeeInBuildingRepo.updateEmployeeInBuilding(emplCode, newData);
	}
	
	@DeleteMapping(value = "/{emplCode}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean deleteCompany(@PathVariable("emplCode") int emplCode) {
		return employeeInBuildingRepo.deleteEmployeeInBuilding(emplCode);
	}
}
