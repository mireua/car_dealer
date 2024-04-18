public class JdmCarFactory extends CarFactory {
    public Car createCar(String model, String color) {
        return new JdmCar(model, color);
    }
}