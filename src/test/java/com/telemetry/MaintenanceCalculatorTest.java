package com.telemetry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaintenanceCalculatorTest {

    @Test
    void return50HoursWhenServiceIsUpcoming() {
        //Arranage: create the data for this scenario.
        Equipment equipment = new Equipment("Cat-001","988k", 200);
        int serviceInterval = 250;

        //Act: call the method being tested.

        int actualHours =
                MaintenanceCalculator.hoursRemaining(equipment, serviceInterval);

        // Assert: compare the expected results with the actual results.

        assertEquals(50, actualHours);

    }
    @Test
    void returnsZeroWhenServiceIsDue() {
        // Arrange
        Equipment equipment = new Equipment("CAT-001", "988k", 250);
        int serviceInterval = 250;

        // Act
        int actualHours =
                MaintenanceCalculator.hoursRemaining(equipment, serviceInterval);

        // Assert
        assertEquals(0, actualHours);
    }

    @Test
    void returnsNegative50WhenServiceIsOverdue() {
        // Arrange
        Equipment equipment = new Equipment("CAT-001", "988k", 300);
        int serviceInterval = 250;

        // Act
        int actualHours =
                MaintenanceCalculator.hoursRemaining(equipment, serviceInterval);

        // Assert
        assertEquals(-50, actualHours);
    }
}
