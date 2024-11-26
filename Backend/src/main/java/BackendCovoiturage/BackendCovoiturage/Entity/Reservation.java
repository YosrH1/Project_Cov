package BackendCovoiturage.BackendCovoiturage.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date reservationDate;

    private String status;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Carpool carpool;

    // Getters and Setters
}
