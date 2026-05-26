package org.example.practice8;

import java.util.Objects;

/**
 * Базовий клас ієрархії.
 * Описує загальні характеристики електронного пристрою.
 */
public class Device {

    private String brand;
    private String model;
    private double price;

    public Device(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeviceType() {
        return "Електронний пристрій";
    }

    @Override
    public String toString() {
        return getDeviceType() +
                " {brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Device device = (Device) obj;

        return Double.compare(device.price, price) == 0
                && Objects.equals(brand, device.brand)
                && Objects.equals(model, device.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, price);
    }
}
