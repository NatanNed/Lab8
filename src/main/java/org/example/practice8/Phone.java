package org.example.practice8;

import java.util.Objects;

/**
 * Клас Phone успадковує Device.
 * Описує звичайний мобільний телефон.
 */
public class Phone extends Device {

    private int memoryGb;
    private boolean has5G;

    public Phone(String brand, String model, double price, int memoryGb, boolean has5G) {
        super(brand, model, price);
        this.memoryGb = memoryGb;
        this.has5G = has5G;
    }

    public int getMemoryGb() {
        return memoryGb;
    }

    public void setMemoryGb(int memoryGb) {
        this.memoryGb = memoryGb;
    }

    public boolean isHas5G() {
        return has5G;
    }

    public void setHas5G(boolean has5G) {
        this.has5G = has5G;
    }

    @Override
    public String getDeviceType() {
        return "Телефон";
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", memoryGb=" + memoryGb +
                ", has5G=" + has5G +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        Phone phone = (Phone) obj;

        return memoryGb == phone.memoryGb
                && has5G == phone.has5G;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), memoryGb, has5G);
    }
}
