package com.reimburse.dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashMap;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;
import com.reimburse.util.ConnectionFactory;
import com.reimburse.util.ConnectionUtil;

public class SystemDAOImpl implements SystemDAO{
	
	public int userLogin(String username, String password, String isManager) throws ClassNotFoundException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try(Connection conn = ConnectionUtil.getConnection();) {
			String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASS = ?" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			rs.next();
			if(rs == null){
				System.out.println(rs.getString("USERNAME"));
            	return 0;
            }
			System.out.println(rs.getString("USERNAME"));
			return (rs.getInt("userid"));
		} catch(SQLException e) {
			e.printStackTrace();	
		} 
//		finally { 
//			if (pstmt != null) {
//				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
//				}
//			if (rs != null) {
//        			try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
//        		}
//		 }     
		return 0;
	}
	@Override
	public boolean register(String username, String password, String email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try(Connection conn = ConnectionUtil.getConnection();) {
			String sql;
			sql = "SELECT * FROM USERS WHERE USERNAME = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
//			int id = 0;
//			ResultSet pk = pstmt.getGeneratedKeys();
			if(rs.next()) {
				return false;
			}
			sql = "insert into USERS (username, pass, email)"
					+ " values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.executeQuery();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
			if (rs != null) {
        			try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
        		}
		 }
	}

	@Override
	public boolean submitRequest(Reimbursement reimbursement) {
		PreparedStatement pstmt = null;
		try(Connection conn =  ConnectionUtil.getConnection();) {
			String sql = "INSERT INTO REIMBURSEMENTS VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reimbursement.getReimbursementID());
			pstmt.setDouble(2, reimbursement.getAmount());
			pstmt.setString(3, reimbursement.getDescription());
			pstmt.setTimestamp(4, reimbursement.getDateSubmitted());
			pstmt.setInt(5, reimbursement.getAuthorID());
			pstmt.setInt(6, reimbursement.getTypeID());
			pstmt.setInt(7, reimbursement.getStatusID());
			
			if(pstmt.executeUpdate() == 1) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
		}
	return false;
	}

	@Override
	public Reimbursement[] viewReimbursement(User user, int reimbursementType) {
		List<Reimbursement> reimbursement = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE AUTHORID = ? AND STATUSid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUser_id());
			pstmt.setInt(2, reimbursementType);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				reimbursement.add(returnReimbursement(rs));
			}
			return reimbursement.toArray(new Reimbursement[reimbursement.size()]);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
			if (rs != null) {
        			try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
        		}
		 }     
		return reimbursement.toArray(new Reimbursement[reimbursement.size()]);
	}
	
	public User returnUser(ResultSet rs) throws SQLException {
		return new User( rs.getInt("userID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), 
				         rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getInt("role_id"));
	}

	public Reimbursement returnReimbursement(ResultSet rs) throws SQLException {
		return new Reimbursement( rs.getInt("ReimburseID"), rs.getDouble("AMOUNT"), rs.getString("DESCRIPTION"),
				                  null, rs.getTimestamp("date_SUBMITTED"), rs.getTimestamp("date_RESOLVED"), 
				                  rs.getInt("AUTHORid"), rs.getInt("RESOLVERid"), rs.getInt("RT_STATUS"), 0);
	}

	@Override
	public boolean updateInfo(User user) {
		PreparedStatement pstmt = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "UPDATE USERS SET USERNAME = ?, PASS = ?, FIRSTNAME = ?, LASTNAME = ?, EMAIL = ? WHERE userID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setString(5, user.getEmail());
			pstmt.setInt(6, user.getUser_id());
			
			if(pstmt.executeUpdate() == 1) {
				return true;
			}	
		} catch(SQLException e) {
			e.printStackTrace();
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
		 }   
		return false;
	}

	@Override
	public List<User> viewAllEmployees() {
		List<User> allEmployees = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM USERS";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				allEmployees.add(returnUser(rs));
			}
			return allEmployees;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
			if (rs != null) {
        			try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
        		}
		}
		return allEmployees;
	}

	@Override
	public Reimbursement[] viewAllReimbursements(int reimbursementType) {
		List<Reimbursement> allReimbursements = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE STATUSid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reimbursementType);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				allReimbursements.add(returnReimbursement(rs));
			}
			return allReimbursements.toArray(new Reimbursement[allReimbursements.size()]);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
			if (rs != null) {
        			try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
        		} 
		}
		return allReimbursements.toArray(new Reimbursement[allReimbursements.size()]);
	}

	@Override
	public boolean handleReimbursementRequests(Reimbursement reimbursement) {
		PreparedStatement pstmt = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "UPDATE REIMBURSEMENTS SET STATUSid = ?, RESOLVERid = ?,  date_RESOLVED = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reimbursement.getStatusID());
			pstmt.setInt(2, reimbursement.getResolverID());
			pstmt.setTimestamp(3, reimbursement.getDateResolved());
			if(pstmt.executeUpdate() == 1) {
				return true;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
		}
		return false;
	}

	@Override
	public User viewSingleEmployee(int user_ID) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM USERS WHERE userID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_ID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = returnUser(rs);
				return user;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
			if (rs != null) {
        			try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
        		} 
		}
		return null;
	}
	@Override
	public String returnUserAsSession(String username, String password) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String returnSession;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASS = ?" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String u_username = rs.getString("USERNAME");
				String u_firstname = rs.getString("FIRSTNAME");
				String u_lastname = rs.getString("LASTNAME");
				String u_password = rs.getString("PASS");
				String u_email = rs.getString("EMAIL");
				int u_id = rs.getInt("UserID");
				returnSession = "sessionStorage.user = \'"+u_username+"\'; sessionStorage.pass = \'"+u_password
						+"\'; sessionStorage.email = \'"+u_email+"\'; sessionStorage.id = \'"+u_id+"\'; sessionStorage.fname = \'" 
						+ u_firstname + "\'; sessionStorage.lname = \'" + u_lastname + "\';";
				return returnSession;	
				} 
			}catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
			if (rs != null) {
        			try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
        		} 
		}
		return null;
	}
	@Override
	public List<String> returnRList(int userID, boolean isManager) {
		System.out.println("REQUEST FROM ID: " + userID + " FOR REIMBURSEMENTS.");
		List<String> reimbursement = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM REIMBURSEMENT";
			if(!isManager) {
				sql=sql+" WHERE AUTHORid = ? ORDER BY reimburseID";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, userID);
			} else {
				sql = sql + " ORDER BY R_ID";
				pstmt = conn.prepareStatement(sql);
			}
			rs = pstmt.executeQuery();
			String result;
			if(isManager == true) {
				while(rs.next()) {
					int r_id = rs.getInt("reimburseID");
					int status = rs.getInt("STATUSid");
					Date submitted = rs.getTimestamp("date_SUBMITTED");
					Date resolved = rs.getTimestamp("date_RESOLVED");
					BigDecimal amount = rs.getBigDecimal("AMOUNT");
					String status2 = "";
					switch(status) {
					case(1): status2 = "Pending..."; break;
					case(2): status2 = "Approved"; break;
					case(3): status2 = "Denied."; break;
					}
					result = "<tr>"+
						 "<th>"+r_id+"</th>"+ 
						 "<td>"+status2+"</th>"+
						 "<td>"+submitted+"</td>"+
						 "<td>"+resolved+"</td>"+
						 "<td>"+amount.toString()+"</td>"+
						 "<td><a href=# onclick='approval("+r_id+", true)'>Approve</a> or <a href=# onclick='approval("+r_id+", false)'>Deny</a></td>"+
						 "</tr>";
					reimbursement.add(result);
					}
				return reimbursement;
			}
			if(isManager == false) {
				while(rs.next()) {
					System.out.println("got this far....");
					int r_id = rs.getInt("reimburseID");
					int status = rs.getInt("STATUSid");
					String status2 = "";
					switch(status) {
					case(1): status2 = "Pending..."; break;
					case(2): status2 = "Approved"; break;
					case(3): status2 = "Denied."; break;
					}
					Date submitted = rs.getTimestamp("date_SUBMITTED");
					Date resolved = rs.getTimestamp("date_RESOLVED");
					BigDecimal amount = rs.getBigDecimal("R_AMOUNT");
					System.out.println(amount.toString());
					result = "<tr>"+
						 "<th>"+r_id+"</th>"+ 
						 "<td>"+status2+"</th>"+
						 "<td>"+submitted+"</td>"+
						 "<td>"+resolved+"</td>"+
						 "<td>"+amount.toString()+"</td>"+
						 "</tr>";
					reimbursement.add(result);
				}
				return reimbursement;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
			if (rs != null) {
        			try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
        		}
		 }     
		return null;
	}
	public boolean submitFields(int userID, double amount, String desc) {
		PreparedStatement pstmt = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql;
			sql = "insert into reimbursement (amount, description, userId)"+" values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, amount);
			pstmt.setString(2, desc);
			pstmt.setInt(3, userID);
			pstmt.executeQuery();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
		 }
	}
	public boolean approveall() {
		PreparedStatement pstmt = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql;
			sql = "BEGIN BETA_APPROVE_ALL; END;";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
		 }
	}
	public boolean denyall() {
		PreparedStatement pstmt = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql;
			sql = "BEGIN BETA_DENY_ALL; END;";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
		 }
	}
	public boolean statuschange(String RID, String UID, int status) {
		PreparedStatement pstmt = null;
		try(Connection conn = ConnectionUtil.getConnection();) {
			String sql;
			sql = "BEGIN PR_APPROVE_REIMB(?,?,?); END;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(RID));
			pstmt.setInt(2, Integer.parseInt(UID));
			pstmt.setInt(3, status);
			pstmt.executeQuery();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
		 }
	}
	public void addname( String username, String password, String fname, String lname) {
		PreparedStatement pstmt = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql;
			sql = "insert into USERS FIRSTNAME = ?, LASTNAME = ? WHERE USERNAME = ? AND PASS = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, fname);
			pstmt.setString(4, lname);
			pstmt.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally { 
			if (pstmt != null) {
				try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); } 
				}
		 }
	}

}