package BackendCovoiturage.BackendCovoiturage.Service;

import BackendCovoiturage.BackendCovoiturage.Entity.Driver;
import BackendCovoiturage.BackendCovoiturage.Entity.DriverStatus;
import BackendCovoiturage.BackendCovoiturage.Entity.Role;
import BackendCovoiturage.BackendCovoiturage.Entity.User;
import BackendCovoiturage.BackendCovoiturage.Repository.DriverRepository;
import BackendCovoiturage.BackendCovoiturage.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // To encrypt passwords
    @Autowired
    private DriverRepository driverRepository;

    // Method to become a driver
    public void requestToBecomeDriver(Long userId, Driver driverDetails) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (user.getRole() != Role.USER) {
            throw new IllegalArgumentException("User is already a driver");
        }

        // Create the driver with the PENDING status
        driverDetails.setId(userId); // Set the user ID to the driver entity
        driverDetails.setStatus(DriverStatus.PENDING); // Set the status as PENDING initially
        driverRepository.save(driverDetails); // Save the driver details
    }
    public void deleteUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw new IllegalArgumentException("User not found.");
        }
    }


    // Admin method to approve or reject driver request
    public void approveDriverRequest(Long driverId, boolean isApproved) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new IllegalArgumentException("Driver not found"));

        if (isApproved) {
            driver.setStatus(DriverStatus.ACCEPTED); // Approve the request
        } else {
            driver.setStatus(DriverStatus.REJECTED); // Reject the request
        }
        driverRepository.save(driver); // Save the updated status
    }

    // Method to add a new user
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password before saving
        return userRepository.save(user);
    }

    // Authenticate user manually
    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email); // Find user by email
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user; // Return user if password matches
        }
        return null; // Return null if no match
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
