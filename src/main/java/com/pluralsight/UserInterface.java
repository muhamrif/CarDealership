package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private static Dealership dealership;
    static Scanner input = new Scanner(System.in);

//__________________________


    public UserInterface() {
    }
    //__________________________
    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

//__________________________

    private void init(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
    }
    private static void updateDealership(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);
    }


    public void display(){
        init();
        displayMenu();
    }

    public static void processGetByPriceRequest(){
        System.out.println("enter min:");
        Double min = Double.parseDouble(input.next());
        System.out.println("enter max:");
        Double max = Double.parseDouble(input.next());
        displayHelper(dealership.getVehicleByPrice(min, max));
    }

    public static void processGetByMakeModelRequest(){
        System.out.println("enter make:");
        String make = input.next();
        System.out.println("enter model:");
        String model = input.next();
        displayHelper(dealership.getVehicleByMakeModel(make, model));

    }

    public static void processGetByYearRequest(){
        System.out.println("enter min:");
        int min = Integer.parseInt(input.next());
        System.out.println("enter max:");
        int max = Integer.parseInt(input.next());
        displayHelper(dealership.getVehicleByYear(min, max));

    }

    public static void processGetByColorRequest(){
        System.out.println("enter color:");
        String color = input.next();
        System.out.println(color);
        displayHelper(dealership.getVehicleByColor(color));
    }

    public static void processGetByMileageRequest(){
        System.out.println("enter min:");
        int min = Integer.parseInt(input.next());
        System.out.println("enter max:");
        int max = Integer.parseInt(input.next());
        displayHelper(dealership.getVehicleByMileage(min, max));
    }

    public static void processGetByVehicleTypeRequest(){
        System.out.println("enter vehicle type:");
        String type = input.next();
        displayHelper(dealership.getVehicleByType(type));
    }

    public static void processGetAllVehicleRequest(){
    displayHelper(dealership.getAllVehicle());
    }

    public static void processAddVehicleRequest(){
        System.out.println("enter vin:");
        int vin = Integer.parseInt(input.next());
        System.out.println("enter year:");
        int year = Integer.parseInt(input.next());
        System.out.println("enter make:");
        String make = input.next();
        System.out.println("enter model:");
        String model = input.next();
        System.out.println("enter vehicle type:");
        String vehicleType = input.next();
        System.out.println("enter color:");
        String color = input.next();
        System.out.println("enter odometer:");
        int odometer = Integer.parseInt(input.next());
        System.out.println("enter price:");
        Double price = Double.valueOf(input.next());

        Vehicle vehicle = new Vehicle(vin,year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);
    }

    public static void processRemoveVehicleRequest(){
        System.out.println("enter the vin of the vehicle you want to remove: ");
        int vin = Integer.parseInt(input.next());

        for (Vehicle x: dealership.getAllVehicle()){
            if (x.getVin()==vin){
                dealership.removeVehicle(x);
                System.out.println("vehicle is removed " + x.toString());
            }
        }
        updateDealership();
    }

    public static void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1) Find Vehicle within a price range");
            System.out.println("2) Find Vehicle by make or model");
            System.out.println("3) Find vehicle by year range");
            System.out.println("4) Find vehicle by color");
            System.out.println("5) Find vehicle by mileage range");
            System.out.println("6) Find vehicle by vehicle type (car,truck,suv,van)");
            System.out.println("7) List all vehicles");
            System.out.println("8) Add a vehicle");
            System.out.println("9) Remove a vehicle");
            System.out.println("99) Quit");


            System.out.print("Your Selection \uD83D\uDC49\uD83C\uDFFD");
            String input = scanner.next().trim();

            switch (input) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehicleRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;

                case "99":

                    running=false;
                    break;
            }
        }
    }


    private static void displayHelper(ArrayList listToBeDisplayed){
        for (Object vehicle: listToBeDisplayed){
            System.out.println(vehicle);
        }
    }

}
