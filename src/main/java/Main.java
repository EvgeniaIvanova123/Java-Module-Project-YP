import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <= 2; i++) {
            System.out.println("Введите название автомобиля");
            String carName = scanner.nextLine();
            while
            (carName.isBlank() || !carName.matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("Название автомобиля некорректно, задайте название заново");
                carName = scanner.nextLine();
            }

            System.out.println("Введите скорость автомобиля " + carName);
            String speedInput = scanner.nextLine();

            while (!speedInput.matches("[0-9]+")) {
                System.out.println("Ошибка: введите целое число");
                speedInput = scanner.nextLine();
            }
            int speedCar = Integer.parseInt(speedInput);

            while (speedCar < 0 || speedCar > 250) {
                System.out.println("Значение скорости " + speedCar + " некорректно. Введите целое число от 0 до 250");
                speedCar = scanner.nextInt();
            }
            Car car = new Car(carName, speedCar);
            race.addCar(car);
        }
        Car leader = race.whoLider();
        System.out.println("Самая быстрая машина: " + leader.carName);

    }
}

class Race {
    ArrayList<Car> cars = new ArrayList<>();

    void addCar(Car car) {
        cars.add(car);
    }

    Car whoLider() {
        if (cars.isEmpty()) {
            return null;
        }

        Car leader = cars.get(0);
        int maxDistance = leader.speed * 24;

        for (Car car : cars) {
            int distance = car.speed * 24;
            if (distance > maxDistance) {
                maxDistance = distance;
                leader = car;
            }
        }

        return leader;
    }
}

class Car {
    String carName;
    int speed;

    Car(String carName, int speed) {
        this.carName = carName;
        this.speed = speed;

    }
}