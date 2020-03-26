/**
 * 
 */
package com.socgen.restControllerInt;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.socgen.request.Employee;
import com.socgen.response.EmpWebResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-24T13:06:00.439+05:30")
/**
 * @author Bibhu
 *
 */

@Api(value = "empGUI", description = "the empGUI API")
public interface EmployeeApi {

	@ApiOperation(value = "Add Employee", nickname = "empAdd", notes = "Add Employee", response = EmpWebResponse.class, tags = {
			"EmpPortal", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "view success", response = EmpWebResponse.class) })
	@RequestMapping(value = "/manageEmp/addEmp", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	ResponseEntity<EmpWebResponse> postaddEmp(@ApiParam(value = "") @Valid @RequestBody Employee request);

	@ApiOperation(value = "View Employee", nickname = "empView", notes = "View Employee", response = EmpWebResponse.class, tags = {
			"EmpPortal", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "view success", response = EmpWebResponse.class) })
	@RequestMapping(value = "/manageEmp/viewEmp", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<EmpWebResponse> viewEmp(
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "employeeId", required = true) long employeeId);

	@ApiOperation(value = "View All Employee", nickname = "empView", notes = "View All Employee", response = Employee.class, tags = {
			"EmpPortal", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "view success", response = Employee.class) })
	@RequestMapping(value = "/manageEmp/viewAllEmp", produces = "application/json", method = RequestMethod.GET)
	ResponseEntity<List<Employee>> viewAllEmp();
	
	
	@ApiOperation(value = "Delete Employee", nickname = "empDel", notes = "Delete Employee", response = EmpWebResponse.class, tags = {
			"EmpPortal", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "delete success", response = EmpWebResponse.class) })
	@RequestMapping(value = "/manageEmp/delEmp", produces = "application/json", method = RequestMethod.DELETE)
	ResponseEntity<EmpWebResponse> deleteEmp(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "employeeId", required = true) long employeeId);
	
	
	
}
