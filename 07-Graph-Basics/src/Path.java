import java.util.Stack;
import java.util.Vector;

/**
 * 寻找图中两个节点路径 深度优先遍历
 *
 * @author ronglexie
 * @version 2018/9/29
 */
public class Path {
	/** 图 */
	private Graph g;
	/** 是否被访问 */
	private boolean[] visited;
	/** 起点 */
	private int s;
	/** 上一个节点 */
	private int[] from;

	public Path(Graph graph, int s){
		g = graph;
		visited = new boolean[g.V()];
		from = new int[g.V()];
		this.s = s;
		if(s < 0 || s >= g.V()){
			throw new IllegalArgumentException("Illegal arguments.");
		}

		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
			from[i] = -1;
		}

		//寻路算法
		dfs(s);

	}

	/**
	 * 深度优先遍历节点
	 *
	 * @param v
	 * @return void
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	private void dfs(int v) {
		visited[v] = true;
		for (int i : g.adj(v)) {
			if(!visited[i]){
				from[i] = v;
				dfs(i);
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
	 * 展示s到某个节点的路径
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
}
