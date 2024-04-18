public abstract class CarDecorator extends Car {
    protected Car decoratedCar;

    public CarDecorator(Car decoratedCar) {
        super(decoratedCar.model, decoratedCar.color);
        this.decoratedCar = decoratedCar;
    }

    public void displayInfo() {
        decoratedCar.displayInfo();
    }
}