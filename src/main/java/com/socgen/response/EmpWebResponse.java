/**
 * 
 */
package com.socgen.response;

import java.sql.Timestamp;

/**
 * @author Bibhu
 *
 */
public class EmpWebResponse {

	public String code;
	public String message;
	private Timestamp generatedAt;
	public boolean isError;
	private EmployeeResponse empployeeResponse;
	
	public EmployeeResponse getEmpployeeResponse() {
		return empployeeResponse;
	}
	public void setEmpployeeResponse(EmployeeResponse empployeeResponse) {
		this.empployeeResponse = empployeeResponse;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getGeneratedAt() {
		return generatedAt;
	}
	public void setGeneratedAt(Timestamp generatedAt) {
		this.generatedAt = generatedAt;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	

}
