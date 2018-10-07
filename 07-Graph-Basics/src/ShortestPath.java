import java.util.*;

/**
 * 寻找无权图中两个节点的最短路径 广度优先遍历
 *
 * @author ronglexie
 * @version 2018/9/29
 */
public class ShortestPath {
	/** 图 */
	private Graph g;
	/** 是否被访问 */
	private boolean[] visited;
	/** 起点 */
	private int s;
	/** 上一个节点 */
	private int[] from;
	/** 最短距离 */
	private int[] ord;

	public ShortestPath(Graph graph, int s){
		g = graph;
		visited = new boolean[g.V()];
		from = new int[g.V()];
		ord = new int[g.V()];
		this.s = s;
		if(s < 0 || s >= g.V()){
			throw new IllegalArgumentException("Illegal arguments.");
		}

		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
			from[i] = -1;
			ord[i] = -1;
		}

		Queue<Integer> q = new LinkedList<>();
		//无向图最短路径算法 广度优先遍历
		((LinkedList<Integer>) q).push(s);
		visited[s] = true;
		ord[s] = 0;
		while (!q.isEmpty()){
			int v = ((LinkedList<Integer>) q).pop();
			for (int i : g.adj(v)) {
				if(!visited[i]){
					((LinkedList<Integer>) q).push(i);
					visited[i] = true;
					from[i] = v;
					ord[i] = ord[v] + 1;
				}
			}
		}
	}

	/**
	 * 判断s到某一个节点是否有路径
	 *
	 * @param w
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	public boolean hasPath(int w){
		if(w < 0 || w >= g.V()){
			throw new IllegalArgumentException("Illegal arguments.");
		}
		return visited[w];
	}

	/**
	 * 计算s到某一个节点的路径
	 *
	 * @param w
	 * @return java.util.Vector<java.lang.Integer>
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	public Vector<Integer> path(int w){
		if(!hasPath(w)){
			return null;
		}

		Vector<Integer> vector = new Vector<>();

		Stack<Integer> stack = new Stack<>();

		int p = w;
		while (p != -1){
			stack.push(p);
			p = from[p];
		}

		while (!stack.isEmpty()){
			vector.add(stack.pop());
		}

		return vector;
	}

	/**
	 * 打印s到某个节点的路径
	 *
	 * @param w
	 * @return void
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	public void showPath(int w){
		Vector<Integer> path = path(w);
		if (path == null || path.size() <= 0) {
			return;
		}
		for (int i = 0; i < path.size(); i++) {
			if(i != path.size() - 1){
				System.out.print(path.get(i) + "->");
			}else {
				System.out.println(path.get(i));
			}
		}
	}

	/**
	 * 查询s到某一个节点的最短距离
	 *
	 * @param w
	 * @return int
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	public int length(int w){
		if(w < 0 || w >= g.V()){
			throw new IllegalArgumentException("Illegal arguments.");
		}
		return ord[w];
	}
}
