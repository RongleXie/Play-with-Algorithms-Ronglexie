import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author ronglexie
 * @version 2018/9/29
 */
public class ReadGraph {

	/**
	 * 读取默认图
	 *
	 * @param
	 * @return Graph
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	public static Graph readGraph(){
		Graph graph = null;
		String filePath = "D:\\iProgramming\\Projects\\IntelliJ IDEA\\Play-with-Algorithms-Ronglexie\\07-Graph-Basics\\testG2.txt";
		StringBuilder content = new StringBuilder("");
		try {
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineText = bufferedReader.readLine();
				Integer n = Integer.valueOf(lineText.split(" ")[0]);
				Integer m = Integer.valueOf(lineText.split(" ")[1]);
				if(n != null && m != null){
					graph = new DenseGraph(n,false);
				}
				for (int i = 0; i < m; i++) {
					String lineTextM = bufferedReader.readLine();
					Integer vi = Integer.valueOf(lineTextM.split(" ")[0]);
					Integer wi = Integer.valueOf(lineTextM.split(" ")[1]);
					if(vi != null && wi != null){
						graph.addEdge(vi, wi);
					}
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		}catch (Exception e){

		}
		return graph;
	}

	/**
	 * 通过文件读取图
	 *
	 * @param filePath
	 * @return Graph
	 * @author ronglexie
	 * @version 2018/9/29
	 */
	public static Graph readGraphByFilePath(String filePath){
		Graph graph = null;
		StringBuilder content = new StringBuilder("");
		try {
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineText = bufferedReader.readLine();
				Integer n = Integer.valueOf(lineText.split(" ")[0]);
				Integer m = Integer.valueOf(lineText.split(" ")[1]);
				if(n != null && m != null){
					graph = new DenseGraph(n,false);
				}
				for (int i = 0; i < m; i++) {
					String lineTextM = bufferedReader.readLine();
					Integer vi = Integer.valueOf(lineTextM.split(" ")[0]);
					Integer wi = Integer.valueOf(lineTextM.split(" ")[1]);
					if(vi != null && wi != null){
						graph.addEdge(vi, wi);
					}
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		}catch (Exception e){

		}
		return graph;
	}

	public static void main(String[] args) {
		Graph graph = ReadGraph.readGraph();
		graph.show();
	}
}
