public class InsertionSortOption {
    private final int[] dataSet;
    private int comparisonCount;

    public InsertionSortOption(int[] dataSet) {
        this.dataSet = dataSet;
        this.comparisonCount = 0;
    }

    public int execute() {
        insertionSort(dataSet);
       return  comparisonCount;
    }

    private void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;


            while (j >= 0 && array[j] > key) {
                comparisonCount++;
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }
}
