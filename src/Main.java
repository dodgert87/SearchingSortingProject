import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dataSet = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] randomArray;
        int target;


        while (true) {
            System.out.println("Menu of Searching and Sorting Testbed\n");
            System.out.println("1) Linear searching");
            System.out.println("2) Binary searching");
            System.out.println("3) O(n^2) type of sorting");
            System.out.println("4) O(n*log(n)) type of sorting");
            System.out.println("5) Sorting performance");
            System.out.println("\nq/Q) Quit\n");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            System.out.println("\nYour choice: " + choice + "\n");
            switch (choice.toLowerCase()) {
                case "1":
                    System.out.print("In the list are values0, ..., 9; Which value would you like to search with binary search? ");
                    target = scanner.nextInt();
                    scanner.nextLine();
                    LinearSearchOption linearSearchOption = new LinearSearchOption(dataSet, target, true);
                    linearSearchOption.execute();
                    break;
                case "2":
                    System.out.print("In the list are values0, ..., 9; Which value would you like to search with binary search? ");
                    target = scanner.nextInt();
                    scanner.nextLine();
                    BinarySearchOption binarySearchOption = new BinarySearchOption(dataSet, target,true);
                    binarySearchOption.execute();
                    break;
                case "3":
                    randomArray = generateRandomArray(10);
                    QuadraticSortOption quadraticSortOption = new QuadraticSortOption(randomArray, true);
                    quadraticSortOption.execute();
                    break;
                case "4":
                    randomArray = generateRandomArray(10);
                    NLogNSortOption nLogNSortOption = new NLogNSortOption(randomArray, true);
                    nLogNSortOption.execute();
                    break;
                case "5":
                    SortingPerformanceOption sortingPerformanceOption = new SortingPerformanceOption();
                    sortingPerformanceOption.execute();
                    break;
                case "q":
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
            System.out.println();
        }
    }
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }

        return array;
    }
}

