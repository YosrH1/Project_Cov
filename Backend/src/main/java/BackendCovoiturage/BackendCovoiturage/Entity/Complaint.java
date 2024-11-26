package BackendCovoiturage.BackendCovoiturage.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String description;
    private String response;

    @Temporal(TemporalType.DATE)
    private Date declarationDate;

    @ManyToOne
    private User user;

    // Getters and Setters
}
