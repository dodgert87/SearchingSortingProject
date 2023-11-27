public class NLogNSortOption {
    private final int[] dataSet;
    private final boolean display;
    private long comparisonCount;

    public NLogNSortOption(int[] dataSet, boolean display) {
        this.dataSet = dataSet;
        this.display = display;
        this.comparisonCount = 0;
    }

    public long execute() {

        // Display original data
        if (display) {
            System.out.println("Data set before merge sorting:");
            displayData();
        }

        // Perform merge sort
        mergeSort(dataSet, 0, dataSet.length - 1);

        // Display sorted data
        if (display) {
            System.out.println("\nData set after merge sorting:");
            displayData();
        }
        return  comparisonCount;

    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Recursively sort the first and second halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = array[mid + 1 + j];

        // Merge the temporary arrays

        // Initial indexes of the first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of the merged subarray
        int k = left;
        while (i < n1 && j < n2) {
            // Increment the comparison count for each comparison
            comparisonCount++;
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void displayData() {
        for (int value : dataSet) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
