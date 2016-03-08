import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author erso
 */
public class UniqueWords {

    private Set<String> wordSet;
    private File file;

    public UniqueWords(String fileName, boolean hash) {
        file = new File(fileName);
        if (hash) {
            wordSet = new HashSet<>();
        } else {
            wordSet = new TreeSet<>();
        }
        // Instantier file med fileName
        // Instantier wordSet til HashSet eller TreeSet afhaengig af hash
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ben Pearce: se https://www.youtube.com/watch?v=AxLWre1TIQw.
        // true: HashSet, false: TreeSet
        UniqueWords uWords = new UniqueWords("lyrics.txt", false);

        uWords.readFile();

        System.out.println(uWords);
    }

    private void readFile() {
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNext()) {
                String next = reader.next();
                next = next.replaceAll(",", "");
                if (!next.isEmpty()) {
                    wordSet.add(next);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return wordSet.toString() + "\nSize: " + wordSet.size();
    }

}
