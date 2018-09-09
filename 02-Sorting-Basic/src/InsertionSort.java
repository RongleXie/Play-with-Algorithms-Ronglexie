/**
 * 插入排序 Insertion Sort
 *
 * 时间复杂度：O(n^2)
 *
 * 工作原理：每步将一个待排序的记录，按其关键码值的大小插入前面已经排序的文件中适当位置上，直到全部插入完为止。
 *
 * 插入排序类似于大多数人安排扑克牌的方式。
 *
 * 1、从你手中的一张牌开始，
 * 2、选择下一张卡并将其插入正确的排序顺序，
 * 3、对所有卡重复上一步。
 *
 * @author ronglexie
 * @version 2018/9/9
 */
public class InsertionSort<T extends Comparable<T>> {

	/**
	 * 对数组中的元素进行插入排序
	 * 每次比较都进行元素交换、三次赋值操作
	 *
	 * @param array
	 * @return T[]
	 * @author ronglexie
	 * @version 2018/9/9
	 */
	public T[] insertionSort(T[] array){
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j > 0 && array[j].compareTo(array[j-1]) < 0 ; j--) {
				T temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
			}
		}
		return array;
	}

	/**
	 * 对数组中的元素进行插入排序
	 * 优化后
	 * 每次比较只进行元素赋值、一次赋值操作，最后一次进行元素交换
	 *
	 * @param array
	 * @return T[]
	 * @author ronglexie
	 * @version 2018/9/9
	 */
	public T[] insertionSortOptimization(T[] array){
		for (int i = 0; i < array.length; i++) {
			//寻找元素array[i]合适的插入位置
			T e = array[i];
			//保存元素array[i]应该插入的位置
			int j;
			for (j = i; j > 0 && e.compareTo(array[j-1]) < 0 ; j--) {
				array[j] = array[j-1];
			}
			array[j] = e;
		}
		return array;
	}
}
