
class SortingMethods {

    private static void swap(int[] array, int leftIndex, int rightIndex) {
        int tmp = array[rightIndex];
        array[rightIndex] = array[leftIndex];
        array[leftIndex] = tmp;
    }

    static int[] bubbleSort(int[] num) {
        int[] sortedNum = num.clone();
        boolean needPermutation = true;
        while (needPermutation) {
            needPermutation = false;
            for (int i = 0; i < num.length - 1; i++) {
                if (sortedNum[i] > sortedNum[i + 1]) {
                    swap(sortedNum, i, (i + 1));
                    needPermutation = true;
                }
            }
        }
        return sortedNum;
    }

    static int[] shakerSort(int[] num) {
        int[] sortedNum = num.clone();
        boolean needPermutation;
        int leftBorder = 0;
        int rightBorder = num.length - 1;
        do {
            needPermutation = false;
            for (int i = leftBorder; i < rightBorder; i++) {
                if (sortedNum[i] > sortedNum[i + 1]) {
                    swap(sortedNum, i, (i + 1));

                    needPermutation = true;
                }
            }
            rightBorder--;
            for (int i = rightBorder; i > leftBorder; i--) {
                if (sortedNum[i] < sortedNum[i - 1]) {
                    swap(sortedNum, (i - 1), i);

                    needPermutation = true;
                }
            }
            leftBorder++;

        } while (needPermutation && (leftBorder < rightBorder));


        return sortedNum;
    }

    static int[] combSort(int[] num) {
        int[] sortedNum = num.clone();
        double k = 1.2473309;
        int arrayLenght = sortedNum.length;
        int step = arrayLenght - 1;
        while (step > 1) {
            for (int i = 1; (i + step) < arrayLenght - 1; i++) {
                if (sortedNum[i] > sortedNum[i + step]) {
                    swap(sortedNum, i, (i + step));
                }
            }
            step /= k;
        }
        return bubbleSort(sortedNum);


    }

}
