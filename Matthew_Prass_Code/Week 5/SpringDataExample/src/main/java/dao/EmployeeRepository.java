package dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import hello.Employee;

@RepositoryRestResource(collectionResourceRel = "emps", path = "emps")
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	  Employee findByFirstName(@Param("firstName")String firstName);

	  List<Employee> findByLastName(@Param("lastName")String lastName);
	}

