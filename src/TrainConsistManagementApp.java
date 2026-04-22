import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        List<String> bogies = new ArrayList<>();

        System.out.println("=== Train Consist Management App ===");
        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + bogies.size());
        addPassengerBogies(bogies);
        trackUniqueBogieIds();
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

    private static void trackUniqueBogieIds() {
        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("B01");
        bogieIds.add("B02");
        bogieIds.add("B03");
        bogieIds.add("B02");

        System.out.println("Unique bogie IDs: " + bogieIds);
        System.out.println("Unique bogie ID count: " + bogieIds.size());
    }
}
