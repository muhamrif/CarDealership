package com.pluralsight;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class DealershipTest {

    private List<Vehicle> inventory;

    @BeforeEach
    public void setUp() {
        inventory = new ArrayList<>();
        inventory.add(new Vehicle(1, 2020, "Toyota", "Camry", "Sedan", "Red", 10000, 20000.0));
        inventory.add(new Vehicle(2, 2021, "Honda", "Civic", "Sedan", "Blue", 8000, 25000.0));
        inventory.add(new Vehicle(3, 2022, "Ford", "F-150", "Truck", "Black", 15000, 30000.0));
    }

    @Test
    public void testGetVehicleByPriceWithinRange() {
        List<Vehicle> filteredArray = getVehicleByPrice(20000.0, 30000.0);

        for (Vehicle vehicle : filteredArray) {
            assertTrue(vehicle.getPrice() >= 20000.0 && vehicle.getPrice() <= 30000.0);
        }
    }

    @Test
    public void testGetVehicleByPriceNoMatch() {
        List<Vehicle> filteredArray = getVehicleByPrice(40000.0, 45000.0);

        assertTrue(filteredArray.isEmpty());
    }

    @Test
    public void testGetVehicleByMakeModelMatch() {
        List<Vehicle> filteredArray = getVehicleByMakeModel("Ford", "F-150");

        for (Vehicle vehicle : filteredArray) {
            assertTrue(vehicle.getMake().equalsIgnoreCase("Ford") || vehicle.getModel().equalsIgnoreCase("F-150"));
        }
    }

    @Test
    public void testGetVehicleByMakeModelNoMatch() {
        List<Vehicle> filteredArray = getVehicleByMakeModel("Chevrolet", "Malibu");

        assertTrue(filteredArray.isEmpty());
    }

    @Test
    public void testGetVehicleByYearWithinRange() {
        List<Vehicle> filteredArray = getVehicleByYear(2020, 2021);

        for (Vehicle vehicle : filteredArray) {
            assertTrue(vehicle.getYear() >= 2020 && vehicle.getYear() <= 2021);
        }
    }

    @Test
    public void testGetVehicleByYearNoMatch() {
        List<Vehicle> filteredArray = getVehicleByYear(2019, 2019);

        assertTrue(filteredArray.isEmpty());
    }


    private List<Vehicle> getVehicleByPrice(double min, double max) {
        List<Vehicle> filteredArray = new ArrayList<>();

        for (Vehicle x : inventory) {
            if (x.getPrice() >= min && x.getPrice() <= max) {
                filteredArray.add(x);
            }
        }

        return filteredArray;
    }

    private List<Vehicle> getVehicleByMakeModel(String make, String model) {
        List<Vehicle> filteredArray = new ArrayList<>();

        for (Vehicle x : inventory) {
            if (x.getMake().equalsIgnoreCase(make) || x.getModel().equalsIgnoreCase(model)) {
                filteredArray.add(x);
            }
        }

        return filteredArray;
    }

    private List<Vehicle> getVehicleByYear(int min, int max) {
        List<Vehicle> filteredArray = new ArrayList<>();

        for (Vehicle x : inventory) {
            if (x.getYear() >= min && x.getYear() <= max) {
                filteredArray.add(x);
            }
        }

        return filteredArray;
    }

//    @AfterAll
//    public void tearDown() {
//        inventory.clear();
//    }
}

