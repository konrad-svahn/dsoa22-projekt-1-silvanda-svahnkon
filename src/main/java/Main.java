import java.util.LinkedHashMap;

/**
 * Projekt 1 - ruttsökning med A*
 *
 * Datastrukturer och algoritmer
 *
 * Programmeringsteam:
 *
 */
public class Main {

	public static void main(String[] args) {
		LinkedHashMap<String,Node> nodes = GraphData.createGraph();
		Print.listNodesAndLinks(nodes);
		
	}

}

