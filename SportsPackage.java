public class SportsPackage extends CarDecorator {
    public SportsPackage(Car decoratedCar) {
        super(decoratedCar);
    }

    public void displayInfo() {
        decoratedCar.displayInfo();
        addSportsFeatures();
    }

    private void addSportsFeatures() {
        System.out.println("Added Sports Package: Includes sports suspension and high-performance brakes.");
    }
}
