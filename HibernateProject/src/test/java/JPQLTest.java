import com.lti.designpattern.basedao.BaseDAOImpl;
import com.lti.onetomany.Employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
	
}
