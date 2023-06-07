package com.ems.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.*;

import com.ems.entity.Address;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;

import lombok.val;

@TestMethodOrder(value = OrderAnnotation.class)
class EmployeeServiceTest {

EmployeeService employeeService;
 

@BeforeAll
static void init()
{

}


	@BeforeEach
	void setUp() throws Exception {
		employeeService=new EmployeeService();
	}

	@AfterEach
	void tearDown() throws Exception {
		employeeService=null;
		System.out.println("object is garbage collected");
	}

	
	@Test
	@DisplayName("testing add employee method")
	@Order(1)
	public void testAddEmployee()
	{
		//way 1
//		employeeService.addEmployee(101, "nil", 20000, "kolkaya", "india");
//		employeeService.addEmployee(102, "subhajit", 10000, "kolkaya", "india");
		//assertEquals(2, employeeService.lengthOfList());
		
		//way 2 using builder
	  Address add=Address.builder().city("kolkata").country("india").build();
		Employee emp=Employee.builder().empId(101).empName("chandan").
				empSal(10000).address(add).build();
		employeeService.addEmp(emp);
		int length=employeeService.lengthOfList();
		assertThat(length>0).isTrue();
	}
	
	     @Test
	    @DisplayName("test case for delete employees")
	     @Order(5)
	    public void testDeleteAllEmployee()
	    {
	   // String msg=employeeService.deleteAllEmployee();
	    assertEquals("All employees deleted successfully", employeeService.deleteAllEmployee());
	    }
	  
  
	
    @Test
    @DisplayName("test case for calculate appraisal")
    @Order(value = 4)
    public void testCalculateAppraisal()
    {
    	employeeService.addEmployee(101, "nil", 20000, "kolkaya", "india");
    	double appraisal=employeeService.calculateAppraisalById(101);
    	//assertEquals(2000, appraisal);
    	assertThat(appraisal).isEqualTo(2000);
    }
    
    
    
    @Test
    @DisplayName("test case for display method")
    @Order(2)
	public void testDisplayEmpById() throws GlobalException
	{
		 Address add=Address.builder().city("delhi").country("india").build();
			Employee emp=Employee.builder().empId(102).empName("nilanjan").
					empSal(50000.00).address(add).build();
			employeeService.addEmp(emp);
			
		Employee e	=employeeService.displayEmpById(102);
			//assertEquals("nilanjan",e.getEmpName());
		assertThat(e.getEmpSal()).isEqualTo(50000.00);
	}
  
    @Test
    @DisplayName("testcase for update employee")
    @Order(value = 3)
    public void testUpdateEmp() throws GlobalException
    {
    	employeeService.addEmployee(101, "nil", 20000, "kolkaya", "india");
    	Employee emp=employeeService.findId(101);
    	emp.setEmpName("nilanjan");
    	
    	Employee updateEmp=employeeService.updateEmployee(0, emp);
    	//assertEquals("nilanjan",updateEmp.getEmpName());
    	assertThat(updateEmp.getEmpName()).isEqualTo("nilanjan");		
    }
}
