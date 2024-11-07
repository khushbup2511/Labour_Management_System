package Labour_employemt_Backend.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Labour_employemt_Backend.demo.model.Employee;
import Labour_employemt_Backend.demo.model.User;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,String >{
   
}
