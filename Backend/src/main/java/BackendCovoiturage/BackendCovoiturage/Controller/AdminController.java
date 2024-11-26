package BackendCovoiturage.BackendCovoiturage.Controller;

import BackendCovoiturage.BackendCovoiturage.Service.UserService;
import BackendCovoiturage.BackendCovoiturage.Service.DriverService;
import BackendCovoiturage.BackendCovoiturage.Service.CarpoolService;
import BackendCovoiturage.BackendCovoiturage.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private CarpoolService carpoolService;

    @Autowired
    private ReservationService reservationService;

    // Admin endpoint to approve or reject a driver request
    @PostMapping("/approve-driver/{driverId}")
    public ResponseEntity<String> approveDriverRequest(@PathVariable Long driverId, @RequestParam boolean isApproved) {
        try {
            userService.approveDriverRequest(driverId, isApproved);
            String message = isApproved ? "Driver request approved." : "Driver request rejected.";
            return ResponseEntity.ok(message);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Admin endpoint to delete a user by ID
    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok("User deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting user: " + e.getMessage());
        }
    }

    // Admin endpoint to delete a driver by ID
    @DeleteMapping("/delete-driver/{driverId}")
    public ResponseEntity<String> deleteDriver(@PathVariable Long driverId) {
        try {
            driverService.deleteDriver(driverId);
            return ResponseEntity.ok("Driver deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting driver: " + e.getMessage());
        }
    }

    // Admin endpoint to consult all carpools
    @GetMapping("/carpools")
    public ResponseEntity<?> getAllCarpools() {
        try {
            return ResponseEntity.ok(carpoolService.getAllCarpools());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching carpools: " + e.getMessage());
        }
    }

    // Admin endpoint to consult all drivers
    @GetMapping("/drivers")
    public ResponseEntity<?> getAllDrivers() {
        try {
            return ResponseEntity.ok(driverService.getAllDrivers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching drivers: " + e.getMessage());
        }
    }

    // Admin endpoint to consult all users
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching users: " + e.getMessage());
        }
    }


}
