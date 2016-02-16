import java.util.Arrays;

/**
 * Created 2/16/16
 *
 * @author Niels Norberg
 */
public class IntegerSorter {

    public static void sortAscending(int[] arrayToSort, int fromIndex, int toIndex) {
        int smallest;
        for (int i = 0; i < toIndex - fromIndex; i++) {
            smallest = smallestIndexIn(Arrays.copyOfRange(arrayToSort, i + fromIndex, toIndex));
            swap(arrayToSort, i + fromIndex, smallest + i + fromIndex);
        }
    }

    public static void sortDescending(int[] arrayToSort, int fromIndex, int toIndex) {
        int smallest;
        for (int i = 0; i < toIndex - fromIndex; i++) {
            smallest = smallestIndexIn(Arrays.copyOfRange(arrayToSort, fromIndex, toIndex - i));
            swap(arrayToSort, smallest + fromIndex, toIndex - i - 1);
        }
    }

    public static int smallestIndexIn(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        int smallestIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[smallestIndex]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(int[] array, int indexToSwap, int otherIndexToSwap) {
        int temp1 = array[indexToSwap];
        array[indexToSwap] = array[otherIndexToSwap];
        array[otherIndexToSwap] = temp1;
    }

}
