
class SortingMethods {

    private static void swap(int[] array, int leftIndex, int rightIndex) {
        int tmp = array[rightIndex];
        array[rightIndex] = array[leftIndex];
        array[leftIndex] = tmp;
    }
// Сортировка пузырьком
// Принцип действий прост: обходим массив от начала до конца, попутно меняя местами неотсортированные соседние элементы.
// В результате первого прохода на последнее место «всплывёт» максимальный элемент. Теперь снова обходим
// неотсортированную часть массива (от первого элемента до предпоследнего) и меняем по пути неотсортированных соседей.
// Второй по величине элемент окажется на предпоследнем месте. Продолжая в том же духе, будем обходить всё уменьшающуюся
// неотсортированную часть массива, запихивая найденные максимумы в конец.
    static int[] bubbleSort(int[] num) {
        int[] sortedNum = num.clone();
        boolean needPermutation = true;
        int rightBorder = num.length - 1;
        while (needPermutation) {
            needPermutation = false;
            for (int i = 0; i < rightBorder; i++) {
                if (sortedNum[i] > sortedNum[i + 1]) {
                    swap(sortedNum, i, (i + 1));
                    needPermutation = true;
                }
            }
            rightBorder--;
        }
        return sortedNum;
    }
// Шейкерная сортировка (сортировка перемешиванием, коктейльная сортировка.)
// Начинается процесс как в «пузырьке»: выдавливаем максимум на самые задворки. После этого разворачиваемся
// и идём в обратную сторону, при этом уже перекатывая в начало не максимум, а минимум. Отсортировав в массиве
// первый и последний элементы, снова делаем кульбит. Обойдя туда-обратно несколько раз, в итоге заканчиваем процесс,
// оказавшись в середине списка.
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
// Сортировка расчёской. Основная идея «расчёски» в том, чтобы первоначально брать достаточно большое расстояние между
// сравниваемыми элементами и по мере упорядочивания массива сужать это расстояние вплоть до минимального. Таким
// образом мы как бы причёсываем массив, постепенно разглаживая на всё более аккуратные пряди. Первоначальный разрыв
// между сравниваемыми элементами лучше брать не абы какой, а с учётом специальной величины называемой фактором
// уменьшения, оптимальное значение которой равно примерно 1,247. Сначала расстояние между элементами равно размеру
// массива разделённого на фактор уменьшения (результат, естественно, округляется до ближайшего целого). Затем, пройдя
// массив с этим шагом, мы снова делим шаг на фактор уменьшения и проходим по списку вновь. Так продолжается до тех пор,
// пока разность индексов не достигнет единицы. В этом случае массив досортировывается обычным пузырьком.

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
// Сортировка выбором. Каждый проход выбирать самый минимальный элемент и смещать его в начало. При этом каждый новый
// проход начинать сдвигаясь вправо, то есть первый проход — с первого элемента, второй проход — со второго.
    static int[] selectionSort(int[] num){
        int[] sortedNum = num.clone();
        int lenght = num.length;
        for(int leftBorder = 0; leftBorder < lenght; leftBorder++ ){
            int minIndex = leftBorder;
            for (int i = leftBorder; i < lenght; i++){
                if (sortedNum[i] < sortedNum[minIndex]){
                    minIndex = i;
                }
            }
            swap(sortedNum, leftBorder, minIndex);
        }
    return sortedNum;
    }


}
