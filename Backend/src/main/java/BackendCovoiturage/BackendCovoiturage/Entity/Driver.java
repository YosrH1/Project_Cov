package BackendCovoiturage.BackendCovoiturage.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Driver extends User {
    private String address;
    private String cin;
    private String dateOfBirth;
    private String photo;
    private String licenseNumber;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Carpool> carpools;
    @Enumerated(EnumType.STRING)
    private DriverStatus status = DriverStatus.PENDING;
    // Getters and Setters
}

