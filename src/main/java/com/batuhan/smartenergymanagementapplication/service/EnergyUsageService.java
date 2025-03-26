package com.batuhan.smartenergymanagementapplication.service;

import com.batuhan.smartenergymanagementapplication.exception.ResourceNotFoundException;
import com.batuhan.smartenergymanagementapplication.model.EnergyUsage;
import com.batuhan.smartenergymanagementapplication.repository.EnergyUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class EnergyUsageService {

    private final EnergyUsageRepository energyUsageRepository;

    @Autowired
    public EnergyUsageService(EnergyUsageRepository energyUsageRepository) {
        this.energyUsageRepository = energyUsageRepository;
    }
    public List<EnergyUsage> getAllUsages() {
        return energyUsageRepository.findAll();
    }
    public EnergyUsage addUsage(EnergyUsage usage) {
        return energyUsageRepository.save(usage);
    }

    public EnergyUsage getUsageById(Long id) {
        return energyUsageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usage not found with this id: " + id));
    }
    public void deleteUsage(Long id) {
        EnergyUsage usage = energyUsageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usage not found with this id: " + id));

        energyUsageRepository.delete(usage);
    }
    public EnergyUsage updateUsage(Long id, EnergyUsage updatedUsage) {
        EnergyUsage existing = energyUsageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usage not found with this id: " + id));

            existing.setDeviceId(updatedUsage.getDeviceId());
            existing.setTimestamp(updatedUsage.getTimestamp());
            existing.setConsumptionKwh(updatedUsage.getConsumptionKwh());

            return energyUsageRepository.save(existing);
    }

}
