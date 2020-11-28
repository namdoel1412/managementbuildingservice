package namdd.managebuilding.webservice.repositories;

import java.lang.reflect.Array;
import java.util.List;

import namdd.managebuilding.webservice.model.BuildingService;


public interface IBuildingServiceRepository {
	List<BuildingService> getAllBuildingService();
	
	BuildingService getBuildingService(String serviceCode);
	
	boolean addBuildingService(BuildingService newData);
	
	boolean updateBuildingService(String serviceCode, BuildingService newData);
	
	boolean deleteBuildingService(String serviceCode);
}
