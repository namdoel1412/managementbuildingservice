package namdd.managebuilding.webservice.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import namdd.managebuilding.webservice.model.BuildingService;
import namdd.managebuilding.webservice.util.GetMySqlConnection;

@Service
public class BuildingServiceRepository implements IBuildingServiceRepository {

	public static final String BUILDINGSERVICE = "buildingservice";

	@Override
	public List<BuildingService> getAllBuildingService() {
		List<BuildingService> lstBuildingService = new ArrayList<BuildingService>();
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "SELECT * FROM " + BUILDINGSERVICE;
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					BuildingService tmp = new BuildingService(rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5));
					lstBuildingService.add(tmp);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//lstBuildingService.add(new BuildingService(1, "Nam1", "Nam2", 22));
		return lstBuildingService;
	}

	@Override
	public BuildingService getBuildingService(String serviceCode) {
		//BuildingService res = new BuildingService();
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "SELECT * FROM " + BUILDINGSERVICE + " WHERE serviceCode = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setString(1, serviceCode);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					BuildingService tmp = new BuildingService(rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5));
					return tmp;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addBuildingService(BuildingService newData) {
		BuildingService res = new BuildingService();
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "INSERT INTO " + BUILDINGSERVICE + "(serviceCode, serviceName, typeOfService, price) VALUES(?, ?, ?, ?)";
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setString(1, newData.getServiceCode());
				pstmt.setString(2, newData.getServiceName());
				pstmt.setString(3, newData.getTypeOfSerive());
				pstmt.setLong(4, newData.getPrice());
				int affectedRows = pstmt.executeUpdate();
				if(affectedRows > 0) return true;
				return false;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateBuildingService(String serviceCode, BuildingService newData) {
		BuildingService oldService = getBuildingService(serviceCode);
		if(oldService != null) {
			if(newData.getServiceCode() != null) {
				oldService.setServiceCode(newData.getServiceCode());
			}
			if(newData.getServiceName() != null) {
				oldService.setServiceName(newData.getServiceName());
			}
			if(newData.getTypeOfSerive() != null) {
				oldService.setTypeOfSerive(newData.getTypeOfSerive());
			}
			if(newData.getPrice() >= 0) {
				oldService.setPrice(newData.getPrice());
			}
			try (Connection conn = GetMySqlConnection.getConnection()) {
				String sql = "UPDATE " + BUILDINGSERVICE + " SET ";
				sql += " serviceCode = ?, serviceName = ?, typeOfService = ?, price = ? WHERE serviceCode = ?";
				try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
					pstmt.setString(1, oldService.getServiceCode());
					pstmt.setString(2, oldService.getServiceName());
					pstmt.setString(3, oldService.getTypeOfSerive());
					pstmt.setLong(4, oldService.getPrice());
					pstmt.setString(5, serviceCode);
					int affectedRows = pstmt.executeUpdate();
					if(affectedRows > 0) return true;
					return false;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteBuildingService(String serviceCode) {
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "DELETE FROM " + BUILDINGSERVICE + " WHERE serviceCode = ? ";
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setString(1, serviceCode);
				int affectedRows = pstmt.executeUpdate();
				if(affectedRows > 0) return true;
				return false;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
