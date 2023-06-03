

import java.util.ArrayList;
import java.util.List;

// Subject (Observable)
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class WeatherStation implements Subject {
    private double temperature;
    private List<Observer> observers;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
// Observer
interface WeatherObserver {
    void update(int temperature);
}

// Concrete Observer
class TemperatureDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Temperature Display: " + temperature + " degrees Celsius");
    }
}

// Concrete Observer
class Fan implements WeatherObserver {
    @Override
    public void update(int temperature) {
        if (temperature > 25) {
            System.out.println("Fan: Turning on");
        } else {
            System.out.println("Fan: Turning off");
        }
    }
}

// Usage example
public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        TemperatureDisplay temperatureDisplay = new TemperatureDisplay();
        Fan fan = new Fan();

        weatherStation.registerObserver(temperatureDisplay);
        weatherStation.registerObserver(fan);

        // Simulate temperature change
        weatherStation.setTemperature(30);

        // Output:
        // Temperature Display: 30 degrees Celsius
        // Fan: Turning on

        // Simulate temperature change
        weatherStation.setTemperature(20);

        // Output:
        // Temperature Display: 20 degrees Celsius
        // Fan: Turning off
    }
}

