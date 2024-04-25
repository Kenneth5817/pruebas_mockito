package org.iesvdm.employee;
/**
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Test doubles that are "fakes" must be tested
 *
 *
 */
/**
@Nested
class EmployeeInMemoryRepositoryTest {

	private EmployeeInMemoryRepository employeeRepository;

	private List<Employee> employees;

	@BeforeEach
	public void setup() {
		employees = new ArrayList<>();
		employeeRepository = new EmployeeInMemoryRepository(employees);
	}

	/**
	 * Descripcion del test:
	 * crea 2 Employee diferentes
	 * aniadelos a la coleccion de employees
	 * comprueba que cuando llamas a employeeRepository.findAll
	 * obtienes los empleados aniadidos en el paso anterior
	 */
	/**@Test
	public void testEmployeeRepositoryFindAll() {
		// Create sample employees
		Employee employee1 = new Employee(1, "John", "Doe", 50000);
		Employee employee2 = new Employee(2, "Jane", "Smith", 60000);
		List<Employee> allEmployees = new ArrayList<>();
		allEmployees.add(employee1);
		allEmployees.add(employee2);

		// Mock the behavior of the employees list
		LinkedTransferQueue<Object> employeesMock = null;
		when(employeesMock.isEmpty()).thenReturn(false);
		when(employeesMock.iterator()).thenReturn(allEmployees.iterator());

		// Retrieve all employees from the repository
		List<Employee> retrievedEmployees = employeeRepository.findAll();

		// Check if the retrieved employees match the ones added
		assertThat(retrievedEmployees).containsExactly(employee1, employee2);
	}
	}

	/**
	 * Descripcion del test:
	 * salva un Employee mediante el metodo
	 * employeeRepository.save y comprueba que la coleccion
	 * employees contiene solo ese Employee
	 */
	/**@Test
	public void testEmployeeRepositorySaveNewEmployee() {
// Create a new employee
		Employee newEmployee = new Employee(1, "John", "Doe", 50000);

		// Mock the behavior of the employees list
		Object employeesMock = null;
		when(employeesMock.add(newEmployee)).thenReturn(true);

		// Save the new employee
		Employee savedEmployee = employeeRepository.save(newEmployee);

		// Verify that the employee was added to the list and returned
		verify(employeesMock).add(newEmployee);
		assertThat(savedEmployee).isEqualTo(newEmployee);
	}
	}

	/**
	 * Descripcion del tets:
	 * crea un par de Employee diferentes
	 * aniadelos a la coleccion de employees.
	 * A continuacion, mediante employeeRepository.save
	 * salva los Employee anteriores (mismo id) con cambios
	 * en el salario y comprueba que la coleccion employees
	 * los contiene actualizados.
	 */
	/**
	@Test
	public void testEmployeeRepositorySaveExistingEmployee() {
		Employee existingEmployee = new Employee(1, "John", "Doe", 50000);

		// Mock the behavior of the employees list
		Object employeesMock;
		when(employeesMock.iterator()).thenReturn(List.of(existingEmployee).iterator());

		// Save the existing employee
		Employee savedEmployee = employeeRepository.save(existingEmployee);

		// Verify that the existing employee was updated in the list and returned
		verify(employeesMock).iterator();
		assertThat(savedEmployee).isEqualTo(existingEmployee);
	}
}
	}
}**/

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeInMemoryRepositoryTest {

	private EmployeeInMemoryRepository employeeRepository;
	private List<Employee> employeesMock;

	@BeforeEach
	public void setup() {
		employeesMock = mock(EmployeeList.class);
		employeeRepository = new EmployeeInMemoryRepository(employeesMock);
	}

	@Test
	public void testEmployeeRepositoryFindAll() {
		// Create sample employees
		Employee employee1 = new Employee(1, "John", "Doe", 50000);
		Employee employee2 = new Employee(2, "Jane", "Smith", 60000);
		List<Employee> allEmployees = new ArrayList<>();
		allEmployees.add(employee1);
		allEmployees.add(employee2);


		when(employeesMock.isEmpty()).thenReturn(false);
		when(employeesMock.iterator()).thenReturn(allEmployees.iterator());

		List<Employee> retrievedEmployees = employeeRepository.findAll();

		assertThat(retrievedEmployees).containsExactly(employee1, employee2);
	}

	@Test
	public void testEmployeeRepositorySaveNewEmployee() {

		Employee newEmployee = new Employee("John", 50000);

		when(employeesMock.add(newEmployee)).thenReturn(true);

		Employee savedEmployee = employeeRepository.save(newEmployee);

		verify(employeesMock).add(newEmployee);
		assertThat(savedEmployee).isEqualTo(newEmployee);
	}

	@Test
	public void testEmployeeRepositorySaveExistingEmployee() {

		Employee existingEmployee = new Employee(1, "John", "Doe", 50000);

		when(employeesMock.iterator()).thenReturn(List.of(existingEmployee).iterator());

		Employee savedEmployee = employeeRepository.save(existingEmployee);

		verify(employeesMock).iterator();
		assertThat(savedEmployee).isEqualTo(existingEmployee);
	}

	static class EmployeeList extends ArrayList<Employee> {
	}
}
