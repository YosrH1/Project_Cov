package BackendCovoiturage.BackendCovoiturage.Controller;

import BackendCovoiturage.BackendCovoiturage.Entity.Complaint;
import BackendCovoiturage.BackendCovoiturage.Service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/complaint")
public class ComplaintController {

    private final ComplaintService complaintService;

    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    // Endpoint to add a new complaint
    @PostMapping("/add")
    public ResponseEntity<Complaint> addComplaint(@RequestBody Complaint complaint) {
        Complaint createdComplaint = complaintService.addComplaint(complaint);
        return new ResponseEntity<>(createdComplaint, HttpStatus.CREATED);
    }

    // Endpoint to get all complaints
    @GetMapping("/all")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        List<Complaint> complaints = complaintService.getAllComplaints();
        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }

    // Endpoint to get a complaint by ID
    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long id) {
        Optional<Complaint> complaint = complaintService.getComplaintById(id);
        if (complaint.isPresent()) {
            return new ResponseEntity<>(complaint.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
