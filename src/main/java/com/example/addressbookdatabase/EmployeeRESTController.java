package com.example.addressbookdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;


@Controller
public class EmployeeRESTController {

    private EmployeeList employees;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeRESTController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void init() {
    }

    //Utility methods for getting employee by id
    private Employee getEmployeeById(int id) {
        for (Employee e : employees.getEmployees()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    /**
     * HTTP GET - Get all employees
     */
    @RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<EmployeeList> getAllEmployeesJSON() {
        employees = new EmployeeList();
        employees.setEmployees(employeeRepository.findAll());
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * HTTP POST - Create new Employee
     */
    @RequestMapping(value = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> createEmployee(@RequestBody Employee newEmployee) {
        newEmployee.setId(employees.getEmployees().size() + 1);
        employeeRepository.save(newEmployee);
        System.out.println(newEmployee.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * HTTP PUT - Update employee
     */
    @RequestMapping(value = "/employees/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        Employee employeeToUpdate = getEmployeeById(id);
        if (employeeToUpdate != null) {
            employeeToUpdate.setFirstName(employee.getFirstName());
            employeeToUpdate.setLastName(employee.getLastName());
            employeeToUpdate.setEmail(employee.getEmail());
            employeeRepository.save(employeeToUpdate);
            return new ResponseEntity<>(employeeToUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * HTTP DELETE - Delete employee
     */
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
        Employee employeeToDelete = getEmployeeById(id);
        if (employeeToDelete != null) {
            employeeRepository.delete(employeeToDelete);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}