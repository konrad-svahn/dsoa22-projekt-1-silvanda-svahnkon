import java.util.ArrayList;

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
        ArrayList<Node> cand = new ArrayList<Node>();
        ArrayList<Node> visited = new ArrayList<Node>();
        ArrayList<Node> rute = new ArrayList<Node>();

       
        mainLoop: while (done == false) {
            Node smallest = null;
            double minF = 0;
            System.out.println();
            System.out.println("new loop " + current.getName());
            System.out.println();

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
                    System.out.println("added: "+cand.get(i).getName()+" to candidates");
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
        return rute;
    }
}
