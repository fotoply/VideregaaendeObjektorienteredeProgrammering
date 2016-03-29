/**
 * Class for reversing the order of a sentence.
 */
public class SentenceReverser {

    public static void main(String[] args) {
        String sentence = "Mary had a little lamb. Its fleece was white as snow.";
        SentenceReverser reverser = new SentenceReverser();
        String reversed = reverser.reverse(sentence);
        System.out.println("Given:    " + sentence);
        System.out.println("Expected: Lamb little a had mary. Snow as white was fleece its.");
        System.out.println("Actual:   " + reversed);
    }

    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return Reversed sentence.
     */
    public String reverse(String sentence) {
        String reversed = "";
        String[] sentences = sentence.split("\\.");
        for (String subSentence : sentences) {
            String[] words = subSentence.trim().split(" ");
            if (reversed.isEmpty()) {
                reversed = words[words.length - 1].substring(0, 1).toUpperCase() + words[words.length - 1].substring(1);
            } else {
                reversed += " " + words[words.length - 1].substring(0, 1).toUpperCase() + words[words.length - 1].substring(1);
            }

            for (int i = 1; i < words.length; i++) {
                reversed += " " + words[words.length - (i + 1)].toLowerCase();
            }
            reversed += ".";
        }
        return reversed;
    }
}
