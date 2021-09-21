package com.lti.onetomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/*
 * 
 * DEPT
 * DEPTNO  DNAME   LOC  
 * 10	   ACC		NY  
 * 20      IT       ND
 * 
 * select * from dept where deptno=10
 * select * from emp where dno=10;
 * 
 * select department0_.deptno as deptno1_0_0_, 
 * department0_.loc as loc2_0_0_, 
 * department0_.dname as dname3_0_0_ from 
 * mydepartment department0_ where department0_.deptno=?


select 

department0_.deptno as deptno1_0_0_, 
department0_.loc as loc2_0_0_, 
department0_.dname as dname3_0_0_, 

employees1_.dno as dno5_1_1_, 
employees1_.empno as empno1_1_1_,
employees1_.empno as empno1_1_2_,
employees1_.dno as dno5_1_2_, 
employees1_.employeeJob as employee2_1_2_, 
employees1_.employeeName as employee3_1_2_,
employees1_.employeeSalary as employee4_1_2_ 

   from mydepartment department0_ 
   left outer join myemployee employees1_ 
   on department0_.deptno=employees1_.dno
    
    where department0_.deptno=?

Dept Number
 */
@Entity
@Table(name="mydepartment")
public class Department {

	@Id
	@Column(name="deptno")
	private int departmentNumber;
	
	@Column(name="dname")
	private String departmentName;

	@Column(name="loc")
	private String departmentLocation;
	
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<Employee> employees;

	
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int departmentNumber, String departmentName, String departmentLocation) {
		super();
		this.departmentNumber = departmentNumber;
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
	}

	public Department(int departmentNumber, String departmentName, String departmentLocation, Set<Employee> employees) {
		super();
		this.departmentNumber = departmentNumber;
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
		this.employees = employees;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public int getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	
	
	
}
