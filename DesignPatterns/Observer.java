
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

        weatherStation.addObserver(temperatureDisplay);
        weatherStation.addObserver(fan);

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

