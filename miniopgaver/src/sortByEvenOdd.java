import java.util.Arrays;

/**
 * Created 2/16/16
 *
 * @author Niels Norberg
 */
public class sortByEvenOdd {

    public static void main(String[] args) {
        int[] testData = {71, 1, 2, 68, 36, 59, 70, 22, 81, 89};
        sortByEvenOdd instance = new sortByEvenOdd();
        System.out.println(Arrays.toString(instance.evenOdd(testData)));
    }

    public int[] evenOdd(int [] array) {
        int minPos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                swap(array,minPos,i);
                minPos++;
            }
        }
        sort(array,minPos);
        return array;
    }

    private void sort(int [] array, int splitIndex) {
        int smallestIndex;
        for (int i = 0; i < array.length-splitIndex; i++) {
            smallestIndex = findSmallest(Arrays.copyOfRange(array,i,splitIndex));
            swap(array,smallestIndex+i,i);
        }

        for (int i = splitIndex; i < array.length; i++) {
            smallestIndex = findSmallest(Arrays.copyOfRange(array,i,array.length));
            swap(array,smallestIndex+i,i);
        }
    }

    private int findSmallest(int[] array) {
        int smallest = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                index = i;
            }
        }
        return index;
    }

    private void swap(int[] array, int indexToSwap, int otherIndexToSwap) {
        int temp1 = array[indexToSwap];
        array[indexToSwap] = array[otherIndexToSwap];
        array[otherIndexToSwap] = temp1;
    }

}
