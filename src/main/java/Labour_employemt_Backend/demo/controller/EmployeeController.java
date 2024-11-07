package Labour_employemt_Backend.demo.controller;

import Labour_employemt_Backend.demo.model.Employee;
import Labour_employemt_Backend.demo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    // Get all employees
    @GetMapping("/getAllEmployees")
    public ResponseEntity<?> getAllEmployees() {
        try {
            return new ResponseEntity<>(employeeRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving employees: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Register a new employee
    @PostMapping("/registerEmployee")
    public ResponseEntity<Map<String, String>> addNewEmployee(@RequestBody Employee employee) {
        Map<String, String> response = new HashMap<>();

        // Check if 'eid' is not null or empty
        if (employee.getEid() == null || employee.getEid().isEmpty()) {
            response.put("error", "Employee ID (eid) must be provided.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); // Return 400 Bad Request
        }

        // Save the employee to the database
        try {
            employeeRepo.save(employee);
            response.put("message", "Employee registered successfully.");
            return ResponseEntity.status(HttpStatus.OK).body(response); // Return 200 OK with success message
        } catch (Exception e) {
            response.put("error", "An error occurred while registering the employee: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // Return 500 Internal Server Error on exception
        }
    }

    // Login an employee (authentication)
    @PostMapping("/loginEmployee")
    public ResponseEntity<Map<String, String>> loginEmployee(@RequestBody Employee loginDetails) {
        Map<String, String> response = new HashMap<>();
        Optional<Employee> employeeOpt = employeeRepo.findById(loginDetails.getEid());

        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            if (employee.getPassword().equals(loginDetails.getPassword())) {
                response.put("message", "Login successful.");
                return ResponseEntity.ok(response);
            } else {
                response.put("error", "Invalid password.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } else {
            response.put("error", "Employee ID not found.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    // Fetch employees by skill
    @GetMapping("/getEmployeesBySkill")
public ResponseEntity<?> getEmployeesBySkill(@RequestParam("skill") String skill) {
    try {
        List<Employee> employees = employeeRepo.findEmployeesBySkill(skill);
        if (employees.isEmpty()) {
            return new ResponseEntity<>("No employees found with the specified skill.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>("Error retrieving employees by skill: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    
}
