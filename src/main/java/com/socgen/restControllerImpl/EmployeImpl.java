/**
 * 
 */
package com.socgen.restControllerImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socgen.request.Employee;
import com.socgen.response.EmpWebResponse;
import com.socgen.restControllerInt.EmployeeApi;
import com.socgen.serviceImpl.EmployeServiceImpl;
import com.socgen.serviceInt.EmployeeService;

/**
 * @author Bibhu
 *
 */
@CrossOrigin(origins = "*")
@RestController
public class EmployeImpl implements EmployeeApi{

	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;
	
	@Autowired
	public EmployeImpl(ObjectMapper objectMapper,HttpServletRequest request ) {
		this.objectMapper=objectMapper;
		this.request=request;
	}
	
	@Autowired
	EmployeeService empSer;
	
	@Override
	public ResponseEntity<EmpWebResponse> postaddEmp(@Valid Employee requestBody) {
		ResponseEntity<EmpWebResponse> response = empSer.postaddEmp(requestBody);
		return response;
	}

	@Override
	public ResponseEntity<EmpWebResponse> viewEmp(@NotNull @Valid long employeeId) {
		ResponseEntity<EmpWebResponse> response = empSer.viewEmp(employeeId);
		return response;
	}

	@Override
	public ResponseEntity<List<Employee>> viewAllEmp() {
		ResponseEntity<List<Employee>> emp = empSer.viewAllEmp();
		return emp;
	}

	@Override
	public ResponseEntity<EmpWebResponse> deleteEmp(@NotNull @Valid long employeeId) {
		ResponseEntity<EmpWebResponse> response = empSer.deleteEmp(employeeId);
		return response;
		
	}

}
