package BackendCovoiturage.BackendCovoiturage.Controller;

import BackendCovoiturage.BackendCovoiturage.Entity.Driver;
import BackendCovoiturage.BackendCovoiturage.Entity.User;
import BackendCovoiturage.BackendCovoiturage.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    // Add a new user
    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        User user = userService.authenticate(email, password);
        if (user != null) {
            return "Login successful! Welcome " + user.getEmail();
        } else {
            return "Invalid credentials!";
        }
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Optional: Endpoint to authenticate user (login)
    @PostMapping("/authenticate")
    public User authenticate(@RequestParam String email, @RequestParam String password) {
        return userService.authenticate(email, password);
    }
    @PostMapping("/become-driver/{userId}")
    public ResponseEntity<String> becomeDriver(@PathVariable Long userId, @RequestBody Driver driverDetails) {
        try {
            userService.requestToBecomeDriver(userId, driverDetails);
            return ResponseEntity.ok("User is now a driver.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}