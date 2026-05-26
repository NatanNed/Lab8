package org.example.practice8;

import java.util.Objects;

/**
 * Клас GamingPhone розширює Smartphone.
 * Додає частоту оновлення екрана та наявність ігрового охолодження.
 */
public class GamingPhone extends Smartphone {

    private int refreshRateHz;
    private boolean coolingSystem;

    public GamingPhone(String brand,
                       String model,
                       double price,
                       int memoryGb,
                       boolean has5G,
                       String operatingSystem,
                       int cameraMp,
                       int refreshRateHz,
                       boolean coolingSystem) {

        super(brand, model, price, memoryGb, has5G, operatingSystem, cameraMp);
        this.refreshRateHz = refreshRateHz;
        this.coolingSystem = coolingSystem;
    }

    public int getRefreshRateHz() {
        return refreshRateHz;
    }

    public void setRefreshRateHz(int refreshRateHz) {
        this.refreshRateHz = refreshRateHz;
    }

    public boolean isCoolingSystem() {
        return coolingSystem;
    }

    public void setCoolingSystem(boolean coolingSystem) {
        this.coolingSystem = coolingSystem;
    }

    @Override
    public String getDeviceType() {
        return "Ігровий смартфон";
    }

    public boolean isSuitableForGaming() {
        return refreshRateHz >= 120 && coolingSystem;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", refreshRateHz=" + refreshRateHz +
                ", coolingSystem=" + coolingSystem +
                ", suitableForGaming=" + isSuitableForGaming() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        GamingPhone that = (GamingPhone) obj;

        return refreshRateHz == that.refreshRateHz
                && coolingSystem == that.coolingSystem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), refreshRateHz, coolingSystem);
    }
}
