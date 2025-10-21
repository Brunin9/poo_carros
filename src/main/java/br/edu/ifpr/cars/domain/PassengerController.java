package br.edu.ifpr.cars.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
    @Autowired
    private PassengerRepository repository;

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Passenger getPassengerById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Passenger not found"));
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return repository.save(passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        passenger.setId(id);
        return repository.save(passenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        repository.deleteById(id);
    }
}