/**
 * Базовий клас Aircraft представляє загальні характеристики літаків.
 */
abstract class Aircraft {
    private String model;
    private int capacity; // Кількість пасажирів
    private double cargoCapacity; // Вантажопідйомність у тоннах
    private double range; // Дальність польоту в км
    private double fuelConsumption; // Споживання пального на 100 км

    /**
     * Конструктор класу Aircraft.
     */
    public Aircraft(String model, int capacity, double cargoCapacity, double range, double fuelConsumption) {
        this.model = model;
        this.capacity = capacity;
        this.cargoCapacity = cargoCapacity;
        this.range = range;
        this.fuelConsumption = fuelConsumption;
    }

    // Геттери
    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public double getRange() {
        return range;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Повертає рядкове представлення об'єкта.
     */
    @Override
    public String toString() {
        return model + " (Capacity: " + capacity + ", Cargo: " + cargoCapacity + "t, Range: " + range + "km, Fuel: " + fuelConsumption + "L/100km)";
    }
}

/**
 * Клас PassengerAircraft представляє пасажирський літак.
 */
class PassengerAircraft extends Aircraft {
    public PassengerAircraft(String model, int capacity, double cargoCapacity, double range, double fuelConsumption) {
        super(model, capacity, cargoCapacity, range, fuelConsumption);
    }
}

/**
 * Клас CargoAircraft представляє вантажний літак.
 */
class CargoAircraft extends Aircraft {
    public CargoAircraft(String model, double cargoCapacity, double range, double fuelConsumption) {
        super(model, 0, cargoCapacity, range, fuelConsumption); // Capacity = 0 для вантажних літаків
    }
}

/**
 * Клас MilitaryAircraft представляє військовий літак.
 */
class MilitaryAircraft extends Aircraft {
    public MilitaryAircraft(String model, int capacity, double cargoCapacity, double range, double fuelConsumption) {
        super(model, capacity, cargoCapacity, range, fuelConsumption);
    }
}
