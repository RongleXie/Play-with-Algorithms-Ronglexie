/**
 * 堆排序
 *
 * @author ronglexie
 * @version 2018/9/24
 */
public class HeapSort<T extends Comparable<T>> {

	/**
	 * 对数组中的元素进行堆排序
	 *
	 * @param array
	 * @return T[]
	 * @author ronglexie
	 * @version 2018/9/24
	 */
	public T[] heapSort(T[] array){
		MaxHeap maxHeap = new MaxHeap(array);
		for (int i = array.length - 1; i >= 0; i -- ) {
			array[i] = (T)maxHeap.extractMax();
		}
		return array;
	}
}
