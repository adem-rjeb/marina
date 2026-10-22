package com.marina.marina.controller;

import com.marina.marina.entity.Port;
import com.marina.marina.repository.PortRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ports")
public class PortController {

    private final PortRepository portRepository;

    public PortController(PortRepository portRepository) {
        this.portRepository = portRepository;
    }

    @GetMapping
    public List<Port> getAll() {
        return portRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Port> getById(@PathVariable Long id) {
        return portRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Port> create(@Valid @RequestBody Port port) {
        Port saved = portRepository.save(port);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Port> update(@PathVariable Long id, @Valid @RequestBody Port port) {
        return portRepository.findById(id)
                .map(existing -> {
                    existing.setName(port.getName());
                    existing.setCity(port.getCity());
                    existing.setCountry(port.getCountry());
                    existing.setCapacity(port.getCapacity());
                    return ResponseEntity.ok(portRepository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!portRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        portRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}