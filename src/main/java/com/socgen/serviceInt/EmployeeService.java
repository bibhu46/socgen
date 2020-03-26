package com.socgen.serviceInt;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.socgen.request.Employee;
import com.socgen.response.EmpWebResponse;

public interface EmployeeService {
	
	public ResponseEntity<EmpWebResponse> postaddEmp(Employee request);
	public ResponseEntity<EmpWebResponse> viewEmp(long id);
	public ResponseEntity<List<Employee>> viewAllEmp();
	public ResponseEntity<EmpWebResponse> deleteEmp(long id);

}
