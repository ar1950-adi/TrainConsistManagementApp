import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {
    private record Bogie(String name, String type, int capacity) {
        @Override
        public String toString() {
            return name + "(" + type + ", capacity=" + capacity + ")";
        }
    }

    private record GoodsBogie(String shape, String cargo) {
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
        groupBogiesByType();
        countTotalSeats();
        validateTrainAndCargoCodes();
        checkGoodsBogieSafetyCompliance();
        compareLoopAndStreamPerformance();
        System.out.println("Program continues.");
    }

    private static List<Bogie> createPassengerBogies() {
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", "Passenger", 72));
        passengerBogies.add(new Bogie("AC Chair", "Passenger", 78));
        passengerBogies.add(new Bogie("First Class", "Passenger", 24));
        return passengerBogies;
    }

    private static List<Bogie> createOperationalBogies() {
        List<Bogie> operationalBogies = new ArrayList<>(createPassengerBogies());
        operationalBogies.add(new Bogie("Cargo", "Goods", 40));
        operationalBogies.add(new Bogie("Petroleum Tanker", "Goods", 55));
        operationalBogies.add(new Bogie("Guard", "Crew", 2));
        return operationalBogies;
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

    private static void groupBogiesByType() {
        Map<String, List<Bogie>> groupedBogies = createOperationalBogies().stream()
                .collect(Collectors.groupingBy(Bogie::type));

        System.out.println("Bogies grouped by type: " + groupedBogies);
    }

    private static void countTotalSeats() {
        int totalSeats = createPassengerBogies().stream()
                .map(Bogie::capacity)
                .reduce(0, Integer::sum);

        System.out.println("Total passenger seating capacity: " + totalSeats);
    }

    private static void validateTrainAndCargoCodes() {
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        System.out.println("Train ID " + trainId + " valid: " + trainMatcher.matches());
        System.out.println("Cargo code " + cargoCode + " valid: " + cargoMatcher.matches());
    }

    private static void checkGoodsBogieSafetyCompliance() {
        List<GoodsBogie> goodsBogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Rectangular", "Machinery")
        );

        boolean safetyCompliant = goodsBogies.stream()
                .allMatch(bogie -> !"Cylindrical".equals(bogie.shape())
                        || "Petroleum".equals(bogie.cargo()));

        System.out.println("Goods bogie safety compliant: " + safetyCompliant);
    }

    private static void compareLoopAndStreamPerformance() {
        List<Bogie> testBogies = createOperationalBogies();
        List<Bogie> loopFiltered = new ArrayList<>();

        long loopStart = System.nanoTime();
        for (Bogie bogie : testBogies) {
            if (bogie.capacity() > 40) {
                loopFiltered.add(bogie);
            }
        }
        long loopEnd = System.nanoTime();

        long streamStart = System.nanoTime();
        List<Bogie> streamFiltered = testBogies.stream()
                .filter(bogie -> bogie.capacity() > 40)
                .toList();
        long streamEnd = System.nanoTime();

        System.out.println("Loop filtering result: " + loopFiltered);
        System.out.println("Loop filtering time ns: " + (loopEnd - loopStart));
        System.out.println("Stream filtering result: " + streamFiltered);
        System.out.println("Stream filtering time ns: " + (streamEnd - streamStart));
    }
}
