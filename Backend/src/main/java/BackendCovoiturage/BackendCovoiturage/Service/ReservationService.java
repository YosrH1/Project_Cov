package BackendCovoiturage.BackendCovoiturage.Service;

import BackendCovoiturage.BackendCovoiturage.Entity.Reservation;
import BackendCovoiturage.BackendCovoiturage.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Method to add a new reservation
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Method to get all reservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Method to get a reservation by its ID
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }
    public void acceptReservation(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            Reservation res = reservation.get();
            res.setStatus("Accepted");
            reservationRepository.save(res);
        } else {
            throw new IllegalArgumentException("Reservation not found.");
        }
    }

    public void rejectReservation(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            Reservation res = reservation.get();
            res.setStatus("Rejected");
            reservationRepository.save(res);
        } else {
            throw new IllegalArgumentException("Reservation not found.");
        }
    }

}
