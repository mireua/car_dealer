public class BmwCar extends Car {
    public BmwCar(String model, String color) {
        super(model, color);
    }

    public void displayInfo() {
        System.out.println("BMW Car - Model: " + model + ", Color: " + color);
    }
}
