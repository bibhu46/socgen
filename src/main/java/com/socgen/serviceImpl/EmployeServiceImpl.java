/**
 * 
 */
package com.socgen.serviceImpl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.socgen.repository.EmployeeRepo;
import com.socgen.request.Employee;
import com.socgen.response.EmpWebResponse;
import com.socgen.response.EmployeeResponse;
import com.socgen.serviceInt.EmployeeService;

/**
 * @author Bibhu
 *
 */
@Service
public class EmployeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo empRepo;

	@Override
	public ResponseEntity<EmpWebResponse> postaddEmp(Employee request) {

		EmpWebResponse empWres = new EmpWebResponse();
		EmployeeResponse empres = new EmployeeResponse();
		try {
			Employee emp = empRepo.save(request);
			empres.setId(emp.getId());
			empWres.setEmpployeeResponse(empres);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return new ResponseEntity<>(empWres, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EmpWebResponse> viewEmp(long id) {
		EmpWebResponse empWres = new EmpWebResponse();
		EmployeeResponse empres = new EmployeeResponse();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		Optional<Employee> emp = empRepo.findById(id);
		if (emp.isPresent()) {
			Employee e = emp.get();
			empres.setId(e.getId());
			empres.setDepartment(e.getDepartment());
			empres.setDob(e.getDob());
			empres.setFirstName(e.getFirstName());
			empres.setLastName(e.getLastName());
			empWres.setEmpployeeResponse(empres);
			empWres.setCode("200");
			empWres.setGeneratedAt(timestamp);
		} else {
			empWres.setError(true);
		}
		return new ResponseEntity<>(empWres, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Employee>> viewAllEmp() {
		List<Employee> emp = empRepo.sortByName();

		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EmpWebResponse> deleteEmp(long id) {
		EmpWebResponse res = new EmpWebResponse();
		empRepo.deleteById(id);
		res.setMessage("Employee deleted successfully");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
