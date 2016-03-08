import java.io.File;
import java.util.Set;

/**
 *
 * @author erso
 */
public class UniqueWords
{

    private Set<String> wordSet;
    private File file;

    public UniqueWords(String fileName, boolean hash)
    {
        // Instantier file med fileName
        // Instantier wordSet til HashSet eller TreeSet afhaengig af hash
    }

    private void readFile()
    {
        // Benyt en Scanner til at laese filen ét ord ad gangen og
        // tilfoej hvert ord til wordSet.
        // Brug try-catch-finally til exception handling

    }

    public String toString()
    {
        return wordSet.toString() +"\nSize: " + wordSet.size();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Ben Pearce: se https://www.youtube.com/watch?v=AxLWre1TIQw.
        // true: HashSet, false: TreeSet
        UniqueWords uWords = new UniqueWords("Ben Pearce - What I Might Do.txt", false);
        
        uWords.readFile();
        
        System.out.println(uWords);
    }

}
