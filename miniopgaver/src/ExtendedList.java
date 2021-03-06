import java.util.Collections;
import java.util.LinkedList;

/**
 * @author erso
 */
public class ExtendedList extends LinkedList<String> {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExtendedList list = new ExtendedList();
        for (int i = 0; i < 20; i++) {
            list.add("Element " + i);
        }
        System.out.println("Before:\n" + list.toString());
        list.downsize(3);
        System.out.println("Downsized:\n" + list.toString());

        list.reverse();
        System.out.println("Reversed:\n" + list.toString());

//       list.reverseRecursive();
//        System.out.println("Reversed Recurcively:\n" + list.toString());
    }

    // Opgave P14.1
    public void downsize(int n) {
        ExtendedList newList = new ExtendedList();
        for (int i = 0; i < this.size(); i++) {
            if (i % n != 0) {
                newList.add(this.get(i));
            }
        }
        this.clear();
        this.addAll(newList);
    }

    // Opgave P14.2
    public void reverse() {
        for (int i = 0, j = this.size() - 1; i < j; i++, j--) {
            Collections.swap(this, i, j);
        }
    }

    // Ekstra Opgave: Recursiv udgave af P14.2
    public void reverseRecursive() {

    }

}
