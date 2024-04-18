public class CarShowroom implements CarObserver {
    public void update(Car car) {
        System.out.println("New Car Available: " + car.getModel() + " in " + car.getColor());
    }
}   