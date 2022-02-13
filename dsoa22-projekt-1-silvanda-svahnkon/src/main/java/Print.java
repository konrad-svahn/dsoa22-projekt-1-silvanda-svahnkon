import java.util.LinkedHashMap;

public class Print {
    // print ineholer alla metoder som gör utskrifter


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

}
