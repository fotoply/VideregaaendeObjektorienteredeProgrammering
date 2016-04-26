package poly_and_strings;

/**
 * Created 4/26/16
 *
 * @author Niels Norberg
 */
public class ToLowerManip extends AbstractManiplulable {

    public ToLowerManip(String originalString) {
        super(originalString);
    }

    @Override
    public String manip() { // Could also be implmented as "return originalString.toLowerCase()"
        char[] newStringAsArray = new char[originalString.length()];
        for (int i = 0; i < originalString.length(); i++) {
            char currentChar = originalString.charAt(i);
            newStringAsArray[i] = Character.toLowerCase(currentChar);
        }
        return newStringAsArray.toString();
    }
}
