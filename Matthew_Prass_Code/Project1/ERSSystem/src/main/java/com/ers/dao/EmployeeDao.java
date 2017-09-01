package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojos.Employee;

public interface EmployeeDao 
{
	public int addEmployee(String fn, String ln, String email, String pass, String usrnm, int manage);
	public ArrayList<Employee> getAllEmployees();
	public Employee getEmployee(int id);
	public void updateEmployeeInfo(Employee e);
}
