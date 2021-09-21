import com.lti.designpattern.basedao.BaseDAOImpl;
import com.lti.onetomany.Department;
import com.lti.onetomany.Employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JPQLTest {
	
	BaseDAOImpl baseDAO = new BaseDAOImpl();
	
	@Test
	void maxSaltest() {
		EntityManager entityManager = baseDAO.getEntityManager();
		Query query1 = entityManager.createQuery("Select MAX(e.employeeSalary) from Employee e");
		Double result = (Double)query1.getSingleResult();
		System.out.println("max emp salary: "+result);
		
	}
	
	@Test
	void salaryRangeTest() {
		EntityManager entityManager = baseDAO.getEntityManager();
		Query query = entityManager.createQuery("Select e from Employee e where e.employeeSalary between 1000 and 6000" );
		List<Employee> results = query.getResultList();
		for(Employee theEmp: results) {
			System.out.println("Emp Number : "+theEmp.getEmployeeNumber());
			System.out.println("Emp Name   : "+theEmp.getEmployeeName());
			System.out.println("Emp Job    : "+theEmp.getEmployeeJob());
			System.out.println("Emp SAlary : "+theEmp.getEmployeeSalary());
			System.out.println("=================");
		}
		
	}
	
	@Test
	void employeeNameStarting() {
		EntityManager entityManager = baseDAO.getEntityManager();
		Query query = entityManager.createQuery("Select e from Employee e where e.employeeName like 'm%'");
		List<Employee> results = query.getResultList();
		for(Employee theEmp: results) {
			System.out.println("Emp Number : "+theEmp.getEmployeeNumber());
			System.out.println("Emp Name   : "+theEmp.getEmployeeName());
			System.out.println("Emp Job    : "+theEmp.getEmployeeJob());
			System.out.println("Emp SAlary : "+theEmp.getEmployeeSalary());
			System.out.println("=================");
		}
	}
	
	@Test
	void sortedEmployeeByEnameTest() {
		EntityManager entityManager = baseDAO.getEntityManager();
		Query query = entityManager.createQuery("Select e from Employee e order by e.employeeName ASC");
		List<Employee> results = query.getResultList();
		for(Employee theEmp: results) {
			System.out.println("Emp Number : "+theEmp.getEmployeeNumber());
			System.out.println("Emp Name   : "+theEmp.getEmployeeName());
			System.out.println("Emp Job    : "+theEmp.getEmployeeJob());
			System.out.println("Emp SAlary : "+theEmp.getEmployeeSalary());
			System.out.println("=================");
		}
	}
	
	@Test
	public void deptJoinEmp() {
		EntityManager entityManager = baseDAO.getEntityManager();
		Query query = entityManager.createQuery("SELECT d FROM Department d JOIN FETCH d.employees e WHERE d.departmentNumber = :x");
		query.setParameter("x", 10); //       <--Employee   e-->
		Department dept = (Department) query.getSingleResult();
		Assertions.assertNotNull(dept); 
	
		System.out.println("Dept Number : "+dept.getDepartmentNumber());
		System.out.println("Dept Name   : "+dept.getDepartmentName());
		System.out.println("Dept Loc    : "+dept.getDepartmentLocation());
		System.out.println("=================");
	}
	
	@Test
	public void deptLeftJoinEmp() {
		EntityManager entityManager = baseDAO.getEntityManager();
		TypedQuery<Department> query = entityManager.createQuery("SELECT d FROM Department d LEFT JOIN FETCH d.employees", Department.class);		 
		List<Department> resultList = query.getResultList();
	
		for(Department dept : resultList) {
			System.out.println("Dept Number : "+dept.getDepartmentNumber());
			System.out.println("Dept Name   : "+dept.getDepartmentName());
			System.out.println("Dept Loc    : "+dept.getDepartmentLocation());
			System.out.println("=================");
		}

	} //10-0, 20 -3, 30-0,  50-6  40 - 4

	 

	@Test

	public void deptRightJoinEmp() {
		EntityManager entityManager = baseDAO.getEntityManager();
		TypedQuery<Department> query = entityManager.createQuery("SELECT d FROM Department d RIGHT JOIN FETCH d.employees", Department.class);
		List<Department> resultList = query.getResultList();
	
		for(Department dept : resultList) {
			System.out.println("Dept Number : "+dept.getDepartmentNumber());
			System.out.println("Dept Name   : "+dept.getDepartmentName());
			System.out.println("Dept Loc    : "+dept.getDepartmentLocation());
			System.out.println("=================");
		}

	}
	
	@Test
	public void deptListTest() {
		EntityManager entityManager = baseDAO.getEntityManager();
		TypedQuery<Department> query = entityManager.createQuery("SELECT d FROM Department d", Department.class);
		List<Department> deptList = query.getResultList();
	
		for(Department dept : deptList) {
			System.out.println("Dept Number : "+dept.getDepartmentNumber());
			System.out.println("Dept Name   : "+dept.getDepartmentName());		
			System.out.println("Dept Loc    : "+dept.getDepartmentLocation());		
			System.out.println("=================");
		
		}

	}
	
	@Test
	public void deptNamedQueryListTest() {
		EntityManager entityManager = baseDAO.getEntityManager();
		TypedQuery<Department> query = entityManager.createNamedQuery("Department.findAll", Department.class);
		List<Department> deptList = query.getResultList();
	
		for(Department dept : deptList) {	
			System.out.println("Dept Number : "+dept.getDepartmentNumber());
			System.out.println("Dept Name   : "+dept.getDepartmentName());
			System.out.println("Dept Loc    : "+dept.getDepartmentLocation());		
			System.out.println("=================");
	
		}

	}
	
	@Test
	public void allEmployeesViaNamedQueryTest() {
		EntityManager entityManager = baseDAO.getEntityManager();
		TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findAll",Employee.class);
		List<Employee> employees =  query.getResultList();
	
		for (Employee theEmp : employees) {
			System.out.println("Emp Number : "+theEmp.getEmployeeNumber());
			System.out.println("Emp Name   : "+theEmp.getEmployeeName());
			System.out.println("Emp Job    : "+theEmp.getEmployeeJob());
			System.out.println("Emp SAlary : "+theEmp.getEmployeeSalary());
			System.out.println("=================");
	
		}

	}

	@Test
	public void allEmployeesByNameViaNamedQueryTest() {
		EntityManager entityManager = baseDAO.getEntityManager();
		TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findByName",Employee.class);
		query.setParameter("xyz", "Heena");
		List<Employee> employees =  query.getResultList();
	
		for (Employee theEmp : employees) {
			System.out.println("Emp Number : "+theEmp.getEmployeeNumber());
			System.out.println("Emp Name   : "+theEmp.getEmployeeName());
			System.out.println("Emp Job    : "+theEmp.getEmployeeJob());
			System.out.println("Emp SAlary : "+theEmp.getEmployeeSalary());
			System.out.println("=================");
		}
	}
	
	
}
