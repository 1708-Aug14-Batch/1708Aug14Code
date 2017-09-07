package com.reimburse.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;
import com.reimburse.util.ConnectionFactory;

public class ReimburseDAO implements DAO {

	@Override
	public int addUser(User user) {
		// add a new user and return its generated primary key
		int id = -1;

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "insert into users (firstname,lastname,username,email,pwd,isManager) "
					+ "values (?,?,?,?,?,?)";

			//to get back primary key
			String[] key = new String[1];
			key[0] = "userid";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql,key);
			//set values into sql string ?'s
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPwd());
			ps.setByte(6, user.getIsManager());

			//execute and get values
			ps.executeUpdate();

			//results from keys
			ResultSet primaryKeys = ps.getGeneratedKeys();
			while(primaryKeys.next()){
				id = primaryKeys.getInt(1);
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}

	@Override
	public void deleteUser(User user) {
		// TODO put delete call in db
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "{ call deleteUser(?) }";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, user.getUserId());
			//execute
			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<User> getAllEmployees() {
		//get all employees in db (not managers)
		ArrayList<User> users = new ArrayList<User>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from users "
					+ "where isManager = 0 ";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);


			//execute and get values
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				User u = new User(rs.getInt("userid"), rs.getString("firstname"), rs.getString("lastname"), 
						rs.getString("username"), rs.getString("email"), rs.getString("pwd"),
						rs.getByte("isManager"));
				users.add(u);
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;

	}

	@Override
	public User getUser(int id) {
		// get a user from user id

		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from users where"
					+ " USERID = ?";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			//set values into sql string ?'s
			ps.setInt(1, id);


			//execute and get values
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				user = new User(rs.getInt("userid"), rs.getString("firstname"), rs.getString("lastname"), 
						rs.getString("username"), rs.getString("email"), rs.getString("pwd"),
						rs.getByte("isManager"));
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User getUser(String usr, String pwd) {
		// get user based on username and pass
		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from users where"
					+ " username = ? AND pwd = ?";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			//set values into sql string ?'s
			ps.setString(1,usr);
			ps.setString(2, pwd);


			//execute and get values
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				user = new User(rs.getInt("userid"), rs.getString("firstname"), rs.getString("lastname"), 
						rs.getString("username"), rs.getString("email"), rs.getString("pwd"),
						rs.getByte("isManager"));
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User getUserUseEmail(String email, String pwd) {
		// get user based on email and pass
		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from users where"
					+ " email = ? AND pwd = ?";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			//set values into sql string ?'s
			ps.setString(1,email);
			ps.setString(2, pwd);


			//execute and get values
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				user = new User(rs.getInt("userid"), rs.getString("firstname"), rs.getString("lastname"), 
						rs.getString("username"), rs.getString("email"), rs.getString("pwd"),
						rs.getByte("isManager"));
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public boolean existsUsername(String username) {
		// find if there's an existing username in db
		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from users where"
					+ " username = ?";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			//set values into sql string ?'s
			ps.setString(1, username);


			//execute and get values
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				user = new User(rs.getInt("userid"), rs.getString("firstname"), rs.getString("lastname"), 
						rs.getString("username"), rs.getString("email"), rs.getString("pwd"),
						rs.getByte("isManager"));
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(user.getUserId()==0){
			return false;
		}

		return true;
	}

	@Override
	public boolean existsEmail(String email) {
		// see if email exists in db
		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from users where"
					+ " email = ?";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			//set values into sql string ?'s
			ps.setString(1, email);


			//execute and get values
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				user = new User(rs.getInt("userid"), rs.getString("firstname"), rs.getString("lastname"), 
						rs.getString("username"), rs.getString("email"), rs.getString("pwd"),
						rs.getByte("isManager"));
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(user.getUserId()==0){
			return false;
		}

		return true;
	}

	@Override
	public void updateUser(User user) {
		// update user via DB procedure
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "{ call updateUser(?,?,?,?,?) }";


			CallableStatement cs = conn.prepareCall(sql);
			//set second ? to findPerson for variable name
			cs.setString(1, user.getFirstname());
			cs.setString(2, user.getLastname());
			cs.setString(3, user.getEmail());
			cs.setString(4, user.getPwd());
			cs.setInt(5, user.getUserId());
			//execute
			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addReimbursement(Reimbursement r) {
		// add new reimbursement
		int id = -1;

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "insert into reimbursements(submitid,description,amount,submit_date) "
					+"values (?,?,?,systimestamp)";

			//to get back primary key
			String[] key = new String[1];
			key[0] = "reimbursementid";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql,key);
			//set values into sql string ?'s
			ps.setInt(1, r.getSubmitId());
			ps.setString(2, r.getDescription());
			ps.setBigDecimal(3, r.getAmount());

			//execute and get values
			ps.executeUpdate();

			//results from keys
			ResultSet primaryKeys = ps.getGeneratedKeys();
			while(primaryKeys.next()){
				id = primaryKeys.getInt(1);
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}

	@Override
	public Reimbursement getReimbursement(int id) {
		// get a reimbursement from reimbursement id

		Reimbursement r = new Reimbursement();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from reimbursements where"
					+ " reimbursementid = ?";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			//set values into sql string ?'s
			ps.setInt(1, id);


			//execute and get values
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				r = new Reimbursement(rs.getInt("reimbursementid"), rs.getInt("submitid"), rs.getInt("resolveid"),
						rs.getInt("statusid"), rs.getString("description"),
						rs.getString("manager_notes"), rs.getBigDecimal("amount"), 
						rs.getDate("submit_Date"), rs.getDate("resolve_date"));
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;

	}

	@Override
	public ArrayList<Reimbursement> getEmployeeReimbursements(int userID) {

		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from reimbursements "
					+ "where submitid = ? order by submit_date desc";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);

			//execute and get values
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Reimbursement u = new Reimbursement(rs.getInt("reimbursementid"), rs.getInt("submitid"), rs.getInt("resolveid"),
						rs.getInt("statusid"), rs.getString("description"),
						rs.getString("manager_notes"), rs.getBigDecimal("amount"), 
						rs.getDate("submit_date"), rs.getDate("resolve_date"));
				reimbursements.add(u);
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursements;
	}

	@Override
	public ArrayList<Reimbursement> getEmployeePendingReimbursements(int userID) {
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from reimbursements "
					+ "where submitid = ? and statusid = 0";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);

			//execute and get values
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Reimbursement u = new Reimbursement(rs.getInt("reimbursementid"), rs.getInt("submitid"), rs.getInt("resolveid"),
						rs.getInt("statusid"), rs.getString("description"),
						rs.getString("manager_notes"), rs.getBigDecimal("amount"), 
						rs.getDate("submit_date"), rs.getDate("resolve_date"));
				reimbursements.add(u);
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursements;
	}

	@Override
	public ArrayList<Reimbursement> getEmployeeResolvedReimbursements(int userID) {
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from reimbursements "
					+ "where submitid = ? and statusid != 0";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);

			//execute and get values
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Reimbursement u = new Reimbursement(rs.getInt("reimbursementid"), rs.getInt("submitid"), rs.getInt("resolveid"),
						rs.getInt("statusid"), rs.getString("description"),
						rs.getString("manager_notes"), rs.getBigDecimal("amount"), 
						rs.getDate("submit_date"), rs.getDate("resolve_date"));
				reimbursements.add(u);
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursements;
	}

	@Override
	public ArrayList<Reimbursement> getAllPending() {
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from reimbursements "
					+ "where statusid = 0";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);

			//execute and get values
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Reimbursement u = new Reimbursement(rs.getInt("reimbursementid"), rs.getInt("submitid"), rs.getInt("resolveid"),
						rs.getInt("statusid"), rs.getString("description"),
						rs.getString("manager_notes"), rs.getBigDecimal("amount"), 
						rs.getDate("submit_date"), rs.getDate("resolve_date"));
				reimbursements.add(u);
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursements;
	}

	@Override
	public ArrayList<Reimbursement> getAllResolved() {
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from reimbursements "
					+ "where statusid != 0";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);

			//execute and get values
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Reimbursement u = new Reimbursement(rs.getInt("reimbursementid"), rs.getInt("submitid"), rs.getInt("resolveid"),
						rs.getInt("statusid"), rs.getString("description"),
						rs.getString("manager_notes"), rs.getBigDecimal("amount"), 
						rs.getDate("submit_date"), rs.getDate("resolve_date"));
				reimbursements.add(u);
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursements;
	}

	@Override
	public void resolveReimbursement(Reimbursement r) {
		// update user via DB procedure
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "{ call resolveReimbursement(?,?,?,?) }";


			CallableStatement cs = conn.prepareCall(sql);
			//set second ? to findPerson for variable name
			cs.setInt(1, r.getReimbursementId());
			cs.setInt(2, r.getResolveId());
			cs.setString(3, r.getManagerNotes());
			cs.setInt(4, r.getStatusId());
			//execute
			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteReimbursement(Reimbursement r) {
		// TODO put delete call in db
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "{ call deleteReimbursement(?) }";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, r.getReimbursementId());
			//execute
			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
