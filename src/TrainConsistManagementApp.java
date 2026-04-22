import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrainConsistManagementApp {
    private record Bogie(String name, String type, int capacity) {
        @Override
        public String toString() {
            return name + "(" + type + ", capacity=" + capacity + ")";
        }
    }

    public static void main(String[] args) {
        List<String> bogies = new ArrayList<>();

        System.out.println("=== Train Consist Management App ===");
        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + bogies.size());
        addPassengerBogies(bogies);
        trackUniqueBogieIds();
        manageOrderedConsist();
        preserveFormationOrder();
        mapBogieCapacities();
        sortBogiesByCapacity();
        filterPassengerBogies();
        System.out.println("Program continues.");
    }

    private static List<Bogie> createPassengerBogies() {
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", "Passenger", 72));
        passengerBogies.add(new Bogie("AC Chair", "Passenger", 78));
        passengerBogies.add(new Bogie("First Class", "Passenger", 24));
        return passengerBogies;
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

    private static void manageOrderedConsist() {
        LinkedList<String> consist = new LinkedList<>();

        consist.addFirst("Engine");
        consist.addLast("Sleeper");
        consist.addLast("AC");
        consist.addLast("Cargo");
        consist.addLast("Guard");

        System.out.println("Linked consist before changes: " + consist);

        consist.add(2, "Pantry Car");
        consist.removeFirst();
        consist.removeLast();

        System.out.println("Final ordered train consist: " + consist);
    }

    private static void preserveFormationOrder() {
        Set<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println("LinkedHashSet formation order: " + formation);
    }

    private static void mapBogieCapacities() {
        Map<String, Integer> bogieCapacities = new HashMap<>();

        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 78);
        bogieCapacities.put("First Class", 24);

        System.out.println("Bogie capacity details:");
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println(entry.getKey() + " capacity: " + entry.getValue());
        }
    }

    private static void sortBogiesByCapacity() {
        List<Bogie> passengerBogies = createPassengerBogies();

        passengerBogies.sort(Comparator.comparingInt(Bogie::capacity));

        System.out.println("Bogies sorted by capacity: " + passengerBogies);
    }

    private static void filterPassengerBogies() {
        List<Bogie> highCapacityBogies = createPassengerBogies().stream()
                .filter(bogie -> bogie.capacity() > 60)
                .toList();

        System.out.println("Passenger bogies with capacity above 60: " + highCapacityBogies);
    }
}
