/**
 * 图
 *
 * @author ronglexie
 * @version 2018/9/29
 */
public interface Graph {

	/**
	 * 获取图的节点数
	 *
	 * @param
	 * @return int
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	int V();

	/**
	 * 获取图的边数
	 *
	 * @param
	 * @return int
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	int E();

	/**
	 * 给两个节点间添加一条边
	 *
	 * @param v
	 * @param w
	 * @return void
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	void addEdge(int v , int w);

	/**
	 * 判断两个节点之间是否有边
	 *
	 * @param v
	 * @param w
	 * @return boolean
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	boolean hasEdge(int v, int w);

	/**
	 * 查找图中一个节点的所有邻边
	 *
	 * @param v
	 * @return java.lang.Iterable<java.lang.Integer>
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	Iterable<Integer> adj(int v);
	
	/**
	 * 打印图
	 *
	 * @param
	 * @return void
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	void show();
}
