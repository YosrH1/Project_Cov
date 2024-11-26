package BackendCovoiturage.BackendCovoiturage.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Carpool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleType;
    private int totalSeats;
    private int availableSeats;
    private String status;
    private String departureCity;
    private String arrivalCity;
    private String meetingLocation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;

    private String licensePlate;

    @ManyToOne
    private Driver driver;

    @OneToMany(mappedBy = "carpool", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    // Getters and Setters
}
