import java.util.LinkedHashMap;
import java.util.Scanner;

import javax.rmi.CORBA.Util;
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
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("\nSkriv in start och destination: ");
            System.out.println("Start: ");
            String start = scan.nextLine();
            System.out.println("Destination: ");
            String end = scan.nextLine();
            Utils.getRoute(nodes.get(start), nodes.get(end));
        }
        

    }
    

}
