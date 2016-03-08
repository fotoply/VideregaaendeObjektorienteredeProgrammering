import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author erso
 */
public class ExtendedList extends LinkedList<String>
{

    // Opgave P14.1
    public void downsize(int n){
        ExtendedList newList = new ExtendedList();
        for (int i = 0; i < newList.size(); i++) {
            if (i%n != 0) {
                newList.add(this.get(i));
            }
        }
        this.clear();
        this.addAll(newList);
    }
    
    // Opgave P14.2
    public void reverse(){

    }
    
    // Ekstra Opgave: Recursiv udgave af P14.2
    public void reverseRecursive(){
   
    }
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ExtendedList list = new ExtendedList();
        for(int i = 0; i < 20; i++){
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
    
}
