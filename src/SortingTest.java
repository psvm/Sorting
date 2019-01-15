import java.util.Arrays;

public class SortingTest {
    public static void main(String[] args) {
        int[] num = {1, 2, 5,  10, 200, 100, 5, 3};
        System.out.println( "Shaker Sorting: " + Arrays.toString(SortingMethods.shakerSort(num)));
        System.out.println( "Bubble Sorting: " + Arrays.toString(SortingMethods.bubbleSort(num)));
        System.out.println( "Comb Sorting:   " + Arrays.toString(SortingMethods.combSort(num)));


    }
}
