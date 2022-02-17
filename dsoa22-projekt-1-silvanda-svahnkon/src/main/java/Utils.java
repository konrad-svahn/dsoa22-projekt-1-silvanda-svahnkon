import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Utils {

    /**
     * Metod för att beräkna distansen mellan två geografiska koordinater
     */
    public static double getDistance( double lat1, double lon1, double lat2, double lon2) {

        // Konvertera grader till radians
        lat1 = lat1 * Math.PI / 180.0;
        lon1 = lon1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        lon2 = lon2 * Math.PI / 180.0;

        // Räkna ut distansen med haversinformeln
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1)
                * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);
        double c = 2 * Math.asin(Math.sqrt(a));

        // Jordens radie i km
        double r = 6371;
        // returnera resultatet i km
        return(c * r);

    }

    public static ArrayList<Node> getRoute (Node startNode, Node endNode) {
        Node current = startNode;
        boolean done = false;   
        boolean inVisited;
        boolean inCand;
        ArrayList<Node> finalRute = new ArrayList<Node>();
        ArrayList<Node> cand = new ArrayList<Node>();
        ArrayList<Node> visited = new ArrayList<Node>();
        ArrayList<Node> rute = new ArrayList<Node>();

       
        mainLoop: while (done == false) {
            Node smallest = null;
            double minF = 0;
            
            for (int i = 0; i < current.getNeighbours().size(); i++) {

                inVisited = false;
                for (int j = 0; j < visited.size(); j++) {
                    if (current.getNeighbours().get(i) == visited.get(j)) {
                        inVisited = true;    
                    }
                }

                inCand = false;
                for (int k = 0; k < cand.size(); k++) {
                    if (current.getNeighbours().get(i) == cand.get(k)) {
                        inCand = true;  
                    }
                }

                if (inVisited == false && inCand == false) {
                    cand.add(current.getNeighbours().get(i));
                    current.getNeighbours().get(i).setPrevious(current);
                }
                
            }

            for (int i = 0; i < cand.size(); i++) {
                if (cand.get(i) == endNode) {
                    endNode.setPrevious(current);
                    done = true;
                    break mainLoop;
                } else {
                    double f = cand.get(i).getF(cand.get(i).calculateG(startNode), cand.get(i).calculateH(endNode)); 
                    if (minF == 0 || minF > f) {
                        minF = f;
                        smallest = cand.get(i);
                    }
                    for (int j = 0; j < current.getNeighbours().size(); j++) {
                        if (current.getNeighbours().get(j) == smallest) {
                            smallest.setPrevious(current);
                        }  
                    }
                }
            }
            visited.add(current);
            cand.remove(current);
            current = smallest;
        }
        current = endNode;

        while (current != startNode) {
            rute.add(current);
            current = current.getPrevious();
        }
        rute.add(startNode);
        
        for (int i = rute.size() -1; i >= 0 ; i--) {
            finalRute.add(rute.get(i));
        }

        return finalRute;
    }

    public static String testUserInput (Scanner scanAction, LinkedHashMap<String,Node> nodes) {  
        boolean warning = false; 
        while (true){
            if (warning){Print.warning();}
            warning = true;
            if (scanAction.hasNext()){String input = scanAction.nextLine();
                if (isValid(input, nodes)) {
                    return input;
                }
            }
        }
    }

    private static boolean isValid (String input, LinkedHashMap<String,Node> nodes){
        boolean valid = false;
        ArrayList<String> tags = new ArrayList<String>();
        // av någon orsak får jag en: Local variable valid defined in an enclosing scope must be final or effectively final. om jag försöker sätta if satsen inuti nodes.forEach
        // så istälet flytar jag alla keys til en array list och testar sedan den listan
        nodes.forEach ((key,V) -> {
             tags.add(key);
        });  
        for (String tag : tags) {
            if (input.matches(tag)) { valid = true;}
        }
        return valid;
    } 
}
