package Labour_employemt_Backend.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Labour_employemt_Backend.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,String>{

  
    
}
