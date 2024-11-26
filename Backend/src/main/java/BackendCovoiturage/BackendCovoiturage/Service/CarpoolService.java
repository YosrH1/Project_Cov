
package BackendCovoiturage.BackendCovoiturage.Service;

import BackendCovoiturage.BackendCovoiturage.Entity.Carpool;
import BackendCovoiturage.BackendCovoiturage.Repository.CarpoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarpoolService {

    private final CarpoolRepository carpoolRepository;
    // Method to add a new carpool
    public Carpool addCarpool(Carpool carpool) {
        return carpoolRepository.save(carpool);
    }
    @Autowired
    public CarpoolService(CarpoolRepository carpoolRepository) {
        this.carpoolRepository = carpoolRepository;
    }

    public List<Carpool> getAllCarpools() {
        return carpoolRepository.findAll();
    }
    public Optional<Carpool> getCarpoolById(Long id) {
        return carpoolRepository.findById(id);
    }
}

