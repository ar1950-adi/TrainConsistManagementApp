import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        List<String> bogies = new ArrayList<>();

        System.out.println("=== Train Consist Management App ===");
        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + bogies.size());
        addPassengerBogies(bogies);
        System.out.println("Program continues.");
    }

    private static void addPassengerBogies(List<String> bogies) {
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        System.out.println("Passenger bogies after insertion: " + bogies);

        bogies.remove("AC Chair");

        System.out.println("Sleeper exists: " + bogies.contains("Sleeper"));
        System.out.println("Final passenger bogies: " + bogies);
    }
}
