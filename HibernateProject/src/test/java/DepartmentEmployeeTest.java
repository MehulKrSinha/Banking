import com.lti.designpattern.basedao.BaseDAOImpl;
import com.lti.onetomany.Department;
import com.lti.onetomany.Employee;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DepartmentEmployeeTest {
	BaseDAOImpl baseDAO = new BaseDAOImpl(); 

	@Test
	void addDepartment() {//1
		
		Department dept = new Department(10,"Accounts","new York");
		baseDAO.merge(dept);
	}
	

	@Test
	void addEmployees() {//2
		
		Employee emp1 = new Employee(107,"Rita","Clerk",5000);
		Employee emp2 = new Employee(108,"Sita","Manager",6000);
		Employee emp3 = new Employee(109,"Gita","Salesman",7000);
		
		//Set<Employee> staff  = new HashSet<Employee>();	
		
		
		baseDAO.merge(emp1);
		baseDAO.merge(emp2);
		baseDAO.merge(emp3);
		
	}
	
	@Test
	void assignExistingDepartmentToExistingEmployees()
	{
		
		Department foundDept = baseDAO.find(Department.class, 10);
		
		Employee e1 = baseDAO.find(Employee.class, 107);
		e1.setDept(foundDept); //on calling setter method it will trigger update query
		
		Employee e2 = baseDAO.find(Employee.class, 108);
		e2.setDept(foundDept); //on calling setter method it will trigger update query
		
		Employee e3 = baseDAO.find(Employee.class, 109);
		e3.setDept(foundDept); //on calling setter method it will trigger update query
		
		baseDAO.merge(e1);
		baseDAO.merge(e2);
		baseDAO.merge(e3);
				
	}
	
	@Test
	void showEmployeesOfExistingDepartment() {
		Department foundDept = baseDAO.find(Department.class, 10);
		System.out.println("Dept Number   : "+foundDept.getDepartmentNumber());
		System.out.println("Dept Name     : "+foundDept.getDepartmentName());
		System.out.println("Dept Location : "+foundDept.getDepartmentLocation());
		System.out.println("---------------- ");
		
		//assertion to check the null ness of found dept
		
		Set<Employee> staff = foundDept.getEmployees();
		
		//assertionof staff to check length !=0 
		
		for(Employee theEmp: staff) {
			System.out.println("Emp Number : "+theEmp.getEmployeeNumber());
			System.out.println("Emp Name   : "+theEmp.getEmployeeName());
			System.out.println("Emp Job    : "+theEmp.getEmployeeJob());
			System.out.println("Emp SAlary : "+theEmp.getEmployeeSalary());
			System.out.println("=================ß");
		}
	}

	@Test
	void addNewEmployeesToExistingDepartment() {
		Department foundDept = baseDAO.find(Department.class, 10);
		System.out.println("Dept Number   : "+foundDept.getDepartmentNumber());
		System.out.println("Dept Name     : "+foundDept.getDepartmentName());
		System.out.println("Dept Location : "+foundDept.getDepartmentLocation());
		System.out.println("---------------- ");
		
		//assertion to check the null ness of found dept
		
		Set<Employee> newStaff = new HashSet<Employee>();
		
		newStaff.add(new Employee(110,"peter","clerk",1100,foundDept));
		Employee emp2 = new Employee(111,"meter","clerk",1110, foundDept);
		Employee emp3 = new Employee(112,"heater","clerk",1120, foundDept);
		newStaff.add(emp2); //insert query is fired, else not 
		newStaff.add(emp3);
		
		foundDept.setEmployees(newStaff);
		baseDAO.merge(foundDept);
	}

	
	
	@Test
	void addNewDepartmentWithNewEmployees() {
		
		Department dept = new Department();
		dept.setDepartmentNumber(40);
		dept.setDepartmentName("MARKETING");
		dept.setDepartmentLocation("NM");
		
		Employee emp1 = new Employee(115,"Himesh","Salesman",5000,dept);
		Employee emp2 = new Employee(116,"Hisham","Salesman",6000,dept);
		Employee emp3 = new Employee(117,"Hira","Salesman",7000,dept);
		Employee emp4 = new Employee(118,"Heena","Salesman",7000,dept);
		
		
		Set<Employee> staff  = new HashSet<Employee>();	
		staff.add(emp1); //if add is called, only then insert query fired
		staff.add(emp2);
		staff.add(emp3);
		staff.add(emp4);
		
		dept.setEmployees(staff); //3 rows added
		
		baseDAO.merge(dept); //3 time update
		
	}

	@Test
	void assignNewDepartmentForExistingEmployees() {
		
		Department dept = new Department();
		dept.setDepartmentNumber(50);
		dept.setDepartmentName("QMS");
		dept.setDepartmentLocation("NP");
		
		List<Employee> empList = baseDAO.findAll("Employee");
		for(Employee emp: empList) {
			if(emp.getDept()==null) {
				System.out.println("emp : "+emp.getEmployeeName()+ " " + emp.getDept());
				emp.setDept(dept); //assigning a dept to this employee	
			}
		}
		//convert List into the Sat
		Set modifiedSet = new HashSet(empList);
		dept.setEmployees(modifiedSet);
		
		baseDAO.merge(dept);
		
	}

}







