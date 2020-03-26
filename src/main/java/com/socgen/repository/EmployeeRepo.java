/**
 * 
 */
package com.socgen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.socgen.request.Employee;

/**
 * @author Bibhu
 *
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	@Query("from Employee order by first_name asc")
	public List<Employee > sortByName();
}
