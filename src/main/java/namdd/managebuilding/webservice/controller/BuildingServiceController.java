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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import namdd.managebuilding.webservice.model.BuildingService;
import namdd.managebuilding.webservice.repositories.IBuildingServiceRepository;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/buildingservices")
public class BuildingServiceController {

	@Autowired
    private IBuildingServiceRepository building;
 
	public BuildingServiceController(IBuildingServiceRepository building) {
		this.building = building;
	}
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<BuildingService> getAllBuildingService() {
        List<BuildingService> list = building.getAllBuildingService();
        return list;
    }
    
	@GetMapping(value = "/{serviceCode}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public BuildingService getBuildingService(@PathVariable("serviceCode") String serviceCode) {
		BuildingService list = building.getBuildingService(serviceCode);
		return list;
	}
	
	@PostMapping(value = "", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean addBuildingService(@RequestBody BuildingService buildingService) {
		return building.addBuildingService(buildingService);
	}
	
	
	@PutMapping(value = "/{serviceCode}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean updateBuildingService(@PathVariable("serviceCode") String serviceCode, @RequestBody BuildingService buildingService) {
		return building.updateBuildingService(serviceCode, buildingService);
	}
	
	@DeleteMapping(value = "/{serviceCode}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean deleteBuildingService(@PathVariable("serviceCode") String serviceCode) {
		return building.deleteBuildingService(serviceCode);
	}
}
