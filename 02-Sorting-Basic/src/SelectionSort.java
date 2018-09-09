/**
 * 选择排序 Selection Sort
 *
 * 时间复杂度：O(n^2)
 *
 * 工作原理: 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。选择排序是不稳定的排序方法。
 *
 * 给定N个项目的数组且L = 0，选择排序将：
 *
 * 1、找到[ L ... N -1] 范围内最小项的位置X，
 * 2、用第L项交换第X个项目，
 * 3、将下限L增加1并重复步骤1直到L = N -2。
 *
 * @author ronglexie
 * @version 2018/9/9
 */
public class SelectionSort<T extends Comparable<T>> {

	/**
	 * 对数组中的元素进行选择排序
	 *
	 * @param array
	 * @return T[]
	 * @author ronglexie
	 * @version 2018/9/9
	 */
	public T[] selectionSort(T[] array){
		for (int i = 0; i < array.length; i++) {

			//寻找[i,n]区间里的最小值
			int minIndex = i;
			for (int j = i+1; j < array.length; j++) {
				if(array[minIndex].compareTo(array[j]) > 0){
					minIndex = j;
				}
			}
			T temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
		return array;
	}
}
