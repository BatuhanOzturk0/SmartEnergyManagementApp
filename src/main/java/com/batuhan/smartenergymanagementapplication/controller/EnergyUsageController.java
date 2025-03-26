package com.batuhan.smartenergymanagementapplication.controller;

import com.batuhan.smartenergymanagementapplication.exception.ResourceNotFoundException;
import com.batuhan.smartenergymanagementapplication.model.EnergyUsage;
import com.batuhan.smartenergymanagementapplication.service.EnergyUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usage")

public class EnergyUsageController {

    private final EnergyUsageService energyUsageService;

    @Autowired
    public EnergyUsageController(EnergyUsageService energyUsageService) {
        this.energyUsageService = energyUsageService;
    }
    @GetMapping
    public List<EnergyUsage> getAllUsage() {
        return energyUsageService.getAllUsages();
    }
    @PostMapping
    public EnergyUsage createUsage(@RequestBody EnergyUsage usage) {
        return energyUsageService.addUsage(usage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EnergyUsage> getUsageById(@PathVariable Long id) {
        EnergyUsage usage = energyUsageService.getUsageById(id);
        return ResponseEntity.ok(usage);
    }
    @PutMapping("{id}")
    public ResponseEntity<EnergyUsage> updateUsage(@PathVariable Long id, @RequestBody EnergyUsage usage) {
        EnergyUsage updated = energyUsageService.updateUsage(id, usage);
            return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsage(@PathVariable Long id) {
        energyUsageService.deleteUsage(id);
        return ResponseEntity.ok("Usage deleted successfully.");
    }
}
