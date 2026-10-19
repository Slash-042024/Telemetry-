package com.telemetry;

public class Main {
    public static void main(String[] args) {
        int engineHours = 300;
        int serviceInterval = 250;

        int hoursRemaining =  serviceInterval - engineHours;

        if (hoursRemaining > 0){

            System.out.println(" Hours until service: " + hoursRemaining);
        } else if ( hoursRemaining == 0){
            System.out.println("Maintenance is due now");
        } else {
            System.out.println( "Overdue Warning");
        }
    }
}

