import java.util.Vector;

/**
 * 稀疏图-邻接表
 *
 * @author ronglexie
 * @version 2018/9/29
 */
public class SparseGraph implements Graph{
	/** 节点数*/
	private int n;
	/** 边数*/
	private int m;
	/** 是否是有向图*/
	private boolean directed;
	/** 邻接表*/
	private Vector<Integer>[] g;

	public SparseGraph(int n, boolean directed){
		this.n = n;
		this.m = 0;
		this.directed = directed;
		// g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
		g = (Vector<Integer>[])new Vector[n];
		for(int i = 0 ; i < n ; i ++){
			g[i] = new Vector<Integer>();
		}
	}

	/**
	 * 获取图的节点数
	 *
	 * @param
	 * @return int
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	@Override
	public int V(){
		return n;
	}

	/**
	 * 获取图的边数
	 *
	 * @param
	 * @return int
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	@Override
	public int E(){
		return m;
	}

	/**
	 * 给两个节点间添加一条边
	 *
	 * @param v
	 * @param w
	 * @return void
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	@Override
	public void addEdge(int v , int w){
		if(v < 0 || v >= n || w < 0 || w >= n){
			throw new IllegalArgumentException("Illegal arguments.");
		}

		if(hasEdge(v, w)){
			return;
		}

		g[v].add(w);
		if(v != w && !directed){
			g[w].add(v);
		}

		m ++;

	}

	/**
	 * 判断两个节点之间是否有边
	 *
	 * @param v
	 * @param w
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	@Override
	public boolean hasEdge(int v, int w){
		if(v < 0 || v >= n || w < 0 || w >= n){
			throw new IllegalArgumentException("Illegal arguments.");
		}
		Vector<Integer> integers = g[v];

		for (int i = 0; i < g[v].size(); i++) {
			if(g[v].get(i) == w){
				return true;
			}
		}
		return false;
	}

	/**
	 * 查找图中一个节点的所有邻边
	 *
	 * @param v
	 * @return java.lang.Iterable<java.lang.Integer>
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	@Override
	public Iterable<Integer> adj(int v) {
		if(v < 0 || v >= n){
			throw new IllegalArgumentException("Illegal arguments.");
		}
		return g[v];
	}

	/**
	 * 打印图
	 *
	 * @param
	 * @return void
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	@Override
	public void show() {
		for (int i = 0; i < n; i++) {
			System.out.print("vertex " + i + ":  " );
			for (int j = 0; j < g[i].size(); j++) {
				System.out.print(g[i].get(j) + "  ");
			}
			System.out.println();
		}
	}
}
