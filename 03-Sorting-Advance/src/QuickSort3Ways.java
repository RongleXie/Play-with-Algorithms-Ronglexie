import java.util.Random;

/**
 * 三路快速排序
 *
 * 时间复杂度：O(nlogn)
 *
 * @author ronglexie
 * @version 2018/9/23
 */
public class QuickSort3Ways<T extends Comparable<T>> {

	/**
	 * 对数组中的元素进行三路快速排序
	 *
	 * @param array
	 * @return T[]
	 * @author ronglexie
	 * @version 2018/9/23
	 */
	public T[] quickSort3Ways(T[] array){
		return quickSort3Ways(array, 0, array.length - 1);
	}

	/**
	 * 对数组array[l...r]中的元素进行三路快速排序
	 * 将array[l...r]分为 <v ; ==v ; >v 三部分
	 * 然后递归对 <v , >v 两部分继续进行三路快速排序
	 *
	 * @param array
	 * @param l
	 * @param r
	 * @return T[]
	 * @author ronglexie
	 * @version 2018/9/23
	 */
	private T[] quickSort3Ways(T[] array, int l, int r) {
		if(l >=r){
			return array;
		}
		// 随机取一个值作为比较标准
		int randL = new Random().nextInt(r - l + 1) + l;
		swap(array, l, randL);
		// 将l位置的值作为比较标准
		T v = array[l];

		// array[l+1...lt] < v
		int lt = l;
		// array[gt...r] > v
		int gt = r + 1;
		// array[lt+1...i] < v
		int i = l + 1;
		while ( i < gt ){
			if( array[i].compareTo(v) < 0){
				swap(array, i, lt + 1);
				lt ++;
				i ++;
			} else if (array[i].compareTo(v) > 0) {
				swap(array, i, gt - 1);
				gt --;
			} else {
				i ++;
			}
		}
		swap(array, l, lt);
		quickSort3Ways(array, l, lt - 1);
		quickSort3Ways(array, gt, r);
		return array;
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
