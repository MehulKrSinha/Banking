package com.lti.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*
 * EMPNO ENAME JOB  SAL DNO
 * 111   JACK  MGR  555 10
 * 222   JOHN  SALE 666 10
 * 333   JILL  MGR  777 10
 * 444   SMIT  ANA  888 20
 * 555   JANE  ANA  999 20
 * 
 */
@Entity
@Table(name="myemployee")
public class Employee {

	@Id
	@Column(name="empno")
	private int employeeNumber;
	
	private String employeeName;
	private String employeeJob;
	private Double employeeSalary;
	
	@ManyToOne
	@JoinColumn(name="dno")
	Department dept;
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeNumber, String employeeName, String employeeJob, double employeeSalary,
			Department dept) {
		super();
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.employeeJob = employeeJob;
		this.employeeSalary = employeeSalary;
		this.dept = dept;
	}
	
	public Employee(int employeeNumber, String employeeName, String employeeJob, double employeeSalary) {
		super();
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.employeeJob = employeeJob;
		this.employeeSalary = employeeSalary;
	}
	
	public Department getDept() {
		return dept;
	}



	public void setDept(Department dept) {
		this.dept = dept;
	}



	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeJob() {
		return employeeJob;
	}
	public void setEmployeeJob(String employeeJob) {
		this.employeeJob = employeeJob;
	}
	public Double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
	
}
