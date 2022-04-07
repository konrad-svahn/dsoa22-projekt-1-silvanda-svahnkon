import java.util.ArrayList;
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
		String[] statAndStop = Print.userInput(nodes);
		ArrayList<Node> route = Utils.getRoute(nodes.get(statAndStop[0]), nodes.get(statAndStop[1]));
		Print.path(route);
	}
}

