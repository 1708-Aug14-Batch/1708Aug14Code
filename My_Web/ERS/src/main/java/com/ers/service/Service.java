package com.ers.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ers.dao.DatabaseDao;
import com.ers.pojos.Request;
import com.ers.pojos.Status;
import com.ers.pojos.User;

public class Service {
	private static final Logger log = Logger.getLogger(Service.class);

	public static final int MAX_SESSION_INACTIVE_INTERVAL = 60 * 10;
	public static final String USER_ATTR = "user";

	public static User getCurrentUser() {
		return currentUser;
	}

	public static String addUser(User user) {
		if (hasUser(user.getEmail()))
			return "User already associated with that email";

		int userId = dao.addUser(user);

		if (userId == -1) {
			return "An unknown error occurred creating user";
		}

		user.setUserId(userId);

		return null;
	}
	
	public static boolean submitRequest(User user, float amount, String description) {
		
		log.trace("user= "+user+", amount= "+amount+", description= "+description);
		if (user == null) return false;
		return dao.submitRequest(user.getUserId(), amount, description);
	}
	
	public static boolean withdrawRequest(int requestId) {
		
		return dao.withdrawRequest(requestId);
	}
	
	public static boolean approveRequest(int requestId, int managerId, String reason) {
		
		return dao.resolveRequest(requestId, managerId, reason, Status.APPROVED);
	}
	
	public static boolean denyRequest(int requestId, int managerId, String reason) {
		
		return dao.resolveRequest(requestId, managerId, reason, Status.DENIED);
	}

	public static boolean updateEmail(User user, String email) {

		if (dao.setEmail(user.getUserId(), email)) {
			user.setEmail(email);
			return true;
		}
		return false;
	}

	public static boolean updatePassword(User user, String password) {

		if (dao.setPassword(user.getUserId(), password)) {
			user.setPassword(password);
			return true;
		}
		return false;
	}

	public static boolean updateFirstName(User user, String firstName) {

		if (dao.setFirstName(user.getUserId(), firstName)) {
			user.setFirstName(firstName);
			return true;
		}
		return false;
	}

	public static boolean updateLastName(User user, String lastName) {

		if (dao.setLastName(user.getUserId(), lastName)) {
			user.setLastName(lastName);
			return true;
		}
		return false;
	}

	public static String loginUser(String email, String password) {
		if ("".equals(email) || "".equals(password) || email == null || password == null)
			return "You must enter an email and password";

		if (!hasUser(email))
			return "There is no user associated with that email";

		User user = dao.getUser(email, password);

		if (user != null) {
			currentUser = user;
			return null;
		} else {
			return "Incorrect email or password";
		}
	}
	
	public static List<User> getAllEmployees() {
		return dao.getAllUsers();
	}

	public static List<Request> getRequests(User user, boolean getPending, boolean getApproved, boolean getDenied) {

		return user.isManager() ? doGetManagerRequests(getPending, getApproved, getDenied)
				: doGetEmployeeRequests(user, getPending, getApproved, getDenied);
	}

	private static List<Request> doGetEmployeeRequests(User user, boolean getPending, boolean getApproved,
			boolean getDenied) {
		List<Request> requests = new ArrayList<>();
		if (getPending)
			requests.addAll(getPendingRequests(user));
		if (getApproved)
			requests.addAll(getApprovedRequests(user));
		if (getDenied)
			requests.addAll(getDeniedRequests(user));
		return requests;
	}

	private static List<Request> doGetManagerRequests(boolean getPending, boolean getApproved, boolean getDenied) {
		List<Request> requests = new ArrayList<>();
		if (getPending)
			requests.addAll(getAllPendingRequests());
		if (getApproved)
			requests.addAll(getAllApprovedRequests());
		if (getDenied)
			requests.addAll(getAllDeniedRequests());
		return requests;
	}

	private static List<Request> getUserRequests(User user) {

		return dao.getUserRequests(user.getUserId());
	}

	private static List<Request> getPendingRequests(User user) {

		return dao.getPendingRequests(user.getUserId());
	}

	private static List<Request> getApprovedRequests(User user) {

		return dao.getApprovedRequests(user.getUserId());
	}

	private static List<Request> getDeniedRequests(User user) {

		return dao.getDeniedRequests(user.getUserId());
	}

	private static List<Request> getResolvedRequests(User user) {

		return dao.getResolvedRequests(user.getUserId());
	}

	private static List<Request> getAllUserRequests() {

		return dao.getAllUserRequests();
	}

	private static List<Request> getAllPendingRequests() {

		return dao.getAllPendingRequests();
	}

	private static List<Request> getAllApprovedRequests() {

		return dao.getAllApprovedRequests();
	}

	private static List<Request> getAllDeniedRequests() {

		return dao.getAllDeniedRequests();
	}

	private static List<Request> getAllResolvedRequests() {

		return dao.getAllResolvedRequests();
	}

	private static boolean hasUser(String email) {
		if (email == null)
			return false;
		return dao.hasUser(email);
	}

	private static User currentUser = null;
	private static DatabaseDao dao = new DatabaseDao();
}
