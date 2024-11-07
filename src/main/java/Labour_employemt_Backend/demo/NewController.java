package Labour_employemt_Backend.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Labour_employemt_Backend.demo.model.User;
import Labour_employemt_Backend.demo.model.sample;
import Labour_employemt_Backend.demo.repository.reposamp;
@RequestMapping("new")
@RestController
public class NewController {
  
   
    @Autowired
    reposamp sReposamp;

    @GetMapping("/all")
    public List<sample> newList(){
    return  sReposamp.findAll();

    }


   
}


