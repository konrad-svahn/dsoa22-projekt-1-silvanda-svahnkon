import java.util.ArrayList;

public class Node {
    
    private String name;
    private String key;
    private double latitude; 
    private double longitude;
    private ArrayList<Node> neighbours;
    
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
}
