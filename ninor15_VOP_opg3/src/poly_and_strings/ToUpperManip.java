package poly_and_strings;

/**
 * Created 4/26/16
 *
 * @author Niels Norberg
 */
public class ToUpperManip extends AbstractManiplulable {

    public ToUpperManip(String originalString) {
        super(originalString);
    }

    @Override
    public String manip() { // Could also be implmented as "return originalString.toUpperCase()"
        char[] newStringAsArray = new char[originalString.length()];
        for (int i = 0; i < originalString.length(); i++) {
            char currentChar = originalString.charAt(i);
            newStringAsArray[i] = Character.toUpperCase(currentChar);
        }
        return newStringAsArray.toString();
    }
}
