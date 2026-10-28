package com.telemetry;

public class MaintenanceCalculator {

    public static int hoursRemaining(
            Equipment equipment, int serviceInterval) {

        int engineHours = equipment.getEngineHours();
        int hoursRemaining = serviceInterval - engineHours;

        return hoursRemaining;
    }
}
