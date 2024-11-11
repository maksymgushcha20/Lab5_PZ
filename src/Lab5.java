// Lab5
// ІО-23
// Гуща Максим

//ВАРІАНТ\\
// C13 = 2309 / 13 = (8) | Визначити ієрархію літаків. Створити авіакомпанію. Порахувати загальну місткість і вантажопідйомність авіакомпанії. Провести сортування літаків компанії за дальністю польоту. Знайти літак у компанії, що відповідає заданому діапазону споживання пального.

import java.util.List;

public class Lab5 {
    public static void main(String[] args) {
        try {
            Airline airline = new Airline();

            airline.addAircraft(new PassengerAircraft("Boeing 747", 400, 20.0, 10000, 5.5));
            airline.addAircraft(new CargoAircraft("C-130 Hercules", 40.0, 7000, 6.0));
            airline.addAircraft(new MilitaryAircraft("F-16 Fighter", 1, 2.0, 2000, 10.0));
            airline.addAircraft(new PassengerAircraft("Airbus A320", 150, 10.0, 5000, 4.5));

            System.out.println("Флот авіакомпанії:");
            System.out.println(airline);

            System.out.println("Загальна місткість пасажирів: " + airline.getTotalCapacity());
            System.out.println("Загальна вантажопідйомність: " + airline.getTotalCargoCapacity() + " тонн");

            airline.sortAircraftByRange();
            System.out.println("\nФлот після сортування за дальністю польоту:");
            System.out.println(airline);

            double minFuel = 4.0;
            double maxFuel = 6.0;
            System.out.println("\nЛітаки з діапазоном споживання пального від " + minFuel + " до " + maxFuel + " л/100 км:");
            List<Aircraft> fuelEfficientAircrafts = airline.findAircraftByFuelConsumption(minFuel, maxFuel);
            for (Aircraft aircraft : fuelEfficientAircrafts) {
                System.out.println(aircraft);
            }
        } catch (Exception e) {
            System.out.println("Сталася помилка: " + e.getMessage());
        }
    }
}
