public class JdmCar extends Car {
    public JdmCar(String model, String color) {
        super(model, color);
    }

    public void displayInfo() {
        System.out.println("JDM Car - Model: " + model + ", Color: " + color);
    }
}
