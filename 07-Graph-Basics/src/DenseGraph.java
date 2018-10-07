import java.util.Vector;

/**
 * 稠密图-邻接矩阵
 *
 * @author ronglexie
 * @version 2018/9/29
 */
public class DenseGraph implements Graph{
	/** 节点数*/
	private int n;
	/** 边数*/
	private int m;
	/** 是否是有向图*/
	private boolean directed;
	/** 邻接矩阵*/
	private boolean[][] g;

	public DenseGraph(int n, boolean directed){
		this.n = n;
		this.m = 0;
		this.directed = directed;
		g = new boolean[n][n];
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

		g[v][w] = true;
		if(!directed){
			g[w][v] = true;
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
		return g[v][w];
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
		Vector<Integer> adjV = new Vector<Integer>();
		for(int i = 0 ; i < n ; i ++ ){
			if( g[v][i] ){
				adjV.add(i);
			}
		}
		return adjV;
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
//		System.out.print("  vertex  ");
//		for (int i = 0; i < n; i++) {
//			System.out.print(" " + i + " " );
//		}
//		System.out.println();

		for (int i = 0; i < n; i++) {
//			System.out.print("vertex " + i + "   " );
			for (int j = 0; j < n; j++) {
				System.out.print((g[i][j] == true ? 1 : 0) + "  ");
			}
			System.out.println();
		}
	}

}
