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

import namdd.managebuilding.webservice.model.BuildingService;
import namdd.managebuilding.webservice.model.Company;
import namdd.managebuilding.webservice.repositories.IBuildingServiceRepository;
import namdd.managebuilding.webservice.repositories.ICompanyRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/company")
public class CompanyController {
	@Autowired
    private ICompanyRepository companyRepo;
 
	public CompanyController(ICompanyRepository companyRepo) {
		this.companyRepo = companyRepo;
	}
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Company> getAllCompanies() {
        List<Company> list = companyRepo.getAllCompanies();
        return list;
    }
    
	@GetMapping(value = "/{companyId}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Company getCompany(@PathVariable("companyId") int companyId) {
		Company list = companyRepo.getCompany(companyId);
		return list;
	}
	
	@PostMapping(value = "", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean addCompany(@RequestBody Company data) {
		return companyRepo.addCompany(data);
	}
	
	
	@PutMapping(value = "/{companyId}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean updateCompany(@PathVariable("companyId") int companyId, @RequestBody Company data) {
		return companyRepo.updateCompany(companyId, data);
	}
	
	@DeleteMapping(value = "/{companyId}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean deleteCompany(@PathVariable("companyId") int companyId) {
		return companyRepo.deleteCompany(companyId);
	}
}
