/**
 * 归并排序
 * 自顶向下
 *
 * 时间复杂度：O(nlogn)
 *
 * 工作原理：采用分治法（Divide and Conquer）将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
 *
 * @author ronglexie
 * @version 2018/9/16
 */
public class MergeSortUB<T extends Comparable<T>> {

	/**
	 * 对数组中的元素进行归并排序
	 *
	 * @param array
	 * @return T[]
	 * @author ronglexie
	 * @version 2018/9/16
	 */
	public T[] mergeSort(T[] array){
		return mergeSort(array, 0, array.length - 1);
	}

	/**
	 * 递归使用归并排序对array[l...r]的范围进行排序
	 *
	 * @param array
	 * @param l
	 * @param r
	 * @return T[]
	 * @author ronglexie
	 * @version 2018/9/16
	 */
	private T[] mergeSort(T[] array, int l, int r){
		if (l >= r){
			return array;
		}

		int mid = (l + r) / 2;
		mergeSort(array, l, mid);
		mergeSort(array, mid + 1, r);
		merge(array, l, mid, r);
		return array;
	}

	/**
	 * 将array[l...mid]和array[mid+1...r]两部分进行归并
	 *
	 * @param array
	 * @param l
	 * @param mid
	 * @param r
	 * @return void
	 * @author ronglexie
	 * @version 2018/9/16
	 */
	private void merge(T[] array, int l, int mid, int r) {
		T[] aux = (T[]) new Comparable[r-l+1];
		for (int i = l; i <= r; i++) {
			aux[i-l] = array[i];
		}

		int i = l, j = mid + 1;
		for (int k = l; k <= r; k++) {

			if(i > mid){
				array[k] = aux[j-l];
				j ++;
			}else if(j > r){
				array[k] = aux[i-l];
				i ++;
			}else if(aux[i-l].compareTo(aux[j-l]) < 0){
				array[k] = aux[i-l];
				i ++;
			}else {
				array[k] = aux[j-l];
				j ++;
			}
		}
	}
}
