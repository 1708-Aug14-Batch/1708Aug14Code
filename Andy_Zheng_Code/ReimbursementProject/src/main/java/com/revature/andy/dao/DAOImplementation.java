package com.revature.andy.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import com.revature.andy.pojos.Reimbursement;
import com.revature.andy.pojos.ReimStatus;
import com.revature.andy.pojos.User;
import com.revature.andy.util.ConnectionFactory;

public class DAOImplementation implements DAOInterface {

	public int selectALL() {
		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			con.setAutoCommit(false);
			String sql = "SELECT * FROM USERS";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println(rs.getInt(1));
			}
			con.commit();
			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	// prepared statement

	// Insert User
	// Insert User by Pass strings
	public int addUser(String fn, String ln, String email, String pwd, int isManager) {

		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			con.setAutoCommit(false);
			String sql = "INSERT INTO USERS(FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ISMANAGER) VALUES(?,?,?,?,?)";
			String[] key = new String[1];
			key[0] = "USERID";
			PreparedStatement ps = con.prepareStatement(sql, key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, email);
			ps.setString(4, pwd);
			ps.setInt(5, isManager);

			ps.executeUpdate();

			int id = 0;

			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()) {
				id = rs.getInt(1);
			}
			con.commit();
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	// Insert User by Pass object
	public int addUser(User u) {

		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			con.setAutoCommit(false);
			String sql = "INSERT INTO USERS(FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ISMANAGER) VALUES(?,?,?,?,?)";
			String[] key = new String[1];
			key[0] = "USERID";
			PreparedStatement ps = con.prepareStatement(sql, key);
			ps.setString(1, u.getFName());
			ps.setString(2, u.getLName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getIsManager());

			ps.executeUpdate();
			
			int id = 0;

			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()) {
				id = rs.getInt(1);
			}
			con.commit();
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

	}

	// Update User by pass object
	public int updateUser(User u) {
		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			con.setAutoCommit(false);
			String sql = "UPDATE USERS SET FIRSTNAME = ?, LASTNAME = ?, "
					+ "EMAIL = ?, PASSWORD = ?, ISMANAGER = ? WHERE USERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, u.getFName());
			ps.setString(2, u.getLName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getIsManager());
			ps.setInt(6, u.getUserID());

			ps.executeUpdate();

			con.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// Insert Reimbursement
	public int addReimbursement(User u, String description, double amount) {

		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			con.setAutoCommit(false);

			String sql = "INSERT INTO REIMBURSEMENTS(SUBMITTERID, DESCRIPTION, AMOUNT) VALUES(?,?,?)";

			String[] key = new String[1];
			key[0] = "REIMID";
			PreparedStatement ps = con.prepareStatement(sql, key);
			ps.setInt(1, u.getUserID());
			ps.setString(2, description);
			ps.setDouble(3, amount);

			ps.executeUpdate();

			int id = 0;
			ResultSet rs = ps.getGeneratedKeys();

			while (rs.next()) {
				id = rs.getInt(1);
			}

			con.commit();
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

	}

	// Update Reimbursement
	public int updateReimbursement(int reimID, User user, ReimStatus rs, String notes) {
		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			con.setAutoCommit(false);
			String sql = "UPDATE REIMBURSEMENTS SET RESOLVERID = ?, RESOLVEDATE = CURRENT_TIMESTAMP, "
					+ "STATUSID = ?, NOTES = ? WHERE REIMID = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, user.getUserID());
			ps.setInt(2, rs.getStatusID());
			ps.setString(3, notes);
			ps.setInt(4, reimID);

			ps.executeQuery();
			con.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	};

	// Procedure, select user info by id
	public User getUser(int userID) {

		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			String sql = "{call getUserInfo(?,?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);

			cs.setInt(1, userID);
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.registerOutParameter(4, java.sql.Types.VARCHAR);
			cs.registerOutParameter(5, java.sql.Types.VARCHAR);
			cs.registerOutParameter(6, java.sql.Types.NUMERIC);

			cs.executeQuery();

			User temp = new User();
			temp.setUserID(userID);
			temp.setFName(cs.getString(2));
			temp.setLName(cs.getString(3));
			temp.setEmail(cs.getString(4));
			temp.setPassword(cs.getString(5));
			temp.setIsManager(cs.getInt(6));

			return temp;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Select user email/pwd
	public User getUser(String email, String pwd) {

		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pwd);

			ResultSet rs = ps.executeQuery();
			
			User temp = null;

			while (rs.next()) {
				temp = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
			}
			return temp;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// select all users
	public HashSet<User> getUsers() {
		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM USERS";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			HashSet<User> userList = new HashSet<>();

			while (rs.next()) {
				User temp = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
				userList.add(temp);
			}

			return userList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// get all employees
	public HashSet<User> getEmployees(){
		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM USERS WHERE ISMANAGER = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 0);
			
			ResultSet rs = ps.executeQuery();

			HashSet<User> userList = new HashSet<>();

			while (rs.next()) {
				User temp = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
				userList.add(temp);
			}

			return userList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	// select all reimbursements
	public HashSet<Reimbursement> getReims(){
		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM REIMBURSEMENTS";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			HashSet<Reimbursement> reimList = new HashSet<>();

			while (rs.next()) {

				ReimStatus tempType = getReimStatusFromID(rs.getInt(6));
				User tempSub = getUser(rs.getInt(2));
				User tempRes = null;
				if(rs.getInt(3) > 0) {
					tempRes = getUser(rs.getInt(3));
				}

				Reimbursement tempReim = new Reimbursement(rs.getInt(1), tempSub, tempRes, rs.getDate(4), rs.getDate(5),
						tempType, rs.getString(7), rs.getString(8), rs.getDouble(9));

				reimList.add(tempReim);
			}

			return reimList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	// select all reimbursements based of a user
	public HashSet<Reimbursement> getUserReim(int userID) {

		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE SUBMITTERID = (?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userID);

			ResultSet rs = ps.executeQuery();

			HashSet<Reimbursement> reimList = new HashSet<>();

			while (rs.next()) {

				ReimStatus tempType = getReimStatusFromID(rs.getInt(6));
				User tempSub = getUser(rs.getInt(2));
				User tempRes = null;
				if(rs.getInt(3) > 0) {
					tempRes = getUser(rs.getInt(3));
				}

				Reimbursement tempReim = new Reimbursement(rs.getInt(1), tempSub, tempRes, rs.getDate(4), rs.getDate(5),
						tempType, rs.getString(7), rs.getString(8), rs.getDouble(9));

				reimList.add(tempReim);
			}

			return reimList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// selects all reimbursements based on status
	public HashSet<Reimbursement> getStatusReim(int statusID) {

		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE STATUSID = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, statusID);

			ResultSet rs = ps.executeQuery();

			HashSet<Reimbursement> reimList = new HashSet<>();

			while (rs.next()) {

				ReimStatus tempType = getReimStatusFromID(rs.getInt(6));
				User tempSub = getUser(rs.getInt(2));
				User tempRes = getUser(rs.getInt(3));

				Reimbursement tempReim = new Reimbursement(rs.getInt(1), tempSub, tempRes, rs.getDate(4), rs.getDate(5),
						tempType, rs.getString(7), rs.getString(8), rs.getDouble(9));

				reimList.add(tempReim);
			}

			return reimList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// selects all reimbursements based on user and status
	public HashSet<Reimbursement> getUserStatusReim(int userID, int statusID) {

		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE USERID = ? AND STATUSID = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userID);
			ps.setInt(2, statusID);

			ResultSet rs = ps.executeQuery();

			HashSet<Reimbursement> reimList = new HashSet<>();

			while (rs.next()) {

				ReimStatus tempType = getReimStatusFromID(rs.getInt(6));
				User tempSub = getUser(rs.getInt(2));
				User tempRes = getUser(rs.getInt(3));

				Reimbursement tempReim = new Reimbursement(rs.getInt(1), tempSub, tempRes, rs.getDate(4), rs.getDate(5),
						tempType, rs.getString(7), rs.getString(8), rs.getDouble(9));

				reimList.add(tempReim);
			}

			return reimList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Return a ReimStatus Object From Look Up Table
	public ReimStatus getReimStatusFromID(int statusID) {

		try (Connection con = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM REIMSTATUS WHERE STATUSID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, statusID);

			ResultSet rs = ps.executeQuery();

			ReimStatus temp = null;

			while (rs.next()) {
				temp = new ReimStatus(rs.getInt(1), rs.getString(2));
			}

			return temp;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}