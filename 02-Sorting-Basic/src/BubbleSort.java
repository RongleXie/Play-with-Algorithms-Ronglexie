/**
 * 冒泡排序
 * <p>
 * 时间复杂度：O(n^2)
 * <p>
 * 工作原理：它重复地走访过要排序的元素列，依次比较两个相邻的元素，如果他们的顺序（如从大到小、首字母从A到Z）错误就把他们交换过来。走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素已经排序完成。
 * <p>
 * 给定一个N个元素的数组，冒泡法排序将：
 * <p>
 * 1、如果元素大小关系不正确，交换这两个数（在本例中为a> b），
 * 2、比较一对相邻元素（a，b），
 * 3、重复步骤1和2，直到我们到达数组的末尾（最后一对是第（N-2）和（N-1）项，因为我们的数组从零开始）
 * 4、到目前为止，最大的元素将在最后的位置。 然后我们将N减少1，并重复步骤1，直到N = 1。
 *
 * @author ronglexie
 * @version 2018/9/9
 */
public class BubbleSort<T extends Comparable<T>> {

	/**
	 * 对数组中的元素进行插入排序
	 * 交换赋值多次
	 *
	 * @param array
	 * @return T[]
	 * @author ronglexie
	 * @version 2018/9/9
	 */
	public T[] bubbleSort(T[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}
}
