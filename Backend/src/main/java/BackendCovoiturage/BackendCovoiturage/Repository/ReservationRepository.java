package BackendCovoiturage.BackendCovoiturage.Repository;

import BackendCovoiturage.BackendCovoiturage.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
