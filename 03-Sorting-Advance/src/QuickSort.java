import java.util.Random;

/**
 * 快速排序
 *
 * 时间复杂度：O(nlogn)
 *
 * @author ronglexie
 * @version 2018/9/23
 */
public class QuickSort<T extends Comparable<T>> {

	/**
	 * 对数组中的元素进行快速排序
	 *
	 * @param array
	 * @return T[]
	 * @author ronglexie
	 * @version 2018/9/23
	 */
	public T[] quickSort(T[] array){
		return quickSort(array, 0, array.length - 1);
	}

	/**
	 * 对数组array[l...r]中的元素进行快速排序
	 *
	 * @param array
	 * @param l
	 * @param r
	 * @return T[]
	 * @author ronglexie
	 * @version 2018/9/23
	 */
	private T[] quickSort(T[] array, int l, int r) {
		if(l >=r){
			return array;
		}
		int p = partition(array, l, r);
		quickSort(array, l, p - 1);
		quickSort(array, p + 1, r);
		return array;
	}

	/**
	 * 对数组array[l...r]中的元素进行partition操作
	 * 返回p,使得array[l...p-1] < array[p],array[p+1...r] > array[p]
	 *
	 * @param array
	 * @param l
	 * @param r
	 * @return int
	 * @author ronglexie
	 * @version 2018/9/23
	 */
	private int partition(T[] array, int l, int r) {
		// 随机取一个值作为比较标准
		int randL = new Random().nextInt(r - l + 1) + l;
		swap(array, l, randL);
		// 将l位置的值作为比较标准
		T v = array[l];
		// array[l...p-1] < v,array[p+1...r] > v
		int j = l;
		for (int i = l + 1; i <= r; i++) {
			if(array[i].compareTo(v) < 0){
				swap(array, j + 1 , i);
				j ++;
			}
		}
		swap(array, l , j);
		return j;
	}

	/**
	 * 交换数组中两个元素
	 *
	 * @param array
	 * @param x
	 * @param y
	 * @return void
	 * @author ronglexie
	 * @version 2018/9/23
	 */
	private void swap(T[] array, int x, int y) {
		T temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

}
