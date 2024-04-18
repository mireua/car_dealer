public class LuxuryPackage extends CarDecorator {
    public LuxuryPackage(Car decoratedCar) {
        super(decoratedCar);
    }

    public void displayInfo() {
        decoratedCar.displayInfo();
        addLuxuryFeatures();
    }

    private void addLuxuryFeatures() {
        System.out.println("Added Luxury Package: Includes leather seats and premium audio system.");
    }
}
