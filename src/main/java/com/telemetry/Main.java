package com.telemetry;

public class Main {
    public static void main(String[] args) {
        int serviceInterval = 250;

        Equipment loader1 = new Equipment("CAT-001", "988k", 300);
        Equipment loader2 = new Equipment("CAT-003", "523k", 250);

        System.out.println("CAT-001:");
        printMaintenanceStatus(loader1, serviceInterval);

        System.out.println("CAT-003:");
        printMaintenanceStatus(loader2, serviceInterval);
    }

    public static void printMaintenanceStatus(
            Equipment equipment, int serviceInterval) {

        int engineHours = equipment.getEngineHours();
        int hoursRemaining = serviceInterval - engineHours;

        if (hoursRemaining > 0) {
            System.out.println("Hours until service: " + hoursRemaining);
        } else if (hoursRemaining == 0) {
            System.out.println("Maintenance is due now");
        } else {
            System.out.println("Overdue by " + (-hoursRemaining) + " hours");
        }
    }
}