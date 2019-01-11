import java.util.Arrays;

public class SortingMethods {
    private static void swap(int [] array, int leftIndex, int rightIndex){
        int tmp = array [rightIndex];
        array[rightIndex] = array[leftIndex];
        array[leftIndex] = tmp;
    }

    private static int [] bubbleSort(int [] num){
        int [] sortedNum = num.clone();
        boolean isPermutation = true;
        int temp;
        while (isPermutation){
            isPermutation = false;
            for (int i = 0; i < num.length - 1; i++){
                if (sortedNum[i] > sortedNum[i + 1]) {
                    swap(sortedNum, i, (i + 1));
                    isPermutation = true;
                }
                }
            }
        return sortedNum;
    }

    public static void main(String[] args) {
        int [] num = {1, 2, 5, 0, 10, 200, 3};
        int sortedNum[] =  bubbleSort(num);
        String sortedArrayString = Arrays.toString(sortedNum);
        System.out.println(sortedArrayString);
    }
}
