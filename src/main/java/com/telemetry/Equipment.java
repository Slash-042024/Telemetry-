package com.telemetry;

public class Equipment {
    private String equipmentId;

    private String model;

    private int engineHours;

    public Equipment (String equipmentId, String model, int engineHours) {
        this.equipmentId = equipmentId;
        this.model = model;
        this.engineHours = engineHours;

        Equipment loader = new Equipment("CAT-001", "988k", 300);

    }
}

