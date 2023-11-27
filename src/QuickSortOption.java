public class QuickSortOption {
    private final int[] dataSet;
    private long comparisonCount;

    public QuickSortOption(int[] dataSet) {
        this.dataSet = dataSet;
        this.comparisonCount = 0;
    }

    public long execute() {
        quickSort(dataSet, 0, dataSet.length - 1);
        return comparisonCount;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);

            // Recursively sort the elements before and after the partition index
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Increment the comparison count for each comparison
            comparisonCount++;
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
