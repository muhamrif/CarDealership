package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {


    public Dealership getDealership(){
        Dealership dealership = new Dealership("","","");

        int lineCounter = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader( "inventory.csv"))){

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                if(lineCounter<=1){
                dealership.setName(tokens[0]);
                dealership.setAddress(tokens[1]);
                dealership.setPhone(tokens[2]);
                }else {
                   int vin = Integer.parseInt(tokens[0]);
                    int year = Integer.parseInt(tokens[1]);
                    String make = tokens[2];
                    String model = tokens[3];
                    String vehicleType = tokens[4];
                    String color = tokens[5];
                    int odometer = Integer.parseInt(tokens[6]);
                    double price = Double.parseDouble(tokens[7]);

                    Vehicle vehicle = new Vehicle(vin,year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);

                }

                lineCounter++;
            }

        } catch (IOException e) {
            System.err.print(e);
        }

        return dealership;
    };

    public void saveDealership(Dealership dealership){

    };
}
