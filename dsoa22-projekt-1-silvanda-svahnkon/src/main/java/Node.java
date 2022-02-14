import java.util.ArrayList;

public class Node {
    
    private String name;
    private String key;
    private double latitude; 
    private double longitude;
    private ArrayList<Node> neighbours;
    private Node previous; 
    
    public Node(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.neighbours = new ArrayList<Node>();
    }

    
    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    public void addNeighbor(Node neighbour) {
        this.neighbours.add(neighbour);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getLatitude() {
        return latitude;
    }
    
    public double getLongitude() {
        return longitude;
    }

    public double getF(double G, double H){     // Lägger ihop G+H för att få veta den kortaste rutten
        return G+H;
    }

    public double calculateH(Node endNode){     //räknar Heuristic distance, den raka längden från noden till mål noden 
       double heuristicDistance = Utils.getDistance(this.latitude,this.longitude,endNode.getLatitude(),endNode.getLongitude() );
        return heuristicDistance;
    }
    public double calculateG(Node startNode){    // räknar Längen till startnoden
        double G = 0;
        //Node current = this.Node; 
        
        
        return G;
/*
  · Skapa en Node-variabel current och sätt till innevarande objekt av Node (this)   

    Loopa (så länge som current inte är samma som startNode) {
        · Beräkna avståndet från current till föregående nod (current.previous).
        · Addera avståndet till G.
        · Sätt current att vara samma som current.previous.
    }
    returnera G
    beräkna och returnera G-värdet dvs. i detta fall den verkliga distansen från startnoden startNode till
    innevarande nod via alla eventuella mellannoder. 
    Definiera i detta skede även en instansmetod getF som returnerar F-värdet, dvs. G + H.
    Observera att denna metod inte kan göra sitt jobb på riktigt innan den används i själva algoritmen och noderna får riktiga värden för previous.*/
    }

}
