

public class LinearSearchOption {

    private final int[] dataSet;
    private final int target;
    private  final boolean display;


    public LinearSearchOption(int[] dataSet, int target, boolean display) {
        this.dataSet = dataSet;
        this.target = target;
        this.display = display;
    }

    public void execute() {

        int index = linearSearch(dataSet, target);

        if (display) {
            if (index == -1) {
                System.out.println("\nNot found");
            } else {
                System.out.println("\nFound");
            }
        }
    }

    private int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
