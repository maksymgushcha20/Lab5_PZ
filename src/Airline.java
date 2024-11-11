import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Клас Airline представляє авіакомпанію, що містить список літаків та дозволяє виконувати різні операції.
 */
class Airline {
    private List<Aircraft> fleet; // Флот авіакомпанії

    /**
     * Конструктор створює об'єкт Airline з порожнім списком літаків.
     */
    public Airline() {
        fleet = new ArrayList<>();
    }

    /**
     * Додає літак до флоту авіакомпанії.
     */
    public void addAircraft(Aircraft aircraft) {
        fleet.add(aircraft);
    }

    /**
     * Обчислює загальну місткість пасажирів флоту.
     * @return Загальна кількість пасажирів.
     */
    public int getTotalCapacity() {
        return fleet.stream().mapToInt(Aircraft::getCapacity).sum();
    }

    /**
     * Обчислює загальну вантажопідйомність флоту.
     * @return Загальна вантажопідйомність у тоннах.
     */
    public double getTotalCargoCapacity() {
        return fleet.stream().mapToDouble(Aircraft::getCargoCapacity).sum();
    }

    /**
     * Сортує літаки за дальністю польоту в порядку зростання.
     */
    public void sortAircraftByRange() {
        fleet.sort(Comparator.comparingDouble(Aircraft::getRange));
    }

    /**
     * Знаходить літаки, що відповідають заданому діапазону споживання пального.
     * @param minFuel Мінімальне споживання пального на 100 км.
     * @param maxFuel Максимальне споживання пального на 100 км.
     * @return Список літаків, що відповідають критерію.
     */
    public List<Aircraft> findAircraftByFuelConsumption(double minFuel, double maxFuel) {
        List<Aircraft> result = new ArrayList<>();
        for (Aircraft aircraft : fleet) {
            double fuelConsumption = aircraft.getFuelConsumption();
            if (fuelConsumption >= minFuel && fuelConsumption <= maxFuel) {
                result.add(aircraft);
            }
        }
        return result;
    }

    /**
     * Повертає інформацію про всі літаки у флоті.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Aircraft aircraft : fleet) {
            sb.append(aircraft).append("\n");
        }
        return sb.toString();
    }
}
