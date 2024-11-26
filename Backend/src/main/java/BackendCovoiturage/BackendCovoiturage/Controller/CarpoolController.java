package BackendCovoiturage.BackendCovoiturage.Controller;

import BackendCovoiturage.BackendCovoiturage.Entity.Carpool;
import BackendCovoiturage.BackendCovoiturage.Repository.CarpoolRepository;
import BackendCovoiturage.BackendCovoiturage.Service.CarpoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carpool")
public class CarpoolController {

    @Autowired
    private CarpoolService carpoolService;


    // Endpoint to add a new carpool
    @PostMapping("/add")
    public ResponseEntity<Carpool> addCarpool(@RequestBody Carpool carpool) {
        Carpool createdCarpool = carpoolService.addCarpool(carpool);
        return new ResponseEntity<>(createdCarpool, HttpStatus.CREATED);
    }
    @GetMapping("/allCarpool")
    public ResponseEntity<List<Carpool>> getAllCarpools() {
        List<Carpool> carpools = carpoolService.getAllCarpools();
        System.out.println("Carpools: " + carpools);  // Log the list of carpools
        return new ResponseEntity<>(carpools, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Carpool> getCarpoolById(@PathVariable Long id) {
        Optional<Carpool> carpool = carpoolService.getCarpoolById(id);
        if (carpool.isPresent()) {
            return new ResponseEntity<>(carpool.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
