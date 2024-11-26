package BackendCovoiturage.BackendCovoiturage.Repository;

import BackendCovoiturage.BackendCovoiturage.Entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
