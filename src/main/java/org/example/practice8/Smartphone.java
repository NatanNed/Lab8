package org.example.practice8;

import java.util.Objects;

/**
 * Клас Smartphone розширює Phone.
 * Додає операційну систему та роздільну здатність камери.
 */
public class Smartphone extends Phone {

    private String operatingSystem;
    private int cameraMp;

    public Smartphone(String brand,
                      String model,
                      double price,
                      int memoryGb,
                      boolean has5G,
                      String operatingSystem,
                      int cameraMp) {

        super(brand, model, price, memoryGb, has5G);
        this.operatingSystem = operatingSystem;
        this.cameraMp = cameraMp;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getCameraMp() {
        return cameraMp;
    }

    public void setCameraMp(int cameraMp) {
        this.cameraMp = cameraMp;
    }

    @Override
    public String getDeviceType() {
        return "Смартфон";
    }

    public boolean isGoodForPhotos() {
        return cameraMp >= 48;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", cameraMp=" + cameraMp +
                ", goodForPhotos=" + isGoodForPhotos() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        Smartphone that = (Smartphone) obj;

        return cameraMp == that.cameraMp
                && Objects.equals(operatingSystem, that.operatingSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), operatingSystem, cameraMp);
    }
}
