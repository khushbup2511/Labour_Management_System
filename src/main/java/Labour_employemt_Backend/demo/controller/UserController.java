package Labour_employemt_Backend.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Labour_employemt_Backend.demo.model.User;
import Labour_employemt_Backend.demo.repository.UserRepo;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5501")  // Allow cross-origin requests from the frontend

public class UserController {

    @Autowired
    private UserRepo rUserRepo;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return rUserRepo.findAll();
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        if (user.getUid() == null || user.getUid().isEmpty()) {
            return "User ID (uid) must be provided";
        }
        rUserRepo.save(user);
        return "Saved";
    }

    // New login endpoint for user authentication
    @PostMapping("/login")
    public String loginUser(@RequestBody User loginDetails) {
        Optional<User> user = rUserRepo.findById(loginDetails.getUid());

        if (user.isPresent() && user.get().getPassword().equals(loginDetails.getPassword())) {
            return "Login successful";  // Successful login
        } else {
            return "Invalid username or password";  // Authentication failed
        }
    }
}
