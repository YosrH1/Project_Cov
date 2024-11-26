package BackendCovoiturage.BackendCovoiturage.Repository;

import BackendCovoiturage.BackendCovoiturage.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email); // Custom method to find user by email
}
