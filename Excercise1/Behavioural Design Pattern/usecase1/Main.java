package bdp1;
//OBSERVER DESIGN PATTERN
import java.util.ArrayList;
import java.util.List;

// Subject
class WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }
}

// Observer
interface WeatherObserver {
    void update(int temperature);
}

// Concrete Observer
class Display implements WeatherObserver {
    private String name;

    public Display(String name) {
        this.name = name;
    }

    public void update(int temperature) {
        System.out.println(name + " Temperature updated: Current Temperature is " + temperature + "°C");
    }
}

// Main
public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Display observer1 = new Display("observer1");
        Display observer2 = new Display("observer2");

        station.addObserver(observer1);
        station.addObserver(observer2);

        station.setTemperature(25);
        station.setTemperature(30);
    }
}
