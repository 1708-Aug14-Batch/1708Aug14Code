package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ers.pojos.Request;
import com.ers.pojos.Status;
import com.ers.pojos.User;
import com.ers.util.ConnectionFactory;

public class DatabaseDao implements Dao {
	private final static Logger log = Logger.getLogger(DatabaseDao.class);

	public User getUser(String email, String password) {
		User user = null;

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT USERID, FIRSTNAME, LASTNAME, ISMANAGER " + "FROM USERS "
					+ "WHERE LOWER(EMAIL) = ? AND PASSWORD = ?";

			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, email.toLowerCase());
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt(1);
				String first = rs.getString(2);
				String last = rs.getString(3);
				int isManager = rs.getInt(4);
				user = new User(email, password, first, last, 0 != isManager);
				user.setUserId(userId);
				
				break;
			}

		} catch (SQLException e) {
			log.warn("getUser(email, password)" + e.getLocalizedMessage());
		}

		log.trace("getUser(email=" + email + ", password=" + password + ") -> " + user);
		return user;
	}

	public User getUser(int userId) {
		User user = null;

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT EMAIL, PASSWORD, FIRSTNAME, LASTNAME, ISMANAGER " + "FROM USERS " + "WHERE USERID = ?";

			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String email = rs.getString(1);
				String password = rs.getString(2);
				String first = rs.getString(3);
				String last = rs.getString(4);
				int isManager = rs.getInt(5);
				user = new User(email, password, first, last, 0 == isManager);
				user.setUserId(userId);
				break;
			}

		} catch (SQLException e) {
			log.warn("getUser(userId=" + userId + "): " + e.getLocalizedMessage());
		}

		log.trace("getUser(userId=" + userId + ") -> " + user);
		return user;
	}

	public boolean hasUser(int userId) {
		boolean hasUser = false;

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT EMAIL, PASSWORD, FNAME, LNAME, ISMGNR " + "FROM USERS " + "WHERE USERID = ?";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);

			hasUser = ps.executeQuery().next();

		} catch (SQLException e) {
			log.warn("hasUser(userId=" + userId + "): " + e.getLocalizedMessage());
		}

		log.trace("hasUser(userId=" + userId + ") -> " + hasUser);
		return hasUser;
	}

	public boolean hasUser(String email) {
		boolean hasUser = false;

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT USERID, PASSWORD, FIRSTNAME, LASTNAME, ISMANAGER FROM USERS "
					   + "WHERE EMAIL = ?";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);

			hasUser = ps.executeQuery().next();

		} catch (SQLException e) {
			log.warn("hasUser(email=" + email + "): " + e.getLocalizedMessage());
		}

		log.trace("hasUser(email=" + email + ") -> " + hasUser);
		return hasUser;
	}

	public int addUser(User user) {
		int userId = -1;
		
		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "INSERT INTO USERS (EMAIL, PASSWORD, FIRSTNAME, LASTNAME, ISMANAGER) "
					   + "VALUES (?, ?, ?, ?, ?)";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setInt(5, (user.isManager()) ? 1 : 0);

			int rowsAdded = ps.executeUpdate();

			if (rowsAdded != 1) {
				log.info("addUser(user=" + user + "): Bad insert, " + rowsAdded + " rows added");
			} else {
				log.trace("addUser(user=" + user + "): " + rowsAdded + " rows inserted (should be 1)");
			}
			
			sql = "SELECT USERID FROM USERS "
				+ "WHERE EMAIL = ?";
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				userId = rs.getInt(1);
			}

		} catch (SQLException e) {
			log.warn("addUser(user): " + e.getLocalizedMessage());
		}
		
		return userId;
	}

	public boolean setEmail(int userId, String email) {
		boolean isSuccess = false;
		
		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "UPDATE USERS " + "SET EMAIL = ? " + "WHERE USERID = ?";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setInt(2, userId);

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated != 1) {
				
				log.info("setEmail(userId=" + userId + ", email=" + email + "): Bad update, " + rowsUpdated
						+ " rows updated");
			} else {
				
				log.trace("setEmail(userId=" + userId + ", email=" + email + "): " + rowsUpdated
						+ " rows updated (should be 1)");
				isSuccess = true;
			}

		} catch (SQLException e) {
			log.warn("setEmail(userId=" + userId + ", email=" + email + "): " + e.getLocalizedMessage());
		}
		return isSuccess;
	}

	public boolean setPassword(int userId, String password) {
		boolean isSuccess = false;
		
		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "UPDATE USERS " + "SET PASSWORD = ? " + "WHERE USERID = ?";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, userId);

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated != 1) {
			
				log.info("setPassword(userId=" + userId + ", password=" + password + "): Bad update, " + rowsUpdated
						+ " rows updated");
			} else {
				
				log.trace("setPassword(userId=" + userId + ", password=" + password + "): " + rowsUpdated
						+ " rows updated (should be 1)");
				isSuccess = true;
			}

		} catch (SQLException e) {
			log.warn("setPassword(userId=" + userId + ", password=" + password + "): " + e.getLocalizedMessage());
		}
		return isSuccess;
	}

	public boolean setFirstName(int userId, String firstName) {
		boolean isSuccess = false;
		
		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "UPDATE USERS " + "SET FIRSTNAME = ? " + "WHERE USERID = ?";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setInt(2, userId);

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated != 1) {
				
				log.info("setFirstName(userId=" + userId + ", firstName=" + firstName + "): Bad update, " + rowsUpdated
						+ " rows updated");
			} else {
				
				log.trace("setFirstName(userId=" + userId + ", firstName=" + firstName + "): " + rowsUpdated
						+ " rows updated (should be 1)");
				isSuccess = true;
			}

		} catch (SQLException e) {
			log.warn("setFirstName(userId=" + userId + ", firstName=" + firstName + "): " + e.getLocalizedMessage());
		}
		return isSuccess;
	}

	public boolean setLastName(int userId, String lastName) {
		boolean isSuccess = false;
		
		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "UPDATE USERS " + "SET LASTNAME = ? " + "WHERE USERID = ?";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, lastName);
			ps.setInt(2, userId);

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated != 1) {
				
				log.info("setlastName(userId=" + userId + ", lastName=" + lastName + "): Bad update, " + rowsUpdated
						+ " rows updated");
			} else {
				
				log.trace("setLastName(userId=" + userId + ", lastName=" + lastName + "): " + rowsUpdated
						+ " rows updated (should be 1)");
				isSuccess = true;
			}

		} catch (SQLException e) {
			log.warn("setLastName(userId=" + userId + ", lastName=" + lastName + "): " + e.getLocalizedMessage());
		}
		return isSuccess;
	}

	public boolean submitRequest(int userId, float amount, String description) {
		boolean isSuccess = false;

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "INSERT INTO REQUESTS " + "(SUBMITTERID, DESCRIPTION, AMOUNT) " + "VALUES (?, ?, ?)";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, description);
			ps.setFloat(3, amount);

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated != 1) {
				log.info("submitRequest(userId=" + userId + ", amount=" + amount + ", description=" + description
						+ "): Bad update, " + rowsUpdated + " rows updated");
			} else {
				log.trace("submitRequest(userId=" + userId + ", amount=" + amount + ", description=" + description
						+ "): " + rowsUpdated + " rows inserted (should be 1)");
				
				isSuccess = true;
			}

		} catch (SQLException e) {
			log.warn("submitRequest(userId=" + userId + ", amount=" + amount + ", description=" + description + "): "
					+ e.getLocalizedMessage());
		}
		return isSuccess;
	}
	
	public boolean withdrawRequest(int requestId) {
		boolean isSuccess = false;
		
		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "DELETE FROM REQUESTS WHERE REQUESTID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, requestId);
			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated != 1) {
				
				log.info("withdrawRequest(requestId=" + requestId+"): Bad update, " + rowsUpdated + " rows updated");
			} else {
				
				log.trace("withdrawRequest(requestId=" + requestId+"): " + rowsUpdated + " rows inserted (should be 1)");
				isSuccess = true;
			}
			
		} catch (SQLException e) {
			log.warn("withdrawRequest(requestId=" + requestId+"): "
					+ e.getLocalizedMessage());
		}
		return isSuccess;
	}

	public List<Request> getUserRequests(int userId) {
		List<Request> requests = new ArrayList<>();

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT R.REQUESTID, CONCAT(U.FIRSTNAME CONCAT(' ', U.LASTNAME)), R.SUBMITDATE, R.RESOLVERID, "
					   + "       R.RESOLVEDATE, R.STATUS, R.DESCRIPTION, R.RESOLVENOTE, R.AMOUNT FROM REQUESTS R "
					   + "INNER JOIN USERS U ON U.USERID = R.SUBMITTERID "
					   + "WHERE R.SUBMITTERID = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int reqId = rs.getInt(1);
				String name = rs.getString(2);
				Timestamp subDate = rs.getTimestamp(3);
				int resId = rs.getInt(4);
				Timestamp resDate = rs.getTimestamp(5);
				String status = Status.getName(rs.getInt(6));
				String desc = rs.getString(7);
				String notes = rs.getString(8);
				float amount = rs.getFloat(9);
				
				requests.add(new Request(reqId, userId, name, subDate, resId, resDate, status, desc, notes, amount));
			}

		} catch (SQLException e) {
			log.warn("getUserRequests(userId=" + userId + "): " + e.getLocalizedMessage());
		}

		log.trace("getUserRequests(userId="+userId+") -> " + ((requests != null) ? requests.size() : null) + " Request objects");
		return requests;
	}

	public List<Request> getPendingRequests(int userId) {
		List<Request> pendingRequests = new ArrayList<>();

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT R.REQUESTID, CONCAT(U.FIRSTNAME CONCAT(' ', U.LASTNAME)), R.SUBMITDATE, R.RESOLVERID, "
					   + "       R.RESOLVEDATE, R.STATUS, R.DESCRIPTION, R.RESOLVENOTE, R.AMOUNT FROM REQUESTS R "
					   + "INNER JOIN USERS U ON U.USERID = R.SUBMITTERID "
					   + "		 WHERE R.SUBMITTERID = ? AND r.STATUS = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, Status.PENDING);
			
			ResultSet rs = ps.executeQuery();			
			while (rs.next()) {
				int reqId = rs.getInt(1);
				String name = rs.getString(2);
				Timestamp subDate = rs.getTimestamp(3);
				int resId = rs.getInt(4);
				Timestamp resDate = rs.getTimestamp(5);
				String status = Status.getName(rs.getInt(6));
				String desc = rs.getString(7);
				String notes = rs.getString(8);
				float amount = rs.getFloat(9);
				
				pendingRequests.add(new Request(reqId, userId, name, subDate, resId, resDate, status, desc, notes, amount));
			}

		} catch (SQLException e) {
			log.warn("getPendingRequests(userId=" + userId + "): " + e.getLocalizedMessage());
		}

		log.trace("getPendingRequests(userId="+userId+") -> " + ((pendingRequests != null) ? pendingRequests.size() : null) + " Request objects");
		return pendingRequests;
	}

	public List<Request> getApprovedRequests(int userId) {
		List<Request> approvedRequests = new ArrayList<>();

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT R.REQUESTID, CONCAT(U.FIRSTNAME CONCAT(' ', U.LASTNAME)), R.SUBMITDATE, R.RESOLVERID, "
					   + "       R.RESOLVEDATE, R.STATUS, R.DESCRIPTION, R.RESOLVENOTE, R.AMOUNT FROM REQUESTS R "
					   + "INNER JOIN USERS U ON U.USERID = R.SUBMITTERID "
					   + "WHERE R.SUBMITTERID = ? AND R.STATUS = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, Status.APPROVED);
			
			ResultSet rs = ps.executeQuery();			
			while (rs.next()) {
				int reqId = rs.getInt(1);
				String name = rs.getString(2);
				Timestamp subDate = rs.getTimestamp(3);
				int resId = rs.getInt(4);
				Timestamp resDate = rs.getTimestamp(5);
				String status = Status.getName(rs.getInt(6));
				String desc = rs.getString(7);
				String notes = rs.getString(8);
				float amount = rs.getFloat(9);
				
				approvedRequests.add(new Request(reqId, userId, name, subDate, resId, resDate, status, desc, notes, amount));
			}

		} catch (SQLException e) {
			log.warn("getApprovedRequests(userId=" + userId + "): " + e.getLocalizedMessage());
		}

		log.trace("getApprovedRequests(userId="+userId+") -> " + ((approvedRequests != null) ? approvedRequests.size() : null) + " Request objects");
		return approvedRequests;
	}

	public List<Request> getDeniedRequests(int userId) {
		List<Request> deniedRequests = new ArrayList<>();

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT R.REQUESTID, CONCAT(U.FIRSTNAME CONCAT(' ', U.LASTNAME)), R.SUBMITDATE, R.RESOLVERID, "
					   + "       R.RESOLVEDATE, R.STATUS, R.DESCRIPTION, R.RESOLVENOTE, R.AMOUNT FROM REQUESTS R "
					   + "INNER JOIN USERS U ON U.USERID = R.SUBMITTERID "
					   + "WHERE R.SUBMITTERID = ? AND R.STATUS = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, Status.DENIED);
			
			ResultSet rs = ps.executeQuery();			
			while (rs.next()) {
				int reqId = rs.getInt(1);
				String name = rs.getString(2);
				Timestamp subDate = rs.getTimestamp(3);
				int resId = rs.getInt(4);
				Timestamp resDate = rs.getTimestamp(5);
				String status = Status.getName(rs.getInt(6));
				String desc = rs.getString(7);
				String notes = rs.getString(8);
				float amount = rs.getFloat(9);
				
				deniedRequests.add(new Request(reqId, userId, name, subDate, resId, resDate, status, desc, notes, amount));
			}

		} catch (SQLException e) {
			log.warn("getDeniedRequests(userId=" + userId + "): " + e.getLocalizedMessage());
		}

		log.trace("getDeniedRequests(userId="+userId+") -> " + ((deniedRequests != null) ? deniedRequests.size() : null) + " Request objects");
		return deniedRequests;
	}

	public List<Request> getResolvedRequests(int userId) {
		List<Request> resolvedRequests = new ArrayList<>();

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT R.REQUESTID, CONCAT(U.FIRSTNAME CONCAT(' ', U.LASTNAME)), R.SUBMITDATE, R.RESOLVERID, "
					   + "       R.RESOLVEDATE, R.STATUS, R.DESCRIPTION, R.RESOLVENOTE, R.AMOUNT FROM REQUESTS R "
					   + "INNER JOIN USERS U ON U.USERID = R.SUBMITTERID "
					   + "WHERE R.SUBMITTERID = ? AND NOT R.STATUS = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, Status.PENDING);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int reqId = rs.getInt(1);
				String name = rs.getString(2);
				Timestamp subDate = rs.getTimestamp(3);
				int resId = rs.getInt(4);
				Timestamp resDate = rs.getTimestamp(5);
				String status = Status.getName(rs.getInt(6));
				String desc = rs.getString(7);
				String notes = rs.getString(8);
				float amount = rs.getFloat(9);
				
				resolvedRequests.add(new Request(reqId, userId, name, subDate, resId, resDate, status, desc, notes, amount));
			}

		} catch (SQLException e) {
			log.warn("getResolvedRequests(userId=" + userId + "): " + e.getLocalizedMessage());
		}

		log.trace("getResolvedRequests(userId="+userId+") -> " + ((resolvedRequests != null) ? resolvedRequests.size() : null) + " Request objects");
		return resolvedRequests;
	}

	public List<Request> getAllUserRequests() {
		List<Request> allRequests = new ArrayList<>();

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT R.REQUESTID, U.USERID, CONCAT(U.FIRSTNAME CONCAT(' ', U.LASTNAME)), R.SUBMITDATE, R.RESOLVERID, "
					   + "       R.RESOLVEDATE, R.STATUS, R.DESCRIPTION, R.RESOLVENOTE, R.AMOUNT FROM REQUESTS R "
					   + "INNER JOIN USERS U ON U.USERID = R.SUBMITTERID";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int reqId = rs.getInt(1);
				int subId = rs.getInt(2);
				String name = rs.getString(3);
				Timestamp subDate = rs.getTimestamp(4);
				int resId = rs.getInt(5);
				Timestamp resDate = rs.getTimestamp(6);
				String status = Status.getName(rs.getInt(7));
				String desc = rs.getString(8);
				String notes = rs.getString(9);
				float amount = rs.getFloat(10);
				
				allRequests.add(new Request(reqId, subId, name, subDate, resId, resDate, status, desc, notes, amount));
			}

		} catch (SQLException e) {
			log.warn("getAllRequests(): " + e.getLocalizedMessage());
		}

		log.trace("getAllRequests() -> " + ((allRequests != null) ? allRequests.size() : null) + " Request objects");
		return allRequests;
	}

	public List<Request> getAllPendingRequests() {
		List<Request> allPendingRequests = new ArrayList<>();

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT R.REQUESTID, U.USERID, CONCAT(U.FIRSTNAME CONCAT(' ', U.LASTNAME)), R.SUBMITDATE, R.RESOLVERID, "
					   + "       R.RESOLVEDATE, R.STATUS, R.DESCRIPTION, R.RESOLVENOTE, R.AMOUNT FROM REQUESTS R "
					   + "INNER JOIN USERS U ON U.USERID = R.SUBMITTERID "
					   + "WHERE STATUS = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, Status.PENDING);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int reqId = rs.getInt(1);
				int subId = rs.getInt(2);
				String name = rs.getString(3);
				Timestamp subDate = rs.getTimestamp(4);
				int resId = rs.getInt(5);
				Timestamp resDate = rs.getTimestamp(6);
				String status = Status.getName(rs.getInt(7));
				String desc = rs.getString(8);
				String notes = rs.getString(9);
				float amount = rs.getFloat(10);
				
				allPendingRequests.add(new Request(reqId, subId, name, subDate, resId, resDate, status, desc, notes, amount));
			}

		} catch (SQLException e) {
			log.warn("getAllPendingRequests(): " + e.getLocalizedMessage());
		}

		log.trace("getAllPendingRequests() -> " + ((allPendingRequests != null) ? allPendingRequests.size() : null) + " Request objects");
		return allPendingRequests;
	}

	public List<Request> getAllApprovedRequests() {
		List<Request> allApprovedRequests = new ArrayList<>();

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT R.REQUESTID, U.USERID, CONCAT(U.FIRSTNAME CONCAT(' ', U.LASTNAME)), R.SUBMITDATE, R.RESOLVERID, "
					   + "       R.RESOLVEDATE, R.STATUS, R.DESCRIPTION, R.RESOLVENOTE, R.AMOUNT FROM REQUESTS R "
					   + "INNER JOIN USERS U ON U.USERID = R.SUBMITTERID "
					   + "WHERE STATUS = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, Status.APPROVED);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int reqId = rs.getInt(1);
				int subId = rs.getInt(2);
				String name = rs.getString(3);
				Timestamp subDate = rs.getTimestamp(4);
				int resId = rs.getInt(5);
				Timestamp resDate = rs.getTimestamp(6);
				String status = Status.getName(rs.getInt(7));
				String desc = rs.getString(8);
				String notes = rs.getString(9);
				float amount = rs.getFloat(10);
				
				allApprovedRequests.add(new Request(reqId, subId, name, subDate, resId, resDate, status, desc, notes, amount));
			}

		} catch (SQLException e) {
			log.warn("getAllApprovedRequests(): " + e.getLocalizedMessage());
		}

		log.trace("getAllApprovedRequests() -> " + ((allApprovedRequests != null) ? allApprovedRequests.size() : null) + " Request objects");
		return allApprovedRequests;
	}

	public List<Request> getAllDeniedRequests() {
		List<Request> allDeniedRequests = new ArrayList<>();

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT R.REQUESTID, U.USERID, CONCAT(U.FIRSTNAME CONCAT(' ', U.LASTNAME)), R.SUBMITDATE, R.RESOLVERID, "
					   + "       R.RESOLVEDATE, R.STATUS, R.DESCRIPTION, R.RESOLVENOTE, R.AMOUNT FROM REQUESTS R "
					   + "INNER JOIN USERS U ON U.USERID = R.SUBMITTERID "
					   + "WHERE STATUS = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, Status.DENIED);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int reqId = rs.getInt(1);
				int subId = rs.getInt(2);
				String name = rs.getString(3);
				Timestamp subDate = rs.getTimestamp(4);
				int resId = rs.getInt(5);
				Timestamp resDate = rs.getTimestamp(6);
				String status = Status.getName(rs.getInt(7));
				String desc = rs.getString(8);
				String notes = rs.getString(9);
				float amount = rs.getFloat(10);
				
				allDeniedRequests.add(new Request(reqId, subId, name, subDate, resId, resDate, status, desc, notes, amount));
			}

		} catch (SQLException e) {
			log.warn("getAllDeniedRequests(): " + e.getLocalizedMessage());
		}

		log.trace("getAllDeniedRequests() -> " + ((allDeniedRequests != null) ? allDeniedRequests.size() : null) + " Request objects");
		return allDeniedRequests;
	}

	public List<Request> getAllResolvedRequests() {
		List<Request> allResolvedRequests = new ArrayList<>();

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT R.REQUESTID, U.USERID, CONCAT(U.FIRSTNAME CONCAT(' ', U.LASTNAME)), R.SUBMITDATE, R.RESOLVERID, "
					   + "       R.RESOLVEDATE, R.STATUS, R.DESCRIPTION, R.RESOLVENOTE, R.AMOUNT FROM REQUESTS R "
					   + "INNER JOIN USERS U ON U.USERID = R.SUBMITTERID "
					   + "WHERE NOT STATUS = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, Status.PENDING);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int reqId = rs.getInt(1);
				int subId = rs.getInt(2);
				String name = rs.getString(3);
				Timestamp subDate = rs.getTimestamp(4);
				int resId = rs.getInt(5);
				Timestamp resDate = rs.getTimestamp(6);
				String status = Status.getName(rs.getInt(7));
				String desc = rs.getString(8);
				String notes = rs.getString(9);
				float amount = rs.getFloat(10);
				
				allResolvedRequests.add(new Request(reqId, subId, name, subDate, resId, resDate, status, desc, notes, amount));
			}

		} catch (SQLException e) {
			log.warn("getResolvedRequests(): " + e.getLocalizedMessage());
		}

		log.trace("getResolvedRequests() -> " + ((allResolvedRequests != null) ? allResolvedRequests.size() : null) + " Request objects");
		return allResolvedRequests;
	}

	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<>();

		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT USERID, EMAIL, PASSWORD, FIRSTNAME, LASTNAME, ISMANAGER FROM USERS";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int userId = rs.getInt(1);
				String email = rs.getString(2);
				String password = rs.getString(3);
				String firstName = rs.getString(4);
				String lastName = rs.getString(5);
				boolean isManager = (rs.getInt(6) == 0) ? false : true;
				
				User user = new User(email, password, firstName, lastName, isManager);
				user.setUserId(userId);
				allUsers.add(user);
			}

		} catch (SQLException e) {
			log.warn("getAllUsers(): " + e.getLocalizedMessage());
		}

		log.trace("getAllUsers() -> " + ((allUsers != null) ? allUsers.size() : null) + " User objects");
		return allUsers;
	}
	
	public void deleteUser(int userId) {
		
		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
			
			
			
		} catch (SQLException e) {
			log.warn("deleteUser(userId="+userId+"): " + e.getLocalizedMessage());
		}
	}
}
