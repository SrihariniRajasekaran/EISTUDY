package sdp1;
//ADAPTER DESIGN PATTERN
interface FahrenheitSensor {
    double getfahrenheit();
}

class TemperatureF implements FahrenheitSensor {
    public double getfahrenheit() {
        return 90.0;
    }
}

interface NewTemperatureSensor {
    double getcelcius();
}

class TemperatureSensorAdapter implements NewTemperatureSensor {
    private FahrenheitSensor oldSensor;

    public TemperatureSensorAdapter(FahrenheitSensor oldSensor) {
        this.oldSensor = oldSensor;
    }

    public double getcelcius() {
        return (oldSensor.getfahrenheit() - 32) * 5.0 / 9.0;
    }
}

public class Main {
    public static void main(String[] args) {
        FahrenheitSensor oldSensor = new TemperatureF();
        NewTemperatureSensor newSensor = new TemperatureSensorAdapter(oldSensor);

        System.out.println("Temperature in Celsius: " + newSensor.getcelcius());
    }
}

