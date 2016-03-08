import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

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
        file = new File(fileName);
        if(hash) {
            wordSet = new HashSet<>();
        } else {
            wordSet = new TreeSet<>();
        }
        // Instantier file med fileName
        // Instantier wordSet til HashSet eller TreeSet afhaengig af hash
    }

    private void readFile()
    {
        try {
            Scanner reader = new Scanner(new BufferedReader(new FileReader(file)));
            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(" ");
                for (String word: line) {
                    wordSet.add(word);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
