import java.util.ArrayList;
import java.util.List;

public class DealershipDatabase {
    private static DealershipDatabase instance;
    private List<Car> cars;

    private DealershipDatabase() {
        cars = new ArrayList<>();
    }

    public static DealershipDatabase getInstance() {
        if (instance == null) {
            instance = new DealershipDatabase();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}