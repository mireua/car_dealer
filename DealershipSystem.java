import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DealershipSystem {
    private static DealershipDatabase database = DealershipDatabase.getInstance();
    private static CarFactory jdmFactory = new JdmCarFactory();
    private static CarFactory bmwFactory = new BmwCarFactory();
    private static CarShowroom showroom = new CarShowroom();
    private static SalesManager salesManager = new SalesManager();

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }

        JFrame frame = new JFrame("Car Dealership System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JLabel titleLabel = new JLabel("Welcome to the 'Only Cars That Matter' Dealership", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton btnAddCar = new JButton("Add Car");
        JButton btnListCars = new JButton("List All Cars");
        JButton btnAddSportPackage = new JButton("Add Sports Package");
        JButton btnAddLuxuryPackage = new JButton("Add Luxury Package");
        JButton btnDeleteLastCar = new JButton("Delete Last Car");

        String[] jdmOptions = {"Supra", "Civic", "GTR"}; // JDM car options
        String[] bmwOptions = {"M3", "M4", "M5 CS"}; // BMW car options

        btnAddCar.addActionListener(e -> {
            String[] carOptions = {"JDM", "BMW"};
            String selectedCarType = (String) JOptionPane.showInputDialog(frame,
                    "Select car type:",
                    "Car Type Selection",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    carOptions,
                    carOptions[0]);
            if (selectedCarType != null) {
                String[] models = (selectedCarType.equals("JDM")) ? jdmOptions : bmwOptions;
                String selectedModel = (String) JOptionPane.showInputDialog(frame,
                        "Select car model:",
                        "Car Model Selection",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        models,
                        models[0]);
                if (selectedModel != null) {
                    String[] colors = {"Red", "Blue", "Black", "White"}; // Add more colors if needed
                    String selectedColor = (String) JOptionPane.showInputDialog(frame,
                            "Select car color:",
                            "Car Color Selection",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            colors,
                            colors[0]);
                    if (selectedColor != null) {
                        Car car = (selectedCarType.equals("JDM")) ? jdmFactory.createCar(selectedModel, selectedColor) : bmwFactory.createCar(selectedModel, selectedColor);
                        database.addCar(car);
                        showroom.update(car);
                        salesManager.update(car);
                        JOptionPane.showMessageDialog(frame, "Added " + selectedCarType + " Car: " + car.getModel() + " in " + car.getColor());
                    }
                }
            }
        });

        btnListCars.addActionListener(e -> {
            List<Car> cars = database.getCars();
            StringBuilder carList = new StringBuilder("Available Cars:\n");
            cars.forEach(car -> carList.append(car.getModel()).append(" in ").append(car.getColor()).append("\n"));
            JOptionPane.showMessageDialog(frame, carList.toString());
        });

        btnAddSportPackage.addActionListener(e -> {
            List<Car> cars = database.getCars();
            if (!cars.isEmpty()) {
                Car car = new SportsPackage(cars.get(cars.size() - 1));
                database.addCar(car);
                showroom.update(car);
                salesManager.update(car);
                JOptionPane.showMessageDialog(frame, "Added Sports Package to " + car.getModel());
            }
        });

        btnAddLuxuryPackage.addActionListener(e -> {
            List<Car> cars = database.getCars();
            if (!cars.isEmpty()) {
                Car car = new LuxuryPackage(cars.get(cars.size() - 1));
                database.addCar(car);
                showroom.update(car);
                salesManager.update(car);
                JOptionPane.showMessageDialog(frame, "Added Luxury Package to " + car.getModel());
            }
        });

        btnDeleteLastCar.addActionListener(e -> {
            if (!database.getCars().isEmpty()) {
                Car car = database.getCars().remove(database.getCars().size() - 1);
                JOptionPane.showMessageDialog(frame, "Deleted " + car.getModel() + " from the database.");
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(3, 2));
        buttonPanel.add(btnAddCar);
        buttonPanel.add(btnListCars);
        buttonPanel.add(btnAddSportPackage);
        buttonPanel.add(btnAddLuxuryPackage);
        buttonPanel.add(btnDeleteLastCar);

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.add(titleLabel, BorderLayout.NORTH);
        titlePanel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(titlePanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
