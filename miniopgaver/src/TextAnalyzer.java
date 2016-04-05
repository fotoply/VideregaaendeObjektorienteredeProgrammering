//package exercise_text_analyser;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TextAnalyzer {

	private File file;

	public TextAnalyzer(String fileName) {
		file = new File(fileName);
	}

	// Opgave 1       Dette er faktisk P15.1 fra BigJava.
	// Parameteren sorted afg�r om der skal benyttes et sorteret Set
	//
	public Set<String> findUniqueWords(boolean sorted) throws FileNotFoundException {
		final Set<String> set;
		if (sorted) {
			set = new TreeSet<>();
		} else {
			set = new HashSet<>();
		}

        for(String word : getText()) {
            word = clean(word);
            if(!word.equals("")) {
                set.add(word);
            }
        }
		// genneml�s filen et ord ad gangen
		// kald clean() metoden p� hvert ord
		// og tilf�j ordet til settet.

		return set;
	}

    private ArrayList<String> getText() throws FileNotFoundException {
        ArrayList<String> text = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            Collections.addAll(text, scanner.nextLine().split(" "));
        }
        return text;
    }

    // Opgave 2:   Udvidelse af P15.1
	//
	public Map<String, Integer> countWords(boolean sorted) throws FileNotFoundException {
		final Map<String, Integer> map;
		if (sorted) {
			map = new TreeMap<>();
		} else {
			map = new HashMap<>();
		}
        for(String word : getText()) {
            word = clean(word);
            if(word.equals("")) {
                continue;
            }
            if(map.containsKey(word)) {
                map.put(word,map.get(word)+1);
            } else {
                map.put(word,1);
            }
        }
		// genneml�s filen et ord ad gangen
		// kald clean() metoden p� hvert ord
		// benyt mappen til at t�lle hver forekomst hvert ord

		return map;
	}

	// Opgave 3:     Udvidelse af P15.1
	//
	public Map<Integer, Set<String>> lengtOfWords(boolean sorted) throws FileNotFoundException {
		Map<Integer, Set<String>> mapOfSets = null;
		if (sorted) {
			mapOfSets = new TreeMap<>();
		} else {
			mapOfSets = new HashMap<>();
		}
        for (String word : getText()) {
            word = clean(word);
            if(word.equals("")) {
                continue;
            }
            if(!mapOfSets.containsKey(word.length())) {
                TreeSet<String> set = new TreeSet<>();
                set.add(word);
                mapOfSets.put(word.length(),set);
            } else {
                mapOfSets.get(word.length()).add(word);
            }
        }
		// genneml�s filen et ord ad gangen
		// kald clean() metoden p� hvert ord
		// Inds�t hvert ord i det Set<String> som er v�rdi til ordl�ngden som key
		// Hint: nyt Set<String> skal oprettes hver gang en l�ngde opdages f�rste gang.


		return mapOfSets;

	}

	// Denne metode fors�ger at fjerne alt 'snavs' fra en String,
	// s� kun bogstaver bevares og store g�res til sm�
	private String clean(String s) {
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				r = r + c;
			}
		}
		return r.toLowerCase();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {

		TextAnalyzer ta = new TextAnalyzer("alice30.txt");

		// Opgave 1. Find alle unikke ord i filen
		Set<String> set = ta.findUniqueWords(true);
		System.out.println(set);
		System.out.println("Number of unique words: " + set.size());

		System.out.println("\n------------------------------------------------------------------\n");

		// Opgave 2. T�l forekomster af ord
		Map<String, Integer> map = ta.countWords(true);
		System.out.println(map);
//
		System.out.println("\n------------------------------------------------------------------\n");

		// Opgave 3. Benyt en mappe til at gruppere ord efter l�ngde
		Map<Integer, Set<String>> map2 = ta.lengtOfWords(true);
		System.out.println(map2);

	}

}
