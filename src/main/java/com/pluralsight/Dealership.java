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
    public List<Vehicle> getVehicleByPrice(double min,double max){
        return null;
    }
    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        return null;
    }
    public List<Vehicle> getVehicleByYear(int min,int max){
        return null;
    }
    public List<Vehicle> getVehicleByColor(String color){
        return null;
    }
    public List<Vehicle> getVehicleByMileage(int min, int max){
        return null;
    }

    public List<Vehicle> getVehicleByType(String type){
        return null;
    }
    public List<Vehicle> getAllVehicle(){
        return inventory;
    }
    public void addVehicle(Vehicle vehicle){
    this.inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){

    }
}
