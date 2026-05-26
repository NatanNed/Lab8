package org.example.practice8;

import java.util.Objects;

/**
 * Клас FoldablePhone розширює Smartphone.
 * Додає кількість згинань та розмір розкритого екрана.
 */
public class FoldablePhone extends Smartphone {

    private int foldingCycles;
    private double unfoldedScreenSize;

    public FoldablePhone(String brand,
                         String model,
                         double price,
                         int memoryGb,
                         boolean has5G,
                         String operatingSystem,
                         int cameraMp,
                         int foldingCycles,
                         double unfoldedScreenSize) {

        super(brand, model, price, memoryGb, has5G, operatingSystem, cameraMp);
        this.foldingCycles = foldingCycles;
        this.unfoldedScreenSize = unfoldedScreenSize;
    }

    public int getFoldingCycles() {
        return foldingCycles;
    }

    public void setFoldingCycles(int foldingCycles) {
        this.foldingCycles = foldingCycles;
    }

    public double getUnfoldedScreenSize() {
        return unfoldedScreenSize;
    }

    public void setUnfoldedScreenSize(double unfoldedScreenSize) {
        this.unfoldedScreenSize = unfoldedScreenSize;
    }

    @Override
    public String getDeviceType() {
        return "Складаний смартфон";
    }

    public boolean isDurable() {
        return foldingCycles >= 200000;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", foldingCycles=" + foldingCycles +
                ", unfoldedScreenSize=" + unfoldedScreenSize +
                ", durable=" + isDurable() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        FoldablePhone that = (FoldablePhone) obj;

        return foldingCycles == that.foldingCycles
                && Double.compare(that.unfoldedScreenSize, unfoldedScreenSize) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), foldingCycles, unfoldedScreenSize);
    }
}
