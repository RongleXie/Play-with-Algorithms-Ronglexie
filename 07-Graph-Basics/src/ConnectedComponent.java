/**
 * 计算图的连通分量
 *
 * @author ronglexie
 * @version 2018/9/29
 */
public class ConnectedComponent {
	/** 图 */
	private Graph g;
	/** 是否被访问 */
	private boolean[] visited;
	/** 联通分量数量 */
	private int count;
	/** 节点对应联通分量标记 */
	private int[] id;

	public ConnectedComponent(Graph graph){
		g = graph;
		visited = new boolean[g.V()];
		id = new int[g.V()];
		count = 0;

		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
			id[i] = -1;
		}

		for (int i = 0; i < g.V(); i++) {
			if(!visited[i]){
				dfs(i);
				count ++;
			}
		}
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
		id[v] = count;
		for (int i : g.adj(v)) {
			if(!visited[i]){
				dfs(i);
			}
		}
	}

	/**
	 * 查找联通分量
	 *
	 * @param
	 * @return int
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	public int count(){
		return count;
	}

	/**
	 * 判断两个节点是否相连
	 *
	 * @param v
	 * @param w
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	public boolean isConnected(int v, int w){
		if(v < 0 || v >= g.V() || w < 0 || w >= g.V()){
			throw new IllegalArgumentException("Illegal arguments.");
		}
		return id[v] == id[w];
	}
}
