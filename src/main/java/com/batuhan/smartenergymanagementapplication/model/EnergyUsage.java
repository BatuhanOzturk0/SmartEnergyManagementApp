package com.batuhan.smartenergymanagementapplication.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "energy_usage")

public class EnergyUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usageId;

    @Column(name = "device_id")
    private long deviceId;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "consumption_kwh")
    private Double consumptionKwh;

    //Getter and Setter

    public long getUsageId() {return usageId;}
    public void setUsageId(long usageId) {this.usageId = usageId;}

    public long getDeviceId() {return deviceId;}
    public void setDeviceId(long deviceId) {this.deviceId = deviceId;}

    public LocalDateTime getTimestamp() {return timestamp;}
    public void setTimestamp(LocalDateTime timestamp) {this.timestamp = timestamp;}

    public Double getConsumptionKwh() {return consumptionKwh;}
    public void setConsumptionKwh(Double consumptionKwh) {this.consumptionKwh = consumptionKwh;}
}
