import java.util.Arrays;


public class BinarySearchOption {
    private final int[] dataSet;
    private final int target;
    private final boolean display;
    public BinarySearchOption(int[] dataSet, int target, boolean display) {
        this.dataSet = dataSet;
        this.target = target;
        this.display = display;
    }

    public void execute() {

        // Binary search requires a sorted array, so we sort the dataset first
        Arrays.sort(dataSet);


        int index = binarySearch(dataSet, target);
        if (display) {
            if (index == -1) {
                System.out.println("\nNot found");
            } else {
                System.out.println("\nFound");
            }
        }
    }

    private int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
