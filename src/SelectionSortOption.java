public class SelectionSortOption {
    private final int[] dataSet;
    private long comparisonCount;

    public SelectionSortOption(int[] dataSet) {
        this.dataSet = dataSet;
        this.comparisonCount = 0;
    }

    public long execute() {
        selectionSort(dataSet);
        return comparisonCount;

    }

    private void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                // Increment the comparison count for each comparison
                comparisonCount++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the element at index i
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
