package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;
//__________________________________________
    public Dealership(String name, String address, String phone) {
        this.inventory = new ArrayList<Vehicle>();
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
//__________________________________________

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }
//_______________
    public ArrayList<Vehicle> getVehicleByPrice(double min,double max){
        ArrayList<Vehicle> filteredArray = new ArrayList<>();

        for(Vehicle x:inventory){
            if (x.getPrice()>=min && x.getPrice()<=max){
                filteredArray.add(x);
            }
        }
        return filteredArray;
    }
    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model){
        ArrayList<Vehicle> filteredArray = new ArrayList<>();

        for(Vehicle x:inventory){
            if (x.getMake().equalsIgnoreCase(make) || x.getModel().equalsIgnoreCase(model)){
                filteredArray.add(x);
            }
        }
        return filteredArray;
    }
    public ArrayList<Vehicle> getVehicleByYear(int min,int max){
        ArrayList<Vehicle> filteredArray = new ArrayList<>();

        for(Vehicle x:inventory){
            if (x.getPrice()>=min && x.getPrice()<=max){
                filteredArray.add(x);
            }
        }
        return filteredArray;
    }
    public ArrayList<Vehicle> getVehicleByColor(String color){
        ArrayList<Vehicle> filteredArray = new ArrayList<>();

        for(Vehicle x:inventory){
            if (x.getMake().equalsIgnoreCase(color) ){
                filteredArray.add(x);
            }
        }
        return filteredArray;
    }
    public ArrayList<Vehicle> getVehicleByMileage(int min, int max){
        ArrayList<Vehicle> filteredArray = new ArrayList<>();

        for(Vehicle x:inventory){
            if (x.getPrice()>=min && x.getPrice()<=max){
                filteredArray.add(x);
            }
        }
        return filteredArray;
    }

    public ArrayList<Vehicle> getVehicleByType(String type){
        ArrayList<Vehicle> filteredArray = new ArrayList<>();

        for(Vehicle x:inventory){
            if (x.getMake().equalsIgnoreCase(type) ){
                filteredArray.add(x);
            }
        }
        return filteredArray;
    }
    public ArrayList<Vehicle> getAllVehicle(){
        return inventory;
    }
    public void addVehicle(Vehicle vehicle){
    this.inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
    this.inventory.remove(vehicle);
    }
}
