/**
 * @author ronglexie
 * @version 2018/9/29
 */
public class Main {
	public static void main(String[] args) {
		Graph graph = ReadGraph.readGraphByFilePath("07-Graph-Basics/testG1.txt");
		graph.show();
		ConnectedComponent component = new ConnectedComponent(graph);
		System.out.println("testG1: Connected Component: " + component.count());
		Path path = new Path(graph, 0);
		System.out.print("DFS: ");
		path.showPath(6);
		ShortestPath shortestPath = new ShortestPath(graph, 0);
		System.out.print("BFS: ");
		shortestPath.showPath(6);

		Graph graph2 = ReadGraph.readGraphByFilePath("07-Graph-Basics/testG2.txt");
		graph2.show();
		ConnectedComponent component2 = new ConnectedComponent(graph2);
		System.out.println("testG2: Connected Component: " + component2.count());
	}
}
