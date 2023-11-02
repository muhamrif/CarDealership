package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private static Dealership dealership;

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
    public void display(){
        init();
        displayMenu();
    }

    public static void processGetByPriceRequest(){

    }

    public static void processGetByMakeModelRequest(){

    }

    public static void processGetByYearRequest(){

    }

    public static void processGetByColorRequest(){

    }

    public static void processGetByMileageRequest(){

    }

    public static void processGetByVehicleTypeRequest(){

    }

    public static void processGetAllVehicleRequest(){
    displayHelper(dealership.getAllVehicle());
    }

    public static void processAddVehicleRequest(){

    }

    public static void processRemoveVehicleRequest(){

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
            System.out.println(vehicle.toString());
        }
    }

}
