package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="employee_id")
	@SequenceGenerator(name="employee_id_seq", sequenceName="employee_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_id_seq")
	private int employeeID;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="department_id")
	private Department department;

}
