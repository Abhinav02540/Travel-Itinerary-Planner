import java.util.*;

public class TravelItineraryPlanner {

    static class Destination {
        String name;
        String date;
        String preference;
        double estimatedCost;

        public Destination(String name, String date, String preference, double estimatedCost) {
            this.name = name;
            this.date = date;
            this.preference = preference;
            this.estimatedCost = estimatedCost;
        }

        @Override
        public String toString() {
            return "📍 Destination: " + name + "\n" +
                   "📅 Travel Date: " + date + "\n" +
                   "🎯 Preference: " + preference + "\n" +
                   "💰 Estimated Cost: $" + estimatedCost + "\n";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Destination> itinerary = new ArrayList<>();
        double totalBudget;

        System.out.println("🌍 Welcome to the Travel Itinerary Planner!");
        System.out.println("Plan your perfect trip with ease!\n");

        System.out.print("💵 Enter your total budget in USD: ");
        totalBudget = getPositiveNumber(scanner);

        System.out.println("\nLet’s start planning your trip!");

        while (true) {
            System.out.println("\n--- ✈️ Add a New Destination ---");

            System.out.print("🌆 What is the name of the destination? ");
            String destination = scanner.nextLine();

            System.out.print("📅 When do you plan to visit? (e.g., YYYY-MM-DD): ");
            String date = scanner.nextLine();

            System.out.print("🎯 What is your preference for this destination? (e.g., Adventure, Relaxation, Cultural): ");
            String preference = scanner.nextLine();

            System.out.print("💰 What is the estimated cost for this destination? ");
            double cost = getPositiveNumber(scanner);

            itinerary.add(new Destination(destination, date, preference, cost));

            System.out.print("➕ Do you want to add another destination? (yes/no): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("\n--- 🗺️ Your Travel Itinerary ---");
        double totalCost = 0;

        for (Destination dest : itinerary) {
            System.out.println(dest);
            totalCost += dest.estimatedCost;
        }

        System.out.println("💸 Total Estimated Cost: $" + totalCost);

        if (totalCost > totalBudget) {
            System.out.println("⚠️ Warning: Your itinerary exceeds your budget by $" + (totalCost - totalBudget) + "!");
        } else {
            System.out.println("🎉 Great! You are within your budget. Remaining budget: $" + (totalBudget - totalCost));
        }

        System.out.println("\n✅ Thank you for using the Travel Itinerary Planner! Safe travels! 🚀");
        scanner.close();
    }

    private static double getPositiveNumber(Scanner scanner) {
        double number;
        while (true) {
            try {
                number = Double.parseDouble(scanner.nextLine());
                if (number > 0) {
                    return number;
                } else {
                    System.out.print("🚫 Please enter a positive number: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("🚫 Invalid input. Please enter a number: ");
            }
        }
    }
}
