package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	  Employee findByFirstName(String firstName);

	  List<Employee> findByLastName(String lastName);
	}

