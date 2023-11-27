public class QuadraticSortOption {
    private final int[] dataSet;
    private final boolean display;
    private long comparisonCount;

    public QuadraticSortOption(int[] dataSet, boolean display) {
        this.dataSet = dataSet;
        this.display = display;
        this.comparisonCount = 0;
    }

    public long execute() {

        // Display original data
        if (display) {
            System.out.println("Data set before bubble sorting:");
            displayData();
        }

        // Perform bubble sort
        bubbleSort(dataSet);

        // Display sorted data
        if (display) {
            System.out.println("\nData set after bubble sorting:");
            displayData();
        }

       return comparisonCount;
    }

    private void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Increment the comparison count for each comparison
                comparisonCount++;
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private void displayData() {
        for (int value : dataSet) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
