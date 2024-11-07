package Labour_employemt_Backend.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Labour_employemt_Backend.demo.model.User;
import Labour_employemt_Backend.demo.model.sample;

public interface reposamp extends JpaRepository<sample,String> {

    void save(User user);
    
}
