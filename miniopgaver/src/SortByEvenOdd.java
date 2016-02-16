import java.util.Arrays;
import java.util.Random;

/**
 * Created 2/16/16
 *
 * @author Niels Norberg
 */
public class SortByEvenOdd {

    public static void main(String[] args) {
        /*int[] testData = {71, 1, 2, 68, 36, 59, 70, 22, 81, 89};
        SortByEvenOdd instance = new SortByEvenOdd();
        System.out.println(Arrays.toString(instance.evenOdd(testData)));*/

        Random generator = new Random(222);
        int array[] = new int [10];
        for(int i = 0; i < array.length; i++){
            array[i] = generator.nextInt(100);
        }
        System.out.println("Input:"+Arrays.toString(array));

        SortByEvenOdd arrMani = new SortByEvenOdd();
        int result[] = arrMani.evenOdd(array);
        System.out.println("Output: " +Arrays.toString(result));
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

        for (int i = 0; i < array.length-splitIndex; i++) {
            smallestIndex = findSmallest(Arrays.copyOfRange(array,splitIndex,array.length-i));
            swap(array,smallestIndex+splitIndex,array.length-i-1);
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
