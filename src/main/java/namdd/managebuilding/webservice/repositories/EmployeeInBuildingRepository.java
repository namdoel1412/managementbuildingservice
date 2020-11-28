package namdd.managebuilding.webservice.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import namdd.managebuilding.webservice.model.BuildingService;
import namdd.managebuilding.webservice.model.Company;
import namdd.managebuilding.webservice.model.EmployeeInBuilding;
import namdd.managebuilding.webservice.util.GetMySqlConnection;

@Service
public class EmployeeInBuildingRepository implements IEmployeeInBuildingRepository{
	public static final String EMPLOYEEINBUILDING = "employeeinbuilding";

	@Override
	public List<EmployeeInBuilding> getAllEmployeesInBuilding() {
		List<EmployeeInBuilding> lstEmployeeInBuilding = new ArrayList<EmployeeInBuilding>();
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "SELECT * FROM " + EMPLOYEEINBUILDING;
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					EmployeeInBuilding tmp = new EmployeeInBuilding(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7));
					lstEmployeeInBuilding.add(tmp);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstEmployeeInBuilding;
	}

	@Override
	public EmployeeInBuilding getEmployeeInBuilding(int emplCode) {
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "SELECT * FROM " + EMPLOYEEINBUILDING + " WHERE emplCode = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setInt(1, emplCode);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					EmployeeInBuilding tmp = new EmployeeInBuilding(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7));
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
	public boolean addEmployeeInBuilding(EmployeeInBuilding newData) {
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "INSERT INTO " + EMPLOYEEINBUILDING + "(peopleId, emplName, dateOfBirth, phoneNumber, address, position) "
					+ " VALUES(?, ?, ?, ?, ?, ?)";
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setString(1, newData.getPeopleId());
				pstmt.setString(2, newData.getEmplName());
				pstmt.setString(3, newData.getDateOfBirth());
				pstmt.setString(4, newData.getPhoneNumber());
				pstmt.setString(5, newData.getAddress());
				pstmt.setString(6, newData.getPosition());
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
	public boolean updateEmployeeInBuilding(int emplCode, EmployeeInBuilding newData) {
		EmployeeInBuilding oldData = getEmployeeInBuilding(emplCode);
		if(oldData != null) {
			if(newData.getPeopleId() != null) {
				oldData.setPeopleId(newData.getPeopleId());
			}
			if(newData.getEmplName() != null) {
				oldData.setEmplName(newData.getEmplName());
			}
			if(newData.getDateOfBirth() != null) {
				oldData.setDateOfBirth(newData.getDateOfBirth());
			}
			if(newData.getPhoneNumber() != null) {
				oldData.setPhoneNumber(newData.getPhoneNumber());
			}
			if(newData.getAddress() != null) {
				oldData.setAddress(newData.getAddress());
			}
			if(newData.getPosition() != null) {
				oldData.setPosition(newData.getPosition());
			}
			try (Connection conn = GetMySqlConnection.getConnection()) {
				String sql = "UPDATE " + EMPLOYEEINBUILDING + " SET ";
				sql += " peopleId = ?, emplName = ?, dateOfBirth = ?, phoneNumber = ?, address = ?, position = ? WHERE emplCode = ?";
				try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
					pstmt.setString(1, oldData.getPeopleId());
					pstmt.setString(2, oldData.getEmplName());
					pstmt.setString(3, oldData.getDateOfBirth());
					pstmt.setString(4, oldData.getPhoneNumber());
					pstmt.setString(5, oldData.getAddress());
					pstmt.setString(6, oldData.getPosition());
					pstmt.setInt(7, emplCode);
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
	public boolean deleteEmployeeInBuilding(int emplCode) {
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "DELETE FROM " + EMPLOYEEINBUILDING + " WHERE emplCode = ? ";
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setInt(1, emplCode);
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
