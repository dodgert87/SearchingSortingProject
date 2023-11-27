
import java.util.ArrayList;
import java.util.Random;

public class SortingPerformanceOption {
    private final int[] dataSetSizes = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
    long startTime;
    ArrayList<Long> runTimeResults = new ArrayList<>();
    long runTime;
    long comparisonCount;
    ArrayList<Long> comparisonCounts = new ArrayList<>();
    String[] algorithm = {"SelectionSort", "quickSort", "bubbleSort", "mergeSort", "insertionSort"};
    public SortingPerformanceOption() {
    }

    public void execute() {

        System.out.printf("%-40s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n", "     ", "1000", "2000", "3000", "4000", "5000", "6000", "7000", "8000", "9000");
        
        
        for (int i = 1; i <= 5 ; i++) {
            for (int size : dataSetSizes) {
                int[] array = generateRandomArray(size);
                switch (i) {
                    case 1:
                        startTime = System.nanoTime();
                        comparisonCount = SelectionSort(array.clone());
                        runTime = (System.nanoTime() - startTime) / 1000;
                        break;
                    case 2:
                        startTime = System.nanoTime();
                        comparisonCount = quickSort(array.clone());
                        runTime = (System.nanoTime() - startTime) / 1000;
                        break;
                    case 3:
                        startTime = System.nanoTime();
                        comparisonCount = bubbleSort(array.clone());
                        runTime = (System.nanoTime() - startTime) / 1000;
                        break;
                    case 4:
                        startTime = System.nanoTime();
                        comparisonCount = mergeSort(array.clone());
                        runTime = (System.nanoTime() - startTime) / 1000;
                        break;
                    case 5:
                        startTime = System.nanoTime();
                        comparisonCount = insertionSort(array.clone());
                        runTime = (System.nanoTime() - startTime) / 1000;
                        break;
                }
                runTimeResults.add(runTime);
                comparisonCounts.add(comparisonCount);
            }

            System.out.printf("%-40s%-15d%-15d%-15d%-15d%-15d%-15d%-15d%-15d%-15d%n", algorithm[i-1] + ",random,comparisons", comparisonCounts.get(0), comparisonCounts.get(1), comparisonCounts.get(2), comparisonCounts.get(3), comparisonCounts.get(4), comparisonCounts.get(5), comparisonCounts.get(6), comparisonCounts.get(7), comparisonCounts.get(8));
            System.out.printf("%-40s%-15d%-15d%-15d%-15d%-15d%-15d%-15d%-15d%-15d%n", algorithm[i-1] + ",random,nano", runTimeResults.get(0), runTimeResults.get(1), runTimeResults.get(2), runTimeResults.get(3), runTimeResults.get(4), runTimeResults.get(5), runTimeResults.get(6), runTimeResults.get(7), runTimeResults.get(8));

            runTimeResults = new ArrayList<>();
            comparisonCounts = new ArrayList<>();
        }
    }

    private int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }

        return array;
    }

    private long SelectionSort(int[] array) {
        SelectionSortOption selectionSortOption = new SelectionSortOption(array);
        return selectionSortOption.execute();
    }

    private long quickSort(int[] array) {
        QuickSortOption quickSortOption = new QuickSortOption(array);
        return quickSortOption.execute();
    }

    private long insertionSort(int[] array) {
        InsertionSortOption insertionSortOption = new InsertionSortOption(array);
        return insertionSortOption.execute();
    }

    private long bubbleSort(int[] array) {
        QuadraticSortOption quadraticSortOption = new QuadraticSortOption(array, false);
        return quadraticSortOption.execute();
    }

    private long mergeSort(int[] array) {
        NLogNSortOption nLogNSortOption = new NLogNSortOption(array, false);
        return nLogNSortOption.execute();
    }
}
