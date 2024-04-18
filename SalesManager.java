public class SalesManager implements CarObserver {
    public void update(Car car) {
        System.out.println("Sales Alert: We have a new " + car.getModel() + " in " + car.getColor());
    }
}