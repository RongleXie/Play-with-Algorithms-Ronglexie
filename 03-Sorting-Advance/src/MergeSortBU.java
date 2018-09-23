/**
 * 归并排序
 * 自底向上
 *
 * 时间复杂度：O(nlogn)
 *
 * 工作原理：采用分治法（Divide and Conquer）将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
 *
 * @author ronglexie
 * @version 2018/9/16
 */
public class MergeSortBU<T extends Comparable<T>> {

	/**
	 * 对数组中的元素进行归并排序
	 *
	 * @param array
	 * @return T[]
	 * @author ronglexie
	 * @version 2018/9/16
	 */
	public T[] mergeSort(T[] array){
		for (int size = 1; size <= array.length; size += size) {
			for (int i = 0; i + size < array.length; i += size + size) {
				//对array[i...i+size-1]和array[i+size...i+2*size-1]进行归并
				merge(array, i, i + size - 1, Math.min(i + size + size - 1, array.length -1));
			}
		}
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
