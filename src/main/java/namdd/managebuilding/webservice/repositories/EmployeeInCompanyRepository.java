package namdd.managebuilding.webservice.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import namdd.managebuilding.webservice.model.BuildingService;
import namdd.managebuilding.webservice.model.EmployeeInBuilding;
import namdd.managebuilding.webservice.model.EmployeeInCompany;
import namdd.managebuilding.webservice.util.GetMySqlConnection;

@Service
public class EmployeeInCompanyRepository implements IEmployeeInCompanyRepository{
	public static final String EMPLOYEEINCOMPANY = "employeeincompany";

	@Override
	public List<EmployeeInCompany> getAllEmployees() {
		List<EmployeeInCompany> lstEmployeeInCompany = new ArrayList<EmployeeInCompany>();
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "SELECT * FROM " + EMPLOYEEINCOMPANY;
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					EmployeeInCompany tmp = new EmployeeInCompany(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
					lstEmployeeInCompany.add(tmp);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstEmployeeInCompany;
	}

	@Override
	public EmployeeInCompany getEmployee(int emplCode) {
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "SELECT * FROM " + EMPLOYEEINCOMPANY + " WHERE emplCode = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setInt(1, emplCode);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					EmployeeInCompany tmp = new EmployeeInCompany(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
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
	public boolean addEmployee(EmployeeInCompany newData) {
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "INSERT INTO " + EMPLOYEEINCOMPANY + "(peopleId, emplName, dateOfBirth, phoneNumber, companyId) "
					+ " VALUES(?, ?, ?, ?, ?)";
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setString(1, newData.getPeopleId());
				pstmt.setString(2, newData.getEmplName());
				pstmt.setString(3, newData.getDateOfBirth());
				pstmt.setString(4, newData.getPhoneNumber());
				pstmt.setInt(5, newData.getCompanyId());
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
	public boolean updateEmployee(int emplCode, EmployeeInCompany newData) {
		EmployeeInCompany oldData = getEmployee(emplCode);
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
			if(newData.getCompanyId() != 0) {
				oldData.setCompanyId(newData.getCompanyId());
			}
			try (Connection conn = GetMySqlConnection.getConnection()) {
				String sql = "UPDATE " + EMPLOYEEINCOMPANY + " SET ";
				sql += " peopleId = ?, emplName = ?, dateOfBirth = ?, phoneNumber = ?, companyId = ? WHERE emplCode = ?";
				try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
					pstmt.setString(1, oldData.getPeopleId());
					pstmt.setString(2, oldData.getEmplName());
					pstmt.setString(3, oldData.getDateOfBirth());
					pstmt.setString(4, oldData.getPhoneNumber());
					pstmt.setInt(5, oldData.getCompanyId());
					pstmt.setInt(6, emplCode);
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
	public boolean deleteEmployee(int emplCode) {
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "DELETE FROM " + EMPLOYEEINCOMPANY + " WHERE emplCode = ? ";
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
	
	@Override
	public List<EmployeeInCompany> getAllEmployeesInACompany(int companyId) {
		List<EmployeeInCompany> lstEmployeeInCompany = new ArrayList<EmployeeInCompany>();
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "SELECT * FROM " + EMPLOYEEINCOMPANY + " where companyId = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setInt(1, companyId);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					EmployeeInCompany tmp = new EmployeeInCompany(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
					lstEmployeeInCompany.add(tmp);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstEmployeeInCompany;
	}
}
