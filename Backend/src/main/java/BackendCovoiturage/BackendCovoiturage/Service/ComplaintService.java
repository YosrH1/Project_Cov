package BackendCovoiturage.BackendCovoiturage.Service;

import BackendCovoiturage.BackendCovoiturage.Entity.Complaint;
import BackendCovoiturage.BackendCovoiturage.Repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    @Autowired
    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    // Method to add a new complaint
    public Complaint addComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    // Method to get all complaints
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    // Method to get a complaint by its ID
    public Optional<Complaint> getComplaintById(Long id) {
        return complaintRepository.findById(id);
    }
}
