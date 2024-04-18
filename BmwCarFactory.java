public class BmwCarFactory extends CarFactory {
    public Car createCar(String model, String color) {
        return new BmwCar(model, color);
    }
}