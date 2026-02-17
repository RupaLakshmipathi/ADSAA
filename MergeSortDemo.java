public class MergeSortDemo {
	static int[] a;   // original array
	static int[] b;   // auxiliary array

    	// Merge two sorted subarrays a[low..mid] and a[mid+1..high]
    	static void merge(int low, int mid, int high) {
        		int i = low;         // index for left subarray
        		int j = mid + 1;   // index for right subarray
        		int k = low;       // index for auxiliary array

        		// Merge elements into auxiliary array, as long as elements are there in both subarrays
        		while (i <= mid && j <= high) {
            			if (a[i] <= a[j]) {
                				b[k++] = a[i++];
            			} else {
                				b[k++] = a[j++];
            			}
        		}

        		// Copy remaining elements of left subarray
        		while (i <= mid) {
            			b[k++] = a[i++];
        		}

        		// Copy remaining elements of right subarray
        		while (j <= high) {
            			b[k++] = a[j++];
        		}

        		// Copy back from auxiliary array to original array
        		for (i = low; i <= high; i++) {
            			a[i] = b[i];
        		}
    	}

    	// Recursive merge sort
    	static void mergeSort(int low, int high) {
        		if (low < high) {
	            		int mid = (low + high) / 2;

            			mergeSort(low, mid);
            			mergeSort(mid + 1, high);
            			merge(low, mid, high);
        		}
    	}

    	public static void main(String[] args) {
        		a = new int[]{38, 27, 43, 3, 9, 82, 10};
        		b = new int[a.length];

        		System.out.println("Before sorting:");
        		for (int x : a) {
            			System.out.print(x + " ");
        		}

        		mergeSort(0, a.length - 1);

        		System.out.println("\nAfter sorting:");
        		for (int x : a) {
            			System.out.print(x + " ");
        		}
    	}
}
