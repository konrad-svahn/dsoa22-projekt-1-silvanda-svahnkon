import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Print {
    // print innehåller alla metoder som gör utskrifter

    public static void listNodesAndLinks (LinkedHashMap<String,Node> nodes) {
        System.out.println("Listan över bibloteken och deras grannar:");
        nodes.forEach ((key,V) -> {
            System.out.println();
            System.out.print(nodes.get(key).getName() + "   ["+key +"] -> ");

            for (Node neighbour : nodes.get(key).getNeighbours()) {
                System.out.print("["+neighbour.getKey()+"] ");
            }
            System.out.println();
        });
    }

    //skriver ut promts för user input och kallar på funktionerna so utför behandling av inputs
    public static String[] userInput (LinkedHashMap<String,Node> nodes) {
        String[] inputs = new String[2];
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("\nSkriv in start och destination: ");

            System.out.println("Start: ");
            inputs[0] = Utils.testUserInput(scan, nodes);

            System.out.println("Destination: ");
            inputs[1] = Utils.testUserInput(scan, nodes);

            System.out.println();

            return inputs;
        }
    }

    public static void path (ArrayList<Node> route) {
        for (Node node : route) {
			System.out.println( node.getName());
		}
    }

    public static void warning() {
        System.out.println("var vändlig och skriv in en key som fins på listan åvan");
    }
}
