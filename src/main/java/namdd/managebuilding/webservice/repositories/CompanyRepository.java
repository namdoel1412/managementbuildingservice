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
import namdd.managebuilding.webservice.util.GetMySqlConnection;

@Service
public class CompanyRepository implements ICompanyRepository{
	
	public static final String COMPANY = "company";

	@Override
	public List<Company> getAllCompanies() {
		List<Company> lstCompany = new ArrayList<Company>();
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "SELECT * FROM " + COMPANY;
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					Company tmp = new Company(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5),
							rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getLong(10));
					lstCompany.add(tmp);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstCompany;
	}

	@Override
	public Company getCompany(int companyId) {
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "SELECT * FROM " + COMPANY + " WHERE companyId = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setInt(1, companyId);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					Company tmp = new Company(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5),
							rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getLong(10));
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
	public boolean addCompany(Company newData) {
		BuildingService res = new BuildingService();
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "INSERT INTO " + COMPANY + "(companyName, taxNumber, authorizedCapital, operationFeild, numOfEmployees,"
					+ " address, locatedBuilding, phoneNumber, groundArea) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setString(1, newData.getCompanyName());
				pstmt.setString(2, newData.getTaxNumber());
				pstmt.setLong(3, newData.getAuthorizedCapital());
				pstmt.setString(4, newData.getOperationFeild());
				pstmt.setLong(5, newData.getNumOfEmployees());
				pstmt.setString(6, newData.getAddress());
				pstmt.setString(7, newData.getLocatedBuilding());
				pstmt.setString(8, newData.getPhoneNumber());
				pstmt.setLong(9, newData.getGroundArea());
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
	public boolean updateCompany(int companyId, Company newData) {
		Company oldData = getCompany(companyId);
		if(oldData != null) {
			if(newData.getCompanyName() != null) {
				oldData.setCompanyName(newData.getCompanyName());
			}
			if(newData.getTaxNumber() != null) {
				oldData.setTaxNumber(newData.getTaxNumber());
			}
			if(newData.getAuthorizedCapital() > 0) {
				oldData.setAuthorizedCapital(newData.getAuthorizedCapital());
			}
			if(newData.getOperationFeild() != null) {
				oldData.setOperationFeild(newData.getOperationFeild());
			}
			if(newData.getNumOfEmployees() > 0) {
				oldData.setNumOfEmployees(newData.getNumOfEmployees());
			}
			if(newData.getAddress() != null) {
				oldData.setAddress(newData.getAddress());
			}
			if(newData.getLocatedBuilding() != null) {
				oldData.setLocatedBuilding(newData.getLocatedBuilding());
			}
			if(newData.getPhoneNumber() != null) {
				oldData.setPhoneNumber(newData.getPhoneNumber());
			}
			if(newData.getGroundArea() > 0) {
				oldData.setGroundArea(newData.getGroundArea());
			}
			try (Connection conn = GetMySqlConnection.getConnection()) {
				String sql = "UPDATE " + COMPANY + " SET ";
				sql += " companyName = ?, taxNumber = ? , authorizedCapital = ? , operationFeild = ? , numOfEmployees = ? ,"
				+ " address = ? , locatedBuilding = ? , phoneNumber = ? , groundArea = ? WHERE companyId = ?";
				try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
					pstmt.setString(1, oldData.getCompanyName());
					pstmt.setString(2, oldData.getTaxNumber());
					pstmt.setLong(3, oldData.getAuthorizedCapital());
					pstmt.setString(4, oldData.getOperationFeild());
					pstmt.setLong(5, oldData.getNumOfEmployees());
					pstmt.setString(6, oldData.getAddress());
					pstmt.setString(7, oldData.getLocatedBuilding());
					pstmt.setString(8, oldData.getPhoneNumber());
					pstmt.setLong(9, oldData.getGroundArea());
					pstmt.setInt(10, companyId);
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
	public boolean deleteCompany(int companyId) {
		try (Connection conn = GetMySqlConnection.getConnection()) {
			String sql = "DELETE FROM " + COMPANY + " WHERE companyId = ? ";
			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.setInt(1, companyId);
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
