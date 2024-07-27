package cdp2;
interface Transportmode {
    void delivery();
}

// Concrete Products
class Truck implements Transportmode {
    public void delivery() {
        System.out.println("Delivered by Truck...");
    }
}

class Ship implements Transportmode {
    public void delivery() {
        System.out.println("Delivered by Ship...");
    }
}

// Factory
class Productdelivery {
    public static Transportmode selectmode(String type) {
        if (type.equalsIgnoreCase("Truck")) {
            return new Truck();
        } else if (type.equalsIgnoreCase("Ship")) {
            return new Ship();
        }
        throw new IllegalArgumentException("Unknown vehicle type");
    }

}

public class Main {
    public static void main(String[] args) {
        Transportmode Truck = Productdelivery.selectmode("Truck");
        Truck.delivery();

        Transportmode Ship = Productdelivery.selectmode("Ship");
        Ship.delivery();
    }
}
